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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.DetalleAsientoContableCajaChicaConstantesFunciones;
import com.bydan.erp.contabilidad.util.DetalleAsientoContableCajaChicaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.DetalleAsientoContableCajaChicaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleAsientoContableCajaChicaConstantesFunciones extends DetalleAsientoContableCajaChicaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleAsientoContableCajaChica";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleAsientoContableCajaChica"+DetalleAsientoContableCajaChicaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleAsientoContableCajaChicaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleAsientoContableCajaChicaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"_"+DetalleAsientoContableCajaChicaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleAsientoContableCajaChicaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"_"+DetalleAsientoContableCajaChicaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"_"+DetalleAsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleAsientoContableCajaChicaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"_"+DetalleAsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleAsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleAsientoContableCajaChicaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleAsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleAsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleAsientoContableCajaChicaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleAsientoContableCajaChicaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleAsientoContableCajaChicaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleAsientoContableCajaChicaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleAsientoContableCajaChicaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleAsientoContableCajaChicaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Asiento Contable Caja Chicas";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Asiento Contable Caja Chica";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Asiento Contable Caja Chica";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleAsientoContableCajaChica";
	public static final String OBJECTNAME="detalleasientocontablecajachica";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="detalle_asiento_contable_caja_chica";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleasientocontablecajachica from "+DetalleAsientoContableCajaChicaConstantesFunciones.SPERSISTENCENAME+" detalleasientocontablecajachica";
	public static String QUERYSELECTNATIVE="select "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".version_row,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_empresa,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_modulo,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_periodo,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_anio,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_mes,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_asiento_contable_caja_chica,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_tipo_gasto_empresa,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".fecha_emision,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_transaccion,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_factura,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".es_proveedor,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_asiento_contable,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".detalle,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".valor_bien_tarifa12,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".valor_servicio_tarifa12,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".porcentaje_iva,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".valor_bien_tarifa0,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".valor_servicio_tarifa0,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".valor_iva,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".valor_bien_ice,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".valor_servicio_ice,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_tipo_cambio,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".id_tipo_transaccion_modulo,"+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME+".fecha from "+DetalleAsientoContableCajaChicaConstantesFunciones.SCHEMA+"."+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME;//+" as "+DetalleAsientoContableCajaChicaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleAsientoContableCajaChicaConstantesFuncionesAdditional detalleasientocontablecajachicaConstantesFuncionesAdditional=null;
	
	public DetalleAsientoContableCajaChicaConstantesFuncionesAdditional getDetalleAsientoContableCajaChicaConstantesFuncionesAdditional() {
		return this.detalleasientocontablecajachicaConstantesFuncionesAdditional;
	}
	
	public void setDetalleAsientoContableCajaChicaConstantesFuncionesAdditional(DetalleAsientoContableCajaChicaConstantesFuncionesAdditional detalleasientocontablecajachicaConstantesFuncionesAdditional) {
		try {
			this.detalleasientocontablecajachicaConstantesFuncionesAdditional=detalleasientocontablecajachicaConstantesFuncionesAdditional;
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
    public static final String IDASIENTOCONTABLECAJACHICA= "id_asiento_contable_caja_chica";
    public static final String IDTIPOGASTOEMPRESA= "id_tipo_gasto_empresa";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDFACTURA= "id_factura";
    public static final String ESPROVEEDOR= "es_proveedor";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String DETALLE= "detalle";
    public static final String VALORBIENTARIFA12= "valor_bien_tarifa12";
    public static final String VALORSERVICIOTARIFA12= "valor_servicio_tarifa12";
    public static final String PORCENTAJEIVA= "porcentaje_iva";
    public static final String VALORBIENTARIFA0= "valor_bien_tarifa0";
    public static final String VALORSERVICIOTARIFA0= "valor_servicio_tarifa0";
    public static final String VALORIVA= "valor_iva";
    public static final String VALORBIENICE= "valor_bien_ice";
    public static final String VALORSERVICIOICE= "valor_servicio_ice";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
    public static final String IDTIPOTRANSACCIONMODULO= "id_tipo_transaccion_modulo";
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
    	public static final String LABEL_IDASIENTOCONTABLECAJACHICA= "Asiento Caja Chica";
		public static final String LABEL_IDASIENTOCONTABLECAJACHICA_LOWER= "Asiento Contable Caja Chica";
    	public static final String LABEL_IDTIPOGASTOEMPRESA= "Tipo Gasto";
		public static final String LABEL_IDTIPOGASTOEMPRESA_LOWER= "Tipo Gasto Empresa";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_IDTRANSACCION= "Tipo";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDFACTURA= "Factura";
		public static final String LABEL_IDFACTURA_LOWER= "Factura";
    	public static final String LABEL_ESPROVEEDOR= "Es Proveedor";
		public static final String LABEL_ESPROVEEDOR_LOWER= "Es Proveedor";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_VALORBIENTARIFA12= "Tarifa Bien 12";
		public static final String LABEL_VALORBIENTARIFA12_LOWER= "Valor Bien Tarifa12";
    	public static final String LABEL_VALORSERVICIOTARIFA12= "Tarifa Servicio 12 ";
		public static final String LABEL_VALORSERVICIOTARIFA12_LOWER= "Valor Servicio Tarifa12";
    	public static final String LABEL_PORCENTAJEIVA= "% Iva";
		public static final String LABEL_PORCENTAJEIVA_LOWER= "Porcentaje Iva";
    	public static final String LABEL_VALORBIENTARIFA0= "Tarifa Bien 0";
		public static final String LABEL_VALORBIENTARIFA0_LOWER= "Valor Bien Tarifa0";
    	public static final String LABEL_VALORSERVICIOTARIFA0= "Tarifa Servicio 0 ";
		public static final String LABEL_VALORSERVICIOTARIFA0_LOWER= "Valor Servicio Tarifa0";
    	public static final String LABEL_VALORIVA= "Valor Iva";
		public static final String LABEL_VALORIVA_LOWER= "Valor Iva";
    	public static final String LABEL_VALORBIENICE= "Valor Bien Ice";
		public static final String LABEL_VALORBIENICE_LOWER= "Valor Bien Ice";
    	public static final String LABEL_VALORSERVICIOICE= "Valor Servicio Ice ";
		public static final String LABEL_VALORSERVICIOICE_LOWER= "Valor Servicio Ice";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDTIPOCAMBIO= "Tipo Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
    	public static final String LABEL_IDTIPOTRANSACCIONMODULO= "Tipo Transaccion Modulo";
		public static final String LABEL_IDTIPOTRANSACCIONMODULO_LOWER= "Tipo Transaccion Modulo";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getDetalleAsientoContableCajaChicaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDANIO)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDMES)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLECAJACHICA)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDASIENTOCONTABLECAJACHICA;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOGASTOEMPRESA)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOGASTOEMPRESA;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.FECHAEMISION)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTRANSACCION)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDFACTURA)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDFACTURA;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_ESPROVEEDOR;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.DETALLE)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA12)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENTARIFA12;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA12)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOTARIFA12;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.PORCENTAJEIVA)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_PORCENTAJEIVA;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA0)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENTARIFA0;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA0)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOTARIFA0;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORIVA)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORIVA;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENICE)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENICE;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOICE)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOICE;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO;}
		if(sNombreColumna.equals(DetalleAsientoContableCajaChicaConstantesFunciones.FECHA)) {sLabelColumna=DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_FECHA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getes_proveedorDescripcion(DetalleAsientoContableCajaChica detalleasientocontablecajachica) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleasientocontablecajachica.getes_proveedor()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_proveedorHtmlDescripcion(DetalleAsientoContableCajaChica detalleasientocontablecajachica) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleasientocontablecajachica.getId(),detalleasientocontablecajachica.getes_proveedor());

		return sDescripcion;
	}	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleAsientoContableCajaChicaDescripcion(DetalleAsientoContableCajaChica detalleasientocontablecajachica) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleasientocontablecajachica !=null/* && detalleasientocontablecajachica.getId()!=0*/) {
			if(detalleasientocontablecajachica.getId()!=null) {
				sDescripcion=detalleasientocontablecajachica.getId().toString();
			}//detalleasientocontablecajachicadetalleasientocontablecajachica.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleAsientoContableCajaChicaDescripcionDetallado(DetalleAsientoContableCajaChica detalleasientocontablecajachica) {
		String sDescripcion="";
			
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.ID+"=";
		sDescripcion+=detalleasientocontablecajachica.getId().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleasientocontablecajachica.getVersionRow().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_empresa().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_sucursal().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_modulo().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_periodo().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDANIO+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_anio().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDMES+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_mes().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLECAJACHICA+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_asiento_contable_caja_chica().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOGASTOEMPRESA+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_tipo_gasto_empresa().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=detalleasientocontablecajachica.getfecha_emision().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_transaccion().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDFACTURA+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_factura().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR+"=";
		sDescripcion+=detalleasientocontablecajachica.getes_proveedor().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_asiento_contable().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.DETALLE+"=";
		sDescripcion+=detalleasientocontablecajachica.getdetalle()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA12+"=";
		sDescripcion+=detalleasientocontablecajachica.getvalor_bien_tarifa12().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA12+"=";
		sDescripcion+=detalleasientocontablecajachica.getvalor_servicio_tarifa12().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.PORCENTAJEIVA+"=";
		sDescripcion+=detalleasientocontablecajachica.getporcentaje_iva().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA0+"=";
		sDescripcion+=detalleasientocontablecajachica.getvalor_bien_tarifa0().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA0+"=";
		sDescripcion+=detalleasientocontablecajachica.getvalor_servicio_tarifa0().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.VALORIVA+"=";
		sDescripcion+=detalleasientocontablecajachica.getvalor_iva().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENICE+"=";
		sDescripcion+=detalleasientocontablecajachica.getvalor_bien_ice().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOICE+"=";
		sDescripcion+=detalleasientocontablecajachica.getvalor_servicio_ice().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_centro_costo().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_tipo_cambio().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO+"=";
		sDescripcion+=detalleasientocontablecajachica.getid_tipo_transaccion_modulo().toString()+",";
		sDescripcion+=DetalleAsientoContableCajaChicaConstantesFunciones.FECHA+"=";
		sDescripcion+=detalleasientocontablecajachica.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleAsientoContableCajaChicaDescripcion(DetalleAsientoContableCajaChica detalleasientocontablecajachica,String sValor) throws Exception {			
		if(detalleasientocontablecajachica !=null) {
			//detalleasientocontablecajachicadetalleasientocontablecajachica.getId().toString();
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

	public static String getAsientoContableCajaChicaDescripcion(AsientoContableCajaChica asientocontablecajachica) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontablecajachica!=null/*&&asientocontablecajachica.getId()>0*/) {
			sDescripcion=AsientoContableCajaChicaConstantesFunciones.getAsientoContableCajaChicaDescripcion(asientocontablecajachica);
		}

		return sDescripcion;
	}

	public static String getTipoGastoEmpresaDescripcion(TipoGastoEmpresa tipogastoempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipogastoempresa!=null/*&&tipogastoempresa.getId()>0*/) {
			sDescripcion=TipoGastoEmpresaConstantesFunciones.getTipoGastoEmpresaDescripcion(tipogastoempresa);
		}

		return sDescripcion;
	}

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
		}

		return sDescripcion;
	}

	public static String getFacturaDescripcion(Factura factura) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(factura!=null/*&&factura.getId()>0*/) {
			sDescripcion=FacturaConstantesFunciones.getFacturaDescripcion(factura);
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

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
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

	public static String getTipoTransaccionModuloDescripcion(TipoTransaccionModulo tipotransaccionmodulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipotransaccionmodulo!=null/*&&tipotransaccionmodulo.getId()>0*/) {
			sDescripcion=TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(tipotransaccionmodulo);
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
		} else if(sNombreIndice.equals("FK_IdAsientoContableCajaChica")) {
			sNombreIndice="Tipo=  Por Asiento Caja Chica";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFactura")) {
			sNombreIndice="Tipo=  Por Factura";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por Tipo Cambio";
		} else if(sNombreIndice.equals("FK_IdTipoGasto")) {
			sNombreIndice="Tipo=  Por Tipo Gasto";
		} else if(sNombreIndice.equals("FK_IdTipoTransaccionModulo")) {
			sNombreIndice="Tipo=  Por Tipo Transaccion Modulo";
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Tipo";
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

	public static String getDetalleIndiceFK_IdAsientoContableCajaChica(Long id_asiento_contable_caja_chica) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable_caja_chica!=null) {sDetalleIndice+=" Codigo Unico De Asiento Caja Chica="+id_asiento_contable_caja_chica.toString();} 

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

	public static String getDetalleIndiceFK_IdFactura(Long id_factura) {
		String sDetalleIndice=" Parametros->";
		if(id_factura!=null) {sDetalleIndice+=" Codigo Unico De Factura="+id_factura.toString();} 

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
		if(id_tipo_cambio!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cambio="+id_tipo_cambio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoGasto(Long id_tipo_gasto_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_gasto_empresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Gasto="+id_tipo_gasto_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoTransaccionModulo(Long id_tipo_transaccion_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_transaccion_modulo!=null) {sDetalleIndice+=" Codigo Unico De Tipo Transaccion Modulo="+id_tipo_transaccion_modulo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Tipo="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleAsientoContableCajaChica(DetalleAsientoContableCajaChica detalleasientocontablecajachica,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleasientocontablecajachica.setdetalle(detalleasientocontablecajachica.getdetalle().trim());
	}
	
	public static void quitarEspaciosDetalleAsientoContableCajaChicas(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachica: detalleasientocontablecajachicas) {
			detalleasientocontablecajachica.setdetalle(detalleasientocontablecajachica.getdetalle().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleAsientoContableCajaChica(DetalleAsientoContableCajaChica detalleasientocontablecajachica,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleasientocontablecajachica.getConCambioAuxiliar()) {
			detalleasientocontablecajachica.setIsDeleted(detalleasientocontablecajachica.getIsDeletedAuxiliar());	
			detalleasientocontablecajachica.setIsNew(detalleasientocontablecajachica.getIsNewAuxiliar());	
			detalleasientocontablecajachica.setIsChanged(detalleasientocontablecajachica.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleasientocontablecajachica.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleasientocontablecajachica.setIsDeletedAuxiliar(false);	
			detalleasientocontablecajachica.setIsNewAuxiliar(false);	
			detalleasientocontablecajachica.setIsChangedAuxiliar(false);
			
			detalleasientocontablecajachica.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleAsientoContableCajaChicas(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachica : detalleasientocontablecajachicas) {
			if(conAsignarBase && detalleasientocontablecajachica.getConCambioAuxiliar()) {
				detalleasientocontablecajachica.setIsDeleted(detalleasientocontablecajachica.getIsDeletedAuxiliar());	
				detalleasientocontablecajachica.setIsNew(detalleasientocontablecajachica.getIsNewAuxiliar());	
				detalleasientocontablecajachica.setIsChanged(detalleasientocontablecajachica.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleasientocontablecajachica.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleasientocontablecajachica.setIsDeletedAuxiliar(false);	
				detalleasientocontablecajachica.setIsNewAuxiliar(false);	
				detalleasientocontablecajachica.setIsChangedAuxiliar(false);
				
				detalleasientocontablecajachica.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleAsientoContableCajaChica(DetalleAsientoContableCajaChica detalleasientocontablecajachica,Boolean conEnteros) throws Exception  {
		detalleasientocontablecajachica.setvalor_bien_tarifa12(0.0);
		detalleasientocontablecajachica.setvalor_servicio_tarifa12(0.0);
		detalleasientocontablecajachica.setporcentaje_iva(0.0);
		detalleasientocontablecajachica.setvalor_bien_tarifa0(0.0);
		detalleasientocontablecajachica.setvalor_servicio_tarifa0(0.0);
		detalleasientocontablecajachica.setvalor_iva(0.0);
		detalleasientocontablecajachica.setvalor_bien_ice(0.0);
		detalleasientocontablecajachica.setvalor_servicio_ice(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleAsientoContableCajaChicas(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,Boolean conEnteros) throws Exception  {
		
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachica: detalleasientocontablecajachicas) {
			detalleasientocontablecajachica.setvalor_bien_tarifa12(0.0);
			detalleasientocontablecajachica.setvalor_servicio_tarifa12(0.0);
			detalleasientocontablecajachica.setporcentaje_iva(0.0);
			detalleasientocontablecajachica.setvalor_bien_tarifa0(0.0);
			detalleasientocontablecajachica.setvalor_servicio_tarifa0(0.0);
			detalleasientocontablecajachica.setvalor_iva(0.0);
			detalleasientocontablecajachica.setvalor_bien_ice(0.0);
			detalleasientocontablecajachica.setvalor_servicio_ice(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleAsientoContableCajaChica(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,DetalleAsientoContableCajaChica detalleasientocontablecajachicaAux) throws Exception  {
		DetalleAsientoContableCajaChicaConstantesFunciones.InicializarValoresDetalleAsientoContableCajaChica(detalleasientocontablecajachicaAux,true);
		
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachica: detalleasientocontablecajachicas) {
			if(detalleasientocontablecajachica.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleasientocontablecajachicaAux.setvalor_bien_tarifa12(detalleasientocontablecajachicaAux.getvalor_bien_tarifa12()+detalleasientocontablecajachica.getvalor_bien_tarifa12());			
			detalleasientocontablecajachicaAux.setvalor_servicio_tarifa12(detalleasientocontablecajachicaAux.getvalor_servicio_tarifa12()+detalleasientocontablecajachica.getvalor_servicio_tarifa12());			
			detalleasientocontablecajachicaAux.setporcentaje_iva(detalleasientocontablecajachicaAux.getporcentaje_iva()+detalleasientocontablecajachica.getporcentaje_iva());			
			detalleasientocontablecajachicaAux.setvalor_bien_tarifa0(detalleasientocontablecajachicaAux.getvalor_bien_tarifa0()+detalleasientocontablecajachica.getvalor_bien_tarifa0());			
			detalleasientocontablecajachicaAux.setvalor_servicio_tarifa0(detalleasientocontablecajachicaAux.getvalor_servicio_tarifa0()+detalleasientocontablecajachica.getvalor_servicio_tarifa0());			
			detalleasientocontablecajachicaAux.setvalor_iva(detalleasientocontablecajachicaAux.getvalor_iva()+detalleasientocontablecajachica.getvalor_iva());			
			detalleasientocontablecajachicaAux.setvalor_bien_ice(detalleasientocontablecajachicaAux.getvalor_bien_ice()+detalleasientocontablecajachica.getvalor_bien_ice());			
			detalleasientocontablecajachicaAux.setvalor_servicio_ice(detalleasientocontablecajachicaAux.getvalor_servicio_ice()+detalleasientocontablecajachica.getvalor_servicio_ice());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleAsientoContableCajaChica(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleAsientoContableCajaChicaConstantesFunciones.getArrayColumnasGlobalesDetalleAsientoContableCajaChica(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleAsientoContableCajaChica(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleAsientoContableCajaChica(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,DetalleAsientoContableCajaChica detalleasientocontablecajachica,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachicaAux: detalleasientocontablecajachicas) {
			if(detalleasientocontablecajachicaAux!=null && detalleasientocontablecajachica!=null) {
				if((detalleasientocontablecajachicaAux.getId()==null && detalleasientocontablecajachica.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleasientocontablecajachicaAux.getId()!=null && detalleasientocontablecajachica.getId()!=null){
					if(detalleasientocontablecajachicaAux.getId().equals(detalleasientocontablecajachica.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleAsientoContableCajaChica(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valor_bien_tarifa12Total=0.0;
		Double valor_servicio_tarifa12Total=0.0;
		Double porcentaje_ivaTotal=0.0;
		Double valor_bien_tarifa0Total=0.0;
		Double valor_servicio_tarifa0Total=0.0;
		Double valor_ivaTotal=0.0;
		Double valor_bien_iceTotal=0.0;
		Double valor_servicio_iceTotal=0.0;
	
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachica: detalleasientocontablecajachicas) {			
			if(detalleasientocontablecajachica.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valor_bien_tarifa12Total+=detalleasientocontablecajachica.getvalor_bien_tarifa12();
			valor_servicio_tarifa12Total+=detalleasientocontablecajachica.getvalor_servicio_tarifa12();
			porcentaje_ivaTotal+=detalleasientocontablecajachica.getporcentaje_iva();
			valor_bien_tarifa0Total+=detalleasientocontablecajachica.getvalor_bien_tarifa0();
			valor_servicio_tarifa0Total+=detalleasientocontablecajachica.getvalor_servicio_tarifa0();
			valor_ivaTotal+=detalleasientocontablecajachica.getvalor_iva();
			valor_bien_iceTotal+=detalleasientocontablecajachica.getvalor_bien_ice();
			valor_servicio_iceTotal+=detalleasientocontablecajachica.getvalor_servicio_ice();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA12);
		datoGeneral.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENTARIFA12);
		datoGeneral.setdValorDouble(valor_bien_tarifa12Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA12);
		datoGeneral.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOTARIFA12);
		datoGeneral.setdValorDouble(valor_servicio_tarifa12Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.PORCENTAJEIVA);
		datoGeneral.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_PORCENTAJEIVA);
		datoGeneral.setdValorDouble(porcentaje_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA0);
		datoGeneral.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENTARIFA0);
		datoGeneral.setdValorDouble(valor_bien_tarifa0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA0);
		datoGeneral.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOTARIFA0);
		datoGeneral.setdValorDouble(valor_servicio_tarifa0Total);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.VALORIVA);
		datoGeneral.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORIVA);
		datoGeneral.setdValorDouble(valor_ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENICE);
		datoGeneral.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENICE);
		datoGeneral.setdValorDouble(valor_bien_iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOICE);
		datoGeneral.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOICE);
		datoGeneral.setdValorDouble(valor_servicio_iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleAsientoContableCajaChica() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_ID, DetalleAsientoContableCajaChicaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VERSIONROW, DetalleAsientoContableCajaChicaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPRESA, DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDSUCURSAL, DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDMODULO, DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDEJERCICIO, DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDPERIODO, DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDANIO, DetalleAsientoContableCajaChicaConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDMES, DetalleAsientoContableCajaChicaConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDASIENTOCONTABLECAJACHICA, DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLECAJACHICA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOGASTOEMPRESA, DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOGASTOEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_FECHAEMISION, DetalleAsientoContableCajaChicaConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTRANSACCION, DetalleAsientoContableCajaChicaConstantesFunciones.IDTRANSACCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDFACTURA, DetalleAsientoContableCajaChicaConstantesFunciones.IDFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_ESPROVEEDOR, DetalleAsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDASIENTOCONTABLE, DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_DETALLE, DetalleAsientoContableCajaChicaConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENTARIFA12, DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA12,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOTARIFA12, DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA12,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_PORCENTAJEIVA, DetalleAsientoContableCajaChicaConstantesFunciones.PORCENTAJEIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENTARIFA0, DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA0,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOTARIFA0, DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA0,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORIVA, DetalleAsientoContableCajaChicaConstantesFunciones.VALORIVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENICE, DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOICE, DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOICE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDCENTROCOSTO, DetalleAsientoContableCajaChicaConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOCAMBIO, DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO, DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_FECHA, DetalleAsientoContableCajaChicaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleAsientoContableCajaChica() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLECAJACHICA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOGASTOEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDTRANSACCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA12;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA12;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.PORCENTAJEIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA0;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA0;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.VALORIVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOICE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableCajaChicaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleAsientoContableCajaChica() throws Exception  {
		return DetalleAsientoContableCajaChicaConstantesFunciones.getTiposSeleccionarDetalleAsientoContableCajaChica(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleAsientoContableCajaChica(Boolean conFk) throws Exception  {
		return DetalleAsientoContableCajaChicaConstantesFunciones.getTiposSeleccionarDetalleAsientoContableCajaChica(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleAsientoContableCajaChica(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDASIENTOCONTABLECAJACHICA);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDASIENTOCONTABLECAJACHICA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOGASTOEMPRESA);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOGASTOEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDFACTURA);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_ESPROVEEDOR);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_ESPROVEEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENTARIFA12);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENTARIFA12);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOTARIFA12);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOTARIFA12);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_PORCENTAJEIVA);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_PORCENTAJEIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENTARIFA0);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENTARIFA0);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOTARIFA0);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOTARIFA0);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORIVA);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORIVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENICE);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOICE);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleAsientoContableCajaChica(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(DetalleAsientoContableCajaChica detalleasientocontablecajachicaAux) throws Exception {
		
			detalleasientocontablecajachicaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleasientocontablecajachicaAux.getEmpresa()));
			detalleasientocontablecajachicaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleasientocontablecajachicaAux.getSucursal()));
			detalleasientocontablecajachicaAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(detalleasientocontablecajachicaAux.getModulo()));
			detalleasientocontablecajachicaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleasientocontablecajachicaAux.getEjercicio()));
			detalleasientocontablecajachicaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleasientocontablecajachicaAux.getPeriodo()));
			detalleasientocontablecajachicaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalleasientocontablecajachicaAux.getAnio()));
			detalleasientocontablecajachicaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalleasientocontablecajachicaAux.getMes()));
			detalleasientocontablecajachicaAux.setasientocontablecajachica_descripcion(AsientoContableCajaChicaConstantesFunciones.getAsientoContableCajaChicaDescripcion(detalleasientocontablecajachicaAux.getAsientoContableCajaChica()));
			detalleasientocontablecajachicaAux.settipogastoempresa_descripcion(TipoGastoEmpresaConstantesFunciones.getTipoGastoEmpresaDescripcion(detalleasientocontablecajachicaAux.getTipoGastoEmpresa()));
			detalleasientocontablecajachicaAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(detalleasientocontablecajachicaAux.getTransaccion()));
			detalleasientocontablecajachicaAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(detalleasientocontablecajachicaAux.getFactura()));
			detalleasientocontablecajachicaAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detalleasientocontablecajachicaAux.getAsientoContable()));
			detalleasientocontablecajachicaAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detalleasientocontablecajachicaAux.getCentroCosto()));
			detalleasientocontablecajachicaAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(detalleasientocontablecajachicaAux.getTipoCambio()));
			detalleasientocontablecajachicaAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(detalleasientocontablecajachicaAux.getTipoTransaccionModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleAsientoContableCajaChica(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicasTemp) throws Exception {
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachicaAux:detalleasientocontablecajachicasTemp) {
			
			detalleasientocontablecajachicaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleasientocontablecajachicaAux.getEmpresa()));
			detalleasientocontablecajachicaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleasientocontablecajachicaAux.getSucursal()));
			detalleasientocontablecajachicaAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(detalleasientocontablecajachicaAux.getModulo()));
			detalleasientocontablecajachicaAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleasientocontablecajachicaAux.getEjercicio()));
			detalleasientocontablecajachicaAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleasientocontablecajachicaAux.getPeriodo()));
			detalleasientocontablecajachicaAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalleasientocontablecajachicaAux.getAnio()));
			detalleasientocontablecajachicaAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalleasientocontablecajachicaAux.getMes()));
			detalleasientocontablecajachicaAux.setasientocontablecajachica_descripcion(AsientoContableCajaChicaConstantesFunciones.getAsientoContableCajaChicaDescripcion(detalleasientocontablecajachicaAux.getAsientoContableCajaChica()));
			detalleasientocontablecajachicaAux.settipogastoempresa_descripcion(TipoGastoEmpresaConstantesFunciones.getTipoGastoEmpresaDescripcion(detalleasientocontablecajachicaAux.getTipoGastoEmpresa()));
			detalleasientocontablecajachicaAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(detalleasientocontablecajachicaAux.getTransaccion()));
			detalleasientocontablecajachicaAux.setfactura_descripcion(FacturaConstantesFunciones.getFacturaDescripcion(detalleasientocontablecajachicaAux.getFactura()));
			detalleasientocontablecajachicaAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detalleasientocontablecajachicaAux.getAsientoContable()));
			detalleasientocontablecajachicaAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detalleasientocontablecajachicaAux.getCentroCosto()));
			detalleasientocontablecajachicaAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(detalleasientocontablecajachicaAux.getTipoCambio()));
			detalleasientocontablecajachicaAux.settipotransaccionmodulo_descripcion(TipoTransaccionModuloConstantesFunciones.getTipoTransaccionModuloDescripcion(detalleasientocontablecajachicaAux.getTipoTransaccionModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
				classes.add(new Classe(AsientoContableCajaChica.class));
				classes.add(new Classe(TipoGastoEmpresa.class));
				classes.add(new Classe(Transaccion.class));
				classes.add(new Classe(Factura.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(TipoCambio.class));
				classes.add(new Classe(TipoTransaccionModulo.class));
				
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
					if(clas.clas.equals(AsientoContableCajaChica.class)) {
						classes.add(new Classe(AsientoContableCajaChica.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoGastoEmpresa.class)) {
						classes.add(new Classe(TipoGastoEmpresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Factura.class)) {
						classes.add(new Classe(Factura.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCambio.class)) {
						classes.add(new Classe(TipoCambio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoTransaccionModulo.class)) {
						classes.add(new Classe(TipoTransaccionModulo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleAsientoContableCajaChica(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(AsientoContableCajaChica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContableCajaChica.class)); continue;
					}

					if(TipoGastoEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGastoEmpresa.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
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

					if(AsientoContableCajaChica.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContableCajaChica.class)); continue;
					}

					if(TipoGastoEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoGastoEmpresa.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
					}

					if(Factura.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Factura.class)); continue;
					}

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
					}

					if(TipoTransaccionModulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoTransaccionModulo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleAsientoContableCajaChicaConstantesFunciones.getClassesRelationshipsOfDetalleAsientoContableCajaChica(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleAsientoContableCajaChica(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleAsientoContableCajaChica(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleAsientoContableCajaChicaConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleAsientoContableCajaChica(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleAsientoContableCajaChica(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleAsientoContableCajaChica detalleasientocontablecajachica,List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleAsientoContableCajaChica detalleasientocontablecajachicaEncontrado=null;
			
			for(DetalleAsientoContableCajaChica detalleasientocontablecajachicaLocal:detalleasientocontablecajachicas) {
				if(detalleasientocontablecajachicaLocal.getId().equals(detalleasientocontablecajachica.getId())) {
					detalleasientocontablecajachicaEncontrado=detalleasientocontablecajachicaLocal;
					
					detalleasientocontablecajachicaLocal.setIsChanged(detalleasientocontablecajachica.getIsChanged());
					detalleasientocontablecajachicaLocal.setIsNew(detalleasientocontablecajachica.getIsNew());
					detalleasientocontablecajachicaLocal.setIsDeleted(detalleasientocontablecajachica.getIsDeleted());
					
					detalleasientocontablecajachicaLocal.setGeneralEntityOriginal(detalleasientocontablecajachica.getGeneralEntityOriginal());
					
					detalleasientocontablecajachicaLocal.setId(detalleasientocontablecajachica.getId());	
					detalleasientocontablecajachicaLocal.setVersionRow(detalleasientocontablecajachica.getVersionRow());	
					detalleasientocontablecajachicaLocal.setid_empresa(detalleasientocontablecajachica.getid_empresa());	
					detalleasientocontablecajachicaLocal.setid_sucursal(detalleasientocontablecajachica.getid_sucursal());	
					detalleasientocontablecajachicaLocal.setid_modulo(detalleasientocontablecajachica.getid_modulo());	
					detalleasientocontablecajachicaLocal.setid_ejercicio(detalleasientocontablecajachica.getid_ejercicio());	
					detalleasientocontablecajachicaLocal.setid_periodo(detalleasientocontablecajachica.getid_periodo());	
					detalleasientocontablecajachicaLocal.setid_anio(detalleasientocontablecajachica.getid_anio());	
					detalleasientocontablecajachicaLocal.setid_mes(detalleasientocontablecajachica.getid_mes());	
					detalleasientocontablecajachicaLocal.setid_asiento_contable_caja_chica(detalleasientocontablecajachica.getid_asiento_contable_caja_chica());	
					detalleasientocontablecajachicaLocal.setid_tipo_gasto_empresa(detalleasientocontablecajachica.getid_tipo_gasto_empresa());	
					detalleasientocontablecajachicaLocal.setfecha_emision(detalleasientocontablecajachica.getfecha_emision());	
					detalleasientocontablecajachicaLocal.setid_transaccion(detalleasientocontablecajachica.getid_transaccion());	
					detalleasientocontablecajachicaLocal.setid_factura(detalleasientocontablecajachica.getid_factura());	
					detalleasientocontablecajachicaLocal.setes_proveedor(detalleasientocontablecajachica.getes_proveedor());	
					detalleasientocontablecajachicaLocal.setid_asiento_contable(detalleasientocontablecajachica.getid_asiento_contable());	
					detalleasientocontablecajachicaLocal.setdetalle(detalleasientocontablecajachica.getdetalle());	
					detalleasientocontablecajachicaLocal.setvalor_bien_tarifa12(detalleasientocontablecajachica.getvalor_bien_tarifa12());	
					detalleasientocontablecajachicaLocal.setvalor_servicio_tarifa12(detalleasientocontablecajachica.getvalor_servicio_tarifa12());	
					detalleasientocontablecajachicaLocal.setporcentaje_iva(detalleasientocontablecajachica.getporcentaje_iva());	
					detalleasientocontablecajachicaLocal.setvalor_bien_tarifa0(detalleasientocontablecajachica.getvalor_bien_tarifa0());	
					detalleasientocontablecajachicaLocal.setvalor_servicio_tarifa0(detalleasientocontablecajachica.getvalor_servicio_tarifa0());	
					detalleasientocontablecajachicaLocal.setvalor_iva(detalleasientocontablecajachica.getvalor_iva());	
					detalleasientocontablecajachicaLocal.setvalor_bien_ice(detalleasientocontablecajachica.getvalor_bien_ice());	
					detalleasientocontablecajachicaLocal.setvalor_servicio_ice(detalleasientocontablecajachica.getvalor_servicio_ice());	
					detalleasientocontablecajachicaLocal.setid_centro_costo(detalleasientocontablecajachica.getid_centro_costo());	
					detalleasientocontablecajachicaLocal.setid_tipo_cambio(detalleasientocontablecajachica.getid_tipo_cambio());	
					detalleasientocontablecajachicaLocal.setid_tipo_transaccion_modulo(detalleasientocontablecajachica.getid_tipo_transaccion_modulo());	
					detalleasientocontablecajachicaLocal.setfecha(detalleasientocontablecajachica.getfecha());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleasientocontablecajachica.getIsDeleted()) {
				if(!existe) {
					detalleasientocontablecajachicas.add(detalleasientocontablecajachica);
				}
			} else {
				if(detalleasientocontablecajachicaEncontrado!=null && permiteQuitar)  {
					detalleasientocontablecajachicas.remove(detalleasientocontablecajachicaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleAsientoContableCajaChica detalleasientocontablecajachica,List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicas) throws Exception {
		try	{			
			for(DetalleAsientoContableCajaChica detalleasientocontablecajachicaLocal:detalleasientocontablecajachicas) {
				if(detalleasientocontablecajachicaLocal.getId().equals(detalleasientocontablecajachica.getId())) {
					detalleasientocontablecajachicaLocal.setIsSelected(detalleasientocontablecajachica.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleAsientoContableCajaChica(List<DetalleAsientoContableCajaChica> detalleasientocontablecajachicasAux) throws Exception {
		//this.detalleasientocontablecajachicasAux=detalleasientocontablecajachicasAux;
		
		for(DetalleAsientoContableCajaChica detalleasientocontablecajachicaAux:detalleasientocontablecajachicasAux) {
			if(detalleasientocontablecajachicaAux.getIsChanged()) {
				detalleasientocontablecajachicaAux.setIsChanged(false);
			}		
			
			if(detalleasientocontablecajachicaAux.getIsNew()) {
				detalleasientocontablecajachicaAux.setIsNew(false);
			}	
			
			if(detalleasientocontablecajachicaAux.getIsDeleted()) {
				detalleasientocontablecajachicaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleAsientoContableCajaChica(DetalleAsientoContableCajaChica detalleasientocontablecajachicaAux) throws Exception {
		//this.detalleasientocontablecajachicaAux=detalleasientocontablecajachicaAux;
		
			if(detalleasientocontablecajachicaAux.getIsChanged()) {
				detalleasientocontablecajachicaAux.setIsChanged(false);
			}		
			
			if(detalleasientocontablecajachicaAux.getIsNew()) {
				detalleasientocontablecajachicaAux.setIsNew(false);
			}	
			
			if(detalleasientocontablecajachicaAux.getIsDeleted()) {
				detalleasientocontablecajachicaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleAsientoContableCajaChica detalleasientocontablecajachicaAsignar,DetalleAsientoContableCajaChica detalleasientocontablecajachica) throws Exception {
		detalleasientocontablecajachicaAsignar.setId(detalleasientocontablecajachica.getId());	
		detalleasientocontablecajachicaAsignar.setVersionRow(detalleasientocontablecajachica.getVersionRow());	
		detalleasientocontablecajachicaAsignar.setid_empresa(detalleasientocontablecajachica.getid_empresa());
		detalleasientocontablecajachicaAsignar.setempresa_descripcion(detalleasientocontablecajachica.getempresa_descripcion());	
		detalleasientocontablecajachicaAsignar.setid_sucursal(detalleasientocontablecajachica.getid_sucursal());
		detalleasientocontablecajachicaAsignar.setsucursal_descripcion(detalleasientocontablecajachica.getsucursal_descripcion());	
		detalleasientocontablecajachicaAsignar.setid_modulo(detalleasientocontablecajachica.getid_modulo());
		detalleasientocontablecajachicaAsignar.setmodulo_descripcion(detalleasientocontablecajachica.getmodulo_descripcion());	
		detalleasientocontablecajachicaAsignar.setid_ejercicio(detalleasientocontablecajachica.getid_ejercicio());
		detalleasientocontablecajachicaAsignar.setejercicio_descripcion(detalleasientocontablecajachica.getejercicio_descripcion());	
		detalleasientocontablecajachicaAsignar.setid_periodo(detalleasientocontablecajachica.getid_periodo());
		detalleasientocontablecajachicaAsignar.setperiodo_descripcion(detalleasientocontablecajachica.getperiodo_descripcion());	
		detalleasientocontablecajachicaAsignar.setid_anio(detalleasientocontablecajachica.getid_anio());
		detalleasientocontablecajachicaAsignar.setanio_descripcion(detalleasientocontablecajachica.getanio_descripcion());	
		detalleasientocontablecajachicaAsignar.setid_mes(detalleasientocontablecajachica.getid_mes());
		detalleasientocontablecajachicaAsignar.setmes_descripcion(detalleasientocontablecajachica.getmes_descripcion());	
		detalleasientocontablecajachicaAsignar.setid_asiento_contable_caja_chica(detalleasientocontablecajachica.getid_asiento_contable_caja_chica());
		detalleasientocontablecajachicaAsignar.setasientocontablecajachica_descripcion(detalleasientocontablecajachica.getasientocontablecajachica_descripcion());	
		detalleasientocontablecajachicaAsignar.setid_tipo_gasto_empresa(detalleasientocontablecajachica.getid_tipo_gasto_empresa());
		detalleasientocontablecajachicaAsignar.settipogastoempresa_descripcion(detalleasientocontablecajachica.gettipogastoempresa_descripcion());	
		detalleasientocontablecajachicaAsignar.setfecha_emision(detalleasientocontablecajachica.getfecha_emision());	
		detalleasientocontablecajachicaAsignar.setid_transaccion(detalleasientocontablecajachica.getid_transaccion());
		detalleasientocontablecajachicaAsignar.settransaccion_descripcion(detalleasientocontablecajachica.gettransaccion_descripcion());	
		detalleasientocontablecajachicaAsignar.setid_factura(detalleasientocontablecajachica.getid_factura());
		detalleasientocontablecajachicaAsignar.setfactura_descripcion(detalleasientocontablecajachica.getfactura_descripcion());	
		detalleasientocontablecajachicaAsignar.setes_proveedor(detalleasientocontablecajachica.getes_proveedor());	
		detalleasientocontablecajachicaAsignar.setid_asiento_contable(detalleasientocontablecajachica.getid_asiento_contable());
		detalleasientocontablecajachicaAsignar.setasientocontable_descripcion(detalleasientocontablecajachica.getasientocontable_descripcion());	
		detalleasientocontablecajachicaAsignar.setdetalle(detalleasientocontablecajachica.getdetalle());	
		detalleasientocontablecajachicaAsignar.setvalor_bien_tarifa12(detalleasientocontablecajachica.getvalor_bien_tarifa12());	
		detalleasientocontablecajachicaAsignar.setvalor_servicio_tarifa12(detalleasientocontablecajachica.getvalor_servicio_tarifa12());	
		detalleasientocontablecajachicaAsignar.setporcentaje_iva(detalleasientocontablecajachica.getporcentaje_iva());	
		detalleasientocontablecajachicaAsignar.setvalor_bien_tarifa0(detalleasientocontablecajachica.getvalor_bien_tarifa0());	
		detalleasientocontablecajachicaAsignar.setvalor_servicio_tarifa0(detalleasientocontablecajachica.getvalor_servicio_tarifa0());	
		detalleasientocontablecajachicaAsignar.setvalor_iva(detalleasientocontablecajachica.getvalor_iva());	
		detalleasientocontablecajachicaAsignar.setvalor_bien_ice(detalleasientocontablecajachica.getvalor_bien_ice());	
		detalleasientocontablecajachicaAsignar.setvalor_servicio_ice(detalleasientocontablecajachica.getvalor_servicio_ice());	
		detalleasientocontablecajachicaAsignar.setid_centro_costo(detalleasientocontablecajachica.getid_centro_costo());
		detalleasientocontablecajachicaAsignar.setcentrocosto_descripcion(detalleasientocontablecajachica.getcentrocosto_descripcion());	
		detalleasientocontablecajachicaAsignar.setid_tipo_cambio(detalleasientocontablecajachica.getid_tipo_cambio());
		detalleasientocontablecajachicaAsignar.settipocambio_descripcion(detalleasientocontablecajachica.gettipocambio_descripcion());	
		detalleasientocontablecajachicaAsignar.setid_tipo_transaccion_modulo(detalleasientocontablecajachica.getid_tipo_transaccion_modulo());
		detalleasientocontablecajachicaAsignar.settipotransaccionmodulo_descripcion(detalleasientocontablecajachica.gettipotransaccionmodulo_descripcion());	
		detalleasientocontablecajachicaAsignar.setfecha(detalleasientocontablecajachica.getfecha());	
	}
	
	public static void inicializarDetalleAsientoContableCajaChica(DetalleAsientoContableCajaChica detalleasientocontablecajachica) throws Exception {
		try {
				detalleasientocontablecajachica.setId(0L);	
					
				detalleasientocontablecajachica.setid_empresa(-1L);	
				detalleasientocontablecajachica.setid_sucursal(-1L);	
				detalleasientocontablecajachica.setid_modulo(-1L);	
				detalleasientocontablecajachica.setid_ejercicio(-1L);	
				detalleasientocontablecajachica.setid_periodo(-1L);	
				detalleasientocontablecajachica.setid_anio(null);	
				detalleasientocontablecajachica.setid_mes(null);	
				detalleasientocontablecajachica.setid_asiento_contable_caja_chica(-1L);	
				detalleasientocontablecajachica.setid_tipo_gasto_empresa(-1L);	
				detalleasientocontablecajachica.setfecha_emision(new Date());	
				detalleasientocontablecajachica.setid_transaccion(-1L);	
				detalleasientocontablecajachica.setid_factura(null);	
				detalleasientocontablecajachica.setes_proveedor(false);	
				detalleasientocontablecajachica.setid_asiento_contable(null);	
				detalleasientocontablecajachica.setdetalle("");	
				detalleasientocontablecajachica.setvalor_bien_tarifa12(0.0);	
				detalleasientocontablecajachica.setvalor_servicio_tarifa12(0.0);	
				detalleasientocontablecajachica.setporcentaje_iva(0.0);	
				detalleasientocontablecajachica.setvalor_bien_tarifa0(0.0);	
				detalleasientocontablecajachica.setvalor_servicio_tarifa0(0.0);	
				detalleasientocontablecajachica.setvalor_iva(0.0);	
				detalleasientocontablecajachica.setvalor_bien_ice(0.0);	
				detalleasientocontablecajachica.setvalor_servicio_ice(0.0);	
				detalleasientocontablecajachica.setid_centro_costo(null);	
				detalleasientocontablecajachica.setid_tipo_cambio(null);	
				detalleasientocontablecajachica.setid_tipo_transaccion_modulo(null);	
				detalleasientocontablecajachica.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleAsientoContableCajaChica(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDASIENTOCONTABLECAJACHICA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOGASTOEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_ESPROVEEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENTARIFA12);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOTARIFA12);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_PORCENTAJEIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENTARIFA0);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOTARIFA0);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORIVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORBIENICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_VALORSERVICIOICE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_IDTIPOTRANSACCIONMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableCajaChicaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleAsientoContableCajaChica(String sTipo,Row row,Workbook workbook,DetalleAsientoContableCajaChica detalleasientocontablecajachica,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getasientocontablecajachica_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.gettipogastoempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getfactura_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleasientocontablecajachica.getes_proveedor()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getvalor_bien_tarifa12());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getvalor_servicio_tarifa12());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getporcentaje_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getvalor_bien_tarifa0());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getvalor_servicio_tarifa0());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getvalor_iva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getvalor_bien_ice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getvalor_servicio_ice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.gettipotransaccionmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontablecajachica.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleAsientoContableCajaChica=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleAsientoContableCajaChica() {
		return this.sFinalQueryDetalleAsientoContableCajaChica;
	}
	
	public void setsFinalQueryDetalleAsientoContableCajaChica(String sFinalQueryDetalleAsientoContableCajaChica) {
		this.sFinalQueryDetalleAsientoContableCajaChica= sFinalQueryDetalleAsientoContableCajaChica;
	}
	
	public Border resaltarSeleccionarDetalleAsientoContableCajaChica=null;
	
	public Border setResaltarSeleccionarDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleAsientoContableCajaChica= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleAsientoContableCajaChica() {
		return this.resaltarSeleccionarDetalleAsientoContableCajaChica;
	}
	
	public void setResaltarSeleccionarDetalleAsientoContableCajaChica(Border borderResaltarSeleccionarDetalleAsientoContableCajaChica) {
		this.resaltarSeleccionarDetalleAsientoContableCajaChica= borderResaltarSeleccionarDetalleAsientoContableCajaChica;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleAsientoContableCajaChica=null;
	public Boolean mostraridDetalleAsientoContableCajaChica=true;
	public Boolean activaridDetalleAsientoContableCajaChica=true;

	public Border resaltarid_empresaDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_empresaDetalleAsientoContableCajaChica=true;
	public Boolean activarid_empresaDetalleAsientoContableCajaChica=true;
	public Boolean cargarid_empresaDetalleAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_sucursalDetalleAsientoContableCajaChica=true;
	public Boolean activarid_sucursalDetalleAsientoContableCajaChica=true;
	public Boolean cargarid_sucursalDetalleAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_moduloDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_moduloDetalleAsientoContableCajaChica=true;
	public Boolean activarid_moduloDetalleAsientoContableCajaChica=true;
	public Boolean cargarid_moduloDetalleAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_ejercicioDetalleAsientoContableCajaChica=true;
	public Boolean activarid_ejercicioDetalleAsientoContableCajaChica=true;
	public Boolean cargarid_ejercicioDetalleAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_periodoDetalleAsientoContableCajaChica=true;
	public Boolean activarid_periodoDetalleAsientoContableCajaChica=true;
	public Boolean cargarid_periodoDetalleAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_anioDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_anioDetalleAsientoContableCajaChica=true;
	public Boolean activarid_anioDetalleAsientoContableCajaChica=false;
	public Boolean cargarid_anioDetalleAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_mesDetalleAsientoContableCajaChica=true;
	public Boolean activarid_mesDetalleAsientoContableCajaChica=false;
	public Boolean cargarid_mesDetalleAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica=true;
	public Boolean activarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica=true;
	public Boolean cargarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_tipo_gasto_empresaDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_tipo_gasto_empresaDetalleAsientoContableCajaChica=true;
	public Boolean activarid_tipo_gasto_empresaDetalleAsientoContableCajaChica=true;
	public Boolean cargarid_tipo_gasto_empresaDetalleAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_gasto_empresaDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarfecha_emisionDetalleAsientoContableCajaChica=null;
	public Boolean mostrarfecha_emisionDetalleAsientoContableCajaChica=true;
	public Boolean activarfecha_emisionDetalleAsientoContableCajaChica=true;

	public Border resaltarid_transaccionDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_transaccionDetalleAsientoContableCajaChica=true;
	public Boolean activarid_transaccionDetalleAsientoContableCajaChica=true;
	public Boolean cargarid_transaccionDetalleAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_facturaDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_facturaDetalleAsientoContableCajaChica=true;
	public Boolean activarid_facturaDetalleAsientoContableCajaChica=true;
	public Boolean cargarid_facturaDetalleAsientoContableCajaChica=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_facturaDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltares_proveedorDetalleAsientoContableCajaChica=null;
	public Boolean mostrares_proveedorDetalleAsientoContableCajaChica=true;
	public Boolean activares_proveedorDetalleAsientoContableCajaChica=true;

	public Border resaltarid_asiento_contableDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_asiento_contableDetalleAsientoContableCajaChica=true;
	public Boolean activarid_asiento_contableDetalleAsientoContableCajaChica=true;
	public Boolean cargarid_asiento_contableDetalleAsientoContableCajaChica=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltardetalleDetalleAsientoContableCajaChica=null;
	public Boolean mostrardetalleDetalleAsientoContableCajaChica=true;
	public Boolean activardetalleDetalleAsientoContableCajaChica=true;

	public Border resaltarvalor_bien_tarifa12DetalleAsientoContableCajaChica=null;
	public Boolean mostrarvalor_bien_tarifa12DetalleAsientoContableCajaChica=true;
	public Boolean activarvalor_bien_tarifa12DetalleAsientoContableCajaChica=true;

	public Border resaltarvalor_servicio_tarifa12DetalleAsientoContableCajaChica=null;
	public Boolean mostrarvalor_servicio_tarifa12DetalleAsientoContableCajaChica=true;
	public Boolean activarvalor_servicio_tarifa12DetalleAsientoContableCajaChica=true;

	public Border resaltarporcentaje_ivaDetalleAsientoContableCajaChica=null;
	public Boolean mostrarporcentaje_ivaDetalleAsientoContableCajaChica=true;
	public Boolean activarporcentaje_ivaDetalleAsientoContableCajaChica=true;

	public Border resaltarvalor_bien_tarifa0DetalleAsientoContableCajaChica=null;
	public Boolean mostrarvalor_bien_tarifa0DetalleAsientoContableCajaChica=true;
	public Boolean activarvalor_bien_tarifa0DetalleAsientoContableCajaChica=true;

	public Border resaltarvalor_servicio_tarifa0DetalleAsientoContableCajaChica=null;
	public Boolean mostrarvalor_servicio_tarifa0DetalleAsientoContableCajaChica=true;
	public Boolean activarvalor_servicio_tarifa0DetalleAsientoContableCajaChica=true;

	public Border resaltarvalor_ivaDetalleAsientoContableCajaChica=null;
	public Boolean mostrarvalor_ivaDetalleAsientoContableCajaChica=true;
	public Boolean activarvalor_ivaDetalleAsientoContableCajaChica=true;

	public Border resaltarvalor_bien_iceDetalleAsientoContableCajaChica=null;
	public Boolean mostrarvalor_bien_iceDetalleAsientoContableCajaChica=true;
	public Boolean activarvalor_bien_iceDetalleAsientoContableCajaChica=true;

	public Border resaltarvalor_servicio_iceDetalleAsientoContableCajaChica=null;
	public Boolean mostrarvalor_servicio_iceDetalleAsientoContableCajaChica=true;
	public Boolean activarvalor_servicio_iceDetalleAsientoContableCajaChica=true;

	public Border resaltarid_centro_costoDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_centro_costoDetalleAsientoContableCajaChica=true;
	public Boolean activarid_centro_costoDetalleAsientoContableCajaChica=false;
	public Boolean cargarid_centro_costoDetalleAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_tipo_cambioDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_tipo_cambioDetalleAsientoContableCajaChica=true;
	public Boolean activarid_tipo_cambioDetalleAsientoContableCajaChica=false;
	public Boolean cargarid_tipo_cambioDetalleAsientoContableCajaChica=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica=null;
	public Boolean mostrarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica=true;
	public Boolean activarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica=false;
	public Boolean cargarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_transaccion_moduloDetalleAsientoContableCajaChica=false;//ConEventDepend=true

	public Border resaltarfechaDetalleAsientoContableCajaChica=null;
	public Boolean mostrarfechaDetalleAsientoContableCajaChica=true;
	public Boolean activarfechaDetalleAsientoContableCajaChica=false;

	
	

	public Border setResaltaridDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltaridDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleAsientoContableCajaChica() {
		return this.resaltaridDetalleAsientoContableCajaChica;
	}

	public void setResaltaridDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltaridDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostraridDetalleAsientoContableCajaChica() {
		return this.mostraridDetalleAsientoContableCajaChica;
	}

	public void setMostraridDetalleAsientoContableCajaChica(Boolean mostraridDetalleAsientoContableCajaChica) {
		this.mostraridDetalleAsientoContableCajaChica= mostraridDetalleAsientoContableCajaChica;
	}

	public Boolean getActivaridDetalleAsientoContableCajaChica() {
		return this.activaridDetalleAsientoContableCajaChica;
	}

	public void setActivaridDetalleAsientoContableCajaChica(Boolean activaridDetalleAsientoContableCajaChica) {
		this.activaridDetalleAsientoContableCajaChica= activaridDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_empresaDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleAsientoContableCajaChica() {
		return this.resaltarid_empresaDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_empresaDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_empresaDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleAsientoContableCajaChica() {
		return this.mostrarid_empresaDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_empresaDetalleAsientoContableCajaChica(Boolean mostrarid_empresaDetalleAsientoContableCajaChica) {
		this.mostrarid_empresaDetalleAsientoContableCajaChica= mostrarid_empresaDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_empresaDetalleAsientoContableCajaChica() {
		return this.activarid_empresaDetalleAsientoContableCajaChica;
	}

	public void setActivarid_empresaDetalleAsientoContableCajaChica(Boolean activarid_empresaDetalleAsientoContableCajaChica) {
		this.activarid_empresaDetalleAsientoContableCajaChica= activarid_empresaDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_empresaDetalleAsientoContableCajaChica() {
		return this.cargarid_empresaDetalleAsientoContableCajaChica;
	}

	public void setCargarid_empresaDetalleAsientoContableCajaChica(Boolean cargarid_empresaDetalleAsientoContableCajaChica) {
		this.cargarid_empresaDetalleAsientoContableCajaChica= cargarid_empresaDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_sucursalDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleAsientoContableCajaChica() {
		return this.resaltarid_sucursalDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_sucursalDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_sucursalDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleAsientoContableCajaChica() {
		return this.mostrarid_sucursalDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_sucursalDetalleAsientoContableCajaChica(Boolean mostrarid_sucursalDetalleAsientoContableCajaChica) {
		this.mostrarid_sucursalDetalleAsientoContableCajaChica= mostrarid_sucursalDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_sucursalDetalleAsientoContableCajaChica() {
		return this.activarid_sucursalDetalleAsientoContableCajaChica;
	}

	public void setActivarid_sucursalDetalleAsientoContableCajaChica(Boolean activarid_sucursalDetalleAsientoContableCajaChica) {
		this.activarid_sucursalDetalleAsientoContableCajaChica= activarid_sucursalDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_sucursalDetalleAsientoContableCajaChica() {
		return this.cargarid_sucursalDetalleAsientoContableCajaChica;
	}

	public void setCargarid_sucursalDetalleAsientoContableCajaChica(Boolean cargarid_sucursalDetalleAsientoContableCajaChica) {
		this.cargarid_sucursalDetalleAsientoContableCajaChica= cargarid_sucursalDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_moduloDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_moduloDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloDetalleAsientoContableCajaChica() {
		return this.resaltarid_moduloDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_moduloDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_moduloDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_moduloDetalleAsientoContableCajaChica() {
		return this.mostrarid_moduloDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_moduloDetalleAsientoContableCajaChica(Boolean mostrarid_moduloDetalleAsientoContableCajaChica) {
		this.mostrarid_moduloDetalleAsientoContableCajaChica= mostrarid_moduloDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_moduloDetalleAsientoContableCajaChica() {
		return this.activarid_moduloDetalleAsientoContableCajaChica;
	}

	public void setActivarid_moduloDetalleAsientoContableCajaChica(Boolean activarid_moduloDetalleAsientoContableCajaChica) {
		this.activarid_moduloDetalleAsientoContableCajaChica= activarid_moduloDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_moduloDetalleAsientoContableCajaChica() {
		return this.cargarid_moduloDetalleAsientoContableCajaChica;
	}

	public void setCargarid_moduloDetalleAsientoContableCajaChica(Boolean cargarid_moduloDetalleAsientoContableCajaChica) {
		this.cargarid_moduloDetalleAsientoContableCajaChica= cargarid_moduloDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_ejercicioDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleAsientoContableCajaChica() {
		return this.resaltarid_ejercicioDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_ejercicioDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleAsientoContableCajaChica() {
		return this.mostrarid_ejercicioDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_ejercicioDetalleAsientoContableCajaChica(Boolean mostrarid_ejercicioDetalleAsientoContableCajaChica) {
		this.mostrarid_ejercicioDetalleAsientoContableCajaChica= mostrarid_ejercicioDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_ejercicioDetalleAsientoContableCajaChica() {
		return this.activarid_ejercicioDetalleAsientoContableCajaChica;
	}

	public void setActivarid_ejercicioDetalleAsientoContableCajaChica(Boolean activarid_ejercicioDetalleAsientoContableCajaChica) {
		this.activarid_ejercicioDetalleAsientoContableCajaChica= activarid_ejercicioDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_ejercicioDetalleAsientoContableCajaChica() {
		return this.cargarid_ejercicioDetalleAsientoContableCajaChica;
	}

	public void setCargarid_ejercicioDetalleAsientoContableCajaChica(Boolean cargarid_ejercicioDetalleAsientoContableCajaChica) {
		this.cargarid_ejercicioDetalleAsientoContableCajaChica= cargarid_ejercicioDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_periodoDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleAsientoContableCajaChica() {
		return this.resaltarid_periodoDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_periodoDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_periodoDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleAsientoContableCajaChica() {
		return this.mostrarid_periodoDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_periodoDetalleAsientoContableCajaChica(Boolean mostrarid_periodoDetalleAsientoContableCajaChica) {
		this.mostrarid_periodoDetalleAsientoContableCajaChica= mostrarid_periodoDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_periodoDetalleAsientoContableCajaChica() {
		return this.activarid_periodoDetalleAsientoContableCajaChica;
	}

	public void setActivarid_periodoDetalleAsientoContableCajaChica(Boolean activarid_periodoDetalleAsientoContableCajaChica) {
		this.activarid_periodoDetalleAsientoContableCajaChica= activarid_periodoDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_periodoDetalleAsientoContableCajaChica() {
		return this.cargarid_periodoDetalleAsientoContableCajaChica;
	}

	public void setCargarid_periodoDetalleAsientoContableCajaChica(Boolean cargarid_periodoDetalleAsientoContableCajaChica) {
		this.cargarid_periodoDetalleAsientoContableCajaChica= cargarid_periodoDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_anioDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_anioDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleAsientoContableCajaChica() {
		return this.resaltarid_anioDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_anioDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_anioDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleAsientoContableCajaChica() {
		return this.mostrarid_anioDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_anioDetalleAsientoContableCajaChica(Boolean mostrarid_anioDetalleAsientoContableCajaChica) {
		this.mostrarid_anioDetalleAsientoContableCajaChica= mostrarid_anioDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_anioDetalleAsientoContableCajaChica() {
		return this.activarid_anioDetalleAsientoContableCajaChica;
	}

	public void setActivarid_anioDetalleAsientoContableCajaChica(Boolean activarid_anioDetalleAsientoContableCajaChica) {
		this.activarid_anioDetalleAsientoContableCajaChica= activarid_anioDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_anioDetalleAsientoContableCajaChica() {
		return this.cargarid_anioDetalleAsientoContableCajaChica;
	}

	public void setCargarid_anioDetalleAsientoContableCajaChica(Boolean cargarid_anioDetalleAsientoContableCajaChica) {
		this.cargarid_anioDetalleAsientoContableCajaChica= cargarid_anioDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_mesDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_mesDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleAsientoContableCajaChica() {
		return this.resaltarid_mesDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_mesDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_mesDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleAsientoContableCajaChica() {
		return this.mostrarid_mesDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_mesDetalleAsientoContableCajaChica(Boolean mostrarid_mesDetalleAsientoContableCajaChica) {
		this.mostrarid_mesDetalleAsientoContableCajaChica= mostrarid_mesDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_mesDetalleAsientoContableCajaChica() {
		return this.activarid_mesDetalleAsientoContableCajaChica;
	}

	public void setActivarid_mesDetalleAsientoContableCajaChica(Boolean activarid_mesDetalleAsientoContableCajaChica) {
		this.activarid_mesDetalleAsientoContableCajaChica= activarid_mesDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_mesDetalleAsientoContableCajaChica() {
		return this.cargarid_mesDetalleAsientoContableCajaChica;
	}

	public void setCargarid_mesDetalleAsientoContableCajaChica(Boolean cargarid_mesDetalleAsientoContableCajaChica) {
		this.cargarid_mesDetalleAsientoContableCajaChica= cargarid_mesDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica() {
		return this.resaltarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica() {
		return this.mostrarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica(Boolean mostrarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica) {
		this.mostrarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica= mostrarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica() {
		return this.activarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica;
	}

	public void setActivarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica(Boolean activarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica) {
		this.activarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica= activarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica() {
		return this.cargarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica;
	}

	public void setCargarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica(Boolean cargarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica) {
		this.cargarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica= cargarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_tipo_gasto_empresaDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_tipo_gasto_empresaDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_gasto_empresaDetalleAsientoContableCajaChica() {
		return this.resaltarid_tipo_gasto_empresaDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_tipo_gasto_empresaDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_tipo_gasto_empresaDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_tipo_gasto_empresaDetalleAsientoContableCajaChica() {
		return this.mostrarid_tipo_gasto_empresaDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_tipo_gasto_empresaDetalleAsientoContableCajaChica(Boolean mostrarid_tipo_gasto_empresaDetalleAsientoContableCajaChica) {
		this.mostrarid_tipo_gasto_empresaDetalleAsientoContableCajaChica= mostrarid_tipo_gasto_empresaDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_tipo_gasto_empresaDetalleAsientoContableCajaChica() {
		return this.activarid_tipo_gasto_empresaDetalleAsientoContableCajaChica;
	}

	public void setActivarid_tipo_gasto_empresaDetalleAsientoContableCajaChica(Boolean activarid_tipo_gasto_empresaDetalleAsientoContableCajaChica) {
		this.activarid_tipo_gasto_empresaDetalleAsientoContableCajaChica= activarid_tipo_gasto_empresaDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_tipo_gasto_empresaDetalleAsientoContableCajaChica() {
		return this.cargarid_tipo_gasto_empresaDetalleAsientoContableCajaChica;
	}

	public void setCargarid_tipo_gasto_empresaDetalleAsientoContableCajaChica(Boolean cargarid_tipo_gasto_empresaDetalleAsientoContableCajaChica) {
		this.cargarid_tipo_gasto_empresaDetalleAsientoContableCajaChica= cargarid_tipo_gasto_empresaDetalleAsientoContableCajaChica;
	}

	public Border setResaltarfecha_emisionDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionDetalleAsientoContableCajaChica() {
		return this.resaltarfecha_emisionDetalleAsientoContableCajaChica;
	}

	public void setResaltarfecha_emisionDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarfecha_emisionDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionDetalleAsientoContableCajaChica() {
		return this.mostrarfecha_emisionDetalleAsientoContableCajaChica;
	}

	public void setMostrarfecha_emisionDetalleAsientoContableCajaChica(Boolean mostrarfecha_emisionDetalleAsientoContableCajaChica) {
		this.mostrarfecha_emisionDetalleAsientoContableCajaChica= mostrarfecha_emisionDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarfecha_emisionDetalleAsientoContableCajaChica() {
		return this.activarfecha_emisionDetalleAsientoContableCajaChica;
	}

	public void setActivarfecha_emisionDetalleAsientoContableCajaChica(Boolean activarfecha_emisionDetalleAsientoContableCajaChica) {
		this.activarfecha_emisionDetalleAsientoContableCajaChica= activarfecha_emisionDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_transaccionDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_transaccionDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionDetalleAsientoContableCajaChica() {
		return this.resaltarid_transaccionDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_transaccionDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_transaccionDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_transaccionDetalleAsientoContableCajaChica() {
		return this.mostrarid_transaccionDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_transaccionDetalleAsientoContableCajaChica(Boolean mostrarid_transaccionDetalleAsientoContableCajaChica) {
		this.mostrarid_transaccionDetalleAsientoContableCajaChica= mostrarid_transaccionDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_transaccionDetalleAsientoContableCajaChica() {
		return this.activarid_transaccionDetalleAsientoContableCajaChica;
	}

	public void setActivarid_transaccionDetalleAsientoContableCajaChica(Boolean activarid_transaccionDetalleAsientoContableCajaChica) {
		this.activarid_transaccionDetalleAsientoContableCajaChica= activarid_transaccionDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_transaccionDetalleAsientoContableCajaChica() {
		return this.cargarid_transaccionDetalleAsientoContableCajaChica;
	}

	public void setCargarid_transaccionDetalleAsientoContableCajaChica(Boolean cargarid_transaccionDetalleAsientoContableCajaChica) {
		this.cargarid_transaccionDetalleAsientoContableCajaChica= cargarid_transaccionDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_facturaDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_facturaDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_facturaDetalleAsientoContableCajaChica() {
		return this.resaltarid_facturaDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_facturaDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_facturaDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_facturaDetalleAsientoContableCajaChica() {
		return this.mostrarid_facturaDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_facturaDetalleAsientoContableCajaChica(Boolean mostrarid_facturaDetalleAsientoContableCajaChica) {
		this.mostrarid_facturaDetalleAsientoContableCajaChica= mostrarid_facturaDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_facturaDetalleAsientoContableCajaChica() {
		return this.activarid_facturaDetalleAsientoContableCajaChica;
	}

	public void setActivarid_facturaDetalleAsientoContableCajaChica(Boolean activarid_facturaDetalleAsientoContableCajaChica) {
		this.activarid_facturaDetalleAsientoContableCajaChica= activarid_facturaDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_facturaDetalleAsientoContableCajaChica() {
		return this.cargarid_facturaDetalleAsientoContableCajaChica;
	}

	public void setCargarid_facturaDetalleAsientoContableCajaChica(Boolean cargarid_facturaDetalleAsientoContableCajaChica) {
		this.cargarid_facturaDetalleAsientoContableCajaChica= cargarid_facturaDetalleAsientoContableCajaChica;
	}

	public Border setResaltares_proveedorDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltares_proveedorDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_proveedorDetalleAsientoContableCajaChica() {
		return this.resaltares_proveedorDetalleAsientoContableCajaChica;
	}

	public void setResaltares_proveedorDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltares_proveedorDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrares_proveedorDetalleAsientoContableCajaChica() {
		return this.mostrares_proveedorDetalleAsientoContableCajaChica;
	}

	public void setMostrares_proveedorDetalleAsientoContableCajaChica(Boolean mostrares_proveedorDetalleAsientoContableCajaChica) {
		this.mostrares_proveedorDetalleAsientoContableCajaChica= mostrares_proveedorDetalleAsientoContableCajaChica;
	}

	public Boolean getActivares_proveedorDetalleAsientoContableCajaChica() {
		return this.activares_proveedorDetalleAsientoContableCajaChica;
	}

	public void setActivares_proveedorDetalleAsientoContableCajaChica(Boolean activares_proveedorDetalleAsientoContableCajaChica) {
		this.activares_proveedorDetalleAsientoContableCajaChica= activares_proveedorDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_asiento_contableDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableDetalleAsientoContableCajaChica() {
		return this.resaltarid_asiento_contableDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_asiento_contableDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_asiento_contableDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableDetalleAsientoContableCajaChica() {
		return this.mostrarid_asiento_contableDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_asiento_contableDetalleAsientoContableCajaChica(Boolean mostrarid_asiento_contableDetalleAsientoContableCajaChica) {
		this.mostrarid_asiento_contableDetalleAsientoContableCajaChica= mostrarid_asiento_contableDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_asiento_contableDetalleAsientoContableCajaChica() {
		return this.activarid_asiento_contableDetalleAsientoContableCajaChica;
	}

	public void setActivarid_asiento_contableDetalleAsientoContableCajaChica(Boolean activarid_asiento_contableDetalleAsientoContableCajaChica) {
		this.activarid_asiento_contableDetalleAsientoContableCajaChica= activarid_asiento_contableDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_asiento_contableDetalleAsientoContableCajaChica() {
		return this.cargarid_asiento_contableDetalleAsientoContableCajaChica;
	}

	public void setCargarid_asiento_contableDetalleAsientoContableCajaChica(Boolean cargarid_asiento_contableDetalleAsientoContableCajaChica) {
		this.cargarid_asiento_contableDetalleAsientoContableCajaChica= cargarid_asiento_contableDetalleAsientoContableCajaChica;
	}

	public Border setResaltardetalleDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltardetalleDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleDetalleAsientoContableCajaChica() {
		return this.resaltardetalleDetalleAsientoContableCajaChica;
	}

	public void setResaltardetalleDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltardetalleDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrardetalleDetalleAsientoContableCajaChica() {
		return this.mostrardetalleDetalleAsientoContableCajaChica;
	}

	public void setMostrardetalleDetalleAsientoContableCajaChica(Boolean mostrardetalleDetalleAsientoContableCajaChica) {
		this.mostrardetalleDetalleAsientoContableCajaChica= mostrardetalleDetalleAsientoContableCajaChica;
	}

	public Boolean getActivardetalleDetalleAsientoContableCajaChica() {
		return this.activardetalleDetalleAsientoContableCajaChica;
	}

	public void setActivardetalleDetalleAsientoContableCajaChica(Boolean activardetalleDetalleAsientoContableCajaChica) {
		this.activardetalleDetalleAsientoContableCajaChica= activardetalleDetalleAsientoContableCajaChica;
	}

	public Border setResaltarvalor_bien_tarifa12DetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarvalor_bien_tarifa12DetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_bien_tarifa12DetalleAsientoContableCajaChica() {
		return this.resaltarvalor_bien_tarifa12DetalleAsientoContableCajaChica;
	}

	public void setResaltarvalor_bien_tarifa12DetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarvalor_bien_tarifa12DetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarvalor_bien_tarifa12DetalleAsientoContableCajaChica() {
		return this.mostrarvalor_bien_tarifa12DetalleAsientoContableCajaChica;
	}

	public void setMostrarvalor_bien_tarifa12DetalleAsientoContableCajaChica(Boolean mostrarvalor_bien_tarifa12DetalleAsientoContableCajaChica) {
		this.mostrarvalor_bien_tarifa12DetalleAsientoContableCajaChica= mostrarvalor_bien_tarifa12DetalleAsientoContableCajaChica;
	}

	public Boolean getActivarvalor_bien_tarifa12DetalleAsientoContableCajaChica() {
		return this.activarvalor_bien_tarifa12DetalleAsientoContableCajaChica;
	}

	public void setActivarvalor_bien_tarifa12DetalleAsientoContableCajaChica(Boolean activarvalor_bien_tarifa12DetalleAsientoContableCajaChica) {
		this.activarvalor_bien_tarifa12DetalleAsientoContableCajaChica= activarvalor_bien_tarifa12DetalleAsientoContableCajaChica;
	}

	public Border setResaltarvalor_servicio_tarifa12DetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarvalor_servicio_tarifa12DetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_servicio_tarifa12DetalleAsientoContableCajaChica() {
		return this.resaltarvalor_servicio_tarifa12DetalleAsientoContableCajaChica;
	}

	public void setResaltarvalor_servicio_tarifa12DetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarvalor_servicio_tarifa12DetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarvalor_servicio_tarifa12DetalleAsientoContableCajaChica() {
		return this.mostrarvalor_servicio_tarifa12DetalleAsientoContableCajaChica;
	}

	public void setMostrarvalor_servicio_tarifa12DetalleAsientoContableCajaChica(Boolean mostrarvalor_servicio_tarifa12DetalleAsientoContableCajaChica) {
		this.mostrarvalor_servicio_tarifa12DetalleAsientoContableCajaChica= mostrarvalor_servicio_tarifa12DetalleAsientoContableCajaChica;
	}

	public Boolean getActivarvalor_servicio_tarifa12DetalleAsientoContableCajaChica() {
		return this.activarvalor_servicio_tarifa12DetalleAsientoContableCajaChica;
	}

	public void setActivarvalor_servicio_tarifa12DetalleAsientoContableCajaChica(Boolean activarvalor_servicio_tarifa12DetalleAsientoContableCajaChica) {
		this.activarvalor_servicio_tarifa12DetalleAsientoContableCajaChica= activarvalor_servicio_tarifa12DetalleAsientoContableCajaChica;
	}

	public Border setResaltarporcentaje_ivaDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarporcentaje_ivaDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_ivaDetalleAsientoContableCajaChica() {
		return this.resaltarporcentaje_ivaDetalleAsientoContableCajaChica;
	}

	public void setResaltarporcentaje_ivaDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarporcentaje_ivaDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarporcentaje_ivaDetalleAsientoContableCajaChica() {
		return this.mostrarporcentaje_ivaDetalleAsientoContableCajaChica;
	}

	public void setMostrarporcentaje_ivaDetalleAsientoContableCajaChica(Boolean mostrarporcentaje_ivaDetalleAsientoContableCajaChica) {
		this.mostrarporcentaje_ivaDetalleAsientoContableCajaChica= mostrarporcentaje_ivaDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarporcentaje_ivaDetalleAsientoContableCajaChica() {
		return this.activarporcentaje_ivaDetalleAsientoContableCajaChica;
	}

	public void setActivarporcentaje_ivaDetalleAsientoContableCajaChica(Boolean activarporcentaje_ivaDetalleAsientoContableCajaChica) {
		this.activarporcentaje_ivaDetalleAsientoContableCajaChica= activarporcentaje_ivaDetalleAsientoContableCajaChica;
	}

	public Border setResaltarvalor_bien_tarifa0DetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarvalor_bien_tarifa0DetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_bien_tarifa0DetalleAsientoContableCajaChica() {
		return this.resaltarvalor_bien_tarifa0DetalleAsientoContableCajaChica;
	}

	public void setResaltarvalor_bien_tarifa0DetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarvalor_bien_tarifa0DetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarvalor_bien_tarifa0DetalleAsientoContableCajaChica() {
		return this.mostrarvalor_bien_tarifa0DetalleAsientoContableCajaChica;
	}

	public void setMostrarvalor_bien_tarifa0DetalleAsientoContableCajaChica(Boolean mostrarvalor_bien_tarifa0DetalleAsientoContableCajaChica) {
		this.mostrarvalor_bien_tarifa0DetalleAsientoContableCajaChica= mostrarvalor_bien_tarifa0DetalleAsientoContableCajaChica;
	}

	public Boolean getActivarvalor_bien_tarifa0DetalleAsientoContableCajaChica() {
		return this.activarvalor_bien_tarifa0DetalleAsientoContableCajaChica;
	}

	public void setActivarvalor_bien_tarifa0DetalleAsientoContableCajaChica(Boolean activarvalor_bien_tarifa0DetalleAsientoContableCajaChica) {
		this.activarvalor_bien_tarifa0DetalleAsientoContableCajaChica= activarvalor_bien_tarifa0DetalleAsientoContableCajaChica;
	}

	public Border setResaltarvalor_servicio_tarifa0DetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarvalor_servicio_tarifa0DetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_servicio_tarifa0DetalleAsientoContableCajaChica() {
		return this.resaltarvalor_servicio_tarifa0DetalleAsientoContableCajaChica;
	}

	public void setResaltarvalor_servicio_tarifa0DetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarvalor_servicio_tarifa0DetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarvalor_servicio_tarifa0DetalleAsientoContableCajaChica() {
		return this.mostrarvalor_servicio_tarifa0DetalleAsientoContableCajaChica;
	}

	public void setMostrarvalor_servicio_tarifa0DetalleAsientoContableCajaChica(Boolean mostrarvalor_servicio_tarifa0DetalleAsientoContableCajaChica) {
		this.mostrarvalor_servicio_tarifa0DetalleAsientoContableCajaChica= mostrarvalor_servicio_tarifa0DetalleAsientoContableCajaChica;
	}

	public Boolean getActivarvalor_servicio_tarifa0DetalleAsientoContableCajaChica() {
		return this.activarvalor_servicio_tarifa0DetalleAsientoContableCajaChica;
	}

	public void setActivarvalor_servicio_tarifa0DetalleAsientoContableCajaChica(Boolean activarvalor_servicio_tarifa0DetalleAsientoContableCajaChica) {
		this.activarvalor_servicio_tarifa0DetalleAsientoContableCajaChica= activarvalor_servicio_tarifa0DetalleAsientoContableCajaChica;
	}

	public Border setResaltarvalor_ivaDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarvalor_ivaDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_ivaDetalleAsientoContableCajaChica() {
		return this.resaltarvalor_ivaDetalleAsientoContableCajaChica;
	}

	public void setResaltarvalor_ivaDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarvalor_ivaDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarvalor_ivaDetalleAsientoContableCajaChica() {
		return this.mostrarvalor_ivaDetalleAsientoContableCajaChica;
	}

	public void setMostrarvalor_ivaDetalleAsientoContableCajaChica(Boolean mostrarvalor_ivaDetalleAsientoContableCajaChica) {
		this.mostrarvalor_ivaDetalleAsientoContableCajaChica= mostrarvalor_ivaDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarvalor_ivaDetalleAsientoContableCajaChica() {
		return this.activarvalor_ivaDetalleAsientoContableCajaChica;
	}

	public void setActivarvalor_ivaDetalleAsientoContableCajaChica(Boolean activarvalor_ivaDetalleAsientoContableCajaChica) {
		this.activarvalor_ivaDetalleAsientoContableCajaChica= activarvalor_ivaDetalleAsientoContableCajaChica;
	}

	public Border setResaltarvalor_bien_iceDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarvalor_bien_iceDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_bien_iceDetalleAsientoContableCajaChica() {
		return this.resaltarvalor_bien_iceDetalleAsientoContableCajaChica;
	}

	public void setResaltarvalor_bien_iceDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarvalor_bien_iceDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarvalor_bien_iceDetalleAsientoContableCajaChica() {
		return this.mostrarvalor_bien_iceDetalleAsientoContableCajaChica;
	}

	public void setMostrarvalor_bien_iceDetalleAsientoContableCajaChica(Boolean mostrarvalor_bien_iceDetalleAsientoContableCajaChica) {
		this.mostrarvalor_bien_iceDetalleAsientoContableCajaChica= mostrarvalor_bien_iceDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarvalor_bien_iceDetalleAsientoContableCajaChica() {
		return this.activarvalor_bien_iceDetalleAsientoContableCajaChica;
	}

	public void setActivarvalor_bien_iceDetalleAsientoContableCajaChica(Boolean activarvalor_bien_iceDetalleAsientoContableCajaChica) {
		this.activarvalor_bien_iceDetalleAsientoContableCajaChica= activarvalor_bien_iceDetalleAsientoContableCajaChica;
	}

	public Border setResaltarvalor_servicio_iceDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarvalor_servicio_iceDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_servicio_iceDetalleAsientoContableCajaChica() {
		return this.resaltarvalor_servicio_iceDetalleAsientoContableCajaChica;
	}

	public void setResaltarvalor_servicio_iceDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarvalor_servicio_iceDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarvalor_servicio_iceDetalleAsientoContableCajaChica() {
		return this.mostrarvalor_servicio_iceDetalleAsientoContableCajaChica;
	}

	public void setMostrarvalor_servicio_iceDetalleAsientoContableCajaChica(Boolean mostrarvalor_servicio_iceDetalleAsientoContableCajaChica) {
		this.mostrarvalor_servicio_iceDetalleAsientoContableCajaChica= mostrarvalor_servicio_iceDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarvalor_servicio_iceDetalleAsientoContableCajaChica() {
		return this.activarvalor_servicio_iceDetalleAsientoContableCajaChica;
	}

	public void setActivarvalor_servicio_iceDetalleAsientoContableCajaChica(Boolean activarvalor_servicio_iceDetalleAsientoContableCajaChica) {
		this.activarvalor_servicio_iceDetalleAsientoContableCajaChica= activarvalor_servicio_iceDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_centro_costoDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetalleAsientoContableCajaChica() {
		return this.resaltarid_centro_costoDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_centro_costoDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_centro_costoDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetalleAsientoContableCajaChica() {
		return this.mostrarid_centro_costoDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_centro_costoDetalleAsientoContableCajaChica(Boolean mostrarid_centro_costoDetalleAsientoContableCajaChica) {
		this.mostrarid_centro_costoDetalleAsientoContableCajaChica= mostrarid_centro_costoDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_centro_costoDetalleAsientoContableCajaChica() {
		return this.activarid_centro_costoDetalleAsientoContableCajaChica;
	}

	public void setActivarid_centro_costoDetalleAsientoContableCajaChica(Boolean activarid_centro_costoDetalleAsientoContableCajaChica) {
		this.activarid_centro_costoDetalleAsientoContableCajaChica= activarid_centro_costoDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_centro_costoDetalleAsientoContableCajaChica() {
		return this.cargarid_centro_costoDetalleAsientoContableCajaChica;
	}

	public void setCargarid_centro_costoDetalleAsientoContableCajaChica(Boolean cargarid_centro_costoDetalleAsientoContableCajaChica) {
		this.cargarid_centro_costoDetalleAsientoContableCajaChica= cargarid_centro_costoDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_tipo_cambioDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cambioDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioDetalleAsientoContableCajaChica() {
		return this.resaltarid_tipo_cambioDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_tipo_cambioDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_tipo_cambioDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioDetalleAsientoContableCajaChica() {
		return this.mostrarid_tipo_cambioDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_tipo_cambioDetalleAsientoContableCajaChica(Boolean mostrarid_tipo_cambioDetalleAsientoContableCajaChica) {
		this.mostrarid_tipo_cambioDetalleAsientoContableCajaChica= mostrarid_tipo_cambioDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_tipo_cambioDetalleAsientoContableCajaChica() {
		return this.activarid_tipo_cambioDetalleAsientoContableCajaChica;
	}

	public void setActivarid_tipo_cambioDetalleAsientoContableCajaChica(Boolean activarid_tipo_cambioDetalleAsientoContableCajaChica) {
		this.activarid_tipo_cambioDetalleAsientoContableCajaChica= activarid_tipo_cambioDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_tipo_cambioDetalleAsientoContableCajaChica() {
		return this.cargarid_tipo_cambioDetalleAsientoContableCajaChica;
	}

	public void setCargarid_tipo_cambioDetalleAsientoContableCajaChica(Boolean cargarid_tipo_cambioDetalleAsientoContableCajaChica) {
		this.cargarid_tipo_cambioDetalleAsientoContableCajaChica= cargarid_tipo_cambioDetalleAsientoContableCajaChica;
	}

	public Border setResaltarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica() {
		return this.resaltarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica;
	}

	public void setResaltarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica() {
		return this.mostrarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica;
	}

	public void setMostrarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica(Boolean mostrarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica) {
		this.mostrarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica= mostrarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica() {
		return this.activarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica;
	}

	public void setActivarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica(Boolean activarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica) {
		this.activarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica= activarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica;
	}

	public Boolean getCargarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica() {
		return this.cargarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica;
	}

	public void setCargarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica(Boolean cargarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica) {
		this.cargarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica= cargarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica;
	}

	public Border setResaltarfechaDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleasientocontablecajachicaBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContableCajaChica.setBorder(borderResaltar);
		
		this.resaltarfechaDetalleAsientoContableCajaChica= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaDetalleAsientoContableCajaChica() {
		return this.resaltarfechaDetalleAsientoContableCajaChica;
	}

	public void setResaltarfechaDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarfechaDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Boolean getMostrarfechaDetalleAsientoContableCajaChica() {
		return this.mostrarfechaDetalleAsientoContableCajaChica;
	}

	public void setMostrarfechaDetalleAsientoContableCajaChica(Boolean mostrarfechaDetalleAsientoContableCajaChica) {
		this.mostrarfechaDetalleAsientoContableCajaChica= mostrarfechaDetalleAsientoContableCajaChica;
	}

	public Boolean getActivarfechaDetalleAsientoContableCajaChica() {
		return this.activarfechaDetalleAsientoContableCajaChica;
	}

	public void setActivarfechaDetalleAsientoContableCajaChica(Boolean activarfechaDetalleAsientoContableCajaChica) {
		this.activarfechaDetalleAsientoContableCajaChica= activarfechaDetalleAsientoContableCajaChica;
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
		
		
		this.setMostraridDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_empresaDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_sucursalDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_moduloDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_ejercicioDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_periodoDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_anioDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_mesDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_tipo_gasto_empresaDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarfecha_emisionDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_transaccionDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_facturaDetalleAsientoContableCajaChica(esInicial);
		this.setMostrares_proveedorDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_asiento_contableDetalleAsientoContableCajaChica(esInicial);
		this.setMostrardetalleDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarvalor_bien_tarifa12DetalleAsientoContableCajaChica(esInicial);
		this.setMostrarvalor_servicio_tarifa12DetalleAsientoContableCajaChica(esInicial);
		this.setMostrarporcentaje_ivaDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarvalor_bien_tarifa0DetalleAsientoContableCajaChica(esInicial);
		this.setMostrarvalor_servicio_tarifa0DetalleAsientoContableCajaChica(esInicial);
		this.setMostrarvalor_ivaDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarvalor_bien_iceDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarvalor_servicio_iceDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_centro_costoDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_tipo_cambioDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica(esInicial);
		this.setMostrarfechaDetalleAsientoContableCajaChica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.ID)) {
				this.setMostraridDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLECAJACHICA)) {
				this.setMostrarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOGASTOEMPRESA)) {
				this.setMostrarid_tipo_gasto_empresaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDFACTURA)) {
				this.setMostrarid_facturaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR)) {
				this.setMostrares_proveedorDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.DETALLE)) {
				this.setMostrardetalleDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA12)) {
				this.setMostrarvalor_bien_tarifa12DetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA12)) {
				this.setMostrarvalor_servicio_tarifa12DetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.PORCENTAJEIVA)) {
				this.setMostrarporcentaje_ivaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA0)) {
				this.setMostrarvalor_bien_tarifa0DetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA0)) {
				this.setMostrarvalor_servicio_tarifa0DetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORIVA)) {
				this.setMostrarvalor_ivaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENICE)) {
				this.setMostrarvalor_bien_iceDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOICE)) {
				this.setMostrarvalor_servicio_iceDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setMostrarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.FECHA)) {
				this.setMostrarfechaDetalleAsientoContableCajaChica(esAsigna);
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
		
		
		this.setActivaridDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_empresaDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_sucursalDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_moduloDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_ejercicioDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_periodoDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_anioDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_mesDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_tipo_gasto_empresaDetalleAsientoContableCajaChica(esInicial);
		this.setActivarfecha_emisionDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_transaccionDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_facturaDetalleAsientoContableCajaChica(esInicial);
		this.setActivares_proveedorDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_asiento_contableDetalleAsientoContableCajaChica(esInicial);
		this.setActivardetalleDetalleAsientoContableCajaChica(esInicial);
		this.setActivarvalor_bien_tarifa12DetalleAsientoContableCajaChica(esInicial);
		this.setActivarvalor_servicio_tarifa12DetalleAsientoContableCajaChica(esInicial);
		this.setActivarporcentaje_ivaDetalleAsientoContableCajaChica(esInicial);
		this.setActivarvalor_bien_tarifa0DetalleAsientoContableCajaChica(esInicial);
		this.setActivarvalor_servicio_tarifa0DetalleAsientoContableCajaChica(esInicial);
		this.setActivarvalor_ivaDetalleAsientoContableCajaChica(esInicial);
		this.setActivarvalor_bien_iceDetalleAsientoContableCajaChica(esInicial);
		this.setActivarvalor_servicio_iceDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_centro_costoDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_tipo_cambioDetalleAsientoContableCajaChica(esInicial);
		this.setActivarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica(esInicial);
		this.setActivarfechaDetalleAsientoContableCajaChica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.ID)) {
				this.setActivaridDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLECAJACHICA)) {
				this.setActivarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOGASTOEMPRESA)) {
				this.setActivarid_tipo_gasto_empresaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDFACTURA)) {
				this.setActivarid_facturaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR)) {
				this.setActivares_proveedorDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.DETALLE)) {
				this.setActivardetalleDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA12)) {
				this.setActivarvalor_bien_tarifa12DetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA12)) {
				this.setActivarvalor_servicio_tarifa12DetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.PORCENTAJEIVA)) {
				this.setActivarporcentaje_ivaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA0)) {
				this.setActivarvalor_bien_tarifa0DetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA0)) {
				this.setActivarvalor_servicio_tarifa0DetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORIVA)) {
				this.setActivarvalor_ivaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENICE)) {
				this.setActivarvalor_bien_iceDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOICE)) {
				this.setActivarvalor_servicio_iceDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setActivarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.FECHA)) {
				this.setActivarfechaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_empresaDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_sucursalDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_moduloDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_ejercicioDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_periodoDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_anioDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_mesDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_tipo_gasto_empresaDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarfecha_emisionDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_transaccionDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_facturaDetalleAsientoContableCajaChica(esInicial);
		this.setResaltares_proveedorDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_asiento_contableDetalleAsientoContableCajaChica(esInicial);
		this.setResaltardetalleDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarvalor_bien_tarifa12DetalleAsientoContableCajaChica(esInicial);
		this.setResaltarvalor_servicio_tarifa12DetalleAsientoContableCajaChica(esInicial);
		this.setResaltarporcentaje_ivaDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarvalor_bien_tarifa0DetalleAsientoContableCajaChica(esInicial);
		this.setResaltarvalor_servicio_tarifa0DetalleAsientoContableCajaChica(esInicial);
		this.setResaltarvalor_ivaDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarvalor_bien_iceDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarvalor_servicio_iceDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_centro_costoDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_tipo_cambioDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica(esInicial);
		this.setResaltarfechaDetalleAsientoContableCajaChica(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.ID)) {
				this.setResaltaridDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLECAJACHICA)) {
				this.setResaltarid_asiento_contable_caja_chicaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOGASTOEMPRESA)) {
				this.setResaltarid_tipo_gasto_empresaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDFACTURA)) {
				this.setResaltarid_facturaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.ESPROVEEDOR)) {
				this.setResaltares_proveedorDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.DETALLE)) {
				this.setResaltardetalleDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA12)) {
				this.setResaltarvalor_bien_tarifa12DetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA12)) {
				this.setResaltarvalor_servicio_tarifa12DetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.PORCENTAJEIVA)) {
				this.setResaltarporcentaje_ivaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENTARIFA0)) {
				this.setResaltarvalor_bien_tarifa0DetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOTARIFA0)) {
				this.setResaltarvalor_servicio_tarifa0DetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORIVA)) {
				this.setResaltarvalor_ivaDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORBIENICE)) {
				this.setResaltarvalor_bien_iceDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.VALORSERVICIOICE)) {
				this.setResaltarvalor_servicio_iceDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.IDTIPOTRANSACCIONMODULO)) {
				this.setResaltarid_tipo_transaccion_moduloDetalleAsientoContableCajaChica(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableCajaChicaConstantesFunciones.FECHA)) {
				this.setResaltarfechaDetalleAsientoContableCajaChica(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableDetalleAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdAsientoContableDetalleAsientoContableCajaChica() {
		return this.mostrarFK_IdAsientoContableDetalleAsientoContableCajaChica;
	}

	public void setMostrarFK_IdAsientoContableDetalleAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableDetalleAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica() {
		return this.mostrarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica;
	}

	public void setMostrarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoDetalleAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdCentroCostoDetalleAsientoContableCajaChica() {
		return this.mostrarFK_IdCentroCostoDetalleAsientoContableCajaChica;
	}

	public void setMostrarFK_IdCentroCostoDetalleAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetalleAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdEjercicioDetalleAsientoContableCajaChica() {
		return this.mostrarFK_IdEjercicioDetalleAsientoContableCajaChica;
	}

	public void setMostrarFK_IdEjercicioDetalleAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdEmpresaDetalleAsientoContableCajaChica() {
		return this.mostrarFK_IdEmpresaDetalleAsientoContableCajaChica;
	}

	public void setMostrarFK_IdEmpresaDetalleAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFacturaDetalleAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdFacturaDetalleAsientoContableCajaChica() {
		return this.mostrarFK_IdFacturaDetalleAsientoContableCajaChica;
	}

	public void setMostrarFK_IdFacturaDetalleAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFacturaDetalleAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloDetalleAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdModuloDetalleAsientoContableCajaChica() {
		return this.mostrarFK_IdModuloDetalleAsientoContableCajaChica;
	}

	public void setMostrarFK_IdModuloDetalleAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloDetalleAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdPeriodoDetalleAsientoContableCajaChica() {
		return this.mostrarFK_IdPeriodoDetalleAsientoContableCajaChica;
	}

	public void setMostrarFK_IdPeriodoDetalleAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdSucursalDetalleAsientoContableCajaChica() {
		return this.mostrarFK_IdSucursalDetalleAsientoContableCajaChica;
	}

	public void setMostrarFK_IdSucursalDetalleAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCambioDetalleAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdTipoCambioDetalleAsientoContableCajaChica() {
		return this.mostrarFK_IdTipoCambioDetalleAsientoContableCajaChica;
	}

	public void setMostrarFK_IdTipoCambioDetalleAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCambioDetalleAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoGastoDetalleAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdTipoGastoDetalleAsientoContableCajaChica() {
		return this.mostrarFK_IdTipoGastoDetalleAsientoContableCajaChica;
	}

	public void setMostrarFK_IdTipoGastoDetalleAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoGastoDetalleAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica() {
		return this.mostrarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica;
	}

	public void setMostrarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTransaccionDetalleAsientoContableCajaChica=true;

	public Boolean getMostrarFK_IdTransaccionDetalleAsientoContableCajaChica() {
		return this.mostrarFK_IdTransaccionDetalleAsientoContableCajaChica;
	}

	public void setMostrarFK_IdTransaccionDetalleAsientoContableCajaChica(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTransaccionDetalleAsientoContableCajaChica= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableDetalleAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdAsientoContableDetalleAsientoContableCajaChica() {
		return this.activarFK_IdAsientoContableDetalleAsientoContableCajaChica;
	}

	public void setActivarFK_IdAsientoContableDetalleAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableDetalleAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica() {
		return this.activarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica;
	}

	public void setActivarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoDetalleAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdCentroCostoDetalleAsientoContableCajaChica() {
		return this.activarFK_IdCentroCostoDetalleAsientoContableCajaChica;
	}

	public void setActivarFK_IdCentroCostoDetalleAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetalleAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdEjercicioDetalleAsientoContableCajaChica() {
		return this.activarFK_IdEjercicioDetalleAsientoContableCajaChica;
	}

	public void setActivarFK_IdEjercicioDetalleAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdEmpresaDetalleAsientoContableCajaChica() {
		return this.activarFK_IdEmpresaDetalleAsientoContableCajaChica;
	}

	public void setActivarFK_IdEmpresaDetalleAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdFacturaDetalleAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdFacturaDetalleAsientoContableCajaChica() {
		return this.activarFK_IdFacturaDetalleAsientoContableCajaChica;
	}

	public void setActivarFK_IdFacturaDetalleAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdFacturaDetalleAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloDetalleAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdModuloDetalleAsientoContableCajaChica() {
		return this.activarFK_IdModuloDetalleAsientoContableCajaChica;
	}

	public void setActivarFK_IdModuloDetalleAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdModuloDetalleAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdPeriodoDetalleAsientoContableCajaChica() {
		return this.activarFK_IdPeriodoDetalleAsientoContableCajaChica;
	}

	public void setActivarFK_IdPeriodoDetalleAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdSucursalDetalleAsientoContableCajaChica() {
		return this.activarFK_IdSucursalDetalleAsientoContableCajaChica;
	}

	public void setActivarFK_IdSucursalDetalleAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCambioDetalleAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdTipoCambioDetalleAsientoContableCajaChica() {
		return this.activarFK_IdTipoCambioDetalleAsientoContableCajaChica;
	}

	public void setActivarFK_IdTipoCambioDetalleAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCambioDetalleAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoGastoDetalleAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdTipoGastoDetalleAsientoContableCajaChica() {
		return this.activarFK_IdTipoGastoDetalleAsientoContableCajaChica;
	}

	public void setActivarFK_IdTipoGastoDetalleAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdTipoGastoDetalleAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica() {
		return this.activarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica;
	}

	public void setActivarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica= habilitarResaltar;
	}

	public Boolean activarFK_IdTransaccionDetalleAsientoContableCajaChica=true;

	public Boolean getActivarFK_IdTransaccionDetalleAsientoContableCajaChica() {
		return this.activarFK_IdTransaccionDetalleAsientoContableCajaChica;
	}

	public void setActivarFK_IdTransaccionDetalleAsientoContableCajaChica(Boolean habilitarResaltar) {
		this.activarFK_IdTransaccionDetalleAsientoContableCajaChica= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableDetalleAsientoContableCajaChica=null;

	public Border getResaltarFK_IdAsientoContableDetalleAsientoContableCajaChica() {
		return this.resaltarFK_IdAsientoContableDetalleAsientoContableCajaChica;
	}

	public void setResaltarFK_IdAsientoContableDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableDetalleAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica=null;

	public Border getResaltarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica() {
		return this.resaltarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica;
	}

	public void setResaltarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableCajaChicaDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoDetalleAsientoContableCajaChica=null;

	public Border getResaltarFK_IdCentroCostoDetalleAsientoContableCajaChica() {
		return this.resaltarFK_IdCentroCostoDetalleAsientoContableCajaChica;
	}

	public void setResaltarFK_IdCentroCostoDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetalleAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleAsientoContableCajaChica=null;

	public Border getResaltarFK_IdEjercicioDetalleAsientoContableCajaChica() {
		return this.resaltarFK_IdEjercicioDetalleAsientoContableCajaChica;
	}

	public void setResaltarFK_IdEjercicioDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleAsientoContableCajaChica=null;

	public Border getResaltarFK_IdEmpresaDetalleAsientoContableCajaChica() {
		return this.resaltarFK_IdEmpresaDetalleAsientoContableCajaChica;
	}

	public void setResaltarFK_IdEmpresaDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdFacturaDetalleAsientoContableCajaChica=null;

	public Border getResaltarFK_IdFacturaDetalleAsientoContableCajaChica() {
		return this.resaltarFK_IdFacturaDetalleAsientoContableCajaChica;
	}

	public void setResaltarFK_IdFacturaDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdFacturaDetalleAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdFacturaDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFacturaDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdModuloDetalleAsientoContableCajaChica=null;

	public Border getResaltarFK_IdModuloDetalleAsientoContableCajaChica() {
		return this.resaltarFK_IdModuloDetalleAsientoContableCajaChica;
	}

	public void setResaltarFK_IdModuloDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdModuloDetalleAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdModuloDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleAsientoContableCajaChica=null;

	public Border getResaltarFK_IdPeriodoDetalleAsientoContableCajaChica() {
		return this.resaltarFK_IdPeriodoDetalleAsientoContableCajaChica;
	}

	public void setResaltarFK_IdPeriodoDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleAsientoContableCajaChica=null;

	public Border getResaltarFK_IdSucursalDetalleAsientoContableCajaChica() {
		return this.resaltarFK_IdSucursalDetalleAsientoContableCajaChica;
	}

	public void setResaltarFK_IdSucursalDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdTipoCambioDetalleAsientoContableCajaChica=null;

	public Border getResaltarFK_IdTipoCambioDetalleAsientoContableCajaChica() {
		return this.resaltarFK_IdTipoCambioDetalleAsientoContableCajaChica;
	}

	public void setResaltarFK_IdTipoCambioDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdTipoCambioDetalleAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdTipoCambioDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCambioDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdTipoGastoDetalleAsientoContableCajaChica=null;

	public Border getResaltarFK_IdTipoGastoDetalleAsientoContableCajaChica() {
		return this.resaltarFK_IdTipoGastoDetalleAsientoContableCajaChica;
	}

	public void setResaltarFK_IdTipoGastoDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdTipoGastoDetalleAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdTipoGastoDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoGastoDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica=null;

	public Border getResaltarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica() {
		return this.resaltarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica;
	}

	public void setResaltarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoTransaccionModuloDetalleAsientoContableCajaChica= borderResaltar;
	}

	public Border resaltarFK_IdTransaccionDetalleAsientoContableCajaChica=null;

	public Border getResaltarFK_IdTransaccionDetalleAsientoContableCajaChica() {
		return this.resaltarFK_IdTransaccionDetalleAsientoContableCajaChica;
	}

	public void setResaltarFK_IdTransaccionDetalleAsientoContableCajaChica(Border borderResaltar) {
		this.resaltarFK_IdTransaccionDetalleAsientoContableCajaChica= borderResaltar;
	}

	public void setResaltarFK_IdTransaccionDetalleAsientoContableCajaChica(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableCajaChicaBeanSwingJInternalFrame detalleasientocontablecajachicaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTransaccionDetalleAsientoContableCajaChica= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}