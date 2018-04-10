package org.codetome.kotlincode.fpgrandma

import arrow.core.Option
import arrow.core.getOrElse
import org.codetome.kotlincode.fpgrandma.Example1.Material.*
import org.codetome.kotlincode.fpgrandma.Example1.Part.*
import org.codetome.kotlincode.fpgrandma.Example1.ProductQuality.*
import org.slf4j.LoggerFactory
import kotlin.math.roundToInt

object Example1 {

    private val logger = LoggerFactory.getLogger(javaClass)

    @JvmStatic
    fun main(args: Array<String>) {

        // raw materials
        val handleMaterials = listOf(
                PlasticScrap(1, 0),
                PlasticScrap(3, 1),
                PlasticScrap(2, -1))

        val lidMaterials = listOf(
                PlasticScrap(1, -1),
                PlasticScrap(3, 1),
                PlasticScrap(2, 8))

        val iron = listOf(RawIron(2, 2),
                RawIron(1, 1),
                RawIron(4, 7))

        val glassMaterials = listOf(GlassMaterial(3, -2),
                GlassMaterial(2, 0),
                GlassMaterial(2, 6))

        logger.info("Original handle materials: $handleMaterials")
        logger.info("Original lid materials: $lidMaterials")
        logger.info("Original iron: $iron")
        logger.info("Original glass materials: $glassMaterials")
        logger.info("===========================================")


        val filteredHandleMats = handleMaterials.filterRefuse()
        val filteredLidMats = lidMaterials.filterRefuse()
        val filteredIron = iron.filterRefuse()
        val filteredGlass = glassMaterials.filterRefuse()

        logger.info("Handle materials after refuse filtered: $filteredHandleMats")
        logger.info("Lid materials after refuse filtered: $filteredLidMats")
        logger.info("Iron after refuse filtered: $filteredIron")
        logger.info("Glass materials after refuse filtered: $filteredGlass")
        logger.info("===========================================")

        val preparedHandleMats = handleMaterials.filterRefuse().makeUnits()
        val preparedLidMats = lidMaterials.filterRefuse().makeUnits()
        val preparedIron = iron.filterRefuse().makeUnits()
        val preparedGlass = glassMaterials.filterRefuse().makeUnits()

        logger.info("Prepared handle materials: $preparedHandleMats")
        logger.info("Prepared lid materials: $preparedLidMats")
        logger.info("Prepared iron: $preparedIron")
        logger.info("Prepared glass materials: $preparedGlass")
        logger.info("===========================================")

        val potHandles = handleMaterials.filterRefuse().makeUnits().map(PlasticScrap::makePotHandle)
        val lidHandles = lidMaterials.filterRefuse().makeUnits().map(PlasticScrap::makeLidHandle)
        val pots = iron.filterRefuse().makeUnits().map(RawIron::makePot)
        val lids = glassMaterials.filterRefuse().makeUnits().map(GlassMaterial::makeLid)

        logger.info("Pot handles: $potHandles")
        logger.info("Lid handles: $lidHandles")
        logger.info("Pots: $pots")
        logger.info("Lids: $lids")
        logger.info("===========================================")

        val potsWithHandle = pots.zip(potHandles, { pot, handle ->
            pot.copy(handle = Option.pure(handle))
        })

        val lidsWithHandle = lids.zip(lidHandles, { lid, handle ->
            lid.copy(handle = Option.pure(handle))
        })

        val cookingPots = potsWithHandle.zip(lidsWithHandle, { potWithHandle, lidWithHandle ->
            CookingPot(potWithHandle, lidWithHandle)
        })

        logger.info("Crafted cooking pots:")
        logger.info(cookingPots.joinToString(separator = "\n"))
        logger.info("===========================================")

        val potsGroupedByQuality = cookingPots.groupBy { it.productQuality }
        logger.info("Cooking pots by quality:")
        potsGroupedByQuality.forEach { key, value ->
            logger.info("${key.name}: ${value.count()}.")
        }
        logger.info("===========================================")

        val productsToSell = potsGroupedByQuality[GOOD]!!.toList()
                .plus(potsGroupedByQuality[ACCEPTABLE]!!.toList())

        val productsToDiscard = potsGroupedByQuality[BAD]!!.toList()

        logger.info("Products we can sell: ${productsToSell.count()}.")
        logger.info("Products to discard: ${productsToDiscard.count()}.")
        logger.info("===========================================")

        val leftoverScrap = productsToDiscard
                .map(CookingPot::turnToScrap)
                .reduce { acc, next -> acc.copy(amount = acc.amount + next.amount) }

        logger.info("Leftover scrap amount: ${leftoverScrap.amount}")
    }

    enum class ProductQuality {
        GOOD,
        ACCEPTABLE,
        BAD;

        companion object {

            fun calculateFromQuality(quality: Int) = when {
                quality > 1 -> GOOD
                quality == 1 -> ACCEPTABLE
                else -> {
                    BAD
                }
            }
        }
    }

    // TODO: can these be solved with arrow using typeclasses?
    private inline fun <reified T : Material> List<T>.makeUnits(): List<T> =
            this.flatMap { material ->
                (0 until material.amount).map {
                    T::class.constructors.first().call(1, material.quality)
                }
            }

    private fun <T : Material> List<T>.filterRefuse(): List<T> =
            this.filter { it.quality >= 0 }

    sealed class Material(open val amount: Int,
                          open val quality: Int) {

        data class PlasticScrap(override val amount: Int,
                                override val quality: Int) : Material(amount, quality) {

            fun makeLidHandle() = LidHandle(quality - 1)

            fun makePotHandle() = PotHandle(quality -1)
        }

        data class RawIron(override val amount: Int,
                           override val quality: Int) : Material(amount, quality) {

            fun makePot() = Pot(quality - 1)
        }

        data class GlassMaterial(override val amount: Int,
                                 override val quality: Int) : Material(amount, quality) {

            fun makeLid() = Lid(quality - 1)
        }
    }

    sealed class Part(open val quality: Int) {

        data class PotHandle(override val quality: Int) : Part(quality)

        data class LidHandle(override val quality: Int) : Part(quality)

        data class Pot(override val quality: Int,
                       val handle: Option<PotHandle> = Option.empty(),
                       val lid: Option<Lid> = Option.empty()) : Part(quality)

        data class Lid(override val quality: Int,
                       val handle: Option<LidHandle> = Option.empty()) : Part(quality)
    }

    data class CookingPot(
            val pot: Pot,
            val lid: Lid,
            val productQuality: ProductQuality = calculateProductQuality(pot, lid)) {

        fun turnToScrap() = Scrap(4)

        companion object {
            private fun calculateProductQuality(pot: Pot,
                                                lid: Lid) = ProductQuality.calculateFromQuality(listOf(
                    pot.quality,
                    lid.quality,
                    lid.handle.getOrElse { throw IllegalArgumentException("Not present") }.quality,
                    pot.handle.getOrElse { throw IllegalArgumentException("Not present") }.quality)
                    .average()
                    .roundToInt())
        }
    }

    data class Scrap(val amount: Int)
}




