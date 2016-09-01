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
package com.bydan.erp.nomina.util.report;

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

import com.bydan.erp.nomina.resources.general.AuxiliarGeneral;

import com.bydan.erp.nomina.util.report.GeneraCreditosConstantesFunciones;
import com.bydan.erp.nomina.util.report.GeneraCreditosParameterReturnGeneral;
//import com.bydan.erp.nomina.util.report.GeneraCreditosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.nomina.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.nomina.business.dataaccess.*;
//import com.bydan.erp.nomina.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class GeneraCreditosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="GeneraCreditos";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="GeneraCreditos"+GeneraCreditosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="GeneraCreditosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="GeneraCreditosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=GeneraCreditosConstantesFunciones.SCHEMA+"_"+GeneraCreditosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/GeneraCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=GeneraCreditosConstantesFunciones.SCHEMA+"_"+GeneraCreditosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=GeneraCreditosConstantesFunciones.SCHEMA+"_"+GeneraCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/GeneraCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=GeneraCreditosConstantesFunciones.SCHEMA+"_"+GeneraCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GeneraCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GeneraCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GeneraCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GeneraCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GeneraCreditosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GeneraCreditosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=GeneraCreditosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+GeneraCreditosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=GeneraCreditosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+GeneraCreditosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Genera Creditoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Genera Creditos";
	public static final String SCLASSWEBTITULO_LOWER="Genera Creditos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="GeneraCreditos";
	public static final String OBJECTNAME="generacreditos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="genera_creditos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select generacreditos from "+GeneraCreditosConstantesFunciones.SPERSISTENCENAME+" generacreditos";
	public static String QUERYSELECTNATIVE="select "+GeneraCreditosConstantesFunciones.SCHEMA+"."+GeneraCreditosConstantesFunciones.TABLENAME+".id,"+GeneraCreditosConstantesFunciones.SCHEMA+"."+GeneraCreditosConstantesFunciones.TABLENAME+".version_row,"+GeneraCreditosConstantesFunciones.SCHEMA+"."+GeneraCreditosConstantesFunciones.TABLENAME+".id_empresa,"+GeneraCreditosConstantesFunciones.SCHEMA+"."+GeneraCreditosConstantesFunciones.TABLENAME+".codigo,"+GeneraCreditosConstantesFunciones.SCHEMA+"."+GeneraCreditosConstantesFunciones.TABLENAME+".nombre_completo,"+GeneraCreditosConstantesFunciones.SCHEMA+"."+GeneraCreditosConstantesFunciones.TABLENAME+".fecha_vence,"+GeneraCreditosConstantesFunciones.SCHEMA+"."+GeneraCreditosConstantesFunciones.TABLENAME+".fecha_emision,"+GeneraCreditosConstantesFunciones.SCHEMA+"."+GeneraCreditosConstantesFunciones.TABLENAME+".numero_factura,"+GeneraCreditosConstantesFunciones.SCHEMA+"."+GeneraCreditosConstantesFunciones.TABLENAME+".debito_mone_local,"+GeneraCreditosConstantesFunciones.SCHEMA+"."+GeneraCreditosConstantesFunciones.TABLENAME+".credito_mone_local,"+GeneraCreditosConstantesFunciones.SCHEMA+"."+GeneraCreditosConstantesFunciones.TABLENAME+".saldo from "+GeneraCreditosConstantesFunciones.SCHEMA+"."+GeneraCreditosConstantesFunciones.TABLENAME;//+" as "+GeneraCreditosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String FECHAVENCE= "fecha_vence";
    public static final String FECHAEMISION= "fecha_emision";
    public static final String NUMEROFACTURA= "numero_factura";
    public static final String DEBITOMONELOCAL= "debito_mone_local";
    public static final String CREDITOMONELOCAL= "credito_mone_local";
    public static final String SALDO= "saldo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_FECHAVENCE= "Fecha Vence";
		public static final String LABEL_FECHAVENCE_LOWER= "Fecha Vence";
    	public static final String LABEL_FECHAEMISION= "Fecha Emision";
		public static final String LABEL_FECHAEMISION_LOWER= "Fecha Emision";
    	public static final String LABEL_NUMEROFACTURA= "Numero Factura";
		public static final String LABEL_NUMEROFACTURA_LOWER= "Numero Factura";
    	public static final String LABEL_DEBITOMONELOCAL= "Debito Mone Local";
		public static final String LABEL_DEBITOMONELOCAL_LOWER= "Debito Mone Local";
    	public static final String LABEL_CREDITOMONELOCAL= "Credito Mone Local";
		public static final String LABEL_CREDITOMONELOCAL_LOWER= "Credito Mone Local";
    	public static final String LABEL_SALDO= "Saldo";
		public static final String LABEL_SALDO_LOWER= "Saldo";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	public static final String SREGEXNUMERO_FACTURA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_FACTURA=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getGeneraCreditosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(GeneraCreditosConstantesFunciones.IDEMPRESA)) {sLabelColumna=GeneraCreditosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(GeneraCreditosConstantesFunciones.CODIGO)) {sLabelColumna=GeneraCreditosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(GeneraCreditosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=GeneraCreditosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(GeneraCreditosConstantesFunciones.FECHAVENCE)) {sLabelColumna=GeneraCreditosConstantesFunciones.LABEL_FECHAVENCE;}
		if(sNombreColumna.equals(GeneraCreditosConstantesFunciones.FECHAEMISION)) {sLabelColumna=GeneraCreditosConstantesFunciones.LABEL_FECHAEMISION;}
		if(sNombreColumna.equals(GeneraCreditosConstantesFunciones.NUMEROFACTURA)) {sLabelColumna=GeneraCreditosConstantesFunciones.LABEL_NUMEROFACTURA;}
		if(sNombreColumna.equals(GeneraCreditosConstantesFunciones.DEBITOMONELOCAL)) {sLabelColumna=GeneraCreditosConstantesFunciones.LABEL_DEBITOMONELOCAL;}
		if(sNombreColumna.equals(GeneraCreditosConstantesFunciones.CREDITOMONELOCAL)) {sLabelColumna=GeneraCreditosConstantesFunciones.LABEL_CREDITOMONELOCAL;}
		if(sNombreColumna.equals(GeneraCreditosConstantesFunciones.SALDO)) {sLabelColumna=GeneraCreditosConstantesFunciones.LABEL_SALDO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getGeneraCreditosDescripcion(GeneraCreditos generacreditos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(generacreditos !=null/* && generacreditos.getId()!=0*/) {
			sDescripcion=generacreditos.getcodigo();//generacreditosgeneracreditos.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getGeneraCreditosDescripcionDetallado(GeneraCreditos generacreditos) {
		String sDescripcion="";
			
		sDescripcion+=GeneraCreditosConstantesFunciones.ID+"=";
		sDescripcion+=generacreditos.getId().toString()+",";
		sDescripcion+=GeneraCreditosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=generacreditos.getVersionRow().toString()+",";
		sDescripcion+=GeneraCreditosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=generacreditos.getid_empresa().toString()+",";
		sDescripcion+=GeneraCreditosConstantesFunciones.CODIGO+"=";
		sDescripcion+=generacreditos.getcodigo()+",";
		sDescripcion+=GeneraCreditosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=generacreditos.getnombre_completo()+",";
		sDescripcion+=GeneraCreditosConstantesFunciones.FECHAVENCE+"=";
		sDescripcion+=generacreditos.getfecha_vence().toString()+",";
		sDescripcion+=GeneraCreditosConstantesFunciones.FECHAEMISION+"=";
		sDescripcion+=generacreditos.getfecha_emision().toString()+",";
		sDescripcion+=GeneraCreditosConstantesFunciones.NUMEROFACTURA+"=";
		sDescripcion+=generacreditos.getnumero_factura()+",";
		sDescripcion+=GeneraCreditosConstantesFunciones.DEBITOMONELOCAL+"=";
		sDescripcion+=generacreditos.getdebito_mone_local().toString()+",";
		sDescripcion+=GeneraCreditosConstantesFunciones.CREDITOMONELOCAL+"=";
		sDescripcion+=generacreditos.getcredito_mone_local().toString()+",";
		sDescripcion+=GeneraCreditosConstantesFunciones.SALDO+"=";
		sDescripcion+=generacreditos.getsaldo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setGeneraCreditosDescripcion(GeneraCreditos generacreditos,String sValor) throws Exception {			
		if(generacreditos !=null) {
			generacreditos.setcodigo(sValor);;//generacreditosgeneracreditos.getcodigo().trim();
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
		} else if(sNombreIndice.equals("BusquedaGeneraCreditos")) {
			sNombreIndice="Tipo=  Por Id";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaGeneraCreditos(Long id) {
		String sDetalleIndice=" Parametros->";
		if(id!=null) {sDetalleIndice+=" Id="+id.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosGeneraCreditos(GeneraCreditos generacreditos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		generacreditos.setcodigo(generacreditos.getcodigo().trim());
		generacreditos.setnombre_completo(generacreditos.getnombre_completo().trim());
		generacreditos.setnumero_factura(generacreditos.getnumero_factura().trim());
	}
	
	public static void quitarEspaciosGeneraCreditoss(List<GeneraCreditos> generacreditoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GeneraCreditos generacreditos: generacreditoss) {
			generacreditos.setcodigo(generacreditos.getcodigo().trim());
			generacreditos.setnombre_completo(generacreditos.getnombre_completo().trim());
			generacreditos.setnumero_factura(generacreditos.getnumero_factura().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGeneraCreditos(GeneraCreditos generacreditos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && generacreditos.getConCambioAuxiliar()) {
			generacreditos.setIsDeleted(generacreditos.getIsDeletedAuxiliar());	
			generacreditos.setIsNew(generacreditos.getIsNewAuxiliar());	
			generacreditos.setIsChanged(generacreditos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			generacreditos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			generacreditos.setIsDeletedAuxiliar(false);	
			generacreditos.setIsNewAuxiliar(false);	
			generacreditos.setIsChangedAuxiliar(false);
			
			generacreditos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGeneraCreditoss(List<GeneraCreditos> generacreditoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(GeneraCreditos generacreditos : generacreditoss) {
			if(conAsignarBase && generacreditos.getConCambioAuxiliar()) {
				generacreditos.setIsDeleted(generacreditos.getIsDeletedAuxiliar());	
				generacreditos.setIsNew(generacreditos.getIsNewAuxiliar());	
				generacreditos.setIsChanged(generacreditos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				generacreditos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				generacreditos.setIsDeletedAuxiliar(false);	
				generacreditos.setIsNewAuxiliar(false);	
				generacreditos.setIsChangedAuxiliar(false);
				
				generacreditos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresGeneraCreditos(GeneraCreditos generacreditos,Boolean conEnteros) throws Exception  {
		generacreditos.setdebito_mone_local(0.0);
		generacreditos.setcredito_mone_local(0.0);
		generacreditos.setsaldo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresGeneraCreditoss(List<GeneraCreditos> generacreditoss,Boolean conEnteros) throws Exception  {
		
		for(GeneraCreditos generacreditos: generacreditoss) {
			generacreditos.setdebito_mone_local(0.0);
			generacreditos.setcredito_mone_local(0.0);
			generacreditos.setsaldo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaGeneraCreditos(List<GeneraCreditos> generacreditoss,GeneraCreditos generacreditosAux) throws Exception  {
		GeneraCreditosConstantesFunciones.InicializarValoresGeneraCreditos(generacreditosAux,true);
		
		for(GeneraCreditos generacreditos: generacreditoss) {
			if(generacreditos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			generacreditosAux.setdebito_mone_local(generacreditosAux.getdebito_mone_local()+generacreditos.getdebito_mone_local());			
			generacreditosAux.setcredito_mone_local(generacreditosAux.getcredito_mone_local()+generacreditos.getcredito_mone_local());			
			generacreditosAux.setsaldo(generacreditosAux.getsaldo()+generacreditos.getsaldo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGeneraCreditos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=GeneraCreditosConstantesFunciones.getArrayColumnasGlobalesGeneraCreditos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesGeneraCreditos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GeneraCreditosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GeneraCreditosConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoGeneraCreditos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GeneraCreditos> generacreditoss,GeneraCreditos generacreditos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GeneraCreditos generacreditosAux: generacreditoss) {
			if(generacreditosAux!=null && generacreditos!=null) {
				if((generacreditosAux.getId()==null && generacreditos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(generacreditosAux.getId()!=null && generacreditos.getId()!=null){
					if(generacreditosAux.getId().equals(generacreditos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGeneraCreditos(List<GeneraCreditos> generacreditoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double debito_mone_localTotal=0.0;
		Double credito_mone_localTotal=0.0;
		Double saldoTotal=0.0;
	
		for(GeneraCreditos generacreditos: generacreditoss) {			
			if(generacreditos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			debito_mone_localTotal+=generacreditos.getdebito_mone_local();
			credito_mone_localTotal+=generacreditos.getcredito_mone_local();
			saldoTotal+=generacreditos.getsaldo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GeneraCreditosConstantesFunciones.DEBITOMONELOCAL);
		datoGeneral.setsDescripcion(GeneraCreditosConstantesFunciones.LABEL_DEBITOMONELOCAL);
		datoGeneral.setdValorDouble(debito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GeneraCreditosConstantesFunciones.CREDITOMONELOCAL);
		datoGeneral.setsDescripcion(GeneraCreditosConstantesFunciones.LABEL_CREDITOMONELOCAL);
		datoGeneral.setdValorDouble(credito_mone_localTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GeneraCreditosConstantesFunciones.SALDO);
		datoGeneral.setsDescripcion(GeneraCreditosConstantesFunciones.LABEL_SALDO);
		datoGeneral.setdValorDouble(saldoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaGeneraCreditos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasGeneraCreditos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGeneraCreditos() throws Exception  {
		return GeneraCreditosConstantesFunciones.getTiposSeleccionarGeneraCreditos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGeneraCreditos(Boolean conFk) throws Exception  {
		return GeneraCreditosConstantesFunciones.getTiposSeleccionarGeneraCreditos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGeneraCreditos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GeneraCreditosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(GeneraCreditosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GeneraCreditosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(GeneraCreditosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GeneraCreditosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(GeneraCreditosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GeneraCreditosConstantesFunciones.LABEL_FECHAVENCE);
			reporte.setsDescripcion(GeneraCreditosConstantesFunciones.LABEL_FECHAVENCE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GeneraCreditosConstantesFunciones.LABEL_FECHAEMISION);
			reporte.setsDescripcion(GeneraCreditosConstantesFunciones.LABEL_FECHAEMISION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GeneraCreditosConstantesFunciones.LABEL_NUMEROFACTURA);
			reporte.setsDescripcion(GeneraCreditosConstantesFunciones.LABEL_NUMEROFACTURA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GeneraCreditosConstantesFunciones.LABEL_DEBITOMONELOCAL);
			reporte.setsDescripcion(GeneraCreditosConstantesFunciones.LABEL_DEBITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GeneraCreditosConstantesFunciones.LABEL_CREDITOMONELOCAL);
			reporte.setsDescripcion(GeneraCreditosConstantesFunciones.LABEL_CREDITOMONELOCAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GeneraCreditosConstantesFunciones.LABEL_SALDO);
			reporte.setsDescripcion(GeneraCreditosConstantesFunciones.LABEL_SALDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesGeneraCreditos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesGeneraCreditos(GeneraCreditos generacreditosAux) throws Exception {
		
			generacreditosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(generacreditosAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesGeneraCreditos(List<GeneraCreditos> generacreditossTemp) throws Exception {
		for(GeneraCreditos generacreditosAux:generacreditossTemp) {
			
			generacreditosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(generacreditosAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfGeneraCreditos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfGeneraCreditos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfGeneraCreditos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return GeneraCreditosConstantesFunciones.getClassesRelationshipsOfGeneraCreditos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGeneraCreditos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGeneraCreditos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return GeneraCreditosConstantesFunciones.getClassesRelationshipsFromStringsOfGeneraCreditos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGeneraCreditos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(GeneraCreditos generacreditos,List<GeneraCreditos> generacreditoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(GeneraCreditos generacreditos,List<GeneraCreditos> generacreditoss) throws Exception {
		try	{			
			for(GeneraCreditos generacreditosLocal:generacreditoss) {
				if(generacreditosLocal.getId().equals(generacreditos.getId())) {
					generacreditosLocal.setIsSelected(generacreditos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesGeneraCreditos(List<GeneraCreditos> generacreditossAux) throws Exception {
		//this.generacreditossAux=generacreditossAux;
		
		for(GeneraCreditos generacreditosAux:generacreditossAux) {
			if(generacreditosAux.getIsChanged()) {
				generacreditosAux.setIsChanged(false);
			}		
			
			if(generacreditosAux.getIsNew()) {
				generacreditosAux.setIsNew(false);
			}	
			
			if(generacreditosAux.getIsDeleted()) {
				generacreditosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesGeneraCreditos(GeneraCreditos generacreditosAux) throws Exception {
		//this.generacreditosAux=generacreditosAux;
		
			if(generacreditosAux.getIsChanged()) {
				generacreditosAux.setIsChanged(false);
			}		
			
			if(generacreditosAux.getIsNew()) {
				generacreditosAux.setIsNew(false);
			}	
			
			if(generacreditosAux.getIsDeleted()) {
				generacreditosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(GeneraCreditos generacreditosAsignar,GeneraCreditos generacreditos) throws Exception {
		generacreditosAsignar.setVersionRow(generacreditos.getVersionRow());	
		generacreditosAsignar.setcodigo(generacreditos.getcodigo());	
		generacreditosAsignar.setnombre_completo(generacreditos.getnombre_completo());	
		generacreditosAsignar.setfecha_vence(generacreditos.getfecha_vence());	
		generacreditosAsignar.setfecha_emision(generacreditos.getfecha_emision());	
		generacreditosAsignar.setnumero_factura(generacreditos.getnumero_factura());	
		generacreditosAsignar.setdebito_mone_local(generacreditos.getdebito_mone_local());	
		generacreditosAsignar.setcredito_mone_local(generacreditos.getcredito_mone_local());	
		generacreditosAsignar.setsaldo(generacreditos.getsaldo());	
	}
	
	public static void inicializarGeneraCreditos(GeneraCreditos generacreditos) throws Exception {
		try {
					
				generacreditos.setcodigo("");	
				generacreditos.setnombre_completo("");	
				generacreditos.setfecha_vence(new Date());	
				generacreditos.setfecha_emision(new Date());	
				generacreditos.setnumero_factura("");	
				generacreditos.setdebito_mone_local(0.0);	
				generacreditos.setcredito_mone_local(0.0);	
				generacreditos.setsaldo(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderGeneraCreditos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(GeneraCreditosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GeneraCreditosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GeneraCreditosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GeneraCreditosConstantesFunciones.LABEL_FECHAVENCE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GeneraCreditosConstantesFunciones.LABEL_FECHAEMISION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GeneraCreditosConstantesFunciones.LABEL_NUMEROFACTURA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GeneraCreditosConstantesFunciones.LABEL_DEBITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GeneraCreditosConstantesFunciones.LABEL_CREDITOMONELOCAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GeneraCreditosConstantesFunciones.LABEL_SALDO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataGeneraCreditos(String sTipo,Row row,Workbook workbook,GeneraCreditos generacreditos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(generacreditos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(generacreditos.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(generacreditos.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(generacreditos.getfecha_vence());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(generacreditos.getfecha_emision());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(generacreditos.getnumero_factura());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(generacreditos.getdebito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(generacreditos.getcredito_mone_local());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(generacreditos.getsaldo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryGeneraCreditos="";
	
	public String getsFinalQueryGeneraCreditos() {
		return this.sFinalQueryGeneraCreditos;
	}
	
	public void setsFinalQueryGeneraCreditos(String sFinalQueryGeneraCreditos) {
		this.sFinalQueryGeneraCreditos= sFinalQueryGeneraCreditos;
	}
	
	public Border resaltarSeleccionarGeneraCreditos=null;
	
	public Border setResaltarSeleccionarGeneraCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*GeneraCreditosBeanSwingJInternalFrame generacreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//generacreditosBeanSwingJInternalFrame.jTtoolBarGeneraCreditos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarGeneraCreditos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarGeneraCreditos() {
		return this.resaltarSeleccionarGeneraCreditos;
	}
	
	public void setResaltarSeleccionarGeneraCreditos(Border borderResaltarSeleccionarGeneraCreditos) {
		this.resaltarSeleccionarGeneraCreditos= borderResaltarSeleccionarGeneraCreditos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridGeneraCreditos=null;
	public Boolean mostraridGeneraCreditos=true;
	public Boolean activaridGeneraCreditos=true;

	public Border resaltarid_empresaGeneraCreditos=null;
	public Boolean mostrarid_empresaGeneraCreditos=true;
	public Boolean activarid_empresaGeneraCreditos=true;
	public Boolean cargarid_empresaGeneraCreditos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaGeneraCreditos=false;//ConEventDepend=true

	public Border resaltarcodigoGeneraCreditos=null;
	public Boolean mostrarcodigoGeneraCreditos=true;
	public Boolean activarcodigoGeneraCreditos=true;

	public Border resaltarnombre_completoGeneraCreditos=null;
	public Boolean mostrarnombre_completoGeneraCreditos=true;
	public Boolean activarnombre_completoGeneraCreditos=true;

	public Border resaltarfecha_venceGeneraCreditos=null;
	public Boolean mostrarfecha_venceGeneraCreditos=true;
	public Boolean activarfecha_venceGeneraCreditos=true;

	public Border resaltarfecha_emisionGeneraCreditos=null;
	public Boolean mostrarfecha_emisionGeneraCreditos=true;
	public Boolean activarfecha_emisionGeneraCreditos=true;

	public Border resaltarnumero_facturaGeneraCreditos=null;
	public Boolean mostrarnumero_facturaGeneraCreditos=true;
	public Boolean activarnumero_facturaGeneraCreditos=true;

	public Border resaltardebito_mone_localGeneraCreditos=null;
	public Boolean mostrardebito_mone_localGeneraCreditos=true;
	public Boolean activardebito_mone_localGeneraCreditos=true;

	public Border resaltarcredito_mone_localGeneraCreditos=null;
	public Boolean mostrarcredito_mone_localGeneraCreditos=true;
	public Boolean activarcredito_mone_localGeneraCreditos=true;

	public Border resaltarsaldoGeneraCreditos=null;
	public Boolean mostrarsaldoGeneraCreditos=true;
	public Boolean activarsaldoGeneraCreditos=true;

	
	

	public Border setResaltaridGeneraCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*GeneraCreditosBeanSwingJInternalFrame generacreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//generacreditosBeanSwingJInternalFrame.jTtoolBarGeneraCreditos.setBorder(borderResaltar);
		
		this.resaltaridGeneraCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridGeneraCreditos() {
		return this.resaltaridGeneraCreditos;
	}

	public void setResaltaridGeneraCreditos(Border borderResaltar) {
		this.resaltaridGeneraCreditos= borderResaltar;
	}

	public Boolean getMostraridGeneraCreditos() {
		return this.mostraridGeneraCreditos;
	}

	public void setMostraridGeneraCreditos(Boolean mostraridGeneraCreditos) {
		this.mostraridGeneraCreditos= mostraridGeneraCreditos;
	}

	public Boolean getActivaridGeneraCreditos() {
		return this.activaridGeneraCreditos;
	}

	public void setActivaridGeneraCreditos(Boolean activaridGeneraCreditos) {
		this.activaridGeneraCreditos= activaridGeneraCreditos;
	}

	public Border setResaltarid_empresaGeneraCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*GeneraCreditosBeanSwingJInternalFrame generacreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//generacreditosBeanSwingJInternalFrame.jTtoolBarGeneraCreditos.setBorder(borderResaltar);
		
		this.resaltarid_empresaGeneraCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaGeneraCreditos() {
		return this.resaltarid_empresaGeneraCreditos;
	}

	public void setResaltarid_empresaGeneraCreditos(Border borderResaltar) {
		this.resaltarid_empresaGeneraCreditos= borderResaltar;
	}

	public Boolean getMostrarid_empresaGeneraCreditos() {
		return this.mostrarid_empresaGeneraCreditos;
	}

	public void setMostrarid_empresaGeneraCreditos(Boolean mostrarid_empresaGeneraCreditos) {
		this.mostrarid_empresaGeneraCreditos= mostrarid_empresaGeneraCreditos;
	}

	public Boolean getActivarid_empresaGeneraCreditos() {
		return this.activarid_empresaGeneraCreditos;
	}

	public void setActivarid_empresaGeneraCreditos(Boolean activarid_empresaGeneraCreditos) {
		this.activarid_empresaGeneraCreditos= activarid_empresaGeneraCreditos;
	}

	public Boolean getCargarid_empresaGeneraCreditos() {
		return this.cargarid_empresaGeneraCreditos;
	}

	public void setCargarid_empresaGeneraCreditos(Boolean cargarid_empresaGeneraCreditos) {
		this.cargarid_empresaGeneraCreditos= cargarid_empresaGeneraCreditos;
	}

	public Border setResaltarcodigoGeneraCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*GeneraCreditosBeanSwingJInternalFrame generacreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//generacreditosBeanSwingJInternalFrame.jTtoolBarGeneraCreditos.setBorder(borderResaltar);
		
		this.resaltarcodigoGeneraCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoGeneraCreditos() {
		return this.resaltarcodigoGeneraCreditos;
	}

	public void setResaltarcodigoGeneraCreditos(Border borderResaltar) {
		this.resaltarcodigoGeneraCreditos= borderResaltar;
	}

	public Boolean getMostrarcodigoGeneraCreditos() {
		return this.mostrarcodigoGeneraCreditos;
	}

	public void setMostrarcodigoGeneraCreditos(Boolean mostrarcodigoGeneraCreditos) {
		this.mostrarcodigoGeneraCreditos= mostrarcodigoGeneraCreditos;
	}

	public Boolean getActivarcodigoGeneraCreditos() {
		return this.activarcodigoGeneraCreditos;
	}

	public void setActivarcodigoGeneraCreditos(Boolean activarcodigoGeneraCreditos) {
		this.activarcodigoGeneraCreditos= activarcodigoGeneraCreditos;
	}

	public Border setResaltarnombre_completoGeneraCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*GeneraCreditosBeanSwingJInternalFrame generacreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//generacreditosBeanSwingJInternalFrame.jTtoolBarGeneraCreditos.setBorder(borderResaltar);
		
		this.resaltarnombre_completoGeneraCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoGeneraCreditos() {
		return this.resaltarnombre_completoGeneraCreditos;
	}

	public void setResaltarnombre_completoGeneraCreditos(Border borderResaltar) {
		this.resaltarnombre_completoGeneraCreditos= borderResaltar;
	}

	public Boolean getMostrarnombre_completoGeneraCreditos() {
		return this.mostrarnombre_completoGeneraCreditos;
	}

	public void setMostrarnombre_completoGeneraCreditos(Boolean mostrarnombre_completoGeneraCreditos) {
		this.mostrarnombre_completoGeneraCreditos= mostrarnombre_completoGeneraCreditos;
	}

	public Boolean getActivarnombre_completoGeneraCreditos() {
		return this.activarnombre_completoGeneraCreditos;
	}

	public void setActivarnombre_completoGeneraCreditos(Boolean activarnombre_completoGeneraCreditos) {
		this.activarnombre_completoGeneraCreditos= activarnombre_completoGeneraCreditos;
	}

	public Border setResaltarfecha_venceGeneraCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*GeneraCreditosBeanSwingJInternalFrame generacreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//generacreditosBeanSwingJInternalFrame.jTtoolBarGeneraCreditos.setBorder(borderResaltar);
		
		this.resaltarfecha_venceGeneraCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_venceGeneraCreditos() {
		return this.resaltarfecha_venceGeneraCreditos;
	}

	public void setResaltarfecha_venceGeneraCreditos(Border borderResaltar) {
		this.resaltarfecha_venceGeneraCreditos= borderResaltar;
	}

	public Boolean getMostrarfecha_venceGeneraCreditos() {
		return this.mostrarfecha_venceGeneraCreditos;
	}

	public void setMostrarfecha_venceGeneraCreditos(Boolean mostrarfecha_venceGeneraCreditos) {
		this.mostrarfecha_venceGeneraCreditos= mostrarfecha_venceGeneraCreditos;
	}

	public Boolean getActivarfecha_venceGeneraCreditos() {
		return this.activarfecha_venceGeneraCreditos;
	}

	public void setActivarfecha_venceGeneraCreditos(Boolean activarfecha_venceGeneraCreditos) {
		this.activarfecha_venceGeneraCreditos= activarfecha_venceGeneraCreditos;
	}

	public Border setResaltarfecha_emisionGeneraCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*GeneraCreditosBeanSwingJInternalFrame generacreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//generacreditosBeanSwingJInternalFrame.jTtoolBarGeneraCreditos.setBorder(borderResaltar);
		
		this.resaltarfecha_emisionGeneraCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emisionGeneraCreditos() {
		return this.resaltarfecha_emisionGeneraCreditos;
	}

	public void setResaltarfecha_emisionGeneraCreditos(Border borderResaltar) {
		this.resaltarfecha_emisionGeneraCreditos= borderResaltar;
	}

	public Boolean getMostrarfecha_emisionGeneraCreditos() {
		return this.mostrarfecha_emisionGeneraCreditos;
	}

	public void setMostrarfecha_emisionGeneraCreditos(Boolean mostrarfecha_emisionGeneraCreditos) {
		this.mostrarfecha_emisionGeneraCreditos= mostrarfecha_emisionGeneraCreditos;
	}

	public Boolean getActivarfecha_emisionGeneraCreditos() {
		return this.activarfecha_emisionGeneraCreditos;
	}

	public void setActivarfecha_emisionGeneraCreditos(Boolean activarfecha_emisionGeneraCreditos) {
		this.activarfecha_emisionGeneraCreditos= activarfecha_emisionGeneraCreditos;
	}

	public Border setResaltarnumero_facturaGeneraCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*GeneraCreditosBeanSwingJInternalFrame generacreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//generacreditosBeanSwingJInternalFrame.jTtoolBarGeneraCreditos.setBorder(borderResaltar);
		
		this.resaltarnumero_facturaGeneraCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_facturaGeneraCreditos() {
		return this.resaltarnumero_facturaGeneraCreditos;
	}

	public void setResaltarnumero_facturaGeneraCreditos(Border borderResaltar) {
		this.resaltarnumero_facturaGeneraCreditos= borderResaltar;
	}

	public Boolean getMostrarnumero_facturaGeneraCreditos() {
		return this.mostrarnumero_facturaGeneraCreditos;
	}

	public void setMostrarnumero_facturaGeneraCreditos(Boolean mostrarnumero_facturaGeneraCreditos) {
		this.mostrarnumero_facturaGeneraCreditos= mostrarnumero_facturaGeneraCreditos;
	}

	public Boolean getActivarnumero_facturaGeneraCreditos() {
		return this.activarnumero_facturaGeneraCreditos;
	}

	public void setActivarnumero_facturaGeneraCreditos(Boolean activarnumero_facturaGeneraCreditos) {
		this.activarnumero_facturaGeneraCreditos= activarnumero_facturaGeneraCreditos;
	}

	public Border setResaltardebito_mone_localGeneraCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*GeneraCreditosBeanSwingJInternalFrame generacreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//generacreditosBeanSwingJInternalFrame.jTtoolBarGeneraCreditos.setBorder(borderResaltar);
		
		this.resaltardebito_mone_localGeneraCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardebito_mone_localGeneraCreditos() {
		return this.resaltardebito_mone_localGeneraCreditos;
	}

	public void setResaltardebito_mone_localGeneraCreditos(Border borderResaltar) {
		this.resaltardebito_mone_localGeneraCreditos= borderResaltar;
	}

	public Boolean getMostrardebito_mone_localGeneraCreditos() {
		return this.mostrardebito_mone_localGeneraCreditos;
	}

	public void setMostrardebito_mone_localGeneraCreditos(Boolean mostrardebito_mone_localGeneraCreditos) {
		this.mostrardebito_mone_localGeneraCreditos= mostrardebito_mone_localGeneraCreditos;
	}

	public Boolean getActivardebito_mone_localGeneraCreditos() {
		return this.activardebito_mone_localGeneraCreditos;
	}

	public void setActivardebito_mone_localGeneraCreditos(Boolean activardebito_mone_localGeneraCreditos) {
		this.activardebito_mone_localGeneraCreditos= activardebito_mone_localGeneraCreditos;
	}

	public Border setResaltarcredito_mone_localGeneraCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*GeneraCreditosBeanSwingJInternalFrame generacreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//generacreditosBeanSwingJInternalFrame.jTtoolBarGeneraCreditos.setBorder(borderResaltar);
		
		this.resaltarcredito_mone_localGeneraCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcredito_mone_localGeneraCreditos() {
		return this.resaltarcredito_mone_localGeneraCreditos;
	}

	public void setResaltarcredito_mone_localGeneraCreditos(Border borderResaltar) {
		this.resaltarcredito_mone_localGeneraCreditos= borderResaltar;
	}

	public Boolean getMostrarcredito_mone_localGeneraCreditos() {
		return this.mostrarcredito_mone_localGeneraCreditos;
	}

	public void setMostrarcredito_mone_localGeneraCreditos(Boolean mostrarcredito_mone_localGeneraCreditos) {
		this.mostrarcredito_mone_localGeneraCreditos= mostrarcredito_mone_localGeneraCreditos;
	}

	public Boolean getActivarcredito_mone_localGeneraCreditos() {
		return this.activarcredito_mone_localGeneraCreditos;
	}

	public void setActivarcredito_mone_localGeneraCreditos(Boolean activarcredito_mone_localGeneraCreditos) {
		this.activarcredito_mone_localGeneraCreditos= activarcredito_mone_localGeneraCreditos;
	}

	public Border setResaltarsaldoGeneraCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*GeneraCreditosBeanSwingJInternalFrame generacreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//generacreditosBeanSwingJInternalFrame.jTtoolBarGeneraCreditos.setBorder(borderResaltar);
		
		this.resaltarsaldoGeneraCreditos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsaldoGeneraCreditos() {
		return this.resaltarsaldoGeneraCreditos;
	}

	public void setResaltarsaldoGeneraCreditos(Border borderResaltar) {
		this.resaltarsaldoGeneraCreditos= borderResaltar;
	}

	public Boolean getMostrarsaldoGeneraCreditos() {
		return this.mostrarsaldoGeneraCreditos;
	}

	public void setMostrarsaldoGeneraCreditos(Boolean mostrarsaldoGeneraCreditos) {
		this.mostrarsaldoGeneraCreditos= mostrarsaldoGeneraCreditos;
	}

	public Boolean getActivarsaldoGeneraCreditos() {
		return this.activarsaldoGeneraCreditos;
	}

	public void setActivarsaldoGeneraCreditos(Boolean activarsaldoGeneraCreditos) {
		this.activarsaldoGeneraCreditos= activarsaldoGeneraCreditos;
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
		
		
		this.setMostraridGeneraCreditos(esInicial);
		this.setMostrarid_empresaGeneraCreditos(esInicial);
		this.setMostrarcodigoGeneraCreditos(esInicial);
		this.setMostrarnombre_completoGeneraCreditos(esInicial);
		this.setMostrarfecha_venceGeneraCreditos(esInicial);
		this.setMostrarfecha_emisionGeneraCreditos(esInicial);
		this.setMostrarnumero_facturaGeneraCreditos(esInicial);
		this.setMostrardebito_mone_localGeneraCreditos(esInicial);
		this.setMostrarcredito_mone_localGeneraCreditos(esInicial);
		this.setMostrarsaldoGeneraCreditos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.ID)) {
				this.setMostraridGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.FECHAVENCE)) {
				this.setMostrarfecha_venceGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.FECHAEMISION)) {
				this.setMostrarfecha_emisionGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.NUMEROFACTURA)) {
				this.setMostrarnumero_facturaGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.DEBITOMONELOCAL)) {
				this.setMostrardebito_mone_localGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.CREDITOMONELOCAL)) {
				this.setMostrarcredito_mone_localGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.SALDO)) {
				this.setMostrarsaldoGeneraCreditos(esAsigna);
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
		
		
		this.setActivaridGeneraCreditos(esInicial);
		this.setActivarid_empresaGeneraCreditos(esInicial);
		this.setActivarcodigoGeneraCreditos(esInicial);
		this.setActivarnombre_completoGeneraCreditos(esInicial);
		this.setActivarfecha_venceGeneraCreditos(esInicial);
		this.setActivarfecha_emisionGeneraCreditos(esInicial);
		this.setActivarnumero_facturaGeneraCreditos(esInicial);
		this.setActivardebito_mone_localGeneraCreditos(esInicial);
		this.setActivarcredito_mone_localGeneraCreditos(esInicial);
		this.setActivarsaldoGeneraCreditos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.ID)) {
				this.setActivaridGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.FECHAVENCE)) {
				this.setActivarfecha_venceGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.FECHAEMISION)) {
				this.setActivarfecha_emisionGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.NUMEROFACTURA)) {
				this.setActivarnumero_facturaGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.DEBITOMONELOCAL)) {
				this.setActivardebito_mone_localGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.CREDITOMONELOCAL)) {
				this.setActivarcredito_mone_localGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.SALDO)) {
				this.setActivarsaldoGeneraCreditos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,GeneraCreditosBeanSwingJInternalFrame generacreditosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridGeneraCreditos(esInicial);
		this.setResaltarid_empresaGeneraCreditos(esInicial);
		this.setResaltarcodigoGeneraCreditos(esInicial);
		this.setResaltarnombre_completoGeneraCreditos(esInicial);
		this.setResaltarfecha_venceGeneraCreditos(esInicial);
		this.setResaltarfecha_emisionGeneraCreditos(esInicial);
		this.setResaltarnumero_facturaGeneraCreditos(esInicial);
		this.setResaltardebito_mone_localGeneraCreditos(esInicial);
		this.setResaltarcredito_mone_localGeneraCreditos(esInicial);
		this.setResaltarsaldoGeneraCreditos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.ID)) {
				this.setResaltaridGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.FECHAVENCE)) {
				this.setResaltarfecha_venceGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.FECHAEMISION)) {
				this.setResaltarfecha_emisionGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.NUMEROFACTURA)) {
				this.setResaltarnumero_facturaGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.DEBITOMONELOCAL)) {
				this.setResaltardebito_mone_localGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.CREDITOMONELOCAL)) {
				this.setResaltarcredito_mone_localGeneraCreditos(esAsigna);
				continue;
			}

			if(campo.clase.equals(GeneraCreditosConstantesFunciones.SALDO)) {
				this.setResaltarsaldoGeneraCreditos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,GeneraCreditosBeanSwingJInternalFrame generacreditosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaGeneraCreditosGeneraCreditos=true;

	public Boolean getMostrarBusquedaGeneraCreditosGeneraCreditos() {
		return this.mostrarBusquedaGeneraCreditosGeneraCreditos;
	}

	public void setMostrarBusquedaGeneraCreditosGeneraCreditos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaGeneraCreditosGeneraCreditos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaGeneraCreditosGeneraCreditos=true;

	public Boolean getActivarBusquedaGeneraCreditosGeneraCreditos() {
		return this.activarBusquedaGeneraCreditosGeneraCreditos;
	}

	public void setActivarBusquedaGeneraCreditosGeneraCreditos(Boolean habilitarResaltar) {
		this.activarBusquedaGeneraCreditosGeneraCreditos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaGeneraCreditosGeneraCreditos=null;

	public Border getResaltarBusquedaGeneraCreditosGeneraCreditos() {
		return this.resaltarBusquedaGeneraCreditosGeneraCreditos;
	}

	public void setResaltarBusquedaGeneraCreditosGeneraCreditos(Border borderResaltar) {
		this.resaltarBusquedaGeneraCreditosGeneraCreditos= borderResaltar;
	}

	public void setResaltarBusquedaGeneraCreditosGeneraCreditos(ParametroGeneralUsuario parametroGeneralUsuario/*GeneraCreditosBeanSwingJInternalFrame generacreditosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaGeneraCreditosGeneraCreditos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}