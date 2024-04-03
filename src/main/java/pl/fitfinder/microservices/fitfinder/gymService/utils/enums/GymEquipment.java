package pl.fitfinder.microservices.fitfinder.gymService.utils.enums;

import lombok.Getter;

@Getter
public enum GymEquipment {

    //Cardio
    TREADMILL("BIEŻNIA", "CARDIO", "Bieżnia elektryczna do biegania"),
    STATIONARY_BICYCLE("ROWEREK", "CARDIO", "Rower elektryczny"),
    ROWING_MACHINE("WIOŚLARZ", "CARDIO", "Wioślarz - symulator wiosłowania"),
    STAIR_CLIMBER("SCHODY AUTOMATYCZNE", "CARDIO", "Maszyna do imitacji wchodzenia po schodach"),

    //Strength training
    BENCH_PRESS("ŁAWKA PŁASKA", "KLATKA PIERSIOWA", "Ławka płaska do wyciskania sztangi"),
    DECLINE_BENCH("SKOS UJEMNY", "KLATKA PIERSIOWA", "Ławka skos ujemny do wyciskania sztangi"),
    INCLINE_BENCH("ŁAWKA SKOŚNA", "KLATKA PIERSIOWA", "Ławka skośna do wyciskania sztangi"),

    FREE_WEIGHT_BENCHES("ŁAWKA WOLNA", "GÓRA CIAŁA", "Ławka wolnostojąca do wykorzystania z hantelkami"),
    CHEST_FLY_MACHINE("MASZYNA DO ROZPIĘTEK", "GÓRA CIAŁA", "Maszyna do rozpiętek butterfly"),

    BICEP_CURL_BENCH_MACHINE("MASZYNA DO ZGIĘĆ RAMION", "BICEPS", "Maszyna do treningów mięśni dwugłowych ramienia"),
    BICEP_CURL_BENCH("MODLITEWNIK DO ZGIĘĆ RAMION", "BICEPS", "Modlitewnik / Ławka do treningów mięśni dwugłowych ramienia"),

    ARM_EXTENSION_MACHINE("MASZYNA DO PROSTOWANIA RAMION", "TRICEPS", "Maszyna do treningów mięśni trójgłowych ramienia"),

    SHOULDER_PRESS_MACHINE("MASZYNA DO BARKÓW", "BARKI", "Maszyna do treningów mięśni barków"),
    LATERAL_RAISES_MACHINE("MASZYNA DO BOCZNEGO AKTONU BARKÓW", "BARKI", "Maszyna do treningów środkowego aktonu barków"),

    LAT_PULL_DOWN("WYCIĄG GÓRNY Z DRĄŻKIEM", "PLECY", "Wyciąg górny do treningów pleców - imitacja podciągania"),
    ROW_BACK_MACHINE("MASZYNA DO WIOSŁOWANIA", "PLECY", "Maszyna do wiosłowania"),
    STATIC_BARBELL_ROW("STATYCZNA SZTANGA DO WIOSŁOWANIA", "PLECY", "Statyczna sztanga do wiosłowania"),

    ABS_BENCH("ŁAWKA DO BRZUSKÓW", "BRZUCH", "Ławka do treningu środkowej sekcji brzucha w skosie ujemnym"),
    AB_CRUNCH_MACHINE("MASZYNA DO SKŁONÓW", "BRZUCH", "Maszyna do treningu środkowego aktonu brzucha"),

    LEG_PRESS_MACHINE("WYCISKANIE NOGAMI LEŻĄC", "NOGI", "Maszyna do wyciskania ciężarów nogami leżąc"),
    LEG_EXTENSION_MACHINE("WYCISKANIE NOGAMI SIEDZĄC", "NOGI", "Maszyna do wyciskania ciężarów nogami siedząc"),
    LEG_CURL_MACHINE("UGINANIE NÓG", "NOGI", "Uginanie nóg siedząc mięśniami dwugłowymi"),
    SEATED_CALF_MACHINE("MASZYNA DO ŁYDEK", "NOGI", "Unoszenie ciężaru przy użyciu łydek siedząc"),
    STANDING_CALF_MACHINE("MASZYNA DO ŁYDEK STOJĄC", "NOGI", "Unoszenie ciężaru przy użyciu łydek stojąc"),
    HACK_SQUAT_MACHINE("MASZYNA DO PRZYSIADÓW", "NOGI", "Maszyna do przysiadów z obciążeniem"),

    //SMALL EQUIPMENT
    JUMPING_ROPE("SKAKANKA", "MAŁĘ WYPOSAŻENIE", "Skakanka"),
    AB_ROLLER("ROLLER ABS", "MAŁĘ WYPOSAŻENIE", "Kółko do treningu mięśni brzucha"),
    MEDICINE_BALL("PIŁKI LEKARSKIE", "MAŁĘ WYPOSAŻENIE", "Piłki lekarskie z różnym obciążeniem"),
    RESISTANCE_BANDS("GUMY TRENINGOWE", "MAŁĘ WYPOSAŻENIE", "Gumy oporowe"),

    //FREE WEIGHTS
    KETTLEBELLS("KETTLEBELLE", "OGÓLNY", "Kettle do treningu ogólnego"),
    DUMBELLS_SET("ZESTAW HANTLI", "OGÓLNY", "Hantle do treningu ogólnego"),
    BARBELLS_SET("ZESTAW SZTANG Z OBCIĄŻENIEM", "OGÓLNY", "Sztangi z zamontowanym ciężarem do treningu ogólnego"),
    BARBELL("SZTANGA", "OGÓLNY", "Klasyczna sztanga"),

    //STATIC BIG EQUIPMENT
    LEG_RAISE_TOWER("MASZYNA DO DIPÓW/WZNOSÓW NÓG", "OGÓLNE", "Maszyna do wznosu nóg i dipów"),
    BOXING_BAG("WOREK TRENINGOWY", "BRZUCH", "Maszyna do treningu środkowego aktonu brzucha"),
    SMITH("MASZYNA SMITHA", "OGÓLNY", "Maszyna smitha"),
    CABLE_CROSSOVER_MACHINE("MASZYNA DO ROZPIĘTEK ATLAS", "OGÓLNY", "Maszyna z dwoma regulowanymi wyciągami i nakładkami"),
    POWER_RACK("KLATKA", "OGÓLNY", "Klatka uniwersalna do ćwiczeń np przysiadów, podciągania");

    private String name;
    private String category;
    private String description;

    GymEquipment(String name, String category, String description){
        this.name = name;
        this.category = category;
        this.description = description;
    }
}
