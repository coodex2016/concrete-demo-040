/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const TimeLimitedService = {
    'lunch': function () {
        return execute(module, `/OrgCoodexConcreteDemoApiTimeLimitedService/lunch`, 'json', 'GET');
    }, 
    'work': function () {
        return execute(module, `/OrgCoodexConcreteDemoApiTimeLimitedService/work`, 'json', 'GET');
    }, 
    'breakfast': function () {
        return execute(module, `/OrgCoodexConcreteDemoApiTimeLimitedService/breakfast`, 'json', 'GET');
    }, 
    'dinner': function () {
        return execute(module, `/OrgCoodexConcreteDemoApiTimeLimitedService/dinner`, 'json', 'GET');
    }
}

export default TimeLimitedService


