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
package com.bydan.erp.cartera.util.report;

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


import com.bydan.erp.cartera.util.report.CobrarMorosidadClientesDetalladosConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarMorosidadClientesDetalladosParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarMorosidadClientesDetalladosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CobrarMorosidadClientesDetalladosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="CobrarMorosidadClientesDetallados";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarMorosidadClientesDetallados"+CobrarMorosidadClientesDetalladosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarMorosidadClientesDetalladosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarMorosidadClientesDetalladosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarMorosidadClientesDetalladosConstantesFunciones.SCHEMA+"_"+CobrarMorosidadClientesDetalladosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarMorosidadClientesDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarMorosidadClientesDetalladosConstantesFunciones.SCHEMA+"_"+CobrarMorosidadClientesDetalladosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarMorosidadClientesDetalladosConstantesFunciones.SCHEMA+"_"+CobrarMorosidadClientesDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarMorosidadClientesDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarMorosidadClientesDetalladosConstantesFunciones.SCHEMA+"_"+CobrarMorosidadClientesDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarMorosidadClientesDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarMorosidadClientesDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarMorosidadClientesDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarMorosidadClientesDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarMorosidadClientesDetalladosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarMorosidadClientesDetalladosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarMorosidadClientesDetalladosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarMorosidadClientesDetalladosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarMorosidadClientesDetalladosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarMorosidadClientesDetalladosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Morosidad Clientes Detalladoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrar Morosidad Clientes Detallados";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Morosidad Clientes Detallados";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarMorosidadClientesDetallados";
	public static final String OBJECTNAME="cobrarmorosidadclientesdetallados";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_morosidad_clientes_detallados";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrarmorosidadclientesdetallados from "+CobrarMorosidadClientesDetalladosConstantesFunciones.SPERSISTENCENAME+" cobrarmorosidadclientesdetallados";
	public static String QUERYSELECTNATIVE="select "+CobrarMorosidadClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarMorosidadClientesDetalladosConstantesFunciones.TABLENAME+".id,"+CobrarMorosidadClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarMorosidadClientesDetalladosConstantesFunciones.TABLENAME+".version_row,"+CobrarMorosidadClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarMorosidadClientesDetalladosConstantesFunciones.TABLENAME+".id_empresa,"+CobrarMorosidadClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarMorosidadClientesDetalladosConstantesFunciones.TABLENAME+".fecha_vence,"+CobrarMorosidadClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarMorosidadClientesDetalladosConstantesFunciones.TABLENAME+".codigo,"+CobrarMorosidadClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarMorosidadClientesDetalladosConstantesFunciones.TABLENAME+".nombre_completo,"+CobrarMorosidadClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarMorosidadClientesDetalladosConstantesFunciones.TABLENAME+".numero_pre_impreso_factura,"+CobrarMorosidadClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarMorosidadClientesDetalladosConstantesFunciones.TABLENAME+".saldo_vencido,"+CobrarMorosidadClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarMorosidadClientesDetalladosConstantesFunciones.TABLENAME+".saldo_vencer from "+CobrarMorosidadClientesDetalladosConstantesFunciones.SCHEMA+"."+CobrarMorosidadClientesDetalladosConstantesFunciones.TABLENAME;//+" as "+CobrarMorosidadClientesDetalladosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String FECHAVENCE= "fecha_vence";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String NUMEROPREIMPRESOFACTURA= "numero_pre_impreso_factura";
    public static final String SALDOVENCIDO= "saldo_vencido";
    public static final String SALDOVENCER= "saldo_vencer";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_FECHAVENCE= "Fecha Vence";
		public static final String LABEL_FECHAVENCE_LOWER= "Fecha Vence";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_NUMEROPREIMPRESOFACTURA= "Numero Pre Impreso Factura";
		public static final String LABEL_NUMEROPREIMPRESOFACTURA_LOWER= "Numero Pre Impreso Factura";
    	public static final String LABEL_SALDOVENCIDO= "Saldo Venco";
		public static final String LABEL_SALDOVENCIDO_LOWER= "Saldo Vencido";
    	public static final String LABEL_SALDOVENCER= "Saldo Vencer";
		public static final String LABEL_SALDOVENCER_LOWER= "Saldo Vencer";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNUMERO_PRE_IMPRESO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getCobrarMorosidadClientesDetalladosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.FECHAVENCE)) {sLabelColumna=CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_FECHAVENCE;}
		if(sNombreColumna.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.CODIGO)) {sLabelColumna=CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {sLabelColumna=CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA;}
		if(sNombreColumna.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCIDO)) {sLabelColumna=CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_SALDOVENCIDO;}
		if(sNombreColumna.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCER)) {sLabelColumna=CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_SALDOVENCER;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getCobrarMorosidadClientesDetalladosDescripcion(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrarmorosidadclientesdetallados !=null/* && cobrarmorosidadclientesdetallados.getId()!=0*/) {
			sDescripcion=cobrarmorosidadclientesdetallados.getcodigo();//cobrarmorosidadclientesdetalladoscobrarmorosidadclientesdetallados.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarMorosidadClientesDetalladosDescripcionDetallado(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados) {
		String sDescripcion="";
			
		sDescripcion+=CobrarMorosidadClientesDetalladosConstantesFunciones.ID+"=";
		sDescripcion+=cobrarmorosidadclientesdetallados.getId().toString()+",";
		sDescripcion+=CobrarMorosidadClientesDetalladosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrarmorosidadclientesdetallados.getVersionRow().toString()+",";
		sDescripcion+=CobrarMorosidadClientesDetalladosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobrarmorosidadclientesdetallados.getid_empresa().toString()+",";
		sDescripcion+=CobrarMorosidadClientesDetalladosConstantesFunciones.FECHAVENCE+"=";
		sDescripcion+=cobrarmorosidadclientesdetallados.getfecha_vence().toString()+",";
		sDescripcion+=CobrarMorosidadClientesDetalladosConstantesFunciones.CODIGO+"=";
		sDescripcion+=cobrarmorosidadclientesdetallados.getcodigo()+",";
		sDescripcion+=CobrarMorosidadClientesDetalladosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=cobrarmorosidadclientesdetallados.getnombre_completo()+",";
		sDescripcion+=CobrarMorosidadClientesDetalladosConstantesFunciones.NUMEROPREIMPRESOFACTURA+"=";
		sDescripcion+=cobrarmorosidadclientesdetallados.getnumero_pre_impreso_factura()+",";
		sDescripcion+=CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCIDO+"=";
		sDescripcion+=cobrarmorosidadclientesdetallados.getsaldo_vencido().toString()+",";
		sDescripcion+=CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCER+"=";
		sDescripcion+=cobrarmorosidadclientesdetallados.getsaldo_vencer().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarMorosidadClientesDetalladosDescripcion(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,String sValor) throws Exception {			
		if(cobrarmorosidadclientesdetallados !=null) {
			cobrarmorosidadclientesdetallados.setcodigo(sValor);;//cobrarmorosidadclientesdetalladoscobrarmorosidadclientesdetallados.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCobrarMorosidadClientesDetallados")) {
			sNombreIndice="Tipo=  Por Fecha Vence";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCobrarMorosidadClientesDetallados(Date fecha_vence) {
		String sDetalleIndice=" Parametros->";
		if(fecha_vence!=null) {sDetalleIndice+=" Fecha Vence="+fecha_vence.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCobrarMorosidadClientesDetallados(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarmorosidadclientesdetallados.setcodigo(cobrarmorosidadclientesdetallados.getcodigo().trim());
		cobrarmorosidadclientesdetallados.setnombre_completo(cobrarmorosidadclientesdetallados.getnombre_completo().trim());
		cobrarmorosidadclientesdetallados.setnumero_pre_impreso_factura(cobrarmorosidadclientesdetallados.getnumero_pre_impreso_factura().trim());
	}
	
	public static void quitarEspaciosCobrarMorosidadClientesDetalladoss(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados: cobrarmorosidadclientesdetalladoss) {
			cobrarmorosidadclientesdetallados.setcodigo(cobrarmorosidadclientesdetallados.getcodigo().trim());
			cobrarmorosidadclientesdetallados.setnombre_completo(cobrarmorosidadclientesdetallados.getnombre_completo().trim());
			cobrarmorosidadclientesdetallados.setnumero_pre_impreso_factura(cobrarmorosidadclientesdetallados.getnumero_pre_impreso_factura().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarMorosidadClientesDetallados(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrarmorosidadclientesdetallados.getConCambioAuxiliar()) {
			cobrarmorosidadclientesdetallados.setIsDeleted(cobrarmorosidadclientesdetallados.getIsDeletedAuxiliar());	
			cobrarmorosidadclientesdetallados.setIsNew(cobrarmorosidadclientesdetallados.getIsNewAuxiliar());	
			cobrarmorosidadclientesdetallados.setIsChanged(cobrarmorosidadclientesdetallados.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrarmorosidadclientesdetallados.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrarmorosidadclientesdetallados.setIsDeletedAuxiliar(false);	
			cobrarmorosidadclientesdetallados.setIsNewAuxiliar(false);	
			cobrarmorosidadclientesdetallados.setIsChangedAuxiliar(false);
			
			cobrarmorosidadclientesdetallados.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarMorosidadClientesDetalladoss(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados : cobrarmorosidadclientesdetalladoss) {
			if(conAsignarBase && cobrarmorosidadclientesdetallados.getConCambioAuxiliar()) {
				cobrarmorosidadclientesdetallados.setIsDeleted(cobrarmorosidadclientesdetallados.getIsDeletedAuxiliar());	
				cobrarmorosidadclientesdetallados.setIsNew(cobrarmorosidadclientesdetallados.getIsNewAuxiliar());	
				cobrarmorosidadclientesdetallados.setIsChanged(cobrarmorosidadclientesdetallados.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrarmorosidadclientesdetallados.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrarmorosidadclientesdetallados.setIsDeletedAuxiliar(false);	
				cobrarmorosidadclientesdetallados.setIsNewAuxiliar(false);	
				cobrarmorosidadclientesdetallados.setIsChangedAuxiliar(false);
				
				cobrarmorosidadclientesdetallados.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarMorosidadClientesDetallados(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,Boolean conEnteros) throws Exception  {
		cobrarmorosidadclientesdetallados.setsaldo_vencido(0.0);
		cobrarmorosidadclientesdetallados.setsaldo_vencer(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCobrarMorosidadClientesDetalladoss(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,Boolean conEnteros) throws Exception  {
		
		for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados: cobrarmorosidadclientesdetalladoss) {
			cobrarmorosidadclientesdetallados.setsaldo_vencido(0.0);
			cobrarmorosidadclientesdetallados.setsaldo_vencer(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarMorosidadClientesDetallados(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetalladosAux) throws Exception  {
		CobrarMorosidadClientesDetalladosConstantesFunciones.InicializarValoresCobrarMorosidadClientesDetallados(cobrarmorosidadclientesdetalladosAux,true);
		
		for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados: cobrarmorosidadclientesdetalladoss) {
			if(cobrarmorosidadclientesdetallados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cobrarmorosidadclientesdetalladosAux.setsaldo_vencido(cobrarmorosidadclientesdetalladosAux.getsaldo_vencido()+cobrarmorosidadclientesdetallados.getsaldo_vencido());			
			cobrarmorosidadclientesdetalladosAux.setsaldo_vencer(cobrarmorosidadclientesdetalladosAux.getsaldo_vencer()+cobrarmorosidadclientesdetallados.getsaldo_vencer());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarMorosidadClientesDetallados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarMorosidadClientesDetalladosConstantesFunciones.getArrayColumnasGlobalesCobrarMorosidadClientesDetallados(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarMorosidadClientesDetallados(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarMorosidadClientesDetalladosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarMorosidadClientesDetallados(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetalladosAux: cobrarmorosidadclientesdetalladoss) {
			if(cobrarmorosidadclientesdetalladosAux!=null && cobrarmorosidadclientesdetallados!=null) {
				if((cobrarmorosidadclientesdetalladosAux.getId()==null && cobrarmorosidadclientesdetallados.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobrarmorosidadclientesdetalladosAux.getId()!=null && cobrarmorosidadclientesdetallados.getId()!=null){
					if(cobrarmorosidadclientesdetalladosAux.getId().equals(cobrarmorosidadclientesdetallados.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarMorosidadClientesDetallados(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double saldo_vencidoTotal=0.0;
		Double saldo_vencerTotal=0.0;
	
		for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados: cobrarmorosidadclientesdetalladoss) {			
			if(cobrarmorosidadclientesdetallados.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			saldo_vencidoTotal+=cobrarmorosidadclientesdetallados.getsaldo_vencido();
			saldo_vencerTotal+=cobrarmorosidadclientesdetallados.getsaldo_vencer();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCIDO);
		datoGeneral.setsDescripcion(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_SALDOVENCIDO);
		datoGeneral.setdValorDouble(saldo_vencidoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCER);
		datoGeneral.setsDescripcion(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_SALDOVENCER);
		datoGeneral.setdValorDouble(saldo_vencerTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarMorosidadClientesDetallados() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_ID, CobrarMorosidadClientesDetalladosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_VERSIONROW, CobrarMorosidadClientesDetalladosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_CODIGO, CobrarMorosidadClientesDetalladosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETO, CobrarMorosidadClientesDetalladosConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA, CobrarMorosidadClientesDetalladosConstantesFunciones.NUMEROPREIMPRESOFACTURA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_SALDOVENCIDO, CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_SALDOVENCER, CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCER,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarMorosidadClientesDetallados() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarMorosidadClientesDetalladosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarMorosidadClientesDetalladosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarMorosidadClientesDetalladosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarMorosidadClientesDetalladosConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarMorosidadClientesDetalladosConstantesFunciones.NUMEROPREIMPRESOFACTURA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCER;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarMorosidadClientesDetallados() throws Exception  {
		return CobrarMorosidadClientesDetalladosConstantesFunciones.getTiposSeleccionarCobrarMorosidadClientesDetallados(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarMorosidadClientesDetallados(Boolean conFk) throws Exception  {
		return CobrarMorosidadClientesDetalladosConstantesFunciones.getTiposSeleccionarCobrarMorosidadClientesDetallados(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarMorosidadClientesDetallados(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_FECHAVENCE);
			reporte.setsDescripcion(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_FECHAVENCE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);
			reporte.setsDescripcion(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_SALDOVENCIDO);
			reporte.setsDescripcion(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_SALDOVENCIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_SALDOVENCER);
			reporte.setsDescripcion(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_SALDOVENCER);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarMorosidadClientesDetallados(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarMorosidadClientesDetallados(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetalladosAux) throws Exception {
		
			cobrarmorosidadclientesdetalladosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarmorosidadclientesdetalladosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarMorosidadClientesDetallados(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladossTemp) throws Exception {
		for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetalladosAux:cobrarmorosidadclientesdetalladossTemp) {
			
			cobrarmorosidadclientesdetalladosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarmorosidadclientesdetalladosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarMorosidadClientesDetallados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarMorosidadClientesDetallados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarMorosidadClientesDetallados(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarMorosidadClientesDetalladosConstantesFunciones.getClassesRelationshipsOfCobrarMorosidadClientesDetallados(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarMorosidadClientesDetallados(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarMorosidadClientesDetallados(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarMorosidadClientesDetalladosConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarMorosidadClientesDetallados(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarMorosidadClientesDetallados(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladoss) throws Exception {
		try	{			
			for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetalladosLocal:cobrarmorosidadclientesdetalladoss) {
				if(cobrarmorosidadclientesdetalladosLocal.getId().equals(cobrarmorosidadclientesdetallados.getId())) {
					cobrarmorosidadclientesdetalladosLocal.setIsSelected(cobrarmorosidadclientesdetallados.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarMorosidadClientesDetallados(List<CobrarMorosidadClientesDetallados> cobrarmorosidadclientesdetalladossAux) throws Exception {
		//this.cobrarmorosidadclientesdetalladossAux=cobrarmorosidadclientesdetalladossAux;
		
		for(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetalladosAux:cobrarmorosidadclientesdetalladossAux) {
			if(cobrarmorosidadclientesdetalladosAux.getIsChanged()) {
				cobrarmorosidadclientesdetalladosAux.setIsChanged(false);
			}		
			
			if(cobrarmorosidadclientesdetalladosAux.getIsNew()) {
				cobrarmorosidadclientesdetalladosAux.setIsNew(false);
			}	
			
			if(cobrarmorosidadclientesdetalladosAux.getIsDeleted()) {
				cobrarmorosidadclientesdetalladosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarMorosidadClientesDetallados(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetalladosAux) throws Exception {
		//this.cobrarmorosidadclientesdetalladosAux=cobrarmorosidadclientesdetalladosAux;
		
			if(cobrarmorosidadclientesdetalladosAux.getIsChanged()) {
				cobrarmorosidadclientesdetalladosAux.setIsChanged(false);
			}		
			
			if(cobrarmorosidadclientesdetalladosAux.getIsNew()) {
				cobrarmorosidadclientesdetalladosAux.setIsNew(false);
			}	
			
			if(cobrarmorosidadclientesdetalladosAux.getIsDeleted()) {
				cobrarmorosidadclientesdetalladosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetalladosAsignar,CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados) throws Exception {
		cobrarmorosidadclientesdetalladosAsignar.setId(cobrarmorosidadclientesdetallados.getId());	
		cobrarmorosidadclientesdetalladosAsignar.setVersionRow(cobrarmorosidadclientesdetallados.getVersionRow());	
		cobrarmorosidadclientesdetalladosAsignar.setcodigo(cobrarmorosidadclientesdetallados.getcodigo());	
		cobrarmorosidadclientesdetalladosAsignar.setnombre_completo(cobrarmorosidadclientesdetallados.getnombre_completo());	
		cobrarmorosidadclientesdetalladosAsignar.setnumero_pre_impreso_factura(cobrarmorosidadclientesdetallados.getnumero_pre_impreso_factura());	
		cobrarmorosidadclientesdetalladosAsignar.setsaldo_vencido(cobrarmorosidadclientesdetallados.getsaldo_vencido());	
		cobrarmorosidadclientesdetalladosAsignar.setsaldo_vencer(cobrarmorosidadclientesdetallados.getsaldo_vencer());	
	}
	
	public static void inicializarCobrarMorosidadClientesDetallados(CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados) throws Exception {
		try {
				cobrarmorosidadclientesdetallados.setId(0L);	
					
				cobrarmorosidadclientesdetallados.setcodigo("");	
				cobrarmorosidadclientesdetallados.setnombre_completo("");	
				cobrarmorosidadclientesdetallados.setnumero_pre_impreso_factura("");	
				cobrarmorosidadclientesdetallados.setsaldo_vencido(0.0);	
				cobrarmorosidadclientesdetallados.setsaldo_vencer(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarMorosidadClientesDetallados(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_FECHAVENCE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_NUMEROPREIMPRESOFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_SALDOVENCIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarMorosidadClientesDetalladosConstantesFunciones.LABEL_SALDOVENCER);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarMorosidadClientesDetallados(String sTipo,Row row,Workbook workbook,CobrarMorosidadClientesDetallados cobrarmorosidadclientesdetallados,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarmorosidadclientesdetallados.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarmorosidadclientesdetallados.getfecha_vence());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarmorosidadclientesdetallados.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarmorosidadclientesdetallados.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarmorosidadclientesdetallados.getnumero_pre_impreso_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarmorosidadclientesdetallados.getsaldo_vencido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarmorosidadclientesdetallados.getsaldo_vencer());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarMorosidadClientesDetallados="";
	
	public String getsFinalQueryCobrarMorosidadClientesDetallados() {
		return this.sFinalQueryCobrarMorosidadClientesDetallados;
	}
	
	public void setsFinalQueryCobrarMorosidadClientesDetallados(String sFinalQueryCobrarMorosidadClientesDetallados) {
		this.sFinalQueryCobrarMorosidadClientesDetallados= sFinalQueryCobrarMorosidadClientesDetallados;
	}
	
	public Border resaltarSeleccionarCobrarMorosidadClientesDetallados=null;
	
	public Border setResaltarSeleccionarCobrarMorosidadClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarMorosidadClientesDetalladosBeanSwingJInternalFrame cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarMorosidadClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarMorosidadClientesDetallados= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarMorosidadClientesDetallados() {
		return this.resaltarSeleccionarCobrarMorosidadClientesDetallados;
	}
	
	public void setResaltarSeleccionarCobrarMorosidadClientesDetallados(Border borderResaltarSeleccionarCobrarMorosidadClientesDetallados) {
		this.resaltarSeleccionarCobrarMorosidadClientesDetallados= borderResaltarSeleccionarCobrarMorosidadClientesDetallados;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarMorosidadClientesDetallados=null;
	public Boolean mostraridCobrarMorosidadClientesDetallados=true;
	public Boolean activaridCobrarMorosidadClientesDetallados=true;

	public Border resaltarid_empresaCobrarMorosidadClientesDetallados=null;
	public Boolean mostrarid_empresaCobrarMorosidadClientesDetallados=true;
	public Boolean activarid_empresaCobrarMorosidadClientesDetallados=true;
	public Boolean cargarid_empresaCobrarMorosidadClientesDetallados=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCobrarMorosidadClientesDetallados=false;//ConEventDepend=true

	public Border resaltarfecha_venceCobrarMorosidadClientesDetallados=null;
	public Boolean mostrarfecha_venceCobrarMorosidadClientesDetallados=true;
	public Boolean activarfecha_venceCobrarMorosidadClientesDetallados=true;

	public Border resaltarcodigoCobrarMorosidadClientesDetallados=null;
	public Boolean mostrarcodigoCobrarMorosidadClientesDetallados=true;
	public Boolean activarcodigoCobrarMorosidadClientesDetallados=true;

	public Border resaltarnombre_completoCobrarMorosidadClientesDetallados=null;
	public Boolean mostrarnombre_completoCobrarMorosidadClientesDetallados=true;
	public Boolean activarnombre_completoCobrarMorosidadClientesDetallados=true;

	public Border resaltarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados=null;
	public Boolean mostrarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados=true;
	public Boolean activarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados=true;

	public Border resaltarsaldo_vencidoCobrarMorosidadClientesDetallados=null;
	public Boolean mostrarsaldo_vencidoCobrarMorosidadClientesDetallados=true;
	public Boolean activarsaldo_vencidoCobrarMorosidadClientesDetallados=true;

	public Border resaltarsaldo_vencerCobrarMorosidadClientesDetallados=null;
	public Boolean mostrarsaldo_vencerCobrarMorosidadClientesDetallados=true;
	public Boolean activarsaldo_vencerCobrarMorosidadClientesDetallados=true;

	
	

	public Border setResaltaridCobrarMorosidadClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarMorosidadClientesDetalladosBeanSwingJInternalFrame cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarMorosidadClientesDetallados.setBorder(borderResaltar);
		
		this.resaltaridCobrarMorosidadClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarMorosidadClientesDetallados() {
		return this.resaltaridCobrarMorosidadClientesDetallados;
	}

	public void setResaltaridCobrarMorosidadClientesDetallados(Border borderResaltar) {
		this.resaltaridCobrarMorosidadClientesDetallados= borderResaltar;
	}

	public Boolean getMostraridCobrarMorosidadClientesDetallados() {
		return this.mostraridCobrarMorosidadClientesDetallados;
	}

	public void setMostraridCobrarMorosidadClientesDetallados(Boolean mostraridCobrarMorosidadClientesDetallados) {
		this.mostraridCobrarMorosidadClientesDetallados= mostraridCobrarMorosidadClientesDetallados;
	}

	public Boolean getActivaridCobrarMorosidadClientesDetallados() {
		return this.activaridCobrarMorosidadClientesDetallados;
	}

	public void setActivaridCobrarMorosidadClientesDetallados(Boolean activaridCobrarMorosidadClientesDetallados) {
		this.activaridCobrarMorosidadClientesDetallados= activaridCobrarMorosidadClientesDetallados;
	}

	public Border setResaltarid_empresaCobrarMorosidadClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarMorosidadClientesDetalladosBeanSwingJInternalFrame cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarMorosidadClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarMorosidadClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarMorosidadClientesDetallados() {
		return this.resaltarid_empresaCobrarMorosidadClientesDetallados;
	}

	public void setResaltarid_empresaCobrarMorosidadClientesDetallados(Border borderResaltar) {
		this.resaltarid_empresaCobrarMorosidadClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarMorosidadClientesDetallados() {
		return this.mostrarid_empresaCobrarMorosidadClientesDetallados;
	}

	public void setMostrarid_empresaCobrarMorosidadClientesDetallados(Boolean mostrarid_empresaCobrarMorosidadClientesDetallados) {
		this.mostrarid_empresaCobrarMorosidadClientesDetallados= mostrarid_empresaCobrarMorosidadClientesDetallados;
	}

	public Boolean getActivarid_empresaCobrarMorosidadClientesDetallados() {
		return this.activarid_empresaCobrarMorosidadClientesDetallados;
	}

	public void setActivarid_empresaCobrarMorosidadClientesDetallados(Boolean activarid_empresaCobrarMorosidadClientesDetallados) {
		this.activarid_empresaCobrarMorosidadClientesDetallados= activarid_empresaCobrarMorosidadClientesDetallados;
	}

	public Boolean getCargarid_empresaCobrarMorosidadClientesDetallados() {
		return this.cargarid_empresaCobrarMorosidadClientesDetallados;
	}

	public void setCargarid_empresaCobrarMorosidadClientesDetallados(Boolean cargarid_empresaCobrarMorosidadClientesDetallados) {
		this.cargarid_empresaCobrarMorosidadClientesDetallados= cargarid_empresaCobrarMorosidadClientesDetallados;
	}

	public Border setResaltarfecha_venceCobrarMorosidadClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarMorosidadClientesDetalladosBeanSwingJInternalFrame cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarMorosidadClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarfecha_venceCobrarMorosidadClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_venceCobrarMorosidadClientesDetallados() {
		return this.resaltarfecha_venceCobrarMorosidadClientesDetallados;
	}

	public void setResaltarfecha_venceCobrarMorosidadClientesDetallados(Border borderResaltar) {
		this.resaltarfecha_venceCobrarMorosidadClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarfecha_venceCobrarMorosidadClientesDetallados() {
		return this.mostrarfecha_venceCobrarMorosidadClientesDetallados;
	}

	public void setMostrarfecha_venceCobrarMorosidadClientesDetallados(Boolean mostrarfecha_venceCobrarMorosidadClientesDetallados) {
		this.mostrarfecha_venceCobrarMorosidadClientesDetallados= mostrarfecha_venceCobrarMorosidadClientesDetallados;
	}

	public Boolean getActivarfecha_venceCobrarMorosidadClientesDetallados() {
		return this.activarfecha_venceCobrarMorosidadClientesDetallados;
	}

	public void setActivarfecha_venceCobrarMorosidadClientesDetallados(Boolean activarfecha_venceCobrarMorosidadClientesDetallados) {
		this.activarfecha_venceCobrarMorosidadClientesDetallados= activarfecha_venceCobrarMorosidadClientesDetallados;
	}

	public Border setResaltarcodigoCobrarMorosidadClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarMorosidadClientesDetalladosBeanSwingJInternalFrame cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarMorosidadClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarcodigoCobrarMorosidadClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCobrarMorosidadClientesDetallados() {
		return this.resaltarcodigoCobrarMorosidadClientesDetallados;
	}

	public void setResaltarcodigoCobrarMorosidadClientesDetallados(Border borderResaltar) {
		this.resaltarcodigoCobrarMorosidadClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarcodigoCobrarMorosidadClientesDetallados() {
		return this.mostrarcodigoCobrarMorosidadClientesDetallados;
	}

	public void setMostrarcodigoCobrarMorosidadClientesDetallados(Boolean mostrarcodigoCobrarMorosidadClientesDetallados) {
		this.mostrarcodigoCobrarMorosidadClientesDetallados= mostrarcodigoCobrarMorosidadClientesDetallados;
	}

	public Boolean getActivarcodigoCobrarMorosidadClientesDetallados() {
		return this.activarcodigoCobrarMorosidadClientesDetallados;
	}

	public void setActivarcodigoCobrarMorosidadClientesDetallados(Boolean activarcodigoCobrarMorosidadClientesDetallados) {
		this.activarcodigoCobrarMorosidadClientesDetallados= activarcodigoCobrarMorosidadClientesDetallados;
	}

	public Border setResaltarnombre_completoCobrarMorosidadClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarMorosidadClientesDetalladosBeanSwingJInternalFrame cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarMorosidadClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarnombre_completoCobrarMorosidadClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoCobrarMorosidadClientesDetallados() {
		return this.resaltarnombre_completoCobrarMorosidadClientesDetallados;
	}

	public void setResaltarnombre_completoCobrarMorosidadClientesDetallados(Border borderResaltar) {
		this.resaltarnombre_completoCobrarMorosidadClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarnombre_completoCobrarMorosidadClientesDetallados() {
		return this.mostrarnombre_completoCobrarMorosidadClientesDetallados;
	}

	public void setMostrarnombre_completoCobrarMorosidadClientesDetallados(Boolean mostrarnombre_completoCobrarMorosidadClientesDetallados) {
		this.mostrarnombre_completoCobrarMorosidadClientesDetallados= mostrarnombre_completoCobrarMorosidadClientesDetallados;
	}

	public Boolean getActivarnombre_completoCobrarMorosidadClientesDetallados() {
		return this.activarnombre_completoCobrarMorosidadClientesDetallados;
	}

	public void setActivarnombre_completoCobrarMorosidadClientesDetallados(Boolean activarnombre_completoCobrarMorosidadClientesDetallados) {
		this.activarnombre_completoCobrarMorosidadClientesDetallados= activarnombre_completoCobrarMorosidadClientesDetallados;
	}

	public Border setResaltarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarMorosidadClientesDetalladosBeanSwingJInternalFrame cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarMorosidadClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados() {
		return this.resaltarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados;
	}

	public void setResaltarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados(Border borderResaltar) {
		this.resaltarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados() {
		return this.mostrarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados;
	}

	public void setMostrarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados(Boolean mostrarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados) {
		this.mostrarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados= mostrarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados;
	}

	public Boolean getActivarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados() {
		return this.activarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados;
	}

	public void setActivarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados(Boolean activarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados) {
		this.activarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados= activarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados;
	}

	public Border setResaltarsaldo_vencidoCobrarMorosidadClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarMorosidadClientesDetalladosBeanSwingJInternalFrame cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarMorosidadClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarsaldo_vencidoCobrarMorosidadClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_vencidoCobrarMorosidadClientesDetallados() {
		return this.resaltarsaldo_vencidoCobrarMorosidadClientesDetallados;
	}

	public void setResaltarsaldo_vencidoCobrarMorosidadClientesDetallados(Border borderResaltar) {
		this.resaltarsaldo_vencidoCobrarMorosidadClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarsaldo_vencidoCobrarMorosidadClientesDetallados() {
		return this.mostrarsaldo_vencidoCobrarMorosidadClientesDetallados;
	}

	public void setMostrarsaldo_vencidoCobrarMorosidadClientesDetallados(Boolean mostrarsaldo_vencidoCobrarMorosidadClientesDetallados) {
		this.mostrarsaldo_vencidoCobrarMorosidadClientesDetallados= mostrarsaldo_vencidoCobrarMorosidadClientesDetallados;
	}

	public Boolean getActivarsaldo_vencidoCobrarMorosidadClientesDetallados() {
		return this.activarsaldo_vencidoCobrarMorosidadClientesDetallados;
	}

	public void setActivarsaldo_vencidoCobrarMorosidadClientesDetallados(Boolean activarsaldo_vencidoCobrarMorosidadClientesDetallados) {
		this.activarsaldo_vencidoCobrarMorosidadClientesDetallados= activarsaldo_vencidoCobrarMorosidadClientesDetallados;
	}

	public Border setResaltarsaldo_vencerCobrarMorosidadClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarMorosidadClientesDetalladosBeanSwingJInternalFrame cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame.jTtoolBarCobrarMorosidadClientesDetallados.setBorder(borderResaltar);
		
		this.resaltarsaldo_vencerCobrarMorosidadClientesDetallados= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldo_vencerCobrarMorosidadClientesDetallados() {
		return this.resaltarsaldo_vencerCobrarMorosidadClientesDetallados;
	}

	public void setResaltarsaldo_vencerCobrarMorosidadClientesDetallados(Border borderResaltar) {
		this.resaltarsaldo_vencerCobrarMorosidadClientesDetallados= borderResaltar;
	}

	public Boolean getMostrarsaldo_vencerCobrarMorosidadClientesDetallados() {
		return this.mostrarsaldo_vencerCobrarMorosidadClientesDetallados;
	}

	public void setMostrarsaldo_vencerCobrarMorosidadClientesDetallados(Boolean mostrarsaldo_vencerCobrarMorosidadClientesDetallados) {
		this.mostrarsaldo_vencerCobrarMorosidadClientesDetallados= mostrarsaldo_vencerCobrarMorosidadClientesDetallados;
	}

	public Boolean getActivarsaldo_vencerCobrarMorosidadClientesDetallados() {
		return this.activarsaldo_vencerCobrarMorosidadClientesDetallados;
	}

	public void setActivarsaldo_vencerCobrarMorosidadClientesDetallados(Boolean activarsaldo_vencerCobrarMorosidadClientesDetallados) {
		this.activarsaldo_vencerCobrarMorosidadClientesDetallados= activarsaldo_vencerCobrarMorosidadClientesDetallados;
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
		
		
		this.setMostraridCobrarMorosidadClientesDetallados(esInicial);
		this.setMostrarid_empresaCobrarMorosidadClientesDetallados(esInicial);
		this.setMostrarfecha_venceCobrarMorosidadClientesDetallados(esInicial);
		this.setMostrarcodigoCobrarMorosidadClientesDetallados(esInicial);
		this.setMostrarnombre_completoCobrarMorosidadClientesDetallados(esInicial);
		this.setMostrarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados(esInicial);
		this.setMostrarsaldo_vencidoCobrarMorosidadClientesDetallados(esInicial);
		this.setMostrarsaldo_vencerCobrarMorosidadClientesDetallados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.ID)) {
				this.setMostraridCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.FECHAVENCE)) {
				this.setMostrarfecha_venceCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setMostrarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCIDO)) {
				this.setMostrarsaldo_vencidoCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCER)) {
				this.setMostrarsaldo_vencerCobrarMorosidadClientesDetallados(esAsigna);
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
		
		
		this.setActivaridCobrarMorosidadClientesDetallados(esInicial);
		this.setActivarid_empresaCobrarMorosidadClientesDetallados(esInicial);
		this.setActivarfecha_venceCobrarMorosidadClientesDetallados(esInicial);
		this.setActivarcodigoCobrarMorosidadClientesDetallados(esInicial);
		this.setActivarnombre_completoCobrarMorosidadClientesDetallados(esInicial);
		this.setActivarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados(esInicial);
		this.setActivarsaldo_vencidoCobrarMorosidadClientesDetallados(esInicial);
		this.setActivarsaldo_vencerCobrarMorosidadClientesDetallados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.ID)) {
				this.setActivaridCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.FECHAVENCE)) {
				this.setActivarfecha_venceCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setActivarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCIDO)) {
				this.setActivarsaldo_vencidoCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCER)) {
				this.setActivarsaldo_vencerCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarMorosidadClientesDetalladosBeanSwingJInternalFrame cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarMorosidadClientesDetallados(esInicial);
		this.setResaltarid_empresaCobrarMorosidadClientesDetallados(esInicial);
		this.setResaltarfecha_venceCobrarMorosidadClientesDetallados(esInicial);
		this.setResaltarcodigoCobrarMorosidadClientesDetallados(esInicial);
		this.setResaltarnombre_completoCobrarMorosidadClientesDetallados(esInicial);
		this.setResaltarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados(esInicial);
		this.setResaltarsaldo_vencidoCobrarMorosidadClientesDetallados(esInicial);
		this.setResaltarsaldo_vencerCobrarMorosidadClientesDetallados(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.ID)) {
				this.setResaltaridCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.FECHAVENCE)) {
				this.setResaltarfecha_venceCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.NUMEROPREIMPRESOFACTURA)) {
				this.setResaltarnumero_pre_impreso_facturaCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCIDO)) {
				this.setResaltarsaldo_vencidoCobrarMorosidadClientesDetallados(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarMorosidadClientesDetalladosConstantesFunciones.SALDOVENCER)) {
				this.setResaltarsaldo_vencerCobrarMorosidadClientesDetallados(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarMorosidadClientesDetalladosBeanSwingJInternalFrame cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados=true;

	public Boolean getMostrarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados() {
		return this.mostrarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados;
	}

	public void setMostrarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados=true;

	public Boolean getActivarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados() {
		return this.activarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados;
	}

	public void setActivarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados=null;

	public Border getResaltarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados() {
		return this.resaltarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados;
	}

	public void setResaltarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados(Border borderResaltar) {
		this.resaltarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados= borderResaltar;
	}

	public void setResaltarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarMorosidadClientesDetalladosBeanSwingJInternalFrame cobrarmorosidadclientesdetalladosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarMorosidadClientesDetalladosCobrarMorosidadClientesDetallados= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}