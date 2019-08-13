/* tslint:disable */
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ConcreteHeadersInterceptor, Broadcast } from './AbstractConcreteService';
import { AddService, AddWithIn10Service, CarService, SubjoinExampleService, TimeLimitedService, TokenDemoService } from './org/coodex/concrete/demo/api';
import { DemoLoginService, DemoSignatureService, LibraryA, LibraryB, LimitingService, MessageTriggerService } from './org/coodex/concrete/demo/api/excepted';

export * from './AbstractConcreteService';
export * from './org/coodex/concrete/api/pojo';
export * from './org/coodex/concrete/demo/api';
export * from './org/coodex/concrete/demo/api/excepted';
export * from './org/coodex/concrete/demo/pojo';


@NgModule({
    declarations: [],
    imports: [HttpClientModule],
    providers: [{
        provide: HTTP_INTERCEPTORS,
        useClass: ConcreteHeadersInterceptor,
        multi: true,
    }, Broadcast, AddService, AddWithIn10Service, CarService, DemoLoginService, DemoSignatureService, LibraryA, LibraryB, LimitingService, MessageTriggerService, SubjoinExampleService, TimeLimitedService, TokenDemoService],
})
export class ConcreteJaxRSModule {
}
