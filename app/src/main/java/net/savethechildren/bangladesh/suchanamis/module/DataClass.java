package net.savethechildren.bangladesh.suchanamis.module;

/**
 * Created by stccon on 8/21/2017.
 */

public class DataClass {


    public static String[] moulic_training_list_type_arr = {"মৌলিক প্রশিক্ষণ","রিফ্রেসার প্রশিক্ষণ","অন্যান্য\n" +
            "(প্রশিক্ষণ/মিটিং)","উঠান বৈঠকে অংশগ্রহন","ANC/PNC সেবা সম্পর্কিত তথ্য",
    "শিশুর পুষ্টি অবস্থা/Nutrition Status (WFA)","ইনপুট/IGA", "ইনপুট/IGA-এর ব্যবহার","মন্তব্য\n" +
            "(যদি থাকে)"};
    public static String[] moulic_training_type_arr = {"1= Poultry- HKI","2= VMF owner on HFP- HKI","3= IGA- HKI","4= Horticulture","5= Aquaculture- WF", "6= Demo Pond (DP) on fish culture- WF","7= IGA- WF","8= IGA- SC","9= Financial literacy-SC","10= Vaccinator training","11= Not received basic training but received orientation","99=  Other (Specify)"};
    public static int[] moulic_training_type_arr_no = {1,2,3,4,5,6,7,8,9,10,11,99};

    public static String[] other_training_type_arr = {"1= Adolescent life skills training","2= Linkage event on fish culture","3= Coaching on fish culture","4= Coaching on vegetable gardening","5= Coaching on poultry", "7= Community Need Assessment (CNA)","8= Community Risk Assessment (CRA)","9= IGA assignment meeting","99= Other (specify)"};
    public static int[] other_training_type_arr_no = {1,2,3,4,5,7,8,9,99};
    public static String[] moulic_training_receiver_type_arr = {"1= উপকারভোগী নিজে","2= অন্য কেউ (মহিলা)","3= অন্য কেউ (পুরুষ)"};
    public static int[] moulic_training_receiver_type_arr_no = {1,2,3};

    public static String[] moulic_training_type_no_arr = {"1st","2nd","3rd","4th","5th","6th","7th","8th","9th","10th"};
    public static int[] moulic_training_type_no_arr_no = {1,2,3,4,5,6,7,8,9,10};

    public static String[] courtyard_meeting_arr = {"1= হ্যাঁ (উপস্থিত ছিল)","2= না (উপস্থিত ছিল না)"};
    public static int[] courtyard_meeting_arr_no = {1,2};
    public static String[] empty_arr = {""};

    public static String[] anc_pnc_type_arr = {"1= ANC 1st check-up","2= ANC 2nd check-up","3= ANC 3rd check-up","4= ANC 4th check-up","5= ANC more than 4 check-up","6= Not received any ANC check-up","7= PNC 1st check-up","8= PNC 2nd check-up","9= PNC more than 2 check-up","10= Not received any PNC check-up"};
    public static int[] anc_pnc_type_arr_no = {1,2,3,4,5,6,7,8,9,10};

    public static String[] baby_nutation_arr = {"1= স্বাভাবিক (স্বাভা) + স্বল্প\n" +
            "(সবুজ বা হলুদ রং অংশ)\n","2= মাঝারি বা মাঝা\n" +
            "(কমলা রং অংশ)\n","3= মারাত্মক বা মারা\n" +
            "(লাল রং অংশ)\n","4= ক্লিনিক বা EPI সেন্টারে গিয়েছিল কিন্তু ওজন মাপা হয়নি বা উপকারভোগীর কাছে GMP কার্ড পাওয়া যায়নি",
            "5= ক্লিনিক বা EPI সেন্টারে যায়নি","6= বাড়ীটি GMP পরিচালিত ক্লিনিক বা EPI সেন্টারের আওতাধীন নয়"};
    public static int[] baby_nutation_arr_no = {1,2,3,4,5,6};

