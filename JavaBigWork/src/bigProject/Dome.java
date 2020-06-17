package bigProject;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * @author ChristinaXinny
 * @Date: 2020年5月30日 下午5:09:54
 */




public class Dome extends Application {

	private static FileData fd = new FileData();

//	FileData fd1 = new FileData();
	
	public BorderPane AllHave(String img, String FaceName) {

		BorderPane bp = new BorderPane();
		
//		背景图
		Image bgImage = new Image(img);//加载图片
		bp.setBackground(new Background(new BackgroundImage(bgImage,BackgroundRepeat.REPEAT, null, null, null)));
		
//		标题 放到bpMainPane的top
		Label title = new Label(FaceName);
		Font font = Font.font("Times New Romes",FontWeight.BOLD,FontPosture.ITALIC,60);//设置字体
		title.setFont(font);
		title.setPadding(new Insets(20, 30, 0, 30));//这是在界面达到这个值之后 失去居中
		bp.setTop(title);
		BorderPane.setAlignment(title, Pos.TOP_CENTER);//标题居中
		
//		Button bReturn = new Button("Return");
		
//		bp.setBottom(bReturn);
		
		return bp;
	}
	
	public Button buttonByBig(String name) {
		Button b = new Button(name);
		b.setStyle("-fx-font-size: 17px;"); 
		b.setMinSize(100, 50);
		return b;
	}
	public Button buttonBySmall(String name) {
		Button b = new Button(name);
		b.setStyle("-fx-font-size: 15px;"); 
		b.setMinSize(50, 30);
		return b;
	}
	
	public Label labelByBig(String name) {
		Label l = new Label(name);
		l.setStyle("-fx-font-size:25px;");
		return l;
	}
	public Label labelBySmall(String name) {
		Label l = new Label(name);
		l.setStyle("-fx-font-size:20px;");
		return l;
	}
	
	
	public ObservableList<String> setObs(){
		String[] title = {
				  "Id", "Name", "Age", "Phone"
		};
		ObservableList<String> it = FXCollections.observableArrayList(title);
		return it;
	}
	public ComboBox<String> setMune(ObservableList<String> it) {
		ComboBox<String> mune = new ComboBox<>(); // flagTitles);
		mune.setPrefWidth(100);
		mune.setValue("Id");
		mune.getItems().addAll(it);
		return mune;
	}
	public void forQuery(int index, String key) {
		
		Stage stage = new Stage();
		
		BorderPane bp = new BorderPane();
		bp.setCenter(labelBySmall(fd.quFile(key, index)));
		bp.setStyle("-fx-background-color:#fff0f5;");
		Scene s = new Scene(bp, 500, 300);
		
		stage.setScene(s);
		stage.show();
		
	}
	
	
	

	@Override
	public void start(Stage prlmaryStage) {
		
		BorderPane bpLogin = AllHave("file:blue-snow.png", "Login");
		
		GridPane gpLogin = new GridPane();
		gpLogin.setAlignment(Pos.CENTER);//居中
		gpLogin.setPadding(new Insets(50, 50, 50, 50));
		gpLogin.setHgap(10);
		gpLogin.setVgap(10);
		
		
		
		TextField tUserName = new TextField();
		tUserName.setPrefSize(200, 40);
		gpLogin.add(labelByBig("UserName:"), 1, 1);
		gpLogin.add(tUserName, 2, 1);
		
		
		
		PasswordField tPassWord = new PasswordField(); // 创建一个密码输入框
		tPassWord.setPrefSize(200, 40); // 设置密码输入框的推荐宽高
		tPassWord.setEditable(true); // 设置密码输入框能否编辑
		tPassWord.setPromptText("请输入密码"); // 设置密码输入框的提示语
		tPassWord.setAlignment(Pos.CENTER_LEFT); // 设置密码输入框的对齐方式
		gpLogin.add(labelByBig("Password:"), 1, 3);
		gpLogin.add(tPassWord, 2, 3);
		
		Button bForget = buttonBySmall("忘记密码"); 
		gpLogin.add(bForget, 0, 4);
		
		Button bLogin = buttonBySmall("登录");
		gpLogin.add(bLogin, 4, 3);
		
		bpLogin.setCenter(gpLogin);
		
		Scene sLogin;
		sLogin = new Scene(bpLogin, 700, 500);
		
		bForget.setOnAction(new EventHandler<ActionEvent>() {// 鼠标点击
			public void handle(ActionEvent e) {
//				弹出窗口
				Stage stage = new Stage();
				
				BorderPane bp = new BorderPane();
				bp.setCenter(labelByBig("你不配拥有本系统\n\n\n\t嘻嘻􏰉􏱜􏱝􏵆􏵇􏰒􏰝􏰞􏵗􏵘􏰍􏶒􏶓􏰐􏰖􏰑􏱜􏱝􏳶􏰒􏰝􏰞􏲕􏲖􏰆􏱻􏰂􏰏􏵻􏶆􏰖􏰉􏱜􏱝􏵆􏵇􏰒􏰝􏰞􏵗􏵘􏰍􏶒􏶓􏰐􏰖􏰑􏱜􏱝􏳶􏰒􏰝􏰞􏲕􏲖􏰆􏱻􏰂􏰏􏵻􏶆􏰖╮(￣▽￣)╭"));
				bp.setStyle("-fx-background-color:#fff0f5;");
				Scene s = new Scene(bp, 250, 250);
				
				stage.setScene(s);
				stage.show();
			}
		});
		
		bLogin.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				fd.readFile();
				
			}
		});

