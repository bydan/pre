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
package com.bydan.erp.contabilidad.util.report;

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


import com.bydan.erp.contabilidad.util.report.DiariosGeneralesConstantesFunciones;
import com.bydan.erp.contabilidad.util.report.DiariosGeneralesParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.report.DiariosGeneralesParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DiariosGeneralesConstantesFunciones{		
	
	
	
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
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="DiariosGenerales";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DiariosGenerales"+DiariosGeneralesConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DiariosGeneralesHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DiariosGeneralesHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DiariosGeneralesConstantesFunciones.SCHEMA+"_"+DiariosGeneralesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DiariosGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DiariosGeneralesConstantesFunciones.SCHEMA+"_"+DiariosGeneralesConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DiariosGeneralesConstantesFunciones.SCHEMA+"_"+DiariosGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DiariosGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DiariosGeneralesConstantesFunciones.SCHEMA+"_"+DiariosGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiariosGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DiariosGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiariosGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiariosGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DiariosGeneralesHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DiariosGeneralesConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DiariosGeneralesConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DiariosGeneralesConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DiariosGeneralesConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DiariosGeneralesConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Diarios Generaleses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Diarios Generales";
	public static final String SCLASSWEBTITULO_LOWER="Diarios Generales";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DiariosGenerales";
	public static final String OBJECTNAME="diariosgenerales";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="diarios_generales";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select diariosgenerales from "+DiariosGeneralesConstantesFunciones.SPERSISTENCENAME+" diariosgenerales";
	public static String QUERYSELECTNATIVE="select "+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".id,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".version_row,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".id_empresa,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".id_sucursal,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".id_ejercicio,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".fecha_emision_desde,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".codigo,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".fecha_emision,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".codigo_tipo_movimiento,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".numero_mayor,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".nombre_cuenta_contable,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".debito_local,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".credito_local,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".detalle,"+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME+".codigo_cuenta_contable from "+DiariosGeneralesConstantesFunciones.SCHEMA+"."+DiariosGeneralesConstantesFunciones.TABLENAME;//+" as "+DiariosGeneralesConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDTIPOMOVIMIENTO= "id_tipo_movimiento";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String CODIGO= "codigo";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String CODIGOTIPOMOVIMIENTO= "codigo_tipo_movimiento";
    public static final String NUMEROMAYOR= "numero_mayor";
    public static final String NOMBRECUENTACONTABLE= "nombre_cuenta_contable";
    public static final String DEBITOLOCAL= "debito_local";
    public static final String CREDITOLOCAL= "credito_local";
    public static final String DETALLE= "detalle";
    public static final String CODIGOCUENTACONTABLE= "codigo_cuenta_contable";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDTIPOMOVIMIENTO= "Tipo Movimiento";
		public static final String LABEL_IDTIPOMOVIMIENTO_LOWER= "Tipo Movimiento";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_CODIGOTIPOMOVIMIENTO= "Codigo Tipo Movimiento";
		public static final String LABEL_CODIGOTIPOMOVIMIENTO_LOWER= "Codigo Tipo Movimiento";
    	public static final String LABEL_NUMEROMAYOR= "Numero Mayor";
		public static final String LABEL_NUMEROMAYOR_LOWER= "Numero Mayor";
    	public static final String LABEL_NOMBRECUENTACONTABLE= "Nombre Cuenta Contable";
		public static final String LABEL_NOMBRECUENTACONTABLE_LOWER= "Nombre Cuenta Contable";
    	public static final String LABEL_DEBITOLOCAL= "Debito Local";
		public static final String LABEL_DEBITOLOCAL_LOWER= "Debito Local";
    	public static final String LABEL_CREDITOLOCAL= "Credito Local";
		public static final String LABEL_CREDITOLOCAL_LOWER= "Credito Local";
    	public static final String LABEL_DETALLE= "Detalle";
		public static final String LABEL_DETALLE_LOWER= "Detalle";
    	public static final String LABEL_CODIGOCUENTACONTABLE= "Codigo Cuenta Contable";
		public static final String LABEL_CODIGOCUENTACONTABLE_LOWER= "Codigo Cuenta Contable";
	
		
		
		
		
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXCODIGO_TIPO_MOVIMIENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_TIPO_MOVIMIENTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_MAYOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_MAYOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CUENTA_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CUENTA_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXDETALLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDETALLE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_CUENTA_CONTABLE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_CUENTA_CONTABLE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getDiariosGeneralesLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.IDEMPRESA)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.IDTIPOMOVIMIENTO)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_IDTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.CODIGO)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.FECHAEMISION)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO;}
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.NUMEROMAYOR)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_NUMEROMAYOR;}
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.NOMBRECUENTACONTABLE)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE;}
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.DEBITOLOCAL)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_DEBITOLOCAL;}
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.CREDITOLOCAL)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_CREDITOLOCAL;}
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.DETALLE)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_DETALLE;}
		if(sNombreColumna.equals(DiariosGeneralesConstantesFunciones.CODIGOCUENTACONTABLE)) {sLabelColumna=DiariosGeneralesConstantesFunciones.LABEL_CODIGOCUENTACONTABLE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDiariosGeneralesDescripcion(DiariosGenerales diariosgenerales) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(diariosgenerales !=null/* && diariosgenerales.getId()!=0*/) {
			sDescripcion=diariosgenerales.getcodigo();//diariosgeneralesdiariosgenerales.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDiariosGeneralesDescripcionDetallado(DiariosGenerales diariosgenerales) {
		String sDescripcion="";
			
		sDescripcion+=DiariosGeneralesConstantesFunciones.ID+"=";
		sDescripcion+=diariosgenerales.getId().toString()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=diariosgenerales.getVersionRow().toString()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=diariosgenerales.getid_empresa().toString()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=diariosgenerales.getid_sucursal().toString()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=diariosgenerales.getid_ejercicio().toString()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.IDTIPOMOVIMIENTO+"=";
		sDescripcion+=diariosgenerales.getid_tipo_movimiento().toString()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=diariosgenerales.getfecha_emision_desde().toString()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=diariosgenerales.getfecha_emision_hasta().toString()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.CODIGO+"=";
		sDescripcion+=diariosgenerales.getcodigo()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=diariosgenerales.getfecha_emision().toString()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO+"=";
		sDescripcion+=diariosgenerales.getcodigo_tipo_movimiento()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.NUMEROMAYOR+"=";
		sDescripcion+=diariosgenerales.getnumero_mayor()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.NOMBRECUENTACONTABLE+"=";
		sDescripcion+=diariosgenerales.getnombre_cuenta_contable()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.DEBITOLOCAL+"=";
		sDescripcion+=diariosgenerales.getdebito_local().toString()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.CREDITOLOCAL+"=";
		sDescripcion+=diariosgenerales.getcredito_local().toString()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.DETALLE+"=";
		sDescripcion+=diariosgenerales.getdetalle()+",";
		sDescripcion+=DiariosGeneralesConstantesFunciones.CODIGOCUENTACONTABLE+"=";
		sDescripcion+=diariosgenerales.getcodigo_cuenta_contable()+",";
			
		return sDescripcion;
	}
	
	public static void setDiariosGeneralesDescripcion(DiariosGenerales diariosgenerales,String sValor) throws Exception {			
		if(diariosgenerales !=null) {
			diariosgenerales.setcodigo(sValor);;//diariosgeneralesdiariosgenerales.getcodigo().trim();
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getTipoMovimientoDescripcion(TipoMovimiento tipomovimiento) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipomovimiento!=null/*&&tipomovimiento.getId()>0*/) {
			sDescripcion=TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(tipomovimiento);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaDiariosGenerales")) {
			sNombreIndice="Tipo=  Por Ejercicio Por Tipo Movimiento Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoMovimiento")) {
			sNombreIndice="Tipo=  Por Tipo Movimiento";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaDiariosGenerales(Long id_ejercicio,Long id_tipo_movimiento,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();}
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoMovimiento(Long id_tipo_movimiento) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_movimiento!=null) {sDetalleIndice+=" Codigo Unico De Tipo Movimiento="+id_tipo_movimiento.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDiariosGenerales(DiariosGenerales diariosgenerales,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		diariosgenerales.setcodigo(diariosgenerales.getcodigo().trim());
		diariosgenerales.setcodigo_tipo_movimiento(diariosgenerales.getcodigo_tipo_movimiento().trim());
		diariosgenerales.setnumero_mayor(diariosgenerales.getnumero_mayor().trim());
		diariosgenerales.setnombre_cuenta_contable(diariosgenerales.getnombre_cuenta_contable().trim());
		diariosgenerales.setdetalle(diariosgenerales.getdetalle().trim());
		diariosgenerales.setcodigo_cuenta_contable(diariosgenerales.getcodigo_cuenta_contable().trim());
	}
	
	public static void quitarEspaciosDiariosGeneraless(List<DiariosGenerales> diariosgeneraless,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DiariosGenerales diariosgenerales: diariosgeneraless) {
			diariosgenerales.setcodigo(diariosgenerales.getcodigo().trim());
			diariosgenerales.setcodigo_tipo_movimiento(diariosgenerales.getcodigo_tipo_movimiento().trim());
			diariosgenerales.setnumero_mayor(diariosgenerales.getnumero_mayor().trim());
			diariosgenerales.setnombre_cuenta_contable(diariosgenerales.getnombre_cuenta_contable().trim());
			diariosgenerales.setdetalle(diariosgenerales.getdetalle().trim());
			diariosgenerales.setcodigo_cuenta_contable(diariosgenerales.getcodigo_cuenta_contable().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDiariosGenerales(DiariosGenerales diariosgenerales,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && diariosgenerales.getConCambioAuxiliar()) {
			diariosgenerales.setIsDeleted(diariosgenerales.getIsDeletedAuxiliar());	
			diariosgenerales.setIsNew(diariosgenerales.getIsNewAuxiliar());	
			diariosgenerales.setIsChanged(diariosgenerales.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			diariosgenerales.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			diariosgenerales.setIsDeletedAuxiliar(false);	
			diariosgenerales.setIsNewAuxiliar(false);	
			diariosgenerales.setIsChangedAuxiliar(false);
			
			diariosgenerales.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDiariosGeneraless(List<DiariosGenerales> diariosgeneraless,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DiariosGenerales diariosgenerales : diariosgeneraless) {
			if(conAsignarBase && diariosgenerales.getConCambioAuxiliar()) {
				diariosgenerales.setIsDeleted(diariosgenerales.getIsDeletedAuxiliar());	
				diariosgenerales.setIsNew(diariosgenerales.getIsNewAuxiliar());	
				diariosgenerales.setIsChanged(diariosgenerales.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				diariosgenerales.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				diariosgenerales.setIsDeletedAuxiliar(false);	
				diariosgenerales.setIsNewAuxiliar(false);	
				diariosgenerales.setIsChangedAuxiliar(false);
				
				diariosgenerales.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDiariosGenerales(DiariosGenerales diariosgenerales,Boolean conEnteros) throws Exception  {
		diariosgenerales.setdebito_local(0.0);
		diariosgenerales.setcredito_local(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDiariosGeneraless(List<DiariosGenerales> diariosgeneraless,Boolean conEnteros) throws Exception  {
		
		for(DiariosGenerales diariosgenerales: diariosgeneraless) {
			diariosgenerales.setdebito_local(0.0);
			diariosgenerales.setcredito_local(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDiariosGenerales(List<DiariosGenerales> diariosgeneraless,DiariosGenerales diariosgeneralesAux) throws Exception  {
		DiariosGeneralesConstantesFunciones.InicializarValoresDiariosGenerales(diariosgeneralesAux,true);
		
		for(DiariosGenerales diariosgenerales: diariosgeneraless) {
			if(diariosgenerales.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			diariosgeneralesAux.setdebito_local(diariosgeneralesAux.getdebito_local()+diariosgenerales.getdebito_local());			
			diariosgeneralesAux.setcredito_local(diariosgeneralesAux.getcredito_local()+diariosgenerales.getcredito_local());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDiariosGenerales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DiariosGeneralesConstantesFunciones.getArrayColumnasGlobalesDiariosGenerales(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDiariosGenerales(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DiariosGeneralesConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DiariosGeneralesConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DiariosGeneralesConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DiariosGeneralesConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DiariosGeneralesConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DiariosGeneralesConstantesFunciones.IDEJERCICIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDiariosGenerales(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DiariosGenerales> diariosgeneraless,DiariosGenerales diariosgenerales,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DiariosGenerales diariosgeneralesAux: diariosgeneraless) {
			if(diariosgeneralesAux!=null && diariosgenerales!=null) {
				if((diariosgeneralesAux.getId()==null && diariosgenerales.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(diariosgeneralesAux.getId()!=null && diariosgenerales.getId()!=null){
					if(diariosgeneralesAux.getId().equals(diariosgenerales.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDiariosGenerales(List<DiariosGenerales> diariosgeneraless) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_localTotal=0.0;
		Double credito_localTotal=0.0;
	
		for(DiariosGenerales diariosgenerales: diariosgeneraless) {			
			if(diariosgenerales.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_localTotal+=diariosgenerales.getdebito_local();
			credito_localTotal+=diariosgenerales.getcredito_local();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiariosGeneralesConstantesFunciones.DEBITOLOCAL);
		datoGeneral.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_DEBITOLOCAL);
		datoGeneral.setdValorDouble(debito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DiariosGeneralesConstantesFunciones.CREDITOLOCAL);
		datoGeneral.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_CREDITOLOCAL);
		datoGeneral.setdValorDouble(credito_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDiariosGenerales() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DiariosGeneralesConstantesFunciones.LABEL_ID, DiariosGeneralesConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiariosGeneralesConstantesFunciones.LABEL_VERSIONROW, DiariosGeneralesConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiariosGeneralesConstantesFunciones.LABEL_CODIGO, DiariosGeneralesConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiariosGeneralesConstantesFunciones.LABEL_FECHAEMISION, DiariosGeneralesConstantesFunciones.FECHAEMISION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiariosGeneralesConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO, DiariosGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiariosGeneralesConstantesFunciones.LABEL_NUMEROMAYOR, DiariosGeneralesConstantesFunciones.NUMEROMAYOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiariosGeneralesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE, DiariosGeneralesConstantesFunciones.NOMBRECUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiariosGeneralesConstantesFunciones.LABEL_DEBITOLOCAL, DiariosGeneralesConstantesFunciones.DEBITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiariosGeneralesConstantesFunciones.LABEL_CREDITOLOCAL, DiariosGeneralesConstantesFunciones.CREDITOLOCAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiariosGeneralesConstantesFunciones.LABEL_DETALLE, DiariosGeneralesConstantesFunciones.DETALLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DiariosGeneralesConstantesFunciones.LABEL_CODIGOCUENTACONTABLE, DiariosGeneralesConstantesFunciones.CODIGOCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDiariosGenerales() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DiariosGeneralesConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiariosGeneralesConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiariosGeneralesConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiariosGeneralesConstantesFunciones.FECHAEMISION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiariosGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiariosGeneralesConstantesFunciones.NUMEROMAYOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiariosGeneralesConstantesFunciones.NOMBRECUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiariosGeneralesConstantesFunciones.DEBITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiariosGeneralesConstantesFunciones.CREDITOLOCAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiariosGeneralesConstantesFunciones.DETALLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DiariosGeneralesConstantesFunciones.CODIGOCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDiariosGenerales() throws Exception  {
		return DiariosGeneralesConstantesFunciones.getTiposSeleccionarDiariosGenerales(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDiariosGenerales(Boolean conFk) throws Exception  {
		return DiariosGeneralesConstantesFunciones.getTiposSeleccionarDiariosGenerales(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDiariosGenerales(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_NUMEROMAYOR);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_NUMEROMAYOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_DEBITOLOCAL);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_DEBITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_CREDITOLOCAL);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_CREDITOLOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_DETALLE);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_DETALLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DiariosGeneralesConstantesFunciones.LABEL_CODIGOCUENTACONTABLE);
			reporte.setsDescripcion(DiariosGeneralesConstantesFunciones.LABEL_CODIGOCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDiariosGenerales(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDiariosGenerales(DiariosGenerales diariosgeneralesAux) throws Exception {
		
			diariosgeneralesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(diariosgeneralesAux.getEmpresa()));
			diariosgeneralesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(diariosgeneralesAux.getSucursal()));
			diariosgeneralesAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(diariosgeneralesAux.getEjercicio()));
			diariosgeneralesAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(diariosgeneralesAux.getTipoMovimiento()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDiariosGenerales(List<DiariosGenerales> diariosgeneralessTemp) throws Exception {
		for(DiariosGenerales diariosgeneralesAux:diariosgeneralessTemp) {
			
			diariosgeneralesAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(diariosgeneralesAux.getEmpresa()));
			diariosgeneralesAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(diariosgeneralesAux.getSucursal()));
			diariosgeneralesAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(diariosgeneralesAux.getEjercicio()));
			diariosgeneralesAux.settipomovimiento_descripcion(TipoMovimientoConstantesFunciones.getTipoMovimientoDescripcion(diariosgeneralesAux.getTipoMovimiento()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDiariosGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(TipoMovimiento.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoMovimiento.class)) {
						classes.add(new Classe(TipoMovimiento.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDiariosGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(TipoMovimiento.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoMovimiento.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDiariosGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DiariosGeneralesConstantesFunciones.getClassesRelationshipsOfDiariosGenerales(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDiariosGenerales(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDiariosGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DiariosGeneralesConstantesFunciones.getClassesRelationshipsFromStringsOfDiariosGenerales(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDiariosGenerales(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DiariosGenerales diariosgenerales,List<DiariosGenerales> diariosgeneraless,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(DiariosGenerales diariosgenerales,List<DiariosGenerales> diariosgeneraless) throws Exception {
		try	{			
			for(DiariosGenerales diariosgeneralesLocal:diariosgeneraless) {
				if(diariosgeneralesLocal.getId().equals(diariosgenerales.getId())) {
					diariosgeneralesLocal.setIsSelected(diariosgenerales.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDiariosGenerales(List<DiariosGenerales> diariosgeneralessAux) throws Exception {
		//this.diariosgeneralessAux=diariosgeneralessAux;
		
		for(DiariosGenerales diariosgeneralesAux:diariosgeneralessAux) {
			if(diariosgeneralesAux.getIsChanged()) {
				diariosgeneralesAux.setIsChanged(false);
			}		
			
			if(diariosgeneralesAux.getIsNew()) {
				diariosgeneralesAux.setIsNew(false);
			}	
			
			if(diariosgeneralesAux.getIsDeleted()) {
				diariosgeneralesAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDiariosGenerales(DiariosGenerales diariosgeneralesAux) throws Exception {
		//this.diariosgeneralesAux=diariosgeneralesAux;
		
			if(diariosgeneralesAux.getIsChanged()) {
				diariosgeneralesAux.setIsChanged(false);
			}		
			
			if(diariosgeneralesAux.getIsNew()) {
				diariosgeneralesAux.setIsNew(false);
			}	
			
			if(diariosgeneralesAux.getIsDeleted()) {
				diariosgeneralesAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DiariosGenerales diariosgeneralesAsignar,DiariosGenerales diariosgenerales) throws Exception {
		diariosgeneralesAsignar.setId(diariosgenerales.getId());	
		diariosgeneralesAsignar.setVersionRow(diariosgenerales.getVersionRow());	
		diariosgeneralesAsignar.setcodigo(diariosgenerales.getcodigo());	
		diariosgeneralesAsignar.setfecha_emision(diariosgenerales.getfecha_emision());	
		diariosgeneralesAsignar.setcodigo_tipo_movimiento(diariosgenerales.getcodigo_tipo_movimiento());	
		diariosgeneralesAsignar.setnumero_mayor(diariosgenerales.getnumero_mayor());	
		diariosgeneralesAsignar.setnombre_cuenta_contable(diariosgenerales.getnombre_cuenta_contable());	
		diariosgeneralesAsignar.setdebito_local(diariosgenerales.getdebito_local());	
		diariosgeneralesAsignar.setcredito_local(diariosgenerales.getcredito_local());	
		diariosgeneralesAsignar.setdetalle(diariosgenerales.getdetalle());	
		diariosgeneralesAsignar.setcodigo_cuenta_contable(diariosgenerales.getcodigo_cuenta_contable());	
	}
	
	public static void inicializarDiariosGenerales(DiariosGenerales diariosgenerales) throws Exception {
		try {
				diariosgenerales.setId(0L);	
					
				diariosgenerales.setcodigo("");	
				diariosgenerales.setfecha_emision(new Date());	
				diariosgenerales.setcodigo_tipo_movimiento("");	
				diariosgenerales.setnumero_mayor("");	
				diariosgenerales.setnombre_cuenta_contable("");	
				diariosgenerales.setdebito_local(0.0);	
				diariosgenerales.setcredito_local(0.0);	
				diariosgenerales.setdetalle("");	
				diariosgenerales.setcodigo_cuenta_contable("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDiariosGenerales(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_IDTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_CODIGOTIPOMOVIMIENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_NUMEROMAYOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_NOMBRECUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_DEBITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_CREDITOLOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_DETALLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DiariosGeneralesConstantesFunciones.LABEL_CODIGOCUENTACONTABLE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDiariosGenerales(String sTipo,Row row,Workbook workbook,DiariosGenerales diariosgenerales,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.gettipomovimiento_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.getcodigo_tipo_movimiento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.getnumero_mayor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.getnombre_cuenta_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.getdebito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.getcredito_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.getdetalle());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(diariosgenerales.getcodigo_cuenta_contable());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDiariosGenerales="";
	
	public String getsFinalQueryDiariosGenerales() {
		return this.sFinalQueryDiariosGenerales;
	}
	
	public void setsFinalQueryDiariosGenerales(String sFinalQueryDiariosGenerales) {
		this.sFinalQueryDiariosGenerales= sFinalQueryDiariosGenerales;
	}
	
	public Border resaltarSeleccionarDiariosGenerales=null;
	
	public Border setResaltarSeleccionarDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDiariosGenerales= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDiariosGenerales() {
		return this.resaltarSeleccionarDiariosGenerales;
	}
	
	public void setResaltarSeleccionarDiariosGenerales(Border borderResaltarSeleccionarDiariosGenerales) {
		this.resaltarSeleccionarDiariosGenerales= borderResaltarSeleccionarDiariosGenerales;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDiariosGenerales=null;
	public Boolean mostraridDiariosGenerales=true;
	public Boolean activaridDiariosGenerales=true;

	public Border resaltarid_empresaDiariosGenerales=null;
	public Boolean mostrarid_empresaDiariosGenerales=true;
	public Boolean activarid_empresaDiariosGenerales=true;
	public Boolean cargarid_empresaDiariosGenerales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDiariosGenerales=false;//ConEventDepend=true

	public Border resaltarid_sucursalDiariosGenerales=null;
	public Boolean mostrarid_sucursalDiariosGenerales=true;
	public Boolean activarid_sucursalDiariosGenerales=true;
	public Boolean cargarid_sucursalDiariosGenerales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDiariosGenerales=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDiariosGenerales=null;
	public Boolean mostrarid_ejercicioDiariosGenerales=true;
	public Boolean activarid_ejercicioDiariosGenerales=true;
	public Boolean cargarid_ejercicioDiariosGenerales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDiariosGenerales=false;//ConEventDepend=true

	public Border resaltarid_tipo_movimientoDiariosGenerales=null;
	public Boolean mostrarid_tipo_movimientoDiariosGenerales=true;
	public Boolean activarid_tipo_movimientoDiariosGenerales=true;
	public Boolean cargarid_tipo_movimientoDiariosGenerales=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_movimientoDiariosGenerales=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeDiariosGenerales=null;
	public Boolean mostrarfecha_emision_desdeDiariosGenerales=true;
	public Boolean activarfecha_emision_desdeDiariosGenerales=true;

	public Border resaltarfecha_emision_hastaDiariosGenerales=null;
	public Boolean mostrarfecha_emision_hastaDiariosGenerales=true;
	public Boolean activarfecha_emision_hastaDiariosGenerales=true;

	public Border resaltarcodigoDiariosGenerales=null;
	public Boolean mostrarcodigoDiariosGenerales=true;
	public Boolean activarcodigoDiariosGenerales=true;

	public Border resaltarfecha_emisionDiariosGenerales=null;
	public Boolean mostrarfecha_emisionDiariosGenerales=true;
	public Boolean activarfecha_emisionDiariosGenerales=true;

	public Border resaltarcodigo_tipo_movimientoDiariosGenerales=null;
	public Boolean mostrarcodigo_tipo_movimientoDiariosGenerales=true;
	public Boolean activarcodigo_tipo_movimientoDiariosGenerales=true;

	public Border resaltarnumero_mayorDiariosGenerales=null;
	public Boolean mostrarnumero_mayorDiariosGenerales=true;
	public Boolean activarnumero_mayorDiariosGenerales=true;

	public Border resaltarnombre_cuenta_contableDiariosGenerales=null;
	public Boolean mostrarnombre_cuenta_contableDiariosGenerales=true;
	public Boolean activarnombre_cuenta_contableDiariosGenerales=true;

	public Border resaltardebito_localDiariosGenerales=null;
	public Boolean mostrardebito_localDiariosGenerales=true;
	public Boolean activardebito_localDiariosGenerales=true;

	public Border resaltarcredito_localDiariosGenerales=null;
	public Boolean mostrarcredito_localDiariosGenerales=true;
	public Boolean activarcredito_localDiariosGenerales=true;

	public Border resaltardetalleDiariosGenerales=null;
	public Boolean mostrardetalleDiariosGenerales=true;
	public Boolean activardetalleDiariosGenerales=true;

	public Border resaltarcodigo_cuenta_contableDiariosGenerales=null;
	public Boolean mostrarcodigo_cuenta_contableDiariosGenerales=true;
	public Boolean activarcodigo_cuenta_contableDiariosGenerales=true;

	
	

	public Border setResaltaridDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltaridDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDiariosGenerales() {
		return this.resaltaridDiariosGenerales;
	}

	public void setResaltaridDiariosGenerales(Border borderResaltar) {
		this.resaltaridDiariosGenerales= borderResaltar;
	}

	public Boolean getMostraridDiariosGenerales() {
		return this.mostraridDiariosGenerales;
	}

	public void setMostraridDiariosGenerales(Boolean mostraridDiariosGenerales) {
		this.mostraridDiariosGenerales= mostraridDiariosGenerales;
	}

	public Boolean getActivaridDiariosGenerales() {
		return this.activaridDiariosGenerales;
	}

	public void setActivaridDiariosGenerales(Boolean activaridDiariosGenerales) {
		this.activaridDiariosGenerales= activaridDiariosGenerales;
	}

	public Border setResaltarid_empresaDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltarid_empresaDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDiariosGenerales() {
		return this.resaltarid_empresaDiariosGenerales;
	}

	public void setResaltarid_empresaDiariosGenerales(Border borderResaltar) {
		this.resaltarid_empresaDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrarid_empresaDiariosGenerales() {
		return this.mostrarid_empresaDiariosGenerales;
	}

	public void setMostrarid_empresaDiariosGenerales(Boolean mostrarid_empresaDiariosGenerales) {
		this.mostrarid_empresaDiariosGenerales= mostrarid_empresaDiariosGenerales;
	}

	public Boolean getActivarid_empresaDiariosGenerales() {
		return this.activarid_empresaDiariosGenerales;
	}

	public void setActivarid_empresaDiariosGenerales(Boolean activarid_empresaDiariosGenerales) {
		this.activarid_empresaDiariosGenerales= activarid_empresaDiariosGenerales;
	}

	public Boolean getCargarid_empresaDiariosGenerales() {
		return this.cargarid_empresaDiariosGenerales;
	}

	public void setCargarid_empresaDiariosGenerales(Boolean cargarid_empresaDiariosGenerales) {
		this.cargarid_empresaDiariosGenerales= cargarid_empresaDiariosGenerales;
	}

	public Border setResaltarid_sucursalDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDiariosGenerales() {
		return this.resaltarid_sucursalDiariosGenerales;
	}

	public void setResaltarid_sucursalDiariosGenerales(Border borderResaltar) {
		this.resaltarid_sucursalDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDiariosGenerales() {
		return this.mostrarid_sucursalDiariosGenerales;
	}

	public void setMostrarid_sucursalDiariosGenerales(Boolean mostrarid_sucursalDiariosGenerales) {
		this.mostrarid_sucursalDiariosGenerales= mostrarid_sucursalDiariosGenerales;
	}

	public Boolean getActivarid_sucursalDiariosGenerales() {
		return this.activarid_sucursalDiariosGenerales;
	}

	public void setActivarid_sucursalDiariosGenerales(Boolean activarid_sucursalDiariosGenerales) {
		this.activarid_sucursalDiariosGenerales= activarid_sucursalDiariosGenerales;
	}

	public Boolean getCargarid_sucursalDiariosGenerales() {
		return this.cargarid_sucursalDiariosGenerales;
	}

	public void setCargarid_sucursalDiariosGenerales(Boolean cargarid_sucursalDiariosGenerales) {
		this.cargarid_sucursalDiariosGenerales= cargarid_sucursalDiariosGenerales;
	}

	public Border setResaltarid_ejercicioDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDiariosGenerales() {
		return this.resaltarid_ejercicioDiariosGenerales;
	}

	public void setResaltarid_ejercicioDiariosGenerales(Border borderResaltar) {
		this.resaltarid_ejercicioDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDiariosGenerales() {
		return this.mostrarid_ejercicioDiariosGenerales;
	}

	public void setMostrarid_ejercicioDiariosGenerales(Boolean mostrarid_ejercicioDiariosGenerales) {
		this.mostrarid_ejercicioDiariosGenerales= mostrarid_ejercicioDiariosGenerales;
	}

	public Boolean getActivarid_ejercicioDiariosGenerales() {
		return this.activarid_ejercicioDiariosGenerales;
	}

	public void setActivarid_ejercicioDiariosGenerales(Boolean activarid_ejercicioDiariosGenerales) {
		this.activarid_ejercicioDiariosGenerales= activarid_ejercicioDiariosGenerales;
	}

	public Boolean getCargarid_ejercicioDiariosGenerales() {
		return this.cargarid_ejercicioDiariosGenerales;
	}

	public void setCargarid_ejercicioDiariosGenerales(Boolean cargarid_ejercicioDiariosGenerales) {
		this.cargarid_ejercicioDiariosGenerales= cargarid_ejercicioDiariosGenerales;
	}

	public Border setResaltarid_tipo_movimientoDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltarid_tipo_movimientoDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_movimientoDiariosGenerales() {
		return this.resaltarid_tipo_movimientoDiariosGenerales;
	}

	public void setResaltarid_tipo_movimientoDiariosGenerales(Border borderResaltar) {
		this.resaltarid_tipo_movimientoDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrarid_tipo_movimientoDiariosGenerales() {
		return this.mostrarid_tipo_movimientoDiariosGenerales;
	}

	public void setMostrarid_tipo_movimientoDiariosGenerales(Boolean mostrarid_tipo_movimientoDiariosGenerales) {
		this.mostrarid_tipo_movimientoDiariosGenerales= mostrarid_tipo_movimientoDiariosGenerales;
	}

	public Boolean getActivarid_tipo_movimientoDiariosGenerales() {
		return this.activarid_tipo_movimientoDiariosGenerales;
	}

	public void setActivarid_tipo_movimientoDiariosGenerales(Boolean activarid_tipo_movimientoDiariosGenerales) {
		this.activarid_tipo_movimientoDiariosGenerales= activarid_tipo_movimientoDiariosGenerales;
	}

	public Boolean getCargarid_tipo_movimientoDiariosGenerales() {
		return this.cargarid_tipo_movimientoDiariosGenerales;
	}

	public void setCargarid_tipo_movimientoDiariosGenerales(Boolean cargarid_tipo_movimientoDiariosGenerales) {
		this.cargarid_tipo_movimientoDiariosGenerales= cargarid_tipo_movimientoDiariosGenerales;
	}

	public Border setResaltarfecha_emision_desdeDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeDiariosGenerales() {
		return this.resaltarfecha_emision_desdeDiariosGenerales;
	}

	public void setResaltarfecha_emision_desdeDiariosGenerales(Border borderResaltar) {
		this.resaltarfecha_emision_desdeDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeDiariosGenerales() {
		return this.mostrarfecha_emision_desdeDiariosGenerales;
	}

	public void setMostrarfecha_emision_desdeDiariosGenerales(Boolean mostrarfecha_emision_desdeDiariosGenerales) {
		this.mostrarfecha_emision_desdeDiariosGenerales= mostrarfecha_emision_desdeDiariosGenerales;
	}

	public Boolean getActivarfecha_emision_desdeDiariosGenerales() {
		return this.activarfecha_emision_desdeDiariosGenerales;
	}

	public void setActivarfecha_emision_desdeDiariosGenerales(Boolean activarfecha_emision_desdeDiariosGenerales) {
		this.activarfecha_emision_desdeDiariosGenerales= activarfecha_emision_desdeDiariosGenerales;
	}

	public Border setResaltarfecha_emision_hastaDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaDiariosGenerales() {
		return this.resaltarfecha_emision_hastaDiariosGenerales;
	}

	public void setResaltarfecha_emision_hastaDiariosGenerales(Border borderResaltar) {
		this.resaltarfecha_emision_hastaDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaDiariosGenerales() {
		return this.mostrarfecha_emision_hastaDiariosGenerales;
	}

	public void setMostrarfecha_emision_hastaDiariosGenerales(Boolean mostrarfecha_emision_hastaDiariosGenerales) {
		this.mostrarfecha_emision_hastaDiariosGenerales= mostrarfecha_emision_hastaDiariosGenerales;
	}

	public Boolean getActivarfecha_emision_hastaDiariosGenerales() {
		return this.activarfecha_emision_hastaDiariosGenerales;
	}

	public void setActivarfecha_emision_hastaDiariosGenerales(Boolean activarfecha_emision_hastaDiariosGenerales) {
		this.activarfecha_emision_hastaDiariosGenerales= activarfecha_emision_hastaDiariosGenerales;
	}

	public Border setResaltarcodigoDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltarcodigoDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoDiariosGenerales() {
		return this.resaltarcodigoDiariosGenerales;
	}

	public void setResaltarcodigoDiariosGenerales(Border borderResaltar) {
		this.resaltarcodigoDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrarcodigoDiariosGenerales() {
		return this.mostrarcodigoDiariosGenerales;
	}

	public void setMostrarcodigoDiariosGenerales(Boolean mostrarcodigoDiariosGenerales) {
		this.mostrarcodigoDiariosGenerales= mostrarcodigoDiariosGenerales;
	}

	public Boolean getActivarcodigoDiariosGenerales() {
		return this.activarcodigoDiariosGenerales;
	}

	public void setActivarcodigoDiariosGenerales(Boolean activarcodigoDiariosGenerales) {
		this.activarcodigoDiariosGenerales= activarcodigoDiariosGenerales;
	}

	public Border setResaltarfecha_emisionDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionDiariosGenerales() {
		return this.resaltarfecha_emisionDiariosGenerales;
	}

	public void setResaltarfecha_emisionDiariosGenerales(Border borderResaltar) {
		this.resaltarfecha_emisionDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionDiariosGenerales() {
		return this.mostrarfecha_emisionDiariosGenerales;
	}

	public void setMostrarfecha_emisionDiariosGenerales(Boolean mostrarfecha_emisionDiariosGenerales) {
		this.mostrarfecha_emisionDiariosGenerales= mostrarfecha_emisionDiariosGenerales;
	}

	public Boolean getActivarfecha_emisionDiariosGenerales() {
		return this.activarfecha_emisionDiariosGenerales;
	}

	public void setActivarfecha_emisionDiariosGenerales(Boolean activarfecha_emisionDiariosGenerales) {
		this.activarfecha_emisionDiariosGenerales= activarfecha_emisionDiariosGenerales;
	}

	public Border setResaltarcodigo_tipo_movimientoDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltarcodigo_tipo_movimientoDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_tipo_movimientoDiariosGenerales() {
		return this.resaltarcodigo_tipo_movimientoDiariosGenerales;
	}

	public void setResaltarcodigo_tipo_movimientoDiariosGenerales(Border borderResaltar) {
		this.resaltarcodigo_tipo_movimientoDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrarcodigo_tipo_movimientoDiariosGenerales() {
		return this.mostrarcodigo_tipo_movimientoDiariosGenerales;
	}

	public void setMostrarcodigo_tipo_movimientoDiariosGenerales(Boolean mostrarcodigo_tipo_movimientoDiariosGenerales) {
		this.mostrarcodigo_tipo_movimientoDiariosGenerales= mostrarcodigo_tipo_movimientoDiariosGenerales;
	}

	public Boolean getActivarcodigo_tipo_movimientoDiariosGenerales() {
		return this.activarcodigo_tipo_movimientoDiariosGenerales;
	}

	public void setActivarcodigo_tipo_movimientoDiariosGenerales(Boolean activarcodigo_tipo_movimientoDiariosGenerales) {
		this.activarcodigo_tipo_movimientoDiariosGenerales= activarcodigo_tipo_movimientoDiariosGenerales;
	}

	public Border setResaltarnumero_mayorDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltarnumero_mayorDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mayorDiariosGenerales() {
		return this.resaltarnumero_mayorDiariosGenerales;
	}

	public void setResaltarnumero_mayorDiariosGenerales(Border borderResaltar) {
		this.resaltarnumero_mayorDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrarnumero_mayorDiariosGenerales() {
		return this.mostrarnumero_mayorDiariosGenerales;
	}

	public void setMostrarnumero_mayorDiariosGenerales(Boolean mostrarnumero_mayorDiariosGenerales) {
		this.mostrarnumero_mayorDiariosGenerales= mostrarnumero_mayorDiariosGenerales;
	}

	public Boolean getActivarnumero_mayorDiariosGenerales() {
		return this.activarnumero_mayorDiariosGenerales;
	}

	public void setActivarnumero_mayorDiariosGenerales(Boolean activarnumero_mayorDiariosGenerales) {
		this.activarnumero_mayorDiariosGenerales= activarnumero_mayorDiariosGenerales;
	}

	public Border setResaltarnombre_cuenta_contableDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltarnombre_cuenta_contableDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_cuenta_contableDiariosGenerales() {
		return this.resaltarnombre_cuenta_contableDiariosGenerales;
	}

	public void setResaltarnombre_cuenta_contableDiariosGenerales(Border borderResaltar) {
		this.resaltarnombre_cuenta_contableDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrarnombre_cuenta_contableDiariosGenerales() {
		return this.mostrarnombre_cuenta_contableDiariosGenerales;
	}

	public void setMostrarnombre_cuenta_contableDiariosGenerales(Boolean mostrarnombre_cuenta_contableDiariosGenerales) {
		this.mostrarnombre_cuenta_contableDiariosGenerales= mostrarnombre_cuenta_contableDiariosGenerales;
	}

	public Boolean getActivarnombre_cuenta_contableDiariosGenerales() {
		return this.activarnombre_cuenta_contableDiariosGenerales;
	}

	public void setActivarnombre_cuenta_contableDiariosGenerales(Boolean activarnombre_cuenta_contableDiariosGenerales) {
		this.activarnombre_cuenta_contableDiariosGenerales= activarnombre_cuenta_contableDiariosGenerales;
	}

	public Border setResaltardebito_localDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltardebito_localDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_localDiariosGenerales() {
		return this.resaltardebito_localDiariosGenerales;
	}

	public void setResaltardebito_localDiariosGenerales(Border borderResaltar) {
		this.resaltardebito_localDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrardebito_localDiariosGenerales() {
		return this.mostrardebito_localDiariosGenerales;
	}

	public void setMostrardebito_localDiariosGenerales(Boolean mostrardebito_localDiariosGenerales) {
		this.mostrardebito_localDiariosGenerales= mostrardebito_localDiariosGenerales;
	}

	public Boolean getActivardebito_localDiariosGenerales() {
		return this.activardebito_localDiariosGenerales;
	}

	public void setActivardebito_localDiariosGenerales(Boolean activardebito_localDiariosGenerales) {
		this.activardebito_localDiariosGenerales= activardebito_localDiariosGenerales;
	}

	public Border setResaltarcredito_localDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltarcredito_localDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_localDiariosGenerales() {
		return this.resaltarcredito_localDiariosGenerales;
	}

	public void setResaltarcredito_localDiariosGenerales(Border borderResaltar) {
		this.resaltarcredito_localDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrarcredito_localDiariosGenerales() {
		return this.mostrarcredito_localDiariosGenerales;
	}

	public void setMostrarcredito_localDiariosGenerales(Boolean mostrarcredito_localDiariosGenerales) {
		this.mostrarcredito_localDiariosGenerales= mostrarcredito_localDiariosGenerales;
	}

	public Boolean getActivarcredito_localDiariosGenerales() {
		return this.activarcredito_localDiariosGenerales;
	}

	public void setActivarcredito_localDiariosGenerales(Boolean activarcredito_localDiariosGenerales) {
		this.activarcredito_localDiariosGenerales= activarcredito_localDiariosGenerales;
	}

	public Border setResaltardetalleDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltardetalleDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardetalleDiariosGenerales() {
		return this.resaltardetalleDiariosGenerales;
	}

	public void setResaltardetalleDiariosGenerales(Border borderResaltar) {
		this.resaltardetalleDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrardetalleDiariosGenerales() {
		return this.mostrardetalleDiariosGenerales;
	}

	public void setMostrardetalleDiariosGenerales(Boolean mostrardetalleDiariosGenerales) {
		this.mostrardetalleDiariosGenerales= mostrardetalleDiariosGenerales;
	}

	public Boolean getActivardetalleDiariosGenerales() {
		return this.activardetalleDiariosGenerales;
	}

	public void setActivardetalleDiariosGenerales(Boolean activardetalleDiariosGenerales) {
		this.activardetalleDiariosGenerales= activardetalleDiariosGenerales;
	}

	public Border setResaltarcodigo_cuenta_contableDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//diariosgeneralesBeanSwingJInternalFrame.jTtoolBarDiariosGenerales.setBorder(borderResaltar);
		
		this.resaltarcodigo_cuenta_contableDiariosGenerales= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_cuenta_contableDiariosGenerales() {
		return this.resaltarcodigo_cuenta_contableDiariosGenerales;
	}

	public void setResaltarcodigo_cuenta_contableDiariosGenerales(Border borderResaltar) {
		this.resaltarcodigo_cuenta_contableDiariosGenerales= borderResaltar;
	}

	public Boolean getMostrarcodigo_cuenta_contableDiariosGenerales() {
		return this.mostrarcodigo_cuenta_contableDiariosGenerales;
	}

	public void setMostrarcodigo_cuenta_contableDiariosGenerales(Boolean mostrarcodigo_cuenta_contableDiariosGenerales) {
		this.mostrarcodigo_cuenta_contableDiariosGenerales= mostrarcodigo_cuenta_contableDiariosGenerales;
	}

	public Boolean getActivarcodigo_cuenta_contableDiariosGenerales() {
		return this.activarcodigo_cuenta_contableDiariosGenerales;
	}

	public void setActivarcodigo_cuenta_contableDiariosGenerales(Boolean activarcodigo_cuenta_contableDiariosGenerales) {
		this.activarcodigo_cuenta_contableDiariosGenerales= activarcodigo_cuenta_contableDiariosGenerales;
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
		
		
		this.setMostraridDiariosGenerales(esInicial);
		this.setMostrarid_empresaDiariosGenerales(esInicial);
		this.setMostrarid_sucursalDiariosGenerales(esInicial);
		this.setMostrarid_ejercicioDiariosGenerales(esInicial);
		this.setMostrarid_tipo_movimientoDiariosGenerales(esInicial);
		this.setMostrarfecha_emision_desdeDiariosGenerales(esInicial);
		this.setMostrarfecha_emision_hastaDiariosGenerales(esInicial);
		this.setMostrarcodigoDiariosGenerales(esInicial);
		this.setMostrarfecha_emisionDiariosGenerales(esInicial);
		this.setMostrarcodigo_tipo_movimientoDiariosGenerales(esInicial);
		this.setMostrarnumero_mayorDiariosGenerales(esInicial);
		this.setMostrarnombre_cuenta_contableDiariosGenerales(esInicial);
		this.setMostrardebito_localDiariosGenerales(esInicial);
		this.setMostrarcredito_localDiariosGenerales(esInicial);
		this.setMostrardetalleDiariosGenerales(esInicial);
		this.setMostrarcodigo_cuenta_contableDiariosGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.ID)) {
				this.setMostraridDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setMostrarid_tipo_movimientoDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {
				this.setMostrarcodigo_tipo_movimientoDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.NUMEROMAYOR)) {
				this.setMostrarnumero_mayorDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setMostrarnombre_cuenta_contableDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.DEBITOLOCAL)) {
				this.setMostrardebito_localDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.CREDITOLOCAL)) {
				this.setMostrarcredito_localDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.DETALLE)) {
				this.setMostrardetalleDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.CODIGOCUENTACONTABLE)) {
				this.setMostrarcodigo_cuenta_contableDiariosGenerales(esAsigna);
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
		
		
		this.setActivaridDiariosGenerales(esInicial);
		this.setActivarid_empresaDiariosGenerales(esInicial);
		this.setActivarid_sucursalDiariosGenerales(esInicial);
		this.setActivarid_ejercicioDiariosGenerales(esInicial);
		this.setActivarid_tipo_movimientoDiariosGenerales(esInicial);
		this.setActivarfecha_emision_desdeDiariosGenerales(esInicial);
		this.setActivarfecha_emision_hastaDiariosGenerales(esInicial);
		this.setActivarcodigoDiariosGenerales(esInicial);
		this.setActivarfecha_emisionDiariosGenerales(esInicial);
		this.setActivarcodigo_tipo_movimientoDiariosGenerales(esInicial);
		this.setActivarnumero_mayorDiariosGenerales(esInicial);
		this.setActivarnombre_cuenta_contableDiariosGenerales(esInicial);
		this.setActivardebito_localDiariosGenerales(esInicial);
		this.setActivarcredito_localDiariosGenerales(esInicial);
		this.setActivardetalleDiariosGenerales(esInicial);
		this.setActivarcodigo_cuenta_contableDiariosGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.ID)) {
				this.setActivaridDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setActivarid_tipo_movimientoDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.CODIGO)) {
				this.setActivarcodigoDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {
				this.setActivarcodigo_tipo_movimientoDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.NUMEROMAYOR)) {
				this.setActivarnumero_mayorDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setActivarnombre_cuenta_contableDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.DEBITOLOCAL)) {
				this.setActivardebito_localDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.CREDITOLOCAL)) {
				this.setActivarcredito_localDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.DETALLE)) {
				this.setActivardetalleDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.CODIGOCUENTACONTABLE)) {
				this.setActivarcodigo_cuenta_contableDiariosGenerales(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDiariosGenerales(esInicial);
		this.setResaltarid_empresaDiariosGenerales(esInicial);
		this.setResaltarid_sucursalDiariosGenerales(esInicial);
		this.setResaltarid_ejercicioDiariosGenerales(esInicial);
		this.setResaltarid_tipo_movimientoDiariosGenerales(esInicial);
		this.setResaltarfecha_emision_desdeDiariosGenerales(esInicial);
		this.setResaltarfecha_emision_hastaDiariosGenerales(esInicial);
		this.setResaltarcodigoDiariosGenerales(esInicial);
		this.setResaltarfecha_emisionDiariosGenerales(esInicial);
		this.setResaltarcodigo_tipo_movimientoDiariosGenerales(esInicial);
		this.setResaltarnumero_mayorDiariosGenerales(esInicial);
		this.setResaltarnombre_cuenta_contableDiariosGenerales(esInicial);
		this.setResaltardebito_localDiariosGenerales(esInicial);
		this.setResaltarcredito_localDiariosGenerales(esInicial);
		this.setResaltardetalleDiariosGenerales(esInicial);
		this.setResaltarcodigo_cuenta_contableDiariosGenerales(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.ID)) {
				this.setResaltaridDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.IDTIPOMOVIMIENTO)) {
				this.setResaltarid_tipo_movimientoDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.CODIGOTIPOMOVIMIENTO)) {
				this.setResaltarcodigo_tipo_movimientoDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.NUMEROMAYOR)) {
				this.setResaltarnumero_mayorDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.NOMBRECUENTACONTABLE)) {
				this.setResaltarnombre_cuenta_contableDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.DEBITOLOCAL)) {
				this.setResaltardebito_localDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.CREDITOLOCAL)) {
				this.setResaltarcredito_localDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.DETALLE)) {
				this.setResaltardetalleDiariosGenerales(esAsigna);
				continue;
			}

			if(campo.clase.equals(DiariosGeneralesConstantesFunciones.CODIGOCUENTACONTABLE)) {
				this.setResaltarcodigo_cuenta_contableDiariosGenerales(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaDiariosGeneralesDiariosGenerales=true;

	public Boolean getMostrarBusquedaDiariosGeneralesDiariosGenerales() {
		return this.mostrarBusquedaDiariosGeneralesDiariosGenerales;
	}

	public void setMostrarBusquedaDiariosGeneralesDiariosGenerales(Boolean visibilidadResaltar) {
		this.mostrarBusquedaDiariosGeneralesDiariosGenerales= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaDiariosGeneralesDiariosGenerales=true;

	public Boolean getActivarBusquedaDiariosGeneralesDiariosGenerales() {
		return this.activarBusquedaDiariosGeneralesDiariosGenerales;
	}

	public void setActivarBusquedaDiariosGeneralesDiariosGenerales(Boolean habilitarResaltar) {
		this.activarBusquedaDiariosGeneralesDiariosGenerales= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaDiariosGeneralesDiariosGenerales=null;

	public Border getResaltarBusquedaDiariosGeneralesDiariosGenerales() {
		return this.resaltarBusquedaDiariosGeneralesDiariosGenerales;
	}

	public void setResaltarBusquedaDiariosGeneralesDiariosGenerales(Border borderResaltar) {
		this.resaltarBusquedaDiariosGeneralesDiariosGenerales= borderResaltar;
	}

	public void setResaltarBusquedaDiariosGeneralesDiariosGenerales(ParametroGeneralUsuario parametroGeneralUsuario/*DiariosGeneralesBeanSwingJInternalFrame diariosgeneralesBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaDiariosGeneralesDiariosGenerales= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}