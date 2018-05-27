package diellza.touristguide.Fragments;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import diellza.touristguide.Activities.MainActivity;
import diellza.touristguide.Adapters.CategoryRecyclerViewAdapter;
import diellza.touristguide.Adapters.MonumentRecyclerViewAdapter;
import diellza.touristguide.Database.DBAdapter;
import diellza.touristguide.Helpers.MonumentArrayList;
import diellza.touristguide.Helpers.RefreshService;
import diellza.touristguide.Models.Monument;
import diellza.touristguide.R;


public class MonumentsFragment extends Fragment {
    public static final String ACTION_STATUS = "com.diellza.fragments.UPDATE_STATUS";
    String title;
    private RecyclerView recyclerView;
   static DBAdapter db;
    private ListReciever receiver;
    private static  List<Monument> monumentArrayList=new ArrayList<>();
    private static ArrayList<Monument> monuments1 = new ArrayList<>();
    MonumentRecyclerViewAdapter adapter;
    public static List<Monument> getMonuments1() {
        return monuments1;
    }

    public static DBAdapter getDb() {
        return db;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



setHasOptionsMenu(true);
 db= new DBAdapter(getContext());

           monumentArrayList = db.getMonuments();


        if(isNetworkAvailable() && MainActivity.getJsonResult()!=""){
           monumentArrayList=MonumentArrayList.getArray();
        }


    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        getActivity().getMenuInflater().inflate(R.menu.action_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.refreshService:
                if(isNetworkAvailable()) {
                    getActivity().startService(new Intent(getActivity(), RefreshService.class));
                }else{
                    Toast.makeText(getContext(), "No internet connection", Toast.LENGTH_SHORT).show();
                }
                return true;

            default:
                return false;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {




        ((MainActivity) getActivity()).setTitle(title);
        View v = inflater.inflate(R.layout.fragment_monuments, container, false);
        recyclerView = v.findViewById(R.id.rvMonument);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
     adapter = new MonumentRecyclerViewAdapter(getMonumentsByCategory(), this.getContext());
        recyclerView.setAdapter(adapter);
        return v;
    }


    public ArrayList<Monument> getMonumentsByCategory(){


            monumentArrayList = db.getMonuments();


        if(isNetworkAvailable()){
            monumentArrayList=MonumentArrayList.getArray();
      }

        Bundle bundle = getArguments();
        title = bundle.getString(CategoryRecyclerViewAdapter.CATEGORY_TITLE, "");


        if (title != "") {

            ((MainActivity) getActivity()).setTitle(title);
            for (int i = 0; i < monumentArrayList.size(); i++) {

                if (monumentArrayList.get(i).getCategory().equals(title)) {
                    monuments1.add(monumentArrayList.get(i));
                }
            }
        }
        return  monuments1;
    }

    public static Monument getMonumentById(String title)
    {



        if( MainActivity.getJsonResult()!=""){
            monumentArrayList=MonumentArrayList.getArray();
        }

        for (int i = 0; i < monumentArrayList.size(); i++) {
            if (monumentArrayList.get(i).getTitle().equals(title)) {
             return  (monumentArrayList.get(i));
            }
        }
        return monumentArrayList.get(0);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        monuments1.clear();
    }

    class ListReciever extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {


if (monuments1.size()!=0){
    monuments1.clear();
}
                adapter=new MonumentRecyclerViewAdapter(getMonumentsByCategory(),getContext());
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();



        }
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().unregisterReceiver(receiver);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (receiver == null)
            receiver = new ListReciever();


        getActivity().registerReceiver(receiver,
                new IntentFilter(MonumentsFragment.ACTION_STATUS));
    }


    public void saveData(){

                 db.openDB();
                 db.add(303,
                                 "Marashi",
                                 "Kompleksi i Marashit gjendet në pjesën lindore të Prizrenit; ai paraqet një simbiozë të këndshme të trashëgimisë natyrore dhe arkitektonike.",
                                 "Kompleksi i Marashit krijon vazhdimësinë mes Lidhjes Shqiptare të Prizrenit dhe Kalasë së Prizrenit dhe vazhdon me grykën e bukur të Lumëbardhit." +
                                                 " Rrapi i vjetër 400 vjeçar, dy metra i gjerë, është shembulli i vetëm i llojit të tij ë Ballkan. Në këtë kompleks paraqiten vlera monumentale të" +
                                                 " arkitekturës tradicionale dhe orientale të Prizrenit, ku ju mund të shihni edhe më tutje Xhaminë e Maksut Pashës, që daton që nga viti 1833, " +
                                                 "mauzoleun e rendit Saadi, objektin e restauruar te Mullirit të Pintolli, i cili kohëve të fundit po shfrytëzohet si restorant qumështor dhe disa" +
                                                 " shtëpi tradicionale urbane.Nga Marashi mund të vazhdohet në këmbë rrjedhës së sipërme të lumit, përderisa tani shtegu i cili vazhdon për disa " +
                                                 "milje për një ecje të këndshme buzë lumit ose për vozitje me biçikletë, është ndërtuar. Shtigjet të çojnë tek Kampi i Dokufestit, e nëse ju vazhdoni" +
                                                 " të ndiqni kalimin e gurit të bardhë, ju do të gjeni një terren perfekt për vrapim bashkë me natyrën e mahnitshme, dhe ju do të magjepseni me atë" +
                                                 " se ku do t’ju çoj fundi i saj, ju do të përfundoni në Kalanë e Prizrenit.Parku i Marashit ka një pozitë shumë të mirë në qytet. Gjendet në pjesën" +
                                                 " lindore të qytetit, pranë Lidhjes Shqiptare të Prizrenit dhe klubeve të natës. I vendosur afër qendrës së qytetit, por në të njëjtën kohë i " +
                                                 "fshehur nga turma," +
                                                 " ky vend ju ofron juve një ambient të ngrohtë, me shtigje për vrapim që të çojnë në kala, stole, terrene sportive dhe disa kafe-restorante të vogla.",
                                 "------",
                                 "---",
                                 "----",
                                 "----",
                                 "Vatra Shqiptare, Prizren, 20000",
                                 42.211774,
                                 20.744854,
                                 "Natyre",
                                 "http://res.cloudinary.com/dvdx8uis3/image/upload/v1525043702/hidroelektrana.jpg");
                 db.add(301,
                                 "Prevalla",
                                 "Prevalla eshte nje park ne malet e Sharrit rruges nga Shterpca ne Prizren, ne lartesi mbidetare 1515 metra.",
                                 "Prevalla eshte nje park ne malet e Sharrit rruges nga Shterpca ne Prizren, ne lartesi mbidetare 1515 metra. "  +
                                                 "Terreni malor, peizazhi i mrekullueshëm dhe ajri i freskët e bëjnë atë një zonë fantastike për shëtitje, ski" +
                                                 " dhe pushim. Për më tepër, Lumi i Lepencit rrjedh në këtë territor, gjë që e bën atë edhe më tërheqës dhe interesant për vizitorët." +
                                                 "Mund te shkoni me makine ose autobus. Prevalla është vend i mirë për ski në dimër. Ju mund të gjeni trajnerë profesionistë të skijimit " +
                                                 "për 20 euro në orë dhe mund të merrni me qira motoçikleta borë për 10 minuta 10 Euro dhe për 60 Euro per orë. Ka skilift 200 metra të gjatë." +
                                                 "Eshte i vend i pershtashem edhe per hiking.",
                                 "-----",
                                 "----",
                                 "----",
                                 "-----",
                                 "Prizren - Doganaj",
                                 42.175173,
                                 20.959605,
                                 "Natyre",
                                 "http://res.cloudinary.com/dvdx8uis3/image/upload/v1525043700/gazi_mehmet.jpg");
                 db.add(302,
                                 "Brod",
                                 "Brod është një vendbanim dhe fshat turistik në komunën e Sharrit, Kosovë.",
                                 "Terreni përreth Brodit në jugperëndim është kodrinor, por në verilindje është malor. " +
                                                 "Pika më e lartë mbidetare është Rule, 2 220 metra mbi nivelin e detit dhe e cila gjendet 2.8 km në lindje të Brodit." +
                                                 "Eshte i pershtatshem per skijim gjate sezones dimerore, ndersa gjat sezones verore ka vende shume interesante per hiking." +
                                                 "Fshati Brod është i begatshëm edhe me shtigje të skijimit. Pikërisht për këtë arsye është ngritur edhe Qendra Skitare, " +
                                                 "si njëra ndër qendrat më të reja skitare në Kosovë. [5] Në kuadër të saj funksionon edhe ski lifti i cili ofron mundësi " +
                                                 "dhe kushte edhe për skijim gjatë natës. [1] Gjithashtu ekzistojnë edhe kushte për zhvillimin e turizmit malor dhe organizimin " +
                                                 "e garave të ndryshme, si në nivel të Kosovës ashtu dhe të atyre ndërkombëtare.",
                                 "-----",
                                 "------",
                                 "----",
                                 "---",
                                 "Brod, Dragash",
                                 41.991688,
                                 20.707206,
                                 "Natyre",
                                 "http://res.cloudinary.com/dvdx8uis3/image/upload/v1525043700/gazi_mehmet.jpg");
                 db.closeDB();
             }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
