//Nikolaos Alexiadis - 2491021A

 public class FruitMachine {

    public static void main(String[] args) {
//        The main method creates instances of the model and controller classes
        FruitMachineModel model = new FruitMachineModel();
        FruitMachineController controller = new FruitMachineController(model);
    }
}
