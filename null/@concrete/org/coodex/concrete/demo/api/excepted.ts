/* tslint:disable */
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { AbstractConcreteService } from '../../../../../AbstractConcreteService';

import { ExamplePojo } from '../../../../../org/coodex/concrete/demo/pojo';

@Injectable()
export class LibraryB extends AbstractConcreteService {

    constructor(private http: HttpClient) {
        super();
    }

    public delete(name: string): Observable<void> {
        return this.http.request('DELETE', LibraryB.$$getServiceRoot() + `/B/Books/${name}`, LibraryB.defaultRequestOptions())
                .pipe(map(LibraryB.extractData), catchError(LibraryB.handleError));
    }
    public sort(): Observable<void> {
        return this.http.request('GET', LibraryB.$$getServiceRoot() + `/B/Books/sort`, LibraryB.defaultRequestOptions())
                .pipe(map(LibraryB.extractData), catchError(LibraryB.handleError));
    }
}

@Injectable()
export class DemoSignatureService extends AbstractConcreteService {

    constructor(private http: HttpClient) {
        super();
    }

    public doSomeThing(a: number, kkk: string, pojo: ExamplePojo): Observable<void> {
        return this.http.request('POST', DemoSignatureService.$$getServiceRoot() + `/OrgCoodexConcreteDemoApiExceptedDemoSignatureService/doSomeThing`, DemoSignatureService.defaultRequestOptions({ a, kkk, pojo }))
                .pipe(map(DemoSignatureService.extractData), catchError(DemoSignatureService.handleError));
    }
}

@Injectable()
export class LimitingService extends AbstractConcreteService {

    constructor(private http: HttpClient) {
        super();
    }

    public demoMaximumConcurrency(): Observable<void> {
        return this.http.request('GET', LimitingService.$$getServiceRoot() + `/OrgCoodexConcreteDemoApiExceptedLimitingService/demoMaximumConcurrency`, LimitingService.defaultRequestOptions())
                .pipe(map(LimitingService.extractData), catchError(LimitingService.handleError));
    }
    public demoTokenBucket(): Observable<void> {
        return this.http.request('GET', LimitingService.$$getServiceRoot() + `/OrgCoodexConcreteDemoApiExceptedLimitingService/demoTokenBucket`, LimitingService.defaultRequestOptions())
                .pipe(map(LimitingService.extractData), catchError(LimitingService.handleError));
    }
}

@Injectable()
export class DemoLoginService extends AbstractConcreteService {

    constructor(private http: HttpClient) {
        super();
    }

    public login(id: string): Observable<void> {
        return this.http.request('POST', DemoLoginService.$$getServiceRoot() + `/OrgCoodexConcreteDemoApiExceptedDemoLoginService/login`, DemoLoginService.defaultRequestOptions(id))
                .pipe(map(DemoLoginService.extractData), catchError(DemoLoginService.handleError));
    }
}

@Injectable()
export class MessageTriggerService extends AbstractConcreteService {

    constructor(private http: HttpClient) {
        super();
    }

    public trigger(x: string): Observable<void> {
        return this.http.request('POST', MessageTriggerService.$$getServiceRoot() + `/OrgCoodexConcreteDemoApiExceptedMessageTriggerService/trigger`, MessageTriggerService.defaultRequestOptions(x))
                .pipe(map(MessageTriggerService.extractData), catchError(MessageTriggerService.handleError));
    }
}

@Injectable()
export class LibraryA extends AbstractConcreteService {

    constructor(private http: HttpClient) {
        super();
    }

    public delete(name: string): Observable<void> {
        return this.http.request('DELETE', LibraryA.$$getServiceRoot() + `/A/Books/${name}`, LibraryA.defaultRequestOptions())
                .pipe(map(LibraryA.extractData), catchError(LibraryA.handleError));
    }
    public sort(): Observable<void> {
        return this.http.request('GET', LibraryA.$$getServiceRoot() + `/A/Books/sort`, LibraryA.defaultRequestOptions())
                .pipe(map(LibraryA.extractData), catchError(LibraryA.handleError));
    }
}
