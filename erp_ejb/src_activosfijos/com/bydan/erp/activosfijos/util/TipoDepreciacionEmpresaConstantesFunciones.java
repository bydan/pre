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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.TipoDepreciacionEmpresaConstantesFunciones;
import com.bydan.erp.activosfijos.util.TipoDepreciacionEmpresaParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.TipoDepreciacionEmpresaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoDepreciacionEmpresaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDepreciacionEmpresa";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDepreciacionEmpresa"+TipoDepreciacionEmpresaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDepreciacionEmpresaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDepreciacionEmpresaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"_"+TipoDepreciacionEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDepreciacionEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"_"+TipoDepreciacionEmpresaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"_"+TipoDepreciacionEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDepreciacionEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"_"+TipoDepreciacionEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDepreciacionEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDepreciacionEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDepreciacionEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDepreciacionEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDepreciacionEmpresaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDepreciacionEmpresaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDepreciacionEmpresaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDepreciacionEmpresaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDepreciacionEmpresaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDepreciacionEmpresaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Depreciacion Empresaes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Depreciacion Empresa";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Depreciacion Empresa";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDepreciacionEmpresa";
	public static final String OBJECTNAME="tipodepreciacionempresa";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="tipo_depreciacion_empresa";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodepreciacionempresa from "+TipoDepreciacionEmpresaConstantesFunciones.SPERSISTENCENAME+" tipodepreciacionempresa";
	public static String QUERYSELECTNATIVE="select "+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".id,"+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".version_row,"+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".id_empresa,"+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".codigo,"+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".nombre,"+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".es_linea_recta,"+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME+".es_mensual from "+TipoDepreciacionEmpresaConstantesFunciones.SCHEMA+"."+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME;//+" as "+TipoDepreciacionEmpresaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String ESLINEARECTA= "es_linea_recta";
    public static final String ESMENSUAL= "es_mensual";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_ESLINEARECTA= "Es Linea Recta";
		public static final String LABEL_ESLINEARECTA_LOWER= "Es Linea Recta";
    	public static final String LABEL_ESMENSUAL= "Es Mensual";
		public static final String LABEL_ESMENSUAL_LOWER= "Es Mensual";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getTipoDepreciacionEmpresaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDepreciacionEmpresaConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoDepreciacionEmpresaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoDepreciacionEmpresaConstantesFunciones.CODIGO)) {sLabelColumna=TipoDepreciacionEmpresaConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoDepreciacionEmpresaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDepreciacionEmpresaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoDepreciacionEmpresaConstantesFunciones.ESLINEARECTA)) {sLabelColumna=TipoDepreciacionEmpresaConstantesFunciones.LABEL_ESLINEARECTA;}
		if(sNombreColumna.equals(TipoDepreciacionEmpresaConstantesFunciones.ESMENSUAL)) {sLabelColumna=TipoDepreciacionEmpresaConstantesFunciones.LABEL_ESMENSUAL;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getes_linea_rectaDescripcion(TipoDepreciacionEmpresa tipodepreciacionempresa) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipodepreciacionempresa.getes_linea_recta()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_linea_rectaHtmlDescripcion(TipoDepreciacionEmpresa tipodepreciacionempresa) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipodepreciacionempresa.getId(),tipodepreciacionempresa.getes_linea_recta());

		return sDescripcion;
	}	
		
	public static String getes_mensualDescripcion(TipoDepreciacionEmpresa tipodepreciacionempresa) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tipodepreciacionempresa.getes_mensual()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_mensualHtmlDescripcion(TipoDepreciacionEmpresa tipodepreciacionempresa) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tipodepreciacionempresa.getId(),tipodepreciacionempresa.getes_mensual());

		return sDescripcion;
	}	
	
	public static String getTipoDepreciacionEmpresaDescripcion(TipoDepreciacionEmpresa tipodepreciacionempresa) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodepreciacionempresa !=null/* && tipodepreciacionempresa.getId()!=0*/) {
			sDescripcion=tipodepreciacionempresa.getcodigo();//tipodepreciacionempresatipodepreciacionempresa.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDepreciacionEmpresaDescripcionDetallado(TipoDepreciacionEmpresa tipodepreciacionempresa) {
		String sDescripcion="";
			
		sDescripcion+=TipoDepreciacionEmpresaConstantesFunciones.ID+"=";
		sDescripcion+=tipodepreciacionempresa.getId().toString()+",";
		sDescripcion+=TipoDepreciacionEmpresaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodepreciacionempresa.getVersionRow().toString()+",";
		sDescripcion+=TipoDepreciacionEmpresaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipodepreciacionempresa.getid_empresa().toString()+",";
		sDescripcion+=TipoDepreciacionEmpresaConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipodepreciacionempresa.getcodigo()+",";
		sDescripcion+=TipoDepreciacionEmpresaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodepreciacionempresa.getnombre()+",";
		sDescripcion+=TipoDepreciacionEmpresaConstantesFunciones.ESLINEARECTA+"=";
		sDescripcion+=tipodepreciacionempresa.getes_linea_recta().toString()+",";
		sDescripcion+=TipoDepreciacionEmpresaConstantesFunciones.ESMENSUAL+"=";
		sDescripcion+=tipodepreciacionempresa.getes_mensual().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDepreciacionEmpresaDescripcion(TipoDepreciacionEmpresa tipodepreciacionempresa,String sValor) throws Exception {			
		if(tipodepreciacionempresa !=null) {
			tipodepreciacionempresa.setcodigo(sValor);;//tipodepreciacionempresatipodepreciacionempresa.getcodigo().trim();
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
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoDepreciacionEmpresa(TipoDepreciacionEmpresa tipodepreciacionempresa,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodepreciacionempresa.setcodigo(tipodepreciacionempresa.getcodigo().trim());
		tipodepreciacionempresa.setnombre(tipodepreciacionempresa.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDepreciacionEmpresas(List<TipoDepreciacionEmpresa> tipodepreciacionempresas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDepreciacionEmpresa tipodepreciacionempresa: tipodepreciacionempresas) {
			tipodepreciacionempresa.setcodigo(tipodepreciacionempresa.getcodigo().trim());
			tipodepreciacionempresa.setnombre(tipodepreciacionempresa.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDepreciacionEmpresa(TipoDepreciacionEmpresa tipodepreciacionempresa,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodepreciacionempresa.getConCambioAuxiliar()) {
			tipodepreciacionempresa.setIsDeleted(tipodepreciacionempresa.getIsDeletedAuxiliar());	
			tipodepreciacionempresa.setIsNew(tipodepreciacionempresa.getIsNewAuxiliar());	
			tipodepreciacionempresa.setIsChanged(tipodepreciacionempresa.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodepreciacionempresa.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodepreciacionempresa.setIsDeletedAuxiliar(false);	
			tipodepreciacionempresa.setIsNewAuxiliar(false);	
			tipodepreciacionempresa.setIsChangedAuxiliar(false);
			
			tipodepreciacionempresa.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDepreciacionEmpresas(List<TipoDepreciacionEmpresa> tipodepreciacionempresas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDepreciacionEmpresa tipodepreciacionempresa : tipodepreciacionempresas) {
			if(conAsignarBase && tipodepreciacionempresa.getConCambioAuxiliar()) {
				tipodepreciacionempresa.setIsDeleted(tipodepreciacionempresa.getIsDeletedAuxiliar());	
				tipodepreciacionempresa.setIsNew(tipodepreciacionempresa.getIsNewAuxiliar());	
				tipodepreciacionempresa.setIsChanged(tipodepreciacionempresa.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodepreciacionempresa.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodepreciacionempresa.setIsDeletedAuxiliar(false);	
				tipodepreciacionempresa.setIsNewAuxiliar(false);	
				tipodepreciacionempresa.setIsChangedAuxiliar(false);
				
				tipodepreciacionempresa.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDepreciacionEmpresa(TipoDepreciacionEmpresa tipodepreciacionempresa,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDepreciacionEmpresas(List<TipoDepreciacionEmpresa> tipodepreciacionempresas,Boolean conEnteros) throws Exception  {
		
		for(TipoDepreciacionEmpresa tipodepreciacionempresa: tipodepreciacionempresas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDepreciacionEmpresa(List<TipoDepreciacionEmpresa> tipodepreciacionempresas,TipoDepreciacionEmpresa tipodepreciacionempresaAux) throws Exception  {
		TipoDepreciacionEmpresaConstantesFunciones.InicializarValoresTipoDepreciacionEmpresa(tipodepreciacionempresaAux,true);
		
		for(TipoDepreciacionEmpresa tipodepreciacionempresa: tipodepreciacionempresas) {
			if(tipodepreciacionempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDepreciacionEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDepreciacionEmpresaConstantesFunciones.getArrayColumnasGlobalesTipoDepreciacionEmpresa(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDepreciacionEmpresa(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoDepreciacionEmpresaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoDepreciacionEmpresaConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDepreciacionEmpresa(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDepreciacionEmpresa> tipodepreciacionempresas,TipoDepreciacionEmpresa tipodepreciacionempresa,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDepreciacionEmpresa tipodepreciacionempresaAux: tipodepreciacionempresas) {
			if(tipodepreciacionempresaAux!=null && tipodepreciacionempresa!=null) {
				if((tipodepreciacionempresaAux.getId()==null && tipodepreciacionempresa.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodepreciacionempresaAux.getId()!=null && tipodepreciacionempresa.getId()!=null){
					if(tipodepreciacionempresaAux.getId().equals(tipodepreciacionempresa.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDepreciacionEmpresa(List<TipoDepreciacionEmpresa> tipodepreciacionempresas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoDepreciacionEmpresa tipodepreciacionempresa: tipodepreciacionempresas) {			
			if(tipodepreciacionempresa.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDepreciacionEmpresa() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDepreciacionEmpresaConstantesFunciones.LABEL_ID, TipoDepreciacionEmpresaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDepreciacionEmpresaConstantesFunciones.LABEL_VERSIONROW, TipoDepreciacionEmpresaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDepreciacionEmpresaConstantesFunciones.LABEL_IDEMPRESA, TipoDepreciacionEmpresaConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDepreciacionEmpresaConstantesFunciones.LABEL_CODIGO, TipoDepreciacionEmpresaConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDepreciacionEmpresaConstantesFunciones.LABEL_NOMBRE, TipoDepreciacionEmpresaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDepreciacionEmpresaConstantesFunciones.LABEL_ESLINEARECTA, TipoDepreciacionEmpresaConstantesFunciones.ESLINEARECTA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDepreciacionEmpresaConstantesFunciones.LABEL_ESMENSUAL, TipoDepreciacionEmpresaConstantesFunciones.ESMENSUAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDepreciacionEmpresa() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDepreciacionEmpresaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDepreciacionEmpresaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDepreciacionEmpresaConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDepreciacionEmpresaConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDepreciacionEmpresaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDepreciacionEmpresaConstantesFunciones.ESLINEARECTA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDepreciacionEmpresaConstantesFunciones.ESMENSUAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDepreciacionEmpresa() throws Exception  {
		return TipoDepreciacionEmpresaConstantesFunciones.getTiposSeleccionarTipoDepreciacionEmpresa(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDepreciacionEmpresa(Boolean conFk) throws Exception  {
		return TipoDepreciacionEmpresaConstantesFunciones.getTiposSeleccionarTipoDepreciacionEmpresa(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDepreciacionEmpresa(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDepreciacionEmpresaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoDepreciacionEmpresaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDepreciacionEmpresaConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoDepreciacionEmpresaConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDepreciacionEmpresaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDepreciacionEmpresaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDepreciacionEmpresaConstantesFunciones.LABEL_ESLINEARECTA);
			reporte.setsDescripcion(TipoDepreciacionEmpresaConstantesFunciones.LABEL_ESLINEARECTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDepreciacionEmpresaConstantesFunciones.LABEL_ESMENSUAL);
			reporte.setsDescripcion(TipoDepreciacionEmpresaConstantesFunciones.LABEL_ESMENSUAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDepreciacionEmpresa(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(TipoDepreciacionEmpresa tipodepreciacionempresaAux) throws Exception {
		
			tipodepreciacionempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodepreciacionempresaAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDepreciacionEmpresa(List<TipoDepreciacionEmpresa> tipodepreciacionempresasTemp) throws Exception {
		for(TipoDepreciacionEmpresa tipodepreciacionempresaAux:tipodepreciacionempresasTemp) {
			
			tipodepreciacionempresaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodepreciacionempresaAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDepreciacionEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDepreciacionEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDepreciacionEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDepreciacionEmpresaConstantesFunciones.getClassesRelationshipsOfTipoDepreciacionEmpresa(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDepreciacionEmpresa(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleActivoFijo.class));
				classes.add(new Classe(DepreciacionActivoFijo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DepreciacionActivoFijo.class)) {
						classes.add(new Classe(DepreciacionActivoFijo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDepreciacionEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDepreciacionEmpresaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDepreciacionEmpresa(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDepreciacionEmpresa(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(DepreciacionActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DepreciacionActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(DepreciacionActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DepreciacionActivoFijo.class)); continue;
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
	public static void actualizarLista(TipoDepreciacionEmpresa tipodepreciacionempresa,List<TipoDepreciacionEmpresa> tipodepreciacionempresas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDepreciacionEmpresa tipodepreciacionempresaEncontrado=null;
			
			for(TipoDepreciacionEmpresa tipodepreciacionempresaLocal:tipodepreciacionempresas) {
				if(tipodepreciacionempresaLocal.getId().equals(tipodepreciacionempresa.getId())) {
					tipodepreciacionempresaEncontrado=tipodepreciacionempresaLocal;
					
					tipodepreciacionempresaLocal.setIsChanged(tipodepreciacionempresa.getIsChanged());
					tipodepreciacionempresaLocal.setIsNew(tipodepreciacionempresa.getIsNew());
					tipodepreciacionempresaLocal.setIsDeleted(tipodepreciacionempresa.getIsDeleted());
					
					tipodepreciacionempresaLocal.setGeneralEntityOriginal(tipodepreciacionempresa.getGeneralEntityOriginal());
					
					tipodepreciacionempresaLocal.setId(tipodepreciacionempresa.getId());	
					tipodepreciacionempresaLocal.setVersionRow(tipodepreciacionempresa.getVersionRow());	
					tipodepreciacionempresaLocal.setid_empresa(tipodepreciacionempresa.getid_empresa());	
					tipodepreciacionempresaLocal.setcodigo(tipodepreciacionempresa.getcodigo());	
					tipodepreciacionempresaLocal.setnombre(tipodepreciacionempresa.getnombre());	
					tipodepreciacionempresaLocal.setes_linea_recta(tipodepreciacionempresa.getes_linea_recta());	
					tipodepreciacionempresaLocal.setes_mensual(tipodepreciacionempresa.getes_mensual());	
					
					
					tipodepreciacionempresaLocal.setDetalleActivoFijos(tipodepreciacionempresa.getDetalleActivoFijos());
					tipodepreciacionempresaLocal.setDepreciacionActivoFijos(tipodepreciacionempresa.getDepreciacionActivoFijos());
					
					existe=true;
					break;
				}
			}
			
			if(!tipodepreciacionempresa.getIsDeleted()) {
				if(!existe) {
					tipodepreciacionempresas.add(tipodepreciacionempresa);
				}
			} else {
				if(tipodepreciacionempresaEncontrado!=null && permiteQuitar)  {
					tipodepreciacionempresas.remove(tipodepreciacionempresaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDepreciacionEmpresa tipodepreciacionempresa,List<TipoDepreciacionEmpresa> tipodepreciacionempresas) throws Exception {
		try	{			
			for(TipoDepreciacionEmpresa tipodepreciacionempresaLocal:tipodepreciacionempresas) {
				if(tipodepreciacionempresaLocal.getId().equals(tipodepreciacionempresa.getId())) {
					tipodepreciacionempresaLocal.setIsSelected(tipodepreciacionempresa.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDepreciacionEmpresa(List<TipoDepreciacionEmpresa> tipodepreciacionempresasAux) throws Exception {
		//this.tipodepreciacionempresasAux=tipodepreciacionempresasAux;
		
		for(TipoDepreciacionEmpresa tipodepreciacionempresaAux:tipodepreciacionempresasAux) {
			if(tipodepreciacionempresaAux.getIsChanged()) {
				tipodepreciacionempresaAux.setIsChanged(false);
			}		
			
			if(tipodepreciacionempresaAux.getIsNew()) {
				tipodepreciacionempresaAux.setIsNew(false);
			}	
			
			if(tipodepreciacionempresaAux.getIsDeleted()) {
				tipodepreciacionempresaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDepreciacionEmpresa(TipoDepreciacionEmpresa tipodepreciacionempresaAux) throws Exception {
		//this.tipodepreciacionempresaAux=tipodepreciacionempresaAux;
		
			if(tipodepreciacionempresaAux.getIsChanged()) {
				tipodepreciacionempresaAux.setIsChanged(false);
			}		
			
			if(tipodepreciacionempresaAux.getIsNew()) {
				tipodepreciacionempresaAux.setIsNew(false);
			}	
			
			if(tipodepreciacionempresaAux.getIsDeleted()) {
				tipodepreciacionempresaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDepreciacionEmpresa tipodepreciacionempresaAsignar,TipoDepreciacionEmpresa tipodepreciacionempresa) throws Exception {
		tipodepreciacionempresaAsignar.setId(tipodepreciacionempresa.getId());	
		tipodepreciacionempresaAsignar.setVersionRow(tipodepreciacionempresa.getVersionRow());	
		tipodepreciacionempresaAsignar.setid_empresa(tipodepreciacionempresa.getid_empresa());
		tipodepreciacionempresaAsignar.setempresa_descripcion(tipodepreciacionempresa.getempresa_descripcion());	
		tipodepreciacionempresaAsignar.setcodigo(tipodepreciacionempresa.getcodigo());	
		tipodepreciacionempresaAsignar.setnombre(tipodepreciacionempresa.getnombre());	
		tipodepreciacionempresaAsignar.setes_linea_recta(tipodepreciacionempresa.getes_linea_recta());	
		tipodepreciacionempresaAsignar.setes_mensual(tipodepreciacionempresa.getes_mensual());	
	}
	
	public static void inicializarTipoDepreciacionEmpresa(TipoDepreciacionEmpresa tipodepreciacionempresa) throws Exception {
		try {
				tipodepreciacionempresa.setId(0L);	
					
				tipodepreciacionempresa.setid_empresa(-1L);	
				tipodepreciacionempresa.setcodigo("");	
				tipodepreciacionempresa.setnombre("");	
				tipodepreciacionempresa.setes_linea_recta(false);	
				tipodepreciacionempresa.setes_mensual(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDepreciacionEmpresa(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDepreciacionEmpresaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDepreciacionEmpresaConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDepreciacionEmpresaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDepreciacionEmpresaConstantesFunciones.LABEL_ESLINEARECTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDepreciacionEmpresaConstantesFunciones.LABEL_ESMENSUAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDepreciacionEmpresa(String sTipo,Row row,Workbook workbook,TipoDepreciacionEmpresa tipodepreciacionempresa,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodepreciacionempresa.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodepreciacionempresa.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodepreciacionempresa.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipodepreciacionempresa.getes_linea_recta()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tipodepreciacionempresa.getes_mensual()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDepreciacionEmpresa=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDepreciacionEmpresa() {
		return this.sFinalQueryTipoDepreciacionEmpresa;
	}
	
	public void setsFinalQueryTipoDepreciacionEmpresa(String sFinalQueryTipoDepreciacionEmpresa) {
		this.sFinalQueryTipoDepreciacionEmpresa= sFinalQueryTipoDepreciacionEmpresa;
	}
	
	public Border resaltarSeleccionarTipoDepreciacionEmpresa=null;
	
	public Border setResaltarSeleccionarTipoDepreciacionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDepreciacionEmpresaBeanSwingJInternalFrame tipodepreciacionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodepreciacionempresaBeanSwingJInternalFrame.jTtoolBarTipoDepreciacionEmpresa.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDepreciacionEmpresa= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDepreciacionEmpresa() {
		return this.resaltarSeleccionarTipoDepreciacionEmpresa;
	}
	
	public void setResaltarSeleccionarTipoDepreciacionEmpresa(Border borderResaltarSeleccionarTipoDepreciacionEmpresa) {
		this.resaltarSeleccionarTipoDepreciacionEmpresa= borderResaltarSeleccionarTipoDepreciacionEmpresa;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDepreciacionEmpresa=null;
	public Boolean mostraridTipoDepreciacionEmpresa=true;
	public Boolean activaridTipoDepreciacionEmpresa=true;

	public Border resaltarid_empresaTipoDepreciacionEmpresa=null;
	public Boolean mostrarid_empresaTipoDepreciacionEmpresa=true;
	public Boolean activarid_empresaTipoDepreciacionEmpresa=true;
	public Boolean cargarid_empresaTipoDepreciacionEmpresa=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoDepreciacionEmpresa=false;//ConEventDepend=true

	public Border resaltarcodigoTipoDepreciacionEmpresa=null;
	public Boolean mostrarcodigoTipoDepreciacionEmpresa=true;
	public Boolean activarcodigoTipoDepreciacionEmpresa=true;

	public Border resaltarnombreTipoDepreciacionEmpresa=null;
	public Boolean mostrarnombreTipoDepreciacionEmpresa=true;
	public Boolean activarnombreTipoDepreciacionEmpresa=true;

	public Border resaltares_linea_rectaTipoDepreciacionEmpresa=null;
	public Boolean mostrares_linea_rectaTipoDepreciacionEmpresa=true;
	public Boolean activares_linea_rectaTipoDepreciacionEmpresa=true;

	public Border resaltares_mensualTipoDepreciacionEmpresa=null;
	public Boolean mostrares_mensualTipoDepreciacionEmpresa=true;
	public Boolean activares_mensualTipoDepreciacionEmpresa=true;

	
	

	public Border setResaltaridTipoDepreciacionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDepreciacionEmpresaBeanSwingJInternalFrame tipodepreciacionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodepreciacionempresaBeanSwingJInternalFrame.jTtoolBarTipoDepreciacionEmpresa.setBorder(borderResaltar);
		
		this.resaltaridTipoDepreciacionEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDepreciacionEmpresa() {
		return this.resaltaridTipoDepreciacionEmpresa;
	}

	public void setResaltaridTipoDepreciacionEmpresa(Border borderResaltar) {
		this.resaltaridTipoDepreciacionEmpresa= borderResaltar;
	}

	public Boolean getMostraridTipoDepreciacionEmpresa() {
		return this.mostraridTipoDepreciacionEmpresa;
	}

	public void setMostraridTipoDepreciacionEmpresa(Boolean mostraridTipoDepreciacionEmpresa) {
		this.mostraridTipoDepreciacionEmpresa= mostraridTipoDepreciacionEmpresa;
	}

	public Boolean getActivaridTipoDepreciacionEmpresa() {
		return this.activaridTipoDepreciacionEmpresa;
	}

	public void setActivaridTipoDepreciacionEmpresa(Boolean activaridTipoDepreciacionEmpresa) {
		this.activaridTipoDepreciacionEmpresa= activaridTipoDepreciacionEmpresa;
	}

	public Border setResaltarid_empresaTipoDepreciacionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDepreciacionEmpresaBeanSwingJInternalFrame tipodepreciacionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodepreciacionempresaBeanSwingJInternalFrame.jTtoolBarTipoDepreciacionEmpresa.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoDepreciacionEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoDepreciacionEmpresa() {
		return this.resaltarid_empresaTipoDepreciacionEmpresa;
	}

	public void setResaltarid_empresaTipoDepreciacionEmpresa(Border borderResaltar) {
		this.resaltarid_empresaTipoDepreciacionEmpresa= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoDepreciacionEmpresa() {
		return this.mostrarid_empresaTipoDepreciacionEmpresa;
	}

	public void setMostrarid_empresaTipoDepreciacionEmpresa(Boolean mostrarid_empresaTipoDepreciacionEmpresa) {
		this.mostrarid_empresaTipoDepreciacionEmpresa= mostrarid_empresaTipoDepreciacionEmpresa;
	}

	public Boolean getActivarid_empresaTipoDepreciacionEmpresa() {
		return this.activarid_empresaTipoDepreciacionEmpresa;
	}

	public void setActivarid_empresaTipoDepreciacionEmpresa(Boolean activarid_empresaTipoDepreciacionEmpresa) {
		this.activarid_empresaTipoDepreciacionEmpresa= activarid_empresaTipoDepreciacionEmpresa;
	}

	public Boolean getCargarid_empresaTipoDepreciacionEmpresa() {
		return this.cargarid_empresaTipoDepreciacionEmpresa;
	}

	public void setCargarid_empresaTipoDepreciacionEmpresa(Boolean cargarid_empresaTipoDepreciacionEmpresa) {
		this.cargarid_empresaTipoDepreciacionEmpresa= cargarid_empresaTipoDepreciacionEmpresa;
	}

	public Border setResaltarcodigoTipoDepreciacionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDepreciacionEmpresaBeanSwingJInternalFrame tipodepreciacionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodepreciacionempresaBeanSwingJInternalFrame.jTtoolBarTipoDepreciacionEmpresa.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoDepreciacionEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoDepreciacionEmpresa() {
		return this.resaltarcodigoTipoDepreciacionEmpresa;
	}

	public void setResaltarcodigoTipoDepreciacionEmpresa(Border borderResaltar) {
		this.resaltarcodigoTipoDepreciacionEmpresa= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoDepreciacionEmpresa() {
		return this.mostrarcodigoTipoDepreciacionEmpresa;
	}

	public void setMostrarcodigoTipoDepreciacionEmpresa(Boolean mostrarcodigoTipoDepreciacionEmpresa) {
		this.mostrarcodigoTipoDepreciacionEmpresa= mostrarcodigoTipoDepreciacionEmpresa;
	}

	public Boolean getActivarcodigoTipoDepreciacionEmpresa() {
		return this.activarcodigoTipoDepreciacionEmpresa;
	}

	public void setActivarcodigoTipoDepreciacionEmpresa(Boolean activarcodigoTipoDepreciacionEmpresa) {
		this.activarcodigoTipoDepreciacionEmpresa= activarcodigoTipoDepreciacionEmpresa;
	}

	public Border setResaltarnombreTipoDepreciacionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDepreciacionEmpresaBeanSwingJInternalFrame tipodepreciacionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodepreciacionempresaBeanSwingJInternalFrame.jTtoolBarTipoDepreciacionEmpresa.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDepreciacionEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDepreciacionEmpresa() {
		return this.resaltarnombreTipoDepreciacionEmpresa;
	}

	public void setResaltarnombreTipoDepreciacionEmpresa(Border borderResaltar) {
		this.resaltarnombreTipoDepreciacionEmpresa= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDepreciacionEmpresa() {
		return this.mostrarnombreTipoDepreciacionEmpresa;
	}

	public void setMostrarnombreTipoDepreciacionEmpresa(Boolean mostrarnombreTipoDepreciacionEmpresa) {
		this.mostrarnombreTipoDepreciacionEmpresa= mostrarnombreTipoDepreciacionEmpresa;
	}

	public Boolean getActivarnombreTipoDepreciacionEmpresa() {
		return this.activarnombreTipoDepreciacionEmpresa;
	}

	public void setActivarnombreTipoDepreciacionEmpresa(Boolean activarnombreTipoDepreciacionEmpresa) {
		this.activarnombreTipoDepreciacionEmpresa= activarnombreTipoDepreciacionEmpresa;
	}

	public Border setResaltares_linea_rectaTipoDepreciacionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDepreciacionEmpresaBeanSwingJInternalFrame tipodepreciacionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodepreciacionempresaBeanSwingJInternalFrame.jTtoolBarTipoDepreciacionEmpresa.setBorder(borderResaltar);
		
		this.resaltares_linea_rectaTipoDepreciacionEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_linea_rectaTipoDepreciacionEmpresa() {
		return this.resaltares_linea_rectaTipoDepreciacionEmpresa;
	}

	public void setResaltares_linea_rectaTipoDepreciacionEmpresa(Border borderResaltar) {
		this.resaltares_linea_rectaTipoDepreciacionEmpresa= borderResaltar;
	}

	public Boolean getMostrares_linea_rectaTipoDepreciacionEmpresa() {
		return this.mostrares_linea_rectaTipoDepreciacionEmpresa;
	}

	public void setMostrares_linea_rectaTipoDepreciacionEmpresa(Boolean mostrares_linea_rectaTipoDepreciacionEmpresa) {
		this.mostrares_linea_rectaTipoDepreciacionEmpresa= mostrares_linea_rectaTipoDepreciacionEmpresa;
	}

	public Boolean getActivares_linea_rectaTipoDepreciacionEmpresa() {
		return this.activares_linea_rectaTipoDepreciacionEmpresa;
	}

	public void setActivares_linea_rectaTipoDepreciacionEmpresa(Boolean activares_linea_rectaTipoDepreciacionEmpresa) {
		this.activares_linea_rectaTipoDepreciacionEmpresa= activares_linea_rectaTipoDepreciacionEmpresa;
	}

	public Border setResaltares_mensualTipoDepreciacionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDepreciacionEmpresaBeanSwingJInternalFrame tipodepreciacionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodepreciacionempresaBeanSwingJInternalFrame.jTtoolBarTipoDepreciacionEmpresa.setBorder(borderResaltar);
		
		this.resaltares_mensualTipoDepreciacionEmpresa= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_mensualTipoDepreciacionEmpresa() {
		return this.resaltares_mensualTipoDepreciacionEmpresa;
	}

	public void setResaltares_mensualTipoDepreciacionEmpresa(Border borderResaltar) {
		this.resaltares_mensualTipoDepreciacionEmpresa= borderResaltar;
	}

	public Boolean getMostrares_mensualTipoDepreciacionEmpresa() {
		return this.mostrares_mensualTipoDepreciacionEmpresa;
	}

	public void setMostrares_mensualTipoDepreciacionEmpresa(Boolean mostrares_mensualTipoDepreciacionEmpresa) {
		this.mostrares_mensualTipoDepreciacionEmpresa= mostrares_mensualTipoDepreciacionEmpresa;
	}

	public Boolean getActivares_mensualTipoDepreciacionEmpresa() {
		return this.activares_mensualTipoDepreciacionEmpresa;
	}

	public void setActivares_mensualTipoDepreciacionEmpresa(Boolean activares_mensualTipoDepreciacionEmpresa) {
		this.activares_mensualTipoDepreciacionEmpresa= activares_mensualTipoDepreciacionEmpresa;
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
		
		
		this.setMostraridTipoDepreciacionEmpresa(esInicial);
		this.setMostrarid_empresaTipoDepreciacionEmpresa(esInicial);
		this.setMostrarcodigoTipoDepreciacionEmpresa(esInicial);
		this.setMostrarnombreTipoDepreciacionEmpresa(esInicial);
		this.setMostrares_linea_rectaTipoDepreciacionEmpresa(esInicial);
		this.setMostrares_mensualTipoDepreciacionEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.ID)) {
				this.setMostraridTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.ESLINEARECTA)) {
				this.setMostrares_linea_rectaTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.ESMENSUAL)) {
				this.setMostrares_mensualTipoDepreciacionEmpresa(esAsigna);
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
		
		
		this.setActivaridTipoDepreciacionEmpresa(esInicial);
		this.setActivarid_empresaTipoDepreciacionEmpresa(esInicial);
		this.setActivarcodigoTipoDepreciacionEmpresa(esInicial);
		this.setActivarnombreTipoDepreciacionEmpresa(esInicial);
		this.setActivares_linea_rectaTipoDepreciacionEmpresa(esInicial);
		this.setActivares_mensualTipoDepreciacionEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.ID)) {
				this.setActivaridTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.ESLINEARECTA)) {
				this.setActivares_linea_rectaTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.ESMENSUAL)) {
				this.setActivares_mensualTipoDepreciacionEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDepreciacionEmpresaBeanSwingJInternalFrame tipodepreciacionempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDepreciacionEmpresa(esInicial);
		this.setResaltarid_empresaTipoDepreciacionEmpresa(esInicial);
		this.setResaltarcodigoTipoDepreciacionEmpresa(esInicial);
		this.setResaltarnombreTipoDepreciacionEmpresa(esInicial);
		this.setResaltares_linea_rectaTipoDepreciacionEmpresa(esInicial);
		this.setResaltares_mensualTipoDepreciacionEmpresa(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.ID)) {
				this.setResaltaridTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.ESLINEARECTA)) {
				this.setResaltares_linea_rectaTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDepreciacionEmpresaConstantesFunciones.ESMENSUAL)) {
				this.setResaltares_mensualTipoDepreciacionEmpresa(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleActivoFijoTipoDepreciacionEmpresa=null;

	public Border getResaltarDetalleActivoFijoTipoDepreciacionEmpresa() {
		return this.resaltarDetalleActivoFijoTipoDepreciacionEmpresa;
	}

	public void setResaltarDetalleActivoFijoTipoDepreciacionEmpresa(Border borderResaltarDetalleActivoFijo) {
		if(borderResaltarDetalleActivoFijo!=null) {
			this.resaltarDetalleActivoFijoTipoDepreciacionEmpresa= borderResaltarDetalleActivoFijo;
		}
	}

	public Border setResaltarDetalleActivoFijoTipoDepreciacionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDepreciacionEmpresaBeanSwingJInternalFrame tipodepreciacionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipodepreciacionempresaBeanSwingJInternalFrame.jTtoolBarTipoDepreciacionEmpresa.setBorder(borderResaltarDetalleActivoFijo);
			
		this.resaltarDetalleActivoFijoTipoDepreciacionEmpresa= borderResaltarDetalleActivoFijo;

		 return borderResaltarDetalleActivoFijo;
	}



	public Boolean mostrarDetalleActivoFijoTipoDepreciacionEmpresa=true;

	public Boolean getMostrarDetalleActivoFijoTipoDepreciacionEmpresa() {
		return this.mostrarDetalleActivoFijoTipoDepreciacionEmpresa;
	}

	public void setMostrarDetalleActivoFijoTipoDepreciacionEmpresa(Boolean visibilidadResaltarDetalleActivoFijo) {
		this.mostrarDetalleActivoFijoTipoDepreciacionEmpresa= visibilidadResaltarDetalleActivoFijo;
	}



	public Boolean activarDetalleActivoFijoTipoDepreciacionEmpresa=true;

	public Boolean gethabilitarResaltarDetalleActivoFijoTipoDepreciacionEmpresa() {
		return this.activarDetalleActivoFijoTipoDepreciacionEmpresa;
	}

	public void setActivarDetalleActivoFijoTipoDepreciacionEmpresa(Boolean habilitarResaltarDetalleActivoFijo) {
		this.activarDetalleActivoFijoTipoDepreciacionEmpresa= habilitarResaltarDetalleActivoFijo;
	}


	public Border resaltarDepreciacionActivoFijoTipoDepreciacionEmpresa=null;

	public Border getResaltarDepreciacionActivoFijoTipoDepreciacionEmpresa() {
		return this.resaltarDepreciacionActivoFijoTipoDepreciacionEmpresa;
	}

	public void setResaltarDepreciacionActivoFijoTipoDepreciacionEmpresa(Border borderResaltarDepreciacionActivoFijo) {
		if(borderResaltarDepreciacionActivoFijo!=null) {
			this.resaltarDepreciacionActivoFijoTipoDepreciacionEmpresa= borderResaltarDepreciacionActivoFijo;
		}
	}

	public Border setResaltarDepreciacionActivoFijoTipoDepreciacionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDepreciacionEmpresaBeanSwingJInternalFrame tipodepreciacionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltarDepreciacionActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipodepreciacionempresaBeanSwingJInternalFrame.jTtoolBarTipoDepreciacionEmpresa.setBorder(borderResaltarDepreciacionActivoFijo);
			
		this.resaltarDepreciacionActivoFijoTipoDepreciacionEmpresa= borderResaltarDepreciacionActivoFijo;

		 return borderResaltarDepreciacionActivoFijo;
	}



	public Boolean mostrarDepreciacionActivoFijoTipoDepreciacionEmpresa=true;

	public Boolean getMostrarDepreciacionActivoFijoTipoDepreciacionEmpresa() {
		return this.mostrarDepreciacionActivoFijoTipoDepreciacionEmpresa;
	}

	public void setMostrarDepreciacionActivoFijoTipoDepreciacionEmpresa(Boolean visibilidadResaltarDepreciacionActivoFijo) {
		this.mostrarDepreciacionActivoFijoTipoDepreciacionEmpresa= visibilidadResaltarDepreciacionActivoFijo;
	}



	public Boolean activarDepreciacionActivoFijoTipoDepreciacionEmpresa=true;

	public Boolean gethabilitarResaltarDepreciacionActivoFijoTipoDepreciacionEmpresa() {
		return this.activarDepreciacionActivoFijoTipoDepreciacionEmpresa;
	}

	public void setActivarDepreciacionActivoFijoTipoDepreciacionEmpresa(Boolean habilitarResaltarDepreciacionActivoFijo) {
		this.activarDepreciacionActivoFijoTipoDepreciacionEmpresa= habilitarResaltarDepreciacionActivoFijo;
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

		this.setMostrarDetalleActivoFijoTipoDepreciacionEmpresa(esInicial);
		this.setMostrarDepreciacionActivoFijoTipoDepreciacionEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setMostrarDetalleActivoFijoTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(clase.clas.equals(DepreciacionActivoFijo.class)) {
				this.setMostrarDepreciacionActivoFijoTipoDepreciacionEmpresa(esAsigna);
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

		this.setActivarDetalleActivoFijoTipoDepreciacionEmpresa(esInicial);
		this.setActivarDepreciacionActivoFijoTipoDepreciacionEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setActivarDetalleActivoFijoTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(clase.clas.equals(DepreciacionActivoFijo.class)) {
				this.setActivarDepreciacionActivoFijoTipoDepreciacionEmpresa(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDepreciacionEmpresaBeanSwingJInternalFrame tipodepreciacionempresaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleActivoFijoTipoDepreciacionEmpresa(esInicial);
		this.setResaltarDepreciacionActivoFijoTipoDepreciacionEmpresa(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setResaltarDetalleActivoFijoTipoDepreciacionEmpresa(esAsigna);
				continue;
			}

			if(clase.clas.equals(DepreciacionActivoFijo.class)) {
				this.setResaltarDepreciacionActivoFijoTipoDepreciacionEmpresa(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoDepreciacionEmpresa=true;

	public Boolean getMostrarFK_IdEmpresaTipoDepreciacionEmpresa() {
		return this.mostrarFK_IdEmpresaTipoDepreciacionEmpresa;
	}

	public void setMostrarFK_IdEmpresaTipoDepreciacionEmpresa(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoDepreciacionEmpresa= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoDepreciacionEmpresa=true;

	public Boolean getActivarFK_IdEmpresaTipoDepreciacionEmpresa() {
		return this.activarFK_IdEmpresaTipoDepreciacionEmpresa;
	}

	public void setActivarFK_IdEmpresaTipoDepreciacionEmpresa(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoDepreciacionEmpresa= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoDepreciacionEmpresa=null;

	public Border getResaltarFK_IdEmpresaTipoDepreciacionEmpresa() {
		return this.resaltarFK_IdEmpresaTipoDepreciacionEmpresa;
	}

	public void setResaltarFK_IdEmpresaTipoDepreciacionEmpresa(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoDepreciacionEmpresa= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoDepreciacionEmpresa(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDepreciacionEmpresaBeanSwingJInternalFrame tipodepreciacionempresaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoDepreciacionEmpresa= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}