//-----------------------------------------------home
		
		
		BorderPane bpHome = AllHave("file:bg1.png", "通讯管理");
		
		
		GridPane gpHome = new GridPane();
		gpHome.setAlignment(Pos.CENTER);//居中
		gpHome.setPadding(new Insets(50, 50, 50, 50));
		gpHome.setHgap(10);
		gpHome.setVgap(10);
		Button bCreat = buttonByBig("创建");
		Button bDelet = buttonByBig("删除");
		Button bRevise = buttonByBig("修改");
		Button bQuery = buttonByBig("查询");
		Button bClear = buttonByBig("清除");
		gpHome.add(bCreat, 1, 1);
		gpHome.add(bDelet, 2, 2);
		gpHome.add(bRevise, 3, 3);
		gpHome.add(bQuery, 4, 4);
		gpHome.add(bClear, 5, 5);
		
		bpHome.setCenter(gpHome);
		
		
		Scene sHome;
		sHome = new Scene(bpHome, 700, 500);
		
		
		bLogin.setOnMouseClicked(e -> {
			
			prlmaryStage.setScene(sHome);
		});
		
		  
		

//----------------------------------------create
		
		BorderPane bpCreate = AllHave("file:bg2.png", "Create创建");
		
		Image imgId = new Image("file:id.png");
		Image imgNa = new Image("file:name.png");
		Image imgAg = new Image("file:age.png");
		Image imgPh = new Image("file:phone.png");
		
		
		GridPane gpCreate = new GridPane();
		gpCreate.setAlignment(Pos.CENTER);
		gpCreate.setHgap(5);
		gpCreate.setVgap(5);
		
		
		TextField tId = new TextField();//数据在页面的文本里录入
		TextField tName = new TextField();
		TextField tAge = new TextField();
		TextField tPhone = new TextField();
		gpCreate.add(new ImageView(imgId), 0, 1);
		gpCreate.add(new ImageView(imgNa), 0, 2);
		gpCreate.add(new ImageView(imgAg), 0, 3);
		gpCreate.add(new ImageView(imgPh), 0, 4);
		gpCreate.add(labelBySmall("Id:"), 1, 1);
		gpCreate.add(labelBySmall("Name:"), 1, 2);
		gpCreate.add(labelBySmall("Age:"), 1, 3);
		gpCreate.add(labelBySmall("Phone:"), 1, 4);
		
		gpCreate.add(tId, 2, 1);
		gpCreate.add(tName, 2, 2);
		gpCreate.add(tAge, 2, 3);
		gpCreate.add(tPhone, 2, 4);
		
		Button bOkCreat = buttonBySmall("OK");
		Button bCReturn = buttonBySmall("返回");
		gpCreate.add(bOkCreat, 2, 5);
		gpCreate.add(bCReturn, 0, 5);
		GridPane.setHalignment(bOkCreat, HPos.RIGHT);
		
		bpCreate.setCenter(gpCreate);
		Scene sCreate;
		sCreate = new Scene(bpCreate, 700, 500);

		
		bCreat.setOnMouseClicked(e -> {
			prlmaryStage.setScene(sCreate);
		});
		
		bOkCreat.setOnAction(new EventHandler<ActionEvent>() {// 鼠标点击OK按钮的时候 
			public void handle(ActionEvent e) {
				String strId = tId.getText();//把输入到文本框的内容 变成string
				String strName = tName.getText();
				String strAge = tAge.getText();
				String strPhone = tPhone.getText();
				Person p = new Person(strId,strName, strAge, strPhone);	//根据输入的内容 创建person对象p
				fd.crFile(p);//放到ArrayList数组里面
//				清空
				tId.setText("");
				tName.setText("");
				tAge.setText("");
				tPhone.setText("");
				
//				弹出窗口
				Stage stage = new Stage();
				
				BorderPane bp = new BorderPane();
				bp.setCenter(labelByBig("创建成功"));
				bp.setStyle("-fx-background-color:#fff0f5;");
				Scene s = new Scene(bp, 200, 200);
				
				stage.setScene(s);
				stage.show();
			}
		});
		
		

		
		

