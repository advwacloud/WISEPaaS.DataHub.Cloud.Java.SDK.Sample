package main;

import static spark.Spark.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import model.DatastoreOptions;
import model.Tag;
import model.TagValue;
import scada.Datastore;
import model.RealDataRequest;
import model.HistRawDataRequest;
import model.HistRawTagValue;

// test example
// start 2020-01-01T01:01:00.00Z
// end 2020-02-10T01:01:00.00Z
// tags e39e619a-c5d2-4d0d-9a7c-7848d27b69d7/Device1/ATag

public class Server {
	static String realDataController(Datastore datastore, RealDataRequest dataReq) {
		ArrayList<TagValue> resp = datastore.GetRealData(dataReq);

		String result = new Gson().toJson(resp);
		return result;
	}

	static String histRawDataController(Datastore datastore, HistRawDataRequest dataReq) {
		ArrayList<HistRawTagValue> resp = datastore.GetHistRawData(dataReq);

		String result = new Gson().toJson(resp);
		return result;
	}

	public static void main(String[] arg) {
		DatastoreOptions options = new DatastoreOptions();
		options.url = "127.0.0.1:50051";
		Datastore datastore = new Datastore(options);

		post("/api/RealData/raw", (request, response) -> {

			Type listType = new TypeToken<ArrayList<Tag>>() {
			}.getType();
			ArrayList<Tag> jsonArr = new Gson().fromJson(request.body(), listType);

			RealDataRequest dataReq = new RealDataRequest();
			dataReq.tags = jsonArr;

			response.type("application/json");

			String result = realDataController(datastore, dataReq);
			return result;
		});

		post("/api/HistData/raw", (request, response) -> {
			HistRawDataRequest dataReq = new Gson().fromJson(request.body(), HistRawDataRequest.class);

			response.type("application/json");

			String result = histRawDataController(datastore, dataReq);
			return result;
		});
	}
}