    public static String[] baby_gender_arr = {"1= মেয়ে শিশু [প্রতিবন্ধী নয়]","2= মেয়ে শিশু [প্রতিবন্ধী]","3= ছেলে শিশু [প্রতিবন্ধী নয়]","4= ছেলে শিশু [প্রতিবন্ধী]"};
    public static int[] baby_gender_arr_no = {1,2,3,4};

    public static String[] iga_input_arr = {"1= Vegetable seed (no. packet)","2= Vegetable seedling (no.)","3= OSP vine (no.)","4= Fruit sapling (no.)","5= Maringa sapling (no.)","6= Poultry shed (no.)","7= Fish fingerling (no.)","8= Chickens (no.)","9= Duck (no.)","10= Goat (no.)","11= Sheep (no.)","12= Rickshaw/Van (no.)","13= Bamboo (no.)","14= Vegetable business related","15= Fish business related","16= Pati making materials","17= Handicraft making materials","99= Other (specify)"};
    public static int[] iga_input_arr_no = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,99};

    public static String[] iga_uses_arr = {"1= ব্যবহার করতে পারছে","2= মোটামোটি ব্যবহার করতে পারছে (কিছু নষ্ট বা মারা গিয়েছে, কিছু ভাল আছে)","3= ব্যবহার করতে পারছে না বা মারা গেছে বা নষ্ট হয়ে গেছে"};
    public static int[] iga_uses_arr_no = {1,2,3};

    public static String[] beneficiary_type_arr = {"1= Woman (15-40/45)\n[প্রতিবন্ধী নয়]\n","2= Woman (15-40/45)\n" +
            "[প্রতিবন্ধী]\n","3= Adolescent (15-19)\n" +
            "[প্রতিবন্ধী নয়]\n","4= Adolescent (15-19)\n" +
            "[প্রতিবন্ধী]\n" };
    public static int[] beneficiary_type_arr_no = {1,2,3,4};
    public static String[] suchanaYearCode_arr = {"0= Learning Phase (2016)","1= Year 1 (2017)","2= Year 2 (2018)","3= Year 3 (2019)","4= Year 4 (2020)"};
    public static int[] suchanaYearCode_arr_no = {0,1,2,3,4};

    public static String[] ipNameCode_arr = {"1=FIVDB","2= RDRS","3= CNRS"};
    public static int[] ipNameCode_arr_no = {1,2,3};

    public static String[] benCondition_arr = {"1= বর্তমানে গর্ভবতী নারী (১৫-৪০/৪৫)\n" +
            "[প্রতিবন্ধী নয়]\n","2= বর্তমানে গর্ভবতী নারী (১৫-৪০/৪৫)\n" +
            "[প্রতিবন্ধী]\n","3= ২ বছরের নিচে সন্তান আছে \n  এমন নারী (১৫-৪০/৪৫)[প্রতিবন্ধী নয়]\n","4= ২ বছরের নিচে সন্তান আছে \n  এমন নারী (১৫-৪০/৪৫) [প্রতিবন্ধী]\n","5= উভয়েই (বর্তমানে গর্ভবতী \n এবং ২ বছরের নিচে সন্তান এমন নারী [প্রতিবন্ধী নয়]","6= উভয়েই (বর্তমানে গর্ভবতী এবং \n ২ বছরের নিচে সন্তান এমন নারী [প্রতিবন্ধী]"};
    public static int[] benCondition_arr_no = {1,2,3,4,5,6};

    public static String[] vmf_dp_arr = {"1= Village Model Farmer (VMF)","2= Demo Pond (DP)","3= Discontinue"};
    public static int[] vmf_dp_arr_no = {1,2,3};

    public static String[] skipSuchana_arr = {"1= মৃত্যূ","2= অন্য জায়গায় চলে গেছে","3= বিয়ে হয়ে অন্য জায়গায় চলে গেছে","4= সূচনা কার্যক্রমে অংশগ্রহনে আর আগ্রহী নয় (নির্দিষ্ট করুন)","99= অন্যান্য (নির্দিষ্ট করুন)"};
    public static int[] skipSuchana_no = {1,2,3,4,99};






}
