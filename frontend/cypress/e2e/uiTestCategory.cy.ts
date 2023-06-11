import { forEach } from 'cypress/types/lodash';
describe('UI Test Category', () => {
    beforeEach(() => {
        cy.visit('http://localhost:4200/category');
    });

    describe('Check UI-Elements', () => {
        it('Check Submit Button', () => {
            //Check if buttons exist
            cy.contains('button', 'Add Category').should('exist');
        });

        it('Check name field', () => {
            //Check if field exist
            cy.get('input[placeholder="Name"]').should('exist');
        });

        it('Check description field', () => {
            //Check if field exist
            cy.get('input[placeholder="Description"]').should('exist');
        });

        it('Check min humidity field', () => {
            //Check if field exist
            cy.get('input[placeholder="Min Humidity Level"]').should('exist');
        });
    });

    describe('Check UI-Elements functionality', () => {
        it('Check maxlength = 40 on Name field and maxlength = 100 on description ', () => {
            cy.get('input[placeholder="Name"]').type('Lorem ipsum dolor sit amet, consectetuer adip');

            cy.get('input[placeholder="Description"]').type('Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.');

            cy.get('input[placeholder="Min Humidity Level"]', ).type('100');

            //Click submit button
            cy.get('button').contains('Add Category').click();

            //Verify the added category
            cy.contains('table td', 'Lorem ipsum dolor sit amet, consectetuer adip').should('exist');
            cy.contains('Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa').should('exist');
        });

        it('fill out form, submits and deletes the category', () => {
            cy.get('input[placeholder="Name"]').type('Category Name');
            cy.get('input[placeholder="Description"]').type('Category Description');
            cy.get('input[placeholder="Min Humidity Level"]').type('10');

            cy.get('button').contains('Add Category').click();

        // Find the button within the last <td> element
        cy.contains('table td', 'Category Name')
            .siblings('td')
            .contains('Delete')
            .click();
        });

        //Delete an existing category that is not longer needed
        it('delete an existing category', () => {
            cy.contains('table td', 'Lorem ipsum dolor sit amet, consectetuer adip')
                .siblings('td')
                .contains('Delete')
                .click();
        });
    });
});