//----------------------------------------deleteById
		
		
		BorderPane bpDelete = AllHave("file:bg3.png",  "Delet删除");

		GridPane gpDelet = new GridPane();
		gpDelet.setAlignment(Pos.CENTER);
		gpDelet.setHgap(5);
		gpDelet.setVgap(5);
		
		TextField tDeletId = new TextField();
		TextField tDeletName = new TextField();
		gpDelet.add(labelBySmall("Id:"), 0, 0);//根据id
		gpDelet.add(labelBySmall("需要删除的name:"), 0, 1);//根据name
		gpDelet.add(tDeletId, 1, 0);
		gpDelet.add(tDeletName, 1, 1);
		
		Button bDByIdOk = buttonBySmall("OK-id");
		Button bDByNameOk = buttonBySmall("OK-name");
		gpDelet.add(bDByIdOk, 2, 0);
		gpDelet.add(bDByNameOk, 2, 1);
		
		Button bDReturn = buttonBySmall("返回");
		gpDelet.add(bDReturn, 0, 3);
		
		
		bpDelete.setCenter(gpDelet);
		Scene sDelete;
		sDelete = new Scene(bpDelete, 700, 500);
		
		bDelet.setOnMouseClicked(e -> {
			prlmaryStage.setScene(sDelete);
		});

		bDByIdOk.setOnAction(new EventHandler<ActionEvent>() {// 点击id的OK
			public void handle(ActionEvent e) {
				String id = tDeletId.getText();
				Stage stage = new Stage();
				tDeletId.clear();//清空

				BorderPane bp = new BorderPane();
				bp.setCenter(labelBySmall(fd.deById(id)));
				bp.setStyle("-fx-background-color:#fff0f5;");
				Scene s = new Scene(bp, 200, 200);
				
				stage.setScene(s);
				stage.show();
			}
		});
		
		bDByNameOk.setOnAction(new EventHandler<ActionEvent>() {// 点击name 的OK
			public void handle(ActionEvent e) {
				String name = tDeletName.getText();
				Stage stage = new Stage();
				tDeletName.clear();//清空
				
				BorderPane bp = new BorderPane();
				bp.setCenter(labelBySmall(fd.deByName(name)));
				bp.setStyle("-fx-background-color:#fff0f5;");
				Scene s = new Scene(bp, 200, 200);
				
				stage.setScene(s);
				stage.show();
			}
		});

// ----------------------------------------Revise修改
		
		BorderPane bpRevise = AllHave("file:bg6.png",  "Revise修改");
		
		GridPane pRevise = new GridPane();
		pRevise.setAlignment(Pos.CENTER);
		pRevise.setHgap(5);
		pRevise.setVgap(5);
		
		
		TextField tRNum = new TextField();
		TextField tRId = new TextField();
		TextField tRName = new TextField();
		TextField tRAge = new TextField();
		TextField tRPhone = new TextField();
		
		pRevise.add(labelBySmall("需要修改的id:"), 0, 0);// al的下标 用户输入从1开始，使用时记得-1
		pRevise.add(labelBySmall("ID:"), 0, 1);
		pRevise.add(labelBySmall("Name"), 0, 2);
		pRevise.add(labelBySmall("Age:"), 0, 3);
		pRevise.add(labelBySmall("phone:"), 0, 4);
		pRevise.add(tRNum, 1, 0);
		pRevise.add(tRId, 1, 1);
		pRevise.add(tRName, 1, 2);
		pRevise.add(tRAge, 1, 3);
		pRevise.add(tRPhone, 1, 4);
		
		Button bOkRevise = buttonBySmall("OK");
		Button bRReturn = buttonBySmall("返回");
		pRevise.add(bOkRevise, 1, 6);
		pRevise.add(bRReturn, 0, 6);
		GridPane.setHalignment(bOkRevise, HPos.RIGHT);
		
		bpRevise.setCenter(pRevise);
		
		Scene sRevise;
		sRevise = new Scene(bpRevise, 700, 500);

