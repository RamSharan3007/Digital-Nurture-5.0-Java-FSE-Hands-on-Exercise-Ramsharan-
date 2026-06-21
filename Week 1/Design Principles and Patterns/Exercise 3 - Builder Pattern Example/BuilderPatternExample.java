public class BuilderPatternExample 
{
    static class Computer {
        private String CPU;
        private String RAM;
        private String storage;

        private Computer(Builder builder) {
            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.storage = builder.storage;
        }
        public void showSpecs() {
            System.out.println("CPU: " + CPU);
            System.out.println("RAM: " + RAM);
            System.out.println("Storage: " + storage);
        }
        static class Builder {
            private String CPU;
            private String RAM;
            private String storage;

            public Builder setCPU(String CPU) {
                this.CPU = CPU;
                return this;
            }
            public Builder setRAM(String RAM) {
                this.RAM = RAM;
                return this;
            }
            public Builder setStorage(String storage) {
                this.storage = storage;
                return this;
            }
            public Computer build() {
                return new Computer(this);
            }
        }
    }
    

public static void main(String[] args)
{
    Computer basicPC = new Computer.Builder()
            .setCPU("Intel i5")
            .setRAM("8GB")
            .setStorage("256GB SSD")
            .build();
    basicPC.showSpecs();
    Computer gamingPC = new Computer.Builder()
            .setCPU("AMD Ryzen 7")
            .setRAM("16GB")
            .setStorage("1TB SSD")
            .build();                
    gamingPC.showSpecs();
    Computer workstationPC = new Computer.Builder()
            .setCPU("Intel Xeon")
            .setRAM("32GB")
            .setStorage("2TB SSD")
            .build();
    workstationPC.showSpecs();              
}
}