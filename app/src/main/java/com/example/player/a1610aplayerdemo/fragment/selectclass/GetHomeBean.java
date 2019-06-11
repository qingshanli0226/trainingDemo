package com.example.player.a1610aplayerdemo.tokendemo;

import java.util.List;

public class GetHomeBean {

    /**
     * success : true
     * message :
     * code : success
     * data : {"homeBanner":[{"title":"童声演唱技巧课","bannerUrl":"http://ali-files.yooshow
     * .com/2018/02/05/7206926d-7780-46cb-ac60-e7b1abf44bbd.jpg","bannerType":2,
     * "relationInfo":"225","moduletype":0,"showIndex":0,"courseType":1,"liveStatus":0,
     * "liveIsBuy":false},{"title":"huiyuan","bannerUrl":"http://ali-files.yooshow
     * .com/2019/01/23/2dfbe2e2-90d8-4dbe-a267-ebb4d46d006c.png","bannerType":3,
     * "relationInfo":"16","moduletype":0,"showIndex":1,"courseType":0,"liveStatus":0,
     * "liveIsBuy":false},{"title":"即兴伴奏","bannerUrl":"http://ali-files.yooshow
     * .com/2019/04/09/59046a34-fe57-423d-a1e1-9876682a3f00.png","bannerType":2,
     * "relationInfo":"367","moduletype":0,"showIndex":1,"courseType":1,"liveStatus":0,
     * "liveIsBuy":false},{"title":"科学用嗓护嗓，帮你塑造好声音","bannerUrl":"http://ali-files.yooshow
     * .com/2019/04/22/8ab9ea63-3907-42a3-af58-b8c54043581a.png","bannerType":1,
     * "relationInfo":"294","moduletype":0,"showIndex":1,"courseType":0,"liveStatus":0,
     * "liveIsBuy":false},{"title":"从零开始学钢琴","bannerUrl":"http://ali-files.yooshow
     * .com/2019/03/15/56c45625-7ae4-4a04-9486-04976da5acb4.png","bannerType":2,
     * "relationInfo":"360","moduletype":0,"showIndex":3,"courseType":1,"liveStatus":0,
     * "liveIsBuy":false},{"title":"开课啦：音乐剧教学法高级班启幕","bannerUrl":"http://ali-files.yooshow
     * .com/2019/03/22/0495e6e6-aab5-4cf4-9775-cd603711aa0f.png","bannerType":0,
     * "relationInfo":"http://mp.weixin.qq
     * .com/s?__biz=MzUzNDY0NjQ1NQ==&mid=100001231&idx=1&sn=1773fac8091daed5f00e02e4a8da5a0c
     * &chksm=7a90de174de7570117cc57bb42792a9ed136424bc972eb9106e19ba187e30681cef87f008592#rd&tm
     * =1556084244456","moduletype":0,"showIndex":4,"courseType":0,"liveStatus":0,
     * "liveIsBuy":false},{"title":"奥尔福","bannerUrl":"http://ali-files.yooshow
     * .com/2017/05/02/ea3d9f06-31b5-4cd0-afe3-ea01a342867e.png","bannerType":2,
     * "relationInfo":"70","moduletype":0,"showIndex":5,"courseType":1,"liveStatus":0,
     * "liveIsBuy":false},{"title":"2019年展演专家指南","bannerUrl":"http://ali-files.yooshow
     * .com/2019/04/09/f2cea0d5-1281-4481-bd8e-11068ef0d982.png","bannerType":2,
     * "relationInfo":"364","moduletype":0,"showIndex":10,"courseType":1,"liveStatus":0,
     * "liveIsBuy":false}],"homeCategory":[{"title":"音乐课堂","bannerUrl":"http://ali-files.yooshow
     * .com/2019/03/22/44e8bb6f-f9e5-4442-9d8f-91b9d0fd9162.png","bannerType":2,
     * "relationInfo":"1","moduletype":1,"showIndex":1},{"title":"在线直播","bannerUrl":"http://ali
     * -files.yooshow.com/2019/03/18/6c2cb03e-551b-4c98-b6d9-35dc93d94456.png","bannerType":1,
     * "relationInfo":"2","moduletype":1,"showIndex":2},{"title":"种子教师","bannerUrl":"http://ali
     * -files.yooshow.com/2019/03/18/eb1df3c5-a45f-4cb8-b381-7a9d40d0ca02.png","bannerType":2,
     * "relationInfo":"27","moduletype":1,"showIndex":3},{"title":"央音展演","bannerUrl":"http://ali
     * -files.yooshow.com/2019/01/23/de21f820-68c2-4813-954d-4b8975651935.png","bannerType":0,
     * "relationInfo":"http://m.immedc.com/html5/yszy/index.html","moduletype":1,"showIndex":4},{
     * "title":"教育联盟","bannerUrl":"http://ali-files.yooshow
     * .com/2019/03/18/bce5314c-0d16-4eaa-b591-9228a7e4a84b.png","bannerType":0,
     * "relationInfo":"http://m.immedc.com/html5/lm/index1.html?v=17.5.11","moduletype":1,
     * "showIndex":5},{"title":"名家名师","bannerUrl":"http://ali-files.yooshow
     * .com/2019/03/18/e852c99e-519a-4ee6-bb02-67ca4c07ae47.png","bannerType":2,
     * "relationInfo":"6","moduletype":1,"showIndex":6},{"title":"音乐入门","bannerUrl":"http://ali
     * -files.yooshow.com/2019/03/18/23879f19-f6b5-46ec-afc5-883325987047.png","bannerType":2,
     * "relationInfo":"28","moduletype":1,"showIndex":7},{"title":"央音乐坊","bannerUrl":"http://ali
     * -files.yooshow.com/2019/03/18/22d8b54b-29f0-4d22-98b2-570ce88f44a7.png","bannerType":0,
     * "relationInfo":"http://m.immedc.com/html5/yyyf/index.html","moduletype":1,"showIndex":8}],
     * "courseRecommends":[{"appTitle":"钢琴","imageUrl":"http://ali-files.yooshow
     * .com/2019/03/15/730ee5a7-70c8-4bc8-b790-390001ffa742.png","courseUrl":"360","showIndex":1,
     * "courseId":360,"coursePrice":380,"teacherName":"童薇","teacherTitle":"中央音乐学院钢琴系副教授",
     * "courseIntroduce":"\r\n适用人群：0基础想要学钢琴的朋友（建议12岁以上）\r\n          教钢琴的老师\r\n\r\n童薇老师课程介绍\r\n
     * \u201c央音在线\u201d充分发挥学院在音乐教育领域中特有优势，将专业权威的师资，先进教学理念结合互联网+思维，精心打造综合创新的在线教育平台。\r\n在\u201c
     * 央音在线\u201d,
     * 您可以跟随专家从基础开始系统化学习，打下最坚实的音乐基础；可以观看专家随堂课，置身于最高音乐学府的真实课堂，感受学院大师风采，接受最权威的音乐理念；还可以欣赏独播的丰富类型的音乐会，专家讲座，大师直播互动等，与专家进行面对面的交流，帮您解答学习中的困惑。平台课程内容丰富，涵盖音乐学院各专业，包括：音乐基础，通史类课程，钢琴、声歌、管弦乐、民族器乐等各表演类课程，家长课堂及一些特色栏目。适合广大音乐学习者，音乐教育老师，专业演员、音乐爱好者升级加分。"},{"appTitle":"童声演唱技巧","imageUrl":"http://ali-files.yooshow.com/2018/02/05/7206926d-7780-46cb-ac60-e7b1abf44bbd.jpg","courseUrl":"225","showIndex":1,"courseId":225,"coursePrice":140,"teacherName":"张莉莉","teacherTitle":"中央歌剧院青年女高音歌唱家","courseIntroduce":"在声乐学习中，通常把6-12岁儿童的声乐培养称之为童声演唱训练，童声演唱训练作为声乐教学的启蒙期，其重要性不言而喻。童声期不仅是声乐学习的起点，还决定着音乐生涯的长度。\r\n中央音乐学院张莉莉老师将带领大家系统的学习这门课程，帮助学生培养音乐兴趣，提升音乐素养与气质。\r\n\r\n童声演唱技巧课程列表：\r\n1、童声演唱技巧中的歌曲方向和音准；\r\n2、童声演唱中的发音练习和母音练习；\r\n3、童声演唱中的呼吸运用；\r\n4、发声的连音和跳音练习方法；\r\n5、yu母音发音练习；\r\n6、a e母音连续发音练习；\r\n7、作品和发音练习；"},{"appTitle":"勃拉姆斯弦乐四重奏Op.51 No.2","imageUrl":"http://ali-files.yooshow.com/2018/07/11/71a9ca02-5725-4613-b081-bce71834c8ab.png","courseUrl":"284","showIndex":2,"courseId":284,"coursePrice":35,"teacherName":"杨一晨","teacherTitle":"中央音乐学院管弦系","courseIntroduce":"【课程简介】\r\n杨一晨老师携中央音乐学院大一弦乐四重奏乐团，为大家带来勃拉姆斯弦乐四重奏Op.51 No.2，这首曲子最能展现勃拉姆斯式的音乐张力，是勃拉  2000   斯室内乐作品中的经典曲目。\r\n\r\n【适用人群】\r\n弦乐高级学习者。"},{"appTitle":"小号专业课程Sonata奏鸣曲","imageUrl":"http://ali-files.yooshow.com/2018/07/13/d216aaec-b8a7-4464-97e8-48c1b8cb1f3c.jpg","courseUrl":"288","showIndex":2,"courseId":288,"coursePrice":35,"teacherName":"戴中晖","teacherTitle":"中央音乐学院管弦系教授 中国音协管乐协会副主席","courseIntroduce":"【作曲家】Kent Kennan K  肯纳（美国）\r\n\r\n【曲目介绍】\r\n肯纳《为小号而作的奏鸣曲》是20世纪最为成功的小号作品之一，时至今日，依然作为各音乐院校教学的标准曲目，受到广泛传播。\r\n\r\n【适用人群】\r\n初、中、高级小号专业学习者。"},{"appTitle":"钢琴作品的演奏与教学","imageUrl":"http://ali-files.yooshow.com/2018/07/12/0d8e9f36-cb16-4055-90b3-52ce14308ef5.jpg","courseUrl":"286","showIndex":2,"courseId":286,"coursePrice":60,"teacherName":"智园行方","teacherTitle":"中央音乐学院钢琴系","courseIntroduce":"【课程简介】\r\n课程包含：肖邦《黑键练习曲》和巴赫十二平均律《BWV862》。\r\n\r\n1、肖邦《黑键练习曲》是肖邦练习曲中比较著名的一首曲子，智园行方老师教你处理练习曲技巧、情感、音乐层次，以及本曲的表现力、风格的把握。\r\n\r\n2、巴赫十二平均律《BWV862》是一首典型的复调作品。\r\n\r\n"},{"appTitle":"双簧管","imageUrl":"http://ali-files.yooshow.com/2018/12/03/b46298fc-007e-47fe-ba20-457bc54cb214.jpg","courseUrl":"330","showIndex":3,"courseId":330,"coursePrice":105,"teacherName":"金京春","teacherTitle":"中央音乐学院双簧管教授 北京交响乐团担任双簧管首席","courseIntroduce":"课程简介:半音阶体系技术、循环呼吸、双吐\r\n课程包简介:半音阶体系技术的练习，循环呼吸及双吐的运用。\r\n\r\n金京春简介：金京春出生在双簧管世家。1987年考入中央音乐学院附中，师从我国著名的双簧管教育家祝盾教授。1997年毕业于中央音乐学院，并留校任教。2001进入北京交响乐团担任双簧管首席。2003年被教育部国家留学基金委公派赴俄罗斯莫斯科格涅辛音乐学院攻读硕士学位，师从于pusheechnikov院士学习。现于中央音乐学院附中任教。"}],"masterLives":[{"appTitle":"科学用嗓护嗓，帮你塑造好声音","imageUrl":"http://ali-files.yooshow.com/2019/04/22/7e584782-6f63-4cf8-874c-bd770e399068.png","liveId":294,"showIndex":1,"price":35,"teacherId":106,"teacherName":"韩丽艳","teacherTitle":"中央音乐学院声歌系","liveIsBuy":false,"liveStatus":0},{"appTitle":"中央音乐学院首部原创大型歌剧《山海经·奔月》","imageUrl":"http://ali-files.yooshow.com/2018/03/06/69debe8c-4e73-463e-9e4c-a493c9a722cf.jpg","liveId":211,"showIndex":4,"price":100,"teacherId":113,"teacherName":"周海宏","teacherTitle":"中央音乐学院音乐学系","liveIsBuy":false,"liveStatus":2},{"appTitle":"如何平衡音乐考级与兴趣培养","imageUrl":"http://ali-files.yooshow.com/2017/06/06/726b540f-f9f0-4d95-8759-24a75afbcda8.jpg","liveId":110,"showIndex":5,"price":25,"teacherId":113,"teacherName":"周海宏","teacherTitle":"中央音乐学院音乐学系","liveIsBuy":false,"liveStatus":2},{"appTitle":"声乐演唱技巧","imageUrl":"http://ali-files.yooshow.com/2017/06/06/22811832-d796-4fa1-9d38-acd6fb49c7d3.jpg","liveId":112,"showIndex":5,"price":100,"teacherId":116,"teacherName":"李双江","teacherTitle":"中国男高音、声乐教育家","liveIsBuy":false,"liveStatus":2},{"appTitle":"民族声乐发声技巧","imageUrl":"http://ali-files.yooshow.com/2017/06/22/7759292c-fd07-429b-b4a6-9889ca204c8f.jpg","liveId":113,"showIndex":5,"price":100,"teacherId":115,"teacherName":"李谷一","teacherTitle":"中国著名女高音歌唱家","liveIsBuy":false,"liveStatus":2},{"appTitle":"小朋友也可以轻松学会的\u201c美国第二国歌\u201d","imageUrl":"http://ali-files.yooshow.com/2018/05/09/ddc7ccae-8352-45eb-8674-d0a6c22b289a.png","liveId":218,"showIndex":6,"price":25,"teacherId":74,"teacherName":"刘俊","teacherTitle":"中央音乐学院现代远程音乐教育学院兼职老师","liveIsBuy":false,"liveStatus":2},{"appTitle":"小朋友也可以轻松学会的\u201c美国第二国歌\u201d(二）","imageUrl":"http://ali-files.yooshow.com/2018/05/31/09e58785-f9de-48f2-99bb-1b87258d3511.png","liveId":231,"showIndex":7,"price":25,"teacherId":74,"teacherName":"刘俊","teacherTitle":"中央音乐学院现代远程音乐教育学院兼职老师","liveIsBuy":false,"liveStatus":2},{"appTitle":"\u201c中速\u201d带来的《爱的协奏曲》","imageUrl":"http://ali-files.yooshow.com/2018/06/22/efcf70b7-e3f4-48a2-a81e-9bbfdc241327.jpg","liveId":240,"showIndex":8,"price":25,"teacherId":74,"teacherName":"刘俊","teacherTitle":"中央音乐学院现代远程音乐教育学院兼职老师","liveIsBuy":false,"liveStatus":2},{"appTitle":"十分调皮的八分音符","imageUrl":"http://ali-files.yooshow.com/2018/06/14/51ecc626-db07-435c-934e-6dfcaf105012.jpg","liveId":237,"showIndex":9,"price":25,"teacherId":74,"teacherName":"刘俊","teacherTitle":"中央音乐学院现代远程音乐教育学院兼职老师","liveIsBuy":false,"liveStatus":2},{"appTitle":"八分音符的朋友\u2014\u2014八分休止符","imageUrl":"http://ali-files.yooshow.com/2018/07/11/0f4300bf-79b5-415c-a8bc-3e56695de362.jpg","liveId":242,"showIndex":10,"price":25,"teacherId":74,"teacherName":"刘俊","teacherTitle":"中央音乐学院现代远程音乐教育学院兼职老师","liveIsBuy":false,"liveStatus":2},{"appTitle":"《和\u201c音\u201d同光》 中央音乐学院与上海音乐学院交流音乐会","imageUrl":"http://ali-files.yooshow.com/2018/10/11/fe24e113-927f-4735-8c21-7fa1dfa9d5da.jpg","liveId":265,"showIndex":10,"price":0,"teacherId":183,"teacherName":"中央音乐学院","teacherTitle":"中央音乐学院","liveIsBuy":false,"liveStatus":2},{"appTitle":"指尖上的旋律\u2014\u2014献给孩子们的钢琴赏析音乐会","imageUrl":"http://ali-files.yooshow.com/2018/07/11/4816899c-42cc-41b1-9f8d-215b6d909fe2.jpg","liveId":235,"showIndex":11,"price":0,"teacherId":117,"teacherName":"中央音乐学院出版社","teacherTitle":"中央音乐学院出版社","liveIsBuy":false,"liveStatus":2},{"appTitle":"《大国之音》 民乐专场音乐会","imageUrl":"http://ali-files.yooshow.com/2018/10/11/61b83ab6-f30a-4a8c-ae58-a92d025b10ef.jpg","liveId":267,"showIndex":11,"price":0,"teacherId":183,"teacherName":"中央音乐学院","teacherTitle":"中央音乐学院","liveIsBuy":false,"liveStatus":2},{"a 1ea1 ppTitle":"\u201c弥漫的心\u201d华人女作曲家现代双钢琴作品集","imageUrl":"http://ali-files.yooshow.com/2018/05/25/644f0fd1-4163-45aa-b23d-5efd79fd8861.jpg","liveId":229,"showIndex":12,"price":0,"teacherId":117,"teacherName":"中央音乐学院出版社","teacherTitle":"中央音乐学院出版社","liveIsBuy":false,"liveStatus":2},{"appTitle":"《走出象牙塔》 中央音乐学院作曲家影视作品音乐会","imageUrl":"http://ali-files.yooshow.com/2018/10/18/1208e5f1-d305-4868-8b49-1aa8bb9ef59f.jpg","liveId":268,"showIndex":12,"price":0,"teacherId":183,"teacherName":"中央音乐学院","teacherTitle":"中央音乐学院","liveIsBuy":false,"liveStatus":2},{"appTitle":"中央音乐学院首部原创大型歌剧《山海经·奔月》","imageUrl":"http://ali-files.yooshow.com/2018/03/06/d2a87e16-d322-4bfd-86db-0faff828efdb.jpg","liveId":212,"showIndex":13,"price":100,"teacherId":113,"teacherName":"周海宏","teacherTitle":"中央音乐学院音乐学系","liveIsBuy":false,"liveStatus":2},{"appTitle":"全本孙文明二胡作品音乐会","imageUrl":"http://ali-files.yooshow.com/2018/10/11/4b297c63-66e9-4cc0-929a-aa1794348f4e.jpg","liveId":264,"showIndex":13,"price":0,"teacherId":183,"teacherName":"中央音乐学院","teacherTitle":"中央音乐学院","liveIsBuy":false,"liveStatus":2},{"appTitle":"《奇弈记》 \u2014\u2014开幕式音乐会","imageUrl":"http://ali-files.yooshow.com/2018/10/11/7a43d1f2-ed97-4c95-a519-1da2c02ae59e.jpg","liveId":261,"showIndex":14,"price":0,"teacherId":183,"teacherName":"中央音乐学院","teacherTitle":"中央音乐学院","liveIsBuy":false,"liveStatus":2},{"appTitle":"歌剧《山海经·奔月》","imageUrl":"http://ali-files.yooshow.com/2018/03/06/cedbe007-24f3-429d-b47e-1bfe9d0baf48.jpg","liveId":210,"showIndex":15,"price":100,"teacherId":113,"teacherName":"周海宏","teacherTitle":"中央音乐学院音乐学系","liveIsBuy":false,"liveStatus":2},{"appTitle":"德奥艺术歌曲之夜","imageUrl":"http://ali-files.yooshow.com/2018/09/20/1939dd79-f657-4817-9cd7-9be037031566.png","liveId":260,"showIndex":15,"price":0,"teacherId":185,"teacherName":"张璋","teacherTitle":"中央音乐学院声乐歌剧系主科教师青年女高音歌唱家","liveIsBuy":false,"liveStatus":2},{"appTitle":"《不可思\u201c议\u201d》学生原创作品音乐会","imageUrl":"http://ali-files.yooshow.com/2018/10/11/48e0b61d-22aa-4497-8b0f-72719189dbfa.jpg","liveId":262,"showIndex":16,"price":0,"teacherId":183,"teacherName":"中央音乐学院","teacherTitle":"中央音乐学院","liveIsBuy":false,"liveStatus":2},{"appTitle":"《春天的故事》中国七八十年代歌曲演唱会","imageUrl":"http://ali-files.yooshow.com/2018/10/11/ca7ad50f-c8fa-4f7e-8745-410fadfc3545.jpg","liveId":263,"showIndex":17,"price":0,"teacherId":183,"teacherName":"中央音乐学院","teacherTitle":"中央音乐学院","liveIsBuy":false,"liveStatus":2},{"appTitle":"刘俊音乐素养课","imageUrl":"http://ali-files.yooshow.com/2018/07/20/28c440a2-0587-4f15-b891-c1fcec7a8ffe.jpg","liveId":254,"showIndex":31,"price":0,"teacherId":74,"teacherName":"刘俊","teacherTitle":"中央音乐学院现代远程音乐教育学院兼职老师","liveIsBuy":false,"liveStatus":2},{"appTitle":"孙媛媛声乐演唱技巧课","imageUrl":"http://ali-files.yooshow.com/2018/07/20/8a47f39c-8347-4df5-ac7a-2ba17a2886da.jpg","liveId":257,"showIndex":44,"price":0,"teacherId":184,"teacherName":"孙媛媛","teacherTitle":"中央音乐学院声歌系教授","liveIsBuy":false,"liveStatus":2}],"zlList":[{"id":20,"title":"走进鲁特琴的世界","image":"http://ali-files.yooshow.com/2017/10/09/76cd8503-d146-4774-8078-d6f739fd5aa3.jpg","showIndex":1,"isQa":0,"qaPrice":0,"percentage":0,"ccomPercentage":0,"teacherPercentage":0,"teacherName":"陈谊","passportId":0},{"id":6,"title":"嗓音诊疗室","image":"http://ali-files.yooshow.com/2017/09/26/316f2c0c-7ab4-443a-bd81-16249fd04351.jpg","showIndex":1,"isQa":1,"qaPrice":0,"percentage":0,"ccomPercentage":0,"teacherPercentage":0,"teacherName":"韩丽艳","passportId":0},{"id":1,"title":"海宏会客厅","image":"http://ali-files.yooshow.com/2017/06/20/f6bd42cb-fc83-41fa-a017-5fe1731724bb.jpg","showIndex":3,"isQa":0,"qaPrice":0,"percentage":0,"ccomPercentage":0,"teacherPercentage":0,"teacherName":"周海宏","passportId":0},{"id":23,"title":"社区音乐","image":"http://ali-files.yooshow.com/2019/03/04/cdb5d2c9-cd52-4d4e-8428-e37b8b8801a9.jpg","showIndex":4,"isQa":1,"qaPrice":0,"percentage":0,"ccomPercentage":0,"teacherPercentage":0,"teacherName":"姚侃","passportId":0}],"shareView":{"sharePic":"http://ali-files.yooshow.com/app/yangyin/default-red-share.png","shareTitle":"免费加入\u201c全国音乐教师联盟\u201d并送价值500元的线上课程。","shareUrl":"http://m.immedc.com/lmhd/download","shareContent":"\"全国音乐教师联盟\"大礼包免费抢"},"vipRecommend":[{"id":1173,"title":"家长音乐素养必修课","image":"http://ali-files.yooshow.com/2019/01/13/bd7e9186-2168-489f-b9c4-11079dcc773e.jpg","dataType":2,"dataId":305,"created":"2019-04-04 11:37:06","text1":"会员优享","price":0,"vip":false,"buy":false},{"id":1174,"title":"闹元宵的演奏技巧","image":"http://ali-files.yooshow.com/2019/03/01/fe8024c2-2cf4-47c9-a8b3-1a3623ee80dd.png","dataType":2,"dataId":350,"created":"2019-03-13 10:02:01","text1":"会员优享","price":0,"vip":false,"buy":false},{"id":1175,"title":"戴玉强声乐大师课","image":"http://ali-files.yooshow.com/2017/08/31/b956483b-91c1-41a7-89e4-c784d0030a54.jpg","dataType":2,"dataId":315,"created":"2019-04-04 11:36:01","text1":"会员优享","price":0,"vip":false,"buy":false},{"id":1176,"title":"李谷一声乐大师课","image":"http://ali-files.yooshow.com/2017/06/22/913680e7-281a-40a6-83d2-15dc257708ea.jpg","dataType":2,"dataId":316,"created":"2019-04-15 12:05:35","text1":"会员优享","price":0,"vip":false,"buy":false}]}
     */

