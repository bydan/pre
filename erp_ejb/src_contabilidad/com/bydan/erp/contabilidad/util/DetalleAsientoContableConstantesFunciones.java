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


import com.bydan.erp.contabilidad.util.DetalleAsientoContableConstantesFunciones;
import com.bydan.erp.contabilidad.util.DetalleAsientoContableParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.DetalleAsientoContableParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleAsientoContableConstantesFunciones extends DetalleAsientoContableConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleAsientoContable";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleAsientoContable"+DetalleAsientoContableConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleAsientoContableHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleAsientoContableHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleAsientoContableConstantesFunciones.SCHEMA+"_"+DetalleAsientoContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleAsientoContableHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleAsientoContableConstantesFunciones.SCHEMA+"_"+DetalleAsientoContableConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleAsientoContableConstantesFunciones.SCHEMA+"_"+DetalleAsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleAsientoContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleAsientoContableConstantesFunciones.SCHEMA+"_"+DetalleAsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleAsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleAsientoContableHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleAsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleAsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleAsientoContableHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleAsientoContableConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleAsientoContableConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleAsientoContableConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleAsientoContableConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleAsientoContableConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Asiento Contables";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Asiento Contable";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Asiento Contable";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleAsientoContable";
	public static final String OBJECTNAME="detalleasientocontable";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="detalle_asiento_contable";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleasientocontable from "+DetalleAsientoContableConstantesFunciones.SPERSISTENCENAME+" detalleasientocontable";
	public static String QUERYSELECTNATIVE="select "+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".version_row,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_empresa,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_asiento_contable,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".numero_documento,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_periodo,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_anio,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_mes,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_cuenta_contable,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".debito_local,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".credito_local,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".debito_extran,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".credito_extran,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_centro_actividad,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".cotizacion,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".detalle,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".id_tipo_cambio,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".con_centro_costo,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".fecha,"+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME+".numero_deposito from "+DetalleAsientoContableConstantesFunciones.SCHEMA+"."+DetalleAsientoContableConstantesFunciones.TABLENAME;//+" as "+DetalleAsientoContableConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleAsientoContableConstantesFuncionesAdditional detalleasientocontableConstantesFuncionesAdditional=null;
	
	public DetalleAsientoContableConstantesFuncionesAdditional getDetalleAsientoContableConstantesFuncionesAdditional() {
		return this.detalleasientocontableConstantesFuncionesAdditional;
	}
	
	public void setDetalleAsientoContableConstantesFuncionesAdditional(DetalleAsientoContableConstantesFuncionesAdditional detalleasientocontableConstantesFuncionesAdditional) {
		try {
			this.detalleasientocontableConstantesFuncionesAdditional=detalleasientocontableConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String NUMERODOCUMENTO= "numero_documento";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String DEBITOLOCAL= "debito_local";
    public static final String CREDITOLOCAL= "credito_local";
    public static final String DEBITOEXTRAN= "debito_extran";
    public static final String CREDITOEXTRAN= "credito_extran";
    public static final String IDCENTROACTIVIDAD= "id_centro_actividad";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String COTIZACION= "cotizacion";
    public static final String DETALLE= "detalle";
    public static final String IDTIPOCAMBIO= "id_tipo_cambio";
    public static final String CONCENTROCOSTO= "con_centro_costo";
    public static final String FECHA= "fecha";
    public static final String NUMERODEPOSITO= "numero_deposito";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento C.";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_NUMERODOCUMENTO= "No Documento";
		public static final String LABEL_NUMERODOCUMENTO_LOWER= "Numero Documento";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_DEBITOLOCAL= "Debito Local";
		public static final String LABEL_DEBITOLOCAL_LOWER= "Debito Local";
    	public static final String LABEL_CREDITOLOCAL= "Credito Local";
		public static final String LABEL_CREDITOLOCAL_LOWER= "Credito Local";
    	public static final String LABEL_DEBITOEXTRAN= "Debito Extran";
		public static final String LABEL_DEBITOEXTRAN_LOWER= "Debito Extran";
    	public static final String LABEL_CREDITOEXTRAN= "Credito Extran";
		public static final String LABEL_CREDITOEXTRAN_LOWER= "Credito Extran";
    	public static final String LABEL_IDCENTROACTIVIDAD= "Centro Actividad";
		public static final String LABEL_IDCENTROACTIVIDAD_LOWER= "Centro Actividad";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_COTIZACION= "Cotizacion";
		public static final String LABEL_COTIZACION_LOWER= "Cotizacion";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_IDTIPOCAMBIO= "Tipo Cambio";
		public static final String LABEL_IDTIPOCAMBIO_LOWER= "Tipo Cambio";
    	public static final String LABEL_CONCENTROCOSTO= "Con Centro Costo";
		public static final String LABEL_CONCENTROCOSTO_LOWER= "Con Centro Costo";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_NUMERODEPOSITO= "Numero Deposito";
		public static final String LABEL_NUMERODEPOSITO_LOWER= "Numero Deposito";
	
		
		
		
		
		
	public static final String SREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXNUMERO_DEPOSITO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DEPOSITO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDetalleAsientoContableLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.NUMERODOCUMENTO)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_NUMERODOCUMENTO;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.IDPERIODO)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.IDANIO)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.IDMES)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.DEBITOLOCAL)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_DEBITOLOCAL;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.CREDITOLOCAL)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_CREDITOLOCAL;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.DEBITOEXTRAN)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_DEBITOEXTRAN;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.CREDITOEXTRAN)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_CREDITOEXTRAN;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.IDCENTROACTIVIDAD)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_IDCENTROACTIVIDAD;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.COTIZACION)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_COTIZACION;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.DETALLE)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.IDTIPOCAMBIO)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_IDTIPOCAMBIO;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.CONCENTROCOSTO)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_CONCENTROCOSTO;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.FECHA)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(DetalleAsientoContableConstantesFunciones.NUMERODEPOSITO)) {sLabelColumna=DetalleAsientoContableConstantesFunciones.LABEL_NUMERODEPOSITO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
	public static String getcon_centro_costoDescripcion(DetalleAsientoContable detalleasientocontable) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!detalleasientocontable.getcon_centro_costo()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getcon_centro_costoHtmlDescripcion(DetalleAsientoContable detalleasientocontable) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(detalleasientocontable.getId(),detalleasientocontable.getcon_centro_costo());

		return sDescripcion;
	}	
			
			
	
	public static String getDetalleAsientoContableDescripcion(DetalleAsientoContable detalleasientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleasientocontable !=null/* && detalleasientocontable.getId()!=0*/) {
			if(detalleasientocontable.getId()!=null) {
				sDescripcion=detalleasientocontable.getId().toString();
			}//detalleasientocontabledetalleasientocontable.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleAsientoContableDescripcionDetallado(DetalleAsientoContable detalleasientocontable) {
		String sDescripcion="";
			
		sDescripcion+=DetalleAsientoContableConstantesFunciones.ID+"=";
		sDescripcion+=detalleasientocontable.getId().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleasientocontable.getVersionRow().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleasientocontable.getid_empresa().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detalleasientocontable.getid_sucursal().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=detalleasientocontable.getid_asiento_contable().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.NUMERODOCUMENTO+"=";
		sDescripcion+=detalleasientocontable.getnumero_documento()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detalleasientocontable.getid_ejercicio().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detalleasientocontable.getid_periodo().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.IDANIO+"=";
		sDescripcion+=detalleasientocontable.getid_anio().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.IDMES+"=";
		sDescripcion+=detalleasientocontable.getid_mes().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=detalleasientocontable.getid_cuenta_contable().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.DEBITOLOCAL+"=";
		sDescripcion+=detalleasientocontable.getdebito_local().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.CREDITOLOCAL+"=";
		sDescripcion+=detalleasientocontable.getcredito_local().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.DEBITOEXTRAN+"=";
		sDescripcion+=detalleasientocontable.getdebito_extran().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.CREDITOEXTRAN+"=";
		sDescripcion+=detalleasientocontable.getcredito_extran().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.IDCENTROACTIVIDAD+"=";
		sDescripcion+=detalleasientocontable.getid_centro_actividad().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=detalleasientocontable.getid_centro_costo().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.COTIZACION+"=";
		sDescripcion+=detalleasientocontable.getcotizacion().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.DETALLE+"=";
		sDescripcion+=detalleasientocontable.getdetalle()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.IDTIPOCAMBIO+"=";
		sDescripcion+=detalleasientocontable.getid_tipo_cambio().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.CONCENTROCOSTO+"=";
		sDescripcion+=detalleasientocontable.getcon_centro_costo().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.FECHA+"=";
		sDescripcion+=detalleasientocontable.getfecha().toString()+",";
		sDescripcion+=DetalleAsientoContableConstantesFunciones.NUMERODEPOSITO+"=";
		sDescripcion+=detalleasientocontable.getnumero_deposito()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleAsientoContableDescripcion(DetalleAsientoContable detalleasientocontable,String sValor) throws Exception {			
		if(detalleasientocontable !=null) {
			//detalleasientocontabledetalleasientocontable.getId().toString();
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

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
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

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCentroActividadDescripcion(CentroActividad centroactividad) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centroactividad!=null/*&&centroactividad.getId()>0*/) {
			sDescripcion=CentroActividadConstantesFunciones.getCentroActividadDescripcion(centroactividad);
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento C.";
		} else if(sNombreIndice.equals("FK_IdCentroActividad")) {
			sNombreIndice="Tipo=  Por Centro Actividad";
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCambio")) {
			sNombreIndice="Tipo=  Por Tipo Cambio";
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
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento C.="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroActividad(Long id_centro_actividad) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_actividad!=null) {sDetalleIndice+=" Codigo Unico De Centro Actividad="+id_centro_actividad.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetalleAsientoContable(DetalleAsientoContable detalleasientocontable,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleasientocontable.setnumero_documento(detalleasientocontable.getnumero_documento().trim());
		detalleasientocontable.setdetalle(detalleasientocontable.getdetalle().trim());
		detalleasientocontable.setnumero_deposito(detalleasientocontable.getnumero_deposito().trim());
	}
	
	public static void quitarEspaciosDetalleAsientoContables(List<DetalleAsientoContable> detalleasientocontables,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleAsientoContable detalleasientocontable: detalleasientocontables) {
			detalleasientocontable.setnumero_documento(detalleasientocontable.getnumero_documento().trim());
			detalleasientocontable.setdetalle(detalleasientocontable.getdetalle().trim());
			detalleasientocontable.setnumero_deposito(detalleasientocontable.getnumero_deposito().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleAsientoContable(DetalleAsientoContable detalleasientocontable,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleasientocontable.getConCambioAuxiliar()) {
			detalleasientocontable.setIsDeleted(detalleasientocontable.getIsDeletedAuxiliar());	
			detalleasientocontable.setIsNew(detalleasientocontable.getIsNewAuxiliar());	
			detalleasientocontable.setIsChanged(detalleasientocontable.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleasientocontable.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleasientocontable.setIsDeletedAuxiliar(false);	
			detalleasientocontable.setIsNewAuxiliar(false);	
			detalleasientocontable.setIsChangedAuxiliar(false);
			
			detalleasientocontable.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleAsientoContables(List<DetalleAsientoContable> detalleasientocontables,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleAsientoContable detalleasientocontable : detalleasientocontables) {
			if(conAsignarBase && detalleasientocontable.getConCambioAuxiliar()) {
				detalleasientocontable.setIsDeleted(detalleasientocontable.getIsDeletedAuxiliar());	
				detalleasientocontable.setIsNew(detalleasientocontable.getIsNewAuxiliar());	
				detalleasientocontable.setIsChanged(detalleasientocontable.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleasientocontable.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleasientocontable.setIsDeletedAuxiliar(false);	
				detalleasientocontable.setIsNewAuxiliar(false);	
				detalleasientocontable.setIsChangedAuxiliar(false);
				
				detalleasientocontable.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleAsientoContable(DetalleAsientoContable detalleasientocontable,Boolean conEnteros) throws Exception  {
		detalleasientocontable.setdebito_local(0.0);
		detalleasientocontable.setcredito_local(0.0);
		detalleasientocontable.setdebito_extran(0.0);
		detalleasientocontable.setcredito_extran(0.0);
		detalleasientocontable.setcotizacion(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleAsientoContables(List<DetalleAsientoContable> detalleasientocontables,Boolean conEnteros) throws Exception  {
		
		for(DetalleAsientoContable detalleasientocontable: detalleasientocontables) {
			detalleasientocontable.setdebito_local(0.0);
			detalleasientocontable.setcredito_local(0.0);
			detalleasientocontable.setdebito_extran(0.0);
			detalleasientocontable.setcredito_extran(0.0);
			detalleasientocontable.setcotizacion(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleAsientoContable(List<DetalleAsientoContable> detalleasientocontables,DetalleAsientoContable detalleasientocontableAux) throws Exception  {
		DetalleAsientoContableConstantesFunciones.InicializarValoresDetalleAsientoContable(detalleasientocontableAux,true);
		
		for(DetalleAsientoContable detalleasientocontable: detalleasientocontables) {
			if(detalleasientocontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleasientocontableAux.setdebito_local(detalleasientocontableAux.getdebito_local()+detalleasientocontable.getdebito_local());			
			detalleasientocontableAux.setcredito_local(detalleasientocontableAux.getcredito_local()+detalleasientocontable.getcredito_local());			
			detalleasientocontableAux.setdebito_extran(detalleasientocontableAux.getdebito_extran()+detalleasientocontable.getdebito_extran());			
			detalleasientocontableAux.setcredito_extran(detalleasientocontableAux.getcredito_extran()+detalleasientocontable.getcredito_extran());			
			detalleasientocontableAux.setcotizacion(detalleasientocontableAux.getcotizacion()+detalleasientocontable.getcotizacion());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleAsientoContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleAsientoContableConstantesFunciones.getArrayColumnasGlobalesDetalleAsientoContable(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleAsientoContable(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleAsientoContableConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleAsientoContableConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleAsientoContableConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleAsientoContableConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleAsientoContableConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleAsientoContableConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleAsientoContableConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleAsientoContableConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleAsientoContable(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleAsientoContable> detalleasientocontables,DetalleAsientoContable detalleasientocontable,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleAsientoContable detalleasientocontableAux: detalleasientocontables) {
			if(detalleasientocontableAux!=null && detalleasientocontable!=null) {
				if((detalleasientocontableAux.getId()==null && detalleasientocontable.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleasientocontableAux.getId()!=null && detalleasientocontable.getId()!=null){
					if(detalleasientocontableAux.getId().equals(detalleasientocontable.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleAsientoContable(List<DetalleAsientoContable> detalleasientocontables) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
		Double debito_extranTotal=0.0;
		Double credito_extranTotal=0.0;
		Double cotizacionTotal=0.0;
	
		for(DetalleAsientoContable detalleasientocontable: detalleasientocontables) {			
			if(detalleasientocontable.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_localTotal+=detalleasientocontable.getdebito_local();
			credito_localTotal+=detalleasientocontable.getcredito_local();
			debito_extranTotal+=detalleasientocontable.getdebito_extran();
			credito_extranTotal+=detalleasientocontable.getcredito_extran();
			cotizacionTotal+=detalleasientocontable.getcotizacion();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableConstantesFunciones.DEBITOEXTRAN);
		datoGeneral.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_DEBITOEXTRAN);
		datoGeneral.setdValorDouble(debito_extranTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableConstantesFunciones.CREDITOEXTRAN);
		datoGeneral.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_CREDITOEXTRAN);
		datoGeneral.setdValorDouble(credito_extranTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleAsientoContableConstantesFunciones.COTIZACION);
		datoGeneral.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_COTIZACION);
		datoGeneral.setdValorDouble(cotizacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleAsientoContable() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_ID, DetalleAsientoContableConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_VERSIONROW, DetalleAsientoContableConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_IDEMPRESA, DetalleAsientoContableConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_IDSUCURSAL, DetalleAsientoContableConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_IDASIENTOCONTABLE, DetalleAsientoContableConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_NUMERODOCUMENTO, DetalleAsientoContableConstantesFunciones.NUMERODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_IDEJERCICIO, DetalleAsientoContableConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_IDPERIODO, DetalleAsientoContableConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_IDANIO, DetalleAsientoContableConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_IDMES, DetalleAsientoContableConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_IDCUENTACONTABLE, DetalleAsientoContableConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_DEBITOLOCAL, DetalleAsientoContableConstantesFunciones.DEBITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_CREDITOLOCAL, DetalleAsientoContableConstantesFunciones.CREDITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_DEBITOEXTRAN, DetalleAsientoContableConstantesFunciones.DEBITOEXTRAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_CREDITOEXTRAN, DetalleAsientoContableConstantesFunciones.CREDITOEXTRAN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_IDCENTROACTIVIDAD, DetalleAsientoContableConstantesFunciones.IDCENTROACTIVIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_IDCENTROCOSTO, DetalleAsientoContableConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_COTIZACION, DetalleAsientoContableConstantesFunciones.COTIZACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_DETALLE, DetalleAsientoContableConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_IDTIPOCAMBIO, DetalleAsientoContableConstantesFunciones.IDTIPOCAMBIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_CONCENTROCOSTO, DetalleAsientoContableConstantesFunciones.CONCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_FECHA, DetalleAsientoContableConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleAsientoContableConstantesFunciones.LABEL_NUMERODEPOSITO, DetalleAsientoContableConstantesFunciones.NUMERODEPOSITO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleAsientoContable() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.NUMERODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.DEBITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.CREDITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.DEBITOEXTRAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.CREDITOEXTRAN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.IDCENTROACTIVIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.COTIZACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.IDTIPOCAMBIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.CONCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleAsientoContableConstantesFunciones.NUMERODEPOSITO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleAsientoContable() throws Exception  {
		return DetalleAsientoContableConstantesFunciones.getTiposSeleccionarDetalleAsientoContable(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleAsientoContable(Boolean conFk) throws Exception  {
		return DetalleAsientoContableConstantesFunciones.getTiposSeleccionarDetalleAsientoContable(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleAsientoContable(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_NUMERODOCUMENTO);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_NUMERODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_DEBITOLOCAL);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_DEBITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_CREDITOLOCAL);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_CREDITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_DEBITOEXTRAN);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_DEBITOEXTRAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_CREDITOEXTRAN);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_CREDITOEXTRAN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_IDCENTROACTIVIDAD);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_IDCENTROACTIVIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_COTIZACION);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_COTIZACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_IDTIPOCAMBIO);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_IDTIPOCAMBIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_CONCENTROCOSTO);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_CONCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleAsientoContableConstantesFunciones.LABEL_NUMERODEPOSITO);
			reporte.setsDescripcion(DetalleAsientoContableConstantesFunciones.LABEL_NUMERODEPOSITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleAsientoContable(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleAsientoContable(DetalleAsientoContable detalleasientocontableAux) throws Exception {
		
			detalleasientocontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleasientocontableAux.getEmpresa()));
			detalleasientocontableAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleasientocontableAux.getSucursal()));
			detalleasientocontableAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detalleasientocontableAux.getAsientoContable()));
			detalleasientocontableAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleasientocontableAux.getEjercicio()));
			detalleasientocontableAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleasientocontableAux.getPeriodo()));
			detalleasientocontableAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalleasientocontableAux.getAnio()));
			detalleasientocontableAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalleasientocontableAux.getMes()));
			detalleasientocontableAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detalleasientocontableAux.getCuentaContable()));
			detalleasientocontableAux.setcentroactividad_descripcion(CentroActividadConstantesFunciones.getCentroActividadDescripcion(detalleasientocontableAux.getCentroActividad()));
			detalleasientocontableAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detalleasientocontableAux.getCentroCosto()));
			detalleasientocontableAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(detalleasientocontableAux.getTipoCambio()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleAsientoContable(List<DetalleAsientoContable> detalleasientocontablesTemp) throws Exception {
		for(DetalleAsientoContable detalleasientocontableAux:detalleasientocontablesTemp) {
			
			detalleasientocontableAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleasientocontableAux.getEmpresa()));
			detalleasientocontableAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detalleasientocontableAux.getSucursal()));
			detalleasientocontableAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detalleasientocontableAux.getAsientoContable()));
			detalleasientocontableAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detalleasientocontableAux.getEjercicio()));
			detalleasientocontableAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detalleasientocontableAux.getPeriodo()));
			detalleasientocontableAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detalleasientocontableAux.getAnio()));
			detalleasientocontableAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detalleasientocontableAux.getMes()));
			detalleasientocontableAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detalleasientocontableAux.getCuentaContable()));
			detalleasientocontableAux.setcentroactividad_descripcion(CentroActividadConstantesFunciones.getCentroActividadDescripcion(detalleasientocontableAux.getCentroActividad()));
			detalleasientocontableAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(detalleasientocontableAux.getCentroCosto()));
			detalleasientocontableAux.settipocambio_descripcion(TipoCambioConstantesFunciones.getTipoCambioDescripcion(detalleasientocontableAux.getTipoCambio()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Anio.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CentroActividad.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(TipoCambio.class));
				
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
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
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
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CentroActividad.class)) {
						classes.add(new Classe(CentroActividad.class));
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleAsientoContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CentroActividad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroActividad.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
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

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
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

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CentroActividad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroActividad.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(TipoCambio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCambio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleAsientoContableConstantesFunciones.getClassesRelationshipsOfDetalleAsientoContable(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleAsientoContable(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleAsientoContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleAsientoContableConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleAsientoContable(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleAsientoContable(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleAsientoContable detalleasientocontable,List<DetalleAsientoContable> detalleasientocontables,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleAsientoContable detalleasientocontableEncontrado=null;
			
			for(DetalleAsientoContable detalleasientocontableLocal:detalleasientocontables) {
				if(detalleasientocontableLocal.getId().equals(detalleasientocontable.getId())) {
					detalleasientocontableEncontrado=detalleasientocontableLocal;
					
					detalleasientocontableLocal.setIsChanged(detalleasientocontable.getIsChanged());
					detalleasientocontableLocal.setIsNew(detalleasientocontable.getIsNew());
					detalleasientocontableLocal.setIsDeleted(detalleasientocontable.getIsDeleted());
					
					detalleasientocontableLocal.setGeneralEntityOriginal(detalleasientocontable.getGeneralEntityOriginal());
					
					detalleasientocontableLocal.setId(detalleasientocontable.getId());	
					detalleasientocontableLocal.setVersionRow(detalleasientocontable.getVersionRow());	
					detalleasientocontableLocal.setid_empresa(detalleasientocontable.getid_empresa());	
					detalleasientocontableLocal.setid_sucursal(detalleasientocontable.getid_sucursal());	
					detalleasientocontableLocal.setid_asiento_contable(detalleasientocontable.getid_asiento_contable());	
					detalleasientocontableLocal.setnumero_documento(detalleasientocontable.getnumero_documento());	
					detalleasientocontableLocal.setid_ejercicio(detalleasientocontable.getid_ejercicio());	
					detalleasientocontableLocal.setid_periodo(detalleasientocontable.getid_periodo());	
					detalleasientocontableLocal.setid_anio(detalleasientocontable.getid_anio());	
					detalleasientocontableLocal.setid_mes(detalleasientocontable.getid_mes());	
					detalleasientocontableLocal.setid_cuenta_contable(detalleasientocontable.getid_cuenta_contable());	
					detalleasientocontableLocal.setdebito_local(detalleasientocontable.getdebito_local());	
					detalleasientocontableLocal.setcredito_local(detalleasientocontable.getcredito_local());	
					detalleasientocontableLocal.setdebito_extran(detalleasientocontable.getdebito_extran());	
					detalleasientocontableLocal.setcredito_extran(detalleasientocontable.getcredito_extran());	
					detalleasientocontableLocal.setid_centro_actividad(detalleasientocontable.getid_centro_actividad());	
					detalleasientocontableLocal.setid_centro_costo(detalleasientocontable.getid_centro_costo());	
					detalleasientocontableLocal.setcotizacion(detalleasientocontable.getcotizacion());	
					detalleasientocontableLocal.setdetalle(detalleasientocontable.getdetalle());	
					detalleasientocontableLocal.setid_tipo_cambio(detalleasientocontable.getid_tipo_cambio());	
					detalleasientocontableLocal.setcon_centro_costo(detalleasientocontable.getcon_centro_costo());	
					detalleasientocontableLocal.setfecha(detalleasientocontable.getfecha());	
					detalleasientocontableLocal.setnumero_deposito(detalleasientocontable.getnumero_deposito());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleasientocontable.getIsDeleted()) {
				if(!existe) {
					detalleasientocontables.add(detalleasientocontable);
				}
			} else {
				if(detalleasientocontableEncontrado!=null && permiteQuitar)  {
					detalleasientocontables.remove(detalleasientocontableEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleAsientoContable detalleasientocontable,List<DetalleAsientoContable> detalleasientocontables) throws Exception {
		try	{			
			for(DetalleAsientoContable detalleasientocontableLocal:detalleasientocontables) {
				if(detalleasientocontableLocal.getId().equals(detalleasientocontable.getId())) {
					detalleasientocontableLocal.setIsSelected(detalleasientocontable.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleAsientoContable(List<DetalleAsientoContable> detalleasientocontablesAux) throws Exception {
		//this.detalleasientocontablesAux=detalleasientocontablesAux;
		
		for(DetalleAsientoContable detalleasientocontableAux:detalleasientocontablesAux) {
			if(detalleasientocontableAux.getIsChanged()) {
				detalleasientocontableAux.setIsChanged(false);
			}		
			
			if(detalleasientocontableAux.getIsNew()) {
				detalleasientocontableAux.setIsNew(false);
			}	
			
			if(detalleasientocontableAux.getIsDeleted()) {
				detalleasientocontableAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleAsientoContable(DetalleAsientoContable detalleasientocontableAux) throws Exception {
		//this.detalleasientocontableAux=detalleasientocontableAux;
		
			if(detalleasientocontableAux.getIsChanged()) {
				detalleasientocontableAux.setIsChanged(false);
			}		
			
			if(detalleasientocontableAux.getIsNew()) {
				detalleasientocontableAux.setIsNew(false);
			}	
			
			if(detalleasientocontableAux.getIsDeleted()) {
				detalleasientocontableAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleAsientoContable detalleasientocontableAsignar,DetalleAsientoContable detalleasientocontable) throws Exception {
		detalleasientocontableAsignar.setId(detalleasientocontable.getId());	
		detalleasientocontableAsignar.setVersionRow(detalleasientocontable.getVersionRow());	
		detalleasientocontableAsignar.setid_empresa(detalleasientocontable.getid_empresa());
		detalleasientocontableAsignar.setempresa_descripcion(detalleasientocontable.getempresa_descripcion());	
		detalleasientocontableAsignar.setid_sucursal(detalleasientocontable.getid_sucursal());
		detalleasientocontableAsignar.setsucursal_descripcion(detalleasientocontable.getsucursal_descripcion());	
		detalleasientocontableAsignar.setid_asiento_contable(detalleasientocontable.getid_asiento_contable());
		detalleasientocontableAsignar.setasientocontable_descripcion(detalleasientocontable.getasientocontable_descripcion());	
		detalleasientocontableAsignar.setnumero_documento(detalleasientocontable.getnumero_documento());	
		detalleasientocontableAsignar.setid_ejercicio(detalleasientocontable.getid_ejercicio());
		detalleasientocontableAsignar.setejercicio_descripcion(detalleasientocontable.getejercicio_descripcion());	
		detalleasientocontableAsignar.setid_periodo(detalleasientocontable.getid_periodo());
		detalleasientocontableAsignar.setperiodo_descripcion(detalleasientocontable.getperiodo_descripcion());	
		detalleasientocontableAsignar.setid_anio(detalleasientocontable.getid_anio());
		detalleasientocontableAsignar.setanio_descripcion(detalleasientocontable.getanio_descripcion());	
		detalleasientocontableAsignar.setid_mes(detalleasientocontable.getid_mes());
		detalleasientocontableAsignar.setmes_descripcion(detalleasientocontable.getmes_descripcion());	
		detalleasientocontableAsignar.setid_cuenta_contable(detalleasientocontable.getid_cuenta_contable());
		detalleasientocontableAsignar.setcuentacontable_descripcion(detalleasientocontable.getcuentacontable_descripcion());	
		detalleasientocontableAsignar.setdebito_local(detalleasientocontable.getdebito_local());	
		detalleasientocontableAsignar.setcredito_local(detalleasientocontable.getcredito_local());	
		detalleasientocontableAsignar.setdebito_extran(detalleasientocontable.getdebito_extran());	
		detalleasientocontableAsignar.setcredito_extran(detalleasientocontable.getcredito_extran());	
		detalleasientocontableAsignar.setid_centro_actividad(detalleasientocontable.getid_centro_actividad());
		detalleasientocontableAsignar.setcentroactividad_descripcion(detalleasientocontable.getcentroactividad_descripcion());	
		detalleasientocontableAsignar.setid_centro_costo(detalleasientocontable.getid_centro_costo());
		detalleasientocontableAsignar.setcentrocosto_descripcion(detalleasientocontable.getcentrocosto_descripcion());	
		detalleasientocontableAsignar.setcotizacion(detalleasientocontable.getcotizacion());	
		detalleasientocontableAsignar.setdetalle(detalleasientocontable.getdetalle());	
		detalleasientocontableAsignar.setid_tipo_cambio(detalleasientocontable.getid_tipo_cambio());
		detalleasientocontableAsignar.settipocambio_descripcion(detalleasientocontable.gettipocambio_descripcion());	
		detalleasientocontableAsignar.setcon_centro_costo(detalleasientocontable.getcon_centro_costo());	
		detalleasientocontableAsignar.setfecha(detalleasientocontable.getfecha());	
		detalleasientocontableAsignar.setnumero_deposito(detalleasientocontable.getnumero_deposito());	
	}
	
	public static void inicializarDetalleAsientoContable(DetalleAsientoContable detalleasientocontable) throws Exception {
		try {
				detalleasientocontable.setId(0L);	
					
				detalleasientocontable.setid_empresa(-1L);	
				detalleasientocontable.setid_sucursal(-1L);	
				detalleasientocontable.setid_asiento_contable(-1L);	
				detalleasientocontable.setnumero_documento("");	
				detalleasientocontable.setid_ejercicio(-1L);	
				detalleasientocontable.setid_periodo(-1L);	
				detalleasientocontable.setid_anio(null);	
				detalleasientocontable.setid_mes(null);	
				detalleasientocontable.setid_cuenta_contable(-1L);	
				detalleasientocontable.setdebito_local(0.0);	
				detalleasientocontable.setcredito_local(0.0);	
				detalleasientocontable.setdebito_extran(0.0);	
				detalleasientocontable.setcredito_extran(0.0);	
				detalleasientocontable.setid_centro_actividad(null);	
				detalleasientocontable.setid_centro_costo(null);	
				detalleasientocontable.setcotizacion(0.0);	
				detalleasientocontable.setdetalle("");	
				detalleasientocontable.setid_tipo_cambio(null);	
				detalleasientocontable.setcon_centro_costo(false);	
				detalleasientocontable.setfecha(new Date());	
				detalleasientocontable.setnumero_deposito("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleAsientoContable(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_NUMERODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_DEBITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_CREDITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_DEBITOEXTRAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_CREDITOEXTRAN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_IDCENTROACTIVIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_COTIZACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_IDTIPOCAMBIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_CONCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleAsientoContableConstantesFunciones.LABEL_NUMERODEPOSITO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleAsientoContable(String sTipo,Row row,Workbook workbook,DetalleAsientoContable detalleasientocontable,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getnumero_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getdebito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getcredito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getdebito_extran());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getcredito_extran());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getcentroactividad_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getcotizacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.gettipocambio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(detalleasientocontable.getcon_centro_costo()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleasientocontable.getnumero_deposito());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleAsientoContable=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleAsientoContable() {
		return this.sFinalQueryDetalleAsientoContable;
	}
	
	public void setsFinalQueryDetalleAsientoContable(String sFinalQueryDetalleAsientoContable) {
		this.sFinalQueryDetalleAsientoContable= sFinalQueryDetalleAsientoContable;
	}
	
	public Border resaltarSeleccionarDetalleAsientoContable=null;
	
	public Border setResaltarSeleccionarDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarSeleccionarDetalleAsientoContable= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleAsientoContable() {
		return this.resaltarSeleccionarDetalleAsientoContable;
	}
	
	public void setResaltarSeleccionarDetalleAsientoContable(Border borderResaltarSeleccionarDetalleAsientoContable) {
		this.resaltarSeleccionarDetalleAsientoContable= borderResaltarSeleccionarDetalleAsientoContable;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleAsientoContable=null;
	public Boolean mostraridDetalleAsientoContable=true;
	public Boolean activaridDetalleAsientoContable=false;

	public Border resaltarid_empresaDetalleAsientoContable=null;
	public Boolean mostrarid_empresaDetalleAsientoContable=true;
	public Boolean activarid_empresaDetalleAsientoContable=true;
	public Boolean cargarid_empresaDetalleAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetalleAsientoContable=null;
	public Boolean mostrarid_sucursalDetalleAsientoContable=true;
	public Boolean activarid_sucursalDetalleAsientoContable=true;
	public Boolean cargarid_sucursalDetalleAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetalleAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableDetalleAsientoContable=null;
	public Boolean mostrarid_asiento_contableDetalleAsientoContable=true;
	public Boolean activarid_asiento_contableDetalleAsientoContable=true;
	public Boolean cargarid_asiento_contableDetalleAsientoContable=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableDetalleAsientoContable=false;//ConEventDepend=true

	public Border resaltarnumero_documentoDetalleAsientoContable=null;
	public Boolean mostrarnumero_documentoDetalleAsientoContable=true;
	public Boolean activarnumero_documentoDetalleAsientoContable=true;

	public Border resaltarid_ejercicioDetalleAsientoContable=null;
	public Boolean mostrarid_ejercicioDetalleAsientoContable=true;
	public Boolean activarid_ejercicioDetalleAsientoContable=true;
	public Boolean cargarid_ejercicioDetalleAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetalleAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_periodoDetalleAsientoContable=null;
	public Boolean mostrarid_periodoDetalleAsientoContable=true;
	public Boolean activarid_periodoDetalleAsientoContable=true;
	public Boolean cargarid_periodoDetalleAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetalleAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_anioDetalleAsientoContable=null;
	public Boolean mostrarid_anioDetalleAsientoContable=true;
	public Boolean activarid_anioDetalleAsientoContable=false;
	public Boolean cargarid_anioDetalleAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetalleAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_mesDetalleAsientoContable=null;
	public Boolean mostrarid_mesDetalleAsientoContable=true;
	public Boolean activarid_mesDetalleAsientoContable=false;
	public Boolean cargarid_mesDetalleAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetalleAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableDetalleAsientoContable=null;
	public Boolean mostrarid_cuenta_contableDetalleAsientoContable=true;
	public Boolean activarid_cuenta_contableDetalleAsientoContable=true;
	public Boolean cargarid_cuenta_contableDetalleAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableDetalleAsientoContable=false;//ConEventDepend=true

	public Border resaltardebito_localDetalleAsientoContable=null;
	public Boolean mostrardebito_localDetalleAsientoContable=true;
	public Boolean activardebito_localDetalleAsientoContable=true;

	public Border resaltarcredito_localDetalleAsientoContable=null;
	public Boolean mostrarcredito_localDetalleAsientoContable=true;
	public Boolean activarcredito_localDetalleAsientoContable=true;

	public Border resaltardebito_extranDetalleAsientoContable=null;
	public Boolean mostrardebito_extranDetalleAsientoContable=true;
	public Boolean activardebito_extranDetalleAsientoContable=true;

	public Border resaltarcredito_extranDetalleAsientoContable=null;
	public Boolean mostrarcredito_extranDetalleAsientoContable=true;
	public Boolean activarcredito_extranDetalleAsientoContable=true;

	public Border resaltarid_centro_actividadDetalleAsientoContable=null;
	public Boolean mostrarid_centro_actividadDetalleAsientoContable=true;
	public Boolean activarid_centro_actividadDetalleAsientoContable=true;
	public Boolean cargarid_centro_actividadDetalleAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_actividadDetalleAsientoContable=false;//ConEventDepend=true

	public Border resaltarid_centro_costoDetalleAsientoContable=null;
	public Boolean mostrarid_centro_costoDetalleAsientoContable=true;
	public Boolean activarid_centro_costoDetalleAsientoContable=true;
	public Boolean cargarid_centro_costoDetalleAsientoContable=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoDetalleAsientoContable=false;//ConEventDepend=true

	public Border resaltarcotizacionDetalleAsientoContable=null;
	public Boolean mostrarcotizacionDetalleAsientoContable=true;
	public Boolean activarcotizacionDetalleAsientoContable=true;

	public Border resaltardetalleDetalleAsientoContable=null;
	public Boolean mostrardetalleDetalleAsientoContable=true;
	public Boolean activardetalleDetalleAsientoContable=true;

	public Border resaltarid_tipo_cambioDetalleAsientoContable=null;
	public Boolean mostrarid_tipo_cambioDetalleAsientoContable=true;
	public Boolean activarid_tipo_cambioDetalleAsientoContable=false;
	public Boolean cargarid_tipo_cambioDetalleAsientoContable=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cambioDetalleAsientoContable=false;//ConEventDepend=true

	public Border resaltarcon_centro_costoDetalleAsientoContable=null;
	public Boolean mostrarcon_centro_costoDetalleAsientoContable=true;
	public Boolean activarcon_centro_costoDetalleAsientoContable=false;

	public Border resaltarfechaDetalleAsientoContable=null;
	public Boolean mostrarfechaDetalleAsientoContable=true;
	public Boolean activarfechaDetalleAsientoContable=false;

	public Border resaltarnumero_depositoDetalleAsientoContable=null;
	public Boolean mostrarnumero_depositoDetalleAsientoContable=true;
	public Boolean activarnumero_depositoDetalleAsientoContable=false;

	
	

	public Border setResaltaridDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltaridDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleAsientoContable() {
		return this.resaltaridDetalleAsientoContable;
	}

	public void setResaltaridDetalleAsientoContable(Border borderResaltar) {
		this.resaltaridDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostraridDetalleAsientoContable() {
		return this.mostraridDetalleAsientoContable;
	}

	public void setMostraridDetalleAsientoContable(Boolean mostraridDetalleAsientoContable) {
		this.mostraridDetalleAsientoContable= mostraridDetalleAsientoContable;
	}

	public Boolean getActivaridDetalleAsientoContable() {
		return this.activaridDetalleAsientoContable;
	}

	public void setActivaridDetalleAsientoContable(Boolean activaridDetalleAsientoContable) {
		this.activaridDetalleAsientoContable= activaridDetalleAsientoContable;
	}

	public Border setResaltarid_empresaDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarid_empresaDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleAsientoContable() {
		return this.resaltarid_empresaDetalleAsientoContable;
	}

	public void setResaltarid_empresaDetalleAsientoContable(Border borderResaltar) {
		this.resaltarid_empresaDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleAsientoContable() {
		return this.mostrarid_empresaDetalleAsientoContable;
	}

	public void setMostrarid_empresaDetalleAsientoContable(Boolean mostrarid_empresaDetalleAsientoContable) {
		this.mostrarid_empresaDetalleAsientoContable= mostrarid_empresaDetalleAsientoContable;
	}

	public Boolean getActivarid_empresaDetalleAsientoContable() {
		return this.activarid_empresaDetalleAsientoContable;
	}

	public void setActivarid_empresaDetalleAsientoContable(Boolean activarid_empresaDetalleAsientoContable) {
		this.activarid_empresaDetalleAsientoContable= activarid_empresaDetalleAsientoContable;
	}

	public Boolean getCargarid_empresaDetalleAsientoContable() {
		return this.cargarid_empresaDetalleAsientoContable;
	}

	public void setCargarid_empresaDetalleAsientoContable(Boolean cargarid_empresaDetalleAsientoContable) {
		this.cargarid_empresaDetalleAsientoContable= cargarid_empresaDetalleAsientoContable;
	}

	public Border setResaltarid_sucursalDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarid_sucursalDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetalleAsientoContable() {
		return this.resaltarid_sucursalDetalleAsientoContable;
	}

	public void setResaltarid_sucursalDetalleAsientoContable(Border borderResaltar) {
		this.resaltarid_sucursalDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetalleAsientoContable() {
		return this.mostrarid_sucursalDetalleAsientoContable;
	}

	public void setMostrarid_sucursalDetalleAsientoContable(Boolean mostrarid_sucursalDetalleAsientoContable) {
		this.mostrarid_sucursalDetalleAsientoContable= mostrarid_sucursalDetalleAsientoContable;
	}

	public Boolean getActivarid_sucursalDetalleAsientoContable() {
		return this.activarid_sucursalDetalleAsientoContable;
	}

	public void setActivarid_sucursalDetalleAsientoContable(Boolean activarid_sucursalDetalleAsientoContable) {
		this.activarid_sucursalDetalleAsientoContable= activarid_sucursalDetalleAsientoContable;
	}

	public Boolean getCargarid_sucursalDetalleAsientoContable() {
		return this.cargarid_sucursalDetalleAsientoContable;
	}

	public void setCargarid_sucursalDetalleAsientoContable(Boolean cargarid_sucursalDetalleAsientoContable) {
		this.cargarid_sucursalDetalleAsientoContable= cargarid_sucursalDetalleAsientoContable;
	}

	public Border setResaltarid_asiento_contableDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarid_asiento_contableDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableDetalleAsientoContable() {
		return this.resaltarid_asiento_contableDetalleAsientoContable;
	}

	public void setResaltarid_asiento_contableDetalleAsientoContable(Border borderResaltar) {
		this.resaltarid_asiento_contableDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableDetalleAsientoContable() {
		return this.mostrarid_asiento_contableDetalleAsientoContable;
	}

	public void setMostrarid_asiento_contableDetalleAsientoContable(Boolean mostrarid_asiento_contableDetalleAsientoContable) {
		this.mostrarid_asiento_contableDetalleAsientoContable= mostrarid_asiento_contableDetalleAsientoContable;
	}

	public Boolean getActivarid_asiento_contableDetalleAsientoContable() {
		return this.activarid_asiento_contableDetalleAsientoContable;
	}

	public void setActivarid_asiento_contableDetalleAsientoContable(Boolean activarid_asiento_contableDetalleAsientoContable) {
		this.activarid_asiento_contableDetalleAsientoContable= activarid_asiento_contableDetalleAsientoContable;
	}

	public Boolean getCargarid_asiento_contableDetalleAsientoContable() {
		return this.cargarid_asiento_contableDetalleAsientoContable;
	}

	public void setCargarid_asiento_contableDetalleAsientoContable(Boolean cargarid_asiento_contableDetalleAsientoContable) {
		this.cargarid_asiento_contableDetalleAsientoContable= cargarid_asiento_contableDetalleAsientoContable;
	}

	public Border setResaltarnumero_documentoDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarnumero_documentoDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documentoDetalleAsientoContable() {
		return this.resaltarnumero_documentoDetalleAsientoContable;
	}

	public void setResaltarnumero_documentoDetalleAsientoContable(Border borderResaltar) {
		this.resaltarnumero_documentoDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarnumero_documentoDetalleAsientoContable() {
		return this.mostrarnumero_documentoDetalleAsientoContable;
	}

	public void setMostrarnumero_documentoDetalleAsientoContable(Boolean mostrarnumero_documentoDetalleAsientoContable) {
		this.mostrarnumero_documentoDetalleAsientoContable= mostrarnumero_documentoDetalleAsientoContable;
	}

	public Boolean getActivarnumero_documentoDetalleAsientoContable() {
		return this.activarnumero_documentoDetalleAsientoContable;
	}

	public void setActivarnumero_documentoDetalleAsientoContable(Boolean activarnumero_documentoDetalleAsientoContable) {
		this.activarnumero_documentoDetalleAsientoContable= activarnumero_documentoDetalleAsientoContable;
	}

	public Border setResaltarid_ejercicioDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarid_ejercicioDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetalleAsientoContable() {
		return this.resaltarid_ejercicioDetalleAsientoContable;
	}

	public void setResaltarid_ejercicioDetalleAsientoContable(Border borderResaltar) {
		this.resaltarid_ejercicioDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetalleAsientoContable() {
		return this.mostrarid_ejercicioDetalleAsientoContable;
	}

	public void setMostrarid_ejercicioDetalleAsientoContable(Boolean mostrarid_ejercicioDetalleAsientoContable) {
		this.mostrarid_ejercicioDetalleAsientoContable= mostrarid_ejercicioDetalleAsientoContable;
	}

	public Boolean getActivarid_ejercicioDetalleAsientoContable() {
		return this.activarid_ejercicioDetalleAsientoContable;
	}

	public void setActivarid_ejercicioDetalleAsientoContable(Boolean activarid_ejercicioDetalleAsientoContable) {
		this.activarid_ejercicioDetalleAsientoContable= activarid_ejercicioDetalleAsientoContable;
	}

	public Boolean getCargarid_ejercicioDetalleAsientoContable() {
		return this.cargarid_ejercicioDetalleAsientoContable;
	}

	public void setCargarid_ejercicioDetalleAsientoContable(Boolean cargarid_ejercicioDetalleAsientoContable) {
		this.cargarid_ejercicioDetalleAsientoContable= cargarid_ejercicioDetalleAsientoContable;
	}

	public Border setResaltarid_periodoDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarid_periodoDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetalleAsientoContable() {
		return this.resaltarid_periodoDetalleAsientoContable;
	}

	public void setResaltarid_periodoDetalleAsientoContable(Border borderResaltar) {
		this.resaltarid_periodoDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetalleAsientoContable() {
		return this.mostrarid_periodoDetalleAsientoContable;
	}

	public void setMostrarid_periodoDetalleAsientoContable(Boolean mostrarid_periodoDetalleAsientoContable) {
		this.mostrarid_periodoDetalleAsientoContable= mostrarid_periodoDetalleAsientoContable;
	}

	public Boolean getActivarid_periodoDetalleAsientoContable() {
		return this.activarid_periodoDetalleAsientoContable;
	}

	public void setActivarid_periodoDetalleAsientoContable(Boolean activarid_periodoDetalleAsientoContable) {
		this.activarid_periodoDetalleAsientoContable= activarid_periodoDetalleAsientoContable;
	}

	public Boolean getCargarid_periodoDetalleAsientoContable() {
		return this.cargarid_periodoDetalleAsientoContable;
	}

	public void setCargarid_periodoDetalleAsientoContable(Boolean cargarid_periodoDetalleAsientoContable) {
		this.cargarid_periodoDetalleAsientoContable= cargarid_periodoDetalleAsientoContable;
	}

	public Border setResaltarid_anioDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarid_anioDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetalleAsientoContable() {
		return this.resaltarid_anioDetalleAsientoContable;
	}

	public void setResaltarid_anioDetalleAsientoContable(Border borderResaltar) {
		this.resaltarid_anioDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_anioDetalleAsientoContable() {
		return this.mostrarid_anioDetalleAsientoContable;
	}

	public void setMostrarid_anioDetalleAsientoContable(Boolean mostrarid_anioDetalleAsientoContable) {
		this.mostrarid_anioDetalleAsientoContable= mostrarid_anioDetalleAsientoContable;
	}

	public Boolean getActivarid_anioDetalleAsientoContable() {
		return this.activarid_anioDetalleAsientoContable;
	}

	public void setActivarid_anioDetalleAsientoContable(Boolean activarid_anioDetalleAsientoContable) {
		this.activarid_anioDetalleAsientoContable= activarid_anioDetalleAsientoContable;
	}

	public Boolean getCargarid_anioDetalleAsientoContable() {
		return this.cargarid_anioDetalleAsientoContable;
	}

	public void setCargarid_anioDetalleAsientoContable(Boolean cargarid_anioDetalleAsientoContable) {
		this.cargarid_anioDetalleAsientoContable= cargarid_anioDetalleAsientoContable;
	}

	public Border setResaltarid_mesDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarid_mesDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetalleAsientoContable() {
		return this.resaltarid_mesDetalleAsientoContable;
	}

	public void setResaltarid_mesDetalleAsientoContable(Border borderResaltar) {
		this.resaltarid_mesDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_mesDetalleAsientoContable() {
		return this.mostrarid_mesDetalleAsientoContable;
	}

	public void setMostrarid_mesDetalleAsientoContable(Boolean mostrarid_mesDetalleAsientoContable) {
		this.mostrarid_mesDetalleAsientoContable= mostrarid_mesDetalleAsientoContable;
	}

	public Boolean getActivarid_mesDetalleAsientoContable() {
		return this.activarid_mesDetalleAsientoContable;
	}

	public void setActivarid_mesDetalleAsientoContable(Boolean activarid_mesDetalleAsientoContable) {
		this.activarid_mesDetalleAsientoContable= activarid_mesDetalleAsientoContable;
	}

	public Boolean getCargarid_mesDetalleAsientoContable() {
		return this.cargarid_mesDetalleAsientoContable;
	}

	public void setCargarid_mesDetalleAsientoContable(Boolean cargarid_mesDetalleAsientoContable) {
		this.cargarid_mesDetalleAsientoContable= cargarid_mesDetalleAsientoContable;
	}

	public Border setResaltarid_cuenta_contableDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarid_cuenta_contableDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableDetalleAsientoContable() {
		return this.resaltarid_cuenta_contableDetalleAsientoContable;
	}

	public void setResaltarid_cuenta_contableDetalleAsientoContable(Border borderResaltar) {
		this.resaltarid_cuenta_contableDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableDetalleAsientoContable() {
		return this.mostrarid_cuenta_contableDetalleAsientoContable;
	}

	public void setMostrarid_cuenta_contableDetalleAsientoContable(Boolean mostrarid_cuenta_contableDetalleAsientoContable) {
		this.mostrarid_cuenta_contableDetalleAsientoContable= mostrarid_cuenta_contableDetalleAsientoContable;
	}

	public Boolean getActivarid_cuenta_contableDetalleAsientoContable() {
		return this.activarid_cuenta_contableDetalleAsientoContable;
	}

	public void setActivarid_cuenta_contableDetalleAsientoContable(Boolean activarid_cuenta_contableDetalleAsientoContable) {
		this.activarid_cuenta_contableDetalleAsientoContable= activarid_cuenta_contableDetalleAsientoContable;
	}

	public Boolean getCargarid_cuenta_contableDetalleAsientoContable() {
		return this.cargarid_cuenta_contableDetalleAsientoContable;
	}

	public void setCargarid_cuenta_contableDetalleAsientoContable(Boolean cargarid_cuenta_contableDetalleAsientoContable) {
		this.cargarid_cuenta_contableDetalleAsientoContable= cargarid_cuenta_contableDetalleAsientoContable;
	}

	public Border setResaltardebito_localDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltardebito_localDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_localDetalleAsientoContable() {
		return this.resaltardebito_localDetalleAsientoContable;
	}

	public void setResaltardebito_localDetalleAsientoContable(Border borderResaltar) {
		this.resaltardebito_localDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrardebito_localDetalleAsientoContable() {
		return this.mostrardebito_localDetalleAsientoContable;
	}

	public void setMostrardebito_localDetalleAsientoContable(Boolean mostrardebito_localDetalleAsientoContable) {
		this.mostrardebito_localDetalleAsientoContable= mostrardebito_localDetalleAsientoContable;
	}

	public Boolean getActivardebito_localDetalleAsientoContable() {
		return this.activardebito_localDetalleAsientoContable;
	}

	public void setActivardebito_localDetalleAsientoContable(Boolean activardebito_localDetalleAsientoContable) {
		this.activardebito_localDetalleAsientoContable= activardebito_localDetalleAsientoContable;
	}

	public Border setResaltarcredito_localDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarcredito_localDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_localDetalleAsientoContable() {
		return this.resaltarcredito_localDetalleAsientoContable;
	}

	public void setResaltarcredito_localDetalleAsientoContable(Border borderResaltar) {
		this.resaltarcredito_localDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarcredito_localDetalleAsientoContable() {
		return this.mostrarcredito_localDetalleAsientoContable;
	}

	public void setMostrarcredito_localDetalleAsientoContable(Boolean mostrarcredito_localDetalleAsientoContable) {
		this.mostrarcredito_localDetalleAsientoContable= mostrarcredito_localDetalleAsientoContable;
	}

	public Boolean getActivarcredito_localDetalleAsientoContable() {
		return this.activarcredito_localDetalleAsientoContable;
	}

	public void setActivarcredito_localDetalleAsientoContable(Boolean activarcredito_localDetalleAsientoContable) {
		this.activarcredito_localDetalleAsientoContable= activarcredito_localDetalleAsientoContable;
	}

	public Border setResaltardebito_extranDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltardebito_extranDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_extranDetalleAsientoContable() {
		return this.resaltardebito_extranDetalleAsientoContable;
	}

	public void setResaltardebito_extranDetalleAsientoContable(Border borderResaltar) {
		this.resaltardebito_extranDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrardebito_extranDetalleAsientoContable() {
		return this.mostrardebito_extranDetalleAsientoContable;
	}

	public void setMostrardebito_extranDetalleAsientoContable(Boolean mostrardebito_extranDetalleAsientoContable) {
		this.mostrardebito_extranDetalleAsientoContable= mostrardebito_extranDetalleAsientoContable;
	}

	public Boolean getActivardebito_extranDetalleAsientoContable() {
		return this.activardebito_extranDetalleAsientoContable;
	}

	public void setActivardebito_extranDetalleAsientoContable(Boolean activardebito_extranDetalleAsientoContable) {
		this.activardebito_extranDetalleAsientoContable= activardebito_extranDetalleAsientoContable;
	}

	public Border setResaltarcredito_extranDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarcredito_extranDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_extranDetalleAsientoContable() {
		return this.resaltarcredito_extranDetalleAsientoContable;
	}

	public void setResaltarcredito_extranDetalleAsientoContable(Border borderResaltar) {
		this.resaltarcredito_extranDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarcredito_extranDetalleAsientoContable() {
		return this.mostrarcredito_extranDetalleAsientoContable;
	}

	public void setMostrarcredito_extranDetalleAsientoContable(Boolean mostrarcredito_extranDetalleAsientoContable) {
		this.mostrarcredito_extranDetalleAsientoContable= mostrarcredito_extranDetalleAsientoContable;
	}

	public Boolean getActivarcredito_extranDetalleAsientoContable() {
		return this.activarcredito_extranDetalleAsientoContable;
	}

	public void setActivarcredito_extranDetalleAsientoContable(Boolean activarcredito_extranDetalleAsientoContable) {
		this.activarcredito_extranDetalleAsientoContable= activarcredito_extranDetalleAsientoContable;
	}

	public Border setResaltarid_centro_actividadDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarid_centro_actividadDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_actividadDetalleAsientoContable() {
		return this.resaltarid_centro_actividadDetalleAsientoContable;
	}

	public void setResaltarid_centro_actividadDetalleAsientoContable(Border borderResaltar) {
		this.resaltarid_centro_actividadDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_centro_actividadDetalleAsientoContable() {
		return this.mostrarid_centro_actividadDetalleAsientoContable;
	}

	public void setMostrarid_centro_actividadDetalleAsientoContable(Boolean mostrarid_centro_actividadDetalleAsientoContable) {
		this.mostrarid_centro_actividadDetalleAsientoContable= mostrarid_centro_actividadDetalleAsientoContable;
	}

	public Boolean getActivarid_centro_actividadDetalleAsientoContable() {
		return this.activarid_centro_actividadDetalleAsientoContable;
	}

	public void setActivarid_centro_actividadDetalleAsientoContable(Boolean activarid_centro_actividadDetalleAsientoContable) {
		this.activarid_centro_actividadDetalleAsientoContable= activarid_centro_actividadDetalleAsientoContable;
	}

	public Boolean getCargarid_centro_actividadDetalleAsientoContable() {
		return this.cargarid_centro_actividadDetalleAsientoContable;
	}

	public void setCargarid_centro_actividadDetalleAsientoContable(Boolean cargarid_centro_actividadDetalleAsientoContable) {
		this.cargarid_centro_actividadDetalleAsientoContable= cargarid_centro_actividadDetalleAsientoContable;
	}

	public Border setResaltarid_centro_costoDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarid_centro_costoDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoDetalleAsientoContable() {
		return this.resaltarid_centro_costoDetalleAsientoContable;
	}

	public void setResaltarid_centro_costoDetalleAsientoContable(Border borderResaltar) {
		this.resaltarid_centro_costoDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoDetalleAsientoContable() {
		return this.mostrarid_centro_costoDetalleAsientoContable;
	}

	public void setMostrarid_centro_costoDetalleAsientoContable(Boolean mostrarid_centro_costoDetalleAsientoContable) {
		this.mostrarid_centro_costoDetalleAsientoContable= mostrarid_centro_costoDetalleAsientoContable;
	}

	public Boolean getActivarid_centro_costoDetalleAsientoContable() {
		return this.activarid_centro_costoDetalleAsientoContable;
	}

	public void setActivarid_centro_costoDetalleAsientoContable(Boolean activarid_centro_costoDetalleAsientoContable) {
		this.activarid_centro_costoDetalleAsientoContable= activarid_centro_costoDetalleAsientoContable;
	}

	public Boolean getCargarid_centro_costoDetalleAsientoContable() {
		return this.cargarid_centro_costoDetalleAsientoContable;
	}

	public void setCargarid_centro_costoDetalleAsientoContable(Boolean cargarid_centro_costoDetalleAsientoContable) {
		this.cargarid_centro_costoDetalleAsientoContable= cargarid_centro_costoDetalleAsientoContable;
	}

	public Border setResaltarcotizacionDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarcotizacionDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcotizacionDetalleAsientoContable() {
		return this.resaltarcotizacionDetalleAsientoContable;
	}

	public void setResaltarcotizacionDetalleAsientoContable(Border borderResaltar) {
		this.resaltarcotizacionDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarcotizacionDetalleAsientoContable() {
		return this.mostrarcotizacionDetalleAsientoContable;
	}

	public void setMostrarcotizacionDetalleAsientoContable(Boolean mostrarcotizacionDetalleAsientoContable) {
		this.mostrarcotizacionDetalleAsientoContable= mostrarcotizacionDetalleAsientoContable;
	}

	public Boolean getActivarcotizacionDetalleAsientoContable() {
		return this.activarcotizacionDetalleAsientoContable;
	}

	public void setActivarcotizacionDetalleAsientoContable(Boolean activarcotizacionDetalleAsientoContable) {
		this.activarcotizacionDetalleAsientoContable= activarcotizacionDetalleAsientoContable;
	}

	public Border setResaltardetalleDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltardetalleDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleDetalleAsientoContable() {
		return this.resaltardetalleDetalleAsientoContable;
	}

	public void setResaltardetalleDetalleAsientoContable(Border borderResaltar) {
		this.resaltardetalleDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrardetalleDetalleAsientoContable() {
		return this.mostrardetalleDetalleAsientoContable;
	}

	public void setMostrardetalleDetalleAsientoContable(Boolean mostrardetalleDetalleAsientoContable) {
		this.mostrardetalleDetalleAsientoContable= mostrardetalleDetalleAsientoContable;
	}

	public Boolean getActivardetalleDetalleAsientoContable() {
		return this.activardetalleDetalleAsientoContable;
	}

	public void setActivardetalleDetalleAsientoContable(Boolean activardetalleDetalleAsientoContable) {
		this.activardetalleDetalleAsientoContable= activardetalleDetalleAsientoContable;
	}

	public Border setResaltarid_tipo_cambioDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarid_tipo_cambioDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cambioDetalleAsientoContable() {
		return this.resaltarid_tipo_cambioDetalleAsientoContable;
	}

	public void setResaltarid_tipo_cambioDetalleAsientoContable(Border borderResaltar) {
		this.resaltarid_tipo_cambioDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cambioDetalleAsientoContable() {
		return this.mostrarid_tipo_cambioDetalleAsientoContable;
	}

	public void setMostrarid_tipo_cambioDetalleAsientoContable(Boolean mostrarid_tipo_cambioDetalleAsientoContable) {
		this.mostrarid_tipo_cambioDetalleAsientoContable= mostrarid_tipo_cambioDetalleAsientoContable;
	}

	public Boolean getActivarid_tipo_cambioDetalleAsientoContable() {
		return this.activarid_tipo_cambioDetalleAsientoContable;
	}

	public void setActivarid_tipo_cambioDetalleAsientoContable(Boolean activarid_tipo_cambioDetalleAsientoContable) {
		this.activarid_tipo_cambioDetalleAsientoContable= activarid_tipo_cambioDetalleAsientoContable;
	}

	public Boolean getCargarid_tipo_cambioDetalleAsientoContable() {
		return this.cargarid_tipo_cambioDetalleAsientoContable;
	}

	public void setCargarid_tipo_cambioDetalleAsientoContable(Boolean cargarid_tipo_cambioDetalleAsientoContable) {
		this.cargarid_tipo_cambioDetalleAsientoContable= cargarid_tipo_cambioDetalleAsientoContable;
	}

	public Border setResaltarcon_centro_costoDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarcon_centro_costoDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcon_centro_costoDetalleAsientoContable() {
		return this.resaltarcon_centro_costoDetalleAsientoContable;
	}

	public void setResaltarcon_centro_costoDetalleAsientoContable(Border borderResaltar) {
		this.resaltarcon_centro_costoDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarcon_centro_costoDetalleAsientoContable() {
		return this.mostrarcon_centro_costoDetalleAsientoContable;
	}

	public void setMostrarcon_centro_costoDetalleAsientoContable(Boolean mostrarcon_centro_costoDetalleAsientoContable) {
		this.mostrarcon_centro_costoDetalleAsientoContable= mostrarcon_centro_costoDetalleAsientoContable;
	}

	public Boolean getActivarcon_centro_costoDetalleAsientoContable() {
		return this.activarcon_centro_costoDetalleAsientoContable;
	}

	public void setActivarcon_centro_costoDetalleAsientoContable(Boolean activarcon_centro_costoDetalleAsientoContable) {
		this.activarcon_centro_costoDetalleAsientoContable= activarcon_centro_costoDetalleAsientoContable;
	}

	public Border setResaltarfechaDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarfechaDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaDetalleAsientoContable() {
		return this.resaltarfechaDetalleAsientoContable;
	}

	public void setResaltarfechaDetalleAsientoContable(Border borderResaltar) {
		this.resaltarfechaDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarfechaDetalleAsientoContable() {
		return this.mostrarfechaDetalleAsientoContable;
	}

	public void setMostrarfechaDetalleAsientoContable(Boolean mostrarfechaDetalleAsientoContable) {
		this.mostrarfechaDetalleAsientoContable= mostrarfechaDetalleAsientoContable;
	}

	public Boolean getActivarfechaDetalleAsientoContable() {
		return this.activarfechaDetalleAsientoContable;
	}

	public void setActivarfechaDetalleAsientoContable(Boolean activarfechaDetalleAsientoContable) {
		this.activarfechaDetalleAsientoContable= activarfechaDetalleAsientoContable;
	}

	public Border setResaltarnumero_depositoDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		/*
		//detalleasientocontableBeanSwingJInternalFrame.jTtoolBarDetalleAsientoContable.setBorder(borderResaltar);
		*/
		this.resaltarnumero_depositoDetalleAsientoContable= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_depositoDetalleAsientoContable() {
		return this.resaltarnumero_depositoDetalleAsientoContable;
	}

	public void setResaltarnumero_depositoDetalleAsientoContable(Border borderResaltar) {
		this.resaltarnumero_depositoDetalleAsientoContable= borderResaltar;
	}

	public Boolean getMostrarnumero_depositoDetalleAsientoContable() {
		return this.mostrarnumero_depositoDetalleAsientoContable;
	}

	public void setMostrarnumero_depositoDetalleAsientoContable(Boolean mostrarnumero_depositoDetalleAsientoContable) {
		this.mostrarnumero_depositoDetalleAsientoContable= mostrarnumero_depositoDetalleAsientoContable;
	}

	public Boolean getActivarnumero_depositoDetalleAsientoContable() {
		return this.activarnumero_depositoDetalleAsientoContable;
	}

	public void setActivarnumero_depositoDetalleAsientoContable(Boolean activarnumero_depositoDetalleAsientoContable) {
		this.activarnumero_depositoDetalleAsientoContable= activarnumero_depositoDetalleAsientoContable;
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
		
		
		this.setMostraridDetalleAsientoContable(esInicial);
		this.setMostrarid_empresaDetalleAsientoContable(esInicial);
		this.setMostrarid_sucursalDetalleAsientoContable(esInicial);
		this.setMostrarid_asiento_contableDetalleAsientoContable(esInicial);
		this.setMostrarnumero_documentoDetalleAsientoContable(esInicial);
		this.setMostrarid_ejercicioDetalleAsientoContable(esInicial);
		this.setMostrarid_periodoDetalleAsientoContable(esInicial);
		this.setMostrarid_anioDetalleAsientoContable(esInicial);
		this.setMostrarid_mesDetalleAsientoContable(esInicial);
		this.setMostrarid_cuenta_contableDetalleAsientoContable(esInicial);
		this.setMostrardebito_localDetalleAsientoContable(esInicial);
		this.setMostrarcredito_localDetalleAsientoContable(esInicial);
		this.setMostrardebito_extranDetalleAsientoContable(esInicial);
		this.setMostrarcredito_extranDetalleAsientoContable(esInicial);
		this.setMostrarid_centro_actividadDetalleAsientoContable(esInicial);
		this.setMostrarid_centro_costoDetalleAsientoContable(esInicial);
		this.setMostrarcotizacionDetalleAsientoContable(esInicial);
		this.setMostrardetalleDetalleAsientoContable(esInicial);
		this.setMostrarid_tipo_cambioDetalleAsientoContable(esInicial);
		this.setMostrarcon_centro_costoDetalleAsientoContable(esInicial);
		this.setMostrarfechaDetalleAsientoContable(esInicial);
		this.setMostrarnumero_depositoDetalleAsientoContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.ID)) {
				this.setMostraridDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.NUMERODOCUMENTO)) {
				this.setMostrarnumero_documentoDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.DEBITOLOCAL)) {
				this.setMostrardebito_localDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.CREDITOLOCAL)) {
				this.setMostrarcredito_localDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.DEBITOEXTRAN)) {
				this.setMostrardebito_extranDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.CREDITOEXTRAN)) {
				this.setMostrarcredito_extranDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setMostrarid_centro_actividadDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.COTIZACION)) {
				this.setMostrarcotizacionDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.DETALLE)) {
				this.setMostrardetalleDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDTIPOCAMBIO)) {
				this.setMostrarid_tipo_cambioDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.CONCENTROCOSTO)) {
				this.setMostrarcon_centro_costoDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.FECHA)) {
				this.setMostrarfechaDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.NUMERODEPOSITO)) {
				this.setMostrarnumero_depositoDetalleAsientoContable(esAsigna);
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
		
		
		this.setActivaridDetalleAsientoContable(esInicial);
		this.setActivarid_empresaDetalleAsientoContable(esInicial);
		this.setActivarid_sucursalDetalleAsientoContable(esInicial);
		this.setActivarid_asiento_contableDetalleAsientoContable(esInicial);
		this.setActivarnumero_documentoDetalleAsientoContable(esInicial);
		this.setActivarid_ejercicioDetalleAsientoContable(esInicial);
		this.setActivarid_periodoDetalleAsientoContable(esInicial);
		this.setActivarid_anioDetalleAsientoContable(esInicial);
		this.setActivarid_mesDetalleAsientoContable(esInicial);
		this.setActivarid_cuenta_contableDetalleAsientoContable(esInicial);
		this.setActivardebito_localDetalleAsientoContable(esInicial);
		this.setActivarcredito_localDetalleAsientoContable(esInicial);
		this.setActivardebito_extranDetalleAsientoContable(esInicial);
		this.setActivarcredito_extranDetalleAsientoContable(esInicial);
		this.setActivarid_centro_actividadDetalleAsientoContable(esInicial);
		this.setActivarid_centro_costoDetalleAsientoContable(esInicial);
		this.setActivarcotizacionDetalleAsientoContable(esInicial);
		this.setActivardetalleDetalleAsientoContable(esInicial);
		this.setActivarid_tipo_cambioDetalleAsientoContable(esInicial);
		this.setActivarcon_centro_costoDetalleAsientoContable(esInicial);
		this.setActivarfechaDetalleAsientoContable(esInicial);
		this.setActivarnumero_depositoDetalleAsientoContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.ID)) {
				this.setActivaridDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.NUMERODOCUMENTO)) {
				this.setActivarnumero_documentoDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.DEBITOLOCAL)) {
				this.setActivardebito_localDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.CREDITOLOCAL)) {
				this.setActivarcredito_localDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.DEBITOEXTRAN)) {
				this.setActivardebito_extranDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.CREDITOEXTRAN)) {
				this.setActivarcredito_extranDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setActivarid_centro_actividadDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.COTIZACION)) {
				this.setActivarcotizacionDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.DETALLE)) {
				this.setActivardetalleDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDTIPOCAMBIO)) {
				this.setActivarid_tipo_cambioDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.CONCENTROCOSTO)) {
				this.setActivarcon_centro_costoDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.FECHA)) {
				this.setActivarfechaDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.NUMERODEPOSITO)) {
				this.setActivarnumero_depositoDetalleAsientoContable(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleAsientoContable(esInicial);
		this.setResaltarid_empresaDetalleAsientoContable(esInicial);
		this.setResaltarid_sucursalDetalleAsientoContable(esInicial);
		this.setResaltarid_asiento_contableDetalleAsientoContable(esInicial);
		this.setResaltarnumero_documentoDetalleAsientoContable(esInicial);
		this.setResaltarid_ejercicioDetalleAsientoContable(esInicial);
		this.setResaltarid_periodoDetalleAsientoContable(esInicial);
		this.setResaltarid_anioDetalleAsientoContable(esInicial);
		this.setResaltarid_mesDetalleAsientoContable(esInicial);
		this.setResaltarid_cuenta_contableDetalleAsientoContable(esInicial);
		this.setResaltardebito_localDetalleAsientoContable(esInicial);
		this.setResaltarcredito_localDetalleAsientoContable(esInicial);
		this.setResaltardebito_extranDetalleAsientoContable(esInicial);
		this.setResaltarcredito_extranDetalleAsientoContable(esInicial);
		this.setResaltarid_centro_actividadDetalleAsientoContable(esInicial);
		this.setResaltarid_centro_costoDetalleAsientoContable(esInicial);
		this.setResaltarcotizacionDetalleAsientoContable(esInicial);
		this.setResaltardetalleDetalleAsientoContable(esInicial);
		this.setResaltarid_tipo_cambioDetalleAsientoContable(esInicial);
		this.setResaltarcon_centro_costoDetalleAsientoContable(esInicial);
		this.setResaltarfechaDetalleAsientoContable(esInicial);
		this.setResaltarnumero_depositoDetalleAsientoContable(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.ID)) {
				this.setResaltaridDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.NUMERODOCUMENTO)) {
				this.setResaltarnumero_documentoDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.DEBITOLOCAL)) {
				this.setResaltardebito_localDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.CREDITOLOCAL)) {
				this.setResaltarcredito_localDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.DEBITOEXTRAN)) {
				this.setResaltardebito_extranDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.CREDITOEXTRAN)) {
				this.setResaltarcredito_extranDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDCENTROACTIVIDAD)) {
				this.setResaltarid_centro_actividadDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.COTIZACION)) {
				this.setResaltarcotizacionDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.DETALLE)) {
				this.setResaltardetalleDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.IDTIPOCAMBIO)) {
				this.setResaltarid_tipo_cambioDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.CONCENTROCOSTO)) {
				this.setResaltarcon_centro_costoDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.FECHA)) {
				this.setResaltarfechaDetalleAsientoContable(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleAsientoContableConstantesFunciones.NUMERODEPOSITO)) {
				this.setResaltarnumero_depositoDetalleAsientoContable(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableDetalleAsientoContable=true;

	public Boolean getMostrarFK_IdAsientoContableDetalleAsientoContable() {
		return this.mostrarFK_IdAsientoContableDetalleAsientoContable;
	}

	public void setMostrarFK_IdAsientoContableDetalleAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableDetalleAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroActividadDetalleAsientoContable=true;

	public Boolean getMostrarFK_IdCentroActividadDetalleAsientoContable() {
		return this.mostrarFK_IdCentroActividadDetalleAsientoContable;
	}

	public void setMostrarFK_IdCentroActividadDetalleAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroActividadDetalleAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCentroCostoDetalleAsientoContable=true;

	public Boolean getMostrarFK_IdCentroCostoDetalleAsientoContable() {
		return this.mostrarFK_IdCentroCostoDetalleAsientoContable;
	}

	public void setMostrarFK_IdCentroCostoDetalleAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoDetalleAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDetalleAsientoContable=true;

	public Boolean getMostrarFK_IdCuentaContableDetalleAsientoContable() {
		return this.mostrarFK_IdCuentaContableDetalleAsientoContable;
	}

	public void setMostrarFK_IdCuentaContableDetalleAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDetalleAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetalleAsientoContable=true;

	public Boolean getMostrarFK_IdEjercicioDetalleAsientoContable() {
		return this.mostrarFK_IdEjercicioDetalleAsientoContable;
	}

	public void setMostrarFK_IdEjercicioDetalleAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetalleAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleAsientoContable=true;

	public Boolean getMostrarFK_IdEmpresaDetalleAsientoContable() {
		return this.mostrarFK_IdEmpresaDetalleAsientoContable;
	}

	public void setMostrarFK_IdEmpresaDetalleAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetalleAsientoContable=true;

	public Boolean getMostrarFK_IdPeriodoDetalleAsientoContable() {
		return this.mostrarFK_IdPeriodoDetalleAsientoContable;
	}

	public void setMostrarFK_IdPeriodoDetalleAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetalleAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetalleAsientoContable=true;

	public Boolean getMostrarFK_IdSucursalDetalleAsientoContable() {
		return this.mostrarFK_IdSucursalDetalleAsientoContable;
	}

	public void setMostrarFK_IdSucursalDetalleAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetalleAsientoContable= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCambioDetalleAsientoContable=true;

	public Boolean getMostrarFK_IdTipoCambioDetalleAsientoContable() {
		return this.mostrarFK_IdTipoCambioDetalleAsientoContable;
	}

	public void setMostrarFK_IdTipoCambioDetalleAsientoContable(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCambioDetalleAsientoContable= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableDetalleAsientoContable=true;

	public Boolean getActivarFK_IdAsientoContableDetalleAsientoContable() {
		return this.activarFK_IdAsientoContableDetalleAsientoContable;
	}

	public void setActivarFK_IdAsientoContableDetalleAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableDetalleAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroActividadDetalleAsientoContable=true;

	public Boolean getActivarFK_IdCentroActividadDetalleAsientoContable() {
		return this.activarFK_IdCentroActividadDetalleAsientoContable;
	}

	public void setActivarFK_IdCentroActividadDetalleAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdCentroActividadDetalleAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdCentroCostoDetalleAsientoContable=true;

	public Boolean getActivarFK_IdCentroCostoDetalleAsientoContable() {
		return this.activarFK_IdCentroCostoDetalleAsientoContable;
	}

	public void setActivarFK_IdCentroCostoDetalleAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoDetalleAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDetalleAsientoContable=true;

	public Boolean getActivarFK_IdCuentaContableDetalleAsientoContable() {
		return this.activarFK_IdCuentaContableDetalleAsientoContable;
	}

	public void setActivarFK_IdCuentaContableDetalleAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDetalleAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetalleAsientoContable=true;

	public Boolean getActivarFK_IdEjercicioDetalleAsientoContable() {
		return this.activarFK_IdEjercicioDetalleAsientoContable;
	}

	public void setActivarFK_IdEjercicioDetalleAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetalleAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleAsientoContable=true;

	public Boolean getActivarFK_IdEmpresaDetalleAsientoContable() {
		return this.activarFK_IdEmpresaDetalleAsientoContable;
	}

	public void setActivarFK_IdEmpresaDetalleAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetalleAsientoContable=true;

	public Boolean getActivarFK_IdPeriodoDetalleAsientoContable() {
		return this.activarFK_IdPeriodoDetalleAsientoContable;
	}

	public void setActivarFK_IdPeriodoDetalleAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetalleAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetalleAsientoContable=true;

	public Boolean getActivarFK_IdSucursalDetalleAsientoContable() {
		return this.activarFK_IdSucursalDetalleAsientoContable;
	}

	public void setActivarFK_IdSucursalDetalleAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetalleAsientoContable= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCambioDetalleAsientoContable=true;

	public Boolean getActivarFK_IdTipoCambioDetalleAsientoContable() {
		return this.activarFK_IdTipoCambioDetalleAsientoContable;
	}

	public void setActivarFK_IdTipoCambioDetalleAsientoContable(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCambioDetalleAsientoContable= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableDetalleAsientoContable=null;

	public Border getResaltarFK_IdAsientoContableDetalleAsientoContable() {
		return this.resaltarFK_IdAsientoContableDetalleAsientoContable;
	}

	public void setResaltarFK_IdAsientoContableDetalleAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableDetalleAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableDetalleAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdCentroActividadDetalleAsientoContable=null;

	public Border getResaltarFK_IdCentroActividadDetalleAsientoContable() {
		return this.resaltarFK_IdCentroActividadDetalleAsientoContable;
	}

	public void setResaltarFK_IdCentroActividadDetalleAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdCentroActividadDetalleAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdCentroActividadDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroActividadDetalleAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdCentroCostoDetalleAsientoContable=null;

	public Border getResaltarFK_IdCentroCostoDetalleAsientoContable() {
		return this.resaltarFK_IdCentroCostoDetalleAsientoContable;
	}

	public void setResaltarFK_IdCentroCostoDetalleAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoDetalleAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoDetalleAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDetalleAsientoContable=null;

	public Border getResaltarFK_IdCuentaContableDetalleAsientoContable() {
		return this.resaltarFK_IdCuentaContableDetalleAsientoContable;
	}

	public void setResaltarFK_IdCuentaContableDetalleAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDetalleAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDetalleAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetalleAsientoContable=null;

	public Border getResaltarFK_IdEjercicioDetalleAsientoContable() {
		return this.resaltarFK_IdEjercicioDetalleAsientoContable;
	}

	public void setResaltarFK_IdEjercicioDetalleAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetalleAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetalleAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleAsientoContable=null;

	public Border getResaltarFK_IdEmpresaDetalleAsientoContable() {
		return this.resaltarFK_IdEmpresaDetalleAsientoContable;
	}

	public void setResaltarFK_IdEmpresaDetalleAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetalleAsientoContable=null;

	public Border getResaltarFK_IdPeriodoDetalleAsientoContable() {
		return this.resaltarFK_IdPeriodoDetalleAsientoContable;
	}

	public void setResaltarFK_IdPeriodoDetalleAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetalleAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetalleAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetalleAsientoContable=null;

	public Border getResaltarFK_IdSucursalDetalleAsientoContable() {
		return this.resaltarFK_IdSucursalDetalleAsientoContable;
	}

	public void setResaltarFK_IdSucursalDetalleAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetalleAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetalleAsientoContable= borderResaltar;
	}

	public Border resaltarFK_IdTipoCambioDetalleAsientoContable=null;

	public Border getResaltarFK_IdTipoCambioDetalleAsientoContable() {
		return this.resaltarFK_IdTipoCambioDetalleAsientoContable;
	}

	public void setResaltarFK_IdTipoCambioDetalleAsientoContable(Border borderResaltar) {
		this.resaltarFK_IdTipoCambioDetalleAsientoContable= borderResaltar;
	}

	public void setResaltarFK_IdTipoCambioDetalleAsientoContable(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleAsientoContableBeanSwingJInternalFrame detalleasientocontableBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCambioDetalleAsientoContable= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}