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


import com.bydan.erp.inventario.util.TransferenciaConstantesFunciones;
import com.bydan.erp.inventario.util.TransferenciaParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TransferenciaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TransferenciaConstantesFunciones extends TransferenciaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="Transferencia";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="Transferencia"+TransferenciaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TransferenciaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TransferenciaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TransferenciaConstantesFunciones.SCHEMA+"_"+TransferenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TransferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TransferenciaConstantesFunciones.SCHEMA+"_"+TransferenciaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TransferenciaConstantesFunciones.SCHEMA+"_"+TransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TransferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TransferenciaConstantesFunciones.SCHEMA+"_"+TransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TransferenciaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TransferenciaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TransferenciaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TransferenciaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TransferenciaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TransferenciaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Transferencias";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Transferencia";
	public static final String SCLASSWEBTITULO_LOWER="Transferencia";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="Transferencia";
	public static final String OBJECTNAME="transferencia";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="transferencia";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select transferencia from "+TransferenciaConstantesFunciones.SPERSISTENCENAME+" transferencia";
	public static String QUERYSELECTNATIVE="select "+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".version_row,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_empresa,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_sucursal,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_modulo,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_ejercicio,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_periodo,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_anio,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_mes,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_usuario,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".fecha_emision,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".fecha_entrega,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".numero_secuencial,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_moneda,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_tipo_cambio,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_estado_inventario,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_formato,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_transportista,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_empleado,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".descripcion,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".porcentaje_descuento,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".suman,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".ice,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".valor_descuento,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".total_descuento,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".iva,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".stock,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".sub_total,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".total_otro,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".ultimo_costo,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".numero_items,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".retencion,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".total,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".flete,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".impuesto,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".id_asiento_contable,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".numero_comprobante,"+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME+".fecha from "+TransferenciaConstantesFunciones.SCHEMA+"."+TransferenciaConstantesFunciones.TABLENAME;//+" as "+TransferenciaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=true;
	
	
	protected TransferenciaConstantesFuncionesAdditional transferenciaConstantesFuncionesAdditional=null;
	
	public TransferenciaConstantesFuncionesAdditional getTransferenciaConstantesFuncionesAdditional() {
		return this.transferenciaConstantesFuncionesAdditional;
	}
	
	public void setTransferenciaConstantesFuncionesAdditional(TransferenciaConstantesFuncionesAdditional transferenciaConstantesFuncionesAdditional) {
		try {
			this.transferenciaConstantesFuncionesAdditional=transferenciaConstantesFuncionesAdditional;
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
    public static final String IDESTADOINVENTARIO= "id_estado_inventario";
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
    	public static final String LABEL_IDESTADOINVENTARIO= "Estado";
		public static final String LABEL_IDESTADOINVENTARIO_LOWER= "Estado";
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
		
	
	public static String getTransferenciaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDMODULO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDPERIODO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDANIO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDMES)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDUSUARIO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.FECHAEMISION)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.FECHAENTREGA)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_FECHAENTREGA;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.NUMEROSECUENCIAL)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_NUMEROSECUENCIAL;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDMONEDA)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDMONEDA;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDESTADOINVENTARIO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDESTADOINVENTARIO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDFORMATO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDTRANSPORTISTA)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDTRANSPORTISTA;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDEMPLEADO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.DESCRIPCION)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.PORCENTAJEDESCUENTO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_PORCENTAJEDESCUENTO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.SUMAN)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_SUMAN;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.ICE)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_ICE;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.VALORDESCUENTO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_VALORDESCUENTO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.TOTALDESCUENTO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_TOTALDESCUENTO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IVA)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.STOCK)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_STOCK;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.SUBTOTAL)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_SUBTOTAL;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.TOTALOTRO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_TOTALOTRO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.ULTIMOCOSTO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_ULTIMOCOSTO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.NUMEROITEMS)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_NUMEROITEMS;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.RETENCION)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_RETENCION;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.TOTAL)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_TOTAL;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.FLETE)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_FLETE;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IMPUESTO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IMPUESTO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.NUMEROCOMPROBANTE)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_NUMEROCOMPROBANTE;}
		if(sNombreColumna.equals(TransferenciaConstantesFunciones.FECHA)) {sLabelColumna=TransferenciaConstantesFunciones.LABEL_FECHA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getTransferenciaDescripcion(Transferencia transferencia) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(transferencia !=null/* && transferencia.getId()!=0*/) {
			if(transferencia.getId()!=null) {
				sDescripcion=transferencia.getId().toString();
			}//transferenciatransferencia.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTransferenciaDescripcionDetallado(Transferencia transferencia) {
		String sDescripcion="";
			
		sDescripcion+=TransferenciaConstantesFunciones.ID+"=";
		sDescripcion+=transferencia.getId().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=transferencia.getVersionRow().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=transferencia.getid_empresa().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=transferencia.getid_sucursal().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDMODULO+"=";
		sDescripcion+=transferencia.getid_modulo().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=transferencia.getid_ejercicio().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=transferencia.getid_periodo().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDANIO+"=";
		sDescripcion+=transferencia.getid_anio().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDMES+"=";
		sDescripcion+=transferencia.getid_mes().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=transferencia.getid_usuario().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=transferencia.getfecha_emision().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.FECHAENTREGA+"=";
		sDescripcion+=transferencia.getfecha_entrega().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.NUMEROSECUENCIAL+"=";
		sDescripcion+=transferencia.getnumero_secuencial()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDMONEDA+"=";
		sDescripcion+=transferencia.getid_moneda().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=transferencia.getid_tipo_cambio().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDESTADOINVENTARIO+"=";
		sDescripcion+=transferencia.getid_estado_inventario().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=transferencia.getid_formato().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDTRANSPORTISTA+"=";
		sDescripcion+=transferencia.getid_transportista().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=transferencia.getid_empleado().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=transferencia.getdescripcion()+",";
		sDescripcion+=TransferenciaConstantesFunciones.PORCENTAJEDESCUENTO+"=";
		sDescripcion+=transferencia.getporcentaje_descuento().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.SUMAN+"=";
		sDescripcion+=transferencia.getsuman().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.ICE+"=";
		sDescripcion+=transferencia.getice().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.VALORDESCUENTO+"=";
		sDescripcion+=transferencia.getvalor_descuento().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.TOTALDESCUENTO+"=";
		sDescripcion+=transferencia.gettotal_descuento().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IVA+"=";
		sDescripcion+=transferencia.getiva().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.STOCK+"=";
		sDescripcion+=transferencia.getstock().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.SUBTOTAL+"=";
		sDescripcion+=transferencia.getsub_total().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.TOTALOTRO+"=";
		sDescripcion+=transferencia.gettotal_otro().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.ULTIMOCOSTO+"=";
		sDescripcion+=transferencia.getultimo_costo().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.NUMEROITEMS+"=";
		sDescripcion+=transferencia.getnumero_items().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.RETENCION+"=";
		sDescripcion+=transferencia.getretencion().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.TOTAL+"=";
		sDescripcion+=transferencia.gettotal().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.FLETE+"=";
		sDescripcion+=transferencia.getflete().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IMPUESTO+"=";
		sDescripcion+=transferencia.getimpuesto().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=transferencia.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=transferencia.getid_asiento_contable().toString()+",";
		sDescripcion+=TransferenciaConstantesFunciones.NUMEROCOMPROBANTE+"=";
		sDescripcion+=transferencia.getnumero_comprobante()+",";
		sDescripcion+=TransferenciaConstantesFunciones.FECHA+"=";
		sDescripcion+=transferencia.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTransferenciaDescripcion(Transferencia transferencia,String sValor) throws Exception {			
		if(transferencia !=null) {
			//transferenciatransferencia.getId().toString();
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

	public static String getEstadoInventarioDescripcion(EstadoInventario estadoinventario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadoinventario!=null/*&&estadoinventario.getId()>0*/) {
			sDescripcion=EstadoInventarioConstantesFunciones.getEstadoInventarioDescripcion(estadoinventario);
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
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEstadoInventario")) {
			sNombreIndice="Tipo=  Por Estado";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdMoneda")) {
			sNombreIndice="Tipo=  Por Moneda";
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

	public static String getDetalleIndiceFK_IdEstadoInventario(Long id_estado_inventario) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_inventario!=null) {sDetalleIndice+=" Codigo Unico De Estado="+id_estado_inventario.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosTransferencia(Transferencia transferencia,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		transferencia.setnumero_secuencial(transferencia.getnumero_secuencial().trim());
		transferencia.setdescripcion(transferencia.getdescripcion().trim());
		transferencia.setnumero_comprobante(transferencia.getnumero_comprobante().trim());
	}
	
	public static void quitarEspaciosTransferencias(List<Transferencia> transferencias,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(Transferencia transferencia: transferencias) {
			transferencia.setnumero_secuencial(transferencia.getnumero_secuencial().trim());
			transferencia.setdescripcion(transferencia.getdescripcion().trim());
			transferencia.setnumero_comprobante(transferencia.getnumero_comprobante().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransferencia(Transferencia transferencia,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && transferencia.getConCambioAuxiliar()) {
			transferencia.setIsDeleted(transferencia.getIsDeletedAuxiliar());	
			transferencia.setIsNew(transferencia.getIsNewAuxiliar());	
			transferencia.setIsChanged(transferencia.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			transferencia.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			transferencia.setIsDeletedAuxiliar(false);	
			transferencia.setIsNewAuxiliar(false);	
			transferencia.setIsChangedAuxiliar(false);
			
			transferencia.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTransferencias(List<Transferencia> transferencias,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(Transferencia transferencia : transferencias) {
			if(conAsignarBase && transferencia.getConCambioAuxiliar()) {
				transferencia.setIsDeleted(transferencia.getIsDeletedAuxiliar());	
				transferencia.setIsNew(transferencia.getIsNewAuxiliar());	
				transferencia.setIsChanged(transferencia.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				transferencia.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				transferencia.setIsDeletedAuxiliar(false);	
				transferencia.setIsNewAuxiliar(false);	
				transferencia.setIsChangedAuxiliar(false);
				
				transferencia.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTransferencia(Transferencia transferencia,Boolean conEnteros) throws Exception  {
		transferencia.setporcentaje_descuento(0.0);
		transferencia.setsuman(0.0);
		transferencia.setice(0.0);
		transferencia.setvalor_descuento(0.0);
		transferencia.settotal_descuento(0.0);
		transferencia.setiva(0.0);
		transferencia.setstock(0.0);
		transferencia.setsub_total(0.0);
		transferencia.settotal_otro(0.0);
		transferencia.setultimo_costo(0.0);
		transferencia.setnumero_items(0.0);
		transferencia.setretencion(0.0);
		transferencia.settotal(0.0);
		transferencia.setflete(0.0);
		transferencia.setimpuesto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTransferencias(List<Transferencia> transferencias,Boolean conEnteros) throws Exception  {
		
		for(Transferencia transferencia: transferencias) {
			transferencia.setporcentaje_descuento(0.0);
			transferencia.setsuman(0.0);
			transferencia.setice(0.0);
			transferencia.setvalor_descuento(0.0);
			transferencia.settotal_descuento(0.0);
			transferencia.setiva(0.0);
			transferencia.setstock(0.0);
			transferencia.setsub_total(0.0);
			transferencia.settotal_otro(0.0);
			transferencia.setultimo_costo(0.0);
			transferencia.setnumero_items(0.0);
			transferencia.setretencion(0.0);
			transferencia.settotal(0.0);
			transferencia.setflete(0.0);
			transferencia.setimpuesto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTransferencia(List<Transferencia> transferencias,Transferencia transferenciaAux) throws Exception  {
		TransferenciaConstantesFunciones.InicializarValoresTransferencia(transferenciaAux,true);
		
		for(Transferencia transferencia: transferencias) {
			if(transferencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			transferenciaAux.setporcentaje_descuento(transferenciaAux.getporcentaje_descuento()+transferencia.getporcentaje_descuento());			
			transferenciaAux.setsuman(transferenciaAux.getsuman()+transferencia.getsuman());			
			transferenciaAux.setice(transferenciaAux.getice()+transferencia.getice());			
			transferenciaAux.setvalor_descuento(transferenciaAux.getvalor_descuento()+transferencia.getvalor_descuento());			
			transferenciaAux.settotal_descuento(transferenciaAux.gettotal_descuento()+transferencia.gettotal_descuento());			
			transferenciaAux.setiva(transferenciaAux.getiva()+transferencia.getiva());			
			transferenciaAux.setstock(transferenciaAux.getstock()+transferencia.getstock());			
			transferenciaAux.setsub_total(transferenciaAux.getsub_total()+transferencia.getsub_total());			
			transferenciaAux.settotal_otro(transferenciaAux.gettotal_otro()+transferencia.gettotal_otro());			
			transferenciaAux.setultimo_costo(transferenciaAux.getultimo_costo()+transferencia.getultimo_costo());			
			transferenciaAux.setnumero_items(transferenciaAux.getnumero_items()+transferencia.getnumero_items());			
			transferenciaAux.setretencion(transferenciaAux.getretencion()+transferencia.getretencion());			
			transferenciaAux.settotal(transferenciaAux.gettotal()+transferencia.gettotal());			
			transferenciaAux.setflete(transferenciaAux.getflete()+transferencia.getflete());			
			transferenciaAux.setimpuesto(transferenciaAux.getimpuesto()+transferencia.getimpuesto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTransferencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TransferenciaConstantesFunciones.getArrayColumnasGlobalesTransferencia(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTransferencia(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransferenciaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransferenciaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransferenciaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransferenciaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransferenciaConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransferenciaConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransferenciaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransferenciaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransferenciaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransferenciaConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransferenciaConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransferenciaConstantesFunciones.IDUSUARIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TransferenciaConstantesFunciones.IDMONEDA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TransferenciaConstantesFunciones.IDMONEDA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTransferencia(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<Transferencia> transferencias,Transferencia transferencia,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(Transferencia transferenciaAux: transferencias) {
			if(transferenciaAux!=null && transferencia!=null) {
				if((transferenciaAux.getId()==null && transferencia.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(transferenciaAux.getId()!=null && transferencia.getId()!=null){
					if(transferenciaAux.getId().equals(transferencia.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTransferencia(List<Transferencia> transferencias) throws Exception  {
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
	
		for(Transferencia transferencia: transferencias) {			
			if(transferencia.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentaje_descuentoTotal+=transferencia.getporcentaje_descuento();
			sumanTotal+=transferencia.getsuman();
			iceTotal+=transferencia.getice();
			valor_descuentoTotal+=transferencia.getvalor_descuento();
			total_descuentoTotal+=transferencia.gettotal_descuento();
			ivaTotal+=transferencia.getiva();
			stockTotal+=transferencia.getstock();
			sub_totalTotal+=transferencia.getsub_total();
			total_otroTotal+=transferencia.gettotal_otro();
			ultimo_costoTotal+=transferencia.getultimo_costo();
			numero_itemsTotal+=transferencia.getnumero_items();
			retencionTotal+=transferencia.getretencion();
			totalTotal+=transferencia.gettotal();
			fleteTotal+=transferencia.getflete();
			impuestoTotal+=transferencia.getimpuesto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.PORCENTAJEDESCUENTO);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		datoGeneral.setdValorDouble(porcentaje_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.SUMAN);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_SUMAN);
		datoGeneral.setdValorDouble(sumanTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.VALORDESCUENTO);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_VALORDESCUENTO);
		datoGeneral.setdValorDouble(valor_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.TOTALDESCUENTO);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_TOTALDESCUENTO);
		datoGeneral.setdValorDouble(total_descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.STOCK);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_STOCK);
		datoGeneral.setdValorDouble(stockTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.SUBTOTAL);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_SUBTOTAL);
		datoGeneral.setdValorDouble(sub_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.TOTALOTRO);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_TOTALOTRO);
		datoGeneral.setdValorDouble(total_otroTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.ULTIMOCOSTO);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_ULTIMOCOSTO);
		datoGeneral.setdValorDouble(ultimo_costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.NUMEROITEMS);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_NUMEROITEMS);
		datoGeneral.setdValorDouble(numero_itemsTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.RETENCION);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_RETENCION);
		datoGeneral.setdValorDouble(retencionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.TOTAL);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_TOTAL);
		datoGeneral.setdValorDouble(totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.FLETE);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_FLETE);
		datoGeneral.setdValorDouble(fleteTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TransferenciaConstantesFunciones.IMPUESTO);
		datoGeneral.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IMPUESTO);
		datoGeneral.setdValorDouble(impuestoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTransferencia() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_ID, TransferenciaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_VERSIONROW, TransferenciaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDEMPRESA, TransferenciaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDSUCURSAL, TransferenciaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDMODULO, TransferenciaConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDEJERCICIO, TransferenciaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDPERIODO, TransferenciaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDANIO, TransferenciaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDMES, TransferenciaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDUSUARIO, TransferenciaConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_FECHAEMISION, TransferenciaConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_FECHAENTREGA, TransferenciaConstantesFunciones.FECHAENTREGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_NUMEROSECUENCIAL, TransferenciaConstantesFunciones.NUMEROSECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDMONEDA, TransferenciaConstantesFunciones.IDMONEDA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDTIPOCAMBIO, TransferenciaConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDESTADOINVENTARIO, TransferenciaConstantesFunciones.IDESTADOINVENTARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDFORMATO, TransferenciaConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDTRANSPORTISTA, TransferenciaConstantesFunciones.IDTRANSPORTISTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDEMPLEADO, TransferenciaConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_DESCRIPCION, TransferenciaConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_PORCENTAJEDESCUENTO, TransferenciaConstantesFunciones.PORCENTAJEDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_SUMAN, TransferenciaConstantesFunciones.SUMAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_ICE, TransferenciaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_VALORDESCUENTO, TransferenciaConstantesFunciones.VALORDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_TOTALDESCUENTO, TransferenciaConstantesFunciones.TOTALDESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IVA, TransferenciaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_STOCK, TransferenciaConstantesFunciones.STOCK,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_SUBTOTAL, TransferenciaConstantesFunciones.SUBTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_TOTALOTRO, TransferenciaConstantesFunciones.TOTALOTRO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_ULTIMOCOSTO, TransferenciaConstantesFunciones.ULTIMOCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_NUMEROITEMS, TransferenciaConstantesFunciones.NUMEROITEMS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_RETENCION, TransferenciaConstantesFunciones.RETENCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_TOTAL, TransferenciaConstantesFunciones.TOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_FLETE, TransferenciaConstantesFunciones.FLETE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IMPUESTO, TransferenciaConstantesFunciones.IMPUESTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, TransferenciaConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_IDASIENTOCONTABLE, TransferenciaConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_NUMEROCOMPROBANTE, TransferenciaConstantesFunciones.NUMEROCOMPROBANTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TransferenciaConstantesFunciones.LABEL_FECHA, TransferenciaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTransferencia() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.FECHAENTREGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.NUMEROSECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDMONEDA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDESTADOINVENTARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDTRANSPORTISTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.PORCENTAJEDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.SUMAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.VALORDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.TOTALDESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.STOCK;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.SUBTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.TOTALOTRO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.ULTIMOCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.NUMEROITEMS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.RETENCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.TOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.FLETE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IMPUESTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.NUMEROCOMPROBANTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TransferenciaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransferencia() throws Exception  {
		return TransferenciaConstantesFunciones.getTiposSeleccionarTransferencia(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransferencia(Boolean conFk) throws Exception  {
		return TransferenciaConstantesFunciones.getTiposSeleccionarTransferencia(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTransferencia(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_FECHAENTREGA);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_FECHAENTREGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_NUMEROSECUENCIAL);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_NUMEROSECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDMONEDA);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDMONEDA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDESTADOINVENTARIO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDESTADOINVENTARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDTRANSPORTISTA);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDTRANSPORTISTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_SUMAN);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_SUMAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_VALORDESCUENTO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_VALORDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_TOTALDESCUENTO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_TOTALDESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_STOCK);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_STOCK);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_SUBTOTAL);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_SUBTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_TOTALOTRO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_TOTALOTRO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_ULTIMOCOSTO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_ULTIMOCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_NUMEROITEMS);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_NUMEROITEMS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_RETENCION);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_RETENCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_TOTAL);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_TOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_FLETE);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_FLETE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IMPUESTO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IMPUESTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_NUMEROCOMPROBANTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TransferenciaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(TransferenciaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTransferencia(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTransferencia(Transferencia transferenciaAux) throws Exception {
		
			transferenciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transferenciaAux.getEmpresa()));
			transferenciaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(transferenciaAux.getSucursal()));
			transferenciaAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(transferenciaAux.getModulo()));
			transferenciaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(transferenciaAux.getEjercicio()));
			transferenciaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(transferenciaAux.getPeriodo()));
			transferenciaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(transferenciaAux.getAnio()));
			transferenciaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(transferenciaAux.getMes()));
			transferenciaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(transferenciaAux.getUsuario()));
			transferenciaAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(transferenciaAux.getMoneda()));
			transferenciaAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(transferenciaAux.getTipoCambio()));
			transferenciaAux.setestadoinventario_descripcion(EstadoInventarioConstantesFunciones.getEstadoInventarioDescripcion(transferenciaAux.getEstadoInventario()));
			transferenciaAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(transferenciaAux.getFormato()));
			transferenciaAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(transferenciaAux.getTransportista()));
			transferenciaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(transferenciaAux.getEmpleado()));
			transferenciaAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(transferenciaAux.getTipoTransaccionModulo()));
			transferenciaAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(transferenciaAux.getAsientoContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTransferencia(List<Transferencia> transferenciasTemp) throws Exception {
		for(Transferencia transferenciaAux:transferenciasTemp) {
			
			transferenciaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(transferenciaAux.getEmpresa()));
			transferenciaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(transferenciaAux.getSucursal()));
			transferenciaAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(transferenciaAux.getModulo()));
			transferenciaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(transferenciaAux.getEjercicio()));
			transferenciaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(transferenciaAux.getPeriodo()));
			transferenciaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(transferenciaAux.getAnio()));
			transferenciaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(transferenciaAux.getMes()));
			transferenciaAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(transferenciaAux.getUsuario()));
			transferenciaAux.setmoneda_descripcion(MonedaConstantesFunciones.getMonedaDescripcion(transferenciaAux.getMoneda()));
			transferenciaAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(transferenciaAux.getTipoCambio()));
			transferenciaAux.setestadoinventario_descripcion(EstadoInventarioConstantesFunciones.getEstadoInventarioDescripcion(transferenciaAux.getEstadoInventario()));
			transferenciaAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(transferenciaAux.getFormato()));
			transferenciaAux.settransportista_descripcion(TransportistaConstantesFunciones.getTransportistaDescripcion(transferenciaAux.getTransportista()));
			transferenciaAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(transferenciaAux.getEmpleado()));
			transferenciaAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(transferenciaAux.getTipoTransaccionModulo()));
			transferenciaAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(transferenciaAux.getAsientoContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
				classes.add(new Classe(EstadoInventario.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Transportista.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
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
					if(clas.clas.equals(EstadoInventario.class)) {
						classes.add(new Classe(EstadoInventario.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTransferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(EstadoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoInventario.class)); continue;
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

					if(EstadoInventario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoInventario.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransferenciaConstantesFunciones.getClassesRelationshipsOfTransferencia(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTransferencia(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleTransferencia.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleTransferencia.class)) {
						classes.add(new Classe(DetalleTransferencia.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TransferenciaConstantesFunciones.getClassesRelationshipsFromStringsOfTransferencia(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTransferencia(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleTransferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleTransferencia.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleTransferencia.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleTransferencia.class)); continue;
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
	public static void actualizarLista(Transferencia transferencia,List<Transferencia> transferencias,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			Transferencia transferenciaEncontrado=null;
			
			for(Transferencia transferenciaLocal:transferencias) {
				if(transferenciaLocal.getId().equals(transferencia.getId())) {
					transferenciaEncontrado=transferenciaLocal;
					
					transferenciaLocal.setIsChanged(transferencia.getIsChanged());
					transferenciaLocal.setIsNew(transferencia.getIsNew());
					transferenciaLocal.setIsDeleted(transferencia.getIsDeleted());
					
					transferenciaLocal.setGeneralEntityOriginal(transferencia.getGeneralEntityOriginal());
					
					transferenciaLocal.setId(transferencia.getId());	
					transferenciaLocal.setVersionRow(transferencia.getVersionRow());	
					transferenciaLocal.setid_empresa(transferencia.getid_empresa());	
					transferenciaLocal.setid_sucursal(transferencia.getid_sucursal());	
					transferenciaLocal.setid_modulo(transferencia.getid_modulo());	
					transferenciaLocal.setid_ejercicio(transferencia.getid_ejercicio());	
					transferenciaLocal.setid_periodo(transferencia.getid_periodo());	
					transferenciaLocal.setid_anio(transferencia.getid_anio());	
					transferenciaLocal.setid_mes(transferencia.getid_mes());	
					transferenciaLocal.setid_usuario(transferencia.getid_usuario());	
					transferenciaLocal.setfecha_emision(transferencia.getfecha_emision());	
					transferenciaLocal.setfecha_entrega(transferencia.getfecha_entrega());	
					transferenciaLocal.setnumero_secuencial(transferencia.getnumero_secuencial());	
					transferenciaLocal.setid_moneda(transferencia.getid_moneda());	
					transferenciaLocal.setid_tipo_cambio(transferencia.getid_tipo_cambio());	
					transferenciaLocal.setid_estado_inventario(transferencia.getid_estado_inventario());	
					transferenciaLocal.setid_formato(transferencia.getid_formato());	
					transferenciaLocal.setid_transportista(transferencia.getid_transportista());	
					transferenciaLocal.setid_empleado(transferencia.getid_empleado());	
					transferenciaLocal.setdescripcion(transferencia.getdescripcion());	
					transferenciaLocal.setporcentaje_descuento(transferencia.getporcentaje_descuento());	
					transferenciaLocal.setsuman(transferencia.getsuman());	
					transferenciaLocal.setice(transferencia.getice());	
					transferenciaLocal.setvalor_descuento(transferencia.getvalor_descuento());	
					transferenciaLocal.settotal_descuento(transferencia.gettotal_descuento());	
					transferenciaLocal.setiva(transferencia.getiva());	
					transferenciaLocal.setstock(transferencia.getstock());	
					transferenciaLocal.setsub_total(transferencia.getsub_total());	
					transferenciaLocal.settotal_otro(transferencia.gettotal_otro());	
					transferenciaLocal.setultimo_costo(transferencia.getultimo_costo());	
					transferenciaLocal.setnumero_items(transferencia.getnumero_items());	
					transferenciaLocal.setretencion(transferencia.getretencion());	
					transferenciaLocal.settotal(transferencia.gettotal());	
					transferenciaLocal.setflete(transferencia.getflete());	
					transferenciaLocal.setimpuesto(transferencia.getimpuesto());	
					transferenciaLocal.setid_tipo_transaccion_modulo(transferencia.getid_tipo_transaccion_modulo());	
					transferenciaLocal.setid_asiento_contable(transferencia.getid_asiento_contable());	
					transferenciaLocal.setnumero_comprobante(transferencia.getnumero_comprobante());	
					transferenciaLocal.setfecha(transferencia.getfecha());	
					
					
					transferenciaLocal.setDetalleTransferencias(transferencia.getDetalleTransferencias());
					
					existe=true;
					break;
				}
			}
			
			if(!transferencia.getIsDeleted()) {
				if(!existe) {
					transferencias.add(transferencia);
				}
			} else {
				if(transferenciaEncontrado!=null && permiteQuitar)  {
					transferencias.remove(transferenciaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(Transferencia transferencia,List<Transferencia> transferencias) throws Exception {
		try	{			
			for(Transferencia transferenciaLocal:transferencias) {
				if(transferenciaLocal.getId().equals(transferencia.getId())) {
					transferenciaLocal.setIsSelected(transferencia.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTransferencia(List<Transferencia> transferenciasAux) throws Exception {
		//this.transferenciasAux=transferenciasAux;
		
		for(Transferencia transferenciaAux:transferenciasAux) {
			if(transferenciaAux.getIsChanged()) {
				transferenciaAux.setIsChanged(false);
			}		
			
			if(transferenciaAux.getIsNew()) {
				transferenciaAux.setIsNew(false);
			}	
			
			if(transferenciaAux.getIsDeleted()) {
				transferenciaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTransferencia(Transferencia transferenciaAux) throws Exception {
		//this.transferenciaAux=transferenciaAux;
		
			if(transferenciaAux.getIsChanged()) {
				transferenciaAux.setIsChanged(false);
			}		
			
			if(transferenciaAux.getIsNew()) {
				transferenciaAux.setIsNew(false);
			}	
			
			if(transferenciaAux.getIsDeleted()) {
				transferenciaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(Transferencia transferenciaAsignar,Transferencia transferencia) throws Exception {
		transferenciaAsignar.setId(transferencia.getId());	
		transferenciaAsignar.setVersionRow(transferencia.getVersionRow());	
		transferenciaAsignar.setid_empresa(transferencia.getid_empresa());
		transferenciaAsignar.setempresa_descripcion(transferencia.getempresa_descripcion());	
		transferenciaAsignar.setid_sucursal(transferencia.getid_sucursal());
		transferenciaAsignar.setsucursal_descripcion(transferencia.getsucursal_descripcion());	
		transferenciaAsignar.setid_modulo(transferencia.getid_modulo());
		transferenciaAsignar.setmodulo_descripcion(transferencia.getmodulo_descripcion());	
		transferenciaAsignar.setid_ejercicio(transferencia.getid_ejercicio());
		transferenciaAsignar.setejercicio_descripcion(transferencia.getejercicio_descripcion());	
		transferenciaAsignar.setid_periodo(transferencia.getid_periodo());
		transferenciaAsignar.setperiodo_descripcion(transferencia.getperiodo_descripcion());	
		transferenciaAsignar.setid_anio(transferencia.getid_anio());
		transferenciaAsignar.setanio_descripcion(transferencia.getanio_descripcion());	
		transferenciaAsignar.setid_mes(transferencia.getid_mes());
		transferenciaAsignar.setmes_descripcion(transferencia.getmes_descripcion());	
		transferenciaAsignar.setid_usuario(transferencia.getid_usuario());
		transferenciaAsignar.setusuario_descripcion(transferencia.getusuario_descripcion());	
		transferenciaAsignar.setfecha_emision(transferencia.getfecha_emision());	
		transferenciaAsignar.setfecha_entrega(transferencia.getfecha_entrega());	
		transferenciaAsignar.setnumero_secuencial(transferencia.getnumero_secuencial());	
		transferenciaAsignar.setid_moneda(transferencia.getid_moneda());
		transferenciaAsignar.setmoneda_descripcion(transferencia.getmoneda_descripcion());	
		transferenciaAsignar.setid_tipo_cambio(transferencia.getid_tipo_cambio());
		transferenciaAsignar.settipocambio_descripcion(transferencia.gettipocambio_descripcion());	
		transferenciaAsignar.setid_estado_inventario(transferencia.getid_estado_inventario());
		transferenciaAsignar.setestadoinventario_descripcion(transferencia.getestadoinventario_descripcion());	
		transferenciaAsignar.setid_formato(transferencia.getid_formato());
		transferenciaAsignar.setformato_descripcion(transferencia.getformato_descripcion());	
		transferenciaAsignar.setid_transportista(transferencia.getid_transportista());
		transferenciaAsignar.settransportista_descripcion(transferencia.gettransportista_descripcion());	
		transferenciaAsignar.setid_empleado(transferencia.getid_empleado());
		transferenciaAsignar.setempleado_descripcion(transferencia.getempleado_descripcion());	
		transferenciaAsignar.setdescripcion(transferencia.getdescripcion());	
		transferenciaAsignar.setporcentaje_descuento(transferencia.getporcentaje_descuento());	
		transferenciaAsignar.setsuman(transferencia.getsuman());	
		transferenciaAsignar.setice(transferencia.getice());	
		transferenciaAsignar.setvalor_descuento(transferencia.getvalor_descuento());	
		transferenciaAsignar.settotal_descuento(transferencia.gettotal_descuento());	
		transferenciaAsignar.setiva(transferencia.getiva());	
		transferenciaAsignar.setstock(transferencia.getstock());	
		transferenciaAsignar.setsub_total(transferencia.getsub_total());	
		transferenciaAsignar.settotal_otro(transferencia.gettotal_otro());	
		transferenciaAsignar.setultimo_costo(transferencia.getultimo_costo());	
		transferenciaAsignar.setnumero_items(transferencia.getnumero_items());	
		transferenciaAsignar.setretencion(transferencia.getretencion());	
		transferenciaAsignar.settotal(transferencia.gettotal());	
		transferenciaAsignar.setflete(transferencia.getflete());	
		transferenciaAsignar.setimpuesto(transferencia.getimpuesto());	
		transferenciaAsignar.setid_tipo_transaccion_modulo(transferencia.getid_tipo_transaccion_modulo());
		transferenciaAsignar.settipotransaccionmodulo_descripcion(transferencia.gettipotransaccionmodulo_descripcion());	
		transferenciaAsignar.setid_asiento_contable(transferencia.getid_asiento_contable());
		transferenciaAsignar.setasientocontable_descripcion(transferencia.getasientocontable_descripcion());	
		transferenciaAsignar.setnumero_comprobante(transferencia.getnumero_comprobante());	
		transferenciaAsignar.setfecha(transferencia.getfecha());	
	}
	
	public static void inicializarTransferencia(Transferencia transferencia) throws Exception {
		try {
				transferencia.setId(0L);	
					
				transferencia.setid_empresa(-1L);	
				transferencia.setid_sucursal(-1L);	
				transferencia.setid_modulo(-1L);	
				transferencia.setid_ejercicio(-1L);	
				transferencia.setid_periodo(-1L);	
				transferencia.setid_anio(null);	
				transferencia.setid_mes(null);	
				transferencia.setid_usuario(-1L);	
				transferencia.setfecha_emision(new Date());	
				transferencia.setfecha_entrega(new Date());	
				transferencia.setnumero_secuencial("");	
				transferencia.setid_moneda(-1L);	
				transferencia.setid_tipo_cambio(null);	
				transferencia.setid_estado_inventario(-1L);	
				transferencia.setid_formato(-1L);	
				transferencia.setid_transportista(null);	
				transferencia.setid_empleado(-1L);	
				transferencia.setdescripcion("");	
				transferencia.setporcentaje_descuento(0.0);	
				transferencia.setsuman(0.0);	
				transferencia.setice(0.0);	
				transferencia.setvalor_descuento(0.0);	
				transferencia.settotal_descuento(0.0);	
				transferencia.setiva(0.0);	
				transferencia.setstock(0.0);	
				transferencia.setsub_total(0.0);	
				transferencia.settotal_otro(0.0);	
				transferencia.setultimo_costo(0.0);	
				transferencia.setnumero_items(0.0);	
				transferencia.setretencion(0.0);	
				transferencia.settotal(0.0);	
				transferencia.setflete(0.0);	
				transferencia.setimpuesto(0.0);	
				transferencia.setid_tipo_transaccion_modulo(null);	
				transferencia.setid_asiento_contable(null);	
				transferencia.setnumero_comprobante("");	
				transferencia.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTransferencia(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_FECHAENTREGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_NUMEROSECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDMONEDA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDESTADOINVENTARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDTRANSPORTISTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_PORCENTAJEDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_SUMAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_VALORDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_TOTALDESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_STOCK);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_SUBTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_TOTALOTRO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_ULTIMOCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_NUMEROITEMS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_RETENCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_TOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_FLETE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IMPUESTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_NUMEROCOMPROBANTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TransferenciaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTransferencia(String sTipo,Row row,Workbook workbook,Transferencia transferencia,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getfecha_entrega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getnumero_secuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getmoneda_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getestadoinventario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.gettransportista_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getporcentaje_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getsuman());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getvalor_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.gettotal_descuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getstock());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getsub_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.gettotal_otro());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getultimo_costo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getnumero_items());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getretencion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.gettotal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getflete());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getimpuesto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getnumero_comprobante());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(transferencia.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTransferencia=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTransferencia() {
		return this.sFinalQueryTransferencia;
	}
	
	public void setsFinalQueryTransferencia(String sFinalQueryTransferencia) {
		this.sFinalQueryTransferencia= sFinalQueryTransferencia;
	}
	
	public Border resaltarSeleccionarTransferencia=null;
	
	public Border setResaltarSeleccionarTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTransferencia= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTransferencia() {
		return this.resaltarSeleccionarTransferencia;
	}
	
	public void setResaltarSeleccionarTransferencia(Border borderResaltarSeleccionarTransferencia) {
		this.resaltarSeleccionarTransferencia= borderResaltarSeleccionarTransferencia;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTransferencia=null;
	public Boolean mostraridTransferencia=true;
	public Boolean activaridTransferencia=true;

	public Border resaltarid_empresaTransferencia=null;
	public Boolean mostrarid_empresaTransferencia=true;
	public Boolean activarid_empresaTransferencia=true;
	public Boolean cargarid_empresaTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTransferencia=false;//ConEventDepend=true

	public Border resaltarid_sucursalTransferencia=null;
	public Boolean mostrarid_sucursalTransferencia=true;
	public Boolean activarid_sucursalTransferencia=true;
	public Boolean cargarid_sucursalTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalTransferencia=false;//ConEventDepend=true

	public Border resaltarid_moduloTransferencia=null;
	public Boolean mostrarid_moduloTransferencia=true;
	public Boolean activarid_moduloTransferencia=true;
	public Boolean cargarid_moduloTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloTransferencia=false;//ConEventDepend=true

	public Border resaltarid_ejercicioTransferencia=null;
	public Boolean mostrarid_ejercicioTransferencia=true;
	public Boolean activarid_ejercicioTransferencia=true;
	public Boolean cargarid_ejercicioTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioTransferencia=false;//ConEventDepend=true

	public Border resaltarid_periodoTransferencia=null;
	public Boolean mostrarid_periodoTransferencia=true;
	public Boolean activarid_periodoTransferencia=true;
	public Boolean cargarid_periodoTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoTransferencia=false;//ConEventDepend=true

	public Border resaltarid_anioTransferencia=null;
	public Boolean mostrarid_anioTransferencia=true;
	public Boolean activarid_anioTransferencia=false;
	public Boolean cargarid_anioTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioTransferencia=false;//ConEventDepend=true

	public Border resaltarid_mesTransferencia=null;
	public Boolean mostrarid_mesTransferencia=true;
	public Boolean activarid_mesTransferencia=false;
	public Boolean cargarid_mesTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesTransferencia=false;//ConEventDepend=true

	public Border resaltarid_usuarioTransferencia=null;
	public Boolean mostrarid_usuarioTransferencia=true;
	public Boolean activarid_usuarioTransferencia=true;
	public Boolean cargarid_usuarioTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioTransferencia=false;//ConEventDepend=true

	public Border resaltarfecha_emisionTransferencia=null;
	public Boolean mostrarfecha_emisionTransferencia=true;
	public Boolean activarfecha_emisionTransferencia=true;

	public Border resaltarfecha_entregaTransferencia=null;
	public Boolean mostrarfecha_entregaTransferencia=true;
	public Boolean activarfecha_entregaTransferencia=true;

	public Border resaltarnumero_secuencialTransferencia=null;
	public Boolean mostrarnumero_secuencialTransferencia=true;
	public Boolean activarnumero_secuencialTransferencia=false;

	public Border resaltarid_monedaTransferencia=null;
	public Boolean mostrarid_monedaTransferencia=true;
	public Boolean activarid_monedaTransferencia=true;
	public Boolean cargarid_monedaTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_monedaTransferencia=false;//ConEventDepend=true

	public Border resaltarid_tipo_cambioTransferencia=null;
	public Boolean mostrarid_tipo_cambioTransferencia=true;
	public Boolean activarid_tipo_cambioTransferencia=true;
	public Boolean cargarid_tipo_cambioTransferencia=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioTransferencia=false;//ConEventDepend=true

	public Border resaltarid_estado_inventarioTransferencia=null;
	public Boolean mostrarid_estado_inventarioTransferencia=true;
	public Boolean activarid_estado_inventarioTransferencia=false;
	public Boolean cargarid_estado_inventarioTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_inventarioTransferencia=false;//ConEventDepend=true

	public Border resaltarid_formatoTransferencia=null;
	public Boolean mostrarid_formatoTransferencia=true;
	public Boolean activarid_formatoTransferencia=true;
	public Boolean cargarid_formatoTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoTransferencia=false;//ConEventDepend=true

	public Border resaltarid_transportistaTransferencia=null;
	public Boolean mostrarid_transportistaTransferencia=true;
	public Boolean activarid_transportistaTransferencia=true;
	public Boolean cargarid_transportistaTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transportistaTransferencia=false;//ConEventDepend=true

	public Border resaltarid_empleadoTransferencia=null;
	public Boolean mostrarid_empleadoTransferencia=true;
	public Boolean activarid_empleadoTransferencia=true;
	public Boolean cargarid_empleadoTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoTransferencia=false;//ConEventDepend=true

	public Border resaltardescripcionTransferencia=null;
	public Boolean mostrardescripcionTransferencia=true;
	public Boolean activardescripcionTransferencia=true;

	public Border resaltarporcentaje_descuentoTransferencia=null;
	public Boolean mostrarporcentaje_descuentoTransferencia=true;
	public Boolean activarporcentaje_descuentoTransferencia=false;

	public Border resaltarsumanTransferencia=null;
	public Boolean mostrarsumanTransferencia=true;
	public Boolean activarsumanTransferencia=false;

	public Border resaltariceTransferencia=null;
	public Boolean mostrariceTransferencia=true;
	public Boolean activariceTransferencia=false;

	public Border resaltarvalor_descuentoTransferencia=null;
	public Boolean mostrarvalor_descuentoTransferencia=true;
	public Boolean activarvalor_descuentoTransferencia=false;

	public Border resaltartotal_descuentoTransferencia=null;
	public Boolean mostrartotal_descuentoTransferencia=true;
	public Boolean activartotal_descuentoTransferencia=false;

	public Border resaltarivaTransferencia=null;
	public Boolean mostrarivaTransferencia=true;
	public Boolean activarivaTransferencia=false;

	public Border resaltarstockTransferencia=null;
	public Boolean mostrarstockTransferencia=true;
	public Boolean activarstockTransferencia=false;

	public Border resaltarsub_totalTransferencia=null;
	public Boolean mostrarsub_totalTransferencia=true;
	public Boolean activarsub_totalTransferencia=false;

	public Border resaltartotal_otroTransferencia=null;
	public Boolean mostrartotal_otroTransferencia=true;
	public Boolean activartotal_otroTransferencia=false;

	public Border resaltarultimo_costoTransferencia=null;
	public Boolean mostrarultimo_costoTransferencia=true;
	public Boolean activarultimo_costoTransferencia=false;

	public Border resaltarnumero_itemsTransferencia=null;
	public Boolean mostrarnumero_itemsTransferencia=true;
	public Boolean activarnumero_itemsTransferencia=false;

	public Border resaltarretencionTransferencia=null;
	public Boolean mostrarretencionTransferencia=true;
	public Boolean activarretencionTransferencia=false;

	public Border resaltartotalTransferencia=null;
	public Boolean mostrartotalTransferencia=true;
	public Boolean activartotalTransferencia=false;

	public Border resaltarfleteTransferencia=null;
	public Boolean mostrarfleteTransferencia=true;
	public Boolean activarfleteTransferencia=false;

	public Border resaltarimpuestoTransferencia=null;
	public Boolean mostrarimpuestoTransferencia=true;
	public Boolean activarimpuestoTransferencia=false;

	public Border resaltarid_tipo_transaccion_moduloTransferencia=null;
	public Boolean mostrarid_tipo_transaccion_moduloTransferencia=true;
	public Boolean activarid_tipo_transaccion_moduloTransferencia=false;
	public Boolean cargarid_tipo_transaccion_moduloTransferencia=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloTransferencia=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableTransferencia=null;
	public Boolean mostrarid_asiento_contableTransferencia=true;
	public Boolean activarid_asiento_contableTransferencia=false;
	public Boolean cargarid_asiento_contableTransferencia=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableTransferencia=false;//ConEventDepend=true

	public Border resaltarnumero_comprobanteTransferencia=null;
	public Boolean mostrarnumero_comprobanteTransferencia=true;
	public Boolean activarnumero_comprobanteTransferencia=false;

	public Border resaltarfechaTransferencia=null;
	public Boolean mostrarfechaTransferencia=true;
	public Boolean activarfechaTransferencia=false;

	
	

	public Border setResaltaridTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltaridTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTransferencia() {
		return this.resaltaridTransferencia;
	}

	public void setResaltaridTransferencia(Border borderResaltar) {
		this.resaltaridTransferencia= borderResaltar;
	}

	public Boolean getMostraridTransferencia() {
		return this.mostraridTransferencia;
	}

	public void setMostraridTransferencia(Boolean mostraridTransferencia) {
		this.mostraridTransferencia= mostraridTransferencia;
	}

	public Boolean getActivaridTransferencia() {
		return this.activaridTransferencia;
	}

	public void setActivaridTransferencia(Boolean activaridTransferencia) {
		this.activaridTransferencia= activaridTransferencia;
	}

	public Border setResaltarid_empresaTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_empresaTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTransferencia() {
		return this.resaltarid_empresaTransferencia;
	}

	public void setResaltarid_empresaTransferencia(Border borderResaltar) {
		this.resaltarid_empresaTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_empresaTransferencia() {
		return this.mostrarid_empresaTransferencia;
	}

	public void setMostrarid_empresaTransferencia(Boolean mostrarid_empresaTransferencia) {
		this.mostrarid_empresaTransferencia= mostrarid_empresaTransferencia;
	}

	public Boolean getActivarid_empresaTransferencia() {
		return this.activarid_empresaTransferencia;
	}

	public void setActivarid_empresaTransferencia(Boolean activarid_empresaTransferencia) {
		this.activarid_empresaTransferencia= activarid_empresaTransferencia;
	}

	public Boolean getCargarid_empresaTransferencia() {
		return this.cargarid_empresaTransferencia;
	}

	public void setCargarid_empresaTransferencia(Boolean cargarid_empresaTransferencia) {
		this.cargarid_empresaTransferencia= cargarid_empresaTransferencia;
	}

	public Border setResaltarid_sucursalTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_sucursalTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalTransferencia() {
		return this.resaltarid_sucursalTransferencia;
	}

	public void setResaltarid_sucursalTransferencia(Border borderResaltar) {
		this.resaltarid_sucursalTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_sucursalTransferencia() {
		return this.mostrarid_sucursalTransferencia;
	}

	public void setMostrarid_sucursalTransferencia(Boolean mostrarid_sucursalTransferencia) {
		this.mostrarid_sucursalTransferencia= mostrarid_sucursalTransferencia;
	}

	public Boolean getActivarid_sucursalTransferencia() {
		return this.activarid_sucursalTransferencia;
	}

	public void setActivarid_sucursalTransferencia(Boolean activarid_sucursalTransferencia) {
		this.activarid_sucursalTransferencia= activarid_sucursalTransferencia;
	}

	public Boolean getCargarid_sucursalTransferencia() {
		return this.cargarid_sucursalTransferencia;
	}

	public void setCargarid_sucursalTransferencia(Boolean cargarid_sucursalTransferencia) {
		this.cargarid_sucursalTransferencia= cargarid_sucursalTransferencia;
	}

	public Border setResaltarid_moduloTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_moduloTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloTransferencia() {
		return this.resaltarid_moduloTransferencia;
	}

	public void setResaltarid_moduloTransferencia(Border borderResaltar) {
		this.resaltarid_moduloTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_moduloTransferencia() {
		return this.mostrarid_moduloTransferencia;
	}

	public void setMostrarid_moduloTransferencia(Boolean mostrarid_moduloTransferencia) {
		this.mostrarid_moduloTransferencia= mostrarid_moduloTransferencia;
	}

	public Boolean getActivarid_moduloTransferencia() {
		return this.activarid_moduloTransferencia;
	}

	public void setActivarid_moduloTransferencia(Boolean activarid_moduloTransferencia) {
		this.activarid_moduloTransferencia= activarid_moduloTransferencia;
	}

	public Boolean getCargarid_moduloTransferencia() {
		return this.cargarid_moduloTransferencia;
	}

	public void setCargarid_moduloTransferencia(Boolean cargarid_moduloTransferencia) {
		this.cargarid_moduloTransferencia= cargarid_moduloTransferencia;
	}

	public Border setResaltarid_ejercicioTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioTransferencia() {
		return this.resaltarid_ejercicioTransferencia;
	}

	public void setResaltarid_ejercicioTransferencia(Border borderResaltar) {
		this.resaltarid_ejercicioTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioTransferencia() {
		return this.mostrarid_ejercicioTransferencia;
	}

	public void setMostrarid_ejercicioTransferencia(Boolean mostrarid_ejercicioTransferencia) {
		this.mostrarid_ejercicioTransferencia= mostrarid_ejercicioTransferencia;
	}

	public Boolean getActivarid_ejercicioTransferencia() {
		return this.activarid_ejercicioTransferencia;
	}

	public void setActivarid_ejercicioTransferencia(Boolean activarid_ejercicioTransferencia) {
		this.activarid_ejercicioTransferencia= activarid_ejercicioTransferencia;
	}

	public Boolean getCargarid_ejercicioTransferencia() {
		return this.cargarid_ejercicioTransferencia;
	}

	public void setCargarid_ejercicioTransferencia(Boolean cargarid_ejercicioTransferencia) {
		this.cargarid_ejercicioTransferencia= cargarid_ejercicioTransferencia;
	}

	public Border setResaltarid_periodoTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_periodoTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoTransferencia() {
		return this.resaltarid_periodoTransferencia;
	}

	public void setResaltarid_periodoTransferencia(Border borderResaltar) {
		this.resaltarid_periodoTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_periodoTransferencia() {
		return this.mostrarid_periodoTransferencia;
	}

	public void setMostrarid_periodoTransferencia(Boolean mostrarid_periodoTransferencia) {
		this.mostrarid_periodoTransferencia= mostrarid_periodoTransferencia;
	}

	public Boolean getActivarid_periodoTransferencia() {
		return this.activarid_periodoTransferencia;
	}

	public void setActivarid_periodoTransferencia(Boolean activarid_periodoTransferencia) {
		this.activarid_periodoTransferencia= activarid_periodoTransferencia;
	}

	public Boolean getCargarid_periodoTransferencia() {
		return this.cargarid_periodoTransferencia;
	}

	public void setCargarid_periodoTransferencia(Boolean cargarid_periodoTransferencia) {
		this.cargarid_periodoTransferencia= cargarid_periodoTransferencia;
	}

	public Border setResaltarid_anioTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_anioTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioTransferencia() {
		return this.resaltarid_anioTransferencia;
	}

	public void setResaltarid_anioTransferencia(Border borderResaltar) {
		this.resaltarid_anioTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_anioTransferencia() {
		return this.mostrarid_anioTransferencia;
	}

	public void setMostrarid_anioTransferencia(Boolean mostrarid_anioTransferencia) {
		this.mostrarid_anioTransferencia= mostrarid_anioTransferencia;
	}

	public Boolean getActivarid_anioTransferencia() {
		return this.activarid_anioTransferencia;
	}

	public void setActivarid_anioTransferencia(Boolean activarid_anioTransferencia) {
		this.activarid_anioTransferencia= activarid_anioTransferencia;
	}

	public Boolean getCargarid_anioTransferencia() {
		return this.cargarid_anioTransferencia;
	}

	public void setCargarid_anioTransferencia(Boolean cargarid_anioTransferencia) {
		this.cargarid_anioTransferencia= cargarid_anioTransferencia;
	}

	public Border setResaltarid_mesTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_mesTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesTransferencia() {
		return this.resaltarid_mesTransferencia;
	}

	public void setResaltarid_mesTransferencia(Border borderResaltar) {
		this.resaltarid_mesTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_mesTransferencia() {
		return this.mostrarid_mesTransferencia;
	}

	public void setMostrarid_mesTransferencia(Boolean mostrarid_mesTransferencia) {
		this.mostrarid_mesTransferencia= mostrarid_mesTransferencia;
	}

	public Boolean getActivarid_mesTransferencia() {
		return this.activarid_mesTransferencia;
	}

	public void setActivarid_mesTransferencia(Boolean activarid_mesTransferencia) {
		this.activarid_mesTransferencia= activarid_mesTransferencia;
	}

	public Boolean getCargarid_mesTransferencia() {
		return this.cargarid_mesTransferencia;
	}

	public void setCargarid_mesTransferencia(Boolean cargarid_mesTransferencia) {
		this.cargarid_mesTransferencia= cargarid_mesTransferencia;
	}

	public Border setResaltarid_usuarioTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_usuarioTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioTransferencia() {
		return this.resaltarid_usuarioTransferencia;
	}

	public void setResaltarid_usuarioTransferencia(Border borderResaltar) {
		this.resaltarid_usuarioTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_usuarioTransferencia() {
		return this.mostrarid_usuarioTransferencia;
	}

	public void setMostrarid_usuarioTransferencia(Boolean mostrarid_usuarioTransferencia) {
		this.mostrarid_usuarioTransferencia= mostrarid_usuarioTransferencia;
	}

	public Boolean getActivarid_usuarioTransferencia() {
		return this.activarid_usuarioTransferencia;
	}

	public void setActivarid_usuarioTransferencia(Boolean activarid_usuarioTransferencia) {
		this.activarid_usuarioTransferencia= activarid_usuarioTransferencia;
	}

	public Boolean getCargarid_usuarioTransferencia() {
		return this.cargarid_usuarioTransferencia;
	}

	public void setCargarid_usuarioTransferencia(Boolean cargarid_usuarioTransferencia) {
		this.cargarid_usuarioTransferencia= cargarid_usuarioTransferencia;
	}

	public Border setResaltarfecha_emisionTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionTransferencia() {
		return this.resaltarfecha_emisionTransferencia;
	}

	public void setResaltarfecha_emisionTransferencia(Border borderResaltar) {
		this.resaltarfecha_emisionTransferencia= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionTransferencia() {
		return this.mostrarfecha_emisionTransferencia;
	}

	public void setMostrarfecha_emisionTransferencia(Boolean mostrarfecha_emisionTransferencia) {
		this.mostrarfecha_emisionTransferencia= mostrarfecha_emisionTransferencia;
	}

	public Boolean getActivarfecha_emisionTransferencia() {
		return this.activarfecha_emisionTransferencia;
	}

	public void setActivarfecha_emisionTransferencia(Boolean activarfecha_emisionTransferencia) {
		this.activarfecha_emisionTransferencia= activarfecha_emisionTransferencia;
	}

	public Border setResaltarfecha_entregaTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarfecha_entregaTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_entregaTransferencia() {
		return this.resaltarfecha_entregaTransferencia;
	}

	public void setResaltarfecha_entregaTransferencia(Border borderResaltar) {
		this.resaltarfecha_entregaTransferencia= borderResaltar;
	}

	public Boolean getMostrarfecha_entregaTransferencia() {
		return this.mostrarfecha_entregaTransferencia;
	}

	public void setMostrarfecha_entregaTransferencia(Boolean mostrarfecha_entregaTransferencia) {
		this.mostrarfecha_entregaTransferencia= mostrarfecha_entregaTransferencia;
	}

	public Boolean getActivarfecha_entregaTransferencia() {
		return this.activarfecha_entregaTransferencia;
	}

	public void setActivarfecha_entregaTransferencia(Boolean activarfecha_entregaTransferencia) {
		this.activarfecha_entregaTransferencia= activarfecha_entregaTransferencia;
	}

	public Border setResaltarnumero_secuencialTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarnumero_secuencialTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_secuencialTransferencia() {
		return this.resaltarnumero_secuencialTransferencia;
	}

	public void setResaltarnumero_secuencialTransferencia(Border borderResaltar) {
		this.resaltarnumero_secuencialTransferencia= borderResaltar;
	}

	public Boolean getMostrarnumero_secuencialTransferencia() {
		return this.mostrarnumero_secuencialTransferencia;
	}

	public void setMostrarnumero_secuencialTransferencia(Boolean mostrarnumero_secuencialTransferencia) {
		this.mostrarnumero_secuencialTransferencia= mostrarnumero_secuencialTransferencia;
	}

	public Boolean getActivarnumero_secuencialTransferencia() {
		return this.activarnumero_secuencialTransferencia;
	}

	public void setActivarnumero_secuencialTransferencia(Boolean activarnumero_secuencialTransferencia) {
		this.activarnumero_secuencialTransferencia= activarnumero_secuencialTransferencia;
	}

	public Border setResaltarid_monedaTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_monedaTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_monedaTransferencia() {
		return this.resaltarid_monedaTransferencia;
	}

	public void setResaltarid_monedaTransferencia(Border borderResaltar) {
		this.resaltarid_monedaTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_monedaTransferencia() {
		return this.mostrarid_monedaTransferencia;
	}

	public void setMostrarid_monedaTransferencia(Boolean mostrarid_monedaTransferencia) {
		this.mostrarid_monedaTransferencia= mostrarid_monedaTransferencia;
	}

	public Boolean getActivarid_monedaTransferencia() {
		return this.activarid_monedaTransferencia;
	}

	public void setActivarid_monedaTransferencia(Boolean activarid_monedaTransferencia) {
		this.activarid_monedaTransferencia= activarid_monedaTransferencia;
	}

	public Boolean getCargarid_monedaTransferencia() {
		return this.cargarid_monedaTransferencia;
	}

	public void setCargarid_monedaTransferencia(Boolean cargarid_monedaTransferencia) {
		this.cargarid_monedaTransferencia= cargarid_monedaTransferencia;
	}

	public Border setResaltarid_tipo_cambioTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioTransferencia() {
		return this.resaltarid_tipo_cambioTransferencia;
	}

	public void setResaltarid_tipo_cambioTransferencia(Border borderResaltar) {
		this.resaltarid_tipo_cambioTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioTransferencia() {
		return this.mostrarid_tipo_cambioTransferencia;
	}

	public void setMostrarid_tipo_cambioTransferencia(Boolean mostrarid_tipo_cambioTransferencia) {
		this.mostrarid_tipo_cambioTransferencia= mostrarid_tipo_cambioTransferencia;
	}

	public Boolean getActivarid_tipo_cambioTransferencia() {
		return this.activarid_tipo_cambioTransferencia;
	}

	public void setActivarid_tipo_cambioTransferencia(Boolean activarid_tipo_cambioTransferencia) {
		this.activarid_tipo_cambioTransferencia= activarid_tipo_cambioTransferencia;
	}

	public Boolean getCargarid_tipo_cambioTransferencia() {
		return this.cargarid_tipo_cambioTransferencia;
	}

	public void setCargarid_tipo_cambioTransferencia(Boolean cargarid_tipo_cambioTransferencia) {
		this.cargarid_tipo_cambioTransferencia= cargarid_tipo_cambioTransferencia;
	}

	public Border setResaltarid_estado_inventarioTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_estado_inventarioTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_inventarioTransferencia() {
		return this.resaltarid_estado_inventarioTransferencia;
	}

	public void setResaltarid_estado_inventarioTransferencia(Border borderResaltar) {
		this.resaltarid_estado_inventarioTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_estado_inventarioTransferencia() {
		return this.mostrarid_estado_inventarioTransferencia;
	}

	public void setMostrarid_estado_inventarioTransferencia(Boolean mostrarid_estado_inventarioTransferencia) {
		this.mostrarid_estado_inventarioTransferencia= mostrarid_estado_inventarioTransferencia;
	}

	public Boolean getActivarid_estado_inventarioTransferencia() {
		return this.activarid_estado_inventarioTransferencia;
	}

	public void setActivarid_estado_inventarioTransferencia(Boolean activarid_estado_inventarioTransferencia) {
		this.activarid_estado_inventarioTransferencia= activarid_estado_inventarioTransferencia;
	}

	public Boolean getCargarid_estado_inventarioTransferencia() {
		return this.cargarid_estado_inventarioTransferencia;
	}

	public void setCargarid_estado_inventarioTransferencia(Boolean cargarid_estado_inventarioTransferencia) {
		this.cargarid_estado_inventarioTransferencia= cargarid_estado_inventarioTransferencia;
	}

	public Border setResaltarid_formatoTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_formatoTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoTransferencia() {
		return this.resaltarid_formatoTransferencia;
	}

	public void setResaltarid_formatoTransferencia(Border borderResaltar) {
		this.resaltarid_formatoTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_formatoTransferencia() {
		return this.mostrarid_formatoTransferencia;
	}

	public void setMostrarid_formatoTransferencia(Boolean mostrarid_formatoTransferencia) {
		this.mostrarid_formatoTransferencia= mostrarid_formatoTransferencia;
	}

	public Boolean getActivarid_formatoTransferencia() {
		return this.activarid_formatoTransferencia;
	}

	public void setActivarid_formatoTransferencia(Boolean activarid_formatoTransferencia) {
		this.activarid_formatoTransferencia= activarid_formatoTransferencia;
	}

	public Boolean getCargarid_formatoTransferencia() {
		return this.cargarid_formatoTransferencia;
	}

	public void setCargarid_formatoTransferencia(Boolean cargarid_formatoTransferencia) {
		this.cargarid_formatoTransferencia= cargarid_formatoTransferencia;
	}

	public Border setResaltarid_transportistaTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_transportistaTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transportistaTransferencia() {
		return this.resaltarid_transportistaTransferencia;
	}

	public void setResaltarid_transportistaTransferencia(Border borderResaltar) {
		this.resaltarid_transportistaTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_transportistaTransferencia() {
		return this.mostrarid_transportistaTransferencia;
	}

	public void setMostrarid_transportistaTransferencia(Boolean mostrarid_transportistaTransferencia) {
		this.mostrarid_transportistaTransferencia= mostrarid_transportistaTransferencia;
	}

	public Boolean getActivarid_transportistaTransferencia() {
		return this.activarid_transportistaTransferencia;
	}

	public void setActivarid_transportistaTransferencia(Boolean activarid_transportistaTransferencia) {
		this.activarid_transportistaTransferencia= activarid_transportistaTransferencia;
	}

	public Boolean getCargarid_transportistaTransferencia() {
		return this.cargarid_transportistaTransferencia;
	}

	public void setCargarid_transportistaTransferencia(Boolean cargarid_transportistaTransferencia) {
		this.cargarid_transportistaTransferencia= cargarid_transportistaTransferencia;
	}

	public Border setResaltarid_empleadoTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_empleadoTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoTransferencia() {
		return this.resaltarid_empleadoTransferencia;
	}

	public void setResaltarid_empleadoTransferencia(Border borderResaltar) {
		this.resaltarid_empleadoTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_empleadoTransferencia() {
		return this.mostrarid_empleadoTransferencia;
	}

	public void setMostrarid_empleadoTransferencia(Boolean mostrarid_empleadoTransferencia) {
		this.mostrarid_empleadoTransferencia= mostrarid_empleadoTransferencia;
	}

	public Boolean getActivarid_empleadoTransferencia() {
		return this.activarid_empleadoTransferencia;
	}

	public void setActivarid_empleadoTransferencia(Boolean activarid_empleadoTransferencia) {
		this.activarid_empleadoTransferencia= activarid_empleadoTransferencia;
	}

	public Boolean getCargarid_empleadoTransferencia() {
		return this.cargarid_empleadoTransferencia;
	}

	public void setCargarid_empleadoTransferencia(Boolean cargarid_empleadoTransferencia) {
		this.cargarid_empleadoTransferencia= cargarid_empleadoTransferencia;
	}

	public Border setResaltardescripcionTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltardescripcionTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionTransferencia() {
		return this.resaltardescripcionTransferencia;
	}

	public void setResaltardescripcionTransferencia(Border borderResaltar) {
		this.resaltardescripcionTransferencia= borderResaltar;
	}

	public Boolean getMostrardescripcionTransferencia() {
		return this.mostrardescripcionTransferencia;
	}

	public void setMostrardescripcionTransferencia(Boolean mostrardescripcionTransferencia) {
		this.mostrardescripcionTransferencia= mostrardescripcionTransferencia;
	}

	public Boolean getActivardescripcionTransferencia() {
		return this.activardescripcionTransferencia;
	}

	public void setActivardescripcionTransferencia(Boolean activardescripcionTransferencia) {
		this.activardescripcionTransferencia= activardescripcionTransferencia;
	}

	public Border setResaltarporcentaje_descuentoTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarporcentaje_descuentoTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_descuentoTransferencia() {
		return this.resaltarporcentaje_descuentoTransferencia;
	}

	public void setResaltarporcentaje_descuentoTransferencia(Border borderResaltar) {
		this.resaltarporcentaje_descuentoTransferencia= borderResaltar;
	}

	public Boolean getMostrarporcentaje_descuentoTransferencia() {
		return this.mostrarporcentaje_descuentoTransferencia;
	}

	public void setMostrarporcentaje_descuentoTransferencia(Boolean mostrarporcentaje_descuentoTransferencia) {
		this.mostrarporcentaje_descuentoTransferencia= mostrarporcentaje_descuentoTransferencia;
	}

	public Boolean getActivarporcentaje_descuentoTransferencia() {
		return this.activarporcentaje_descuentoTransferencia;
	}

	public void setActivarporcentaje_descuentoTransferencia(Boolean activarporcentaje_descuentoTransferencia) {
		this.activarporcentaje_descuentoTransferencia= activarporcentaje_descuentoTransferencia;
	}

	public Border setResaltarsumanTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarsumanTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsumanTransferencia() {
		return this.resaltarsumanTransferencia;
	}

	public void setResaltarsumanTransferencia(Border borderResaltar) {
		this.resaltarsumanTransferencia= borderResaltar;
	}

	public Boolean getMostrarsumanTransferencia() {
		return this.mostrarsumanTransferencia;
	}

	public void setMostrarsumanTransferencia(Boolean mostrarsumanTransferencia) {
		this.mostrarsumanTransferencia= mostrarsumanTransferencia;
	}

	public Boolean getActivarsumanTransferencia() {
		return this.activarsumanTransferencia;
	}

	public void setActivarsumanTransferencia(Boolean activarsumanTransferencia) {
		this.activarsumanTransferencia= activarsumanTransferencia;
	}

	public Border setResaltariceTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltariceTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceTransferencia() {
		return this.resaltariceTransferencia;
	}

	public void setResaltariceTransferencia(Border borderResaltar) {
		this.resaltariceTransferencia= borderResaltar;
	}

	public Boolean getMostrariceTransferencia() {
		return this.mostrariceTransferencia;
	}

	public void setMostrariceTransferencia(Boolean mostrariceTransferencia) {
		this.mostrariceTransferencia= mostrariceTransferencia;
	}

	public Boolean getActivariceTransferencia() {
		return this.activariceTransferencia;
	}

	public void setActivariceTransferencia(Boolean activariceTransferencia) {
		this.activariceTransferencia= activariceTransferencia;
	}

	public Border setResaltarvalor_descuentoTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarvalor_descuentoTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_descuentoTransferencia() {
		return this.resaltarvalor_descuentoTransferencia;
	}

	public void setResaltarvalor_descuentoTransferencia(Border borderResaltar) {
		this.resaltarvalor_descuentoTransferencia= borderResaltar;
	}

	public Boolean getMostrarvalor_descuentoTransferencia() {
		return this.mostrarvalor_descuentoTransferencia;
	}

	public void setMostrarvalor_descuentoTransferencia(Boolean mostrarvalor_descuentoTransferencia) {
		this.mostrarvalor_descuentoTransferencia= mostrarvalor_descuentoTransferencia;
	}

	public Boolean getActivarvalor_descuentoTransferencia() {
		return this.activarvalor_descuentoTransferencia;
	}

	public void setActivarvalor_descuentoTransferencia(Boolean activarvalor_descuentoTransferencia) {
		this.activarvalor_descuentoTransferencia= activarvalor_descuentoTransferencia;
	}

	public Border setResaltartotal_descuentoTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltartotal_descuentoTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_descuentoTransferencia() {
		return this.resaltartotal_descuentoTransferencia;
	}

	public void setResaltartotal_descuentoTransferencia(Border borderResaltar) {
		this.resaltartotal_descuentoTransferencia= borderResaltar;
	}

	public Boolean getMostrartotal_descuentoTransferencia() {
		return this.mostrartotal_descuentoTransferencia;
	}

	public void setMostrartotal_descuentoTransferencia(Boolean mostrartotal_descuentoTransferencia) {
		this.mostrartotal_descuentoTransferencia= mostrartotal_descuentoTransferencia;
	}

	public Boolean getActivartotal_descuentoTransferencia() {
		return this.activartotal_descuentoTransferencia;
	}

	public void setActivartotal_descuentoTransferencia(Boolean activartotal_descuentoTransferencia) {
		this.activartotal_descuentoTransferencia= activartotal_descuentoTransferencia;
	}

	public Border setResaltarivaTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarivaTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaTransferencia() {
		return this.resaltarivaTransferencia;
	}

	public void setResaltarivaTransferencia(Border borderResaltar) {
		this.resaltarivaTransferencia= borderResaltar;
	}

	public Boolean getMostrarivaTransferencia() {
		return this.mostrarivaTransferencia;
	}

	public void setMostrarivaTransferencia(Boolean mostrarivaTransferencia) {
		this.mostrarivaTransferencia= mostrarivaTransferencia;
	}

	public Boolean getActivarivaTransferencia() {
		return this.activarivaTransferencia;
	}

	public void setActivarivaTransferencia(Boolean activarivaTransferencia) {
		this.activarivaTransferencia= activarivaTransferencia;
	}

	public Border setResaltarstockTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarstockTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarstockTransferencia() {
		return this.resaltarstockTransferencia;
	}

	public void setResaltarstockTransferencia(Border borderResaltar) {
		this.resaltarstockTransferencia= borderResaltar;
	}

	public Boolean getMostrarstockTransferencia() {
		return this.mostrarstockTransferencia;
	}

	public void setMostrarstockTransferencia(Boolean mostrarstockTransferencia) {
		this.mostrarstockTransferencia= mostrarstockTransferencia;
	}

	public Boolean getActivarstockTransferencia() {
		return this.activarstockTransferencia;
	}

	public void setActivarstockTransferencia(Boolean activarstockTransferencia) {
		this.activarstockTransferencia= activarstockTransferencia;
	}

	public Border setResaltarsub_totalTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarsub_totalTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsub_totalTransferencia() {
		return this.resaltarsub_totalTransferencia;
	}

	public void setResaltarsub_totalTransferencia(Border borderResaltar) {
		this.resaltarsub_totalTransferencia= borderResaltar;
	}

	public Boolean getMostrarsub_totalTransferencia() {
		return this.mostrarsub_totalTransferencia;
	}

	public void setMostrarsub_totalTransferencia(Boolean mostrarsub_totalTransferencia) {
		this.mostrarsub_totalTransferencia= mostrarsub_totalTransferencia;
	}

	public Boolean getActivarsub_totalTransferencia() {
		return this.activarsub_totalTransferencia;
	}

	public void setActivarsub_totalTransferencia(Boolean activarsub_totalTransferencia) {
		this.activarsub_totalTransferencia= activarsub_totalTransferencia;
	}

	public Border setResaltartotal_otroTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltartotal_otroTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotal_otroTransferencia() {
		return this.resaltartotal_otroTransferencia;
	}

	public void setResaltartotal_otroTransferencia(Border borderResaltar) {
		this.resaltartotal_otroTransferencia= borderResaltar;
	}

	public Boolean getMostrartotal_otroTransferencia() {
		return this.mostrartotal_otroTransferencia;
	}

	public void setMostrartotal_otroTransferencia(Boolean mostrartotal_otroTransferencia) {
		this.mostrartotal_otroTransferencia= mostrartotal_otroTransferencia;
	}

	public Boolean getActivartotal_otroTransferencia() {
		return this.activartotal_otroTransferencia;
	}

	public void setActivartotal_otroTransferencia(Boolean activartotal_otroTransferencia) {
		this.activartotal_otroTransferencia= activartotal_otroTransferencia;
	}

	public Border setResaltarultimo_costoTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarultimo_costoTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarultimo_costoTransferencia() {
		return this.resaltarultimo_costoTransferencia;
	}

	public void setResaltarultimo_costoTransferencia(Border borderResaltar) {
		this.resaltarultimo_costoTransferencia= borderResaltar;
	}

	public Boolean getMostrarultimo_costoTransferencia() {
		return this.mostrarultimo_costoTransferencia;
	}

	public void setMostrarultimo_costoTransferencia(Boolean mostrarultimo_costoTransferencia) {
		this.mostrarultimo_costoTransferencia= mostrarultimo_costoTransferencia;
	}

	public Boolean getActivarultimo_costoTransferencia() {
		return this.activarultimo_costoTransferencia;
	}

	public void setActivarultimo_costoTransferencia(Boolean activarultimo_costoTransferencia) {
		this.activarultimo_costoTransferencia= activarultimo_costoTransferencia;
	}

	public Border setResaltarnumero_itemsTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarnumero_itemsTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_itemsTransferencia() {
		return this.resaltarnumero_itemsTransferencia;
	}

	public void setResaltarnumero_itemsTransferencia(Border borderResaltar) {
		this.resaltarnumero_itemsTransferencia= borderResaltar;
	}

	public Boolean getMostrarnumero_itemsTransferencia() {
		return this.mostrarnumero_itemsTransferencia;
	}

	public void setMostrarnumero_itemsTransferencia(Boolean mostrarnumero_itemsTransferencia) {
		this.mostrarnumero_itemsTransferencia= mostrarnumero_itemsTransferencia;
	}

	public Boolean getActivarnumero_itemsTransferencia() {
		return this.activarnumero_itemsTransferencia;
	}

	public void setActivarnumero_itemsTransferencia(Boolean activarnumero_itemsTransferencia) {
		this.activarnumero_itemsTransferencia= activarnumero_itemsTransferencia;
	}

	public Border setResaltarretencionTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarretencionTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarretencionTransferencia() {
		return this.resaltarretencionTransferencia;
	}

	public void setResaltarretencionTransferencia(Border borderResaltar) {
		this.resaltarretencionTransferencia= borderResaltar;
	}

	public Boolean getMostrarretencionTransferencia() {
		return this.mostrarretencionTransferencia;
	}

	public void setMostrarretencionTransferencia(Boolean mostrarretencionTransferencia) {
		this.mostrarretencionTransferencia= mostrarretencionTransferencia;
	}

	public Boolean getActivarretencionTransferencia() {
		return this.activarretencionTransferencia;
	}

	public void setActivarretencionTransferencia(Boolean activarretencionTransferencia) {
		this.activarretencionTransferencia= activarretencionTransferencia;
	}

	public Border setResaltartotalTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltartotalTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartotalTransferencia() {
		return this.resaltartotalTransferencia;
	}

	public void setResaltartotalTransferencia(Border borderResaltar) {
		this.resaltartotalTransferencia= borderResaltar;
	}

	public Boolean getMostrartotalTransferencia() {
		return this.mostrartotalTransferencia;
	}

	public void setMostrartotalTransferencia(Boolean mostrartotalTransferencia) {
		this.mostrartotalTransferencia= mostrartotalTransferencia;
	}

	public Boolean getActivartotalTransferencia() {
		return this.activartotalTransferencia;
	}

	public void setActivartotalTransferencia(Boolean activartotalTransferencia) {
		this.activartotalTransferencia= activartotalTransferencia;
	}

	public Border setResaltarfleteTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarfleteTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfleteTransferencia() {
		return this.resaltarfleteTransferencia;
	}

	public void setResaltarfleteTransferencia(Border borderResaltar) {
		this.resaltarfleteTransferencia= borderResaltar;
	}

	public Boolean getMostrarfleteTransferencia() {
		return this.mostrarfleteTransferencia;
	}

	public void setMostrarfleteTransferencia(Boolean mostrarfleteTransferencia) {
		this.mostrarfleteTransferencia= mostrarfleteTransferencia;
	}

	public Boolean getActivarfleteTransferencia() {
		return this.activarfleteTransferencia;
	}

	public void setActivarfleteTransferencia(Boolean activarfleteTransferencia) {
		this.activarfleteTransferencia= activarfleteTransferencia;
	}

	public Border setResaltarimpuestoTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarimpuestoTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarimpuestoTransferencia() {
		return this.resaltarimpuestoTransferencia;
	}

	public void setResaltarimpuestoTransferencia(Border borderResaltar) {
		this.resaltarimpuestoTransferencia= borderResaltar;
	}

	public Boolean getMostrarimpuestoTransferencia() {
		return this.mostrarimpuestoTransferencia;
	}

	public void setMostrarimpuestoTransferencia(Boolean mostrarimpuestoTransferencia) {
		this.mostrarimpuestoTransferencia= mostrarimpuestoTransferencia;
	}

	public Boolean getActivarimpuestoTransferencia() {
		return this.activarimpuestoTransferencia;
	}

	public void setActivarimpuestoTransferencia(Boolean activarimpuestoTransferencia) {
		this.activarimpuestoTransferencia= activarimpuestoTransferencia;
	}

	public Border setResaltarid_tipo_transaccion_moduloTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloTransferencia() {
		return this.resaltarid_tipo_transaccion_moduloTransferencia;
	}

	public void setResaltarid_tipo_transaccion_moduloTransferencia(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloTransferencia() {
		return this.mostrarid_tipo_transaccion_moduloTransferencia;
	}

	public void setMostrarid_tipo_transaccion_moduloTransferencia(Boolean mostrarid_tipo_transaccion_moduloTransferencia) {
		this.mostrarid_tipo_transaccion_moduloTransferencia= mostrarid_tipo_transaccion_moduloTransferencia;
	}

	public Boolean getActivarid_tipo_transaccion_moduloTransferencia() {
		return this.activarid_tipo_transaccion_moduloTransferencia;
	}

	public void setActivarid_tipo_transaccion_moduloTransferencia(Boolean activarid_tipo_transaccion_moduloTransferencia) {
		this.activarid_tipo_transaccion_moduloTransferencia= activarid_tipo_transaccion_moduloTransferencia;
	}

	public Boolean getCargarid_tipo_transaccion_moduloTransferencia() {
		return this.cargarid_tipo_transaccion_moduloTransferencia;
	}

	public void setCargarid_tipo_transaccion_moduloTransferencia(Boolean cargarid_tipo_transaccion_moduloTransferencia) {
		this.cargarid_tipo_transaccion_moduloTransferencia= cargarid_tipo_transaccion_moduloTransferencia;
	}

	public Border setResaltarid_asiento_contableTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableTransferencia() {
		return this.resaltarid_asiento_contableTransferencia;
	}

	public void setResaltarid_asiento_contableTransferencia(Border borderResaltar) {
		this.resaltarid_asiento_contableTransferencia= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableTransferencia() {
		return this.mostrarid_asiento_contableTransferencia;
	}

	public void setMostrarid_asiento_contableTransferencia(Boolean mostrarid_asiento_contableTransferencia) {
		this.mostrarid_asiento_contableTransferencia= mostrarid_asiento_contableTransferencia;
	}

	public Boolean getActivarid_asiento_contableTransferencia() {
		return this.activarid_asiento_contableTransferencia;
	}

	public void setActivarid_asiento_contableTransferencia(Boolean activarid_asiento_contableTransferencia) {
		this.activarid_asiento_contableTransferencia= activarid_asiento_contableTransferencia;
	}

	public Boolean getCargarid_asiento_contableTransferencia() {
		return this.cargarid_asiento_contableTransferencia;
	}

	public void setCargarid_asiento_contableTransferencia(Boolean cargarid_asiento_contableTransferencia) {
		this.cargarid_asiento_contableTransferencia= cargarid_asiento_contableTransferencia;
	}

	public Border setResaltarnumero_comprobanteTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarnumero_comprobanteTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_comprobanteTransferencia() {
		return this.resaltarnumero_comprobanteTransferencia;
	}

	public void setResaltarnumero_comprobanteTransferencia(Border borderResaltar) {
		this.resaltarnumero_comprobanteTransferencia= borderResaltar;
	}

	public Boolean getMostrarnumero_comprobanteTransferencia() {
		return this.mostrarnumero_comprobanteTransferencia;
	}

	public void setMostrarnumero_comprobanteTransferencia(Boolean mostrarnumero_comprobanteTransferencia) {
		this.mostrarnumero_comprobanteTransferencia= mostrarnumero_comprobanteTransferencia;
	}

	public Boolean getActivarnumero_comprobanteTransferencia() {
		return this.activarnumero_comprobanteTransferencia;
	}

	public void setActivarnumero_comprobanteTransferencia(Boolean activarnumero_comprobanteTransferencia) {
		this.activarnumero_comprobanteTransferencia= activarnumero_comprobanteTransferencia;
	}

	public Border setResaltarfechaTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltar);
		
		this.resaltarfechaTransferencia= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaTransferencia() {
		return this.resaltarfechaTransferencia;
	}

	public void setResaltarfechaTransferencia(Border borderResaltar) {
		this.resaltarfechaTransferencia= borderResaltar;
	}

	public Boolean getMostrarfechaTransferencia() {
		return this.mostrarfechaTransferencia;
	}

	public void setMostrarfechaTransferencia(Boolean mostrarfechaTransferencia) {
		this.mostrarfechaTransferencia= mostrarfechaTransferencia;
	}

	public Boolean getActivarfechaTransferencia() {
		return this.activarfechaTransferencia;
	}

	public void setActivarfechaTransferencia(Boolean activarfechaTransferencia) {
		this.activarfechaTransferencia= activarfechaTransferencia;
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
		
		
		this.setMostraridTransferencia(esInicial);
		this.setMostrarid_empresaTransferencia(esInicial);
		this.setMostrarid_sucursalTransferencia(esInicial);
		this.setMostrarid_moduloTransferencia(esInicial);
		this.setMostrarid_ejercicioTransferencia(esInicial);
		this.setMostrarid_periodoTransferencia(esInicial);
		this.setMostrarid_anioTransferencia(esInicial);
		this.setMostrarid_mesTransferencia(esInicial);
		this.setMostrarid_usuarioTransferencia(esInicial);
		this.setMostrarfecha_emisionTransferencia(esInicial);
		this.setMostrarfecha_entregaTransferencia(esInicial);
		this.setMostrarnumero_secuencialTransferencia(esInicial);
		this.setMostrarid_monedaTransferencia(esInicial);
		this.setMostrarid_tipo_cambioTransferencia(esInicial);
		this.setMostrarid_estado_inventarioTransferencia(esInicial);
		this.setMostrarid_formatoTransferencia(esInicial);
		this.setMostrarid_transportistaTransferencia(esInicial);
		this.setMostrarid_empleadoTransferencia(esInicial);
		this.setMostrardescripcionTransferencia(esInicial);
		this.setMostrarporcentaje_descuentoTransferencia(esInicial);
		this.setMostrarsumanTransferencia(esInicial);
		this.setMostrariceTransferencia(esInicial);
		this.setMostrarvalor_descuentoTransferencia(esInicial);
		this.setMostrartotal_descuentoTransferencia(esInicial);
		this.setMostrarivaTransferencia(esInicial);
		this.setMostrarstockTransferencia(esInicial);
		this.setMostrarsub_totalTransferencia(esInicial);
		this.setMostrartotal_otroTransferencia(esInicial);
		this.setMostrarultimo_costoTransferencia(esInicial);
		this.setMostrarnumero_itemsTransferencia(esInicial);
		this.setMostrarretencionTransferencia(esInicial);
		this.setMostrartotalTransferencia(esInicial);
		this.setMostrarfleteTransferencia(esInicial);
		this.setMostrarimpuestoTransferencia(esInicial);
		this.setMostrarid_tipo_transaccion_moduloTransferencia(esInicial);
		this.setMostrarid_asiento_contableTransferencia(esInicial);
		this.setMostrarnumero_comprobanteTransferencia(esInicial);
		this.setMostrarfechaTransferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransferenciaConstantesFunciones.ID)) {
				this.setMostraridTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.FECHAENTREGA)) {
				this.setMostrarfecha_entregaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setMostrarnumero_secuencialTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDMONEDA)) {
				this.setMostrarid_monedaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDESTADOINVENTARIO)) {
				this.setMostrarid_estado_inventarioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDTRANSPORTISTA)) {
				this.setMostrarid_transportistaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setMostrarporcentaje_descuentoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.SUMAN)) {
				this.setMostrarsumanTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.ICE)) {
				this.setMostrariceTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.VALORDESCUENTO)) {
				this.setMostrarvalor_descuentoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.TOTALDESCUENTO)) {
				this.setMostrartotal_descuentoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IVA)) {
				this.setMostrarivaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.STOCK)) {
				this.setMostrarstockTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.SUBTOTAL)) {
				this.setMostrarsub_totalTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.TOTALOTRO)) {
				this.setMostrartotal_otroTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.ULTIMOCOSTO)) {
				this.setMostrarultimo_costoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.NUMEROITEMS)) {
				this.setMostrarnumero_itemsTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.RETENCION)) {
				this.setMostrarretencionTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.TOTAL)) {
				this.setMostrartotalTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.FLETE)) {
				this.setMostrarfleteTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IMPUESTO)) {
				this.setMostrarimpuestoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setMostrarnumero_comprobanteTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.FECHA)) {
				this.setMostrarfechaTransferencia(esAsigna);
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
		
		
		this.setActivaridTransferencia(esInicial);
		this.setActivarid_empresaTransferencia(esInicial);
		this.setActivarid_sucursalTransferencia(esInicial);
		this.setActivarid_moduloTransferencia(esInicial);
		this.setActivarid_ejercicioTransferencia(esInicial);
		this.setActivarid_periodoTransferencia(esInicial);
		this.setActivarid_anioTransferencia(esInicial);
		this.setActivarid_mesTransferencia(esInicial);
		this.setActivarid_usuarioTransferencia(esInicial);
		this.setActivarfecha_emisionTransferencia(esInicial);
		this.setActivarfecha_entregaTransferencia(esInicial);
		this.setActivarnumero_secuencialTransferencia(esInicial);
		this.setActivarid_monedaTransferencia(esInicial);
		this.setActivarid_tipo_cambioTransferencia(esInicial);
		this.setActivarid_estado_inventarioTransferencia(esInicial);
		this.setActivarid_formatoTransferencia(esInicial);
		this.setActivarid_transportistaTransferencia(esInicial);
		this.setActivarid_empleadoTransferencia(esInicial);
		this.setActivardescripcionTransferencia(esInicial);
		this.setActivarporcentaje_descuentoTransferencia(esInicial);
		this.setActivarsumanTransferencia(esInicial);
		this.setActivariceTransferencia(esInicial);
		this.setActivarvalor_descuentoTransferencia(esInicial);
		this.setActivartotal_descuentoTransferencia(esInicial);
		this.setActivarivaTransferencia(esInicial);
		this.setActivarstockTransferencia(esInicial);
		this.setActivarsub_totalTransferencia(esInicial);
		this.setActivartotal_otroTransferencia(esInicial);
		this.setActivarultimo_costoTransferencia(esInicial);
		this.setActivarnumero_itemsTransferencia(esInicial);
		this.setActivarretencionTransferencia(esInicial);
		this.setActivartotalTransferencia(esInicial);
		this.setActivarfleteTransferencia(esInicial);
		this.setActivarimpuestoTransferencia(esInicial);
		this.setActivarid_tipo_transaccion_moduloTransferencia(esInicial);
		this.setActivarid_asiento_contableTransferencia(esInicial);
		this.setActivarnumero_comprobanteTransferencia(esInicial);
		this.setActivarfechaTransferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransferenciaConstantesFunciones.ID)) {
				this.setActivaridTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDMES)) {
				this.setActivarid_mesTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.FECHAENTREGA)) {
				this.setActivarfecha_entregaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setActivarnumero_secuencialTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDMONEDA)) {
				this.setActivarid_monedaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDESTADOINVENTARIO)) {
				this.setActivarid_estado_inventarioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDTRANSPORTISTA)) {
				this.setActivarid_transportistaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setActivarporcentaje_descuentoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.SUMAN)) {
				this.setActivarsumanTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.ICE)) {
				this.setActivariceTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.VALORDESCUENTO)) {
				this.setActivarvalor_descuentoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.TOTALDESCUENTO)) {
				this.setActivartotal_descuentoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IVA)) {
				this.setActivarivaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.STOCK)) {
				this.setActivarstockTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.SUBTOTAL)) {
				this.setActivarsub_totalTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.TOTALOTRO)) {
				this.setActivartotal_otroTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.ULTIMOCOSTO)) {
				this.setActivarultimo_costoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.NUMEROITEMS)) {
				this.setActivarnumero_itemsTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.RETENCION)) {
				this.setActivarretencionTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.TOTAL)) {
				this.setActivartotalTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.FLETE)) {
				this.setActivarfleteTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IMPUESTO)) {
				this.setActivarimpuestoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setActivarnumero_comprobanteTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.FECHA)) {
				this.setActivarfechaTransferencia(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTransferencia(esInicial);
		this.setResaltarid_empresaTransferencia(esInicial);
		this.setResaltarid_sucursalTransferencia(esInicial);
		this.setResaltarid_moduloTransferencia(esInicial);
		this.setResaltarid_ejercicioTransferencia(esInicial);
		this.setResaltarid_periodoTransferencia(esInicial);
		this.setResaltarid_anioTransferencia(esInicial);
		this.setResaltarid_mesTransferencia(esInicial);
		this.setResaltarid_usuarioTransferencia(esInicial);
		this.setResaltarfecha_emisionTransferencia(esInicial);
		this.setResaltarfecha_entregaTransferencia(esInicial);
		this.setResaltarnumero_secuencialTransferencia(esInicial);
		this.setResaltarid_monedaTransferencia(esInicial);
		this.setResaltarid_tipo_cambioTransferencia(esInicial);
		this.setResaltarid_estado_inventarioTransferencia(esInicial);
		this.setResaltarid_formatoTransferencia(esInicial);
		this.setResaltarid_transportistaTransferencia(esInicial);
		this.setResaltarid_empleadoTransferencia(esInicial);
		this.setResaltardescripcionTransferencia(esInicial);
		this.setResaltarporcentaje_descuentoTransferencia(esInicial);
		this.setResaltarsumanTransferencia(esInicial);
		this.setResaltariceTransferencia(esInicial);
		this.setResaltarvalor_descuentoTransferencia(esInicial);
		this.setResaltartotal_descuentoTransferencia(esInicial);
		this.setResaltarivaTransferencia(esInicial);
		this.setResaltarstockTransferencia(esInicial);
		this.setResaltarsub_totalTransferencia(esInicial);
		this.setResaltartotal_otroTransferencia(esInicial);
		this.setResaltarultimo_costoTransferencia(esInicial);
		this.setResaltarnumero_itemsTransferencia(esInicial);
		this.setResaltarretencionTransferencia(esInicial);
		this.setResaltartotalTransferencia(esInicial);
		this.setResaltarfleteTransferencia(esInicial);
		this.setResaltarimpuestoTransferencia(esInicial);
		this.setResaltarid_tipo_transaccion_moduloTransferencia(esInicial);
		this.setResaltarid_asiento_contableTransferencia(esInicial);
		this.setResaltarnumero_comprobanteTransferencia(esInicial);
		this.setResaltarfechaTransferencia(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TransferenciaConstantesFunciones.ID)) {
				this.setResaltaridTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.FECHAENTREGA)) {
				this.setResaltarfecha_entregaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.NUMEROSECUENCIAL)) {
				this.setResaltarnumero_secuencialTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDMONEDA)) {
				this.setResaltarid_monedaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDESTADOINVENTARIO)) {
				this.setResaltarid_estado_inventarioTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDTRANSPORTISTA)) {
				this.setResaltarid_transportistaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.PORCENTAJEDESCUENTO)) {
				this.setResaltarporcentaje_descuentoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.SUMAN)) {
				this.setResaltarsumanTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.ICE)) {
				this.setResaltariceTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.VALORDESCUENTO)) {
				this.setResaltarvalor_descuentoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.TOTALDESCUENTO)) {
				this.setResaltartotal_descuentoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IVA)) {
				this.setResaltarivaTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.STOCK)) {
				this.setResaltarstockTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.SUBTOTAL)) {
				this.setResaltarsub_totalTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.TOTALOTRO)) {
				this.setResaltartotal_otroTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.ULTIMOCOSTO)) {
				this.setResaltarultimo_costoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.NUMEROITEMS)) {
				this.setResaltarnumero_itemsTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.RETENCION)) {
				this.setResaltarretencionTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.TOTAL)) {
				this.setResaltartotalTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.FLETE)) {
				this.setResaltarfleteTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IMPUESTO)) {
				this.setResaltarimpuestoTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.NUMEROCOMPROBANTE)) {
				this.setResaltarnumero_comprobanteTransferencia(esAsigna);
				continue;
			}

			if(campo.clase.equals(TransferenciaConstantesFunciones.FECHA)) {
				this.setResaltarfechaTransferencia(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleTransferenciaTransferencia=null;

	public Border getResaltarDetalleTransferenciaTransferencia() {
		return this.resaltarDetalleTransferenciaTransferencia;
	}

	public void setResaltarDetalleTransferenciaTransferencia(Border borderResaltarDetalleTransferencia) {
		if(borderResaltarDetalleTransferencia!=null) {
			this.resaltarDetalleTransferenciaTransferencia= borderResaltarDetalleTransferencia;
		}
	}

	public Border setResaltarDetalleTransferenciaTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleTransferencia=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//transferenciaBeanSwingJInternalFrame.jTtoolBarTransferencia.setBorder(borderResaltarDetalleTransferencia);
			
		this.resaltarDetalleTransferenciaTransferencia= borderResaltarDetalleTransferencia;

		 return borderResaltarDetalleTransferencia;
	}



	public Boolean mostrarDetalleTransferenciaTransferencia=true;

	public Boolean getMostrarDetalleTransferenciaTransferencia() {
		return this.mostrarDetalleTransferenciaTransferencia;
	}

	public void setMostrarDetalleTransferenciaTransferencia(Boolean visibilidadResaltarDetalleTransferencia) {
		this.mostrarDetalleTransferenciaTransferencia= visibilidadResaltarDetalleTransferencia;
	}



	public Boolean activarDetalleTransferenciaTransferencia=true;

	public Boolean gethabilitarResaltarDetalleTransferenciaTransferencia() {
		return this.activarDetalleTransferenciaTransferencia;
	}

	public void setActivarDetalleTransferenciaTransferencia(Boolean habilitarResaltarDetalleTransferencia) {
		this.activarDetalleTransferenciaTransferencia= habilitarResaltarDetalleTransferencia;
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

		this.setMostrarDetalleTransferenciaTransferencia(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleTransferencia.class)) {
				this.setMostrarDetalleTransferenciaTransferencia(esAsigna);
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

		this.setActivarDetalleTransferenciaTransferencia(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleTransferencia.class)) {
				this.setActivarDetalleTransferenciaTransferencia(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleTransferenciaTransferencia(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleTransferencia.class)) {
				this.setResaltarDetalleTransferenciaTransferencia(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdAsientoContableTransferencia=true;

	public Boolean getMostrarFK_IdAsientoContableTransferencia() {
		return this.mostrarFK_IdAsientoContableTransferencia;
	}

	public void setMostrarFK_IdAsientoContableTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioTransferencia=true;

	public Boolean getMostrarFK_IdEjercicioTransferencia() {
		return this.mostrarFK_IdEjercicioTransferencia;
	}

	public void setMostrarFK_IdEjercicioTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoTransferencia=true;

	public Boolean getMostrarFK_IdEmpleadoTransferencia() {
		return this.mostrarFK_IdEmpleadoTransferencia;
	}

	public void setMostrarFK_IdEmpleadoTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaTransferencia=true;

	public Boolean getMostrarFK_IdEmpresaTransferencia() {
		return this.mostrarFK_IdEmpresaTransferencia;
	}

	public void setMostrarFK_IdEmpresaTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEstadoInventarioTransferencia=true;

	public Boolean getMostrarFK_IdEstadoInventarioTransferencia() {
		return this.mostrarFK_IdEstadoInventarioTransferencia;
	}

	public void setMostrarFK_IdEstadoInventarioTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEstadoInventarioTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloTransferencia=true;

	public Boolean getMostrarFK_IdModuloTransferencia() {
		return this.mostrarFK_IdModuloTransferencia;
	}

	public void setMostrarFK_IdModuloTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoTransferencia=true;

	public Boolean getMostrarFK_IdPeriodoTransferencia() {
		return this.mostrarFK_IdPeriodoTransferencia;
	}

	public void setMostrarFK_IdPeriodoTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalTransferencia=true;

	public Boolean getMostrarFK_IdSucursalTransferencia() {
		return this.mostrarFK_IdSucursalTransferencia;
	}

	public void setMostrarFK_IdSucursalTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloTransferencia=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloTransferencia() {
		return this.mostrarFK_IdTipoTransaccionModuloTransferencia;
	}

	public void setMostrarFK_IdTipoTransaccionModuloTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloTransferencia= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioTransferencia=true;

	public Boolean getMostrarFK_IdUsuarioTransferencia() {
		return this.mostrarFK_IdUsuarioTransferencia;
	}

	public void setMostrarFK_IdUsuarioTransferencia(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioTransferencia= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableTransferencia=true;

	public Boolean getActivarFK_IdAsientoContableTransferencia() {
		return this.activarFK_IdAsientoContableTransferencia;
	}

	public void setActivarFK_IdAsientoContableTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioTransferencia=true;

	public Boolean getActivarFK_IdEjercicioTransferencia() {
		return this.activarFK_IdEjercicioTransferencia;
	}

	public void setActivarFK_IdEjercicioTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoTransferencia=true;

	public Boolean getActivarFK_IdEmpleadoTransferencia() {
		return this.activarFK_IdEmpleadoTransferencia;
	}

	public void setActivarFK_IdEmpleadoTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaTransferencia=true;

	public Boolean getActivarFK_IdEmpresaTransferencia() {
		return this.activarFK_IdEmpresaTransferencia;
	}

	public void setActivarFK_IdEmpresaTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdEstadoInventarioTransferencia=true;

	public Boolean getActivarFK_IdEstadoInventarioTransferencia() {
		return this.activarFK_IdEstadoInventarioTransferencia;
	}

	public void setActivarFK_IdEstadoInventarioTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdEstadoInventarioTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloTransferencia=true;

	public Boolean getActivarFK_IdModuloTransferencia() {
		return this.activarFK_IdModuloTransferencia;
	}

	public void setActivarFK_IdModuloTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdModuloTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoTransferencia=true;

	public Boolean getActivarFK_IdPeriodoTransferencia() {
		return this.activarFK_IdPeriodoTransferencia;
	}

	public void setActivarFK_IdPeriodoTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalTransferencia=true;

	public Boolean getActivarFK_IdSucursalTransferencia() {
		return this.activarFK_IdSucursalTransferencia;
	}

	public void setActivarFK_IdSucursalTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloTransferencia=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloTransferencia() {
		return this.activarFK_IdTipoTransaccionModuloTransferencia;
	}

	public void setActivarFK_IdTipoTransaccionModuloTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloTransferencia= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioTransferencia=true;

	public Boolean getActivarFK_IdUsuarioTransferencia() {
		return this.activarFK_IdUsuarioTransferencia;
	}

	public void setActivarFK_IdUsuarioTransferencia(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioTransferencia= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableTransferencia=null;

	public Border getResaltarFK_IdAsientoContableTransferencia() {
		return this.resaltarFK_IdAsientoContableTransferencia;
	}

	public void setResaltarFK_IdAsientoContableTransferencia(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioTransferencia=null;

	public Border getResaltarFK_IdEjercicioTransferencia() {
		return this.resaltarFK_IdEjercicioTransferencia;
	}

	public void setResaltarFK_IdEjercicioTransferencia(Border borderResaltar) {
		this.resaltarFK_IdEjercicioTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoTransferencia=null;

	public Border getResaltarFK_IdEmpleadoTransferencia() {
		return this.resaltarFK_IdEmpleadoTransferencia;
	}

	public void setResaltarFK_IdEmpleadoTransferencia(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaTransferencia=null;

	public Border getResaltarFK_IdEmpresaTransferencia() {
		return this.resaltarFK_IdEmpresaTransferencia;
	}

	public void setResaltarFK_IdEmpresaTransferencia(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdEstadoInventarioTransferencia=null;

	public Border getResaltarFK_IdEstadoInventarioTransferencia() {
		return this.resaltarFK_IdEstadoInventarioTransferencia;
	}

	public void setResaltarFK_IdEstadoInventarioTransferencia(Border borderResaltar) {
		this.resaltarFK_IdEstadoInventarioTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdEstadoInventarioTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEstadoInventarioTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdModuloTransferencia=null;

	public Border getResaltarFK_IdModuloTransferencia() {
		return this.resaltarFK_IdModuloTransferencia;
	}

	public void setResaltarFK_IdModuloTransferencia(Border borderResaltar) {
		this.resaltarFK_IdModuloTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdModuloTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoTransferencia=null;

	public Border getResaltarFK_IdPeriodoTransferencia() {
		return this.resaltarFK_IdPeriodoTransferencia;
	}

	public void setResaltarFK_IdPeriodoTransferencia(Border borderResaltar) {
		this.resaltarFK_IdPeriodoTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdSucursalTransferencia=null;

	public Border getResaltarFK_IdSucursalTransferencia() {
		return this.resaltarFK_IdSucursalTransferencia;
	}

	public void setResaltarFK_IdSucursalTransferencia(Border borderResaltar) {
		this.resaltarFK_IdSucursalTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdSucursalTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloTransferencia=null;

	public Border getResaltarFK_IdTipoTransaccionModuloTransferencia() {
		return this.resaltarFK_IdTipoTransaccionModuloTransferencia;
	}

	public void setResaltarFK_IdTipoTransaccionModuloTransferencia(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloTransferencia= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioTransferencia=null;

	public Border getResaltarFK_IdUsuarioTransferencia() {
		return this.resaltarFK_IdUsuarioTransferencia;
	}

	public void setResaltarFK_IdUsuarioTransferencia(Border borderResaltar) {
		this.resaltarFK_IdUsuarioTransferencia= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioTransferencia(ParametroGeneralUsuario parametroGeneralUsuario/*TransferenciaBeanSwingJInternalFrame transferenciaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioTransferencia= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}