    private boolean success;
    private String message;
    private String code;
    private DataBean data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * homeBanner : [{"title":"童声演唱技巧课","bannerUrl":"http://ali-files.yooshow
         * .com/2018/02/05/7206926d-7780-46cb-ac60-e7b1abf44bbd.jpg","bannerType":2,
         * "relationInfo":"225","moduletype":0,"showIndex":0,"courseType":1,"liveStatus":0,
         * "liveIsBuy":false},{"title":"huiyuan","bannerUrl":"http://ali-files.yooshow
         * .com/2019/01/23/2dfbe2e2-90d8-4dbe-a267-ebb4d46d006c.png","bannerType":3,
         * "relationInfo":"16","moduletype":0,"showIndex":1,"courseType":0,"liveStatus":0,
         * "liveIsBuy":false},{"title":"即兴伴奏","bannerUrl":"http://ali-files.yooshow
         * .com/2019/04/09/59046a34-fe57-423d-a1e1-9876682a3f00.png","bannerType":2,
         * "relationInfo":"367","moduletype":0,"showIndex":1,"courseType":1,"liveStatus":0,
         * "liveIsBuy":false},{"title":"科学用嗓护嗓，帮你塑造好声音","bannerUrl":"http://ali-files.yooshow
         * .com/2019/04/22/8ab9ea63-3907-42a3-af58-b8c54043581a.png","bannerType":1,
         * "relationInfo":"294","moduletype":0,"showIndex":1,"courseType":0,"liveStatus":0,
         * "liveIsBuy":false},{"title":"从零开始学钢琴","bannerUrl":"http://ali-files.yooshow
         * .com/2019/03/15/56c45625-7ae4-4a04-9486-04976da5acb4.png","bannerType":2,
         * "relationInfo":"360","moduletype":0,"showIndex":3,"courseType":1,"liveStatus":0,
         * "liveIsBuy":false},{"title":"开课啦：音乐剧教学法高级班启幕","bannerUrl":"http://ali-files.yooshow
         * .com/2019/03/22/0495e6e6-aab5-4cf4-9775-cd603711aa0f.png","bannerType":0,
         * "relationInfo":"http://mp.weixin.qq
         * .com/s?__biz=MzUzNDY0NjQ1NQ==&mid=100001231&idx=1&sn=1773fac8091daed5f00e02e4a8da5a0c
         * &chksm=7a90de174de7570117cc57bb42792a9ed136424bc972eb9106e19ba187e30681cef87f008592#rd
         * &tm=1556084244456","moduletype":0,"showIndex":4,"courseType":0,"liveStatus":0,
         * "liveIsBuy":false},{"title":"奥尔福","bannerUrl":"http://ali-files.yooshow
         * .com/2017/05/02/ea3d9f06-31b5-4cd0-afe3-ea01a342867e.png","bannerType":2,
         * "relationInfo":"70","moduletype":0,"showIndex":5,"courseType":1,"liveStatus":0,
         * "liveIsBuy":false},{"title":"2019年展演专家指南","bannerUrl":"http://ali-files.yooshow
         * .com/2019/04/09/f2cea0d5-1281-4481-bd8e-11068ef0d982.png","bannerType":2,
         * "relationInfo":"364","moduletype":0,"showIndex":10,"courseType":1,"liveStatus":0,
         * "liveIsBuy":false}]
         * homeCategory : [{"title":"音乐课堂","bannerUrl":"http://ali-files.yooshow
         * .com/2019/03/22/44e8bb6f-f9e5-4442-9d8f-91b9d0fd9162.png","bannerType":2,
         * "relationInfo":"1","moduletype":1,"showIndex":1},{"title":"在线直播",
         * "bannerUrl":"http://ali-files.yooshow
         * .com/2019/03/18/6c2cb03e-551b-4c98-b6d9-35dc93d94456.png","bannerType":1,
         * "relationInfo":"2","moduletype":1,"showIndex":2},{"title":"种子教师",
         * "bannerUrl":"http://ali-files.yooshow
         * .com/2019/03/18/eb1df3c5-a45f-4cb8-b381-7a9d40d0ca02.png","bannerType":2,
         * "relationInfo":"27","moduletype":1,"showIndex":3},{"title":"央音展演",
         * "bannerUrl":"http://ali-files.yooshow
         * .com/2019/01/23/de21f820-68c2-4813-954d-4b8975651935.png","bannerType":0,
         * "relationInfo":"http://m.immedc.com/html5/yszy/index.html","moduletype":1,
         * "showIndex":4},{"title":"教育联盟","bannerUrl":"http://ali-files.yooshow
         * .com/2019/03/18/bce5314c-0d16-4eaa-b591-9228a7e4a84b.png","bannerType":0,
         * "relationInfo":"http://m.immedc.com/html5/lm/index1.html?v=17.5.11","moduletype":1,
         * "showIndex":5},{"title":"名家名师","bannerUrl":"http://ali-files.yooshow
         * .com/2019/03/18/e852c99e-519a-4ee6-bb02-67ca4c07ae47.png","bannerType":2,
         * "relationInfo":"6","moduletype":1,"showIndex":6},{"title":"音乐入门",
         * "bannerUrl":"http://ali-files.yooshow
         * .com/2019/03/18/23879f19-f6b5-46ec-afc5-883325987047.png","bannerType":2,
         * "relationInfo":"28","moduletype":1,"showIndex":7},{"title":"央音乐坊",
         * "bannerUrl":"http://ali-files.yooshow
         * .com/2019/03/18/22d8b54b-29f0-4d22-98b2-570ce88f44a7.png","bannerType":0,
         * "relationInfo":"http://m.immedc.com/html5/yyyf/index.html","moduletype":1,"showIndex":8}]
         * courseRecommends : [{"appTitle":"钢琴","imageUrl":"http://ali-files.yooshow
         * .com/2019/03/15/730ee5a7-70c8-4bc8-b790-390001ffa742.png","courseUrl":"360",
         * "showIndex":1,"courseId":360,"coursePrice":380,"teacherName":"童薇",
         * "teacherTitle":"中央音乐学院钢琴系副教授","courseIntroduce":"\r\n适用人群：0基础想要学钢琴的朋友（建议12岁以上）\r\n
         * 教钢琴的老师\r\n\r\n童薇老师课程介绍\r\n
         * \u201c央音在线\u201d充分发挥学院在音乐教育领域中特有优势，将专业权威的师资，先进教学理念结合互联网+思维，精心打造综合创新的在线教育平台。\r\n在\u201c
         * 央音在线\u201d,
         * 您可以跟随专家从基础开始系统化学习，打下最坚实的音乐基础；可以观看专家随堂课，置身于最高音乐学府的真实课堂，感受学院大师风采，接受最权威的音乐理念；还可以欣赏独播的丰富类型的音乐会，专家讲座，大师直播互动等，与专家进行面对面的交流，帮您解答学习中的困惑。平台课程内容丰富，涵盖音乐学院各专业，包括：音乐基础，通史类课程，钢琴、声歌、管弦乐、民族器乐等各表演类课程，家长课堂及一些特色栏目。适合广大音乐学习者，音乐教育老师，专业演员、音乐爱好者升级加分。"},{"appTitle":"童声演唱技巧","imageUrl":"http://ali-files.yooshow.com/2018/02/05/7206926d-7780-46cb-ac60-e7b1abf44bbd.jpg","courseUrl":"225","showIndex":1,"courseId":225,"coursePrice":140,"teacherName":"张莉莉","teacherTitle":"中央歌剧院青年女高音歌唱家","courseIntroduce":"在声乐学习中，通常把6-12岁儿童的声乐培养称之为童声演唱训练，童声演唱训练作为声乐教学的启蒙期，其重要性不言而喻。童声期不仅是声乐学习的起点，还决定着音乐生涯的长度。\r\n中央音乐学院张莉莉老师将带领大家系统的学习这门课程，帮助学生培养音乐兴趣，提升音乐素养与气质。\r\n\r\n童声演唱技巧课程列表：\r\n1、童声演唱技巧中的歌曲方向和音准；\r\n2、童声演唱中的发音练习和母音练习；\r\n3、童声演唱中的呼吸运用；\r\n4、发声的连音和跳音练习方法；\r\n5、yu母音发音练习；\r\n6、a e母音连续发音练习；\r\n7、作品和发音练习；"},{"appTitle":"勃拉姆斯弦乐四重奏Op.51 No.2","imageUrl":"http://ali-files.yooshow.com/2018/07/11/71a9ca02-5725-4613-b081-bce71834c8ab.png","courseUrl":"284","showIndex":2,"courseId":284,"coursePrice":35,"teacherName":"杨一晨","teacherTitle":"中央音乐学院管弦系","courseIntroduce":"【课程简介】\r\n杨一晨老师携中央音乐学院大一弦乐四重奏乐团，为大家带来勃拉姆斯弦乐四重奏Op.51 No.2，这首曲子最能展现勃拉姆斯式的音乐张力，是勃拉  2000   斯室内乐作品中的经典曲目。\r\n\r\n【适用人群】\r\n弦乐高级学习者。"},{"appTitle":"小号专业课程Sonata奏鸣曲","imageUrl":"http://ali-files.yooshow.com/2018/07/13/d216aaec-b8a7-4464-97e8-48c1b8cb1f3c.jpg","courseUrl":"288","showIndex":2,"courseId":288,"coursePrice":35,"teacherName":"戴中晖","teacherTitle":"中央音乐学院管弦系教授 中国音协管乐协会副主席","courseIntroduce":"【作曲家】Kent Kennan K  肯纳（美国）\r\n\r\n【曲目介绍】\r\n肯纳《为小号而作的奏鸣曲》是20世纪最为成功的小号作品之一，时至今日，依然作为各音乐院校教学的标准曲目，受到广泛传播。\r\n\r\n【适用人群】\r\n初、中、高级小号专业学习者。"},{"appTitle":"钢琴作品的演奏与教学","imageUrl":"http://ali-files.yooshow.com/2018/07/12/0d8e9f36-cb16-4055-90b3-52ce14308ef5.jpg","courseUrl":"286","showIndex":2,"courseId":286,"coursePrice":60,"teacherName":"智园行方","teacherTitle":"中央音乐学院钢琴系","courseIntroduce":"【课程简介】\r\n课程包含：肖邦《黑键练习曲》和巴赫十二平均律《BWV862》。\r\n\r\n1、肖邦《黑键练习曲》是肖邦练习曲中比较著名的一首曲子，智园行方老师教你处理练习曲技巧、情感、音乐层次，以及本曲的表现力、风格的把握。\r\n\r\n2、巴赫十二平均律《BWV862》是一首典型的复调作品。\r\n\r\n"},{"appTitle":"双簧管","imageUrl":"http://ali-files.yooshow.com/2018/12/03/b46298fc-007e-47fe-ba20-457bc54cb214.jpg","courseUrl":"330","showIndex":3,"courseId":330,"coursePrice":105,"teacherName":"金京春","teacherTitle":"中央音乐学院双簧管教授 北京交响乐团担任双簧管首席","courseIntroduce":"课程简介:半音阶体系技术、循环呼吸、双吐\r\n课程包简介:半音阶体系技术的练习，循环呼吸及双吐的运用。\r\n\r\n金京春简介：金京春出生在双簧管世家。1987年考入中央音乐学院附中，师从我国著名的双簧管教育家祝盾教授。1997年毕业于中央音乐学院，并留校任教。2001进入北京交响乐团担任双簧管首席。2003年被教育部国家留学基金委公派赴俄罗斯莫斯科格涅辛音乐学院攻读硕士学位，师从于pusheechnikov院士学习。现于中央音乐学院附中任教。"}]
         * masterLives : [{"appTitle":"科学用嗓护嗓，帮你塑造好声音","imageUrl":"http://ali-files.yooshow
         * .com/2019/04/22/7e584782-6f63-4cf8-874c-bd770e399068.png","liveId":294,"showIndex":1,
         * "price":35,"teacherId":106,"teacherName":"韩丽艳","teacherTitle":"中央音乐学院声歌系",
         * "liveIsBuy":false,"liveStatus":0},{"appTitle":"中央音乐学院首部原创大型歌剧《山海经·奔月》",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2018/03/06/69debe8c-4e73-463e-9e4c-a493c9a722cf.jpg","liveId":211,"showIndex":4,
         * "price":100,"teacherId":113,"teacherName":"周海宏","teacherTitle":"中央音乐学院音乐学系",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"如何平衡音乐考级与兴趣培养",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2017/06/06/726b540f-f9f0-4d95-8759-24a75afbcda8.jpg","liveId":110,"showIndex":5,
         * "price":25,"teacherId":113,"teacherName":"周海宏","teacherTitle":"中央音乐学院音乐学系",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"声乐演唱技巧","imageUrl":"http://ali-files
         * .yooshow.com/2017/06/06/22811832-d796-4fa1-9d38-acd6fb49c7d3.jpg","liveId":112,
         * "showIndex":5,"price":100,"teacherId":116,"teacherName":"李双江",
         * "teacherTitle":"中国男高音、声乐教育家","liveIsBuy":false,"liveStatus":2},{"appTitle":"民族声乐发声技巧",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2017/06/22/7759292c-fd07-429b-b4a6-9889ca204c8f.jpg","liveId":113,"showIndex":5,
         * "price":100,"teacherId":115,"teacherName":"李谷一","teacherTitle":"中国著名女高音歌唱家",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"小朋友也可以轻松学会的\u201c美国第二国歌\u201d",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2018/05/09/ddc7ccae-8352-45eb-8674-d0a6c22b289a.png","liveId":218,"showIndex":6,
         * "price":25,"teacherId":74,"teacherName":"刘俊","teacherTitle":"中央音乐学院现代远程音乐教育学院兼职老师",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"小朋友也可以轻松学会的\u201c美国第二国歌\u201d(二）",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2018/05/31/09e58785-f9de-48f2-99bb-1b87258d3511.png","liveId":231,"showIndex":7,
         * "price":25,"teacherId":74,"teacherName":"刘俊","teacherTitle":"中央音乐学院现代远程音乐教育学院兼职老师",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"\u201c中速\u201d带来的《爱的协奏曲》",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2018/06/22/efcf70b7-e3f4-48a2-a81e-9bbfdc241327.jpg","liveId":240,"showIndex":8,
         * "price":25,"teacherId":74,"teacherName":"刘俊","teacherTitle":"中央音乐学院现代远程音乐教育学院兼职老师",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"十分调皮的八分音符","imageUrl":"http://ali-files
         * .yooshow.com/2018/06/14/51ecc626-db07-435c-934e-6dfcaf105012.jpg","liveId":237,
         * "showIndex":9,"price":25,"teacherId":74,"teacherName":"刘俊",
         * "teacherTitle":"中央音乐学院现代远程音乐教育学院兼职老师","liveIsBuy":false,"liveStatus":2},{"appTitle
         * ":"八分音符的朋友\u2014\u2014八分休止符","imageUrl":"http://ali-files.yooshow
         * .com/2018/07/11/0f4300bf-79b5-415c-a8bc-3e56695de362.jpg","liveId":242,"showIndex":10,
         * "price":25,"teacherId":74,"teacherName":"刘俊","teacherTitle":"中央音乐学院现代远程音乐教育学院兼职老师",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"《和\u201c音\u201d同光》 中央音乐学院与上海音乐学院交流音乐会",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2018/10/11/fe24e113-927f-4735-8c21-7fa1dfa9d5da.jpg","liveId":265,"showIndex":10,
         * "price":0,"teacherId":183,"teacherName":"中央音乐学院","teacherTitle":"中央音乐学院",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"指尖上的旋律\u2014\u2014献给孩子们的钢琴赏析音乐会",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2018/07/11/4816899c-42cc-41b1-9f8d-215b6d909fe2.jpg","liveId":235,"showIndex":11,
         * "price":0,"teacherId":117,"teacherName":"中央音乐学院出版社","teacherTitle":"中央音乐学院出版社",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"《大国之音》 民乐专场音乐会",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2018/10/11/61b83ab6-f30a-4a8c-ae58-a92d025b10ef.jpg","liveId":267,"showIndex":11,
         * "price":0,"teacherId":183,"teacherName":"中央音乐学院","teacherTitle":"中央音乐学院",
         * "liveIsBuy":false,"liveStatus":2},{"a 1ea1 ppTitle":"\u201c弥漫的心\u201d华人女作曲家现代双钢琴作品集",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2018/05/25/644f0fd1-4163-45aa-b23d-5efd79fd8861.jpg","liveId":229,"showIndex":12,
         * "price":0,"teacherId":117,"teacherName":"中央音乐学院出版社","teacherTitle":"中央音乐学院出版社",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"《走出象牙塔》 中央音乐学院作曲家影视作品音乐会",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2018/10/18/1208e5f1-d305-4868-8b49-1aa8bb9ef59f.jpg","liveId":268,"showIndex":12,
         * "price":0,"teacherId":183,"teacherName":"中央音乐学院","teacherTitle":"中央音乐学院",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"中央音乐学院首部原创大型歌剧《山海经·奔月》",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2018/03/06/d2a87e16-d322-4bfd-86db-0faff828efdb.jpg","liveId":212,"showIndex":13,
         * "price":100,"teacherId":113,"teacherName":"周海宏","teacherTitle":"中央音乐学院音乐学系",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"全本孙文明二胡作品音乐会",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2018/10/11/4b297c63-66e9-4cc0-929a-aa1794348f4e.jpg","liveId":264,"showIndex":13,
         * "price":0,"teacherId":183,"teacherName":"中央音乐学院","teacherTitle":"中央音乐学院",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"《奇弈记》 \u2014\u2014开幕式音乐会",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2018/10/11/7a43d1f2-ed97-4c95-a519-1da2c02ae59e.jpg","liveId":261,"showIndex":14,
         * "price":0,"teacherId":183,"teacherName":"中央音乐学院","teacherTitle":"中央音乐学院",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"歌剧《山海经·奔月》",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2018/03/06/cedbe007-24f3-429d-b47e-1bfe9d0baf48.jpg","liveId":210,"showIndex":15,
         * "price":100,"teacherId":113,"teacherName":"周海宏","teacherTitle":"中央音乐学院音乐学系",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"德奥艺术歌曲之夜","imageUrl":"http://ali-files
         * .yooshow.com/2018/09/20/1939dd79-f657-4817-9cd7-9be037031566.png","liveId":260,
         * "showIndex":15,"price":0,"teacherId":185,"teacherName":"张璋",
         * "teacherTitle":"中央音乐学院声乐歌剧系主科教师青年女高音歌唱家","liveIsBuy":false,"liveStatus":2},{"appTitle
         * ":"《不可思\u201c议\u201d》学生原创作品音乐会","imageUrl":"http://ali-files.yooshow
         * .com/2018/10/11/48e0b61d-22aa-4497-8b0f-72719189dbfa.jpg","liveId":262,"showIndex":16,
         * "price":0,"teacherId":183,"teacherName":"中央音乐学院","teacherTitle":"中央音乐学院",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"《春天的故事》中国七八十年代歌曲演唱会",
         * "imageUrl":"http://ali-files.yooshow
         * .com/2018/10/11/ca7ad50f-c8fa-4f7e-8745-410fadfc3545.jpg","liveId":263,"showIndex":17,
         * "price":0,"teacherId":183,"teacherName":"中央音乐学院","teacherTitle":"中央音乐学院",
         * "liveIsBuy":false,"liveStatus":2},{"appTitle":"刘俊音乐素养课","imageUrl":"http://ali-files
         * .yooshow.com/2018/07/20/28c440a2-0587-4f15-b891-c1fcec7a8ffe.jpg","liveId":254,
         * "showIndex":31,"price":0,"teacherId":74,"teacherName":"刘俊",
         * "teacherTitle":"中央音乐学院现代远程音乐教育学院兼职老师","liveIsBuy":false,"liveStatus":2},{"appTitle
         * ":"孙媛媛声乐演唱技巧课","imageUrl":"http://ali-files.yooshow
         * .com/2018/07/20/8a47f39c-8347-4df5-ac7a-2ba17a2886da.jpg","liveId":257,"showIndex":44,
         * "price":0,"teacherId":184,"teacherName":"孙媛媛","teacherTitle":"中央音乐学院声歌系教授",
         * "liveIsBuy":false,"liveStatus":2}]
         * zlList : [{"id":20,"title":"走进鲁特琴的世界","image":"http://ali-files.yooshow
         * .com/2017/10/09/76cd8503-d146-4774-8078-d6f739fd5aa3.jpg","showIndex":1,"isQa":0,
         * "qaPrice":0,"percentage":0,"ccomPercentage":0,"teacherPercentage":0,
         * "teacherName":"陈谊","passportId":0},{"id":6,"title":"嗓音诊疗室","image":"http://ali-files
         * .yooshow.com/2017/09/26/316f2c0c-7ab4-443a-bd81-16249fd04351.jpg","showIndex":1,
         * "isQa":1,"qaPrice":0,"percentage":0,"ccomPercentage":0,"teacherPercentage":0,
         * "teacherName":"韩丽艳","passportId":0},{"id":1,"title":"海宏会客厅","image":"http://ali-files
         * .yooshow.com/2017/06/20/f6bd42cb-fc83-41fa-a017-5fe1731724bb.jpg","showIndex":3,
         * "isQa":0,"qaPrice":0,"percentage":0,"ccomPercentage":0,"teacherPercentage":0,
         * "teacherName":"周海宏","passportId":0},{"id":23,"title":"社区音乐","image":"http://ali-files
         * .yooshow.com/2019/03/04/cdb5d2c9-cd52-4d4e-8428-e37b8b8801a9.jpg","showIndex":4,
         * "isQa":1,"qaPrice":0,"percentage":0,"ccomPercentage":0,"teacherPercentage":0,
         * "teacherName":"姚侃","passportId":0}]
         * shareView : {"sharePic":"http://ali-files.yooshow.com/app/yangyin/default-red-share
         * .png","shareTitle":"免费加入\u201c全国音乐教师联盟\u201d并送价值500元的线上课程。","shareUrl":"http://m
         * .immedc.com/lmhd/download","shareContent":"\"全国音乐教师联盟\"大礼包免费抢"}
         * vipRecommend : [{"id":1173,"title":"家长音乐素养必修课","image":"http://ali-files.yooshow
         * .com/2019/01/13/bd7e9186-2168-489f-b9c4-11079dcc773e.jpg","dataType":2,"dataId":305,
         * "created":"2019-04-04 11:37:06","text1":"会员优享","price":0,"vip":false,"buy":false},{"id
         * ":1174,"title":"闹元宵的演奏技巧","image":"http://ali-files.yooshow
         * .com/2019/03/01/fe8024c2-2cf4-47c9-a8b3-1a3623ee80dd.png","dataType":2,"dataId":350,
         * "created":"2019-03-13 10:02:01","text1":"会员优享","price":0,"vip":false,"buy":false},{"id
         * ":1175,"title":"戴玉强声乐大师课","image":"http://ali-files.yooshow
         * .com/2017/08/31/b956483b-91c1-41a7-89e4-c784d0030a54.jpg","dataType":2,"dataId":315,
         * "created":"2019-04-04 11:36:01","text1":"会员优享","price":0,"vip":false,"buy":false},{"id
         * ":1176,"title":"李谷一声乐大师课","image":"http://ali-files.yooshow
         * .com/2017/06/22/913680e7-281a-40a6-83d2-15dc257708ea.jpg","dataType":2,"dataId":316,
         * "created":"2019-04-15 12:05:35","text1":"会员优享","price":0,"vip":false,"buy":false}]
         */

        private ShareViewBean shareView;
        private List<HomeBannerBean> homeBanner;
        private List<HomeCategoryBean> homeCategory;
        private List<CourseRecommendsBean> courseRecommends;
        private List<MasterLivesBean> masterLives;
        private List<ZlListBean> zlList;
        private List<VipRecommendBean> vipRecommend;

        public ShareViewBean getShareView() {
            return shareView;
        }

        public void setShareView(ShareViewBean shareView) {
            this.shareView = shareView;
        }

        public List<HomeBannerBean> getHomeBanner() {
            return homeBanner;
        }

        public void setHomeBanner(List<HomeBannerBean> homeBanner) {
            this.homeBanner = homeBanner;
        }

        public List<HomeCategoryBean> getHomeCategory() {
            return homeCategory;
        }

        public void setHomeCategory(List<HomeCategoryBean> homeCategory) {
            this.homeCategory = homeCategory;
        }

        public List<CourseRecommendsBean> getCourseRecommends() {
            return courseRecommends;
        }

        public void setCourseRecommends(List<CourseRecommendsBean> courseRecommends) {
            this.courseRecommends = courseRecommends;
        }

        public List<MasterLivesBean> getMasterLives() {
            return masterLives;
        }

        public void setMasterLives(List<MasterLivesBean> masterLives) {
            this.masterLives = masterLives;
        }

        public List<ZlListBean> getZlList() {
            return zlList;
        }

        public void setZlList(List<ZlListBean> zlList) {
            this.zlList = zlList;
        }

        public List<VipRecommendBean> getVipRecommend() {
            return vipRecommend;
        }

        public void setVipRecommend(List<VipRecommendBean> vipRecommend) {
            this.vipRecommend = vipRecommend;
        }

        public static class ShareViewBean {
            /**
             * sharePic : http://ali-files.yooshow.com/app/yangyin/default-red-share.png
             * shareTitle : 免费加入“全国音乐教师联盟”并送价值500元的线上课程。
             * shareUrl : http://m.immedc.com/lmhd/download
             * shareContent : "全国音乐教师联盟"大礼包免费抢
             */

            private String sharePic;
            private String shareTitle;
            private String shareUrl;
            private String shareContent;

            public String getSharePic() {
                return sharePic;
            }

            public void setSharePic(String sharePic) {
                this.sharePic = sharePic;
            }

            public String getShareTitle() {
                return shareTitle;
            }

            public void setShareTitle(String shareTitle) {
                this.shareTitle = shareTitle;
            }

            public String getShareUrl() {
                return shareUrl;
            }

            public void setShareUrl(String shareUrl) {
                this.shareUrl = shareUrl;
            }

            public String getShareContent() {
                return shareContent;
            }

            public void setShareContent(String shareContent) {
                this.shareContent = shareContent;
            }
        }

        public static class HomeBannerBean {
            /**
             * title : 童声演唱技巧课
             * bannerUrl : http://ali-files.yooshow
             * .com/2018/02/05/7206926d-7780-46cb-ac60-e7b1abf44bbd.jpg
             * bannerType : 2
             * relationInfo : 225
             * moduletype : 0
             * showIndex : 0
             * courseType : 1
             * liveStatus : 0
             * liveIsBuy : false
             */

            private String title;
            private String bannerUrl;
            private int bannerType;
            private String relationInfo;
            private int moduletype;
            private int showIndex;
            private int courseType;
            private int liveStatus;
            private boolean liveIsBuy;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getBannerUrl() {
                return bannerUrl;
            }

            public void setBannerUrl(String bannerUrl) {
                this.bannerUrl = bannerUrl;
            }

            public int getBannerType() {
                return bannerType;
            }

            public void setBannerType(int bannerType) {
                this.bannerType = bannerType;
            }

            public String getRelationInfo() {
                return relationInfo;
            }

            public void setRelationInfo(String relationInfo) {
                this.relationInfo = relationInfo;
            }

            public int getModuletype() {
                return moduletype;
            }

            public void setModuletype(int moduletype) {
                this.moduletype = moduletype;
            }

            public int getShowIndex() {
                return showIndex;
            }

            public void setShowIndex(int showIndex) {
                this.showIndex = showIndex;
            }

            public int getCourseType() {
                return courseType;
            }

            public void setCourseType(int courseType) {
                this.courseType = courseType;
            }

            public int getLiveStatus() {
                return liveStatus;
            }

            public void setLiveStatus(int liveStatus) {
                this.liveStatus = liveStatus;
            }

            public boolean isLiveIsBuy() {
                return liveIsBuy;
            }

            public void setLiveIsBuy(boolean liveIsBuy) {
                this.liveIsBuy = liveIsBuy;
            }
        }

        public static class HomeCategoryBean {
            /**
             * title : 音乐课堂
             * bannerUrl : http://ali-files.yooshow
             * .com/2019/03/22/44e8bb6f-f9e5-4442-9d8f-91b9d0fd9162.png
             * bannerType : 2
             * relationInfo : 1
             * moduletype : 1
             * showIndex : 1
             */

            private String title;
            private String bannerUrl;
            private int bannerType;
            private String relationInfo;
            private int moduletype;
            private int showIndex;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getBannerUrl() {
                return bannerUrl;
            }

            public void setBannerUrl(String bannerUrl) {
                this.bannerUrl = bannerUrl;
            }

            public int getBannerType() {
                return bannerType;
            }

            public void setBannerType(int bannerType) {
                this.bannerType = bannerType;
            }

            public String getRelationInfo() {
                return relationInfo;
            }

            public void setRelationInfo(String relationInfo) {
                this.relationInfo = relationInfo;
            }

            public int getModuletype() {
                return moduletype;
            }

            public void setModuletype(int moduletype) {
                this.moduletype = moduletype;
            }

            public int getShowIndex() {
                return showIndex;
            }

            public void setShowIndex(int showIndex) {
                this.showIndex = showIndex;
            }
        }

        public static class CourseRecommendsBean {
            /**
             * appTitle : 钢琴
             * imageUrl : http://ali-files.yooshow
             * .com/2019/03/15/730ee5a7-70c8-4bc8-b790-390001ffa742.png
             * courseUrl : 360
             * showIndex : 1
             * courseId : 360
             * coursePrice : 380.0
             * teacherName : 童薇
             * teacherTitle : 中央音乐学院钢琴系副教授
             * courseIntroduce :
             * 适用人群：0基础想要学钢琴的朋友（建议12岁以上）
             * 教钢琴的老师
             * <p>
             * 童薇老师课程介绍
             * “央音在线”充分发挥学院在音乐教育领域中特有优势，将专业权威的师资，先进教学理念结合互联网+思维，精心打造综合创新的在线教育平台。
             * 在“央音在线”,
             * 您可以跟随专家从基础开始系统化学习，打下最坚实的音乐基础；可以观看专家随堂课，置身于最高音乐学府的真实课堂，感受学院大师风采，接受最权威的音乐理念；还可以欣赏独播的丰富类型的音乐会，专家讲座，大师直播互动等，与专家进行面对面的交流，帮您解答学习中的困惑。平台课程内容丰富，涵盖音乐学院各专业，包括：音乐基础，通史类课程，钢琴、声歌、管弦乐、民族器乐等各表演类课程，家长课堂及一些特色栏目。适合广大音乐学习者，音乐教育老师，专业演员、音乐爱好者升级加分。
             */

            private String appTitle;
            private String imageUrl;
            private String courseUrl;
            private int showIndex;
            private int courseId;
            private double coursePrice;
            private String teacherName;
            private String teacherTitle;
            private String courseIntroduce;

            public String getAppTitle() {
                return appTitle;
            }

            public void setAppTitle(String appTitle) {
                this.appTitle = appTitle;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public String getCourseUrl() {
                return courseUrl;
            }

            public void setCourseUrl(String courseUrl) {
                this.courseUrl = courseUrl;
            }

            public int getShowIndex() {
                return showIndex;
            }

            public void setShowIndex(int showIndex) {
                this.showIndex = showIndex;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }

            public double getCoursePrice() {
                return coursePrice;
            }

            public void setCoursePrice(double coursePrice) {
                this.coursePrice = coursePrice;
            }

            public String getTeacherName() {
                return teacherName;
            }

            public void setTeacherName(String teacherName) {
                this.teacherName = teacherName;
            }

            public String getTeacherTitle() {
                return teacherTitle;
            }

            public void setTeacherTitle(String teacherTitle) {
                this.teacherTitle = teacherTitle;
            }

            public String getCourseIntroduce() {
                return courseIntroduce;
            }

            public void setCourseIntroduce(String courseIntroduce) {
                this.courseIntroduce = courseIntroduce;
            }
        }

        public static class MasterLivesBean {
            /**
             * appTitle : 科学用嗓护嗓，帮你塑造好声音
             * imageUrl : http://ali-files.yooshow
             * .com/2019/04/22/7e584782-6f63-4cf8-874c-bd770e399068.png
             * liveId : 294
             * showIndex : 1
             * price : 35
             * teacherId : 106
             * teacherName : 韩丽艳
             * teacherTitle : 中央音乐学院声歌系
             * liveIsBuy : false
             * liveStatus : 0
             * a 1ea1 ppTitle : “弥漫的心”华人女作曲家现代双钢琴作品集
             */

            private String appTitle;
            private String imageUrl;
            private int liveId;
            private int showIndex;
            private int price;
            private int teacherId;
            private String teacherName;
            private String teacherTitle;
            private boolean liveIsBuy;
            private int liveStatus;

            public String getAppTitle() {
                return appTitle;
            }

            public void setAppTitle(String appTitle) {
                this.appTitle = appTitle;
            }

            public String getImageUrl() {
                return imageUrl;
            }

            public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
            }

            public int getLiveId() {
                return liveId;
            }

            public void setLiveId(int liveId) {
                this.liveId = liveId;
            }

            public int getShowIndex() {
                return showIndex;
            }

            public void setShowIndex(int showIndex) {
                this.showIndex = showIndex;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getTeacherId() {
                return teacherId;
            }

            public void setTeacherId(int teacherId) {
                this.teacherId = teacherId;
            }

            public String getTeacherName() {
                return teacherName;
            }

            public void setTeacherName(String teacherName) {
                this.teacherName = teacherName;
            }

            public String getTeacherTitle() {
                return teacherTitle;
            }

            public void setTeacherTitle(String teacherTitle) {
                this.teacherTitle = teacherTitle;
            }

            public boolean isLiveIsBuy() {
                return liveIsBuy;
            }

            public void setLiveIsBuy(boolean liveIsBuy) {
                this.liveIsBuy = liveIsBuy;
            }

            public int getLiveStatus() {
                return liveStatus;
            }

            public void setLiveStatus(int liveStatus) {
                this.liveStatus = liveStatus;
            }
        }

        public static class ZlListBean {
            /**
             * id : 20
             * title : 走进鲁特琴的世界
             * image : http://ali-files.yooshow
             * .com/2017/10/09/76cd8503-d146-4774-8078-d6f739fd5aa3.jpg
             * showIndex : 1
             * isQa : 0
             * qaPrice : 0.0
             * percentage : 0
             * ccomPercentage : 0
             * teacherPercentage : 0
             * teacherName : 陈谊
             * passportId : 0
             */

            private int id;
            private String title;
            private String image;
            private int showIndex;
            private int isQa;
            private double qaPrice;
            private int percentage;
            private int ccomPercentage;
            private int teacherPercentage;
            private String teacherName;
            private int passportId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getShowIndex() {
                return showIndex;
            }

            public void setShowIndex(int showIndex) {
                this.showIndex = showIndex;
            }

            public int getIsQa() {
                return isQa;
            }

            public void setIsQa(int isQa) {
                this.isQa = isQa;
            }

            public double getQaPrice() {
                return qaPrice;
            }

            public void setQaPrice(double qaPrice) {
                this.qaPrice = qaPrice;
            }

            public int getPercentage() {
                return percentage;
            }

            public void setPercentage(int percentage) {
                this.percentage = percentage;
            }

            public int getCcomPercentage() {
                return ccomPercentage;
            }

            public void setCcomPercentage(int ccomPercentage) {
                this.ccomPercentage = ccomPercentage;
            }

            public int getTeacherPercentage() {
                return teacherPercentage;
            }

            public void setTeacherPercentage(int teacherPercentage) {
                this.teacherPercentage = teacherPercentage;
            }

            public String getTeacherName() {
                return teacherName;
            }

            public void setTeacherName(String teacherName) {
                this.teacherName = teacherName;
            }

            public int getPassportId() {
                return passportId;
            }

            public void setPassportId(int passportId) {
                this.passportId = passportId;
            }
        }

        public static class VipRecommendBean {
            /**
             * id : 1173
             * title : 家长音乐素养必修课
             * image : http://ali-files.yooshow
             * .com/2019/01/13/bd7e9186-2168-489f-b9c4-11079dcc773e.jpg
             * dataType : 2
             * dataId : 305
             * created : 2019-04-04 11:37:06
             * text1 : 会员优享
             * price : 0.0
             * vip : false
             * buy : false
             */

            private int id;
            private String title;
            private String image;
            private int dataType;
            private int dataId;
            private String created;
            private String text1;
            private double price;
            private boolean vip;
            private boolean buy;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getDataType() {
                return dataType;
            }

            public void setDataType(int dataType) {
                this.dataType = dataType;
            }

            public int getDataId() {
                return dataId;
            }

            public void setDataId(int dataId) {
                this.dataId = dataId;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getText1() {
                return text1;
            }

            public void setText1(String text1) {
                this.text1 = text1;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public boolean isVip() {
                return vip;
            }

            public void setVip(boolean vip) {
                this.vip = vip;
            }

            public boolean isBuy() {
                return buy;
            }

            public void setBuy(boolean buy) {
                this.buy = buy;
            }
        }
    }
}
