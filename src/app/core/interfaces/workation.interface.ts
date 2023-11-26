import { RiskEnum } from "../enums/risk.enum";

export interface WorkationInterface {
    workationId: string;
    employeeName: string;
    originName: string;
    destinationName: string;
    start: string;
    end: string;
    workingDays: string;
    risk: RiskEnum;

}