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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.OrdenCompraConstantesFunciones;
import com.bydan.erp.inventario.util.OrdenCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.OrdenCompraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class OrdenCompraConstantesFunciones extends OrdenCompraConstantesFuncionesAdditional {		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,-20);
	
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
	public static final String SNOMBREOPCION="OrdenCompra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="OrdenCompra"+OrdenCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="OrdenCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="OrdenCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=OrdenCompraConstantesFunciones.SCHEMA+"_"+OrdenCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/OrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=OrdenCompraConstantesFunciones.SCHEMA+"_"+OrdenCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=OrdenCompraConstantesFunciones.SCHEMA+"_"+OrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/OrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=OrdenCompraConstantesFunciones.SCHEMA+"_"+OrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/OrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/OrdenCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+OrdenCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=OrdenCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+OrdenCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=OrdenCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+OrdenCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="OrdenCompras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="OrdenCompra";
	public static final String SCLASSWEBTITULO_LOWER="Orden Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="OrdenCompra";
	public static final String OBJECTNAME="ordencompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="orden_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ordencompra from "+OrdenCompraConstantesFunciones.SPERSISTENCENAME+" ordencompra";
	public static String QUERYSELECTNATIVE="select "+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".version_row,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_empresa,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_sucursal,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_modulo,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_periodo,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_anio,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_mes,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_usuario,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".fecha_emision,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".fecha_entrega,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".numero_secuencial,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_moneda,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_tipo_cambio,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_estado_orden_compra,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_cliente,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_formato,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_transportista,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_empleado,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".descripcion,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".porcentaje_descuento,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".suman,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".ice,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".valor_descuento,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".total_descuento,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".iva,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".stock,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".sub_total,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".total_otro,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".ultimo_costo,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".numero_items,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".retencion,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".total,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".flete,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".impuesto,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_orden_compra,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".id_asiento_contable,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".numero_comprobante,"+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME+".fecha from "+OrdenCompraConstantesFunciones.SCHEMA+"."+OrdenCompraConstantesFunciones.TABLENAME;//+" as "+OrdenCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected OrdenCompraConstantesFuncionesAdditional ordencompraConstantesFuncionesAdditional=null;
	
	public OrdenCompraConstantesFuncionesAdditional getOrdenCompraConstantesFuncionesAdditional() {
		return this.ordencompraConstantesFuncionesAdditional;
	}
	
	public void setOrdenCompraConstantesFuncionesAdditional(OrdenCompraConstantesFuncionesAdditional ordencompraConstantesFuncionesAdditional) {
		try {
			this.ordencompraConstantesFuncionesAdditional=ordencompraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDMODULO= "id_modulo";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDUSUARIO= "id_usuario";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String FECHAENTREGA= "fecha_entrega";
    public static final String NUMEROSECUENCIAL= "numero_secuencial";
    public static final String IDMONEDA= "id_moneda";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
    public static final String IDESTADOORDENCOMPRA= "id_estado_orden_compra";
    public static final String IDCLIENTE= "id_cliente";
    public static final String IDFORMATO= "id_formato";
    public static final String IDTRANSPORTISTA= "id_transportista";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String DESCRIPCION= "descripcion";
    public static final String PORCENTAJEDESCUENTO= "porcentaje_descuento";
    public static final String SUMAN= "suman";
    public static final String ICE= "ice";
    public static final String VALORDESCUENTO= "valor_descuento";
    public static final String TOTALDESCUENTO= "total_descuento";
    public static final String IVA= "iva";
    public static final String STOCK= "stock";
    public static final String SUBTOTAL= "sub_total";
    public static final String TOTALOTRO= "total_otro";
    public static final String ULTIMOCOSTO= "ultimo_costo";
    public static final String NUMEROITEMS= "numero_items";
    public static final String RETENCION= "retencion";
    public static final String TOTAL= "total";
    public static final String FLETE= "flete";
    public static final String IMPUESTO= "impuesto";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
    public static final String IDORDENCOMPRA= "id_orden_compra";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String NUMEROCOMPROBANTE= "numero_comprobante";
    public static final String FECHA= "fecha";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_FECHAEMISION= "F Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "F Emision";
    	public static final String LABEL_FECHAENTREGA= "F Entrega";
		public static final String LABEL_FECHAENTREGA_LOWER= "F Entrega";
    	public static final String LABEL_NUMEROSECUENCIAL= "No Secuencial";
		public static final String LABEL_NUMEROSECUENCIAL_LOWER= "No Secuen";
    	public static final String LABEL_IDMONEDA= "Moneda";
		public static final String LABEL_IDMONEDA_LOWER= "Moneda";
    	public static final String LABEL_IDTIPOCAMBIO= "T Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
    	public static final String LABEL_IDESTADOORDENCOMPRA= "Estado";
		public static final String LABEL_IDESTADOORDENCOMPRA_LOWER= "Estado";
    	public static final String LABEL_IDCLIENTE= "Cliente";
		public static final String LABEL_IDCLIENTE_LOWER= "Cliente";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_IDTRANSPORTISTA= "Transportista";
		public static final String LABEL_IDTRANSPORTISTA_LOWER= "Transportista";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_PORCENTAJEDESCUENTO= "Descuento %";
		public static final String LABEL_PORCENTAJEDESCUENTO_LOWER= "% Descuento";
    	public static final String LABEL_SUMAN= "Suman";
		public static final String LABEL_SUMAN_LOWER= "Suman";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
    	public static final String LABEL_VALORDESCUENTO= "Descuento Valor";
		public static final String LABEL_VALORDESCUENTO_LOWER= "Val Desc";
    	public static final String LABEL_TOTALDESCUENTO= "Total Descuento";
		public static final String LABEL_TOTALDESCUENTO_LOWER= "Total Desc";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_STOCK= "Stock";
		public static final String LABEL_STOCK_LOWER= "Stock";
    	public static final String LABEL_SUBTOTAL= "Sub Total";
		public static final String LABEL_SUBTOTAL_LOWER= "Sub Total";
    	public static final String LABEL_TOTALOTRO= "Total Otro";
		public static final String LABEL_TOTALOTRO_LOWER= "Total Otro";
    	public static final String LABEL_ULTIMOCOSTO= "Ultimo Costo";
		public static final String LABEL_ULTIMOCOSTO_LOWER= "Ultimo Costo";
    	public static final String LABEL_NUMEROITEMS= "No Items";
		public static final String LABEL_NUMEROITEMS_LOWER= "No Items";
    	public static final String LABEL_RETENCION= "Retencion";
		public static final String LABEL_RETENCION_LOWER= "Retencion";
    	public static final String LABEL_TOTAL= "Total";
		public static final String LABEL_TOTAL_LOWER= "Total";
    	public static final String LABEL_FLETE= "Flete";
		public static final String LABEL_FLETE_LOWER= "Flete";
    	public static final String LABEL_IMPUESTO= "Impuesto";
		public static final String LABEL_IMPUESTO_LOWER= "Impuesto";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo";
    	public static final String LABEL_IDORDENCOMPRA= "Orden Compra";
		public static final String LABEL_IDORDENCOMPRA_LOWER= "Orden Compra";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_NUMEROCOMPROBANTE= "Numero Comprobante";
		public static final String LABEL_NUMEROCOMPROBANTE_LOWER= "Numero Comprobante";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_SECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_COMPROBANTE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getOrdenCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDEMPRESA)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDMODULO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDEJERCICIO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDPERIODO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDANIO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDMES)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDUSUARIO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.FECHAEMISION)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.FECHAENTREGA)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDMONEDA)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDESTADOORDENCOMPRA)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDESTADOORDENCOMPRA;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDCLIENTE)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDCLIENTE;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDFORMATO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDTRANSPORTISTA)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDTRANSPORTISTA;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDEMPLEADO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.DESCRIPCION)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.PORCENTAJEDESCUENTO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_PORCENTAJEDESCUENTO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.SUMAN)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_SUMAN;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.ICE)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.VALORDESCUENTO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_VALORDESCUENTO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.TOTALDESCUENTO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_TOTALDESCUENTO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IVA)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.STOCK)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_STOCK;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.SUBTOTAL)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.TOTALOTRO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_TOTALOTRO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.ULTIMOCOSTO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_ULTIMOCOSTO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.NUMEROITEMS)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_NUMEROITEMS;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.RETENCION)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_RETENCION;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.TOTAL)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.FLETE)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IMPUESTO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IMPUESTO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDORDENCOMPRA)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(OrdenCompraConstantesFunciones.FECHA)) {sLabelColumna=OrdenCompraConstantesFunciones.LABEL_FECHA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getOrdenCompraDescripcion(OrdenCompra ordencompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ordencompra !=null/* && ordencompra.getId()!=0*/) {
			if(ordencompra.getId()!=null) {
				sDescripcion=ordencompra.getId().toString();
			}//ordencompraordencompra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getOrdenCompraDescripcionDetallado(OrdenCompra ordencompra) {
		String sDescripcion="";
			
		sDescripcion+=OrdenCompraConstantesFunciones.ID+"=";
		sDescripcion+=ordencompra.getId().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ordencompra.getVersionRow().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ordencompra.getid_empresa().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=ordencompra.getid_sucursal().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDMODULO+"=";
		sDescripcion+=ordencompra.getid_modulo().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=ordencompra.getid_ejercicio().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=ordencompra.getid_periodo().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDANIO+"=";
		sDescripcion+=ordencompra.getid_anio().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDMES+"=";
		sDescripcion+=ordencompra.getid_mes().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=ordencompra.getid_usuario().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=ordencompra.getfecha_emision().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=ordencompra.getfecha_entrega().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=ordencompra.getnumero_secuencial()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=ordencompra.getid_moneda().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=ordencompra.getid_tipo_cambio().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDESTADOORDENCOMPRA+"=";
		sDescripcion+=ordencompra.getid_estado_orden_compra().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDCLIENTE+"=";
		sDescripcion+=ordencompra.getid_cliente().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=ordencompra.getid_formato().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDTRANSPORTISTA+"=";
		sDescripcion+=ordencompra.getid_transportista().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=ordencompra.getid_empleado().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=ordencompra.getdescripcion()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.PORCENTAJEDESCUENTO+"=";
		sDescripcion+=ordencompra.getporcentaje_descuento().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.SUMAN+"=";
		sDescripcion+=ordencompra.getsuman().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.ICE+"=";
		sDescripcion+=ordencompra.getice().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.VALORDESCUENTO+"=";
		sDescripcion+=ordencompra.getvalor_descuento().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.TOTALDESCUENTO+"=";
		sDescripcion+=ordencompra.gettotal_descuento().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IVA+"=";
		sDescripcion+=ordencompra.getiva().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.STOCK+"=";
		sDescripcion+=ordencompra.getstock().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=ordencompra.getsub_total().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.TOTALOTRO+"=";
		sDescripcion+=ordencompra.gettotal_otro().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.ULTIMOCOSTO+"=";
		sDescripcion+=ordencompra.getultimo_costo().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.NUMEROITEMS+"=";
		sDescripcion+=ordencompra.getnumero_items().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.RETENCION+"=";
		sDescripcion+=ordencompra.getretencion().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.TOTAL+"=";
		sDescripcion+=ordencompra.gettotal().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.FLETE+"=";
		sDescripcion+=ordencompra.getflete().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IMPUESTO+"=";
		sDescripcion+=ordencompra.getimpuesto().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=ordencompra.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDORDENCOMPRA+"=";
		sDescripcion+=ordencompra.getid_orden_compra().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=ordencompra.getid_asiento_contable().toString()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=ordencompra.getnumero_comprobante()+",";
		sDescripcion+=OrdenCompraConstantesFunciones.FECHA+"=";
		sDescripcion+=ordencompra.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setOrdenCompraDescripcion(OrdenCompra ordencompra,String sValor) throws Exception {			
		if(ordencompra !=null) {
			//ordencompraordencompra.getId().toString();
		}		
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

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getMonedaDescripcion(Moneda moneda) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(moneda!=null/*&&moneda.getId()>0*/) {
			sDescripcion=MonedaConstantesFunciones.getMonedaDescripcion(moneda);
		}

		return sDescripcion;
	}

	public static String getTipoCambioDescripcion(TipoCambio tipocambio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocambio!=null/*&&tipocambio.getId()>0*/) {
			sDescripcion=TipoCambioConstantesFunciones.getTipoCambioDescripcion(tipocambio);
		}

		return sDescripcion;
	}

	public static String getEstadoOrdenCompraDescripcion(EstadoOrdenCompra estadoordencompra) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoordencompra!=null/*&&estadoordencompra.getId()>0*/) {
			sDescripcion=EstadoOrdenCompraConstantesFunciones.getEstadoOrdenCompraDescripcion(estadoordencompra);
		}

		return sDescripcion;
	}

	public static String getClienteDescripcion(Cliente cliente) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cliente!=null/*&&cliente.getId()>0*/) {
			sDescripcion=ClienteConstantesFunciones.getClienteDescripcion(cliente);
		}

		return sDescripcion;
	}

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getTransportistaDescripcion(Transportista transportista) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transportista!=null/*&&transportista.getId()>0*/) {
			sDescripcion=TransportistaConstantesFunciones.getTransportistaDescripcion(transportista);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
		}

		return sDescripcion;
	}

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
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
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdCliente")) {
			sNombreIndice="Tipo=  Por Cliente";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoOrdenCompra")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
		} else if(sNombreIndice.equals("FK_IdOrdenCompra")) {
			sNombreIndice="Tipo=  Por Orden Compra";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por T Cambio";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("FK_IdTransportista")) {
			sNombreIndice="Tipo=  Por Transportista";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
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

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCliente(Long id_cliente) {
		String sDetalleIndice=" Parametros->";
		if(id_cliente!=null) {sDetalleIndice+=" Codigo Unico De Cliente="+id_cliente.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEstadoOrdenCompra(Long id_estado_orden_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_orden_compra!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_orden_compra.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMoneda(Long id_moneda) {
		String sDetalleIndice=" Parametros->";
		if(id_moneda!=null) {sDetalleIndice+=" Codigo Unico De Moneda="+id_moneda.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdOrdenCompra(Long id_orden_compra) {
		String sDetalleIndice=" Parametros->";
		if(id_orden_compra!=null) {sDetalleIndice+=" Codigo Unico De Orden Compra="+id_orden_compra.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCambio(Long id_tipo_cambio) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cambio!=null) {sDetalleIndice+=" Codigo Unico De T Cambio="+id_tipo_cambio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransportista(Long id_transportista) {
		String sDetalleIndice=" Parametros->";
		if(id_transportista!=null) {sDetalleIndice+=" Codigo Unico De Transportista="+id_transportista.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosOrdenCompra(OrdenCompra ordencompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ordencompra.setnumero_secuencial(ordencompra.getnumero_secuencial().trim());
		ordencompra.setdescripcion(ordencompra.getdescripcion().trim());
		ordencompra.setnumero_comprobante(ordencompra.getnumero_comprobante().trim());
	}
	
	public static void quitarEspaciosOrdenCompras(List<OrdenCompra> ordencompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(OrdenCompra ordencompra: ordencompras) {
			ordencompra.setnumero_secuencial(ordencompra.getnumero_secuencial().trim());
			ordencompra.setdescripcion(ordencompra.getdescripcion().trim());
			ordencompra.setnumero_comprobante(ordencompra.getnumero_comprobante().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresOrdenCompra(OrdenCompra ordencompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ordencompra.getConCambioAuxiliar()) {
			ordencompra.setIsDeleted(ordencompra.getIsDeletedAuxiliar());	
			ordencompra.setIsNew(ordencompra.getIsNewAuxiliar());	
			ordencompra.setIsChanged(ordencompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ordencompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ordencompra.setIsDeletedAuxiliar(false);	
			ordencompra.setIsNewAuxiliar(false);	
			ordencompra.setIsChangedAuxiliar(false);
			
			ordencompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresOrdenCompras(List<OrdenCompra> ordencompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(OrdenCompra ordencompra : ordencompras) {
			if(conAsignarBase && ordencompra.getConCambioAuxiliar()) {
				ordencompra.setIsDeleted(ordencompra.getIsDeletedAuxiliar());	
				ordencompra.setIsNew(ordencompra.getIsNewAuxiliar());	
				ordencompra.setIsChanged(ordencompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ordencompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ordencompra.setIsDeletedAuxiliar(false);	
				ordencompra.setIsNewAuxiliar(false);	
				ordencompra.setIsChangedAuxiliar(false);
				
				ordencompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresOrdenCompra(OrdenCompra ordencompra,Boolean conEnteros) throws Exception  {
		ordencompra.setporcentaje_descuento(0.0);
		ordencompra.setsuman(0.0);
		ordencompra.setice(0.0);
		ordencompra.setvalor_descuento(0.0);
		ordencompra.settotal_descuento(0.0);
		ordencompra.setiva(0.0);
		ordencompra.setstock(0.0);
		ordencompra.setsub_total(0.0);
		ordencompra.settotal_otro(0.0);
		ordencompra.setultimo_costo(0.0);
		ordencompra.setnumero_items(0.0);
		ordencompra.setretencion(0.0);
		ordencompra.settotal(0.0);
		ordencompra.setflete(0.0);
		ordencompra.setimpuesto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresOrdenCompras(List<OrdenCompra> ordencompras,Boolean conEnteros) throws Exception  {
		
		for(OrdenCompra ordencompra: ordencompras) {
			ordencompra.setporcentaje_descuento(0.0);
			ordencompra.setsuman(0.0);
			ordencompra.setice(0.0);
			ordencompra.setvalor_descuento(0.0);
			ordencompra.settotal_descuento(0.0);
			ordencompra.setiva(0.0);
			ordencompra.setstock(0.0);
			ordencompra.setsub_total(0.0);
			ordencompra.settotal_otro(0.0);
			ordencompra.setultimo_costo(0.0);
			ordencompra.setnumero_items(0.0);
			ordencompra.setretencion(0.0);
			ordencompra.settotal(0.0);
			ordencompra.setflete(0.0);
			ordencompra.setimpuesto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaOrdenCompra(List<OrdenCompra> ordencompras,OrdenCompra ordencompraAux) throws Exception  {
		OrdenCompraConstantesFunciones.InicializarValoresOrdenCompra(ordencompraAux,true);
		
		for(OrdenCompra ordencompra: ordencompras) {
			if(ordencompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ordencompraAux.setporcentaje_descuento(ordencompraAux.getporcentaje_descuento()+ordencompra.getporcentaje_descuento());			
			ordencompraAux.setsuman(ordencompraAux.getsuman()+ordencompra.getsuman());			
			ordencompraAux.setice(ordencompraAux.getice()+ordencompra.getice());			
			ordencompraAux.setvalor_descuento(ordencompraAux.getvalor_descuento()+ordencompra.getvalor_descuento());			
			ordencompraAux.settotal_descuento(ordencompraAux.gettotal_descuento()+ordencompra.gettotal_descuento());			
			ordencompraAux.setiva(ordencompraAux.getiva()+ordencompra.getiva());			
			ordencompraAux.setstock(ordencompraAux.getstock()+ordencompra.getstock());			
			ordencompraAux.setsub_total(ordencompraAux.getsub_total()+ordencompra.getsub_total());			
			ordencompraAux.settotal_otro(ordencompraAux.gettotal_otro()+ordencompra.gettotal_otro());			
			ordencompraAux.setultimo_costo(ordencompraAux.getultimo_costo()+ordencompra.getultimo_costo());			
			ordencompraAux.setnumero_items(ordencompraAux.getnumero_items()+ordencompra.getnumero_items());			
			ordencompraAux.setretencion(ordencompraAux.getretencion()+ordencompra.getretencion());			
			ordencompraAux.settotal(ordencompraAux.gettotal()+ordencompra.gettotal());			
			ordencompraAux.setflete(ordencompraAux.getflete()+ordencompra.getflete());			
			ordencompraAux.setimpuesto(ordencompraAux.getimpuesto()+ordencompra.getimpuesto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=OrdenCompraConstantesFunciones.getArrayColumnasGlobalesOrdenCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenCompraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenCompraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenCompraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenCompraConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenCompraConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenCompraConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenCompraConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenCompraConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenCompraConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenCompraConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenCompraConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenCompraConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(OrdenCompraConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(OrdenCompraConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoOrdenCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<OrdenCompra> ordencompras,OrdenCompra ordencompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(OrdenCompra ordencompraAux: ordencompras) {
			if(ordencompraAux!=null && ordencompra!=null) {
				if((ordencompraAux.getId()==null && ordencompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ordencompraAux.getId()!=null && ordencompra.getId()!=null){
					if(ordencompraAux.getId().equals(ordencompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaOrdenCompra(List<OrdenCompra> ordencompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentaje_descuentoTotal=0.0;
		Double sumanTotal=0.0;
		Double iceTotal=0.0;
		Double valor_descuentoTotal=0.0;
		Double total_descuentoTotal=0.0;
		Double ivaTotal=0.0;
		Double stockTotal=0.0;
		Double sub_totalTotal=0.0;
		Double total_otroTotal=0.0;
		Double ultimo_costoTotal=0.0;
		Double numero_itemsTotal=0.0;
		Double retencionTotal=0.0;
		Double totalTotal=0.0;
		Double fleteTotal=0.0;
		Double impuestoTotal=0.0;
	
		for(OrdenCompra ordencompra: ordencompras) {			
			if(ordencompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentaje_descuentoTotal+=ordencompra.getporcentaje_descuento();
			sumanTotal+=ordencompra.getsuman();
			iceTotal+=ordencompra.getice();
			valor_descuentoTotal+=ordencompra.getvalor_descuento();
			total_descuentoTotal+=ordencompra.gettotal_descuento();
			ivaTotal+=ordencompra.getiva();
			stockTotal+=ordencompra.getstock();
			sub_totalTotal+=ordencompra.getsub_total();
			total_otroTotal+=ordencompra.gettotal_otro();
			ultimo_costoTotal+=ordencompra.getultimo_costo();
			numero_itemsTotal+=ordencompra.getnumero_items();
			retencionTotal+=ordencompra.getretencion();
			totalTotal+=ordencompra.gettotal();
			fleteTotal+=ordencompra.getflete();
			impuestoTotal+=ordencompra.getimpuesto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.PORCENTAJEDESCUENTO);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		datoGeneral.setdValorDouble(porcentaje_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.SUMAN);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_SUMAN);
		datoGeneral.setdValorDouble(sumanTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.VALORDESCUENTO);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_VALORDESCUENTO);
		datoGeneral.setdValorDouble(valor_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.STOCK);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_STOCK);
		datoGeneral.setdValorDouble(stockTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.TOTALOTRO);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_TOTALOTRO);
		datoGeneral.setdValorDouble(total_otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.ULTIMOCOSTO);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_ULTIMOCOSTO);
		datoGeneral.setdValorDouble(ultimo_costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.NUMEROITEMS);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_NUMEROITEMS);
		datoGeneral.setdValorDouble(numero_itemsTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.RETENCION);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_RETENCION);
		datoGeneral.setdValorDouble(retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(OrdenCompraConstantesFunciones.IMPUESTO);
		datoGeneral.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IMPUESTO);
		datoGeneral.setdValorDouble(impuestoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaOrdenCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_ID, OrdenCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_VERSIONROW, OrdenCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDEMPRESA, OrdenCompraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDSUCURSAL, OrdenCompraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDMODULO, OrdenCompraConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDEJERCICIO, OrdenCompraConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDPERIODO, OrdenCompraConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDANIO, OrdenCompraConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDMES, OrdenCompraConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDUSUARIO, OrdenCompraConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_FECHAEMISION, OrdenCompraConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_FECHAENTREGA, OrdenCompraConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL, OrdenCompraConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDMONEDA, OrdenCompraConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDTIPOCAMBIO, OrdenCompraConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDESTADOORDENCOMPRA, OrdenCompraConstantesFunciones.IDESTADOORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDCLIENTE, OrdenCompraConstantesFunciones.IDCLIENTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDFORMATO, OrdenCompraConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDTRANSPORTISTA, OrdenCompraConstantesFunciones.IDTRANSPORTISTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDEMPLEADO, OrdenCompraConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_DESCRIPCION, OrdenCompraConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_PORCENTAJEDESCUENTO, OrdenCompraConstantesFunciones.PORCENTAJEDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_SUMAN, OrdenCompraConstantesFunciones.SUMAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_ICE, OrdenCompraConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_VALORDESCUENTO, OrdenCompraConstantesFunciones.VALORDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_TOTALDESCUENTO, OrdenCompraConstantesFunciones.TOTALDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IVA, OrdenCompraConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_STOCK, OrdenCompraConstantesFunciones.STOCK,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_SUBTOTAL, OrdenCompraConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_TOTALOTRO, OrdenCompraConstantesFunciones.TOTALOTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_ULTIMOCOSTO, OrdenCompraConstantesFunciones.ULTIMOCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_NUMEROITEMS, OrdenCompraConstantesFunciones.NUMEROITEMS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_RETENCION, OrdenCompraConstantesFunciones.RETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_TOTAL, OrdenCompraConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_FLETE, OrdenCompraConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IMPUESTO, OrdenCompraConstantesFunciones.IMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, OrdenCompraConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA, OrdenCompraConstantesFunciones.IDORDENCOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_IDASIENTOCONTABLE, OrdenCompraConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE, OrdenCompraConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,OrdenCompraConstantesFunciones.LABEL_FECHA, OrdenCompraConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasOrdenCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDESTADOORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDCLIENTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDTRANSPORTISTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.PORCENTAJEDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.SUMAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.VALORDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.TOTALDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.STOCK;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.TOTALOTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.ULTIMOCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.NUMEROITEMS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.RETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDORDENCOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=OrdenCompraConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarOrdenCompra() throws Exception  {
		return OrdenCompraConstantesFunciones.getTiposSeleccionarOrdenCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarOrdenCompra(Boolean conFk) throws Exception  {
		return OrdenCompraConstantesFunciones.getTiposSeleccionarOrdenCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarOrdenCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDESTADOORDENCOMPRA);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDESTADOORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDCLIENTE);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDCLIENTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDTRANSPORTISTA);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDTRANSPORTISTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_SUMAN);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_SUMAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_VALORDESCUENTO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_VALORDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_TOTALDESCUENTO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_TOTALDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_STOCK);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_STOCK);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_TOTALOTRO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_TOTALOTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_ULTIMOCOSTO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_ULTIMOCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_NUMEROITEMS);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_NUMEROITEMS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_RETENCION);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_RETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IMPUESTO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(OrdenCompraConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(OrdenCompraConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesOrdenCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesOrdenCompra(OrdenCompra ordencompraAux) throws Exception {
		
			ordencompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ordencompraAux.getEmpresa()));
			ordencompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ordencompraAux.getSucursal()));
			ordencompraAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(ordencompraAux.getModulo()));
			ordencompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(ordencompraAux.getEjercicio()));
			ordencompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(ordencompraAux.getPeriodo()));
			ordencompraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(ordencompraAux.getAnio()));
			ordencompraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(ordencompraAux.getMes()));
			ordencompraAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(ordencompraAux.getUsuario()));
			ordencompraAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(ordencompraAux.getMoneda()));
			ordencompraAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(ordencompraAux.getTipoCambio()));
			ordencompraAux.setestadoordencompra_descripcion(EstadoOrdenCompraConstantesFunciones.getEstadoOrdenCompraDescripcion(ordencompraAux.getEstadoOrdenCompra()));
			ordencompraAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(ordencompraAux.getCliente()));
			ordencompraAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(ordencompraAux.getFormato()));
			ordencompraAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(ordencompraAux.getTransportista()));
			ordencompraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(ordencompraAux.getEmpleado()));
			ordencompraAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(ordencompraAux.getTipoTransaccionModulo()));
			ordencompraAux.setordencompra_descripcion(OrdenCompraConstantesFunciones.getOrdenCompraDescripcion(ordencompraAux.getOrdenCompra()));
			ordencompraAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(ordencompraAux.getAsientoContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesOrdenCompra(List<OrdenCompra> ordencomprasTemp) throws Exception {
		for(OrdenCompra ordencompraAux:ordencomprasTemp) {
			
			ordencompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ordencompraAux.getEmpresa()));
			ordencompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ordencompraAux.getSucursal()));
			ordencompraAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(ordencompraAux.getModulo()));
			ordencompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(ordencompraAux.getEjercicio()));
			ordencompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(ordencompraAux.getPeriodo()));
			ordencompraAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(ordencompraAux.getAnio()));
			ordencompraAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(ordencompraAux.getMes()));
			ordencompraAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(ordencompraAux.getUsuario()));
			ordencompraAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(ordencompraAux.getMoneda()));
			ordencompraAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(ordencompraAux.getTipoCambio()));
			ordencompraAux.setestadoordencompra_descripcion(EstadoOrdenCompraConstantesFunciones.getEstadoOrdenCompraDescripcion(ordencompraAux.getEstadoOrdenCompra()));
			ordencompraAux.setcliente_descripcion(ClienteConstantesFunciones.getClienteDescripcion(ordencompraAux.getCliente()));
			ordencompraAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(ordencompraAux.getFormato()));
			ordencompraAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(ordencompraAux.getTransportista()));
			ordencompraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(ordencompraAux.getEmpleado()));
			ordencompraAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(ordencompraAux.getTipoTransaccionModulo()));
			ordencompraAux.setordencompra_descripcion(OrdenCompraConstantesFunciones.getOrdenCompraDescripcion(ordencompraAux.getOrdenCompra()));
			ordencompraAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(ordencompraAux.getAsientoContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Modulo.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Moneda.class));
				classes.add(new Classe(TipoCambio.class));
				classes.add(new Classe(EstadoOrdenCompra.class));
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Transportista.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				classes.add(new Classe(OrdenCompra.class));
				classes.add(new Classe(AsientoContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
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
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
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
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Moneda.class)) {
						classes.add(new Classe(Moneda.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoOrdenCompra.class)) {
						classes.add(new Classe(EstadoOrdenCompra.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transportista.class)) {
						classes.add(new Classe(Transportista.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenCompra.class)) {
						classes.add(new Classe(OrdenCompra.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(EstadoOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoOrdenCompra.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Moneda.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Moneda.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(EstadoOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoOrdenCompra.class)); continue;
					}

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Transportista.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transportista.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
					}

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return OrdenCompraConstantesFunciones.getClassesRelationshipsOfOrdenCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfOrdenCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleProve.class));
				classes.add(new Classe(OrdenCompra.class));
				classes.add(new Classe(AutoriPagoOrdenCompra.class));
				classes.add(new Classe(Compra.class));
				classes.add(new Classe(DetalleOrdenCompra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleProve.class)) {
						classes.add(new Classe(DetalleProve.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(OrdenCompra.class)) {
						classes.add(new Classe(OrdenCompra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AutoriPagoOrdenCompra.class)) {
						classes.add(new Classe(AutoriPagoOrdenCompra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Compra.class)) {
						classes.add(new Classe(Compra.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleOrdenCompra.class)) {
						classes.add(new Classe(DetalleOrdenCompra.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return OrdenCompraConstantesFunciones.getClassesRelationshipsFromStringsOfOrdenCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfOrdenCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleProve.class)); continue;
					}

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
					}

					if(AutoriPagoOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPagoOrdenCompra.class)); continue;
					}

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}

					if(DetalleOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleOrdenCompra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleProve.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleProve.class)); continue;
					}

					if(OrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(OrdenCompra.class)); continue;
					}

					if(AutoriPagoOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AutoriPagoOrdenCompra.class)); continue;
					}

					if(Compra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Compra.class)); continue;
					}

					if(DetalleOrdenCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleOrdenCompra.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(OrdenCompra ordencompra,List<OrdenCompra> ordencompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			OrdenCompra ordencompraEncontrado=null;
			
			for(OrdenCompra ordencompraLocal:ordencompras) {
				if(ordencompraLocal.getId().equals(ordencompra.getId())) {
					ordencompraEncontrado=ordencompraLocal;
					
					ordencompraLocal.setIsChanged(ordencompra.getIsChanged());
					ordencompraLocal.setIsNew(ordencompra.getIsNew());
					ordencompraLocal.setIsDeleted(ordencompra.getIsDeleted());
					
					ordencompraLocal.setGeneralEntityOriginal(ordencompra.getGeneralEntityOriginal());
					
					ordencompraLocal.setId(ordencompra.getId());	
					ordencompraLocal.setVersionRow(ordencompra.getVersionRow());	
					ordencompraLocal.setid_empresa(ordencompra.getid_empresa());	
					ordencompraLocal.setid_sucursal(ordencompra.getid_sucursal());	
					ordencompraLocal.setid_modulo(ordencompra.getid_modulo());	
					ordencompraLocal.setid_ejercicio(ordencompra.getid_ejercicio());	
					ordencompraLocal.setid_periodo(ordencompra.getid_periodo());	
					ordencompraLocal.setid_anio(ordencompra.getid_anio());	
					ordencompraLocal.setid_mes(ordencompra.getid_mes());	
					ordencompraLocal.setid_usuario(ordencompra.getid_usuario());	
					ordencompraLocal.setfecha_emision(ordencompra.getfecha_emision());	
					ordencompraLocal.setfecha_entrega(ordencompra.getfecha_entrega());	
					ordencompraLocal.setnumero_secuencial(ordencompra.getnumero_secuencial());	
					ordencompraLocal.setid_moneda(ordencompra.getid_moneda());	
					ordencompraLocal.setid_tipo_cambio(ordencompra.getid_tipo_cambio());	
					ordencompraLocal.setid_estado_orden_compra(ordencompra.getid_estado_orden_compra());	
					ordencompraLocal.setid_cliente(ordencompra.getid_cliente());	
					ordencompraLocal.setid_formato(ordencompra.getid_formato());	
					ordencompraLocal.setid_transportista(ordencompra.getid_transportista());	
					ordencompraLocal.setid_empleado(ordencompra.getid_empleado());	
					ordencompraLocal.setdescripcion(ordencompra.getdescripcion());	
					ordencompraLocal.setporcentaje_descuento(ordencompra.getporcentaje_descuento());	
					ordencompraLocal.setsuman(ordencompra.getsuman());	
					ordencompraLocal.setice(ordencompra.getice());	
					ordencompraLocal.setvalor_descuento(ordencompra.getvalor_descuento());	
					ordencompraLocal.settotal_descuento(ordencompra.gettotal_descuento());	
					ordencompraLocal.setiva(ordencompra.getiva());	
					ordencompraLocal.setstock(ordencompra.getstock());	
					ordencompraLocal.setsub_total(ordencompra.getsub_total());	
					ordencompraLocal.settotal_otro(ordencompra.gettotal_otro());	
					ordencompraLocal.setultimo_costo(ordencompra.getultimo_costo());	
					ordencompraLocal.setnumero_items(ordencompra.getnumero_items());	
					ordencompraLocal.setretencion(ordencompra.getretencion());	
					ordencompraLocal.settotal(ordencompra.gettotal());	
					ordencompraLocal.setflete(ordencompra.getflete());	
					ordencompraLocal.setimpuesto(ordencompra.getimpuesto());	
					ordencompraLocal.setid_tipo_transaccion_modulo(ordencompra.getid_tipo_transaccion_modulo());	
					ordencompraLocal.setid_orden_compra(ordencompra.getid_orden_compra());	
					ordencompraLocal.setid_asiento_contable(ordencompra.getid_asiento_contable());	
					ordencompraLocal.setnumero_comprobante(ordencompra.getnumero_comprobante());	
					ordencompraLocal.setfecha(ordencompra.getfecha());	
					
					
					ordencompraLocal.setDetalleOrdenCompras(ordencompra.getDetalleOrdenCompras());
					
					existe=true;
					break;
				}
			}
			
			if(!ordencompra.getIsDeleted()) {
				if(!existe) {
					ordencompras.add(ordencompra);
				}
			} else {
				if(ordencompraEncontrado!=null && permiteQuitar)  {
					ordencompras.remove(ordencompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(OrdenCompra ordencompra,List<OrdenCompra> ordencompras) throws Exception {
		try	{			
			for(OrdenCompra ordencompraLocal:ordencompras) {
				if(ordencompraLocal.getId().equals(ordencompra.getId())) {
					ordencompraLocal.setIsSelected(ordencompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesOrdenCompra(List<OrdenCompra> ordencomprasAux) throws Exception {
		//this.ordencomprasAux=ordencomprasAux;
		
		for(OrdenCompra ordencompraAux:ordencomprasAux) {
			if(ordencompraAux.getIsChanged()) {
				ordencompraAux.setIsChanged(false);
			}		
			
			if(ordencompraAux.getIsNew()) {
				ordencompraAux.setIsNew(false);
			}	
			
			if(ordencompraAux.getIsDeleted()) {
				ordencompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesOrdenCompra(OrdenCompra ordencompraAux) throws Exception {
		//this.ordencompraAux=ordencompraAux;
		
			if(ordencompraAux.getIsChanged()) {
				ordencompraAux.setIsChanged(false);
			}		
			
			if(ordencompraAux.getIsNew()) {
				ordencompraAux.setIsNew(false);
			}	
			
			if(ordencompraAux.getIsDeleted()) {
				ordencompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(OrdenCompra ordencompraAsignar,OrdenCompra ordencompra) throws Exception {
		ordencompraAsignar.setId(ordencompra.getId());	
		ordencompraAsignar.setVersionRow(ordencompra.getVersionRow());	
		ordencompraAsignar.setid_empresa(ordencompra.getid_empresa());
		ordencompraAsignar.setempresa_descripcion(ordencompra.getempresa_descripcion());	
		ordencompraAsignar.setid_sucursal(ordencompra.getid_sucursal());
		ordencompraAsignar.setsucursal_descripcion(ordencompra.getsucursal_descripcion());	
		ordencompraAsignar.setid_modulo(ordencompra.getid_modulo());
		ordencompraAsignar.setmodulo_descripcion(ordencompra.getmodulo_descripcion());	
		ordencompraAsignar.setid_ejercicio(ordencompra.getid_ejercicio());
		ordencompraAsignar.setejercicio_descripcion(ordencompra.getejercicio_descripcion());	
		ordencompraAsignar.setid_periodo(ordencompra.getid_periodo());
		ordencompraAsignar.setperiodo_descripcion(ordencompra.getperiodo_descripcion());	
		ordencompraAsignar.setid_anio(ordencompra.getid_anio());
		ordencompraAsignar.setanio_descripcion(ordencompra.getanio_descripcion());	
		ordencompraAsignar.setid_mes(ordencompra.getid_mes());
		ordencompraAsignar.setmes_descripcion(ordencompra.getmes_descripcion());	
		ordencompraAsignar.setid_usuario(ordencompra.getid_usuario());
		ordencompraAsignar.setusuario_descripcion(ordencompra.getusuario_descripcion());	
		ordencompraAsignar.setfecha_emision(ordencompra.getfecha_emision());	
		ordencompraAsignar.setfecha_entrega(ordencompra.getfecha_entrega());	
		ordencompraAsignar.setnumero_secuencial(ordencompra.getnumero_secuencial());	
		ordencompraAsignar.setid_moneda(ordencompra.getid_moneda());
		ordencompraAsignar.setmoneda_descripcion(ordencompra.getmoneda_descripcion());	
		ordencompraAsignar.setid_tipo_cambio(ordencompra.getid_tipo_cambio());
		ordencompraAsignar.settipocambio_descripcion(ordencompra.gettipocambio_descripcion());	
		ordencompraAsignar.setid_estado_orden_compra(ordencompra.getid_estado_orden_compra());
		ordencompraAsignar.setestadoordencompra_descripcion(ordencompra.getestadoordencompra_descripcion());	
		ordencompraAsignar.setid_cliente(ordencompra.getid_cliente());
		ordencompraAsignar.setcliente_descripcion(ordencompra.getcliente_descripcion());	
		ordencompraAsignar.setid_formato(ordencompra.getid_formato());
		ordencompraAsignar.setformato_descripcion(ordencompra.getformato_descripcion());	
		ordencompraAsignar.setid_transportista(ordencompra.getid_transportista());
		ordencompraAsignar.settransportista_descripcion(ordencompra.gettransportista_descripcion());	
		ordencompraAsignar.setid_empleado(ordencompra.getid_empleado());
		ordencompraAsignar.setempleado_descripcion(ordencompra.getempleado_descripcion());	
		ordencompraAsignar.setdescripcion(ordencompra.getdescripcion());	
		ordencompraAsignar.setporcentaje_descuento(ordencompra.getporcentaje_descuento());	
		ordencompraAsignar.setsuman(ordencompra.getsuman());	
		ordencompraAsignar.setice(ordencompra.getice());	
		ordencompraAsignar.setvalor_descuento(ordencompra.getvalor_descuento());	
		ordencompraAsignar.settotal_descuento(ordencompra.gettotal_descuento());	
		ordencompraAsignar.setiva(ordencompra.getiva());	
		ordencompraAsignar.setstock(ordencompra.getstock());	
		ordencompraAsignar.setsub_total(ordencompra.getsub_total());	
		ordencompraAsignar.settotal_otro(ordencompra.gettotal_otro());	
		ordencompraAsignar.setultimo_costo(ordencompra.getultimo_costo());	
		ordencompraAsignar.setnumero_items(ordencompra.getnumero_items());	
		ordencompraAsignar.setretencion(ordencompra.getretencion());	
		ordencompraAsignar.settotal(ordencompra.gettotal());	
		ordencompraAsignar.setflete(ordencompra.getflete());	
		ordencompraAsignar.setimpuesto(ordencompra.getimpuesto());	
		ordencompraAsignar.setid_tipo_transaccion_modulo(ordencompra.getid_tipo_transaccion_modulo());
		ordencompraAsignar.settipotransaccionmodulo_descripcion(ordencompra.gettipotransaccionmodulo_descripcion());	
		ordencompraAsignar.setid_orden_compra(ordencompra.getid_orden_compra());
		ordencompraAsignar.setordencompra_descripcion(ordencompra.getordencompra_descripcion());	
		ordencompraAsignar.setid_asiento_contable(ordencompra.getid_asiento_contable());
		ordencompraAsignar.setasientocontable_descripcion(ordencompra.getasientocontable_descripcion());	
		ordencompraAsignar.setnumero_comprobante(ordencompra.getnumero_comprobante());	
		ordencompraAsignar.setfecha(ordencompra.getfecha());	
	}
	
	public static void inicializarOrdenCompra(OrdenCompra ordencompra) throws Exception {
		try {
				ordencompra.setId(0L);	
					
				ordencompra.setid_empresa(-1L);	
				ordencompra.setid_sucursal(-1L);	
				ordencompra.setid_modulo(-1L);	
				ordencompra.setid_ejercicio(-1L);	
				ordencompra.setid_periodo(-1L);	
				ordencompra.setid_anio(null);	
				ordencompra.setid_mes(null);	
				ordencompra.setid_usuario(-1L);	
				ordencompra.setfecha_emision(new Date());	
				ordencompra.setfecha_entrega(new Date());	
				ordencompra.setnumero_secuencial("");	
				ordencompra.setid_moneda(-1L);	
				ordencompra.setid_tipo_cambio(null);	
				ordencompra.setid_estado_orden_compra(-1L);	
				ordencompra.setid_cliente(-1L);	
				ordencompra.setid_formato(-1L);	
				ordencompra.setid_transportista(null);	
				ordencompra.setid_empleado(-1L);	
				ordencompra.setdescripcion("");	
				ordencompra.setporcentaje_descuento(0.0);	
				ordencompra.setsuman(0.0);	
				ordencompra.setice(0.0);	
				ordencompra.setvalor_descuento(0.0);	
				ordencompra.settotal_descuento(0.0);	
				ordencompra.setiva(0.0);	
				ordencompra.setstock(0.0);	
				ordencompra.setsub_total(0.0);	
				ordencompra.settotal_otro(0.0);	
				ordencompra.setultimo_costo(0.0);	
				ordencompra.setnumero_items(0.0);	
				ordencompra.setretencion(0.0);	
				ordencompra.settotal(0.0);	
				ordencompra.setflete(0.0);	
				ordencompra.setimpuesto(0.0);	
				ordencompra.setid_tipo_transaccion_modulo(null);	
				ordencompra.setid_orden_compra(null);	
				ordencompra.setid_asiento_contable(null);	
				ordencompra.setnumero_comprobante("");	
				ordencompra.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderOrdenCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDESTADOORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDCLIENTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDTRANSPORTISTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_SUMAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_VALORDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_TOTALDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_STOCK);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_TOTALOTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_ULTIMOCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_NUMEROITEMS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_RETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDORDENCOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(OrdenCompraConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataOrdenCompra(String sTipo,Row row,Workbook workbook,OrdenCompra ordencompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getestadoordencompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getcliente_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.gettransportista_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getporcentaje_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getsuman());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getvalor_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.gettotal_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getstock());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.gettotal_otro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getultimo_costo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getnumero_items());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getretencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getimpuesto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getordencompra_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ordencompra.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryOrdenCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryOrdenCompra() {
		return this.sFinalQueryOrdenCompra;
	}
	
	public void setsFinalQueryOrdenCompra(String sFinalQueryOrdenCompra) {
		this.sFinalQueryOrdenCompra= sFinalQueryOrdenCompra;
	}
	
	public Border resaltarSeleccionarOrdenCompra=null;
	
	public Border setResaltarSeleccionarOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarOrdenCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarOrdenCompra() {
		return this.resaltarSeleccionarOrdenCompra;
	}
	
	public void setResaltarSeleccionarOrdenCompra(Border borderResaltarSeleccionarOrdenCompra) {
		this.resaltarSeleccionarOrdenCompra= borderResaltarSeleccionarOrdenCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridOrdenCompra=null;
	public Boolean mostraridOrdenCompra=true;
	public Boolean activaridOrdenCompra=true;

	public Border resaltarid_empresaOrdenCompra=null;
	public Boolean mostrarid_empresaOrdenCompra=true;
	public Boolean activarid_empresaOrdenCompra=true;
	public Boolean cargarid_empresaOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_sucursalOrdenCompra=null;
	public Boolean mostrarid_sucursalOrdenCompra=true;
	public Boolean activarid_sucursalOrdenCompra=true;
	public Boolean cargarid_sucursalOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_moduloOrdenCompra=null;
	public Boolean mostrarid_moduloOrdenCompra=true;
	public Boolean activarid_moduloOrdenCompra=true;
	public Boolean cargarid_moduloOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_ejercicioOrdenCompra=null;
	public Boolean mostrarid_ejercicioOrdenCompra=true;
	public Boolean activarid_ejercicioOrdenCompra=true;
	public Boolean cargarid_ejercicioOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_periodoOrdenCompra=null;
	public Boolean mostrarid_periodoOrdenCompra=true;
	public Boolean activarid_periodoOrdenCompra=true;
	public Boolean cargarid_periodoOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_anioOrdenCompra=null;
	public Boolean mostrarid_anioOrdenCompra=true;
	public Boolean activarid_anioOrdenCompra=false;
	public Boolean cargarid_anioOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_mesOrdenCompra=null;
	public Boolean mostrarid_mesOrdenCompra=true;
	public Boolean activarid_mesOrdenCompra=false;
	public Boolean cargarid_mesOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_usuarioOrdenCompra=null;
	public Boolean mostrarid_usuarioOrdenCompra=true;
	public Boolean activarid_usuarioOrdenCompra=true;
	public Boolean cargarid_usuarioOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioOrdenCompra=false;//ConEventDepend=true

	public Border resaltarfecha_emisionOrdenCompra=null;
	public Boolean mostrarfecha_emisionOrdenCompra=true;
	public Boolean activarfecha_emisionOrdenCompra=true;

	public Border resaltarfecha_entregaOrdenCompra=null;
	public Boolean mostrarfecha_entregaOrdenCompra=true;
	public Boolean activarfecha_entregaOrdenCompra=true;

	public Border resaltarnumero_secuencialOrdenCompra=null;
	public Boolean mostrarnumero_secuencialOrdenCompra=true;
	public Boolean activarnumero_secuencialOrdenCompra=false;

	public Border resaltarid_monedaOrdenCompra=null;
	public Boolean mostrarid_monedaOrdenCompra=true;
	public Boolean activarid_monedaOrdenCompra=true;
	public Boolean cargarid_monedaOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_tipo_cambioOrdenCompra=null;
	public Boolean mostrarid_tipo_cambioOrdenCompra=true;
	public Boolean activarid_tipo_cambioOrdenCompra=true;
	public Boolean cargarid_tipo_cambioOrdenCompra=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_estado_orden_compraOrdenCompra=null;
	public Boolean mostrarid_estado_orden_compraOrdenCompra=true;
	public Boolean activarid_estado_orden_compraOrdenCompra=false;
	public Boolean cargarid_estado_orden_compraOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_orden_compraOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_clienteOrdenCompra=null;
	public Boolean mostrarid_clienteOrdenCompra=true;
	public Boolean activarid_clienteOrdenCompra=true;
	public Boolean cargarid_clienteOrdenCompra=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_clienteOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_formatoOrdenCompra=null;
	public Boolean mostrarid_formatoOrdenCompra=true;
	public Boolean activarid_formatoOrdenCompra=true;
	public Boolean cargarid_formatoOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_transportistaOrdenCompra=null;
	public Boolean mostrarid_transportistaOrdenCompra=true;
	public Boolean activarid_transportistaOrdenCompra=true;
	public Boolean cargarid_transportistaOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportistaOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_empleadoOrdenCompra=null;
	public Boolean mostrarid_empleadoOrdenCompra=true;
	public Boolean activarid_empleadoOrdenCompra=true;
	public Boolean cargarid_empleadoOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoOrdenCompra=false;//ConEventDepend=true

	public Border resaltardescripcionOrdenCompra=null;
	public Boolean mostrardescripcionOrdenCompra=true;
	public Boolean activardescripcionOrdenCompra=true;

	public Border resaltarporcentaje_descuentoOrdenCompra=null;
	public Boolean mostrarporcentaje_descuentoOrdenCompra=true;
	public Boolean activarporcentaje_descuentoOrdenCompra=true;

	public Border resaltarsumanOrdenCompra=null;
	public Boolean mostrarsumanOrdenCompra=true;
	public Boolean activarsumanOrdenCompra=true;

	public Border resaltariceOrdenCompra=null;
	public Boolean mostrariceOrdenCompra=true;
	public Boolean activariceOrdenCompra=true;

	public Border resaltarvalor_descuentoOrdenCompra=null;
	public Boolean mostrarvalor_descuentoOrdenCompra=true;
	public Boolean activarvalor_descuentoOrdenCompra=true;

	public Border resaltartotal_descuentoOrdenCompra=null;
	public Boolean mostrartotal_descuentoOrdenCompra=true;
	public Boolean activartotal_descuentoOrdenCompra=true;

	public Border resaltarivaOrdenCompra=null;
	public Boolean mostrarivaOrdenCompra=true;
	public Boolean activarivaOrdenCompra=true;

	public Border resaltarstockOrdenCompra=null;
	public Boolean mostrarstockOrdenCompra=true;
	public Boolean activarstockOrdenCompra=true;

	public Border resaltarsub_totalOrdenCompra=null;
	public Boolean mostrarsub_totalOrdenCompra=true;
	public Boolean activarsub_totalOrdenCompra=true;

	public Border resaltartotal_otroOrdenCompra=null;
	public Boolean mostrartotal_otroOrdenCompra=true;
	public Boolean activartotal_otroOrdenCompra=true;

	public Border resaltarultimo_costoOrdenCompra=null;
	public Boolean mostrarultimo_costoOrdenCompra=true;
	public Boolean activarultimo_costoOrdenCompra=true;

	public Border resaltarnumero_itemsOrdenCompra=null;
	public Boolean mostrarnumero_itemsOrdenCompra=true;
	public Boolean activarnumero_itemsOrdenCompra=true;

	public Border resaltarretencionOrdenCompra=null;
	public Boolean mostrarretencionOrdenCompra=true;
	public Boolean activarretencionOrdenCompra=true;

	public Border resaltartotalOrdenCompra=null;
	public Boolean mostrartotalOrdenCompra=true;
	public Boolean activartotalOrdenCompra=true;

	public Border resaltarfleteOrdenCompra=null;
	public Boolean mostrarfleteOrdenCompra=true;
	public Boolean activarfleteOrdenCompra=false;

	public Border resaltarimpuestoOrdenCompra=null;
	public Boolean mostrarimpuestoOrdenCompra=true;
	public Boolean activarimpuestoOrdenCompra=false;

	public Border resaltarid_tipo_transaccion_moduloOrdenCompra=null;
	public Boolean mostrarid_tipo_transaccion_moduloOrdenCompra=true;
	public Boolean activarid_tipo_transaccion_moduloOrdenCompra=false;
	public Boolean cargarid_tipo_transaccion_moduloOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_orden_compraOrdenCompra=null;
	public Boolean mostrarid_orden_compraOrdenCompra=true;
	public Boolean activarid_orden_compraOrdenCompra=false;
	public Boolean cargarid_orden_compraOrdenCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_orden_compraOrdenCompra=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableOrdenCompra=null;
	public Boolean mostrarid_asiento_contableOrdenCompra=true;
	public Boolean activarid_asiento_contableOrdenCompra=false;
	public Boolean cargarid_asiento_contableOrdenCompra=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableOrdenCompra=false;//ConEventDepend=true

	public Border resaltarnumero_comprobanteOrdenCompra=null;
	public Boolean mostrarnumero_comprobanteOrdenCompra=true;
	public Boolean activarnumero_comprobanteOrdenCompra=false;

	public Border resaltarfechaOrdenCompra=null;
	public Boolean mostrarfechaOrdenCompra=true;
	public Boolean activarfechaOrdenCompra=false;

	
	

	public Border setResaltaridOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltaridOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridOrdenCompra() {
		return this.resaltaridOrdenCompra;
	}

	public void setResaltaridOrdenCompra(Border borderResaltar) {
		this.resaltaridOrdenCompra= borderResaltar;
	}

	public Boolean getMostraridOrdenCompra() {
		return this.mostraridOrdenCompra;
	}

	public void setMostraridOrdenCompra(Boolean mostraridOrdenCompra) {
		this.mostraridOrdenCompra= mostraridOrdenCompra;
	}

	public Boolean getActivaridOrdenCompra() {
		return this.activaridOrdenCompra;
	}

	public void setActivaridOrdenCompra(Boolean activaridOrdenCompra) {
		this.activaridOrdenCompra= activaridOrdenCompra;
	}

	public Border setResaltarid_empresaOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_empresaOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaOrdenCompra() {
		return this.resaltarid_empresaOrdenCompra;
	}

	public void setResaltarid_empresaOrdenCompra(Border borderResaltar) {
		this.resaltarid_empresaOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_empresaOrdenCompra() {
		return this.mostrarid_empresaOrdenCompra;
	}

	public void setMostrarid_empresaOrdenCompra(Boolean mostrarid_empresaOrdenCompra) {
		this.mostrarid_empresaOrdenCompra= mostrarid_empresaOrdenCompra;
	}

	public Boolean getActivarid_empresaOrdenCompra() {
		return this.activarid_empresaOrdenCompra;
	}

	public void setActivarid_empresaOrdenCompra(Boolean activarid_empresaOrdenCompra) {
		this.activarid_empresaOrdenCompra= activarid_empresaOrdenCompra;
	}

	public Boolean getCargarid_empresaOrdenCompra() {
		return this.cargarid_empresaOrdenCompra;
	}

	public void setCargarid_empresaOrdenCompra(Boolean cargarid_empresaOrdenCompra) {
		this.cargarid_empresaOrdenCompra= cargarid_empresaOrdenCompra;
	}

	public Border setResaltarid_sucursalOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_sucursalOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalOrdenCompra() {
		return this.resaltarid_sucursalOrdenCompra;
	}

	public void setResaltarid_sucursalOrdenCompra(Border borderResaltar) {
		this.resaltarid_sucursalOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_sucursalOrdenCompra() {
		return this.mostrarid_sucursalOrdenCompra;
	}

	public void setMostrarid_sucursalOrdenCompra(Boolean mostrarid_sucursalOrdenCompra) {
		this.mostrarid_sucursalOrdenCompra= mostrarid_sucursalOrdenCompra;
	}

	public Boolean getActivarid_sucursalOrdenCompra() {
		return this.activarid_sucursalOrdenCompra;
	}

	public void setActivarid_sucursalOrdenCompra(Boolean activarid_sucursalOrdenCompra) {
		this.activarid_sucursalOrdenCompra= activarid_sucursalOrdenCompra;
	}

	public Boolean getCargarid_sucursalOrdenCompra() {
		return this.cargarid_sucursalOrdenCompra;
	}

	public void setCargarid_sucursalOrdenCompra(Boolean cargarid_sucursalOrdenCompra) {
		this.cargarid_sucursalOrdenCompra= cargarid_sucursalOrdenCompra;
	}

	public Border setResaltarid_moduloOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_moduloOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloOrdenCompra() {
		return this.resaltarid_moduloOrdenCompra;
	}

	public void setResaltarid_moduloOrdenCompra(Border borderResaltar) {
		this.resaltarid_moduloOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_moduloOrdenCompra() {
		return this.mostrarid_moduloOrdenCompra;
	}

	public void setMostrarid_moduloOrdenCompra(Boolean mostrarid_moduloOrdenCompra) {
		this.mostrarid_moduloOrdenCompra= mostrarid_moduloOrdenCompra;
	}

	public Boolean getActivarid_moduloOrdenCompra() {
		return this.activarid_moduloOrdenCompra;
	}

	public void setActivarid_moduloOrdenCompra(Boolean activarid_moduloOrdenCompra) {
		this.activarid_moduloOrdenCompra= activarid_moduloOrdenCompra;
	}

	public Boolean getCargarid_moduloOrdenCompra() {
		return this.cargarid_moduloOrdenCompra;
	}

	public void setCargarid_moduloOrdenCompra(Boolean cargarid_moduloOrdenCompra) {
		this.cargarid_moduloOrdenCompra= cargarid_moduloOrdenCompra;
	}

	public Border setResaltarid_ejercicioOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioOrdenCompra() {
		return this.resaltarid_ejercicioOrdenCompra;
	}

	public void setResaltarid_ejercicioOrdenCompra(Border borderResaltar) {
		this.resaltarid_ejercicioOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioOrdenCompra() {
		return this.mostrarid_ejercicioOrdenCompra;
	}

	public void setMostrarid_ejercicioOrdenCompra(Boolean mostrarid_ejercicioOrdenCompra) {
		this.mostrarid_ejercicioOrdenCompra= mostrarid_ejercicioOrdenCompra;
	}

	public Boolean getActivarid_ejercicioOrdenCompra() {
		return this.activarid_ejercicioOrdenCompra;
	}

	public void setActivarid_ejercicioOrdenCompra(Boolean activarid_ejercicioOrdenCompra) {
		this.activarid_ejercicioOrdenCompra= activarid_ejercicioOrdenCompra;
	}

	public Boolean getCargarid_ejercicioOrdenCompra() {
		return this.cargarid_ejercicioOrdenCompra;
	}

	public void setCargarid_ejercicioOrdenCompra(Boolean cargarid_ejercicioOrdenCompra) {
		this.cargarid_ejercicioOrdenCompra= cargarid_ejercicioOrdenCompra;
	}

	public Border setResaltarid_periodoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_periodoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoOrdenCompra() {
		return this.resaltarid_periodoOrdenCompra;
	}

	public void setResaltarid_periodoOrdenCompra(Border borderResaltar) {
		this.resaltarid_periodoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_periodoOrdenCompra() {
		return this.mostrarid_periodoOrdenCompra;
	}

	public void setMostrarid_periodoOrdenCompra(Boolean mostrarid_periodoOrdenCompra) {
		this.mostrarid_periodoOrdenCompra= mostrarid_periodoOrdenCompra;
	}

	public Boolean getActivarid_periodoOrdenCompra() {
		return this.activarid_periodoOrdenCompra;
	}

	public void setActivarid_periodoOrdenCompra(Boolean activarid_periodoOrdenCompra) {
		this.activarid_periodoOrdenCompra= activarid_periodoOrdenCompra;
	}

	public Boolean getCargarid_periodoOrdenCompra() {
		return this.cargarid_periodoOrdenCompra;
	}

	public void setCargarid_periodoOrdenCompra(Boolean cargarid_periodoOrdenCompra) {
		this.cargarid_periodoOrdenCompra= cargarid_periodoOrdenCompra;
	}

	public Border setResaltarid_anioOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_anioOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioOrdenCompra() {
		return this.resaltarid_anioOrdenCompra;
	}

	public void setResaltarid_anioOrdenCompra(Border borderResaltar) {
		this.resaltarid_anioOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_anioOrdenCompra() {
		return this.mostrarid_anioOrdenCompra;
	}

	public void setMostrarid_anioOrdenCompra(Boolean mostrarid_anioOrdenCompra) {
		this.mostrarid_anioOrdenCompra= mostrarid_anioOrdenCompra;
	}

	public Boolean getActivarid_anioOrdenCompra() {
		return this.activarid_anioOrdenCompra;
	}

	public void setActivarid_anioOrdenCompra(Boolean activarid_anioOrdenCompra) {
		this.activarid_anioOrdenCompra= activarid_anioOrdenCompra;
	}

	public Boolean getCargarid_anioOrdenCompra() {
		return this.cargarid_anioOrdenCompra;
	}

	public void setCargarid_anioOrdenCompra(Boolean cargarid_anioOrdenCompra) {
		this.cargarid_anioOrdenCompra= cargarid_anioOrdenCompra;
	}

	public Border setResaltarid_mesOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_mesOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesOrdenCompra() {
		return this.resaltarid_mesOrdenCompra;
	}

	public void setResaltarid_mesOrdenCompra(Border borderResaltar) {
		this.resaltarid_mesOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_mesOrdenCompra() {
		return this.mostrarid_mesOrdenCompra;
	}

	public void setMostrarid_mesOrdenCompra(Boolean mostrarid_mesOrdenCompra) {
		this.mostrarid_mesOrdenCompra= mostrarid_mesOrdenCompra;
	}

	public Boolean getActivarid_mesOrdenCompra() {
		return this.activarid_mesOrdenCompra;
	}

	public void setActivarid_mesOrdenCompra(Boolean activarid_mesOrdenCompra) {
		this.activarid_mesOrdenCompra= activarid_mesOrdenCompra;
	}

	public Boolean getCargarid_mesOrdenCompra() {
		return this.cargarid_mesOrdenCompra;
	}

	public void setCargarid_mesOrdenCompra(Boolean cargarid_mesOrdenCompra) {
		this.cargarid_mesOrdenCompra= cargarid_mesOrdenCompra;
	}

	public Border setResaltarid_usuarioOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_usuarioOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioOrdenCompra() {
		return this.resaltarid_usuarioOrdenCompra;
	}

	public void setResaltarid_usuarioOrdenCompra(Border borderResaltar) {
		this.resaltarid_usuarioOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_usuarioOrdenCompra() {
		return this.mostrarid_usuarioOrdenCompra;
	}

	public void setMostrarid_usuarioOrdenCompra(Boolean mostrarid_usuarioOrdenCompra) {
		this.mostrarid_usuarioOrdenCompra= mostrarid_usuarioOrdenCompra;
	}

	public Boolean getActivarid_usuarioOrdenCompra() {
		return this.activarid_usuarioOrdenCompra;
	}

	public void setActivarid_usuarioOrdenCompra(Boolean activarid_usuarioOrdenCompra) {
		this.activarid_usuarioOrdenCompra= activarid_usuarioOrdenCompra;
	}

	public Boolean getCargarid_usuarioOrdenCompra() {
		return this.cargarid_usuarioOrdenCompra;
	}

	public void setCargarid_usuarioOrdenCompra(Boolean cargarid_usuarioOrdenCompra) {
		this.cargarid_usuarioOrdenCompra= cargarid_usuarioOrdenCompra;
	}

	public Border setResaltarfecha_emisionOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionOrdenCompra() {
		return this.resaltarfecha_emisionOrdenCompra;
	}

	public void setResaltarfecha_emisionOrdenCompra(Border borderResaltar) {
		this.resaltarfecha_emisionOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionOrdenCompra() {
		return this.mostrarfecha_emisionOrdenCompra;
	}

	public void setMostrarfecha_emisionOrdenCompra(Boolean mostrarfecha_emisionOrdenCompra) {
		this.mostrarfecha_emisionOrdenCompra= mostrarfecha_emisionOrdenCompra;
	}

	public Boolean getActivarfecha_emisionOrdenCompra() {
		return this.activarfecha_emisionOrdenCompra;
	}

	public void setActivarfecha_emisionOrdenCompra(Boolean activarfecha_emisionOrdenCompra) {
		this.activarfecha_emisionOrdenCompra= activarfecha_emisionOrdenCompra;
	}

	public Border setResaltarfecha_entregaOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaOrdenCompra() {
		return this.resaltarfecha_entregaOrdenCompra;
	}

	public void setResaltarfecha_entregaOrdenCompra(Border borderResaltar) {
		this.resaltarfecha_entregaOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaOrdenCompra() {
		return this.mostrarfecha_entregaOrdenCompra;
	}

	public void setMostrarfecha_entregaOrdenCompra(Boolean mostrarfecha_entregaOrdenCompra) {
		this.mostrarfecha_entregaOrdenCompra= mostrarfecha_entregaOrdenCompra;
	}

	public Boolean getActivarfecha_entregaOrdenCompra() {
		return this.activarfecha_entregaOrdenCompra;
	}

	public void setActivarfecha_entregaOrdenCompra(Boolean activarfecha_entregaOrdenCompra) {
		this.activarfecha_entregaOrdenCompra= activarfecha_entregaOrdenCompra;
	}

	public Border setResaltarnumero_secuencialOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialOrdenCompra() {
		return this.resaltarnumero_secuencialOrdenCompra;
	}

	public void setResaltarnumero_secuencialOrdenCompra(Border borderResaltar) {
		this.resaltarnumero_secuencialOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialOrdenCompra() {
		return this.mostrarnumero_secuencialOrdenCompra;
	}

	public void setMostrarnumero_secuencialOrdenCompra(Boolean mostrarnumero_secuencialOrdenCompra) {
		this.mostrarnumero_secuencialOrdenCompra= mostrarnumero_secuencialOrdenCompra;
	}

	public Boolean getActivarnumero_secuencialOrdenCompra() {
		return this.activarnumero_secuencialOrdenCompra;
	}

	public void setActivarnumero_secuencialOrdenCompra(Boolean activarnumero_secuencialOrdenCompra) {
		this.activarnumero_secuencialOrdenCompra= activarnumero_secuencialOrdenCompra;
	}

	public Border setResaltarid_monedaOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_monedaOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaOrdenCompra() {
		return this.resaltarid_monedaOrdenCompra;
	}

	public void setResaltarid_monedaOrdenCompra(Border borderResaltar) {
		this.resaltarid_monedaOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_monedaOrdenCompra() {
		return this.mostrarid_monedaOrdenCompra;
	}

	public void setMostrarid_monedaOrdenCompra(Boolean mostrarid_monedaOrdenCompra) {
		this.mostrarid_monedaOrdenCompra= mostrarid_monedaOrdenCompra;
	}

	public Boolean getActivarid_monedaOrdenCompra() {
		return this.activarid_monedaOrdenCompra;
	}

	public void setActivarid_monedaOrdenCompra(Boolean activarid_monedaOrdenCompra) {
		this.activarid_monedaOrdenCompra= activarid_monedaOrdenCompra;
	}

	public Boolean getCargarid_monedaOrdenCompra() {
		return this.cargarid_monedaOrdenCompra;
	}

	public void setCargarid_monedaOrdenCompra(Boolean cargarid_monedaOrdenCompra) {
		this.cargarid_monedaOrdenCompra= cargarid_monedaOrdenCompra;
	}

	public Border setResaltarid_tipo_cambioOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioOrdenCompra() {
		return this.resaltarid_tipo_cambioOrdenCompra;
	}

	public void setResaltarid_tipo_cambioOrdenCompra(Border borderResaltar) {
		this.resaltarid_tipo_cambioOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioOrdenCompra() {
		return this.mostrarid_tipo_cambioOrdenCompra;
	}

	public void setMostrarid_tipo_cambioOrdenCompra(Boolean mostrarid_tipo_cambioOrdenCompra) {
		this.mostrarid_tipo_cambioOrdenCompra= mostrarid_tipo_cambioOrdenCompra;
	}

	public Boolean getActivarid_tipo_cambioOrdenCompra() {
		return this.activarid_tipo_cambioOrdenCompra;
	}

	public void setActivarid_tipo_cambioOrdenCompra(Boolean activarid_tipo_cambioOrdenCompra) {
		this.activarid_tipo_cambioOrdenCompra= activarid_tipo_cambioOrdenCompra;
	}

	public Boolean getCargarid_tipo_cambioOrdenCompra() {
		return this.cargarid_tipo_cambioOrdenCompra;
	}

	public void setCargarid_tipo_cambioOrdenCompra(Boolean cargarid_tipo_cambioOrdenCompra) {
		this.cargarid_tipo_cambioOrdenCompra= cargarid_tipo_cambioOrdenCompra;
	}

	public Border setResaltarid_estado_orden_compraOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_estado_orden_compraOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_orden_compraOrdenCompra() {
		return this.resaltarid_estado_orden_compraOrdenCompra;
	}

	public void setResaltarid_estado_orden_compraOrdenCompra(Border borderResaltar) {
		this.resaltarid_estado_orden_compraOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_estado_orden_compraOrdenCompra() {
		return this.mostrarid_estado_orden_compraOrdenCompra;
	}

	public void setMostrarid_estado_orden_compraOrdenCompra(Boolean mostrarid_estado_orden_compraOrdenCompra) {
		this.mostrarid_estado_orden_compraOrdenCompra= mostrarid_estado_orden_compraOrdenCompra;
	}

	public Boolean getActivarid_estado_orden_compraOrdenCompra() {
		return this.activarid_estado_orden_compraOrdenCompra;
	}

	public void setActivarid_estado_orden_compraOrdenCompra(Boolean activarid_estado_orden_compraOrdenCompra) {
		this.activarid_estado_orden_compraOrdenCompra= activarid_estado_orden_compraOrdenCompra;
	}

	public Boolean getCargarid_estado_orden_compraOrdenCompra() {
		return this.cargarid_estado_orden_compraOrdenCompra;
	}

	public void setCargarid_estado_orden_compraOrdenCompra(Boolean cargarid_estado_orden_compraOrdenCompra) {
		this.cargarid_estado_orden_compraOrdenCompra= cargarid_estado_orden_compraOrdenCompra;
	}

	public Border setResaltarid_clienteOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_clienteOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_clienteOrdenCompra() {
		return this.resaltarid_clienteOrdenCompra;
	}

	public void setResaltarid_clienteOrdenCompra(Border borderResaltar) {
		this.resaltarid_clienteOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_clienteOrdenCompra() {
		return this.mostrarid_clienteOrdenCompra;
	}

	public void setMostrarid_clienteOrdenCompra(Boolean mostrarid_clienteOrdenCompra) {
		this.mostrarid_clienteOrdenCompra= mostrarid_clienteOrdenCompra;
	}

	public Boolean getActivarid_clienteOrdenCompra() {
		return this.activarid_clienteOrdenCompra;
	}

	public void setActivarid_clienteOrdenCompra(Boolean activarid_clienteOrdenCompra) {
		this.activarid_clienteOrdenCompra= activarid_clienteOrdenCompra;
	}

	public Boolean getCargarid_clienteOrdenCompra() {
		return this.cargarid_clienteOrdenCompra;
	}

	public void setCargarid_clienteOrdenCompra(Boolean cargarid_clienteOrdenCompra) {
		this.cargarid_clienteOrdenCompra= cargarid_clienteOrdenCompra;
	}

	public Border setResaltarid_formatoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_formatoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoOrdenCompra() {
		return this.resaltarid_formatoOrdenCompra;
	}

	public void setResaltarid_formatoOrdenCompra(Border borderResaltar) {
		this.resaltarid_formatoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_formatoOrdenCompra() {
		return this.mostrarid_formatoOrdenCompra;
	}

	public void setMostrarid_formatoOrdenCompra(Boolean mostrarid_formatoOrdenCompra) {
		this.mostrarid_formatoOrdenCompra= mostrarid_formatoOrdenCompra;
	}

	public Boolean getActivarid_formatoOrdenCompra() {
		return this.activarid_formatoOrdenCompra;
	}

	public void setActivarid_formatoOrdenCompra(Boolean activarid_formatoOrdenCompra) {
		this.activarid_formatoOrdenCompra= activarid_formatoOrdenCompra;
	}

	public Boolean getCargarid_formatoOrdenCompra() {
		return this.cargarid_formatoOrdenCompra;
	}

	public void setCargarid_formatoOrdenCompra(Boolean cargarid_formatoOrdenCompra) {
		this.cargarid_formatoOrdenCompra= cargarid_formatoOrdenCompra;
	}

	public Border setResaltarid_transportistaOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_transportistaOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportistaOrdenCompra() {
		return this.resaltarid_transportistaOrdenCompra;
	}

	public void setResaltarid_transportistaOrdenCompra(Border borderResaltar) {
		this.resaltarid_transportistaOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_transportistaOrdenCompra() {
		return this.mostrarid_transportistaOrdenCompra;
	}

	public void setMostrarid_transportistaOrdenCompra(Boolean mostrarid_transportistaOrdenCompra) {
		this.mostrarid_transportistaOrdenCompra= mostrarid_transportistaOrdenCompra;
	}

	public Boolean getActivarid_transportistaOrdenCompra() {
		return this.activarid_transportistaOrdenCompra;
	}

	public void setActivarid_transportistaOrdenCompra(Boolean activarid_transportistaOrdenCompra) {
		this.activarid_transportistaOrdenCompra= activarid_transportistaOrdenCompra;
	}

	public Boolean getCargarid_transportistaOrdenCompra() {
		return this.cargarid_transportistaOrdenCompra;
	}

	public void setCargarid_transportistaOrdenCompra(Boolean cargarid_transportistaOrdenCompra) {
		this.cargarid_transportistaOrdenCompra= cargarid_transportistaOrdenCompra;
	}

	public Border setResaltarid_empleadoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_empleadoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoOrdenCompra() {
		return this.resaltarid_empleadoOrdenCompra;
	}

	public void setResaltarid_empleadoOrdenCompra(Border borderResaltar) {
		this.resaltarid_empleadoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_empleadoOrdenCompra() {
		return this.mostrarid_empleadoOrdenCompra;
	}

	public void setMostrarid_empleadoOrdenCompra(Boolean mostrarid_empleadoOrdenCompra) {
		this.mostrarid_empleadoOrdenCompra= mostrarid_empleadoOrdenCompra;
	}

	public Boolean getActivarid_empleadoOrdenCompra() {
		return this.activarid_empleadoOrdenCompra;
	}

	public void setActivarid_empleadoOrdenCompra(Boolean activarid_empleadoOrdenCompra) {
		this.activarid_empleadoOrdenCompra= activarid_empleadoOrdenCompra;
	}

	public Boolean getCargarid_empleadoOrdenCompra() {
		return this.cargarid_empleadoOrdenCompra;
	}

	public void setCargarid_empleadoOrdenCompra(Boolean cargarid_empleadoOrdenCompra) {
		this.cargarid_empleadoOrdenCompra= cargarid_empleadoOrdenCompra;
	}

	public Border setResaltardescripcionOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltardescripcionOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionOrdenCompra() {
		return this.resaltardescripcionOrdenCompra;
	}

	public void setResaltardescripcionOrdenCompra(Border borderResaltar) {
		this.resaltardescripcionOrdenCompra= borderResaltar;
	}

	public Boolean getMostrardescripcionOrdenCompra() {
		return this.mostrardescripcionOrdenCompra;
	}

	public void setMostrardescripcionOrdenCompra(Boolean mostrardescripcionOrdenCompra) {
		this.mostrardescripcionOrdenCompra= mostrardescripcionOrdenCompra;
	}

	public Boolean getActivardescripcionOrdenCompra() {
		return this.activardescripcionOrdenCompra;
	}

	public void setActivardescripcionOrdenCompra(Boolean activardescripcionOrdenCompra) {
		this.activardescripcionOrdenCompra= activardescripcionOrdenCompra;
	}

	public Border setResaltarporcentaje_descuentoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarporcentaje_descuentoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_descuentoOrdenCompra() {
		return this.resaltarporcentaje_descuentoOrdenCompra;
	}

	public void setResaltarporcentaje_descuentoOrdenCompra(Border borderResaltar) {
		this.resaltarporcentaje_descuentoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarporcentaje_descuentoOrdenCompra() {
		return this.mostrarporcentaje_descuentoOrdenCompra;
	}

	public void setMostrarporcentaje_descuentoOrdenCompra(Boolean mostrarporcentaje_descuentoOrdenCompra) {
		this.mostrarporcentaje_descuentoOrdenCompra= mostrarporcentaje_descuentoOrdenCompra;
	}

	public Boolean getActivarporcentaje_descuentoOrdenCompra() {
		return this.activarporcentaje_descuentoOrdenCompra;
	}

	public void setActivarporcentaje_descuentoOrdenCompra(Boolean activarporcentaje_descuentoOrdenCompra) {
		this.activarporcentaje_descuentoOrdenCompra= activarporcentaje_descuentoOrdenCompra;
	}

	public Border setResaltarsumanOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarsumanOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsumanOrdenCompra() {
		return this.resaltarsumanOrdenCompra;
	}

	public void setResaltarsumanOrdenCompra(Border borderResaltar) {
		this.resaltarsumanOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarsumanOrdenCompra() {
		return this.mostrarsumanOrdenCompra;
	}

	public void setMostrarsumanOrdenCompra(Boolean mostrarsumanOrdenCompra) {
		this.mostrarsumanOrdenCompra= mostrarsumanOrdenCompra;
	}

	public Boolean getActivarsumanOrdenCompra() {
		return this.activarsumanOrdenCompra;
	}

	public void setActivarsumanOrdenCompra(Boolean activarsumanOrdenCompra) {
		this.activarsumanOrdenCompra= activarsumanOrdenCompra;
	}

	public Border setResaltariceOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltariceOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceOrdenCompra() {
		return this.resaltariceOrdenCompra;
	}

	public void setResaltariceOrdenCompra(Border borderResaltar) {
		this.resaltariceOrdenCompra= borderResaltar;
	}

	public Boolean getMostrariceOrdenCompra() {
		return this.mostrariceOrdenCompra;
	}

	public void setMostrariceOrdenCompra(Boolean mostrariceOrdenCompra) {
		this.mostrariceOrdenCompra= mostrariceOrdenCompra;
	}

	public Boolean getActivariceOrdenCompra() {
		return this.activariceOrdenCompra;
	}

	public void setActivariceOrdenCompra(Boolean activariceOrdenCompra) {
		this.activariceOrdenCompra= activariceOrdenCompra;
	}

	public Border setResaltarvalor_descuentoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarvalor_descuentoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_descuentoOrdenCompra() {
		return this.resaltarvalor_descuentoOrdenCompra;
	}

	public void setResaltarvalor_descuentoOrdenCompra(Border borderResaltar) {
		this.resaltarvalor_descuentoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarvalor_descuentoOrdenCompra() {
		return this.mostrarvalor_descuentoOrdenCompra;
	}

	public void setMostrarvalor_descuentoOrdenCompra(Boolean mostrarvalor_descuentoOrdenCompra) {
		this.mostrarvalor_descuentoOrdenCompra= mostrarvalor_descuentoOrdenCompra;
	}

	public Boolean getActivarvalor_descuentoOrdenCompra() {
		return this.activarvalor_descuentoOrdenCompra;
	}

	public void setActivarvalor_descuentoOrdenCompra(Boolean activarvalor_descuentoOrdenCompra) {
		this.activarvalor_descuentoOrdenCompra= activarvalor_descuentoOrdenCompra;
	}

	public Border setResaltartotal_descuentoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltartotal_descuentoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_descuentoOrdenCompra() {
		return this.resaltartotal_descuentoOrdenCompra;
	}

	public void setResaltartotal_descuentoOrdenCompra(Border borderResaltar) {
		this.resaltartotal_descuentoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrartotal_descuentoOrdenCompra() {
		return this.mostrartotal_descuentoOrdenCompra;
	}

	public void setMostrartotal_descuentoOrdenCompra(Boolean mostrartotal_descuentoOrdenCompra) {
		this.mostrartotal_descuentoOrdenCompra= mostrartotal_descuentoOrdenCompra;
	}

	public Boolean getActivartotal_descuentoOrdenCompra() {
		return this.activartotal_descuentoOrdenCompra;
	}

	public void setActivartotal_descuentoOrdenCompra(Boolean activartotal_descuentoOrdenCompra) {
		this.activartotal_descuentoOrdenCompra= activartotal_descuentoOrdenCompra;
	}

	public Border setResaltarivaOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarivaOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaOrdenCompra() {
		return this.resaltarivaOrdenCompra;
	}

	public void setResaltarivaOrdenCompra(Border borderResaltar) {
		this.resaltarivaOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarivaOrdenCompra() {
		return this.mostrarivaOrdenCompra;
	}

	public void setMostrarivaOrdenCompra(Boolean mostrarivaOrdenCompra) {
		this.mostrarivaOrdenCompra= mostrarivaOrdenCompra;
	}

	public Boolean getActivarivaOrdenCompra() {
		return this.activarivaOrdenCompra;
	}

	public void setActivarivaOrdenCompra(Boolean activarivaOrdenCompra) {
		this.activarivaOrdenCompra= activarivaOrdenCompra;
	}

	public Border setResaltarstockOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarstockOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarstockOrdenCompra() {
		return this.resaltarstockOrdenCompra;
	}

	public void setResaltarstockOrdenCompra(Border borderResaltar) {
		this.resaltarstockOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarstockOrdenCompra() {
		return this.mostrarstockOrdenCompra;
	}

	public void setMostrarstockOrdenCompra(Boolean mostrarstockOrdenCompra) {
		this.mostrarstockOrdenCompra= mostrarstockOrdenCompra;
	}

	public Boolean getActivarstockOrdenCompra() {
		return this.activarstockOrdenCompra;
	}

	public void setActivarstockOrdenCompra(Boolean activarstockOrdenCompra) {
		this.activarstockOrdenCompra= activarstockOrdenCompra;
	}

	public Border setResaltarsub_totalOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarsub_totalOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalOrdenCompra() {
		return this.resaltarsub_totalOrdenCompra;
	}

	public void setResaltarsub_totalOrdenCompra(Border borderResaltar) {
		this.resaltarsub_totalOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarsub_totalOrdenCompra() {
		return this.mostrarsub_totalOrdenCompra;
	}

	public void setMostrarsub_totalOrdenCompra(Boolean mostrarsub_totalOrdenCompra) {
		this.mostrarsub_totalOrdenCompra= mostrarsub_totalOrdenCompra;
	}

	public Boolean getActivarsub_totalOrdenCompra() {
		return this.activarsub_totalOrdenCompra;
	}

	public void setActivarsub_totalOrdenCompra(Boolean activarsub_totalOrdenCompra) {
		this.activarsub_totalOrdenCompra= activarsub_totalOrdenCompra;
	}

	public Border setResaltartotal_otroOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltartotal_otroOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_otroOrdenCompra() {
		return this.resaltartotal_otroOrdenCompra;
	}

	public void setResaltartotal_otroOrdenCompra(Border borderResaltar) {
		this.resaltartotal_otroOrdenCompra= borderResaltar;
	}

	public Boolean getMostrartotal_otroOrdenCompra() {
		return this.mostrartotal_otroOrdenCompra;
	}

	public void setMostrartotal_otroOrdenCompra(Boolean mostrartotal_otroOrdenCompra) {
		this.mostrartotal_otroOrdenCompra= mostrartotal_otroOrdenCompra;
	}

	public Boolean getActivartotal_otroOrdenCompra() {
		return this.activartotal_otroOrdenCompra;
	}

	public void setActivartotal_otroOrdenCompra(Boolean activartotal_otroOrdenCompra) {
		this.activartotal_otroOrdenCompra= activartotal_otroOrdenCompra;
	}

	public Border setResaltarultimo_costoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarultimo_costoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarultimo_costoOrdenCompra() {
		return this.resaltarultimo_costoOrdenCompra;
	}

	public void setResaltarultimo_costoOrdenCompra(Border borderResaltar) {
		this.resaltarultimo_costoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarultimo_costoOrdenCompra() {
		return this.mostrarultimo_costoOrdenCompra;
	}

	public void setMostrarultimo_costoOrdenCompra(Boolean mostrarultimo_costoOrdenCompra) {
		this.mostrarultimo_costoOrdenCompra= mostrarultimo_costoOrdenCompra;
	}

	public Boolean getActivarultimo_costoOrdenCompra() {
		return this.activarultimo_costoOrdenCompra;
	}

	public void setActivarultimo_costoOrdenCompra(Boolean activarultimo_costoOrdenCompra) {
		this.activarultimo_costoOrdenCompra= activarultimo_costoOrdenCompra;
	}

	public Border setResaltarnumero_itemsOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarnumero_itemsOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_itemsOrdenCompra() {
		return this.resaltarnumero_itemsOrdenCompra;
	}

	public void setResaltarnumero_itemsOrdenCompra(Border borderResaltar) {
		this.resaltarnumero_itemsOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarnumero_itemsOrdenCompra() {
		return this.mostrarnumero_itemsOrdenCompra;
	}

	public void setMostrarnumero_itemsOrdenCompra(Boolean mostrarnumero_itemsOrdenCompra) {
		this.mostrarnumero_itemsOrdenCompra= mostrarnumero_itemsOrdenCompra;
	}

	public Boolean getActivarnumero_itemsOrdenCompra() {
		return this.activarnumero_itemsOrdenCompra;
	}

	public void setActivarnumero_itemsOrdenCompra(Boolean activarnumero_itemsOrdenCompra) {
		this.activarnumero_itemsOrdenCompra= activarnumero_itemsOrdenCompra;
	}

	public Border setResaltarretencionOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarretencionOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarretencionOrdenCompra() {
		return this.resaltarretencionOrdenCompra;
	}

	public void setResaltarretencionOrdenCompra(Border borderResaltar) {
		this.resaltarretencionOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarretencionOrdenCompra() {
		return this.mostrarretencionOrdenCompra;
	}

	public void setMostrarretencionOrdenCompra(Boolean mostrarretencionOrdenCompra) {
		this.mostrarretencionOrdenCompra= mostrarretencionOrdenCompra;
	}

	public Boolean getActivarretencionOrdenCompra() {
		return this.activarretencionOrdenCompra;
	}

	public void setActivarretencionOrdenCompra(Boolean activarretencionOrdenCompra) {
		this.activarretencionOrdenCompra= activarretencionOrdenCompra;
	}

	public Border setResaltartotalOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltartotalOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalOrdenCompra() {
		return this.resaltartotalOrdenCompra;
	}

	public void setResaltartotalOrdenCompra(Border borderResaltar) {
		this.resaltartotalOrdenCompra= borderResaltar;
	}

	public Boolean getMostrartotalOrdenCompra() {
		return this.mostrartotalOrdenCompra;
	}

	public void setMostrartotalOrdenCompra(Boolean mostrartotalOrdenCompra) {
		this.mostrartotalOrdenCompra= mostrartotalOrdenCompra;
	}

	public Boolean getActivartotalOrdenCompra() {
		return this.activartotalOrdenCompra;
	}

	public void setActivartotalOrdenCompra(Boolean activartotalOrdenCompra) {
		this.activartotalOrdenCompra= activartotalOrdenCompra;
	}

	public Border setResaltarfleteOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarfleteOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteOrdenCompra() {
		return this.resaltarfleteOrdenCompra;
	}

	public void setResaltarfleteOrdenCompra(Border borderResaltar) {
		this.resaltarfleteOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarfleteOrdenCompra() {
		return this.mostrarfleteOrdenCompra;
	}

	public void setMostrarfleteOrdenCompra(Boolean mostrarfleteOrdenCompra) {
		this.mostrarfleteOrdenCompra= mostrarfleteOrdenCompra;
	}

	public Boolean getActivarfleteOrdenCompra() {
		return this.activarfleteOrdenCompra;
	}

	public void setActivarfleteOrdenCompra(Boolean activarfleteOrdenCompra) {
		this.activarfleteOrdenCompra= activarfleteOrdenCompra;
	}

	public Border setResaltarimpuestoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarimpuestoOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuestoOrdenCompra() {
		return this.resaltarimpuestoOrdenCompra;
	}

	public void setResaltarimpuestoOrdenCompra(Border borderResaltar) {
		this.resaltarimpuestoOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarimpuestoOrdenCompra() {
		return this.mostrarimpuestoOrdenCompra;
	}

	public void setMostrarimpuestoOrdenCompra(Boolean mostrarimpuestoOrdenCompra) {
		this.mostrarimpuestoOrdenCompra= mostrarimpuestoOrdenCompra;
	}

	public Boolean getActivarimpuestoOrdenCompra() {
		return this.activarimpuestoOrdenCompra;
	}

	public void setActivarimpuestoOrdenCompra(Boolean activarimpuestoOrdenCompra) {
		this.activarimpuestoOrdenCompra= activarimpuestoOrdenCompra;
	}

	public Border setResaltarid_tipo_transaccion_moduloOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloOrdenCompra() {
		return this.resaltarid_tipo_transaccion_moduloOrdenCompra;
	}

	public void setResaltarid_tipo_transaccion_moduloOrdenCompra(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloOrdenCompra() {
		return this.mostrarid_tipo_transaccion_moduloOrdenCompra;
	}

	public void setMostrarid_tipo_transaccion_moduloOrdenCompra(Boolean mostrarid_tipo_transaccion_moduloOrdenCompra) {
		this.mostrarid_tipo_transaccion_moduloOrdenCompra= mostrarid_tipo_transaccion_moduloOrdenCompra;
	}

	public Boolean getActivarid_tipo_transaccion_moduloOrdenCompra() {
		return this.activarid_tipo_transaccion_moduloOrdenCompra;
	}

	public void setActivarid_tipo_transaccion_moduloOrdenCompra(Boolean activarid_tipo_transaccion_moduloOrdenCompra) {
		this.activarid_tipo_transaccion_moduloOrdenCompra= activarid_tipo_transaccion_moduloOrdenCompra;
	}

	public Boolean getCargarid_tipo_transaccion_moduloOrdenCompra() {
		return this.cargarid_tipo_transaccion_moduloOrdenCompra;
	}

	public void setCargarid_tipo_transaccion_moduloOrdenCompra(Boolean cargarid_tipo_transaccion_moduloOrdenCompra) {
		this.cargarid_tipo_transaccion_moduloOrdenCompra= cargarid_tipo_transaccion_moduloOrdenCompra;
	}

	public Border setResaltarid_orden_compraOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_orden_compraOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_orden_compraOrdenCompra() {
		return this.resaltarid_orden_compraOrdenCompra;
	}

	public void setResaltarid_orden_compraOrdenCompra(Border borderResaltar) {
		this.resaltarid_orden_compraOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_orden_compraOrdenCompra() {
		return this.mostrarid_orden_compraOrdenCompra;
	}

	public void setMostrarid_orden_compraOrdenCompra(Boolean mostrarid_orden_compraOrdenCompra) {
		this.mostrarid_orden_compraOrdenCompra= mostrarid_orden_compraOrdenCompra;
	}

	public Boolean getActivarid_orden_compraOrdenCompra() {
		return this.activarid_orden_compraOrdenCompra;
	}

	public void setActivarid_orden_compraOrdenCompra(Boolean activarid_orden_compraOrdenCompra) {
		this.activarid_orden_compraOrdenCompra= activarid_orden_compraOrdenCompra;
	}

	public Boolean getCargarid_orden_compraOrdenCompra() {
		return this.cargarid_orden_compraOrdenCompra;
	}

	public void setCargarid_orden_compraOrdenCompra(Boolean cargarid_orden_compraOrdenCompra) {
		this.cargarid_orden_compraOrdenCompra= cargarid_orden_compraOrdenCompra;
	}

	public Border setResaltarid_asiento_contableOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableOrdenCompra() {
		return this.resaltarid_asiento_contableOrdenCompra;
	}

	public void setResaltarid_asiento_contableOrdenCompra(Border borderResaltar) {
		this.resaltarid_asiento_contableOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableOrdenCompra() {
		return this.mostrarid_asiento_contableOrdenCompra;
	}

	public void setMostrarid_asiento_contableOrdenCompra(Boolean mostrarid_asiento_contableOrdenCompra) {
		this.mostrarid_asiento_contableOrdenCompra= mostrarid_asiento_contableOrdenCompra;
	}

	public Boolean getActivarid_asiento_contableOrdenCompra() {
		return this.activarid_asiento_contableOrdenCompra;
	}

	public void setActivarid_asiento_contableOrdenCompra(Boolean activarid_asiento_contableOrdenCompra) {
		this.activarid_asiento_contableOrdenCompra= activarid_asiento_contableOrdenCompra;
	}

	public Boolean getCargarid_asiento_contableOrdenCompra() {
		return this.cargarid_asiento_contableOrdenCompra;
	}

	public void setCargarid_asiento_contableOrdenCompra(Boolean cargarid_asiento_contableOrdenCompra) {
		this.cargarid_asiento_contableOrdenCompra= cargarid_asiento_contableOrdenCompra;
	}

	public Border setResaltarnumero_comprobanteOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteOrdenCompra() {
		return this.resaltarnumero_comprobanteOrdenCompra;
	}

	public void setResaltarnumero_comprobanteOrdenCompra(Border borderResaltar) {
		this.resaltarnumero_comprobanteOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteOrdenCompra() {
		return this.mostrarnumero_comprobanteOrdenCompra;
	}

	public void setMostrarnumero_comprobanteOrdenCompra(Boolean mostrarnumero_comprobanteOrdenCompra) {
		this.mostrarnumero_comprobanteOrdenCompra= mostrarnumero_comprobanteOrdenCompra;
	}

	public Boolean getActivarnumero_comprobanteOrdenCompra() {
		return this.activarnumero_comprobanteOrdenCompra;
	}

	public void setActivarnumero_comprobanteOrdenCompra(Boolean activarnumero_comprobanteOrdenCompra) {
		this.activarnumero_comprobanteOrdenCompra= activarnumero_comprobanteOrdenCompra;
	}

	public Border setResaltarfechaOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltar);
		
		this.resaltarfechaOrdenCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaOrdenCompra() {
		return this.resaltarfechaOrdenCompra;
	}

	public void setResaltarfechaOrdenCompra(Border borderResaltar) {
		this.resaltarfechaOrdenCompra= borderResaltar;
	}

	public Boolean getMostrarfechaOrdenCompra() {
		return this.mostrarfechaOrdenCompra;
	}

	public void setMostrarfechaOrdenCompra(Boolean mostrarfechaOrdenCompra) {
		this.mostrarfechaOrdenCompra= mostrarfechaOrdenCompra;
	}

	public Boolean getActivarfechaOrdenCompra() {
		return this.activarfechaOrdenCompra;
	}

	public void setActivarfechaOrdenCompra(Boolean activarfechaOrdenCompra) {
		this.activarfechaOrdenCompra= activarfechaOrdenCompra;
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
		
		
		this.setMostraridOrdenCompra(esInicial);
		this.setMostrarid_empresaOrdenCompra(esInicial);
		this.setMostrarid_sucursalOrdenCompra(esInicial);
		this.setMostrarid_moduloOrdenCompra(esInicial);
		this.setMostrarid_ejercicioOrdenCompra(esInicial);
		this.setMostrarid_periodoOrdenCompra(esInicial);
		this.setMostrarid_anioOrdenCompra(esInicial);
		this.setMostrarid_mesOrdenCompra(esInicial);
		this.setMostrarid_usuarioOrdenCompra(esInicial);
		this.setMostrarfecha_emisionOrdenCompra(esInicial);
		this.setMostrarfecha_entregaOrdenCompra(esInicial);
		this.setMostrarnumero_secuencialOrdenCompra(esInicial);
		this.setMostrarid_monedaOrdenCompra(esInicial);
		this.setMostrarid_tipo_cambioOrdenCompra(esInicial);
		this.setMostrarid_estado_orden_compraOrdenCompra(esInicial);
		this.setMostrarid_clienteOrdenCompra(esInicial);
		this.setMostrarid_formatoOrdenCompra(esInicial);
		this.setMostrarid_transportistaOrdenCompra(esInicial);
		this.setMostrarid_empleadoOrdenCompra(esInicial);
		this.setMostrardescripcionOrdenCompra(esInicial);
		this.setMostrarporcentaje_descuentoOrdenCompra(esInicial);
		this.setMostrarsumanOrdenCompra(esInicial);
		this.setMostrariceOrdenCompra(esInicial);
		this.setMostrarvalor_descuentoOrdenCompra(esInicial);
		this.setMostrartotal_descuentoOrdenCompra(esInicial);
		this.setMostrarivaOrdenCompra(esInicial);
		this.setMostrarstockOrdenCompra(esInicial);
		this.setMostrarsub_totalOrdenCompra(esInicial);
		this.setMostrartotal_otroOrdenCompra(esInicial);
		this.setMostrarultimo_costoOrdenCompra(esInicial);
		this.setMostrarnumero_itemsOrdenCompra(esInicial);
		this.setMostrarretencionOrdenCompra(esInicial);
		this.setMostrartotalOrdenCompra(esInicial);
		this.setMostrarfleteOrdenCompra(esInicial);
		this.setMostrarimpuestoOrdenCompra(esInicial);
		this.setMostrarid_tipo_transaccion_moduloOrdenCompra(esInicial);
		this.setMostrarid_orden_compraOrdenCompra(esInicial);
		this.setMostrarid_asiento_contableOrdenCompra(esInicial);
		this.setMostrarnumero_comprobanteOrdenCompra(esInicial);
		this.setMostrarfechaOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(OrdenCompraConstantesFunciones.ID)) {
				this.setMostraridOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDMES)) {
				this.setMostrarid_mesOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDESTADOORDENCOMPRA)) {
				this.setMostrarid_estado_orden_compraOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDCLIENTE)) {
				this.setMostrarid_clienteOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDTRANSPORTISTA)) {
				this.setMostrarid_transportistaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setMostrarporcentaje_descuentoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.SUMAN)) {
				this.setMostrarsumanOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.ICE)) {
				this.setMostrariceOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.VALORDESCUENTO)) {
				this.setMostrarvalor_descuentoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.TOTALDESCUENTO)) {
				this.setMostrartotal_descuentoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IVA)) {
				this.setMostrarivaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.STOCK)) {
				this.setMostrarstockOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.TOTALOTRO)) {
				this.setMostrartotal_otroOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.ULTIMOCOSTO)) {
				this.setMostrarultimo_costoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.NUMEROITEMS)) {
				this.setMostrarnumero_itemsOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.RETENCION)) {
				this.setMostrarretencionOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.TOTAL)) {
				this.setMostrartotalOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.FLETE)) {
				this.setMostrarfleteOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IMPUESTO)) {
				this.setMostrarimpuestoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDORDENCOMPRA)) {
				this.setMostrarid_orden_compraOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.FECHA)) {
				this.setMostrarfechaOrdenCompra(esAsigna);
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
		
		
		this.setActivaridOrdenCompra(esInicial);
		this.setActivarid_empresaOrdenCompra(esInicial);
		this.setActivarid_sucursalOrdenCompra(esInicial);
		this.setActivarid_moduloOrdenCompra(esInicial);
		this.setActivarid_ejercicioOrdenCompra(esInicial);
		this.setActivarid_periodoOrdenCompra(esInicial);
		this.setActivarid_anioOrdenCompra(esInicial);
		this.setActivarid_mesOrdenCompra(esInicial);
		this.setActivarid_usuarioOrdenCompra(esInicial);
		this.setActivarfecha_emisionOrdenCompra(esInicial);
		this.setActivarfecha_entregaOrdenCompra(esInicial);
		this.setActivarnumero_secuencialOrdenCompra(esInicial);
		this.setActivarid_monedaOrdenCompra(esInicial);
		this.setActivarid_tipo_cambioOrdenCompra(esInicial);
		this.setActivarid_estado_orden_compraOrdenCompra(esInicial);
		this.setActivarid_clienteOrdenCompra(esInicial);
		this.setActivarid_formatoOrdenCompra(esInicial);
		this.setActivarid_transportistaOrdenCompra(esInicial);
		this.setActivarid_empleadoOrdenCompra(esInicial);
		this.setActivardescripcionOrdenCompra(esInicial);
		this.setActivarporcentaje_descuentoOrdenCompra(esInicial);
		this.setActivarsumanOrdenCompra(esInicial);
		this.setActivariceOrdenCompra(esInicial);
		this.setActivarvalor_descuentoOrdenCompra(esInicial);
		this.setActivartotal_descuentoOrdenCompra(esInicial);
		this.setActivarivaOrdenCompra(esInicial);
		this.setActivarstockOrdenCompra(esInicial);
		this.setActivarsub_totalOrdenCompra(esInicial);
		this.setActivartotal_otroOrdenCompra(esInicial);
		this.setActivarultimo_costoOrdenCompra(esInicial);
		this.setActivarnumero_itemsOrdenCompra(esInicial);
		this.setActivarretencionOrdenCompra(esInicial);
		this.setActivartotalOrdenCompra(esInicial);
		this.setActivarfleteOrdenCompra(esInicial);
		this.setActivarimpuestoOrdenCompra(esInicial);
		this.setActivarid_tipo_transaccion_moduloOrdenCompra(esInicial);
		this.setActivarid_orden_compraOrdenCompra(esInicial);
		this.setActivarid_asiento_contableOrdenCompra(esInicial);
		this.setActivarnumero_comprobanteOrdenCompra(esInicial);
		this.setActivarfechaOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(OrdenCompraConstantesFunciones.ID)) {
				this.setActivaridOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDANIO)) {
				this.setActivarid_anioOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDMES)) {
				this.setActivarid_mesOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDESTADOORDENCOMPRA)) {
				this.setActivarid_estado_orden_compraOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDCLIENTE)) {
				this.setActivarid_clienteOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDTRANSPORTISTA)) {
				this.setActivarid_transportistaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setActivarporcentaje_descuentoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.SUMAN)) {
				this.setActivarsumanOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.ICE)) {
				this.setActivariceOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.VALORDESCUENTO)) {
				this.setActivarvalor_descuentoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.TOTALDESCUENTO)) {
				this.setActivartotal_descuentoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IVA)) {
				this.setActivarivaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.STOCK)) {
				this.setActivarstockOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.TOTALOTRO)) {
				this.setActivartotal_otroOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.ULTIMOCOSTO)) {
				this.setActivarultimo_costoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.NUMEROITEMS)) {
				this.setActivarnumero_itemsOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.RETENCION)) {
				this.setActivarretencionOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.TOTAL)) {
				this.setActivartotalOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.FLETE)) {
				this.setActivarfleteOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IMPUESTO)) {
				this.setActivarimpuestoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDORDENCOMPRA)) {
				this.setActivarid_orden_compraOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.FECHA)) {
				this.setActivarfechaOrdenCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridOrdenCompra(esInicial);
		this.setResaltarid_empresaOrdenCompra(esInicial);
		this.setResaltarid_sucursalOrdenCompra(esInicial);
		this.setResaltarid_moduloOrdenCompra(esInicial);
		this.setResaltarid_ejercicioOrdenCompra(esInicial);
		this.setResaltarid_periodoOrdenCompra(esInicial);
		this.setResaltarid_anioOrdenCompra(esInicial);
		this.setResaltarid_mesOrdenCompra(esInicial);
		this.setResaltarid_usuarioOrdenCompra(esInicial);
		this.setResaltarfecha_emisionOrdenCompra(esInicial);
		this.setResaltarfecha_entregaOrdenCompra(esInicial);
		this.setResaltarnumero_secuencialOrdenCompra(esInicial);
		this.setResaltarid_monedaOrdenCompra(esInicial);
		this.setResaltarid_tipo_cambioOrdenCompra(esInicial);
		this.setResaltarid_estado_orden_compraOrdenCompra(esInicial);
		this.setResaltarid_clienteOrdenCompra(esInicial);
		this.setResaltarid_formatoOrdenCompra(esInicial);
		this.setResaltarid_transportistaOrdenCompra(esInicial);
		this.setResaltarid_empleadoOrdenCompra(esInicial);
		this.setResaltardescripcionOrdenCompra(esInicial);
		this.setResaltarporcentaje_descuentoOrdenCompra(esInicial);
		this.setResaltarsumanOrdenCompra(esInicial);
		this.setResaltariceOrdenCompra(esInicial);
		this.setResaltarvalor_descuentoOrdenCompra(esInicial);
		this.setResaltartotal_descuentoOrdenCompra(esInicial);
		this.setResaltarivaOrdenCompra(esInicial);
		this.setResaltarstockOrdenCompra(esInicial);
		this.setResaltarsub_totalOrdenCompra(esInicial);
		this.setResaltartotal_otroOrdenCompra(esInicial);
		this.setResaltarultimo_costoOrdenCompra(esInicial);
		this.setResaltarnumero_itemsOrdenCompra(esInicial);
		this.setResaltarretencionOrdenCompra(esInicial);
		this.setResaltartotalOrdenCompra(esInicial);
		this.setResaltarfleteOrdenCompra(esInicial);
		this.setResaltarimpuestoOrdenCompra(esInicial);
		this.setResaltarid_tipo_transaccion_moduloOrdenCompra(esInicial);
		this.setResaltarid_orden_compraOrdenCompra(esInicial);
		this.setResaltarid_asiento_contableOrdenCompra(esInicial);
		this.setResaltarnumero_comprobanteOrdenCompra(esInicial);
		this.setResaltarfechaOrdenCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(OrdenCompraConstantesFunciones.ID)) {
				this.setResaltaridOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDMES)) {
				this.setResaltarid_mesOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDESTADOORDENCOMPRA)) {
				this.setResaltarid_estado_orden_compraOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDCLIENTE)) {
				this.setResaltarid_clienteOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDTRANSPORTISTA)) {
				this.setResaltarid_transportistaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setResaltarporcentaje_descuentoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.SUMAN)) {
				this.setResaltarsumanOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.ICE)) {
				this.setResaltariceOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.VALORDESCUENTO)) {
				this.setResaltarvalor_descuentoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.TOTALDESCUENTO)) {
				this.setResaltartotal_descuentoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IVA)) {
				this.setResaltarivaOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.STOCK)) {
				this.setResaltarstockOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.TOTALOTRO)) {
				this.setResaltartotal_otroOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.ULTIMOCOSTO)) {
				this.setResaltarultimo_costoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.NUMEROITEMS)) {
				this.setResaltarnumero_itemsOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.RETENCION)) {
				this.setResaltarretencionOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.TOTAL)) {
				this.setResaltartotalOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.FLETE)) {
				this.setResaltarfleteOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IMPUESTO)) {
				this.setResaltarimpuestoOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDORDENCOMPRA)) {
				this.setResaltarid_orden_compraOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteOrdenCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(OrdenCompraConstantesFunciones.FECHA)) {
				this.setResaltarfechaOrdenCompra(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleOrdenCompraOrdenCompra=null;

	public Border getResaltarDetalleOrdenCompraOrdenCompra() {
		return this.resaltarDetalleOrdenCompraOrdenCompra;
	}

	public void setResaltarDetalleOrdenCompraOrdenCompra(Border borderResaltarDetalleOrdenCompra) {
		if(borderResaltarDetalleOrdenCompra!=null) {
			this.resaltarDetalleOrdenCompraOrdenCompra= borderResaltarDetalleOrdenCompra;
		}
	}

	public Border setResaltarDetalleOrdenCompraOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleOrdenCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//ordencompraBeanSwingJInternalFrame.jTtoolBarOrdenCompra.setBorder(borderResaltarDetalleOrdenCompra);
			
		this.resaltarDetalleOrdenCompraOrdenCompra= borderResaltarDetalleOrdenCompra;

		 return borderResaltarDetalleOrdenCompra;
	}



	public Boolean mostrarDetalleOrdenCompraOrdenCompra=true;

	public Boolean getMostrarDetalleOrdenCompraOrdenCompra() {
		return this.mostrarDetalleOrdenCompraOrdenCompra;
	}

	public void setMostrarDetalleOrdenCompraOrdenCompra(Boolean visibilidadResaltarDetalleOrdenCompra) {
		this.mostrarDetalleOrdenCompraOrdenCompra= visibilidadResaltarDetalleOrdenCompra;
	}



	public Boolean activarDetalleOrdenCompraOrdenCompra=true;

	public Boolean gethabilitarResaltarDetalleOrdenCompraOrdenCompra() {
		return this.activarDetalleOrdenCompraOrdenCompra;
	}

	public void setActivarDetalleOrdenCompraOrdenCompra(Boolean habilitarResaltarDetalleOrdenCompra) {
		this.activarDetalleOrdenCompraOrdenCompra= habilitarResaltarDetalleOrdenCompra;
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

		this.setMostrarDetalleOrdenCompraOrdenCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleOrdenCompra.class)) {
				this.setMostrarDetalleOrdenCompraOrdenCompra(esAsigna);
				continue;
			}
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

		this.setActivarDetalleOrdenCompraOrdenCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleOrdenCompra.class)) {
				this.setActivarDetalleOrdenCompraOrdenCompra(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleOrdenCompraOrdenCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleOrdenCompra.class)) {
				this.setResaltarDetalleOrdenCompraOrdenCompra(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdAsientoContableOrdenCompra=true;

	public Boolean getMostrarFK_IdAsientoContableOrdenCompra() {
		return this.mostrarFK_IdAsientoContableOrdenCompra;
	}

	public void setMostrarFK_IdAsientoContableOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdClienteOrdenCompra=true;

	public Boolean getMostrarFK_IdClienteOrdenCompra() {
		return this.mostrarFK_IdClienteOrdenCompra;
	}

	public void setMostrarFK_IdClienteOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdClienteOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioOrdenCompra=true;

	public Boolean getMostrarFK_IdEjercicioOrdenCompra() {
		return this.mostrarFK_IdEjercicioOrdenCompra;
	}

	public void setMostrarFK_IdEjercicioOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoOrdenCompra=true;

	public Boolean getMostrarFK_IdEmpleadoOrdenCompra() {
		return this.mostrarFK_IdEmpleadoOrdenCompra;
	}

	public void setMostrarFK_IdEmpleadoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaOrdenCompra=true;

	public Boolean getMostrarFK_IdEmpresaOrdenCompra() {
		return this.mostrarFK_IdEmpresaOrdenCompra;
	}

	public void setMostrarFK_IdEmpresaOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoOrdenCompraOrdenCompra=true;

	public Boolean getMostrarFK_IdEstadoOrdenCompraOrdenCompra() {
		return this.mostrarFK_IdEstadoOrdenCompraOrdenCompra;
	}

	public void setMostrarFK_IdEstadoOrdenCompraOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoOrdenCompraOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloOrdenCompra=true;

	public Boolean getMostrarFK_IdModuloOrdenCompra() {
		return this.mostrarFK_IdModuloOrdenCompra;
	}

	public void setMostrarFK_IdModuloOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdOrdenCompraOrdenCompra=true;

	public Boolean getMostrarFK_IdOrdenCompraOrdenCompra() {
		return this.mostrarFK_IdOrdenCompraOrdenCompra;
	}

	public void setMostrarFK_IdOrdenCompraOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdOrdenCompraOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoOrdenCompra=true;

	public Boolean getMostrarFK_IdPeriodoOrdenCompra() {
		return this.mostrarFK_IdPeriodoOrdenCompra;
	}

	public void setMostrarFK_IdPeriodoOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalOrdenCompra=true;

	public Boolean getMostrarFK_IdSucursalOrdenCompra() {
		return this.mostrarFK_IdSucursalOrdenCompra;
	}

	public void setMostrarFK_IdSucursalOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloOrdenCompra=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloOrdenCompra() {
		return this.mostrarFK_IdTipoTransaccionModuloOrdenCompra;
	}

	public void setMostrarFK_IdTipoTransaccionModuloOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloOrdenCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioOrdenCompra=true;

	public Boolean getMostrarFK_IdUsuarioOrdenCompra() {
		return this.mostrarFK_IdUsuarioOrdenCompra;
	}

	public void setMostrarFK_IdUsuarioOrdenCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioOrdenCompra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableOrdenCompra=true;

	public Boolean getActivarFK_IdAsientoContableOrdenCompra() {
		return this.activarFK_IdAsientoContableOrdenCompra;
	}

	public void setActivarFK_IdAsientoContableOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdClienteOrdenCompra=true;

	public Boolean getActivarFK_IdClienteOrdenCompra() {
		return this.activarFK_IdClienteOrdenCompra;
	}

	public void setActivarFK_IdClienteOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdClienteOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioOrdenCompra=true;

	public Boolean getActivarFK_IdEjercicioOrdenCompra() {
		return this.activarFK_IdEjercicioOrdenCompra;
	}

	public void setActivarFK_IdEjercicioOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoOrdenCompra=true;

	public Boolean getActivarFK_IdEmpleadoOrdenCompra() {
		return this.activarFK_IdEmpleadoOrdenCompra;
	}

	public void setActivarFK_IdEmpleadoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaOrdenCompra=true;

	public Boolean getActivarFK_IdEmpresaOrdenCompra() {
		return this.activarFK_IdEmpresaOrdenCompra;
	}

	public void setActivarFK_IdEmpresaOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoOrdenCompraOrdenCompra=true;

	public Boolean getActivarFK_IdEstadoOrdenCompraOrdenCompra() {
		return this.activarFK_IdEstadoOrdenCompraOrdenCompra;
	}

	public void setActivarFK_IdEstadoOrdenCompraOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoOrdenCompraOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloOrdenCompra=true;

	public Boolean getActivarFK_IdModuloOrdenCompra() {
		return this.activarFK_IdModuloOrdenCompra;
	}

	public void setActivarFK_IdModuloOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdModuloOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdOrdenCompraOrdenCompra=true;

	public Boolean getActivarFK_IdOrdenCompraOrdenCompra() {
		return this.activarFK_IdOrdenCompraOrdenCompra;
	}

	public void setActivarFK_IdOrdenCompraOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdOrdenCompraOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoOrdenCompra=true;

	public Boolean getActivarFK_IdPeriodoOrdenCompra() {
		return this.activarFK_IdPeriodoOrdenCompra;
	}

	public void setActivarFK_IdPeriodoOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalOrdenCompra=true;

	public Boolean getActivarFK_IdSucursalOrdenCompra() {
		return this.activarFK_IdSucursalOrdenCompra;
	}

	public void setActivarFK_IdSucursalOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloOrdenCompra=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloOrdenCompra() {
		return this.activarFK_IdTipoTransaccionModuloOrdenCompra;
	}

	public void setActivarFK_IdTipoTransaccionModuloOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloOrdenCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioOrdenCompra=true;

	public Boolean getActivarFK_IdUsuarioOrdenCompra() {
		return this.activarFK_IdUsuarioOrdenCompra;
	}

	public void setActivarFK_IdUsuarioOrdenCompra(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioOrdenCompra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableOrdenCompra=null;

	public Border getResaltarFK_IdAsientoContableOrdenCompra() {
		return this.resaltarFK_IdAsientoContableOrdenCompra;
	}

	public void setResaltarFK_IdAsientoContableOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdClienteOrdenCompra=null;

	public Border getResaltarFK_IdClienteOrdenCompra() {
		return this.resaltarFK_IdClienteOrdenCompra;
	}

	public void setResaltarFK_IdClienteOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdClienteOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdClienteOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdClienteOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioOrdenCompra=null;

	public Border getResaltarFK_IdEjercicioOrdenCompra() {
		return this.resaltarFK_IdEjercicioOrdenCompra;
	}

	public void setResaltarFK_IdEjercicioOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdEjercicioOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoOrdenCompra=null;

	public Border getResaltarFK_IdEmpleadoOrdenCompra() {
		return this.resaltarFK_IdEmpleadoOrdenCompra;
	}

	public void setResaltarFK_IdEmpleadoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaOrdenCompra=null;

	public Border getResaltarFK_IdEmpresaOrdenCompra() {
		return this.resaltarFK_IdEmpresaOrdenCompra;
	}

	public void setResaltarFK_IdEmpresaOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdEstadoOrdenCompraOrdenCompra=null;

	public Border getResaltarFK_IdEstadoOrdenCompraOrdenCompra() {
		return this.resaltarFK_IdEstadoOrdenCompraOrdenCompra;
	}

	public void setResaltarFK_IdEstadoOrdenCompraOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdEstadoOrdenCompraOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdEstadoOrdenCompraOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoOrdenCompraOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdModuloOrdenCompra=null;

	public Border getResaltarFK_IdModuloOrdenCompra() {
		return this.resaltarFK_IdModuloOrdenCompra;
	}

	public void setResaltarFK_IdModuloOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdModuloOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdModuloOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdOrdenCompraOrdenCompra=null;

	public Border getResaltarFK_IdOrdenCompraOrdenCompra() {
		return this.resaltarFK_IdOrdenCompraOrdenCompra;
	}

	public void setResaltarFK_IdOrdenCompraOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdOrdenCompraOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdOrdenCompraOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdOrdenCompraOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoOrdenCompra=null;

	public Border getResaltarFK_IdPeriodoOrdenCompra() {
		return this.resaltarFK_IdPeriodoOrdenCompra;
	}

	public void setResaltarFK_IdPeriodoOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdPeriodoOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdSucursalOrdenCompra=null;

	public Border getResaltarFK_IdSucursalOrdenCompra() {
		return this.resaltarFK_IdSucursalOrdenCompra;
	}

	public void setResaltarFK_IdSucursalOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdSucursalOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdSucursalOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloOrdenCompra=null;

	public Border getResaltarFK_IdTipoTransaccionModuloOrdenCompra() {
		return this.resaltarFK_IdTipoTransaccionModuloOrdenCompra;
	}

	public void setResaltarFK_IdTipoTransaccionModuloOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloOrdenCompra= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioOrdenCompra=null;

	public Border getResaltarFK_IdUsuarioOrdenCompra() {
		return this.resaltarFK_IdUsuarioOrdenCompra;
	}

	public void setResaltarFK_IdUsuarioOrdenCompra(Border borderResaltar) {
		this.resaltarFK_IdUsuarioOrdenCompra= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioOrdenCompra(ParametroGeneralUsuario parametroGeneralUsuario/*OrdenCompraBeanSwingJInternalFrame ordencompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioOrdenCompra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}