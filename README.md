We’d love to see some of your code. It should take about two hours to put together, and we give feedback on every submission. If it passes our tests, we’ll continue to a pair programming session with you where we interactively add some features.

Let’s say that, besides providing invoice finance, NoviCap runs a physical store which sells 3 products:

Code         | Name         |  Price
----------------------------------------
VOUCHER      | Voucher      |   5.00€
TSHIRT       | T-shirt      |  20.00€
MUG          | Coffee mug   |   7.50€
Various departments have suggested some discounts to improve sales:

The marketing department wants a 2-for-1 special on VOUCHER items.
The CFO insists that the best way to increase sales is with (tiny) discounts on bulk purchases. If you buy 3 or more TSHIRT items, the price per unit should be 19.00€.
The checkout process allows for items to be scanned in any order, and calculates the total price. The interface looks like this (in ruby):

checkout = Checkout.new(price_rules)
checkout.scan("VOUCHER")
checkout.scan("VOUCHER")
checkout.scan("TSHIRT")
price = checkout.total

Examples:

Items: VOUCHER, TSHIRT, MUG
Total: 32.50€
Items: VOUCHER, TSHIRT, VOUCHER
Total: 25.00€
Items: TSHIRT, TSHIRT, TSHIRT, VOUCHER, TSHIRT
Total: 81.00€
Items: VOUCHER, TSHIRT, VOUCHER, VOUCHER, MUG, TSHIRT, TSHIRT
Total: 74.50€
Our team will add, remove, and change products and discounts, so they should be configurable with a JSON file. They’re definitely going to get creative with the discounts in the next session.

We just want the checkout library: no need to add a frontend, CLI interface, or database. If it takes longer than 3 hours, you’re probably doing too much!

We’re looking for:

Production-ready code
Something that’s easy to work with, because we’ll play with the business logic in the next session
Comments explaining why decisions are made and what the tradeoffs are
A programming language that you’re comfortable with; if you don’t use ruby, just make sure that the interface is equivalent to the example
Simplicity; we value clean, minimal, well-designed code; no points for showing off