/* eslint-disable */
import {argumentsError, execute, overload} from '../concrete'

const module = 'concrete'

const LibraryA = {
    'sort': function () {
        return execute(module, `/A/Books/sort`, 'json', 'GET');
    }, 
    'delete': function (name) {
        return execute(module, `/A/Books/${name}`, 'json', 'DELETE');
    }
}

export default LibraryA


