/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const SubjoinExampleService = {
    'add': function (x1, x2) {
        return execute(module, `/SubjoinExample/add`, 'json', 'POST', { x1, x2 });
    }, 
    'sayHello': function (name) {
        return execute(module, `/SubjoinExample/sayHello`, 'text', 'POST', name);
    }
}

export default SubjoinExampleService


