/* tslint:disable */


export class Identifiable<ID, POJO> {
    id: ID;
    pojo: POJO;
}


export class StrID<P> extends Identifiable<string, P> {
}

