export class Consumer {
    mobile: number;
    vArray: Array<string> = []; 
    constructor(mobile:number, vArray: Array<string> = []) {
        this.mobile = mobile;
        this.vArray = vArray;       
    }
}