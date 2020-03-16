class Flat {

        int pricePerSqrMeter;
        int SqrMeters;

    public Flat( int pricePerSqrMeter, int sqrMeters){
            this.pricePerSqrMeter = pricePerSqrMeter;
            this.SqrMeters = sqrMeters;
        }
        public int calculateRentalPrice () {
            return (this.pricePerSqrMeter * this.SqrMeters);
        }
    }

