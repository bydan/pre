/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.importaciones.util;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.importaciones.util.DetallePedidoCompraImporConstantesFunciones;
import com.bydan.erp.importaciones.util.DetallePedidoCompraImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.DetallePedidoCompraImporParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.importaciones.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.importaciones.business.dataaccess.*;
//import com.bydan.erp.importaciones.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetallePedidoCompraImporConstantesFunciones extends DetallePedidoCompraImporConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="DetallePedidoCompraImpor";
	public static final String SPATHOPCION="Importaciones";	
	public static final String SPATHMODULO="importaciones/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetallePedidoCompraImpor"+DetallePedidoCompraImporConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetallePedidoCompraImporHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetallePedidoCompraImporHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetallePedidoCompraImporConstantesFunciones.SCHEMA+"_"+DetallePedidoCompraImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetallePedidoCompraImporHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetallePedidoCompraImporConstantesFunciones.SCHEMA+"_"+DetallePedidoCompraImporConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetallePedidoCompraImporConstantesFunciones.SCHEMA+"_"+DetallePedidoCompraImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetallePedidoCompraImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetallePedidoCompraImporConstantesFunciones.SCHEMA+"_"+DetallePedidoCompraImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoCompraImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePedidoCompraImporHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoCompraImporConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoCompraImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePedidoCompraImporHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePedidoCompraImporConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetallePedidoCompraImporConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetallePedidoCompraImporConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetallePedidoCompraImporConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetallePedidoCompraImporConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Pedido Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Pedido Compra";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Pedido Compra Impor";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetallePedidoCompraImpor";
	public static final String OBJECTNAME="detallepedidocompraimpor";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_IMPORTACIONES;	
	public static final String TABLENAME="detalle_pedido_compra_impor";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallepedidocompraimpor from "+DetallePedidoCompraImporConstantesFunciones.SPERSISTENCENAME+" detallepedidocompraimpor";
	public static String QUERYSELECTNATIVE="select "+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".version_row,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_pedido_compra_impor,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_empresa,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_sucursal,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_bodega,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_producto,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_unidad,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_ejercicio,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_periodo,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_arancel,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".cantidad_pedido,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".cantidad_entra,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".cantidad_pendiente,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".porcentaje,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".peso,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".precio,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".lote,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".porcentaje_arancel,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".cantidad_unidad_auxiliar,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".precio_unidad_auxiliar,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".fob,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".fob_exw,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".total,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".descripcion,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_centro_costo,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_anio,"+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME+".id_mes from "+DetallePedidoCompraImporConstantesFunciones.SCHEMA+"."+DetallePedidoCompraImporConstantesFunciones.TABLENAME;//+" as "+DetallePedidoCompraImporConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetallePedidoCompraImporConstantesFuncionesAdditional detallepedidocompraimporConstantesFuncionesAdditional=null;
	
	public DetallePedidoCompraImporConstantesFuncionesAdditional getDetallePedidoCompraImporConstantesFuncionesAdditional() {
		return this.detallepedidocompraimporConstantesFuncionesAdditional;
	}
	
	public void setDetallePedidoCompraImporConstantesFuncionesAdditional(DetallePedidoCompraImporConstantesFuncionesAdditional detallepedidocompraimporConstantesFuncionesAdditional) {
		try {
			this.detallepedidocompraimporConstantesFuncionesAdditional=detallepedidocompraimporConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPEDIDOCOMPRAIMPOR= "id_pedido_compra_impor";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDBODEGA= "id_bodega";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDUNIDAD= "id_unidad";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDARANCEL= "id_arancel";
    public static final String CANTIDADPEDIDO= "cantidad_pedido";
    public static final String CANTIDADENTRA= "cantidad_entra";
    public static final String CANTIDADPENDIENTE= "cantidad_pendiente";
    public static final String PORCENTAJE= "porcentaje";
    public static final String PESO= "peso";
    public static final String PRECIO= "precio";
    public static final String LOTE= "lote";
    public static final String PORCENTAJEARANCEL= "porcentaje_arancel";
    public static final String CANTIDADUNIDADAUXILIAR= "cantidad_unidad_auxiliar";
    public static final String PRECIOUNIDADAUXILIAR= "precio_unidad_auxiliar";
    public static final String FOB= "fob";
    public static final String FOBEXW= "fob_exw";
    public static final String TOTAL= "total";
    public static final String DESCRIPCION= "descripcion";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPEDIDOCOMPRAIMPOR= "Pedo Compra Impor";
		public static final String LABEL_IDPEDIDOCOMPRAIMPOR_LOWER= "Pedido Compra Impor";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDUNIDAD= "Unad";
		public static final String LABEL_IDUNIDAD_LOWER= "Unidad";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDARANCEL= "Arancel";
		public static final String LABEL_IDARANCEL_LOWER= "Arancel";
    	public static final String LABEL_CANTIDADPEDIDO= "Cantad Pedo";
		public static final String LABEL_CANTIDADPEDIDO_LOWER= "Cantidad Pedido";
    	public static final String LABEL_CANTIDADENTRA= "Cantad Entra";
		public static final String LABEL_CANTIDADENTRA_LOWER= "Cantidad Entra";
    	public static final String LABEL_CANTIDADPENDIENTE= "Cantad Pendiente";
		public static final String LABEL_CANTIDADPENDIENTE_LOWER= "Cantidad Pendiente";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_PESO= "Peso";
		public static final String LABEL_PESO_LOWER= "Peso";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_LOTE= "Lote";
		public static final String LABEL_LOTE_LOWER= "Lote";
    	public static final String LABEL_PORCENTAJEARANCEL= "Porcentaje Arancel";
		public static final String LABEL_PORCENTAJEARANCEL_LOWER= "Porcentaje Arancel";
    	public static final String LABEL_CANTIDADUNIDADAUXILIAR= "Cantad Unad Auxiliar";
		public static final String LABEL_CANTIDADUNIDADAUXILIAR_LOWER= "Cantidad Unidad Auxiliar";
    	public static final String LABEL_PRECIOUNIDADAUXILIAR= "Precio Unad Auxiliar";
		public static final String LABEL_PRECIOUNIDADAUXILIAR_LOWER= "Precio Unidad Auxiliar";
    	public static final String LABEL_FOB= "Fob";
		public static final String LABEL_FOB_LOWER= "Fob";
    	public static final String LABEL_FOBEXW= "Fob Exw";
		public static final String LABEL_FOBEXW_LOWER= "Fob Exw";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXLOTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXLOTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getDetallePedidoCompraImporLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_IDPEDIDOCOMPRAIMPOR;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.IDBODEGA)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.IDPRODUCTO)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.IDUNIDAD)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_IDUNIDAD;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.IDPERIODO)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.IDARANCEL)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_IDARANCEL;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADPEDIDO)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADPEDIDO;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADENTRA)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADENTRA;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADPENDIENTE)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADPENDIENTE;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.PORCENTAJE)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.PESO)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_PESO;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.PRECIO)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.LOTE)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_LOTE;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.PORCENTAJEARANCEL)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_PORCENTAJEARANCEL;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADUNIDADAUXILIAR)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADUNIDADAUXILIAR;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.PRECIOUNIDADAUXILIAR)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_PRECIOUNIDADAUXILIAR;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.FOB)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_FOB;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.FOBEXW)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_FOBEXW;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.TOTAL)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.IDANIO)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetallePedidoCompraImporConstantesFunciones.IDMES)) {sLabelColumna=DetallePedidoCompraImporConstantesFunciones.LABEL_IDMES;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetallePedidoCompraImporDescripcion(DetallePedidoCompraImpor detallepedidocompraimpor) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallepedidocompraimpor !=null/* && detallepedidocompraimpor.getId()!=0*/) {
			if(detallepedidocompraimpor.getId()!=null) {
				sDescripcion=detallepedidocompraimpor.getId().toString();
			}//detallepedidocompraimpordetallepedidocompraimpor.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetallePedidoCompraImporDescripcionDetallado(DetallePedidoCompraImpor detallepedidocompraimpor) {
		String sDescripcion="";
			
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.ID+"=";
		sDescripcion+=detallepedidocompraimpor.getId().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallepedidocompraimpor.getVersionRow().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR+"=";
		sDescripcion+=detallepedidocompraimpor.getid_pedido_compra_impor().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallepedidocompraimpor.getid_empresa().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallepedidocompraimpor.getid_sucursal().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=detallepedidocompraimpor.getid_bodega().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=detallepedidocompraimpor.getid_producto().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.IDUNIDAD+"=";
		sDescripcion+=detallepedidocompraimpor.getid_unidad().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallepedidocompraimpor.getid_ejercicio().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallepedidocompraimpor.getid_periodo().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.IDARANCEL+"=";
		sDescripcion+=detallepedidocompraimpor.getid_arancel().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.CANTIDADPEDIDO+"=";
		sDescripcion+=detallepedidocompraimpor.getcantidad_pedido().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.CANTIDADENTRA+"=";
		sDescripcion+=detallepedidocompraimpor.getcantidad_entra().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.CANTIDADPENDIENTE+"=";
		sDescripcion+=detallepedidocompraimpor.getcantidad_pendiente().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=detallepedidocompraimpor.getporcentaje().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.PESO+"=";
		sDescripcion+=detallepedidocompraimpor.getpeso().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.PRECIO+"=";
		sDescripcion+=detallepedidocompraimpor.getprecio().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.LOTE+"=";
		sDescripcion+=detallepedidocompraimpor.getlote()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.PORCENTAJEARANCEL+"=";
		sDescripcion+=detallepedidocompraimpor.getporcentaje_arancel().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.CANTIDADUNIDADAUXILIAR+"=";
		sDescripcion+=detallepedidocompraimpor.getcantidad_unidad_auxiliar().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.PRECIOUNIDADAUXILIAR+"=";
		sDescripcion+=detallepedidocompraimpor.getprecio_unidad_auxiliar().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.FOB+"=";
		sDescripcion+=detallepedidocompraimpor.getfob().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.FOBEXW+"=";
		sDescripcion+=detallepedidocompraimpor.getfob_exw().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.TOTAL+"=";
		sDescripcion+=detallepedidocompraimpor.gettotal().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detallepedidocompraimpor.getdescripcion()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detallepedidocompraimpor.getid_centro_costo().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallepedidocompraimpor.getid_anio().toString()+",";
		sDescripcion+=DetallePedidoCompraImporConstantesFunciones.IDMES+"=";
		sDescripcion+=detallepedidocompraimpor.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetallePedidoCompraImporDescripcion(DetallePedidoCompraImpor detallepedidocompraimpor,String sValor) throws Exception {			
		if(detallepedidocompraimpor !=null) {
			//detallepedidocompraimpordetallepedidocompraimpor.getId().toString();
		}		
	}
	
		

	public static String getPedidoCompraImporDescripcion(PedidoCompraImpor pedidocompraimpor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pedidocompraimpor!=null/*&&pedidocompraimpor.getId()>0*/) {
			sDescripcion=PedidoCompraImporConstantesFunciones.getPedidoCompraImporDescripcion(pedidocompraimpor);
		}

		return sDescripcion;
	}

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
	}

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}

	public static String getUnidadDescripcion(Unidad unidad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(unidad!=null/*&&unidad.getId()>0*/) {
			sDescripcion=UnidadConstantesFunciones.getUnidadDescripcion(unidad);
		}

		return sDescripcion;
	}

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getArancelDescripcion(Arancel arancel) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(arancel!=null/*&&arancel.getId()>0*/) {
			sDescripcion=ArancelConstantesFunciones.getArancelDescripcion(arancel);
		}

		return sDescripcion;
	}

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdArancel")) {
			sNombreIndice="Tipo=  Por Arancel";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPedidoCompraImpor")) {
			sNombreIndice="Tipo=  Por Pedo Compra Impor";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUnidad")) {
			sNombreIndice="Tipo=  Por Unad";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdArancel(Long id_arancel) {
		String sDetalleIndice=" Parametros->";
		if(id_arancel!=null) {sDetalleIndice+=" Codigo Unico De Arancel="+id_arancel.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPedidoCompraImpor(Long id_pedido_compra_impor) {
		String sDetalleIndice=" Parametros->";
		if(id_pedido_compra_impor!=null) {sDetalleIndice+=" Codigo Unico De Pedo Compra Impor="+id_pedido_compra_impor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUnidad(Long id_unidad) {
		String sDetalleIndice=" Parametros->";
		if(id_unidad!=null) {sDetalleIndice+=" Codigo Unico De Unad="+id_unidad.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetallePedidoCompraImpor(DetallePedidoCompraImpor detallepedidocompraimpor,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallepedidocompraimpor.setlote(detallepedidocompraimpor.getlote().trim());
		detallepedidocompraimpor.setdescripcion(detallepedidocompraimpor.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetallePedidoCompraImpors(List<DetallePedidoCompraImpor> detallepedidocompraimpors,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallePedidoCompraImpor detallepedidocompraimpor: detallepedidocompraimpors) {
			detallepedidocompraimpor.setlote(detallepedidocompraimpor.getlote().trim());
			detallepedidocompraimpor.setdescripcion(detallepedidocompraimpor.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePedidoCompraImpor(DetallePedidoCompraImpor detallepedidocompraimpor,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallepedidocompraimpor.getConCambioAuxiliar()) {
			detallepedidocompraimpor.setIsDeleted(detallepedidocompraimpor.getIsDeletedAuxiliar());	
			detallepedidocompraimpor.setIsNew(detallepedidocompraimpor.getIsNewAuxiliar());	
			detallepedidocompraimpor.setIsChanged(detallepedidocompraimpor.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallepedidocompraimpor.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallepedidocompraimpor.setIsDeletedAuxiliar(false);	
			detallepedidocompraimpor.setIsNewAuxiliar(false);	
			detallepedidocompraimpor.setIsChangedAuxiliar(false);
			
			detallepedidocompraimpor.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePedidoCompraImpors(List<DetallePedidoCompraImpor> detallepedidocompraimpors,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetallePedidoCompraImpor detallepedidocompraimpor : detallepedidocompraimpors) {
			if(conAsignarBase && detallepedidocompraimpor.getConCambioAuxiliar()) {
				detallepedidocompraimpor.setIsDeleted(detallepedidocompraimpor.getIsDeletedAuxiliar());	
				detallepedidocompraimpor.setIsNew(detallepedidocompraimpor.getIsNewAuxiliar());	
				detallepedidocompraimpor.setIsChanged(detallepedidocompraimpor.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallepedidocompraimpor.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallepedidocompraimpor.setIsDeletedAuxiliar(false);	
				detallepedidocompraimpor.setIsNewAuxiliar(false);	
				detallepedidocompraimpor.setIsChangedAuxiliar(false);
				
				detallepedidocompraimpor.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetallePedidoCompraImpor(DetallePedidoCompraImpor detallepedidocompraimpor,Boolean conEnteros) throws Exception  {
		detallepedidocompraimpor.setporcentaje(0.0);
		detallepedidocompraimpor.setpeso(0.0);
		detallepedidocompraimpor.setprecio(0.0);
		detallepedidocompraimpor.setporcentaje_arancel(0.0);
		detallepedidocompraimpor.setprecio_unidad_auxiliar(0.0);
		detallepedidocompraimpor.setfob(0.0);
		detallepedidocompraimpor.setfob_exw(0.0);
		detallepedidocompraimpor.settotal(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			detallepedidocompraimpor.setcantidad_pedido(0);
			detallepedidocompraimpor.setcantidad_entra(0);
			detallepedidocompraimpor.setcantidad_pendiente(0);
			detallepedidocompraimpor.setcantidad_unidad_auxiliar(0);
		}
	}		
	
	public static void InicializarValoresDetallePedidoCompraImpors(List<DetallePedidoCompraImpor> detallepedidocompraimpors,Boolean conEnteros) throws Exception  {
		
		for(DetallePedidoCompraImpor detallepedidocompraimpor: detallepedidocompraimpors) {
			detallepedidocompraimpor.setporcentaje(0.0);
			detallepedidocompraimpor.setpeso(0.0);
			detallepedidocompraimpor.setprecio(0.0);
			detallepedidocompraimpor.setporcentaje_arancel(0.0);
			detallepedidocompraimpor.setprecio_unidad_auxiliar(0.0);
			detallepedidocompraimpor.setfob(0.0);
			detallepedidocompraimpor.setfob_exw(0.0);
			detallepedidocompraimpor.settotal(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				detallepedidocompraimpor.setcantidad_pedido(0);
				detallepedidocompraimpor.setcantidad_entra(0);
				detallepedidocompraimpor.setcantidad_pendiente(0);
				detallepedidocompraimpor.setcantidad_unidad_auxiliar(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetallePedidoCompraImpor(List<DetallePedidoCompraImpor> detallepedidocompraimpors,DetallePedidoCompraImpor detallepedidocompraimporAux) throws Exception  {
		DetallePedidoCompraImporConstantesFunciones.InicializarValoresDetallePedidoCompraImpor(detallepedidocompraimporAux,true);
		
		for(DetallePedidoCompraImpor detallepedidocompraimpor: detallepedidocompraimpors) {
			if(detallepedidocompraimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallepedidocompraimporAux.setcantidad_pedido(detallepedidocompraimporAux.getcantidad_pedido()+detallepedidocompraimpor.getcantidad_pedido());			
			detallepedidocompraimporAux.setcantidad_entra(detallepedidocompraimporAux.getcantidad_entra()+detallepedidocompraimpor.getcantidad_entra());			
			detallepedidocompraimporAux.setcantidad_pendiente(detallepedidocompraimporAux.getcantidad_pendiente()+detallepedidocompraimpor.getcantidad_pendiente());			
			detallepedidocompraimporAux.setporcentaje(detallepedidocompraimporAux.getporcentaje()+detallepedidocompraimpor.getporcentaje());			
			detallepedidocompraimporAux.setpeso(detallepedidocompraimporAux.getpeso()+detallepedidocompraimpor.getpeso());			
			detallepedidocompraimporAux.setprecio(detallepedidocompraimporAux.getprecio()+detallepedidocompraimpor.getprecio());			
			detallepedidocompraimporAux.setporcentaje_arancel(detallepedidocompraimporAux.getporcentaje_arancel()+detallepedidocompraimpor.getporcentaje_arancel());			
			detallepedidocompraimporAux.setcantidad_unidad_auxiliar(detallepedidocompraimporAux.getcantidad_unidad_auxiliar()+detallepedidocompraimpor.getcantidad_unidad_auxiliar());			
			detallepedidocompraimporAux.setprecio_unidad_auxiliar(detallepedidocompraimporAux.getprecio_unidad_auxiliar()+detallepedidocompraimpor.getprecio_unidad_auxiliar());			
			detallepedidocompraimporAux.setfob(detallepedidocompraimporAux.getfob()+detallepedidocompraimpor.getfob());			
			detallepedidocompraimporAux.setfob_exw(detallepedidocompraimporAux.getfob_exw()+detallepedidocompraimpor.getfob_exw());			
			detallepedidocompraimporAux.settotal(detallepedidocompraimporAux.gettotal()+detallepedidocompraimpor.gettotal());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePedidoCompraImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetallePedidoCompraImporConstantesFunciones.getArrayColumnasGlobalesDetallePedidoCompraImpor(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePedidoCompraImpor(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoCompraImporConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoCompraImporConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePedidoCompraImporConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePedidoCompraImporConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetallePedidoCompraImpor(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallePedidoCompraImpor> detallepedidocompraimpors,DetallePedidoCompraImpor detallepedidocompraimpor,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallePedidoCompraImpor detallepedidocompraimporAux: detallepedidocompraimpors) {
			if(detallepedidocompraimporAux!=null && detallepedidocompraimpor!=null) {
				if((detallepedidocompraimporAux.getId()==null && detallepedidocompraimpor.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallepedidocompraimporAux.getId()!=null && detallepedidocompraimpor.getId()!=null){
					if(detallepedidocompraimporAux.getId().equals(detallepedidocompraimpor.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallePedidoCompraImpor(List<DetallePedidoCompraImpor> detallepedidocompraimpors) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double pesoTotal=0.0;
		Double precioTotal=0.0;
		Double porcentaje_arancelTotal=0.0;
		Double precio_unidad_auxiliarTotal=0.0;
		Double fobTotal=0.0;
		Double fob_exwTotal=0.0;
		Double totalTotal=0.0;
	
		for(DetallePedidoCompraImpor detallepedidocompraimpor: detallepedidocompraimpors) {			
			if(detallepedidocompraimpor.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=detallepedidocompraimpor.getporcentaje();
			pesoTotal+=detallepedidocompraimpor.getpeso();
			precioTotal+=detallepedidocompraimpor.getprecio();
			porcentaje_arancelTotal+=detallepedidocompraimpor.getporcentaje_arancel();
			precio_unidad_auxiliarTotal+=detallepedidocompraimpor.getprecio_unidad_auxiliar();
			fobTotal+=detallepedidocompraimpor.getfob();
			fob_exwTotal+=detallepedidocompraimpor.getfob_exw();
			totalTotal+=detallepedidocompraimpor.gettotal();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.PESO);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PESO);
		datoGeneral.setdValorDouble(pesoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.PORCENTAJEARANCEL);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PORCENTAJEARANCEL);
		datoGeneral.setdValorDouble(porcentaje_arancelTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.PRECIOUNIDADAUXILIAR);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PRECIOUNIDADAUXILIAR);
		datoGeneral.setdValorDouble(precio_unidad_auxiliarTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.FOB);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_FOB);
		datoGeneral.setdValorDouble(fobTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.FOBEXW);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_FOBEXW);
		datoGeneral.setdValorDouble(fob_exwTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePedidoCompraImporConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetallePedidoCompraImpor() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_ID, DetallePedidoCompraImporConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_VERSIONROW, DetallePedidoCompraImporConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_IDPEDIDOCOMPRAIMPOR, DetallePedidoCompraImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_IDEMPRESA, DetallePedidoCompraImporConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_IDSUCURSAL, DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_IDBODEGA, DetallePedidoCompraImporConstantesFunciones.IDBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_IDPRODUCTO, DetallePedidoCompraImporConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_IDUNIDAD, DetallePedidoCompraImporConstantesFunciones.IDUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_IDEJERCICIO, DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_IDPERIODO, DetallePedidoCompraImporConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_IDARANCEL, DetallePedidoCompraImporConstantesFunciones.IDARANCEL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADPEDIDO, DetallePedidoCompraImporConstantesFunciones.CANTIDADPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADENTRA, DetallePedidoCompraImporConstantesFunciones.CANTIDADENTRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADPENDIENTE, DetallePedidoCompraImporConstantesFunciones.CANTIDADPENDIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_PORCENTAJE, DetallePedidoCompraImporConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_PESO, DetallePedidoCompraImporConstantesFunciones.PESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_PRECIO, DetallePedidoCompraImporConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_LOTE, DetallePedidoCompraImporConstantesFunciones.LOTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_PORCENTAJEARANCEL, DetallePedidoCompraImporConstantesFunciones.PORCENTAJEARANCEL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADUNIDADAUXILIAR, DetallePedidoCompraImporConstantesFunciones.CANTIDADUNIDADAUXILIAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_PRECIOUNIDADAUXILIAR, DetallePedidoCompraImporConstantesFunciones.PRECIOUNIDADAUXILIAR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_FOB, DetallePedidoCompraImporConstantesFunciones.FOB,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_FOBEXW, DetallePedidoCompraImporConstantesFunciones.FOBEXW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_TOTAL, DetallePedidoCompraImporConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_DESCRIPCION, DetallePedidoCompraImporConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_IDCENTROCOSTO, DetallePedidoCompraImporConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_IDANIO, DetallePedidoCompraImporConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePedidoCompraImporConstantesFunciones.LABEL_IDMES, DetallePedidoCompraImporConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetallePedidoCompraImpor() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.IDBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.IDUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.IDARANCEL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.CANTIDADPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.CANTIDADENTRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.CANTIDADPENDIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.PESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.LOTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.PORCENTAJEARANCEL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.CANTIDADUNIDADAUXILIAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.PRECIOUNIDADAUXILIAR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.FOB;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.FOBEXW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePedidoCompraImporConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedidoCompraImpor() throws Exception  {
		return DetallePedidoCompraImporConstantesFunciones.getTiposSeleccionarDetallePedidoCompraImpor(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedidoCompraImpor(Boolean conFk) throws Exception  {
		return DetallePedidoCompraImporConstantesFunciones.getTiposSeleccionarDetallePedidoCompraImpor(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePedidoCompraImpor(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_IDPEDIDOCOMPRAIMPOR);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_IDPEDIDOCOMPRAIMPOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_IDUNIDAD);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_IDUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_IDARANCEL);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_IDARANCEL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADPEDIDO);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADENTRA);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADENTRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADPENDIENTE);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADPENDIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_PESO);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_LOTE);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_LOTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_PORCENTAJEARANCEL);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PORCENTAJEARANCEL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADUNIDADAUXILIAR);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADUNIDADAUXILIAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_PRECIOUNIDADAUXILIAR);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_PRECIOUNIDADAUXILIAR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_FOB);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_FOB);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_FOBEXW);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_FOBEXW);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePedidoCompraImporConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetallePedidoCompraImporConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetallePedidoCompraImpor(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(DetallePedidoCompraImpor detallepedidocompraimporAux) throws Exception {
		
			detallepedidocompraimporAux.setpedidocompraimpor_descripcion(PedidoCompraImporConstantesFunciones.getPedidoCompraImporDescripcion(detallepedidocompraimporAux.getPedidoCompraImpor()));
			detallepedidocompraimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepedidocompraimporAux.getEmpresa()));
			detallepedidocompraimporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallepedidocompraimporAux.getSucursal()));
			detallepedidocompraimporAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallepedidocompraimporAux.getBodega()));
			detallepedidocompraimporAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallepedidocompraimporAux.getProducto()));
			detallepedidocompraimporAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallepedidocompraimporAux.getUnidad()));
			detallepedidocompraimporAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallepedidocompraimporAux.getEjercicio()));
			detallepedidocompraimporAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallepedidocompraimporAux.getPeriodo()));
			detallepedidocompraimporAux.setarancel_descripcion(ArancelConstantesFunciones.getArancelDescripcion(detallepedidocompraimporAux.getArancel()));
			detallepedidocompraimporAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detallepedidocompraimporAux.getCentroCosto()));
			detallepedidocompraimporAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallepedidocompraimporAux.getAnio()));
			detallepedidocompraimporAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallepedidocompraimporAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePedidoCompraImpor(List<DetallePedidoCompraImpor> detallepedidocompraimporsTemp) throws Exception {
		for(DetallePedidoCompraImpor detallepedidocompraimporAux:detallepedidocompraimporsTemp) {
			
			detallepedidocompraimporAux.setpedidocompraimpor_descripcion(PedidoCompraImporConstantesFunciones.getPedidoCompraImporDescripcion(detallepedidocompraimporAux.getPedidoCompraImpor()));
			detallepedidocompraimporAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepedidocompraimporAux.getEmpresa()));
			detallepedidocompraimporAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallepedidocompraimporAux.getSucursal()));
			detallepedidocompraimporAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(detallepedidocompraimporAux.getBodega()));
			detallepedidocompraimporAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(detallepedidocompraimporAux.getProducto()));
			detallepedidocompraimporAux.setunidad_descripcion(UnidadConstantesFunciones.getUnidadDescripcion(detallepedidocompraimporAux.getUnidad()));
			detallepedidocompraimporAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallepedidocompraimporAux.getEjercicio()));
			detallepedidocompraimporAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallepedidocompraimporAux.getPeriodo()));
			detallepedidocompraimporAux.setarancel_descripcion(ArancelConstantesFunciones.getArancelDescripcion(detallepedidocompraimporAux.getArancel()));
			detallepedidocompraimporAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detallepedidocompraimporAux.getCentroCosto()));
			detallepedidocompraimporAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallepedidocompraimporAux.getAnio()));
			detallepedidocompraimporAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallepedidocompraimporAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePedidoCompraImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(PedidoCompraImpor.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Unidad.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Arancel.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(PedidoCompraImpor.class)) {
						classes.add(new Classe(PedidoCompraImpor.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Unidad.class)) {
						classes.add(new Classe(Unidad.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Arancel.class)) {
						classes.add(new Classe(Arancel.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetallePedidoCompraImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoCompraImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompraImpor.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Arancel.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Arancel.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(PedidoCompraImpor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(PedidoCompraImpor.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Unidad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Unidad.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Arancel.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Arancel.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedidoCompraImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePedidoCompraImporConstantesFunciones.getClassesRelationshipsOfDetallePedidoCompraImpor(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePedidoCompraImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePedidoCompraImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePedidoCompraImporConstantesFunciones.getClassesRelationshipsFromStringsOfDetallePedidoCompraImpor(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePedidoCompraImpor(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(DetallePedidoCompraImpor detallepedidocompraimpor,List<DetallePedidoCompraImpor> detallepedidocompraimpors,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetallePedidoCompraImpor detallepedidocompraimporEncontrado=null;
			
			for(DetallePedidoCompraImpor detallepedidocompraimporLocal:detallepedidocompraimpors) {
				if(detallepedidocompraimporLocal.getId().equals(detallepedidocompraimpor.getId())) {
					detallepedidocompraimporEncontrado=detallepedidocompraimporLocal;
					
					detallepedidocompraimporLocal.setIsChanged(detallepedidocompraimpor.getIsChanged());
					detallepedidocompraimporLocal.setIsNew(detallepedidocompraimpor.getIsNew());
					detallepedidocompraimporLocal.setIsDeleted(detallepedidocompraimpor.getIsDeleted());
					
					detallepedidocompraimporLocal.setGeneralEntityOriginal(detallepedidocompraimpor.getGeneralEntityOriginal());
					
					detallepedidocompraimporLocal.setId(detallepedidocompraimpor.getId());	
					detallepedidocompraimporLocal.setVersionRow(detallepedidocompraimpor.getVersionRow());	
					detallepedidocompraimporLocal.setid_pedido_compra_impor(detallepedidocompraimpor.getid_pedido_compra_impor());	
					detallepedidocompraimporLocal.setid_empresa(detallepedidocompraimpor.getid_empresa());	
					detallepedidocompraimporLocal.setid_sucursal(detallepedidocompraimpor.getid_sucursal());	
					detallepedidocompraimporLocal.setid_bodega(detallepedidocompraimpor.getid_bodega());	
					detallepedidocompraimporLocal.setid_producto(detallepedidocompraimpor.getid_producto());	
					detallepedidocompraimporLocal.setid_unidad(detallepedidocompraimpor.getid_unidad());	
					detallepedidocompraimporLocal.setid_ejercicio(detallepedidocompraimpor.getid_ejercicio());	
					detallepedidocompraimporLocal.setid_periodo(detallepedidocompraimpor.getid_periodo());	
					detallepedidocompraimporLocal.setid_arancel(detallepedidocompraimpor.getid_arancel());	
					detallepedidocompraimporLocal.setcantidad_pedido(detallepedidocompraimpor.getcantidad_pedido());	
					detallepedidocompraimporLocal.setcantidad_entra(detallepedidocompraimpor.getcantidad_entra());	
					detallepedidocompraimporLocal.setcantidad_pendiente(detallepedidocompraimpor.getcantidad_pendiente());	
					detallepedidocompraimporLocal.setporcentaje(detallepedidocompraimpor.getporcentaje());	
					detallepedidocompraimporLocal.setpeso(detallepedidocompraimpor.getpeso());	
					detallepedidocompraimporLocal.setprecio(detallepedidocompraimpor.getprecio());	
					detallepedidocompraimporLocal.setlote(detallepedidocompraimpor.getlote());	
					detallepedidocompraimporLocal.setporcentaje_arancel(detallepedidocompraimpor.getporcentaje_arancel());	
					detallepedidocompraimporLocal.setcantidad_unidad_auxiliar(detallepedidocompraimpor.getcantidad_unidad_auxiliar());	
					detallepedidocompraimporLocal.setprecio_unidad_auxiliar(detallepedidocompraimpor.getprecio_unidad_auxiliar());	
					detallepedidocompraimporLocal.setfob(detallepedidocompraimpor.getfob());	
					detallepedidocompraimporLocal.setfob_exw(detallepedidocompraimpor.getfob_exw());	
					detallepedidocompraimporLocal.settotal(detallepedidocompraimpor.gettotal());	
					detallepedidocompraimporLocal.setdescripcion(detallepedidocompraimpor.getdescripcion());	
					detallepedidocompraimporLocal.setid_centro_costo(detallepedidocompraimpor.getid_centro_costo());	
					detallepedidocompraimporLocal.setid_anio(detallepedidocompraimpor.getid_anio());	
					detallepedidocompraimporLocal.setid_mes(detallepedidocompraimpor.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallepedidocompraimpor.getIsDeleted()) {
				if(!existe) {
					detallepedidocompraimpors.add(detallepedidocompraimpor);
				}
			} else {
				if(detallepedidocompraimporEncontrado!=null && permiteQuitar)  {
					detallepedidocompraimpors.remove(detallepedidocompraimporEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetallePedidoCompraImpor detallepedidocompraimpor,List<DetallePedidoCompraImpor> detallepedidocompraimpors) throws Exception {
		try	{			
			for(DetallePedidoCompraImpor detallepedidocompraimporLocal:detallepedidocompraimpors) {
				if(detallepedidocompraimporLocal.getId().equals(detallepedidocompraimpor.getId())) {
					detallepedidocompraimporLocal.setIsSelected(detallepedidocompraimpor.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetallePedidoCompraImpor(List<DetallePedidoCompraImpor> detallepedidocompraimporsAux) throws Exception {
		//this.detallepedidocompraimporsAux=detallepedidocompraimporsAux;
		
		for(DetallePedidoCompraImpor detallepedidocompraimporAux:detallepedidocompraimporsAux) {
			if(detallepedidocompraimporAux.getIsChanged()) {
				detallepedidocompraimporAux.setIsChanged(false);
			}		
			
			if(detallepedidocompraimporAux.getIsNew()) {
				detallepedidocompraimporAux.setIsNew(false);
			}	
			
			if(detallepedidocompraimporAux.getIsDeleted()) {
				detallepedidocompraimporAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetallePedidoCompraImpor(DetallePedidoCompraImpor detallepedidocompraimporAux) throws Exception {
		//this.detallepedidocompraimporAux=detallepedidocompraimporAux;
		
			if(detallepedidocompraimporAux.getIsChanged()) {
				detallepedidocompraimporAux.setIsChanged(false);
			}		
			
			if(detallepedidocompraimporAux.getIsNew()) {
				detallepedidocompraimporAux.setIsNew(false);
			}	
			
			if(detallepedidocompraimporAux.getIsDeleted()) {
				detallepedidocompraimporAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetallePedidoCompraImpor detallepedidocompraimporAsignar,DetallePedidoCompraImpor detallepedidocompraimpor) throws Exception {
		detallepedidocompraimporAsignar.setId(detallepedidocompraimpor.getId());	
		detallepedidocompraimporAsignar.setVersionRow(detallepedidocompraimpor.getVersionRow());	
		detallepedidocompraimporAsignar.setid_pedido_compra_impor(detallepedidocompraimpor.getid_pedido_compra_impor());
		detallepedidocompraimporAsignar.setpedidocompraimpor_descripcion(detallepedidocompraimpor.getpedidocompraimpor_descripcion());	
		detallepedidocompraimporAsignar.setid_empresa(detallepedidocompraimpor.getid_empresa());
		detallepedidocompraimporAsignar.setempresa_descripcion(detallepedidocompraimpor.getempresa_descripcion());	
		detallepedidocompraimporAsignar.setid_sucursal(detallepedidocompraimpor.getid_sucursal());
		detallepedidocompraimporAsignar.setsucursal_descripcion(detallepedidocompraimpor.getsucursal_descripcion());	
		detallepedidocompraimporAsignar.setid_bodega(detallepedidocompraimpor.getid_bodega());
		detallepedidocompraimporAsignar.setbodega_descripcion(detallepedidocompraimpor.getbodega_descripcion());	
		detallepedidocompraimporAsignar.setid_producto(detallepedidocompraimpor.getid_producto());
		detallepedidocompraimporAsignar.setproducto_descripcion(detallepedidocompraimpor.getproducto_descripcion());	
		detallepedidocompraimporAsignar.setid_unidad(detallepedidocompraimpor.getid_unidad());
		detallepedidocompraimporAsignar.setunidad_descripcion(detallepedidocompraimpor.getunidad_descripcion());	
		detallepedidocompraimporAsignar.setid_ejercicio(detallepedidocompraimpor.getid_ejercicio());
		detallepedidocompraimporAsignar.setejercicio_descripcion(detallepedidocompraimpor.getejercicio_descripcion());	
		detallepedidocompraimporAsignar.setid_periodo(detallepedidocompraimpor.getid_periodo());
		detallepedidocompraimporAsignar.setperiodo_descripcion(detallepedidocompraimpor.getperiodo_descripcion());	
		detallepedidocompraimporAsignar.setid_arancel(detallepedidocompraimpor.getid_arancel());
		detallepedidocompraimporAsignar.setarancel_descripcion(detallepedidocompraimpor.getarancel_descripcion());	
		detallepedidocompraimporAsignar.setcantidad_pedido(detallepedidocompraimpor.getcantidad_pedido());	
		detallepedidocompraimporAsignar.setcantidad_entra(detallepedidocompraimpor.getcantidad_entra());	
		detallepedidocompraimporAsignar.setcantidad_pendiente(detallepedidocompraimpor.getcantidad_pendiente());	
		detallepedidocompraimporAsignar.setporcentaje(detallepedidocompraimpor.getporcentaje());	
		detallepedidocompraimporAsignar.setpeso(detallepedidocompraimpor.getpeso());	
		detallepedidocompraimporAsignar.setprecio(detallepedidocompraimpor.getprecio());	
		detallepedidocompraimporAsignar.setlote(detallepedidocompraimpor.getlote());	
		detallepedidocompraimporAsignar.setporcentaje_arancel(detallepedidocompraimpor.getporcentaje_arancel());	
		detallepedidocompraimporAsignar.setcantidad_unidad_auxiliar(detallepedidocompraimpor.getcantidad_unidad_auxiliar());	
		detallepedidocompraimporAsignar.setprecio_unidad_auxiliar(detallepedidocompraimpor.getprecio_unidad_auxiliar());	
		detallepedidocompraimporAsignar.setfob(detallepedidocompraimpor.getfob());	
		detallepedidocompraimporAsignar.setfob_exw(detallepedidocompraimpor.getfob_exw());	
		detallepedidocompraimporAsignar.settotal(detallepedidocompraimpor.gettotal());	
		detallepedidocompraimporAsignar.setdescripcion(detallepedidocompraimpor.getdescripcion());	
		detallepedidocompraimporAsignar.setid_centro_costo(detallepedidocompraimpor.getid_centro_costo());
		detallepedidocompraimporAsignar.setcentrocosto_descripcion(detallepedidocompraimpor.getcentrocosto_descripcion());	
		detallepedidocompraimporAsignar.setid_anio(detallepedidocompraimpor.getid_anio());
		detallepedidocompraimporAsignar.setanio_descripcion(detallepedidocompraimpor.getanio_descripcion());	
		detallepedidocompraimporAsignar.setid_mes(detallepedidocompraimpor.getid_mes());
		detallepedidocompraimporAsignar.setmes_descripcion(detallepedidocompraimpor.getmes_descripcion());	
	}
	
	public static void inicializarDetallePedidoCompraImpor(DetallePedidoCompraImpor detallepedidocompraimpor) throws Exception {
		try {
				detallepedidocompraimpor.setId(0L);	
					
				detallepedidocompraimpor.setid_pedido_compra_impor(-1L);	
				detallepedidocompraimpor.setid_empresa(-1L);	
				detallepedidocompraimpor.setid_sucursal(-1L);	
				detallepedidocompraimpor.setid_bodega(-1L);	
				detallepedidocompraimpor.setid_producto(-1L);	
				detallepedidocompraimpor.setid_unidad(-1L);	
				detallepedidocompraimpor.setid_ejercicio(-1L);	
				detallepedidocompraimpor.setid_periodo(-1L);	
				detallepedidocompraimpor.setid_arancel(-1L);	
				detallepedidocompraimpor.setcantidad_pedido(0);	
				detallepedidocompraimpor.setcantidad_entra(0);	
				detallepedidocompraimpor.setcantidad_pendiente(0);	
				detallepedidocompraimpor.setporcentaje(0.0);	
				detallepedidocompraimpor.setpeso(0.0);	
				detallepedidocompraimpor.setprecio(0.0);	
				detallepedidocompraimpor.setlote("");	
				detallepedidocompraimpor.setporcentaje_arancel(0.0);	
				detallepedidocompraimpor.setcantidad_unidad_auxiliar(0);	
				detallepedidocompraimpor.setprecio_unidad_auxiliar(0.0);	
				detallepedidocompraimpor.setfob(0.0);	
				detallepedidocompraimpor.setfob_exw(0.0);	
				detallepedidocompraimpor.settotal(0.0);	
				detallepedidocompraimpor.setdescripcion("");	
				detallepedidocompraimpor.setid_centro_costo(null);	
				detallepedidocompraimpor.setid_anio(null);	
				detallepedidocompraimpor.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetallePedidoCompraImpor(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_IDPEDIDOCOMPRAIMPOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_IDUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_IDARANCEL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADENTRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADPENDIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_PESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_LOTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_PORCENTAJEARANCEL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_CANTIDADUNIDADAUXILIAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_PRECIOUNIDADAUXILIAR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_FOB);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_FOBEXW);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePedidoCompraImporConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetallePedidoCompraImpor(String sTipo,Row row,Workbook workbook,DetallePedidoCompraImpor detallepedidocompraimpor,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getpedidocompraimpor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getunidad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getarancel_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getcantidad_pedido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getcantidad_entra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getcantidad_pendiente());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getpeso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getlote());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getporcentaje_arancel());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getcantidad_unidad_auxiliar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getprecio_unidad_auxiliar());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getfob());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getfob_exw());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepedidocompraimpor.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetallePedidoCompraImpor=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetallePedidoCompraImpor() {
		return this.sFinalQueryDetallePedidoCompraImpor;
	}
	
	public void setsFinalQueryDetallePedidoCompraImpor(String sFinalQueryDetallePedidoCompraImpor) {
		this.sFinalQueryDetallePedidoCompraImpor= sFinalQueryDetallePedidoCompraImpor;
	}
	
	public Border resaltarSeleccionarDetallePedidoCompraImpor=null;
	
	public Border setResaltarSeleccionarDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetallePedidoCompraImpor= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetallePedidoCompraImpor() {
		return this.resaltarSeleccionarDetallePedidoCompraImpor;
	}
	
	public void setResaltarSeleccionarDetallePedidoCompraImpor(Border borderResaltarSeleccionarDetallePedidoCompraImpor) {
		this.resaltarSeleccionarDetallePedidoCompraImpor= borderResaltarSeleccionarDetallePedidoCompraImpor;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetallePedidoCompraImpor=null;
	public Boolean mostraridDetallePedidoCompraImpor=true;
	public Boolean activaridDetallePedidoCompraImpor=true;

	public Border resaltarid_pedido_compra_imporDetallePedidoCompraImpor=null;
	public Boolean mostrarid_pedido_compra_imporDetallePedidoCompraImpor=true;
	public Boolean activarid_pedido_compra_imporDetallePedidoCompraImpor=true;
	public Boolean cargarid_pedido_compra_imporDetallePedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_pedido_compra_imporDetallePedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_empresaDetallePedidoCompraImpor=null;
	public Boolean mostrarid_empresaDetallePedidoCompraImpor=true;
	public Boolean activarid_empresaDetallePedidoCompraImpor=true;
	public Boolean cargarid_empresaDetallePedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetallePedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetallePedidoCompraImpor=null;
	public Boolean mostrarid_sucursalDetallePedidoCompraImpor=true;
	public Boolean activarid_sucursalDetallePedidoCompraImpor=true;
	public Boolean cargarid_sucursalDetallePedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetallePedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_bodegaDetallePedidoCompraImpor=null;
	public Boolean mostrarid_bodegaDetallePedidoCompraImpor=true;
	public Boolean activarid_bodegaDetallePedidoCompraImpor=true;
	public Boolean cargarid_bodegaDetallePedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaDetallePedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_productoDetallePedidoCompraImpor=null;
	public Boolean mostrarid_productoDetallePedidoCompraImpor=true;
	public Boolean activarid_productoDetallePedidoCompraImpor=true;
	public Boolean cargarid_productoDetallePedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoDetallePedidoCompraImpor=true;//ConEventDepend=true

	public Border resaltarid_unidadDetallePedidoCompraImpor=null;
	public Boolean mostrarid_unidadDetallePedidoCompraImpor=true;
	public Boolean activarid_unidadDetallePedidoCompraImpor=true;
	public Boolean cargarid_unidadDetallePedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_unidadDetallePedidoCompraImpor=true;//ConEventDepend=true

	public Border resaltarid_ejercicioDetallePedidoCompraImpor=null;
	public Boolean mostrarid_ejercicioDetallePedidoCompraImpor=true;
	public Boolean activarid_ejercicioDetallePedidoCompraImpor=true;
	public Boolean cargarid_ejercicioDetallePedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetallePedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_periodoDetallePedidoCompraImpor=null;
	public Boolean mostrarid_periodoDetallePedidoCompraImpor=true;
	public Boolean activarid_periodoDetallePedidoCompraImpor=true;
	public Boolean cargarid_periodoDetallePedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetallePedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_arancelDetallePedidoCompraImpor=null;
	public Boolean mostrarid_arancelDetallePedidoCompraImpor=true;
	public Boolean activarid_arancelDetallePedidoCompraImpor=true;
	public Boolean cargarid_arancelDetallePedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_arancelDetallePedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarcantidad_pedidoDetallePedidoCompraImpor=null;
	public Boolean mostrarcantidad_pedidoDetallePedidoCompraImpor=true;
	public Boolean activarcantidad_pedidoDetallePedidoCompraImpor=true;

	public Border resaltarcantidad_entraDetallePedidoCompraImpor=null;
	public Boolean mostrarcantidad_entraDetallePedidoCompraImpor=true;
	public Boolean activarcantidad_entraDetallePedidoCompraImpor=true;

	public Border resaltarcantidad_pendienteDetallePedidoCompraImpor=null;
	public Boolean mostrarcantidad_pendienteDetallePedidoCompraImpor=true;
	public Boolean activarcantidad_pendienteDetallePedidoCompraImpor=true;

	public Border resaltarporcentajeDetallePedidoCompraImpor=null;
	public Boolean mostrarporcentajeDetallePedidoCompraImpor=true;
	public Boolean activarporcentajeDetallePedidoCompraImpor=true;

	public Border resaltarpesoDetallePedidoCompraImpor=null;
	public Boolean mostrarpesoDetallePedidoCompraImpor=true;
	public Boolean activarpesoDetallePedidoCompraImpor=true;

	public Border resaltarprecioDetallePedidoCompraImpor=null;
	public Boolean mostrarprecioDetallePedidoCompraImpor=true;
	public Boolean activarprecioDetallePedidoCompraImpor=true;

	public Border resaltarloteDetallePedidoCompraImpor=null;
	public Boolean mostrarloteDetallePedidoCompraImpor=true;
	public Boolean activarloteDetallePedidoCompraImpor=true;

	public Border resaltarporcentaje_arancelDetallePedidoCompraImpor=null;
	public Boolean mostrarporcentaje_arancelDetallePedidoCompraImpor=true;
	public Boolean activarporcentaje_arancelDetallePedidoCompraImpor=true;

	public Border resaltarcantidad_unidad_auxiliarDetallePedidoCompraImpor=null;
	public Boolean mostrarcantidad_unidad_auxiliarDetallePedidoCompraImpor=true;
	public Boolean activarcantidad_unidad_auxiliarDetallePedidoCompraImpor=true;

	public Border resaltarprecio_unidad_auxiliarDetallePedidoCompraImpor=null;
	public Boolean mostrarprecio_unidad_auxiliarDetallePedidoCompraImpor=true;
	public Boolean activarprecio_unidad_auxiliarDetallePedidoCompraImpor=true;

	public Border resaltarfobDetallePedidoCompraImpor=null;
	public Boolean mostrarfobDetallePedidoCompraImpor=true;
	public Boolean activarfobDetallePedidoCompraImpor=true;

	public Border resaltarfob_exwDetallePedidoCompraImpor=null;
	public Boolean mostrarfob_exwDetallePedidoCompraImpor=true;
	public Boolean activarfob_exwDetallePedidoCompraImpor=true;

	public Border resaltartotalDetallePedidoCompraImpor=null;
	public Boolean mostrartotalDetallePedidoCompraImpor=true;
	public Boolean activartotalDetallePedidoCompraImpor=true;

	public Border resaltardescripcionDetallePedidoCompraImpor=null;
	public Boolean mostrardescripcionDetallePedidoCompraImpor=true;
	public Boolean activardescripcionDetallePedidoCompraImpor=true;

	public Border resaltarid_centro_costoDetallePedidoCompraImpor=null;
	public Boolean mostrarid_centro_costoDetallePedidoCompraImpor=true;
	public Boolean activarid_centro_costoDetallePedidoCompraImpor=true;
	public Boolean cargarid_centro_costoDetallePedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetallePedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_anioDetallePedidoCompraImpor=null;
	public Boolean mostrarid_anioDetallePedidoCompraImpor=true;
	public Boolean activarid_anioDetallePedidoCompraImpor=false;
	public Boolean cargarid_anioDetallePedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetallePedidoCompraImpor=false;//ConEventDepend=true

	public Border resaltarid_mesDetallePedidoCompraImpor=null;
	public Boolean mostrarid_mesDetallePedidoCompraImpor=true;
	public Boolean activarid_mesDetallePedidoCompraImpor=false;
	public Boolean cargarid_mesDetallePedidoCompraImpor=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetallePedidoCompraImpor=false;//ConEventDepend=true

	
	

	public Border setResaltaridDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltaridDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetallePedidoCompraImpor() {
		return this.resaltaridDetallePedidoCompraImpor;
	}

	public void setResaltaridDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltaridDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostraridDetallePedidoCompraImpor() {
		return this.mostraridDetallePedidoCompraImpor;
	}

	public void setMostraridDetallePedidoCompraImpor(Boolean mostraridDetallePedidoCompraImpor) {
		this.mostraridDetallePedidoCompraImpor= mostraridDetallePedidoCompraImpor;
	}

	public Boolean getActivaridDetallePedidoCompraImpor() {
		return this.activaridDetallePedidoCompraImpor;
	}

	public void setActivaridDetallePedidoCompraImpor(Boolean activaridDetallePedidoCompraImpor) {
		this.activaridDetallePedidoCompraImpor= activaridDetallePedidoCompraImpor;
	}

	public Border setResaltarid_pedido_compra_imporDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_pedido_compra_imporDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_pedido_compra_imporDetallePedidoCompraImpor() {
		return this.resaltarid_pedido_compra_imporDetallePedidoCompraImpor;
	}

	public void setResaltarid_pedido_compra_imporDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_pedido_compra_imporDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_pedido_compra_imporDetallePedidoCompraImpor() {
		return this.mostrarid_pedido_compra_imporDetallePedidoCompraImpor;
	}

	public void setMostrarid_pedido_compra_imporDetallePedidoCompraImpor(Boolean mostrarid_pedido_compra_imporDetallePedidoCompraImpor) {
		this.mostrarid_pedido_compra_imporDetallePedidoCompraImpor= mostrarid_pedido_compra_imporDetallePedidoCompraImpor;
	}

	public Boolean getActivarid_pedido_compra_imporDetallePedidoCompraImpor() {
		return this.activarid_pedido_compra_imporDetallePedidoCompraImpor;
	}

	public void setActivarid_pedido_compra_imporDetallePedidoCompraImpor(Boolean activarid_pedido_compra_imporDetallePedidoCompraImpor) {
		this.activarid_pedido_compra_imporDetallePedidoCompraImpor= activarid_pedido_compra_imporDetallePedidoCompraImpor;
	}

	public Boolean getCargarid_pedido_compra_imporDetallePedidoCompraImpor() {
		return this.cargarid_pedido_compra_imporDetallePedidoCompraImpor;
	}

	public void setCargarid_pedido_compra_imporDetallePedidoCompraImpor(Boolean cargarid_pedido_compra_imporDetallePedidoCompraImpor) {
		this.cargarid_pedido_compra_imporDetallePedidoCompraImpor= cargarid_pedido_compra_imporDetallePedidoCompraImpor;
	}

	public Border setResaltarid_empresaDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetallePedidoCompraImpor() {
		return this.resaltarid_empresaDetallePedidoCompraImpor;
	}

	public void setResaltarid_empresaDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_empresaDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetallePedidoCompraImpor() {
		return this.mostrarid_empresaDetallePedidoCompraImpor;
	}

	public void setMostrarid_empresaDetallePedidoCompraImpor(Boolean mostrarid_empresaDetallePedidoCompraImpor) {
		this.mostrarid_empresaDetallePedidoCompraImpor= mostrarid_empresaDetallePedidoCompraImpor;
	}

	public Boolean getActivarid_empresaDetallePedidoCompraImpor() {
		return this.activarid_empresaDetallePedidoCompraImpor;
	}

	public void setActivarid_empresaDetallePedidoCompraImpor(Boolean activarid_empresaDetallePedidoCompraImpor) {
		this.activarid_empresaDetallePedidoCompraImpor= activarid_empresaDetallePedidoCompraImpor;
	}

	public Boolean getCargarid_empresaDetallePedidoCompraImpor() {
		return this.cargarid_empresaDetallePedidoCompraImpor;
	}

	public void setCargarid_empresaDetallePedidoCompraImpor(Boolean cargarid_empresaDetallePedidoCompraImpor) {
		this.cargarid_empresaDetallePedidoCompraImpor= cargarid_empresaDetallePedidoCompraImpor;
	}

	public Border setResaltarid_sucursalDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetallePedidoCompraImpor() {
		return this.resaltarid_sucursalDetallePedidoCompraImpor;
	}

	public void setResaltarid_sucursalDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_sucursalDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetallePedidoCompraImpor() {
		return this.mostrarid_sucursalDetallePedidoCompraImpor;
	}

	public void setMostrarid_sucursalDetallePedidoCompraImpor(Boolean mostrarid_sucursalDetallePedidoCompraImpor) {
		this.mostrarid_sucursalDetallePedidoCompraImpor= mostrarid_sucursalDetallePedidoCompraImpor;
	}

	public Boolean getActivarid_sucursalDetallePedidoCompraImpor() {
		return this.activarid_sucursalDetallePedidoCompraImpor;
	}

	public void setActivarid_sucursalDetallePedidoCompraImpor(Boolean activarid_sucursalDetallePedidoCompraImpor) {
		this.activarid_sucursalDetallePedidoCompraImpor= activarid_sucursalDetallePedidoCompraImpor;
	}

	public Boolean getCargarid_sucursalDetallePedidoCompraImpor() {
		return this.cargarid_sucursalDetallePedidoCompraImpor;
	}

	public void setCargarid_sucursalDetallePedidoCompraImpor(Boolean cargarid_sucursalDetallePedidoCompraImpor) {
		this.cargarid_sucursalDetallePedidoCompraImpor= cargarid_sucursalDetallePedidoCompraImpor;
	}

	public Border setResaltarid_bodegaDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_bodegaDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaDetallePedidoCompraImpor() {
		return this.resaltarid_bodegaDetallePedidoCompraImpor;
	}

	public void setResaltarid_bodegaDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_bodegaDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_bodegaDetallePedidoCompraImpor() {
		return this.mostrarid_bodegaDetallePedidoCompraImpor;
	}

	public void setMostrarid_bodegaDetallePedidoCompraImpor(Boolean mostrarid_bodegaDetallePedidoCompraImpor) {
		this.mostrarid_bodegaDetallePedidoCompraImpor= mostrarid_bodegaDetallePedidoCompraImpor;
	}

	public Boolean getActivarid_bodegaDetallePedidoCompraImpor() {
		return this.activarid_bodegaDetallePedidoCompraImpor;
	}

	public void setActivarid_bodegaDetallePedidoCompraImpor(Boolean activarid_bodegaDetallePedidoCompraImpor) {
		this.activarid_bodegaDetallePedidoCompraImpor= activarid_bodegaDetallePedidoCompraImpor;
	}

	public Boolean getCargarid_bodegaDetallePedidoCompraImpor() {
		return this.cargarid_bodegaDetallePedidoCompraImpor;
	}

	public void setCargarid_bodegaDetallePedidoCompraImpor(Boolean cargarid_bodegaDetallePedidoCompraImpor) {
		this.cargarid_bodegaDetallePedidoCompraImpor= cargarid_bodegaDetallePedidoCompraImpor;
	}

	public Border setResaltarid_productoDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_productoDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoDetallePedidoCompraImpor() {
		return this.resaltarid_productoDetallePedidoCompraImpor;
	}

	public void setResaltarid_productoDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_productoDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_productoDetallePedidoCompraImpor() {
		return this.mostrarid_productoDetallePedidoCompraImpor;
	}

	public void setMostrarid_productoDetallePedidoCompraImpor(Boolean mostrarid_productoDetallePedidoCompraImpor) {
		this.mostrarid_productoDetallePedidoCompraImpor= mostrarid_productoDetallePedidoCompraImpor;
	}

	public Boolean getActivarid_productoDetallePedidoCompraImpor() {
		return this.activarid_productoDetallePedidoCompraImpor;
	}

	public void setActivarid_productoDetallePedidoCompraImpor(Boolean activarid_productoDetallePedidoCompraImpor) {
		this.activarid_productoDetallePedidoCompraImpor= activarid_productoDetallePedidoCompraImpor;
	}

	public Boolean getCargarid_productoDetallePedidoCompraImpor() {
		return this.cargarid_productoDetallePedidoCompraImpor;
	}

	public void setCargarid_productoDetallePedidoCompraImpor(Boolean cargarid_productoDetallePedidoCompraImpor) {
		this.cargarid_productoDetallePedidoCompraImpor= cargarid_productoDetallePedidoCompraImpor;
	}

	public Border setResaltarid_unidadDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_unidadDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_unidadDetallePedidoCompraImpor() {
		return this.resaltarid_unidadDetallePedidoCompraImpor;
	}

	public void setResaltarid_unidadDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_unidadDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_unidadDetallePedidoCompraImpor() {
		return this.mostrarid_unidadDetallePedidoCompraImpor;
	}

	public void setMostrarid_unidadDetallePedidoCompraImpor(Boolean mostrarid_unidadDetallePedidoCompraImpor) {
		this.mostrarid_unidadDetallePedidoCompraImpor= mostrarid_unidadDetallePedidoCompraImpor;
	}

	public Boolean getActivarid_unidadDetallePedidoCompraImpor() {
		return this.activarid_unidadDetallePedidoCompraImpor;
	}

	public void setActivarid_unidadDetallePedidoCompraImpor(Boolean activarid_unidadDetallePedidoCompraImpor) {
		this.activarid_unidadDetallePedidoCompraImpor= activarid_unidadDetallePedidoCompraImpor;
	}

	public Boolean getCargarid_unidadDetallePedidoCompraImpor() {
		return this.cargarid_unidadDetallePedidoCompraImpor;
	}

	public void setCargarid_unidadDetallePedidoCompraImpor(Boolean cargarid_unidadDetallePedidoCompraImpor) {
		this.cargarid_unidadDetallePedidoCompraImpor= cargarid_unidadDetallePedidoCompraImpor;
	}

	public Border setResaltarid_ejercicioDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetallePedidoCompraImpor() {
		return this.resaltarid_ejercicioDetallePedidoCompraImpor;
	}

	public void setResaltarid_ejercicioDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_ejercicioDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetallePedidoCompraImpor() {
		return this.mostrarid_ejercicioDetallePedidoCompraImpor;
	}

	public void setMostrarid_ejercicioDetallePedidoCompraImpor(Boolean mostrarid_ejercicioDetallePedidoCompraImpor) {
		this.mostrarid_ejercicioDetallePedidoCompraImpor= mostrarid_ejercicioDetallePedidoCompraImpor;
	}

	public Boolean getActivarid_ejercicioDetallePedidoCompraImpor() {
		return this.activarid_ejercicioDetallePedidoCompraImpor;
	}

	public void setActivarid_ejercicioDetallePedidoCompraImpor(Boolean activarid_ejercicioDetallePedidoCompraImpor) {
		this.activarid_ejercicioDetallePedidoCompraImpor= activarid_ejercicioDetallePedidoCompraImpor;
	}

	public Boolean getCargarid_ejercicioDetallePedidoCompraImpor() {
		return this.cargarid_ejercicioDetallePedidoCompraImpor;
	}

	public void setCargarid_ejercicioDetallePedidoCompraImpor(Boolean cargarid_ejercicioDetallePedidoCompraImpor) {
		this.cargarid_ejercicioDetallePedidoCompraImpor= cargarid_ejercicioDetallePedidoCompraImpor;
	}

	public Border setResaltarid_periodoDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetallePedidoCompraImpor() {
		return this.resaltarid_periodoDetallePedidoCompraImpor;
	}

	public void setResaltarid_periodoDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_periodoDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetallePedidoCompraImpor() {
		return this.mostrarid_periodoDetallePedidoCompraImpor;
	}

	public void setMostrarid_periodoDetallePedidoCompraImpor(Boolean mostrarid_periodoDetallePedidoCompraImpor) {
		this.mostrarid_periodoDetallePedidoCompraImpor= mostrarid_periodoDetallePedidoCompraImpor;
	}

	public Boolean getActivarid_periodoDetallePedidoCompraImpor() {
		return this.activarid_periodoDetallePedidoCompraImpor;
	}

	public void setActivarid_periodoDetallePedidoCompraImpor(Boolean activarid_periodoDetallePedidoCompraImpor) {
		this.activarid_periodoDetallePedidoCompraImpor= activarid_periodoDetallePedidoCompraImpor;
	}

	public Boolean getCargarid_periodoDetallePedidoCompraImpor() {
		return this.cargarid_periodoDetallePedidoCompraImpor;
	}

	public void setCargarid_periodoDetallePedidoCompraImpor(Boolean cargarid_periodoDetallePedidoCompraImpor) {
		this.cargarid_periodoDetallePedidoCompraImpor= cargarid_periodoDetallePedidoCompraImpor;
	}

	public Border setResaltarid_arancelDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_arancelDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_arancelDetallePedidoCompraImpor() {
		return this.resaltarid_arancelDetallePedidoCompraImpor;
	}

	public void setResaltarid_arancelDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_arancelDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_arancelDetallePedidoCompraImpor() {
		return this.mostrarid_arancelDetallePedidoCompraImpor;
	}

	public void setMostrarid_arancelDetallePedidoCompraImpor(Boolean mostrarid_arancelDetallePedidoCompraImpor) {
		this.mostrarid_arancelDetallePedidoCompraImpor= mostrarid_arancelDetallePedidoCompraImpor;
	}

	public Boolean getActivarid_arancelDetallePedidoCompraImpor() {
		return this.activarid_arancelDetallePedidoCompraImpor;
	}

	public void setActivarid_arancelDetallePedidoCompraImpor(Boolean activarid_arancelDetallePedidoCompraImpor) {
		this.activarid_arancelDetallePedidoCompraImpor= activarid_arancelDetallePedidoCompraImpor;
	}

	public Boolean getCargarid_arancelDetallePedidoCompraImpor() {
		return this.cargarid_arancelDetallePedidoCompraImpor;
	}

	public void setCargarid_arancelDetallePedidoCompraImpor(Boolean cargarid_arancelDetallePedidoCompraImpor) {
		this.cargarid_arancelDetallePedidoCompraImpor= cargarid_arancelDetallePedidoCompraImpor;
	}

	public Border setResaltarcantidad_pedidoDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarcantidad_pedidoDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_pedidoDetallePedidoCompraImpor() {
		return this.resaltarcantidad_pedidoDetallePedidoCompraImpor;
	}

	public void setResaltarcantidad_pedidoDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarcantidad_pedidoDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarcantidad_pedidoDetallePedidoCompraImpor() {
		return this.mostrarcantidad_pedidoDetallePedidoCompraImpor;
	}

	public void setMostrarcantidad_pedidoDetallePedidoCompraImpor(Boolean mostrarcantidad_pedidoDetallePedidoCompraImpor) {
		this.mostrarcantidad_pedidoDetallePedidoCompraImpor= mostrarcantidad_pedidoDetallePedidoCompraImpor;
	}

	public Boolean getActivarcantidad_pedidoDetallePedidoCompraImpor() {
		return this.activarcantidad_pedidoDetallePedidoCompraImpor;
	}

	public void setActivarcantidad_pedidoDetallePedidoCompraImpor(Boolean activarcantidad_pedidoDetallePedidoCompraImpor) {
		this.activarcantidad_pedidoDetallePedidoCompraImpor= activarcantidad_pedidoDetallePedidoCompraImpor;
	}

	public Border setResaltarcantidad_entraDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarcantidad_entraDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_entraDetallePedidoCompraImpor() {
		return this.resaltarcantidad_entraDetallePedidoCompraImpor;
	}

	public void setResaltarcantidad_entraDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarcantidad_entraDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarcantidad_entraDetallePedidoCompraImpor() {
		return this.mostrarcantidad_entraDetallePedidoCompraImpor;
	}

	public void setMostrarcantidad_entraDetallePedidoCompraImpor(Boolean mostrarcantidad_entraDetallePedidoCompraImpor) {
		this.mostrarcantidad_entraDetallePedidoCompraImpor= mostrarcantidad_entraDetallePedidoCompraImpor;
	}

	public Boolean getActivarcantidad_entraDetallePedidoCompraImpor() {
		return this.activarcantidad_entraDetallePedidoCompraImpor;
	}

	public void setActivarcantidad_entraDetallePedidoCompraImpor(Boolean activarcantidad_entraDetallePedidoCompraImpor) {
		this.activarcantidad_entraDetallePedidoCompraImpor= activarcantidad_entraDetallePedidoCompraImpor;
	}

	public Border setResaltarcantidad_pendienteDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarcantidad_pendienteDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_pendienteDetallePedidoCompraImpor() {
		return this.resaltarcantidad_pendienteDetallePedidoCompraImpor;
	}

	public void setResaltarcantidad_pendienteDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarcantidad_pendienteDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarcantidad_pendienteDetallePedidoCompraImpor() {
		return this.mostrarcantidad_pendienteDetallePedidoCompraImpor;
	}

	public void setMostrarcantidad_pendienteDetallePedidoCompraImpor(Boolean mostrarcantidad_pendienteDetallePedidoCompraImpor) {
		this.mostrarcantidad_pendienteDetallePedidoCompraImpor= mostrarcantidad_pendienteDetallePedidoCompraImpor;
	}

	public Boolean getActivarcantidad_pendienteDetallePedidoCompraImpor() {
		return this.activarcantidad_pendienteDetallePedidoCompraImpor;
	}

	public void setActivarcantidad_pendienteDetallePedidoCompraImpor(Boolean activarcantidad_pendienteDetallePedidoCompraImpor) {
		this.activarcantidad_pendienteDetallePedidoCompraImpor= activarcantidad_pendienteDetallePedidoCompraImpor;
	}

	public Border setResaltarporcentajeDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarporcentajeDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeDetallePedidoCompraImpor() {
		return this.resaltarporcentajeDetallePedidoCompraImpor;
	}

	public void setResaltarporcentajeDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarporcentajeDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarporcentajeDetallePedidoCompraImpor() {
		return this.mostrarporcentajeDetallePedidoCompraImpor;
	}

	public void setMostrarporcentajeDetallePedidoCompraImpor(Boolean mostrarporcentajeDetallePedidoCompraImpor) {
		this.mostrarporcentajeDetallePedidoCompraImpor= mostrarporcentajeDetallePedidoCompraImpor;
	}

	public Boolean getActivarporcentajeDetallePedidoCompraImpor() {
		return this.activarporcentajeDetallePedidoCompraImpor;
	}

	public void setActivarporcentajeDetallePedidoCompraImpor(Boolean activarporcentajeDetallePedidoCompraImpor) {
		this.activarporcentajeDetallePedidoCompraImpor= activarporcentajeDetallePedidoCompraImpor;
	}

	public Border setResaltarpesoDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarpesoDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarpesoDetallePedidoCompraImpor() {
		return this.resaltarpesoDetallePedidoCompraImpor;
	}

	public void setResaltarpesoDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarpesoDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarpesoDetallePedidoCompraImpor() {
		return this.mostrarpesoDetallePedidoCompraImpor;
	}

	public void setMostrarpesoDetallePedidoCompraImpor(Boolean mostrarpesoDetallePedidoCompraImpor) {
		this.mostrarpesoDetallePedidoCompraImpor= mostrarpesoDetallePedidoCompraImpor;
	}

	public Boolean getActivarpesoDetallePedidoCompraImpor() {
		return this.activarpesoDetallePedidoCompraImpor;
	}

	public void setActivarpesoDetallePedidoCompraImpor(Boolean activarpesoDetallePedidoCompraImpor) {
		this.activarpesoDetallePedidoCompraImpor= activarpesoDetallePedidoCompraImpor;
	}

	public Border setResaltarprecioDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarprecioDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioDetallePedidoCompraImpor() {
		return this.resaltarprecioDetallePedidoCompraImpor;
	}

	public void setResaltarprecioDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarprecioDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarprecioDetallePedidoCompraImpor() {
		return this.mostrarprecioDetallePedidoCompraImpor;
	}

	public void setMostrarprecioDetallePedidoCompraImpor(Boolean mostrarprecioDetallePedidoCompraImpor) {
		this.mostrarprecioDetallePedidoCompraImpor= mostrarprecioDetallePedidoCompraImpor;
	}

	public Boolean getActivarprecioDetallePedidoCompraImpor() {
		return this.activarprecioDetallePedidoCompraImpor;
	}

	public void setActivarprecioDetallePedidoCompraImpor(Boolean activarprecioDetallePedidoCompraImpor) {
		this.activarprecioDetallePedidoCompraImpor= activarprecioDetallePedidoCompraImpor;
	}

	public Border setResaltarloteDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarloteDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarloteDetallePedidoCompraImpor() {
		return this.resaltarloteDetallePedidoCompraImpor;
	}

	public void setResaltarloteDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarloteDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarloteDetallePedidoCompraImpor() {
		return this.mostrarloteDetallePedidoCompraImpor;
	}

	public void setMostrarloteDetallePedidoCompraImpor(Boolean mostrarloteDetallePedidoCompraImpor) {
		this.mostrarloteDetallePedidoCompraImpor= mostrarloteDetallePedidoCompraImpor;
	}

	public Boolean getActivarloteDetallePedidoCompraImpor() {
		return this.activarloteDetallePedidoCompraImpor;
	}

	public void setActivarloteDetallePedidoCompraImpor(Boolean activarloteDetallePedidoCompraImpor) {
		this.activarloteDetallePedidoCompraImpor= activarloteDetallePedidoCompraImpor;
	}

	public Border setResaltarporcentaje_arancelDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarporcentaje_arancelDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_arancelDetallePedidoCompraImpor() {
		return this.resaltarporcentaje_arancelDetallePedidoCompraImpor;
	}

	public void setResaltarporcentaje_arancelDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarporcentaje_arancelDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarporcentaje_arancelDetallePedidoCompraImpor() {
		return this.mostrarporcentaje_arancelDetallePedidoCompraImpor;
	}

	public void setMostrarporcentaje_arancelDetallePedidoCompraImpor(Boolean mostrarporcentaje_arancelDetallePedidoCompraImpor) {
		this.mostrarporcentaje_arancelDetallePedidoCompraImpor= mostrarporcentaje_arancelDetallePedidoCompraImpor;
	}

	public Boolean getActivarporcentaje_arancelDetallePedidoCompraImpor() {
		return this.activarporcentaje_arancelDetallePedidoCompraImpor;
	}

	public void setActivarporcentaje_arancelDetallePedidoCompraImpor(Boolean activarporcentaje_arancelDetallePedidoCompraImpor) {
		this.activarporcentaje_arancelDetallePedidoCompraImpor= activarporcentaje_arancelDetallePedidoCompraImpor;
	}

	public Border setResaltarcantidad_unidad_auxiliarDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarcantidad_unidad_auxiliarDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_unidad_auxiliarDetallePedidoCompraImpor() {
		return this.resaltarcantidad_unidad_auxiliarDetallePedidoCompraImpor;
	}

	public void setResaltarcantidad_unidad_auxiliarDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarcantidad_unidad_auxiliarDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarcantidad_unidad_auxiliarDetallePedidoCompraImpor() {
		return this.mostrarcantidad_unidad_auxiliarDetallePedidoCompraImpor;
	}

	public void setMostrarcantidad_unidad_auxiliarDetallePedidoCompraImpor(Boolean mostrarcantidad_unidad_auxiliarDetallePedidoCompraImpor) {
		this.mostrarcantidad_unidad_auxiliarDetallePedidoCompraImpor= mostrarcantidad_unidad_auxiliarDetallePedidoCompraImpor;
	}

	public Boolean getActivarcantidad_unidad_auxiliarDetallePedidoCompraImpor() {
		return this.activarcantidad_unidad_auxiliarDetallePedidoCompraImpor;
	}

	public void setActivarcantidad_unidad_auxiliarDetallePedidoCompraImpor(Boolean activarcantidad_unidad_auxiliarDetallePedidoCompraImpor) {
		this.activarcantidad_unidad_auxiliarDetallePedidoCompraImpor= activarcantidad_unidad_auxiliarDetallePedidoCompraImpor;
	}

	public Border setResaltarprecio_unidad_auxiliarDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarprecio_unidad_auxiliarDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecio_unidad_auxiliarDetallePedidoCompraImpor() {
		return this.resaltarprecio_unidad_auxiliarDetallePedidoCompraImpor;
	}

	public void setResaltarprecio_unidad_auxiliarDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarprecio_unidad_auxiliarDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarprecio_unidad_auxiliarDetallePedidoCompraImpor() {
		return this.mostrarprecio_unidad_auxiliarDetallePedidoCompraImpor;
	}

	public void setMostrarprecio_unidad_auxiliarDetallePedidoCompraImpor(Boolean mostrarprecio_unidad_auxiliarDetallePedidoCompraImpor) {
		this.mostrarprecio_unidad_auxiliarDetallePedidoCompraImpor= mostrarprecio_unidad_auxiliarDetallePedidoCompraImpor;
	}

	public Boolean getActivarprecio_unidad_auxiliarDetallePedidoCompraImpor() {
		return this.activarprecio_unidad_auxiliarDetallePedidoCompraImpor;
	}

	public void setActivarprecio_unidad_auxiliarDetallePedidoCompraImpor(Boolean activarprecio_unidad_auxiliarDetallePedidoCompraImpor) {
		this.activarprecio_unidad_auxiliarDetallePedidoCompraImpor= activarprecio_unidad_auxiliarDetallePedidoCompraImpor;
	}

	public Border setResaltarfobDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarfobDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfobDetallePedidoCompraImpor() {
		return this.resaltarfobDetallePedidoCompraImpor;
	}

	public void setResaltarfobDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarfobDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarfobDetallePedidoCompraImpor() {
		return this.mostrarfobDetallePedidoCompraImpor;
	}

	public void setMostrarfobDetallePedidoCompraImpor(Boolean mostrarfobDetallePedidoCompraImpor) {
		this.mostrarfobDetallePedidoCompraImpor= mostrarfobDetallePedidoCompraImpor;
	}

	public Boolean getActivarfobDetallePedidoCompraImpor() {
		return this.activarfobDetallePedidoCompraImpor;
	}

	public void setActivarfobDetallePedidoCompraImpor(Boolean activarfobDetallePedidoCompraImpor) {
		this.activarfobDetallePedidoCompraImpor= activarfobDetallePedidoCompraImpor;
	}

	public Border setResaltarfob_exwDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarfob_exwDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfob_exwDetallePedidoCompraImpor() {
		return this.resaltarfob_exwDetallePedidoCompraImpor;
	}

	public void setResaltarfob_exwDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarfob_exwDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarfob_exwDetallePedidoCompraImpor() {
		return this.mostrarfob_exwDetallePedidoCompraImpor;
	}

	public void setMostrarfob_exwDetallePedidoCompraImpor(Boolean mostrarfob_exwDetallePedidoCompraImpor) {
		this.mostrarfob_exwDetallePedidoCompraImpor= mostrarfob_exwDetallePedidoCompraImpor;
	}

	public Boolean getActivarfob_exwDetallePedidoCompraImpor() {
		return this.activarfob_exwDetallePedidoCompraImpor;
	}

	public void setActivarfob_exwDetallePedidoCompraImpor(Boolean activarfob_exwDetallePedidoCompraImpor) {
		this.activarfob_exwDetallePedidoCompraImpor= activarfob_exwDetallePedidoCompraImpor;
	}

	public Border setResaltartotalDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltartotalDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalDetallePedidoCompraImpor() {
		return this.resaltartotalDetallePedidoCompraImpor;
	}

	public void setResaltartotalDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltartotalDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrartotalDetallePedidoCompraImpor() {
		return this.mostrartotalDetallePedidoCompraImpor;
	}

	public void setMostrartotalDetallePedidoCompraImpor(Boolean mostrartotalDetallePedidoCompraImpor) {
		this.mostrartotalDetallePedidoCompraImpor= mostrartotalDetallePedidoCompraImpor;
	}

	public Boolean getActivartotalDetallePedidoCompraImpor() {
		return this.activartotalDetallePedidoCompraImpor;
	}

	public void setActivartotalDetallePedidoCompraImpor(Boolean activartotalDetallePedidoCompraImpor) {
		this.activartotalDetallePedidoCompraImpor= activartotalDetallePedidoCompraImpor;
	}

	public Border setResaltardescripcionDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltardescripcionDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetallePedidoCompraImpor() {
		return this.resaltardescripcionDetallePedidoCompraImpor;
	}

	public void setResaltardescripcionDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltardescripcionDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrardescripcionDetallePedidoCompraImpor() {
		return this.mostrardescripcionDetallePedidoCompraImpor;
	}

	public void setMostrardescripcionDetallePedidoCompraImpor(Boolean mostrardescripcionDetallePedidoCompraImpor) {
		this.mostrardescripcionDetallePedidoCompraImpor= mostrardescripcionDetallePedidoCompraImpor;
	}

	public Boolean getActivardescripcionDetallePedidoCompraImpor() {
		return this.activardescripcionDetallePedidoCompraImpor;
	}

	public void setActivardescripcionDetallePedidoCompraImpor(Boolean activardescripcionDetallePedidoCompraImpor) {
		this.activardescripcionDetallePedidoCompraImpor= activardescripcionDetallePedidoCompraImpor;
	}

	public Border setResaltarid_centro_costoDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetallePedidoCompraImpor() {
		return this.resaltarid_centro_costoDetallePedidoCompraImpor;
	}

	public void setResaltarid_centro_costoDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_centro_costoDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetallePedidoCompraImpor() {
		return this.mostrarid_centro_costoDetallePedidoCompraImpor;
	}

	public void setMostrarid_centro_costoDetallePedidoCompraImpor(Boolean mostrarid_centro_costoDetallePedidoCompraImpor) {
		this.mostrarid_centro_costoDetallePedidoCompraImpor= mostrarid_centro_costoDetallePedidoCompraImpor;
	}

	public Boolean getActivarid_centro_costoDetallePedidoCompraImpor() {
		return this.activarid_centro_costoDetallePedidoCompraImpor;
	}

	public void setActivarid_centro_costoDetallePedidoCompraImpor(Boolean activarid_centro_costoDetallePedidoCompraImpor) {
		this.activarid_centro_costoDetallePedidoCompraImpor= activarid_centro_costoDetallePedidoCompraImpor;
	}

	public Boolean getCargarid_centro_costoDetallePedidoCompraImpor() {
		return this.cargarid_centro_costoDetallePedidoCompraImpor;
	}

	public void setCargarid_centro_costoDetallePedidoCompraImpor(Boolean cargarid_centro_costoDetallePedidoCompraImpor) {
		this.cargarid_centro_costoDetallePedidoCompraImpor= cargarid_centro_costoDetallePedidoCompraImpor;
	}

	public Border setResaltarid_anioDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_anioDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetallePedidoCompraImpor() {
		return this.resaltarid_anioDetallePedidoCompraImpor;
	}

	public void setResaltarid_anioDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_anioDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_anioDetallePedidoCompraImpor() {
		return this.mostrarid_anioDetallePedidoCompraImpor;
	}

	public void setMostrarid_anioDetallePedidoCompraImpor(Boolean mostrarid_anioDetallePedidoCompraImpor) {
		this.mostrarid_anioDetallePedidoCompraImpor= mostrarid_anioDetallePedidoCompraImpor;
	}

	public Boolean getActivarid_anioDetallePedidoCompraImpor() {
		return this.activarid_anioDetallePedidoCompraImpor;
	}

	public void setActivarid_anioDetallePedidoCompraImpor(Boolean activarid_anioDetallePedidoCompraImpor) {
		this.activarid_anioDetallePedidoCompraImpor= activarid_anioDetallePedidoCompraImpor;
	}

	public Boolean getCargarid_anioDetallePedidoCompraImpor() {
		return this.cargarid_anioDetallePedidoCompraImpor;
	}

	public void setCargarid_anioDetallePedidoCompraImpor(Boolean cargarid_anioDetallePedidoCompraImpor) {
		this.cargarid_anioDetallePedidoCompraImpor= cargarid_anioDetallePedidoCompraImpor;
	}

	public Border setResaltarid_mesDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepedidocompraimporBeanSwingJInternalFrame.jTtoolBarDetallePedidoCompraImpor.setBorder(borderResaltar);
		
		this.resaltarid_mesDetallePedidoCompraImpor= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetallePedidoCompraImpor() {
		return this.resaltarid_mesDetallePedidoCompraImpor;
	}

	public void setResaltarid_mesDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarid_mesDetallePedidoCompraImpor= borderResaltar;
	}

	public Boolean getMostrarid_mesDetallePedidoCompraImpor() {
		return this.mostrarid_mesDetallePedidoCompraImpor;
	}

	public void setMostrarid_mesDetallePedidoCompraImpor(Boolean mostrarid_mesDetallePedidoCompraImpor) {
		this.mostrarid_mesDetallePedidoCompraImpor= mostrarid_mesDetallePedidoCompraImpor;
	}

	public Boolean getActivarid_mesDetallePedidoCompraImpor() {
		return this.activarid_mesDetallePedidoCompraImpor;
	}

	public void setActivarid_mesDetallePedidoCompraImpor(Boolean activarid_mesDetallePedidoCompraImpor) {
		this.activarid_mesDetallePedidoCompraImpor= activarid_mesDetallePedidoCompraImpor;
	}

	public Boolean getCargarid_mesDetallePedidoCompraImpor() {
		return this.cargarid_mesDetallePedidoCompraImpor;
	}

	public void setCargarid_mesDetallePedidoCompraImpor(Boolean cargarid_mesDetallePedidoCompraImpor) {
		this.cargarid_mesDetallePedidoCompraImpor= cargarid_mesDetallePedidoCompraImpor;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridDetallePedidoCompraImpor(esInicial);
		this.setMostrarid_pedido_compra_imporDetallePedidoCompraImpor(esInicial);
		this.setMostrarid_empresaDetallePedidoCompraImpor(esInicial);
		this.setMostrarid_sucursalDetallePedidoCompraImpor(esInicial);
		this.setMostrarid_bodegaDetallePedidoCompraImpor(esInicial);
		this.setMostrarid_productoDetallePedidoCompraImpor(esInicial);
		this.setMostrarid_unidadDetallePedidoCompraImpor(esInicial);
		this.setMostrarid_ejercicioDetallePedidoCompraImpor(esInicial);
		this.setMostrarid_periodoDetallePedidoCompraImpor(esInicial);
		this.setMostrarid_arancelDetallePedidoCompraImpor(esInicial);
		this.setMostrarcantidad_pedidoDetallePedidoCompraImpor(esInicial);
		this.setMostrarcantidad_entraDetallePedidoCompraImpor(esInicial);
		this.setMostrarcantidad_pendienteDetallePedidoCompraImpor(esInicial);
		this.setMostrarporcentajeDetallePedidoCompraImpor(esInicial);
		this.setMostrarpesoDetallePedidoCompraImpor(esInicial);
		this.setMostrarprecioDetallePedidoCompraImpor(esInicial);
		this.setMostrarloteDetallePedidoCompraImpor(esInicial);
		this.setMostrarporcentaje_arancelDetallePedidoCompraImpor(esInicial);
		this.setMostrarcantidad_unidad_auxiliarDetallePedidoCompraImpor(esInicial);
		this.setMostrarprecio_unidad_auxiliarDetallePedidoCompraImpor(esInicial);
		this.setMostrarfobDetallePedidoCompraImpor(esInicial);
		this.setMostrarfob_exwDetallePedidoCompraImpor(esInicial);
		this.setMostrartotalDetallePedidoCompraImpor(esInicial);
		this.setMostrardescripcionDetallePedidoCompraImpor(esInicial);
		this.setMostrarid_centro_costoDetallePedidoCompraImpor(esInicial);
		this.setMostrarid_anioDetallePedidoCompraImpor(esInicial);
		this.setMostrarid_mesDetallePedidoCompraImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.ID)) {
				this.setMostraridDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR)) {
				this.setMostrarid_pedido_compra_imporDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDUNIDAD)) {
				this.setMostrarid_unidadDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDARANCEL)) {
				this.setMostrarid_arancelDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADPEDIDO)) {
				this.setMostrarcantidad_pedidoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADENTRA)) {
				this.setMostrarcantidad_entraDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setMostrarcantidad_pendienteDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PESO)) {
				this.setMostrarpesoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PRECIO)) {
				this.setMostrarprecioDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.LOTE)) {
				this.setMostrarloteDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PORCENTAJEARANCEL)) {
				this.setMostrarporcentaje_arancelDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADUNIDADAUXILIAR)) {
				this.setMostrarcantidad_unidad_auxiliarDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PRECIOUNIDADAUXILIAR)) {
				this.setMostrarprecio_unidad_auxiliarDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.FOB)) {
				this.setMostrarfobDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.FOBEXW)) {
				this.setMostrarfob_exwDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.TOTAL)) {
				this.setMostrartotalDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetallePedidoCompraImpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridDetallePedidoCompraImpor(esInicial);
		this.setActivarid_pedido_compra_imporDetallePedidoCompraImpor(esInicial);
		this.setActivarid_empresaDetallePedidoCompraImpor(esInicial);
		this.setActivarid_sucursalDetallePedidoCompraImpor(esInicial);
		this.setActivarid_bodegaDetallePedidoCompraImpor(esInicial);
		this.setActivarid_productoDetallePedidoCompraImpor(esInicial);
		this.setActivarid_unidadDetallePedidoCompraImpor(esInicial);
		this.setActivarid_ejercicioDetallePedidoCompraImpor(esInicial);
		this.setActivarid_periodoDetallePedidoCompraImpor(esInicial);
		this.setActivarid_arancelDetallePedidoCompraImpor(esInicial);
		this.setActivarcantidad_pedidoDetallePedidoCompraImpor(esInicial);
		this.setActivarcantidad_entraDetallePedidoCompraImpor(esInicial);
		this.setActivarcantidad_pendienteDetallePedidoCompraImpor(esInicial);
		this.setActivarporcentajeDetallePedidoCompraImpor(esInicial);
		this.setActivarpesoDetallePedidoCompraImpor(esInicial);
		this.setActivarprecioDetallePedidoCompraImpor(esInicial);
		this.setActivarloteDetallePedidoCompraImpor(esInicial);
		this.setActivarporcentaje_arancelDetallePedidoCompraImpor(esInicial);
		this.setActivarcantidad_unidad_auxiliarDetallePedidoCompraImpor(esInicial);
		this.setActivarprecio_unidad_auxiliarDetallePedidoCompraImpor(esInicial);
		this.setActivarfobDetallePedidoCompraImpor(esInicial);
		this.setActivarfob_exwDetallePedidoCompraImpor(esInicial);
		this.setActivartotalDetallePedidoCompraImpor(esInicial);
		this.setActivardescripcionDetallePedidoCompraImpor(esInicial);
		this.setActivarid_centro_costoDetallePedidoCompraImpor(esInicial);
		this.setActivarid_anioDetallePedidoCompraImpor(esInicial);
		this.setActivarid_mesDetallePedidoCompraImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.ID)) {
				this.setActivaridDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR)) {
				this.setActivarid_pedido_compra_imporDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDUNIDAD)) {
				this.setActivarid_unidadDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDARANCEL)) {
				this.setActivarid_arancelDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADPEDIDO)) {
				this.setActivarcantidad_pedidoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADENTRA)) {
				this.setActivarcantidad_entraDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setActivarcantidad_pendienteDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PESO)) {
				this.setActivarpesoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PRECIO)) {
				this.setActivarprecioDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.LOTE)) {
				this.setActivarloteDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PORCENTAJEARANCEL)) {
				this.setActivarporcentaje_arancelDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADUNIDADAUXILIAR)) {
				this.setActivarcantidad_unidad_auxiliarDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PRECIOUNIDADAUXILIAR)) {
				this.setActivarprecio_unidad_auxiliarDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.FOB)) {
				this.setActivarfobDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.FOBEXW)) {
				this.setActivarfob_exwDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.TOTAL)) {
				this.setActivartotalDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetallePedidoCompraImpor(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetallePedidoCompraImpor(esInicial);
		this.setResaltarid_pedido_compra_imporDetallePedidoCompraImpor(esInicial);
		this.setResaltarid_empresaDetallePedidoCompraImpor(esInicial);
		this.setResaltarid_sucursalDetallePedidoCompraImpor(esInicial);
		this.setResaltarid_bodegaDetallePedidoCompraImpor(esInicial);
		this.setResaltarid_productoDetallePedidoCompraImpor(esInicial);
		this.setResaltarid_unidadDetallePedidoCompraImpor(esInicial);
		this.setResaltarid_ejercicioDetallePedidoCompraImpor(esInicial);
		this.setResaltarid_periodoDetallePedidoCompraImpor(esInicial);
		this.setResaltarid_arancelDetallePedidoCompraImpor(esInicial);
		this.setResaltarcantidad_pedidoDetallePedidoCompraImpor(esInicial);
		this.setResaltarcantidad_entraDetallePedidoCompraImpor(esInicial);
		this.setResaltarcantidad_pendienteDetallePedidoCompraImpor(esInicial);
		this.setResaltarporcentajeDetallePedidoCompraImpor(esInicial);
		this.setResaltarpesoDetallePedidoCompraImpor(esInicial);
		this.setResaltarprecioDetallePedidoCompraImpor(esInicial);
		this.setResaltarloteDetallePedidoCompraImpor(esInicial);
		this.setResaltarporcentaje_arancelDetallePedidoCompraImpor(esInicial);
		this.setResaltarcantidad_unidad_auxiliarDetallePedidoCompraImpor(esInicial);
		this.setResaltarprecio_unidad_auxiliarDetallePedidoCompraImpor(esInicial);
		this.setResaltarfobDetallePedidoCompraImpor(esInicial);
		this.setResaltarfob_exwDetallePedidoCompraImpor(esInicial);
		this.setResaltartotalDetallePedidoCompraImpor(esInicial);
		this.setResaltardescripcionDetallePedidoCompraImpor(esInicial);
		this.setResaltarid_centro_costoDetallePedidoCompraImpor(esInicial);
		this.setResaltarid_anioDetallePedidoCompraImpor(esInicial);
		this.setResaltarid_mesDetallePedidoCompraImpor(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.ID)) {
				this.setResaltaridDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDPEDIDOCOMPRAIMPOR)) {
				this.setResaltarid_pedido_compra_imporDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDUNIDAD)) {
				this.setResaltarid_unidadDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDARANCEL)) {
				this.setResaltarid_arancelDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADPEDIDO)) {
				this.setResaltarcantidad_pedidoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADENTRA)) {
				this.setResaltarcantidad_entraDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADPENDIENTE)) {
				this.setResaltarcantidad_pendienteDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PESO)) {
				this.setResaltarpesoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PRECIO)) {
				this.setResaltarprecioDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.LOTE)) {
				this.setResaltarloteDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PORCENTAJEARANCEL)) {
				this.setResaltarporcentaje_arancelDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.CANTIDADUNIDADAUXILIAR)) {
				this.setResaltarcantidad_unidad_auxiliarDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.PRECIOUNIDADAUXILIAR)) {
				this.setResaltarprecio_unidad_auxiliarDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.FOB)) {
				this.setResaltarfobDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.FOBEXW)) {
				this.setResaltarfob_exwDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.TOTAL)) {
				this.setResaltartotalDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetallePedidoCompraImpor(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePedidoCompraImporConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetallePedidoCompraImpor(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarFK_IdArancelDetallePedidoCompraImpor=true;

	public Boolean getMostrarFK_IdArancelDetallePedidoCompraImpor() {
		return this.mostrarFK_IdArancelDetallePedidoCompraImpor;
	}

	public void setMostrarFK_IdArancelDetallePedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdArancelDetallePedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdBodegaDetallePedidoCompraImpor=true;

	public Boolean getMostrarFK_IdBodegaDetallePedidoCompraImpor() {
		return this.mostrarFK_IdBodegaDetallePedidoCompraImpor;
	}

	public void setMostrarFK_IdBodegaDetallePedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdBodegaDetallePedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoDetallePedidoCompraImpor=true;

	public Boolean getMostrarFK_IdCentroCostoDetallePedidoCompraImpor() {
		return this.mostrarFK_IdCentroCostoDetallePedidoCompraImpor;
	}

	public void setMostrarFK_IdCentroCostoDetallePedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetallePedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetallePedidoCompraImpor=true;

	public Boolean getMostrarFK_IdEjercicioDetallePedidoCompraImpor() {
		return this.mostrarFK_IdEjercicioDetallePedidoCompraImpor;
	}

	public void setMostrarFK_IdEjercicioDetallePedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetallePedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetallePedidoCompraImpor=true;

	public Boolean getMostrarFK_IdEmpresaDetallePedidoCompraImpor() {
		return this.mostrarFK_IdEmpresaDetallePedidoCompraImpor;
	}

	public void setMostrarFK_IdEmpresaDetallePedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetallePedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPedidoCompraImporDetallePedidoCompraImpor=true;

	public Boolean getMostrarFK_IdPedidoCompraImporDetallePedidoCompraImpor() {
		return this.mostrarFK_IdPedidoCompraImporDetallePedidoCompraImpor;
	}

	public void setMostrarFK_IdPedidoCompraImporDetallePedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPedidoCompraImporDetallePedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetallePedidoCompraImpor=true;

	public Boolean getMostrarFK_IdPeriodoDetallePedidoCompraImpor() {
		return this.mostrarFK_IdPeriodoDetallePedidoCompraImpor;
	}

	public void setMostrarFK_IdPeriodoDetallePedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetallePedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdProductoDetallePedidoCompraImpor=true;

	public Boolean getMostrarFK_IdProductoDetallePedidoCompraImpor() {
		return this.mostrarFK_IdProductoDetallePedidoCompraImpor;
	}

	public void setMostrarFK_IdProductoDetallePedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdProductoDetallePedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetallePedidoCompraImpor=true;

	public Boolean getMostrarFK_IdSucursalDetallePedidoCompraImpor() {
		return this.mostrarFK_IdSucursalDetallePedidoCompraImpor;
	}

	public void setMostrarFK_IdSucursalDetallePedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetallePedidoCompraImpor= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUnidadDetallePedidoCompraImpor=true;

	public Boolean getMostrarFK_IdUnidadDetallePedidoCompraImpor() {
		return this.mostrarFK_IdUnidadDetallePedidoCompraImpor;
	}

	public void setMostrarFK_IdUnidadDetallePedidoCompraImpor(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUnidadDetallePedidoCompraImpor= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdArancelDetallePedidoCompraImpor=true;

	public Boolean getActivarFK_IdArancelDetallePedidoCompraImpor() {
		return this.activarFK_IdArancelDetallePedidoCompraImpor;
	}

	public void setActivarFK_IdArancelDetallePedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdArancelDetallePedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdBodegaDetallePedidoCompraImpor=true;

	public Boolean getActivarFK_IdBodegaDetallePedidoCompraImpor() {
		return this.activarFK_IdBodegaDetallePedidoCompraImpor;
	}

	public void setActivarFK_IdBodegaDetallePedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdBodegaDetallePedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoDetallePedidoCompraImpor=true;

	public Boolean getActivarFK_IdCentroCostoDetallePedidoCompraImpor() {
		return this.activarFK_IdCentroCostoDetallePedidoCompraImpor;
	}

	public void setActivarFK_IdCentroCostoDetallePedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetallePedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetallePedidoCompraImpor=true;

	public Boolean getActivarFK_IdEjercicioDetallePedidoCompraImpor() {
		return this.activarFK_IdEjercicioDetallePedidoCompraImpor;
	}

	public void setActivarFK_IdEjercicioDetallePedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetallePedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetallePedidoCompraImpor=true;

	public Boolean getActivarFK_IdEmpresaDetallePedidoCompraImpor() {
		return this.activarFK_IdEmpresaDetallePedidoCompraImpor;
	}

	public void setActivarFK_IdEmpresaDetallePedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetallePedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdPedidoCompraImporDetallePedidoCompraImpor=true;

	public Boolean getActivarFK_IdPedidoCompraImporDetallePedidoCompraImpor() {
		return this.activarFK_IdPedidoCompraImporDetallePedidoCompraImpor;
	}

	public void setActivarFK_IdPedidoCompraImporDetallePedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdPedidoCompraImporDetallePedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetallePedidoCompraImpor=true;

	public Boolean getActivarFK_IdPeriodoDetallePedidoCompraImpor() {
		return this.activarFK_IdPeriodoDetallePedidoCompraImpor;
	}

	public void setActivarFK_IdPeriodoDetallePedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetallePedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdProductoDetallePedidoCompraImpor=true;

	public Boolean getActivarFK_IdProductoDetallePedidoCompraImpor() {
		return this.activarFK_IdProductoDetallePedidoCompraImpor;
	}

	public void setActivarFK_IdProductoDetallePedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdProductoDetallePedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetallePedidoCompraImpor=true;

	public Boolean getActivarFK_IdSucursalDetallePedidoCompraImpor() {
		return this.activarFK_IdSucursalDetallePedidoCompraImpor;
	}

	public void setActivarFK_IdSucursalDetallePedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetallePedidoCompraImpor= habilitarResaltar;
	}

	public Boolean activarFK_IdUnidadDetallePedidoCompraImpor=true;

	public Boolean getActivarFK_IdUnidadDetallePedidoCompraImpor() {
		return this.activarFK_IdUnidadDetallePedidoCompraImpor;
	}

	public void setActivarFK_IdUnidadDetallePedidoCompraImpor(Boolean habilitarResaltar) {
		this.activarFK_IdUnidadDetallePedidoCompraImpor= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdArancelDetallePedidoCompraImpor=null;

	public Border getResaltarFK_IdArancelDetallePedidoCompraImpor() {
		return this.resaltarFK_IdArancelDetallePedidoCompraImpor;
	}

	public void setResaltarFK_IdArancelDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdArancelDetallePedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdArancelDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdArancelDetallePedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdBodegaDetallePedidoCompraImpor=null;

	public Border getResaltarFK_IdBodegaDetallePedidoCompraImpor() {
		return this.resaltarFK_IdBodegaDetallePedidoCompraImpor;
	}

	public void setResaltarFK_IdBodegaDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdBodegaDetallePedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdBodegaDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdBodegaDetallePedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoDetallePedidoCompraImpor=null;

	public Border getResaltarFK_IdCentroCostoDetallePedidoCompraImpor() {
		return this.resaltarFK_IdCentroCostoDetallePedidoCompraImpor;
	}

	public void setResaltarFK_IdCentroCostoDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetallePedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetallePedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetallePedidoCompraImpor=null;

	public Border getResaltarFK_IdEjercicioDetallePedidoCompraImpor() {
		return this.resaltarFK_IdEjercicioDetallePedidoCompraImpor;
	}

	public void setResaltarFK_IdEjercicioDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetallePedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetallePedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetallePedidoCompraImpor=null;

	public Border getResaltarFK_IdEmpresaDetallePedidoCompraImpor() {
		return this.resaltarFK_IdEmpresaDetallePedidoCompraImpor;
	}

	public void setResaltarFK_IdEmpresaDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetallePedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetallePedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdPedidoCompraImporDetallePedidoCompraImpor=null;

	public Border getResaltarFK_IdPedidoCompraImporDetallePedidoCompraImpor() {
		return this.resaltarFK_IdPedidoCompraImporDetallePedidoCompraImpor;
	}

	public void setResaltarFK_IdPedidoCompraImporDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdPedidoCompraImporDetallePedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdPedidoCompraImporDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPedidoCompraImporDetallePedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetallePedidoCompraImpor=null;

	public Border getResaltarFK_IdPeriodoDetallePedidoCompraImpor() {
		return this.resaltarFK_IdPeriodoDetallePedidoCompraImpor;
	}

	public void setResaltarFK_IdPeriodoDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetallePedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetallePedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdProductoDetallePedidoCompraImpor=null;

	public Border getResaltarFK_IdProductoDetallePedidoCompraImpor() {
		return this.resaltarFK_IdProductoDetallePedidoCompraImpor;
	}

	public void setResaltarFK_IdProductoDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdProductoDetallePedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdProductoDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdProductoDetallePedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetallePedidoCompraImpor=null;

	public Border getResaltarFK_IdSucursalDetallePedidoCompraImpor() {
		return this.resaltarFK_IdSucursalDetallePedidoCompraImpor;
	}

	public void setResaltarFK_IdSucursalDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetallePedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetallePedidoCompraImpor= borderResaltar;
	}

	public Border resaltarFK_IdUnidadDetallePedidoCompraImpor=null;

	public Border getResaltarFK_IdUnidadDetallePedidoCompraImpor() {
		return this.resaltarFK_IdUnidadDetallePedidoCompraImpor;
	}

	public void setResaltarFK_IdUnidadDetallePedidoCompraImpor(Border borderResaltar) {
		this.resaltarFK_IdUnidadDetallePedidoCompraImpor= borderResaltar;
	}

	public void setResaltarFK_IdUnidadDetallePedidoCompraImpor(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePedidoCompraImporBeanSwingJInternalFrame detallepedidocompraimporBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUnidadDetallePedidoCompraImpor= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}