//		主页面进入
		bRevise.setOnMouseClicked(e -> {
			prlmaryStage.setScene(sRevise);
		});

		bOkRevise.setOnAction(new EventHandler<ActionEvent>() {// 鼠标点击
			public void handle(ActionEvent e) {
				Stage stage = new Stage();
				String id = tRNum.getText();
				String strId = tRId.getText();
				String strName = tRName.getText();
				String strAge = tRAge.getText();
				String strPhone = tRPhone.getText();
				Person p = new Person(strId, strName, strAge, strPhone);
				
				BorderPane bp = new BorderPane();
				bp.setCenter(labelBySmall(fd.reFile(p, id)));
				bp.setStyle("-fx-background-color:#fff0f5;");
				Scene s = new Scene(bp, 200, 200);
				
				tRNum.clear();
				tRId.clear();
				tRName.clear();
				tRAge.clear();
				tRPhone.clear();
				
				stage.setScene(s);
				stage.show();
			}
		});

// ----------------------------------------Query查询根据id搜索
		
		BorderPane bpQuery = AllHave("file:bg5.png",  "Query查询");
		
		
		GridPane pQuery = new GridPane();
		pQuery.setAlignment(Pos.CENTER);
		pQuery.setHgap(5);
		pQuery.setVgap(5);
		
		
		
		
		pQuery.add(labelBySmall("需要查询的"), 0, 0);
		Button bOkQuery = buttonBySmall("清除");
		Button bQReturn = buttonBySmall("返回");
		Button bQAll = buttonBySmall("查询全部");
		pQuery.add(bQReturn, 0, 3);
		pQuery.add(bQAll, 1, 4);
		
		
		TextField tqq = new TextField();
		pQuery.add(tqq, 2, 0);
		ObservableList<String> it = setObs();
		ComboBox<String> muneQ = setMune(it);
		pQuery.add(muneQ, 1, 0);
		
		muneQ.setOnAction(e -> forQuery(it.indexOf(muneQ.getValue()), tqq.getText()));
		
		
		
		
		bpQuery.setCenter(pQuery);
		
		Scene sQuery;
		sQuery = new Scene(bpQuery, 700, 500);
		
//		在这里设置主页面点击进入 因为现在才设置好Query页面
		bQuery.setOnMouseClicked(e -> {
			prlmaryStage.setScene(sQuery);
		});

//		 鼠标点击 ok按钮
		bOkQuery.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				tqq.clear();//清空
			}
		});
		
		bQAll.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				
				Stage stage = new Stage();
				TextArea ta = new TextArea(fd.quAll());
				  
//				labelByBig(fd.quAll());
				ta.setFont(new Font("Serif", 20));
				    

				ScrollPane sp = new ScrollPane(ta);
				
				BorderPane bp = AllHave("file:bg6.png","查询");
				bp.setCenter(sp);
				Scene s = new Scene(bp, 500, 300);
				
				stage.setScene(s);
				stage.show();
			}
		});
		
		
		
		
// ----------------------------------------Clear 清除文件所有内容
		bClear.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				Stage stage = new Stage();
				
//				BorderPane bp = AllHave("file:bg6.png","Clear清除\n      成功");
				BorderPane bp = new BorderPane();
				bp.setCenter(labelByBig("Clear清除\n      成功\n"+fd.clearFile()));
				bp.setStyle("-fx-background-color:#fff0f5;");
				Scene s = new Scene(bp, 400, 200);
				
				stage.setScene(s);
				stage.show();
			}
		});
		

		
		
		
//		--------------------------------
//		返回按钮设置
		bCReturn.setOnMouseClicked(e -> {
			prlmaryStage.setScene(sHome);
		});
		bDReturn.setOnMouseClicked(e -> {
			prlmaryStage.setScene(sHome);
		});
		bRReturn.setOnMouseClicked(e -> {
			prlmaryStage.setScene(sHome);
		});
		bQReturn.setOnMouseClicked(e -> {
			prlmaryStage.setScene(sHome);
		});


		prlmaryStage.setTitle("Home");
		prlmaryStage.setScene(sLogin);
		prlmaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
		fd.writeFile();
	}

}

