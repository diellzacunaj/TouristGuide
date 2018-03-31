package diellza.touristguide.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import diellza.touristguide.Activities.MainActivity;
import diellza.touristguide.Adapters.CategoryRecyclerViewAdapter;
import diellza.touristguide.Adapters.MonumentRecyclerViewAdapter;
import diellza.touristguide.Models.Monument;
import diellza.touristguide.R;


public class MonumentsFragment extends Fragment {


    RecyclerView recyclerView;
    List<Monument> monumentArrayList;
    List<Monument> monuments1 = new ArrayList<>();
    String key;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initalizeData();
        Bundle bundle = getArguments();
        String title = bundle.getString(CategoryRecyclerViewAdapter.CATEGORY_TITLE, "");


        if (title != "") {

            for (int i = 0; i < monumentArrayList.size(); i++) {
                if (monumentArrayList.get(i).getCategory() == title) {
                    monuments1.add(monumentArrayList.get(i));
                }
            }

        }

        ((MainActivity) getActivity()).setTitle("Monuments");
        View v = inflater.inflate(R.layout.fragment_monuments, container, false);
        recyclerView = v.findViewById(R.id.rvMonument);
        Log.d("ERRRORRR", "bundle");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        MonumentRecyclerViewAdapter adapter = new MonumentRecyclerViewAdapter(monuments1, this.getContext());
        recyclerView.setAdapter(adapter);

