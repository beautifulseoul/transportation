public class Transportation {

    int gas = 100;
    int carNum;

    Transportation(int number) {
        this.carNum = number;
    }
}

class Bus extends Transportation {
    final int maxPeople = 30;
    int currentPeople;
    int fee = 2000;
    int currentSpeed = 0;
    String status = "운행";

    Bus(int number) {
        super(number);
    }

    void operateOn() {
        if (status.equals("운행")) {
            System.out.println("이미 운행중입니다");
        } else {
            this.status = "운행";
            System.out.println("운행을 시작합니다");
        }
    }

    void operateOff() {
        this.status = "차고지행";
        System.out.println("운행을 종료합니다");
    }

    void gasCheck() {
        if (gas < 10) {
            this.status = "차고지행";
            System.out.println("주유가 필요합니다");
        }
    }

    void getPeople(int people) {
        if (this.currentPeople + people <= maxPeople && this.status.equals("운행")) {
            this.currentPeople += people;
        } else {
            System.out.println("탑승하실 수 없습니다.");
        }
    }

    void changeSpeed(int speed) {
        if (this.gas >= 10) {
            this.currentSpeed += speed;
        } else {
            this.status = "차고지행";
            System.out.println("주유량으로 인해 속도를 변경에 실패하였습니다");
            System.out.println("주유량으로 인해 차고지행으로 변경합니다");
        }
    }
}

class Taxi extends Transportation {
    int currentSpeed = 0;
    String destination;
    int distanceOfDefault = 10;
    int totalFee = 0;
    int defaultFee = 8000;
    int feePerDistance = 500;
    String status = "운행불가";

    Taxi(int number) {
        super(number);
    }

    void powerOn() {
        if (this.gas >= 10) {
            this.status = "일반";
        } else {
            System.out.println("주유량 부족으로 시동을 걸지 못했습니다");
        }
    }

    void powerOff() {
        this.status = "운행불가";
    }

    void getPeople() {
        if (this.gas >= 10 && this.status.equals("일반")) {
            this.status = "운행 중";
        } else {
            System.out.println("승객을 태울 수 없습니다");
        }
    }

    void changeSpeed(int speed) {
        this.currentSpeed += speed;
    }

    void calculate(int distanceToDestination) {
        totalFee = (distanceToDestination - this.distanceOfDefault) * this.feePerDistance + defaultFee;
    }
}

class Test {
    public static void main(String[] args) {
        Bus mybus = new Bus(1245);
        System.out.println(mybus.carNum);

        mybus.getPeople(80);
    }
}
