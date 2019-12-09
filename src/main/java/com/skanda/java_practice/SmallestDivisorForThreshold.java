package com.skanda.java_practice;


class SmallestDivisorForThreshold {
    public static int smallestDivisor(int[] nums, int threshold) {
        boolean flag = true;
        int runningSum = 0;
        int divisor = 1;

        // There is a guaranteed answer,
        // so let's keep the loop running until we find the correct answer
        while (flag) {
            int i = 0;
            for (i = 0;
                 i < nums.length && runningSum <= threshold;     // Keep going until threshold not met
                 i++) {

                runningSum += roundDivisor(nums[i], divisor);
            }

            if (i == nums.length && runningSum <= threshold)        // All elements were accounted for
                break;

            // Increment divisor
            // Reset runningSum
            divisor += 1;
            runningSum = 0;
        }

        return divisor;
    }

    private static int roundDivisor(int dividend, int divisor) {
        int result = (int) Math.ceil((float) dividend / divisor);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{528754, 366632, 155274, 788101, 448133, 291313, 222891, 139423, 332231, 841586, 155540, 644464, 412897, 262060, 535056, 206895, 919471, 235483, 80807, 815743, 569496, 385618, 442119, 219734, 597515, 536495, 512624, 96972, 565481, 221452, 406218, 976445, 205832, 936777, 677607, 706808, 431578, 375281, 800941, 917370, 322671, 846342, 635404, 761096, 137404, 799625, 975277, 6095, 322878, 942330, 772415, 513589, 51836, 952651, 557125, 802428, 307271, 856909, 759476, 557231, 876085, 912912, 743731, 586284, 486703, 329891, 255865, 790230, 930183, 606859, 527914, 482369, 900891, 100884, 497332, 995846, 293592, 252599, 732325, 429951, 437140, 434629, 348926, 223753, 672742, 704572, 99761, 789824, 745852, 979591, 513359, 627100, 94874, 244516, 333890, 566768, 770471, 254362, 166663, 535689, 689568, 432325, 825940, 424739, 421634, 337429, 292840, 594494, 765255, 327133, 806545, 853413, 271406, 648421, 572577, 529048, 396715, 523880, 704378, 816196, 606472, 655764, 830364, 172843, 296202, 492700, 697833, 542123, 46045, 152410, 550419, 716537, 489613, 222352, 696825, 47136, 237508, 921098, 814087, 174382, 782071, 126605, 295702, 636786, 994227, 760787, 387639, 358849, 192933, 806089, 752506, 637570, 920560, 276629, 887689, 143373, 694013, 584350, 553645, 52921, 598291, 262192, 484352, 530886, 873462, 948181, 663492, 849459, 723145, 808422, 918533, 94419, 946711, 221620, 295017, 976019, 560589, 368538, 51716, 772560, 621518, 368663, 154588, 427469, 563615, 48124, 853067, 645316, 727989, 697781, 745774, 440041, 880373, 724056, 426370, 382854, 936752, 536573, 472018, 250755, 903895, 66437, 854431, 584985, 848590, 842467, 553529, 242965, 467337, 941039, 567799, 71725, 620230, 340028, 268641, 855695, 711836, 718836, 935674, 652572, 609729, 50171, 464014, 256964, 260959, 614100, 996663, 961965, 630374, 214906, 815050, 517741, 573238, 725491, 235045, 626867, 444547, 987322, 669964, 406198, 311700, 800480, 357892, 568137, 438799, 853301, 727321, 934637, 332257, 470969, 823847, 735085, 730105, 250481, 878493, 846819, 840672, 619639, 155914, 207791, 282306, 401254, 456773, 867391, 662309, 603693, 643586, 309041, 46918, 415276, 645919, 833687, 391069, 350707, 979831, 408399, 418753, 119852, 341864, 57285, 968765, 400503, 31101, 631230, 535744, 692397, 279116, 943509, 668707, 965662, 969275, 617941, 600302, 639807, 71876, 699029, 140163, 615822, 928313, 460944, 472153, 644476, 743035, 639774, 242865, 525527, 316949, 760609, 554903, 655952, 610530, 900392, 305844, 764537, 110763, 264541, 790389, 617384, 696998, 401456, 317695, 890602, 370138, 155340, 670510, 687071, 887990, 235897, 811473, 282185, 619260, 518265, 567051, 754780, 795934, 393795, 515641, 854639, 26067, 301299, 322606, 727678, 776843, 131020, 628982, 473639, 43438, 513342, 689378, 219106, 956554, 200206, 459850, 630640, 292644, 675254, 8485, 178795, 636017, 855404, 980281, 589876, 57928, 37053, 644220, 799286, 943956, 718613, 648413, 982106, 787313, 328538, 286384, 505991, 641200, 310126, 582271, 239198, 593102, 768949, 183452, 251999, 596894, 72827, 165163, 111536, 980798, 692061, 131691, 574044, 559, 687104, 339582, 249303, 354333, 333728, 843995, 157101, 595278, 99827, 775958, 278099, 636726, 948094, 156236, 638998, 988700, 188168, 479002, 844614, 428590, 68501, 864642, 959890, 847285, 759192, 600518, 613589, 302639, 599294, 253170, 890730, 441412, 687452, 642688, 875484, 826606, 122794, 655575, 688113, 556402, 619647, 639874, 684491, 313905, 978451, 635990, 148061, 878146, 519205, 455955, 389876, 746626, 520456, 452364, 17283, 128461, 642438, 454740, 920474, 960876, 663953, 375780, 765572, 593435, 5070, 782768, 202852, 524988, 213961, 851052, 596682, 228191, 711417, 934557, 966351, 850250, 190038, 785225, 619915, 99756, 527231, 273140, 101839, 976833, 667786, 842063, 983087, 666588, 868992, 113234, 147691, 287695, 335273, 798548, 710607, 613873, 540340, 998970, 502131, 968545, 281888, 719044, 24612, 593160, 116006, 615000, 309713, 401365, 21526, 249867, 310646, 67914, 515407, 826636, 958037, 862223, 784724, 27113, 82313, 715963, 178536, 520985, 570678, 425609, 877121, 65459, 609445, 521953, 359649, 904571, 749732, 994056, 641382, 125054, 659935, 433501, 406818, 444209, 794799, 472770, 487237, 98117, 190101, 509026, 390452, 144037, 586188, 870029, 498703, 565777, 550739, 692962, 322571, 21759, 51367, 136709, 707582, 518719, 898628, 97228, 534618, 535306, 102463, 280399, 648982, 942834, 314236, 410906, 270179, 232337, 414704, 397770, 969225, 651744, 466492, 178312, 14504, 746820, 612137, 6893, 414106, 469752, 160599, 157407, 241605, 401192, 240310, 776342, 399925, 961789, 694269, 308072, 296442, 466486, 486497, 689512, 990131, 162436, 37643, 639229, 420542, 857483, 552512, 294355, 186649, 277658, 474303, 35513, 3175, 719116, 623762, 363676, 168666, 912684, 662542, 305824, 529471, 233582, 55833, 696516, 778024, 278832, 166559, 238357, 636722, 872119, 896437, 630953, 552825, 886799, 570234, 728948, 54103, 584473, 971892, 566657, 950130, 369296, 586944, 149532, 426055, 98199, 154372, 172184, 495146, 534308, 885841, 102032, 2367, 35212, 18019, 506858, 82982, 116285, 275723, 998490, 954830, 531294, 994153, 314232, 216309, 495368, 895351, 904145, 639636, 24012, 364542, 732405, 24744, 734998, 968816, 666751, 33212, 951565, 811064, 675488, 755370, 916931, 351258, 67355, 669012, 301935, 859230, 521880, 799350, 83189, 521112, 717145, 488520, 826792, 734114, 44398, 409935, 767846, 492472, 923395, 300335, 403100, 97907, 693059, 651620, 260565, 507340, 471374, 504246, 419198, 440409, 91546, 523653, 756987, 714893, 927616, 630264, 948213, 684022, 621703, 19076, 40595, 231252, 391375, 405564, 162332, 541351, 369989, 828885, 905783, 587091, 358284, 260986, 788793, 567003, 62877, 357800, 607584, 906911, 375024, 990084, 612557, 974621, 431919, 992429, 275725, 663990, 218075, 679802, 517921, 665416, 532022, 950941, 311770, 542313, 48796, 342317, 588910, 964550, 40277, 537817, 605353, 865995, 61583, 62709, 684471, 267516, 941232, 391206, 69237, 674036, 32127, 901853, 178874, 682007, 451493, 407536, 977864, 966739, 450057, 276337, 255346, 234562, 302137, 559711, 86385, 931023, 743616, 127129, 214820, 99816, 18167, 352059, 427953, 39635, 751685, 130772, 883554, 482401, 211904, 977714, 641844, 762656, 141930, 507329, 554846, 283602, 895336, 331031, 271939, 737700, 351796, 598426, 186891, 349055, 624919, 432953, 17133, 789051, 16200, 569647, 124838, 792202, 835554, 734087, 26169, 387484, 460736, 638747, 688482, 598510, 256592, 10722, 474992, 745304, 490366, 403524, 972001, 641136, 854003, 746108, 59009, 874031, 794770, 149170, 12187, 683877, 779412, 855010, 24854, 172033, 81095, 423310, 686845, 624859, 762831, 101724, 858910, 598645, 951583, 466769, 780669, 224010, 893498, 123851, 586793, 297514, 427248, 816804, 361786, 537557, 194874, 88306, 33264, 322782, 93587, 585634, 314924, 142908, 878162, 537930, 967374, 526005, 690928, 856082, 707708, 660739, 10889, 479221, 484201, 851548, 834648, 606429, 407777, 22983, 214149, 801881, 937568, 847155, 819267, 900817, 749641, 265681, 895571, 405709, 646793, 932159, 488650, 498990, 875836, 677074, 467922, 170277, 396806, 239243, 354468, 332639, 762158, 293769, 348545, 514945, 757909, 713067, 394546, 936640, 730599, 441743, 552073, 358926, 469565, 295013, 176680, 62210, 695649, 192633, 536522, 783293, 408238, 33637, 485735, 447892, 714632, 9484, 158195, 976780, 601796, 542598, 869447, 484991, 541971, 170607, 191938, 893372, 289874, 650001, 530523, 544433, 546862, 684641, 620289, 463736, 627283, 501866, 502435, 274716, 42897, 150198, 878525, 490923, 459403, 734611, 190765, 912270, 749235, 644133, 27393, 713400, 948388, 831026, 694993, 543482, 105818, 864614, 533081, 201806, 595038, 940069, 59424, 915295, 467101, 205222, 92423, 616946, 517544, 911021, 255690, 583369, 303309, 263797, 884976, 557308, 889741, 364168, 698907, 7124, 263738, 649760, 178405, 315314, 451913, 809134, 846482, 445128};
        int threshold = 4641;
        System.out.println(smallestDivisor(arr, threshold));
    }
}