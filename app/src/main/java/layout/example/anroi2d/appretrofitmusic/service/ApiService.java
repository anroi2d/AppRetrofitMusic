package layout.example.anroi2d.appretrofitmusic.service;

public class ApiService {

    private static String base_url = "https://lecongan92.000webhostapp.com/Server/";

    public static DataService getService(){
        return ApiRetrofitClient.getClient(base_url).create(DataService.class);
    }
}
