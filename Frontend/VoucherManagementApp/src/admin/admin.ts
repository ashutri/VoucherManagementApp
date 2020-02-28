export class Admin {
    voucherId: string;
    faceValue: number;
    startDate: Date;
    expiryDate: Date;
    redeemed: boolean;
    constructor(id: string, faceValue: number, startDate: Date, expiryDate: Date, redeemed: boolean) {
        this.voucherId = id;
        this.faceValue = faceValue;
        this.startDate = startDate;
        this.expiryDate = expiryDate;
        this.redeemed = redeemed;
    }
}