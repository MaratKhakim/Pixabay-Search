package me.mrtkhkm.search_data

val validResponse = """
    {
	"total": 37098,
	"totalHits": 500,
	"hits": [
		"id": 2310212,
		"pageURL": "https://pixabay.com/illustrations/fruit-lemon-art-pattern-design-2310212/",
		"type": "illustration",
		"tags": "fruit, lemon, art",
		"previewURL": "https://cdn.pixabay.com/photo/2017/05/13/17/31/fruit-2310212_150.jpg",
		"previewWidth": 150,
		"previewHeight": 150,
		"webformatURL": "https://pixabay.com/get/g6498705d472f6ba77e99d925b50bb12a85ae5e321367c65a84d263fd475f96ebca88e8401af8a06294d2a60f81d184b1b2fe4f6a127e0c0fa89fbd7600265eaf_640.jpg",
		"webformatWidth": 640,
		"webformatHeight": 640,
		"largeImageURL": "https://pixabay.com/get/g25a04f9dc0805c22de375d39b55777fe0100705ff6716d83ece978b8a3c8388c73a79509c327af7f50ade4f45ca2853b2243638a37e74be95977390f69ecdaad_1280.jpg",
		"imageWidth": 2048,
		"imageHeight": 2048,
		"imageSize": 715632,
		"views": 212123,
		"downloads": 101433,
		"collections": 1662,
		"likes": 990,
		"comments": 173,
		"user_id": 1216526,
		"user": "Yousz",
		"userImageURL": ""
	}, {
		"id": 2305192,
		"pageURL": "https://pixabay.com/photos/fresh-fruits-bowls-fruit-bowls-2305192/",
		"type": "photo",
		"tags": "fresh fruits, bowls, fruit bowls",
		"previewURL": "https://cdn.pixabay.com/photo/2017/05/11/19/44/fresh-fruits-2305192_150.jpg",
		"previewWidth": 150,
		"previewHeight": 84,
		"webformatURL": "https://pixabay.com/get/g2536a9ce594843ea00369967cc67856427531952542adb14223058e8649c4a40c8e3ab35f041eb4d3290b315ec051d28ce8a6ec5df79d8e5f75ba499c5c8651f_640.jpg",
		"webformatWidth": 640,
		"webformatHeight": 359,
		"largeImageURL": "https://pixabay.com/get/g29b882cb957fc459e34a0e21ca7051d8b22e62cf02c2260007cd0433a5a590fdf3d9f570cd10301d778d84dbdc911552b89a3009d1de7b18c53e3125704fb822_1280.jpg",
		"imageWidth": 4000,
		"imageHeight": 2248,
		"imageSize": 2944985,
		"views": 451503,
		"downloads": 252083,
		"collections": 946,
		"likes": 1134,
		"comments": 228,
		"user_id": 3142410,
		"user": "silviarita",
		"userImageURL": "https://cdn.pixabay.com/user/2022/12/22/08-57-06-251_250x250.jpeg"
	}, {
		"id": 2367029,
		"pageURL": "https://pixabay.com/photos/watermelon-berry-fruit-heart-2367029/",
		"type": "photo",
		"tags": "watermelon, berry, fruit",
		"previewURL": "https://cdn.pixabay.com/photo/2017/06/02/18/24/watermelon-2367029_150.jpg",
		"previewWidth": 150,
		"previewHeight": 112,
		"webformatURL": "https://pixabay.com/get/g381b0028e2b7fb0352174c01270a798f8b3ec5a3a6c44aead38353d5c73863aad1ea04cd68ee2ecbe0424f1a76c9af384a2e6580f759895c4b83507c932b7161_640.jpg",
		"webformatWidth": 640,
		"webformatHeight": 480,
		"largeImageURL": "https://pixabay.com/get/g0831b84309fdfba28af9c366ebff118f3357f2e9317b05bcf67c3fc611dc21883a2a499ac3f3618f43c815fcafe1c1cf8cb4ccbbf1e2f049f4123cd97b2f37cb_1280.jpg",
		"imageWidth": 3264,
		"imageHeight": 2448,
		"imageSize": 2396557,
		"views": 599355,
		"downloads": 388827,
		"collections": 1058,
		"likes": 1355,
		"comments": 271,
		"user_id": 3142410,
		"user": "silviarita",
		"userImageURL": "https://cdn.pixabay.com/user/2022/12/22/08-57-06-251_250x250.jpeg"
	}, {
		"id": 2293337,
		"pageURL": "https://pixabay.com/photos/strawberry-splash-water-clean-water-2293337/",
		"type": "photo",
		"tags": "strawberry, splash, water",
		"previewURL": "https://cdn.pixabay.com/photo/2017/05/07/19/32/strawberry-2293337_150.jpg",
		"previewWidth": 150,
		"previewHeight": 82,
		"webformatURL": "https://pixabay.com/get/g43db9845ed7793f44d2ea09f0ca0977d455eb94b0905bc1a3361b68f90af78959cb45f84426674432c4adc3b199b76f67807a07dfe7e63e732519a4b7814f137_640.jpg",
		"webformatWidth": 640,
		"webformatHeight": 352,
		"largeImageURL": "https://pixabay.com/get/g68c88e1071f89af035e3e1dedcff1089aa1c544efd6e343b2b14b18d95d2bb4a6aea52ed4b349c5c7b598a6925f76864f6241896f3bdbb4b6ee776c1f43b0581_1280.jpg",
		"imageWidth": 3000,
		"imageHeight": 1650,
		"imageSize": 855858,
		"views": 319832,
		"downloads": 163924,
		"collections": 816,
		"likes": 863,
		"comments": 95,
		"user_id": 4845927,
		"user": "atlantis0815",
		"userImageURL": "https://cdn.pixabay.com/user/2017/03/31/23-06-55-143_250x250.jpg"
	}, {
		"id": 634572,
		"pageURL": "https://pixabay.com/photos/apples-fruits-red-ripe-vitamins-634572/",
		"type": "photo",
		"tags": "apples, fruits, red",
		"previewURL": "https://cdn.pixabay.com/photo/2015/02/13/00/43/apples-634572_150.jpg",
		"previewWidth": 100,
		"previewHeight": 150,
		"webformatURL": "https://pixabay.com / get / g65fe2b6acced002d066915b3cef7fa09b1e7d1432749bc9db4d0a248bf8ec9331db4b69001fcb0230221dbfb169688d9_640.jpg ",
		"webformatWidth ": 427,
		"webformatHeight ": 640,
		"largeImageURL ": "https: //pixabay.com/get/g90046d03047d40c505467bb2313a18af12b839189dc4081eb26916d9d6cd779f45a4550411742af5ad4909d042d30b38bc6305def1bc957b0bab85c5020774b2_1280.jpg",
		"imageWidth": 3345,
		"imageHeight": 5017,
		"imageSize": 811238,
		"views": 474537,
		"downloads": 277318,
		"collections": 1268,
		"likes": 2352,
		"comments": 194,
		"user_id": 752536,
		"user": "Desertrose7",
		"userImageURL": "https://cdn.pixabay.com/user/2016/03/14/13-25-18-933_250x250.jpg"
	}, {
		"id": 1973875,
		"pageURL": "https://pixabay.com/illustrations/flower-twig-corolla-wreath-lease-1973875/",
		"type": "illustration",
		"tags": "flower, twig, corolla",
		"previewURL": "https://cdn.pixabay.com/photo/2017/01/12/06/26/flowers-1973875_150.png",
		"previewWidth": 150,
		"previewHeight": 150,
		"webformatURL": "https://pixabay.com/get/g615df97ac7bae2bd84e2c454578a2e3af81b2249c52f5ab9b6552f785f1e8e8d998530e1c0937d5c38791f9a6da99ce09293ca772a134f9cbaa4e03e9b3fff2c_640.png",
		"webformatWidth": 640,
		"webformatHeight": 640,
		"largeImageURL": "https://pixabay.com/get/g39ce1e94c47a116611f508300acc9ecff804f48f3b330fa7bd5b2b194a1626b6fcd6d94a7fc6f849c15bd9f90a7df6ce52ba460cf975b4ddf08ce2926d8c2847_1280.png",
		"imageWidth": 4167,
		"imageHeight": 4167,
		"imageSize": 871837,
		"views": 972298,
		"downloads": 633535,
		"collections": 2164,
		"likes": 1577,
		"comments": 347,
		"user_id": 4244193,
		"user": "OHMAOH",
		"userImageURL": "https://cdn.pixabay.com/user/2017/01/12/06-23-29-350_250x250.png"
	}, {
		"id": 2023404,
		"pageURL": "https://pixabay.com/photos/raspberries-fresh-bowl-fruit-bowl-2023404/",
		"type": "photo",
		"tags": "raspberries, fresh, bowl",
		"previewURL": "https://cdn.pixabay.com/photo/2017/01/31/09/30/raspberries-2023404_150.jpg",
		"previewWidth": 150,
		"previewHeight": 99,
		"webformatURL": "https://pixabay.com/get/gdace8db1e69878a50267d477c62683be631291bcd36842279fa5c26e2c667e9c6c2a4377c2ae0b3fbf328c9c7c432d57e0ea5c8f6328fb97198d376ccc39e7d0_640.jpg",
		"webformatWidth": 640,
		"webformatHeight": 426,
		"largeImageURL": "https://pixabay.com/get/g2cbd6f76d83b5c3786ead27ca82a791103bc30526d303406d1b69d3df04b98d833dda6fd76de2d15544b74d9d4afd3bbcbdb0c1548e83ef0bec7a866f8d02b7e_1280.jpg",
		"imageWidth": 5643,
		"imageHeight": 3762,
		"imageSize": 10326529,
		"views": 355899,
		"downloads": 227537,
		"collections": 1027,
		"likes": 1096,
		"comments": 112,
		"user_id": 3938704,
		"user": "Daria-Yakovleva",
		"userImageURL": "https://cdn.pixabay.com/user/2016/12/06/15-05-11-524_250x250.jpg"
	}, {
		"id": 3359755,
		"pageURL": "https://pixabay.com/photos/strawberries-fruit-season-eating-3359755/",
		"type": "photo",
		"tags": "strawberries, fruit, season",
		"previewURL": "https://cdn.pixabay.com/photo/2018/04/29/11/54/strawberries-3359755_150.jpg",
		"previewWidth": 150,
		"previewHeight": 99,
		"webformatURL": "https://pixabay.com/get/gd34db36511ac26dae2c3ffbe1af6394ce518f68b6c9ff286856301a51bdc09b70b4db94ec4c7a5044b36dec18abff54c5d3f85e7204213d6c52d73bab0acf925_640.jpg",
		"webformatWidth": 640,
		"webformatHeight": 426,
		"largeImageURL": "https://pixabay.com/get/gabd9afaf58aeb2c721bb86c45b128c0a162d63e492b5eee343cbb25fb2ab940523fcdba68c4b0893128b6e055e04ff252e43edcb50627a0ce1be776e9e7e1151_1280.jpg",
		"imageWidth": 4358,
		"imageHeight": 2905,
		"imageSize": 1712866,
		"views": 266553,
		"downloads": 184086,
		"collections": 555,
		"likes": 681,
		"comments": 149,
		"user_id": 6355831,
		"user": "pasja1000",
		"userImageURL": "https://cdn.pixabay.com/user/2021/02/06/02-19-29-704_250x250.png"
	}, {
		"id": 1532300,
		"pageURL": "https://pixabay.com/photos/drink-glass-lime-mint-cold-fresh-1532300/",
		"type": "photo",
		"tags": "drink, glass, lime",
		"previewURL": "https://cdn.pixabay.com/photo/2016/07/21/11/17/drink-1532300_150.jpg",
		"previewWidth": 150,
		"previewHeight": 99,
		"webformatURL": "https://pixabay.com/get/g52b9785a22aa84f56c45b0f4d5be277548bc6652ec979e50e0702b29ad945a4e2a39bf34309ab3dc54dd800e6c87439456a41289a79ff3ac1f0ebd2ac4a2cdf5_640.jpg",
		"webformatWidth": 640,
		"webformatHeight": 426,
		"largeImageURL": "https://pixabay.com/get/g6711b05d2997061a51ad03d3603b64033138ea14ff00c29256ca14c065627f69108 f22670a95379d10e10f8eacf09f979d7ba9c4b00889973b8702b2f15df504_1280.jpg ",
		"imageWidth ": 5468,
		"imageHeight ": 3645,
		"imageSize ": 2600307,
		"views ": 313839,
		"downloads ": 174433,
		"collections ": 874,
		"likes ": 877,
		"comments ": 160,
		"user_id ": 1546875,
		"user ": "PhotoMIX - Company ",
		"userImageURL ": "https: //cdn.pixabay.com/user/2018/02/20/12-45-58-742_250x250.jpg"
	}, {
		"id": 1122537,
		"pageURL": "https://pixabay.com/photos/apple-water-droplets-fruit-moist-1122537/",
		"type": "photo",
		"tags": "apple, water droplets, fruit",
		"previewURL": "https://cdn.pixabay.com/photo/2016/01/05/13/58/apple-1122537_150.jpg",
		"previewWidth": 150,
		"previewHeight": 95,
		"webformatURL": "https://pixabay.com/get/g78a6898225124a7ee149a2601146f9c77755bcebf76515fcaa0d6524b03e569e453b25a7498ea9a85e8cb36dd35528310857f127540f44e66beca083be4afc71_640.jpg",
		"webformatWidth": 640,
		"webformatHeight": 409,
		"largeImageURL": "https://pixabay.com/get/g1535d2b65abc30a09e689373b5e09a8b153fa8048b42b36b1f008af80feb6311ddb3e0ed3b5d6b95c7f48b84205ec70532cbd5af1efdc992cfd434e3e7b778f7_1280.jpg",
		"imageWidth": 4752,
		"imageHeight": 3044,
		"imageSize": 5213632,
		"views": 324330,
		"downloads": 187435,
		"collections": 1032,
		"likes": 1144,
		"comments": 187,
		"user_id": 1445608,
		"user": "mploscar",
		"userImageURL": "https://cdn.pixabay.com/user/2016/01/05/14-08-20-943_250x250.jpg"
	}]
}
""".trimIndent()