package pl.fitfinder.microservices.fitfinder.gymService.utils.enums;

import lombok.Getter;

@Getter
public enum GymEquipment {

    //Cardio
    TREADMILL("BIEŻNIA", "Cardio", "Bieżnia elektryczna do biegania"),
    STATIONARY_BICYCLE("ROWEREK", "Cardio", "Rower elektryczny"),
    ROWING_MACHINE("WIOŚLARZ", "Cardio", "Wioślarz - symulator wiosłowania"),
    STAIR_CLIMBER("SCHODY AUTOMATYCZNE", "Cardio", "Maszyna do imitacji wchodzenia po schodach"),

    //Strength training
    BENCH_PRESS("ŁAWKA PŁASKA", "Wolne ciężary", "Ławka płaska do wyciskania sztangi"),
    DECLINE_BENCH("SKOS UJEMNY", "Wolne ciężary", "Ławka skos ujemny do wyciskania sztangi"),
    INCLINE_BENCH("ŁAWKA SKOŚNA", "Wolne ciężary", "Ławka skośna do wyciskania sztangi"),

    FREE_WEIGHT_BENCHES("ŁAWKA WOLNA", "Wolne ciężary", "Ławka wolnostojąca do wykorzystania z hantelkami"),
    CHEST_FLY_MACHINE("MASZYNA DO ROZPIĘTEK", "Wolne ciężary", "Maszyna do rozpiętek butterfly"),

    BICEP_CURL_BENCH_MACHINE("MASZYNA DO ZGIĘĆ RAMION", "Maszyny", "Maszyna do treningów mięśni dwugłowych ramienia"),
    BICEP_CURL_BENCH("MODLITEWNIK DO ZGIĘĆ RAMION", "Wolne ciężary", "Modlitewnik / Ławka do treningów mięśni dwugłowych ramienia"),

    ARM_EXTENSION_MACHINE("MASZYNA DO PROSTOWANIA RAMION", "TRICEPS", "Maszyna do treningów mięśni trójgłowych ramienia"),

    SHOULDER_PRESS_MACHINE("MASZYNA DO BARKÓW", "Maszyny", "Maszyna do treningów mięśni barków"),
    LATERAL_RAISES_MACHINE("MASZYNA DO BOCZNEGO AKTONU BARKÓW", "Maszyny", "Maszyna do treningów środkowego aktonu barków"),

    LAT_PULL_DOWN("WYCIĄG GÓRNY Z DRĄŻKIEM", "Maszyny", "Wyciąg górny do treningów pleców - imitacja podciągania"),
    ROW_BACK_MACHINE("MASZYNA DO WIOSŁOWANIA", "Maszyny", "Maszyna do wiosłowania"),
    STATIC_BARBELL_ROW("STATYCZNA SZTANGA DO WIOSŁOWANIA", "PLECY", "Statyczna sztanga do wiosłowania"),

    ABS_BENCH("ŁAWKA DO BRZUSKÓW", "BRZUCH", "Ławka do treningu środkowej sekcji brzucha w skosie ujemnym"),
    AB_CRUNCH_MACHINE("MASZYNA DO SKŁONÓW", "BRZUCH", "Maszyna do treningu środkowego aktonu brzucha"),

    LEG_PRESS_MACHINE("WYCISKANIE NOGAMI LEŻĄC", "Maszyny", "Maszyna do wyciskania ciężarów nogami leżąc"),
    LEG_EXTENSION_MACHINE("WYCISKANIE NOGAMI SIEDZĄC", "Maszyny", "Maszyna do wyciskania ciężarów nogami siedząc"),
    LEG_CURL_MACHINE("UGINANIE NÓG", "Maszyny", "Uginanie nóg siedząc mięśniami dwugłowymi"),
    SEATED_CALF_MACHINE("MASZYNA DO ŁYDEK", "Maszyny", "Unoszenie ciężaru przy użyciu łydek siedząc"),
    STANDING_CALF_MACHINE("MASZYNA DO ŁYDEK STOJĄC", "Maszyny", "Unoszenie ciężaru przy użyciu łydek stojąc"),
    HACK_SQUAT_MACHINE("MASZYNA DO PRZYSIADÓW", "Maszyny", "Maszyna do przysiadów z obciążeniem"),

    //SMALL EQUIPMENT
    JUMPING_ROPE("SKAKANKA", "Akcesoria", "Skakanka"),
    AB_ROLLER("ROLLER ABS", "Akcesoria", "Kółko do treningu mięśni brzucha"),
    MEDICINE_BALL("PIŁKI LEKARSKIE", "Akcesoria", "Piłki lekarskie z różnym obciążeniem"),
    RESISTANCE_BANDS("GUMY TRENINGOWE", "Akcesoria", "Gumy oporowe"),

    //FREE WEIGHTS
    KETTLEBELLS("KETTLEBELLE", "Akcesoria", "Kettle do treningu ogólnego"),
    DUMBELLS_SET("ZESTAW HANTLI", "Akcesoria", "Hantle do treningu ogólnego"),
    BARBELLS_SET("ZESTAW SZTANG Z OBCIĄŻENIEM", "Akcesoria", "Sztangi z zamontowanym ciężarem do treningu ogólnego"),
    BARBELL("SZTANGA", "Akcesoria", "Klasyczna sztanga"),

    //STATIC BIG EQUIPMENT
    LEG_RAISE_TOWER("MASZYNA DO DIPÓW/WZNOSÓW NÓG", "OGÓLNE", "Maszyna do wznosu nóg i dipów"),
    BOXING_BAG("WOREK TRENINGOWY", "BRZUCH", "Maszyna do treningu środkowego aktonu brzucha"),
    SMITH("MASZYNA SMITHA", "OGÓLNY", "Maszyna smitha"),
    CABLE_CROSSOVER_MACHINE("MASZYNA DO ROZPIĘTEK ATLAS", "OGÓLNY", "Maszyna z dwoma regulowanymi wyciągami i nakładkami"),
    POWER_RACK("KLATKA", "OGÓLNY", "Klatka uniwersalna do ćwiczeń np przysiadów, podciągania");

    private final String name;
    private final String category;
    private final String description;

    GymEquipment(String name, String category, String description){
        this.name = name;
        this.category = category;
        this.description = description;
    }
}
