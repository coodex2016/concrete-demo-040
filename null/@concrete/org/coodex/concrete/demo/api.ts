/* tslint:disable */
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { AbstractConcreteService } from '../../../../AbstractConcreteService';

import { CarInfo } from '../../../../org/coodex/concrete/demo/pojo';

@Injectable()
export class TokenDemoService extends AbstractConcreteService {

    constructor(private http: HttpClient) {
        super();
    }

    public getTokenValue(): Observable<string> {
        return this.http.request('GET', TokenDemoService.$$getServiceRoot() + `/OrgCoodexConcreteDemoApiTokenDemoService/tokenValue`, TokenDemoService.defaultRequestOptions())
                .pipe(map(TokenDemoService.extractData), catchError(TokenDemoService.handleError));
    }
    public setTokenValue(value: string): Observable<void> {
        return this.http.request('PUT', TokenDemoService.$$getServiceRoot() + `/OrgCoodexConcreteDemoApiTokenDemoService/tokenValue`, TokenDemoService.defaultRequestOptions(value))
                .pipe(map(TokenDemoService.extractData), catchError(TokenDemoService.handleError));
    }
}

@Injectable()
export class SubjoinExampleService extends AbstractConcreteService {

    constructor(private http: HttpClient) {
        super();
    }

    public add(x1: number, x2: number): Observable<number> {
        return this.http.request('POST', SubjoinExampleService.$$getServiceRoot() + `/SubjoinExample/add`, SubjoinExampleService.defaultRequestOptions({ x1, x2 }))
                .pipe(map(SubjoinExampleService.extractData), catchError(SubjoinExampleService.handleError));
    }
    public sayHello(name: string): Observable<string> {
        return this.http.request('POST', SubjoinExampleService.$$getServiceRoot() + `/SubjoinExample/sayHello`, SubjoinExampleService.defaultRequestOptions(name))
                .pipe(map(SubjoinExampleService.extractData), catchError(SubjoinExampleService.handleError));
    }
}

@Injectable()
export class TimeLimitedService extends AbstractConcreteService {

    constructor(private http: HttpClient) {
        super();
    }

    public breakfast(): Observable<void> {
        return this.http.request('GET', TimeLimitedService.$$getServiceRoot() + `/OrgCoodexConcreteDemoApiTimeLimitedService/breakfast`, TimeLimitedService.defaultRequestOptions())
                .pipe(map(TimeLimitedService.extractData), catchError(TimeLimitedService.handleError));
    }
    public dinner(): Observable<void> {
        return this.http.request('GET', TimeLimitedService.$$getServiceRoot() + `/OrgCoodexConcreteDemoApiTimeLimitedService/dinner`, TimeLimitedService.defaultRequestOptions())
                .pipe(map(TimeLimitedService.extractData), catchError(TimeLimitedService.handleError));
    }
    public lunch(): Observable<void> {
        return this.http.request('GET', TimeLimitedService.$$getServiceRoot() + `/OrgCoodexConcreteDemoApiTimeLimitedService/lunch`, TimeLimitedService.defaultRequestOptions())
                .pipe(map(TimeLimitedService.extractData), catchError(TimeLimitedService.handleError));
    }
    public work(): Observable<void> {
        return this.http.request('GET', TimeLimitedService.$$getServiceRoot() + `/OrgCoodexConcreteDemoApiTimeLimitedService/work`, TimeLimitedService.defaultRequestOptions())
                .pipe(map(TimeLimitedService.extractData), catchError(TimeLimitedService.handleError));
    }
}

@Injectable()
export class AddService extends AbstractConcreteService {

    constructor(private http: HttpClient) {
        super();
    }

    public add(x1: number, x2: number): Observable<number> {
        return this.http.request('POST', AddService.$$getServiceRoot() + `/OrgCoodexConcreteDemoApiAddService/add`, AddService.defaultRequestOptions({ x1, x2 }))
                .pipe(map(AddService.extractData), catchError(AddService.handleError));
    }
}

@Injectable()
export class AddWithIn10Service extends AbstractConcreteService {

    constructor(private http: HttpClient) {
        super();
    }

    public add(x1: number, x2: number): Observable<number> {
        return this.http.request('POST', AddWithIn10Service.$$getServiceRoot() + `/OrgCoodexConcreteDemoApiAddWithIn10Service/add`, AddWithIn10Service.defaultRequestOptions({ x1, x2 }))
                .pipe(map(AddWithIn10Service.extractData), catchError(AddWithIn10Service.handleError));
    }
}

@Injectable()
export class CarService extends AbstractConcreteService {

    constructor(private http: HttpClient) {
        super();
    }

    public getCarById(id: string): Observable<CarInfo> {
        return this.http.request('GET', CarService.$$getServiceRoot() + `/Cars/${id}`, CarService.defaultRequestOptions())
                .pipe(map(CarService.extractData), catchError(CarService.handleError));
    }
    public getCarNumberById(id: string): Observable<string> {
        return this.http.request('GET', CarService.$$getServiceRoot() + `/Cars/${id}/PlateCode`, CarService.defaultRequestOptions())
                .pipe(map(CarService.extractData), catchError(CarService.handleError));
    }
    public warningExample(): Observable<number> {
        return this.http.request('GET', CarService.$$getServiceRoot() + `/Cars/warningExample`, CarService.defaultRequestOptions())
                .pipe(map(CarService.extractData), catchError(CarService.handleError));
    }
}