        return v;
    }

    private void initalizeData() {
        monumentArrayList = new ArrayList<>();

        /////////xhamite

        monumentArrayList.add(new Monument(1,
                "Xhamia e Sinan Pashes",
                "Është njëra prej monumenteve më karakterisitike të Prizrenit. E vendosur në qendrën historike.",
                "Xhamia e Sinan Pashës ndodhet në Zonën Historike të qytetit të Prizrenit." +
                        " Është ndërtuar nga ana e Sofi Sinan Pashës - person i shquar, njeri i dijes," +
                        "  me pozitë të rëndësishme në administratën Osmane. Me pozitën e saj dominuese, dimensionet," +
                        " formën, proporcionin e minares ndaj kupolës, materialet dhe teknikën e ndërtimit, dekorimet e" +
                        " pasura në enterier, Xhamia e Sinan Pashës paraqet njërin prej monumenteve më karakteristike të Prizrenit." +
                        " Xhamia është vendosur mbi një bazament të ngritur ku qasja nga rruga bëhet në anën veriore nëpërmjet" +
                        " shkallëve të gdhendura nga guri. Ka planimetri katrore me një nishë në pjesën jug-lindore që e bën xhaminë" +
                        " më specifike në krahasim me xhamitë tjera në Kosovë. Është ndërtuar nga gurët lumorë të latuar, të lidhur" +
                        " me llaç gëlqeror, ndërsa nga ana e jashtme është veshur me gurë të gdhendur (të cilët supozohet që janë marrë" +
                        " nga gërmadhat e Manastirit të Kryeengjëjve). Minarja e xhamisë është ndërtuar prej gurëve shtufe (siga), me" +
                        " bazë katrore dhe trung rrethor. Në pjesën e sipërme ndodhet një Sherefe. Para hyrjes në xhami ndodhet hajati i" +
                        " hapur, i punuar prej guri. Hajati ka tri kupola të mbuluara me plumb të cilat mbështeten në shtylla guri me bazë" +
                        " rrethore. Xhamia mbulohet me një kupolë të gjerë më diametër 42.5 m. Enterieri është hapësirë unike, e ndriçuar" +
                        " përmes dritareve të radhitura në nivele, me kupolë të pikturuar me motive florale në tri faza.",
                "Sofi Sinan Pasha",
                1615,
                "Free",
                "Mimar Sinani,Prizren 20000",
                42.209136,
                20.741279,
                "Xhamite",
                R.drawable.sinan_pasha,
                R.drawable.sinan_pasha));
        monumentArrayList.add(new Monument(2,
                "Xhamia e Suziut",
                "Njihet si një ndër xhamitë më të vjetra në Prizren, e ndërtuar në periudhën osmane gjatë shekullit XVI.",
                "Në popull njihet me emrin xhamia e Sozisë. Është e ndërtuar në vitin 1513 me financim të dijetarit të njohur të asaj kohe Suzi Çelebiu. Ai bashkë me xhaminë ndërtoi edhe mejtepin, bibliotekën (në historinë e bibliotekave të Kosovës njihet si biblioteka e parë e Kosovës), një çezme dhe një urë në lagjen e Sozisë. Është e njohur vepra poetike e tij e shkruar”Gazavetnameja”. Përmendet se renovimin dhe ngritjen e minares së Soziut e ka bërë Ymer beu. Viteve nëntëdhjeta xhamia është riparuar plotësisht, dhe është në gjendje të mirë funksionale. ",
                "Suzi Çelebiu",
                1513,
                "Free",
                "Suzi Çelebia, Prizren, 20000",
                42.209583,
                20.733954,
                "Xhamite",
                R.drawable.xhamia_soziut,
                R.drawable.xhamia_soziut));
        monumentArrayList.add(new Monument(3,
                "Xhamia e Namazgjasë",
                "Njihet si një ndër xhamitë më të vjetra në Prizren, e ndërtuar në periudhën osmane gjatë shekullit XVI.",
                "Eshte ndërtuar në vitin 1513 me financim të dijetarit të njohur të asaj kohe Suzi Çelebiu. Ai bashkë me xhaminë" +
                        " ndërtoi edhe mejtepin, bibliotekën (në historinë e bibliotekave të Kosovës njihet si biblioteka e parë e Kosovës)," +
                        " një çezme dhe një urë në lagjen e Sozisë. Është e njohur vepra poetike e tij e shkruar”Gazavetnameja”. Përmendet se " +
                        "renovimin dhe ngritjen e minares së Soziut e ka bërë Ymer beu. Viteve nëntëdhjeta xhamia është riparuar plotësisht," +
                        " dhe është në gjendje të mirë funksionale. ",
                "Isa Beu, komandant i Fatih Sulltan Mehmedit",
                1455,
                "Free",
                "De Rada, Prizren, 20000",
                42.214133,
                20.731059,
                "Xhamite",
                R.drawable.xhamia_namazgjase,
                R.drawable.xhamia_namazgjase));

        //////Kishat

        monumentArrayList.add(new Monument(11,
                "Kisha e Shën Premtes",
                "Ose Xhamia e Xhumasë është një kishe dhe ish-xhami e vjetër në rrugën e qyteti i Prizrenit.E ndërtuar në vitin 1306 nga Shtjefën Millutini.",
                "Kisha e Shën Premtes, e cila gjendet në Zonën Historike të Prizrenit, u rindërtua me urdhërin e mbretit Millutin, më 1306/7." +
                        " Punët meremetuese u udhëhoqën nga mjeshtrit e njohur të asaj kohe, Nikolla dhe Astrapa, të cilët e pasuruan kishën me një shprehje" +
                        " specifike dhe të pasur arkitektural dhe artistike përmes kombinimit të stilit Bizantin dhe atij të Rashkës. Shkencëtarët për vjetërsinë " +
                        "e kishës pothuajse pajtohen se kjo kishë është rindërtuar mbi një tempull të vjetër. Supozohet se themelet e kishës paleokristiane të faz" +
                        "ës së parë (shek. V-VI) e më pas të bazilikës Bizantine " +
                        "(shek. IX), vihen mbi themelet e tempullit Pagan (para erës sonë) të përkushtuar hyjneshës ilire të plleshmërisë dhe lindjes: Prema apo Premta. ",
                "Mbreti Millutin",
                1307,
                "Free",
                "Sahat Kulla,Prizren, 20000",
                42.211491,
                20.735211,
                "Kishat",
                R.drawable.premtes,
                R.drawable.premtes));
        monumentArrayList.add(new Monument(12,
                "Kisha e Shën Gjorgjit",
                "Kisha e Shën Gjorgjit është ndërtuar në fund të shekullit XV, nga vëllëzërit Runoviq dhe i ështe kushtuar Shën Gjorgjit",
                "Ndodhet në Zonën Historike të qytetit të Prizrenit. Është ndërtuar në vitin 1615 nga ana e Sofi Sinan Pashës - person i shquar, njeri i dijes, me pozitë të rëndësishme në administratën Osmane. Me pozitën e saj dominuese, dimensionet, formën, proporcionin e minares ndaj kupolës, materialet dhe teknikën e ndërtimit, dekorimet e pasura në enterier, Xhamia e Sinan Pashës paraqet njërin prej monumenteve më karakteristike të Prizrenit. Xhamia është vendosur mbi një bazament të ngritur ku qasja nga rruga bëhet në anën veriore nëpërmjet shkallëve të gdhendura nga guri. Ka planimetri katrore me një nishë në pjesën jug-lindore që e bën xhaminë më specifike në krahasim me xhamitë tjera në Kosovë. Është ndërtuar nga gurët lumorë të latuar, të lidhur me llaç gëlqeror, ndërsa nga ana e jashtme është veshur me gurë të gdhendur (të cilët supozohet që janë marrë nga gërmadhat e Manastirit të Kryeengjëjve). Minarja e xhamisë është ndërtuar prej gurëve shtufe (siga), me bazë katrore dhe trung rrethor. Në pjesën e sipërme ndodhet një Sherefe. Para hyrjes në xhami ndodhet hajati i hapur, i punuar prej guri. Hajati ka tri kupola të mbuluara me plumb të cilat mbështeten në shtylla guri me bazë rrethore. Xhamia mbulohet me një kupolë të gjerë më diametër 42.5 m. Enterieri është hapësirë unike, e ndriçuar përmes dritareve të radhitura në nivele, me kupolë të pikturuar me motive florale në tri faza. ",
                "Vëllëzërit Runoviq",
                0,
                "Free",
                "Sheshi i Shadervanit, Prizren, 20000",
                42.208275,
                20.740019,
                "Kishat",
                R.drawable.gjorgjit,
                R.drawable.gjorgjit));
        monumentArrayList.add(new Monument(13,
                "Kisha e Dielës se Shenjtë",
                "Kisha e Dielës së Shenjtë gjendet në Kompleksin e Nën-Kalasë. Eshte ndërtim i dimensioneve të vogla.",
                "Kisha e Dielës së Shenjtë gjendet në Kompleksin e Nën-Kalasë. Eshte ndërtim i dimensioneve të vogla, me kupolën " +
                        "tetëkëndëshe, e ndërtuar me material prej guri e tullave.",
                "I panjohur",
                1615,
                "Free",
                "Vatra Shqipetare, Prizren, 20000",
                42.209097,
                20.742514,
                "Kishat",
                R.drawable.dieles,
                R.drawable.dieles));

        ///Urat

        monumentArrayList.add(new Monument(101,
                "Ura e vjetër e Gurit",
                "Ura e Gurit gjendet në qendrën historike të qytetit. Në anën lindore të saj gjendet Ura e Arastës, kurse në anën perëndimore gjendet Ura e Naletit",
                "Përmes Prizrenit kalon lumi Lumbardh i cili e ndan qytetin në dy pjesë, pothuajse të barabarta." +
                        " Mbi Lumbardhin e Prizrenit, në rrjedhat e historisë, u ngritën shumë ura por pa dyshim më e veçanta " +
                        "që u shndërrua në simbol të qytetit është Ura e Gurit. Ura e Gurit gjendet në qendrën e qytetit të vjetër." +
                        " Në anën lindore të saj gjendet Ura e ,,Arastës”, kurse në anën perëndimore gjendet Ura e ,,Naletit”. " +
                        "Ura lidh drejtpërsëdrejti sheshin Shatërvan (në anën e majtë të lumit) dhe Saraçhanën (në të djathtë të lumit)." +
                        " Burimet historike nuk ofrojnë të dhëna për kohën e saktë të ndërtimit të saj. Në bazë të materialit, stilit, " +
                        "teknikës së ndërtimit, supozohet se ura është ndërtuar kah fundi i shekullit XV, ose në fillim të shekullit XVI." +
                        " Ura e vjetër është e ndërtuar me gurë cilësorë të përpunuar dhe të lidhur ndërmjet vete me llaç gëlqeror. " +
                        "Ura e vjetër ishte triharkore, harku i mesëm ishte më i madh, kurse harqet anësore më të vogla. Gjatësia e urës" +
                        " së dikurshme ishte përafërsisht 30m, ndërkaq e urës së tanishme është 17m. Gjatësia e harkut të madh është 10m, " +
                        "lartësia 5m. Gjatësia e harqeve anësore 4m, lartësia 3m. Ura ka edhe një hark të vogël ndihmës me gjatësi 103cm " +
                        "dhe lartësi 160cm. Gjerësia e trasesë është 4,20m dhe është e shtruar me kalldrëm. Ura ka një rrethojë prej 40cm " +
                        "që përcjellë nivelimin e saj dhe ka shërbyer vetëm për këmbësorë. Në rrjedhat e historisë, ura ka përjetuar disa n" +
                        "dryshime të mëdha. Ajo pësoi dëme serioze strukturale gjatë ndërtimit të shtratit të Lumbardhit, në vitet ‘60. Me k" +
                        "ëtë rast mbyllet krejtësisht harku i saj, në të majtë të lumit. Ndërkaq harku i anës së djathtë pësoi me rastin e n" +
                        "dërtimit të aksit rrugor, në anën e djathtë të lumit, më 1963. Urës rreziku më i madh i erdhi nga faktorët natyrorë" +
                        ". Vërshimi i lumit më 17/18 nëntor të vitit 1979 shkaktoi rrënimin e urës në tërësi. Prizrenasit të mallëngjyer për" +
                        " shkatërrimin e urë u mobilizuan dhe sipas projektit të hartuar nga M. Gojkoviq, ing., më 5 qershor 1982 fillojnë" +
                        " punimet për rindërtimin e saj. Punët restauruese i kreu Ndërmarrja e ,,Elanit”, nën mbikëqyrjen e Entit për " +
                        "Mbrojtjen e Monumenteve Kulturore të Prizrenit. Ura e rindërtuar solemnisht u inaugurua më 17 nëntor 1982." +
                        " Kështu ura natyrshëm vjen në ambientin e vet dhe vazhdon ta kryejë funksionin e urës për këmbësorë. Duke marrë" +
                        " në konsideratë vlerat e mirëfillta të trashëgimisë, Ura e Gurit me vendimin nr. 2345 të datës 31 dhjetor 1948 v" +
                        "ihet nën mbrojtje të shtetit.",
                "I panjohur",
                0,
                "Free",
                "Ura e Gurit,Prizren,20000",
                42.209568,
                20.740694,
                "Urat",
                R.drawable.ura_e_gurit,
                R.drawable.ura_e_gurit));
        monumentArrayList.add(new Monument(102,
                "Ura e Soziut",
                "Gjendet pranë xhamisë së Suzi Celbisë. Në formën e tanishme e ndërtoi Suzi Celebia në vitin 1513.",
                "Gjendet pranë xhamisë së Suzi Celbisë. Në formën e tanishme e ndërtoi Suzi Celebia në vitin 1513. " +
                        "Në bazë të disa dokumenteve qëndron që të ketë ekzisituar ura edhe më parë. Në popull është e njohur me " +
                        "emrin Ura e Tabakhanes, pasi që gjendet në pjesën e qytetit ku kryesishtë ishin zanatlinj të cilët" +
                        " merreshin me mbledhjen dhe përpunimin e lëkurës, e njohur edhe jashtë vendit",
                "Suzi Çelebia",
                1513,
                "Free",
                "Suzi Çelebia,Prizren, 20000",
                42.209724,
                20.733659,
                "Urat",
                R.drawable.ura_soziut,
                R.drawable.ura_soziut));
        monumentArrayList.add(new Monument(103,
                "Ura e Marashit",
                "Gjendet në Marash.",
                "Gjendet në Marash.Gjendet në Marash.Gjendet në Marash.Gjendet në Marash.Gjendet në Marash.Gjendet në Marash." +
                        "Gjendet në Marash.Gjendet në Marash.Gjendet në Marash.Gjendet në Marash.Gjendet në Marash.Gjendet në Marash." +
                        "Gjendet në Marash.Gjendet në Marash.Gjendet në Marash.Gjendet në Marash.Gjendet në Marash.Gjendet në Marash.",
                "Nuk dihet",
                1936,
                "Free",
                "Vatra Shqipetare, Prizren, 20000",
                42.212325,
                20.744633,
                "Urat",
                R.drawable.ura_marashit,
                R.drawable.ura_marashit));

        ////monumente

        monumentArrayList.add(new Monument(201,
                "Kalaja e Prizrenit",
                "Kalaja e Prizrenit është një monument i trashëgimisë kulturore në Prizren, Kosovë, konsiderohet të jetë simboli i qytetit dhe një element me rëndësi në identitetin kulturor të Kosovës.",
                "Kalaja e Prizrenit është një monument i trashëgimisë kulturore në Prizren, Kosovë[1], konsiderohet të jetë simboli i qytetit dhe një element me rëndësi në identitetin kulturor të Kosovës." +
                        "Kalaja e Prizrenit është një monument i trashëgimisë kulturore në Prizren, Kosovë[1], konsiderohet të jetë simboli i qytetit dhe një element me rëndësi në identitetin kulturor të Kosovës.",
                "Vatra Shqipetare, Prizren, 20000",
                42.209384,
                20.745397,
                "Monumente",
                R.drawable.kalaja1,
                R.drawable.kalaja1));
        monumentArrayList.add(new Monument(202,
                "Shatervani",
                "Në Zonën Historike të Prizrenit, në afërsi të Xhamisë së Sinan Pashës gjendet kroi i “Shatërvanit”. Supozohet se është ndërtuar në shek. XVII.",
                "Baza e kroit është në formë katrore me gur të latuar nga mermeri me ngjyrë të përhimtë, pjesa e sipërme ka formën e " +
                        "tetëkëndëshit. Pipëzat e ujit gjenden në katër anët e kroit në lartësi prej 1 m. Pjesa e sipërme është në formë të " +
                        "tetëkëndëshit, e zbukuruar me ornamente gjeometrike. Guacat për përcjelljen e ujit janë prej betoni në formë harkore" +
                        " të rrethuar me gurë të latuar. Uji prej guacave rrjedh në kanale. Në fund të shek. XIX mbi kroin e Shatërvanit ndodhej" +
                        " vrojtorja e xhandarmerisë turke, për të cilën na vërteton një fotografi që gjendet në dokumentacionin e QRTK-së së" +
                        " Prizrenit . Kroi i Shatërvanit ndodhet në mes të Sheshit Shatërvan, me pozitën e saj karakteristike, formën " +
                        "dhe dekorimet paraqet njërin prej simboleve të qytetit dhe njëherësh edhe Kroin më karakteristik të ruajtur deri në" +
                        " ditët e sotme.",
                "Sheshi i Shadervanit,PRizren, 20000",
                42.209015,
                20.740552,
                "Monumente",
                R.drawable.shatervani,
                R.drawable.shatervani));
        monumentArrayList.add(new Monument(203,
                "Sahat Kulla - Muzeu Arkeologjik",
                "Muzeu Arkeologjik është vendosur në hapësirat e hamamit, të ndërtuar në fundin e shekullit XV, respektivisht në vitin 1498.",
                "Muzeu Arkeologjik është vendosur në hapësirat e hamamit, të ndërtuar në fundin e shekullit XV, respektivisht në vitin 1498." +
                        " Ndërtuesi i këtij hamami supozohet të jetë Shemsudin Ahmed Beu. Në mungesë të burimeve të shkruara, nuk dihet se deri në " +
                        "cilin vit është përdorur si hamam, por dihet se hamami nuk ka kryer funksionin " +
                        "e tij fillestar në mesin e shek. XIX kur mbi hapësirën e ngrohtë është ndërtuar Kulla e Sahatit nga ana e Eshref Pashë " +
                        "Rrotullit. Objekti ka formë drejtkëndëshe dhe është ndërtuar me gurë të ndryshëm dhe tulla, ndërsa si material lidhës është " +
                        "përdorur llaçi gëlqeror. Kulmi ka shtatë kupola dhe tri qemerë, dhe të gjitha janë të mbuluara me pllaka të plumbit. Sahat Kulla " +
                        "është ndërtuar me tulla të argjilës së pjekur. " +
                        "Dyshemeja e objektit është shtruar me pllaka guri të vendosura në vitet ’70 të shek XX kur objekti shndërrohet në muze arkeologjik.",
                "Vatra Shqipetare, Prizren, 20000",
                42.209384,
                20.745397,
                "Monumente",
                R.drawable.sahatkulla,
                R.drawable.sahatkulla));

        /////Ndertesa
        monumentArrayList.add(new Monument(300,
                "Lidhja Shqipetare e Prizrenit",
                "Gjendet në kuadër të Kompleksit të Gazi Mehmed Pashës.",
                " Kompleksi i Lidhjes Shqiptare të Prizrenit, si tërësi urbane-arkitektonike në aspektin hapësinor është vendosur në bërthamën e vjetër" +
                        " të qytetit dhe ka vlerë të veçantë kulturo-historike, shoqërore dhe ambientale. Ndërtesa e Lidhjes" +
                        " së Prizrenit ka planimetri drejtkëndëshe, është e formësuar në përdhesë dhe në kat. Kati del në formë konzolle kah fasada lindore. " +
                        "Trajtimi i fasadës është linear, me disa hapje në formë drejtkëndëshe dhe kulm katër ujor. Ndërtesa e Lidhjes së Prizrenit" +
                        " fillimisht ka shërbyer si ders-hane (mësonjëtore) e kompleksit të Gazi Mehmed Pashës. Në vitin 1878 e deri në vitin 1881 " +
                        "kjo ndërtesë u shfrytëzua si zyre administrative e Lidhjes Shqiptare të Prizrenit. Gjatë shek. XX kjo ndërtesë u shfrytëzua si hapësirë" +
                        " banimi. Në vitin 1968 bëhet dislokimi i ndërtesës për disa metra në perëndim, për arsye të ndërtimit të rrugës. Vitet 1976-1978" +
                        " shënojnë intervenimet restauruese dhe revitalizuese me ç’rast, për nder të shënimit të 100 vjetorit, ndërtesa shndërrohet në pjesë të" +
                        " Kompleksit Muzeor të Lidhjes Shqiptare të Prizrenit. Në mars të vitit 1999 objekti shkatërrohet në tërësi nga paramilitarët Serb " +
                        "dhe aty formohet një park. Pas qershorit 1999 menjëherë fillojnë punët në projektimin dhe rinkonstruim të kësaj ikone historike " +
                        "të rëndësishme për historinë e popullit shqiptar. Punët përfunduan në 10 qershor të vitit 2000. Në vitin 2003 bëhet" +
                        " ridizajnimi i oborrit të kompleksit të Lidhjes Shqiptare të Prizrenit, në kuadër të saj kjo ndërtesë shërben si Muze Historik." +
                        " Në muzeun historik janë të paraqitura eksponate që tregojnë historinë e zhvillimit të ngjarjeve politike gjatë periudhës 1878 – 1881.",
                "Vatra Shqipetare, Prizren, 20000",
                42.209384,
                20.745397,
                "Ndertesa",
                R.drawable.lidhja,
                R.drawable.lidhja));
        monumentArrayList.add(new Monument(203,
                "Hamami - Gazi Mehmet Pasha",
                "Gjendet në qender te qytetit prane Xhamise se Kukli Mehmet Beut dhe te Emin Pashes. ",
                " Është ndërtuar në vitin 1563-74, nga Gazi Mehmet Pasha, Sanxhakbej i Shkodrës më 1573-4. Në portën kryesore është vendosur pllaka me" +
                        " mbishkrim (1833) e cila tregon datën e restaurimit të hamamit nga ana e vëllezërve Tahir dhe Mehmed Pashë Rrotulli. Hamami gjendet " +
                        "në kuadër të ansamblit arkitektonik të themeluar nga Gazi Mehmet Pasha, ku gjenden Xhamia e Bajraklisë, shkolla e mesme (medresa), s" +
                        "hkolla fillore (mejtepi), biblioteka dhe mauzoleumi (tyrbja). Hamami është i llojit \"çifte hamam\" që është përdorur nga të dy gjin" +
                        "itë në të njëjtën kohë. Hamami është ndërtuar nga gur të ndryshëm në kombinim me tulla. Muret kanë një trashësi rreth 90 cm, të suvatuara nga ana e" +
                        " brendshme. Pullazi i objektit ka dy kupola të ndërtuara mbi tambure, në pjesën e ftohtë (pritja) dhe nëntë kupola të vogla që janë " +
                        "mbi pjesën e ngrohtë të Hamamit. Pjesa e garderobës dhe kaldatores është e mbuluar me qemerë. " +
                        "Mbulesa është me tjegulla në pjesën e ftohtë, ndërsa me pllaka të plumbit në pjesët tjera. Prej vitit 2000 pjesa e ftohtë e" +
                        " Hamamit shfrytëzohet si galeri për organizimin e aktiviteteve të ndryshme kulturore, artistike dhe edukative.",
                "Adem Jashari, Prizren, 20000",
                42.210799,
                20.741585,
                "Ndertesa",
                R.drawable.gazi_mehmet,
                R.drawable.gazi_mehmet));
        monumentArrayList.add(new Monument(203,
                "Hidroelektrana - Muzeu i Elektroekonomise",
                "Në ambientin piktoresk të Grykës së Lumbardhit, 2.5 km larg Prizrenit gjendet objekti i Hidro-elektranës “Prizrenasja” ",
                " Është ndërtuar në vitin 1926-28 me kontributin e qytetarëve dhe kredive bankare. Ndërtesa është projektuar dhe ndërtuar nga një kompani austriake." +
                        " Objekti ka pasur elementet moderne të asaj kohe: turbinat e ujit, pjesën për pastrimin e ujit nga mbeturinat, kanalin, pajisjet për përcjelljen e" +
                        " ujit gjer në turbinë dhe gjeneratorin me fuqi 160 KW. Për shkak të kërkesës së madhe të energjisë elektrike më 1936 është lëshuar në qarkullim gj" +
                        "eneratori i dytë me kapacitet të njëjtë. Objekti është formësuar në dy kate, në përdhesë është kthina e madhe ku janë të vendosura dy gjeneratorë " +
                        "dhe pajisjet tjera përcjellëse, kurse në dhomën tjetër kanë qenë aparatet për përcjelljen e rrymës. Në katin e epërm ka qenë dhoma e inxhinerit që" +
                        " ka qenë edhe mbikëqyrësi i hidroelektranës. Fillimisht një pjesë e katit të parë ka qenë e mbuluar me kulm të rrafshët, dhe qasja në kulm " +
                        "realizohej nga ana veriore e dhomës së inxhinierit. Më vonë kulmi i rrafshët është mbuluar me kulm të pjerrtë një ujor të mbuluar me tjegulla argjile." +
                        " Arkitekti austriak ka zgjedhur vendin më të përshtatshëm për shfrytëzimin e ujit dhe është munduar që objektin industrial ta përshtatë me ambientin" +
                        " duke dhënë formën e një kështjelle si inspirim nga Kështjella e Epërme që gjendet në afërsi. Në të njëjtën kohë dhe me të njëjtin stil janë " +
                        "ndërtuar edhe dy trafostacione që kanë shpërndarë rrymën nëpër qytetin e Prizrenit. Objekti është ndërtuar nga gurët e latuar të lidhur me llaç" +
                        " gëlqeror, me këndet e punuara me tulla të plota. Konstruksioni meskatësh është punuar nga druri. Kulmi i rrafshët është punuar me beton të armuar." +
                        " Dritaret kanë formë drejtkëndëshe, me hapje gjysmëharkore në pjesën e sipërme. Dera hyrëse në përdhesë është punuar nga dru bungu," +
                        " me hapje gjysmëharkore në pjesën e sipërme. Hidroelektrana ka furnizuar qytetin e Prizrenit me rrymë elektrike prej vitit 1929 deri në vitin 1973. ",
                "Gryka e Lumbardhit, Prizren-Prevallë, 20000",
                42.200912,
                20.763797,
                "Ndertesa",
                R.drawable.hidroelektrana,
                R.drawable.hidroelektrana));

        /////////      natyre
        monumentArrayList.add(new Monument(300,
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
                "Vatra Shqiptare, Prizren, 20000",
                42.211774,
                20.744854,
                "Natyre",
                R.drawable.marashi,
                R.drawable.marashi));
        monumentArrayList.add(new Monument(301,
                "Prevalla",
                "Prevalla eshte nje park ne malet e Sharrit rruges nga Shterpca ne Prizren, ne lartesi mbidetare 1515 metra.",
                "Prevalla eshte nje park ne malet e Sharrit rruges nga Shterpca ne Prizren, ne lartesi mbidetare 1515 metra. " +
                        "Terreni malor, peizazhi i mrekullueshëm dhe ajri i freskët e bëjnë atë një zonë fantastike për shëtitje, ski" +
                        " dhe pushim. Për më tepër, Lumi i Lepencit rrjedh në këtë territor, gjë që e bën atë edhe më tërheqës dhe interesant për vizitorët." +
                        "Mund te shkoni me makine ose autobus. Prevalla është vend i mirë për ski në dimër. Ju mund të gjeni trajnerë profesionistë të skijimit " +
                        "për 20 euro në orë dhe mund të merrni me qira motoçikleta borë për 10 minuta 10 Euro dhe për 60 Euro per orë. Ka skilift 200 metra të gjatë." +
                        "Eshte i vend i pershtashem edhe per hiking.",
                "Prizren - Doganaj",
                42.175173,
                20.959605,
                "Natyre",
                R.drawable.prevalla,
                R.drawable.prevalla));
        monumentArrayList.add(new Monument(302,
                "Brod",
                "Brod është një vendbanim dhe fshat turistik në komunën e Sharrit, Kosovë.",
                "Terreni përreth Brodit në jugperëndim është kodrinor, por në verilindje është malor. " +
                        "Pika më e lartë mbidetare është Rule, 2 220 metra mbi nivelin e detit dhe e cila gjendet 2.8 km në lindje të Brodit." +
                        "Eshte i pershtatshem per skijim gjate sezones dimerore, ndersa gjat sezones verore ka vende shume interesante per hiking." +
                        "Fshati Brod është i begatshëm edhe me shtigje të skijimit. Pikërisht për këtë arsye është ngritur edhe Qendra Skitare, " +
                        "si njëra ndër qendrat më të reja skitare në Kosovë. [5] Në kuadër të saj funksionon edhe ski lifti i cili ofron mundësi " +
                        "dhe kushte edhe për skijim gjatë natës. [1] Gjithashtu ekzistojnë edhe kushte për zhvillimin e turizmit malor dhe organizimin " +
                        "e garave të ndryshme, si në nivel të Kosovës ashtu dhe të atyre ndërkombëtare.",
                "Brod, Dragash",
                41.991688,
                20.707206,
                "Natyre",
                R.drawable.brod,
                R.drawable.brod));
    }
}
