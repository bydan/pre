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
package com.bydan.erp.nomina.util;

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


import com.bydan.erp.nomina.util.TipoDiscapacidadConstantesFunciones;
import com.bydan.erp.nomina.util.TipoDiscapacidadParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoDiscapacidadParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.nomina.business.entity.*;



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
final public class TipoDiscapacidadConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDiscapacidad";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDiscapacidad"+TipoDiscapacidadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDiscapacidadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDiscapacidadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDiscapacidadConstantesFunciones.SCHEMA+"_"+TipoDiscapacidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDiscapacidadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDiscapacidadConstantesFunciones.SCHEMA+"_"+TipoDiscapacidadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDiscapacidadConstantesFunciones.SCHEMA+"_"+TipoDiscapacidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDiscapacidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDiscapacidadConstantesFunciones.SCHEMA+"_"+TipoDiscapacidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDiscapacidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDiscapacidadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDiscapacidadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDiscapacidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDiscapacidadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDiscapacidadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDiscapacidadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDiscapacidadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDiscapacidadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDiscapacidadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Discapacidades";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Discapacidad";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Discapacidad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDiscapacidad";
	public static final String OBJECTNAME="tipodiscapacidad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_discapacidad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodiscapacidad from "+TipoDiscapacidadConstantesFunciones.SPERSISTENCENAME+" tipodiscapacidad";
	public static String QUERYSELECTNATIVE="select "+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".id,"+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".version_row,"+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".id_empresa,"+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".nombre,"+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".porcentaje_inicial,"+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME+".porcentaje_final from "+TipoDiscapacidadConstantesFunciones.SCHEMA+"."+TipoDiscapacidadConstantesFunciones.TABLENAME;//+" as "+TipoDiscapacidadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
    public static final String PORCENTAJEINICIAL= "porcentaje_inicial";
    public static final String PORCENTAJEFINAL= "porcentaje_final";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_PORCENTAJEINICIAL= "Porcentaje Inicial";
		public static final String LABEL_PORCENTAJEINICIAL_LOWER= "Porcentaje Inicial";
    	public static final String LABEL_PORCENTAJEFINAL= "Porcentaje Final";
		public static final String LABEL_PORCENTAJEFINAL_LOWER= "Porcentaje Final";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getTipoDiscapacidadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDiscapacidadConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoDiscapacidadConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoDiscapacidadConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDiscapacidadConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoDiscapacidadConstantesFunciones.PORCENTAJEINICIAL)) {sLabelColumna=TipoDiscapacidadConstantesFunciones.LABEL_PORCENTAJEINICIAL;}
		if(sNombreColumna.equals(TipoDiscapacidadConstantesFunciones.PORCENTAJEFINAL)) {sLabelColumna=TipoDiscapacidadConstantesFunciones.LABEL_PORCENTAJEFINAL;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getTipoDiscapacidadDescripcion(TipoDiscapacidad tipodiscapacidad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodiscapacidad !=null/* && tipodiscapacidad.getId()!=0*/) {
			sDescripcion=tipodiscapacidad.getnombre();//tipodiscapacidadtipodiscapacidad.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDiscapacidadDescripcionDetallado(TipoDiscapacidad tipodiscapacidad) {
		String sDescripcion="";
			
		sDescripcion+=TipoDiscapacidadConstantesFunciones.ID+"=";
		sDescripcion+=tipodiscapacidad.getId().toString()+",";
		sDescripcion+=TipoDiscapacidadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodiscapacidad.getVersionRow().toString()+",";
		sDescripcion+=TipoDiscapacidadConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipodiscapacidad.getid_empresa().toString()+",";
		sDescripcion+=TipoDiscapacidadConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodiscapacidad.getnombre()+",";
		sDescripcion+=TipoDiscapacidadConstantesFunciones.PORCENTAJEINICIAL+"=";
		sDescripcion+=tipodiscapacidad.getporcentaje_inicial().toString()+",";
		sDescripcion+=TipoDiscapacidadConstantesFunciones.PORCENTAJEFINAL+"=";
		sDescripcion+=tipodiscapacidad.getporcentaje_final().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDiscapacidadDescripcion(TipoDiscapacidad tipodiscapacidad,String sValor) throws Exception {			
		if(tipodiscapacidad !=null) {
			tipodiscapacidad.setnombre(sValor);;//tipodiscapacidadtipodiscapacidad.getnombre().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoDiscapacidad(TipoDiscapacidad tipodiscapacidad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodiscapacidad.setnombre(tipodiscapacidad.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDiscapacidads(List<TipoDiscapacidad> tipodiscapacidads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDiscapacidad tipodiscapacidad: tipodiscapacidads) {
			tipodiscapacidad.setnombre(tipodiscapacidad.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDiscapacidad(TipoDiscapacidad tipodiscapacidad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodiscapacidad.getConCambioAuxiliar()) {
			tipodiscapacidad.setIsDeleted(tipodiscapacidad.getIsDeletedAuxiliar());	
			tipodiscapacidad.setIsNew(tipodiscapacidad.getIsNewAuxiliar());	
			tipodiscapacidad.setIsChanged(tipodiscapacidad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodiscapacidad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodiscapacidad.setIsDeletedAuxiliar(false);	
			tipodiscapacidad.setIsNewAuxiliar(false);	
			tipodiscapacidad.setIsChangedAuxiliar(false);
			
			tipodiscapacidad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDiscapacidads(List<TipoDiscapacidad> tipodiscapacidads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDiscapacidad tipodiscapacidad : tipodiscapacidads) {
			if(conAsignarBase && tipodiscapacidad.getConCambioAuxiliar()) {
				tipodiscapacidad.setIsDeleted(tipodiscapacidad.getIsDeletedAuxiliar());	
				tipodiscapacidad.setIsNew(tipodiscapacidad.getIsNewAuxiliar());	
				tipodiscapacidad.setIsChanged(tipodiscapacidad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodiscapacidad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodiscapacidad.setIsDeletedAuxiliar(false);	
				tipodiscapacidad.setIsNewAuxiliar(false);	
				tipodiscapacidad.setIsChangedAuxiliar(false);
				
				tipodiscapacidad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDiscapacidad(TipoDiscapacidad tipodiscapacidad,Boolean conEnteros) throws Exception  {
		tipodiscapacidad.setporcentaje_inicial(0.0);
		tipodiscapacidad.setporcentaje_final(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDiscapacidads(List<TipoDiscapacidad> tipodiscapacidads,Boolean conEnteros) throws Exception  {
		
		for(TipoDiscapacidad tipodiscapacidad: tipodiscapacidads) {
			tipodiscapacidad.setporcentaje_inicial(0.0);
			tipodiscapacidad.setporcentaje_final(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDiscapacidad(List<TipoDiscapacidad> tipodiscapacidads,TipoDiscapacidad tipodiscapacidadAux) throws Exception  {
		TipoDiscapacidadConstantesFunciones.InicializarValoresTipoDiscapacidad(tipodiscapacidadAux,true);
		
		for(TipoDiscapacidad tipodiscapacidad: tipodiscapacidads) {
			if(tipodiscapacidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			tipodiscapacidadAux.setporcentaje_inicial(tipodiscapacidadAux.getporcentaje_inicial()+tipodiscapacidad.getporcentaje_inicial());			
			tipodiscapacidadAux.setporcentaje_final(tipodiscapacidadAux.getporcentaje_final()+tipodiscapacidad.getporcentaje_final());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDiscapacidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDiscapacidadConstantesFunciones.getArrayColumnasGlobalesTipoDiscapacidad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDiscapacidad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoDiscapacidadConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoDiscapacidadConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDiscapacidad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDiscapacidad> tipodiscapacidads,TipoDiscapacidad tipodiscapacidad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDiscapacidad tipodiscapacidadAux: tipodiscapacidads) {
			if(tipodiscapacidadAux!=null && tipodiscapacidad!=null) {
				if((tipodiscapacidadAux.getId()==null && tipodiscapacidad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodiscapacidadAux.getId()!=null && tipodiscapacidad.getId()!=null){
					if(tipodiscapacidadAux.getId().equals(tipodiscapacidad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDiscapacidad(List<TipoDiscapacidad> tipodiscapacidads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentaje_inicialTotal=0.0;
		Double porcentaje_finalTotal=0.0;
	
		for(TipoDiscapacidad tipodiscapacidad: tipodiscapacidads) {			
			if(tipodiscapacidad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentaje_inicialTotal+=tipodiscapacidad.getporcentaje_inicial();
			porcentaje_finalTotal+=tipodiscapacidad.getporcentaje_final();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoDiscapacidadConstantesFunciones.PORCENTAJEINICIAL);
		datoGeneral.setsDescripcion(TipoDiscapacidadConstantesFunciones.LABEL_PORCENTAJEINICIAL);
		datoGeneral.setdValorDouble(porcentaje_inicialTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(TipoDiscapacidadConstantesFunciones.PORCENTAJEFINAL);
		datoGeneral.setsDescripcion(TipoDiscapacidadConstantesFunciones.LABEL_PORCENTAJEFINAL);
		datoGeneral.setdValorDouble(porcentaje_finalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDiscapacidad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDiscapacidadConstantesFunciones.LABEL_ID, TipoDiscapacidadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDiscapacidadConstantesFunciones.LABEL_VERSIONROW, TipoDiscapacidadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDiscapacidadConstantesFunciones.LABEL_IDEMPRESA, TipoDiscapacidadConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDiscapacidadConstantesFunciones.LABEL_NOMBRE, TipoDiscapacidadConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDiscapacidadConstantesFunciones.LABEL_PORCENTAJEINICIAL, TipoDiscapacidadConstantesFunciones.PORCENTAJEINICIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDiscapacidadConstantesFunciones.LABEL_PORCENTAJEFINAL, TipoDiscapacidadConstantesFunciones.PORCENTAJEFINAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDiscapacidad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDiscapacidadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDiscapacidadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDiscapacidadConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDiscapacidadConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDiscapacidadConstantesFunciones.PORCENTAJEINICIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDiscapacidadConstantesFunciones.PORCENTAJEFINAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDiscapacidad() throws Exception  {
		return TipoDiscapacidadConstantesFunciones.getTiposSeleccionarTipoDiscapacidad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDiscapacidad(Boolean conFk) throws Exception  {
		return TipoDiscapacidadConstantesFunciones.getTiposSeleccionarTipoDiscapacidad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDiscapacidad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDiscapacidadConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoDiscapacidadConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDiscapacidadConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDiscapacidadConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDiscapacidadConstantesFunciones.LABEL_PORCENTAJEINICIAL);
			reporte.setsDescripcion(TipoDiscapacidadConstantesFunciones.LABEL_PORCENTAJEINICIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDiscapacidadConstantesFunciones.LABEL_PORCENTAJEFINAL);
			reporte.setsDescripcion(TipoDiscapacidadConstantesFunciones.LABEL_PORCENTAJEFINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDiscapacidad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDiscapacidad(TipoDiscapacidad tipodiscapacidadAux) throws Exception {
		
			tipodiscapacidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodiscapacidadAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDiscapacidad(List<TipoDiscapacidad> tipodiscapacidadsTemp) throws Exception {
		for(TipoDiscapacidad tipodiscapacidadAux:tipodiscapacidadsTemp) {
			
			tipodiscapacidadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodiscapacidadAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDiscapacidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDiscapacidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDiscapacidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDiscapacidadConstantesFunciones.getClassesRelationshipsOfTipoDiscapacidad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDiscapacidad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(EmpleadoDisca.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(EmpleadoDisca.class)) {
						classes.add(new Classe(EmpleadoDisca.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDiscapacidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDiscapacidadConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDiscapacidad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDiscapacidad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(EmpleadoDisca.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoDisca.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(EmpleadoDisca.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EmpleadoDisca.class)); continue;
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
	public static void actualizarLista(TipoDiscapacidad tipodiscapacidad,List<TipoDiscapacidad> tipodiscapacidads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDiscapacidad tipodiscapacidadEncontrado=null;
			
			for(TipoDiscapacidad tipodiscapacidadLocal:tipodiscapacidads) {
				if(tipodiscapacidadLocal.getId().equals(tipodiscapacidad.getId())) {
					tipodiscapacidadEncontrado=tipodiscapacidadLocal;
					
					tipodiscapacidadLocal.setIsChanged(tipodiscapacidad.getIsChanged());
					tipodiscapacidadLocal.setIsNew(tipodiscapacidad.getIsNew());
					tipodiscapacidadLocal.setIsDeleted(tipodiscapacidad.getIsDeleted());
					
					tipodiscapacidadLocal.setGeneralEntityOriginal(tipodiscapacidad.getGeneralEntityOriginal());
					
					tipodiscapacidadLocal.setId(tipodiscapacidad.getId());	
					tipodiscapacidadLocal.setVersionRow(tipodiscapacidad.getVersionRow());	
					tipodiscapacidadLocal.setid_empresa(tipodiscapacidad.getid_empresa());	
					tipodiscapacidadLocal.setnombre(tipodiscapacidad.getnombre());	
					tipodiscapacidadLocal.setporcentaje_inicial(tipodiscapacidad.getporcentaje_inicial());	
					tipodiscapacidadLocal.setporcentaje_final(tipodiscapacidad.getporcentaje_final());	
					
					
					tipodiscapacidadLocal.setEmpleadoDiscas(tipodiscapacidad.getEmpleadoDiscas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipodiscapacidad.getIsDeleted()) {
				if(!existe) {
					tipodiscapacidads.add(tipodiscapacidad);
				}
			} else {
				if(tipodiscapacidadEncontrado!=null && permiteQuitar)  {
					tipodiscapacidads.remove(tipodiscapacidadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDiscapacidad tipodiscapacidad,List<TipoDiscapacidad> tipodiscapacidads) throws Exception {
		try	{			
			for(TipoDiscapacidad tipodiscapacidadLocal:tipodiscapacidads) {
				if(tipodiscapacidadLocal.getId().equals(tipodiscapacidad.getId())) {
					tipodiscapacidadLocal.setIsSelected(tipodiscapacidad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDiscapacidad(List<TipoDiscapacidad> tipodiscapacidadsAux) throws Exception {
		//this.tipodiscapacidadsAux=tipodiscapacidadsAux;
		
		for(TipoDiscapacidad tipodiscapacidadAux:tipodiscapacidadsAux) {
			if(tipodiscapacidadAux.getIsChanged()) {
				tipodiscapacidadAux.setIsChanged(false);
			}		
			
			if(tipodiscapacidadAux.getIsNew()) {
				tipodiscapacidadAux.setIsNew(false);
			}	
			
			if(tipodiscapacidadAux.getIsDeleted()) {
				tipodiscapacidadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDiscapacidad(TipoDiscapacidad tipodiscapacidadAux) throws Exception {
		//this.tipodiscapacidadAux=tipodiscapacidadAux;
		
			if(tipodiscapacidadAux.getIsChanged()) {
				tipodiscapacidadAux.setIsChanged(false);
			}		
			
			if(tipodiscapacidadAux.getIsNew()) {
				tipodiscapacidadAux.setIsNew(false);
			}	
			
			if(tipodiscapacidadAux.getIsDeleted()) {
				tipodiscapacidadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDiscapacidad tipodiscapacidadAsignar,TipoDiscapacidad tipodiscapacidad) throws Exception {
		tipodiscapacidadAsignar.setId(tipodiscapacidad.getId());	
		tipodiscapacidadAsignar.setVersionRow(tipodiscapacidad.getVersionRow());	
		tipodiscapacidadAsignar.setid_empresa(tipodiscapacidad.getid_empresa());
		tipodiscapacidadAsignar.setempresa_descripcion(tipodiscapacidad.getempresa_descripcion());	
		tipodiscapacidadAsignar.setnombre(tipodiscapacidad.getnombre());	
		tipodiscapacidadAsignar.setporcentaje_inicial(tipodiscapacidad.getporcentaje_inicial());	
		tipodiscapacidadAsignar.setporcentaje_final(tipodiscapacidad.getporcentaje_final());	
	}
	
	public static void inicializarTipoDiscapacidad(TipoDiscapacidad tipodiscapacidad) throws Exception {
		try {
				tipodiscapacidad.setId(0L);	
					
				tipodiscapacidad.setid_empresa(-1L);	
				tipodiscapacidad.setnombre("");	
				tipodiscapacidad.setporcentaje_inicial(0.0);	
				tipodiscapacidad.setporcentaje_final(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDiscapacidad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDiscapacidadConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDiscapacidadConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDiscapacidadConstantesFunciones.LABEL_PORCENTAJEINICIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDiscapacidadConstantesFunciones.LABEL_PORCENTAJEFINAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDiscapacidad(String sTipo,Row row,Workbook workbook,TipoDiscapacidad tipodiscapacidad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodiscapacidad.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodiscapacidad.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodiscapacidad.getporcentaje_inicial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodiscapacidad.getporcentaje_final());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDiscapacidad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDiscapacidad() {
		return this.sFinalQueryTipoDiscapacidad;
	}
	
	public void setsFinalQueryTipoDiscapacidad(String sFinalQueryTipoDiscapacidad) {
		this.sFinalQueryTipoDiscapacidad= sFinalQueryTipoDiscapacidad;
	}
	
	public Border resaltarSeleccionarTipoDiscapacidad=null;
	
	public Border setResaltarSeleccionarTipoDiscapacidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDiscapacidadBeanSwingJInternalFrame tipodiscapacidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodiscapacidadBeanSwingJInternalFrame.jTtoolBarTipoDiscapacidad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDiscapacidad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDiscapacidad() {
		return this.resaltarSeleccionarTipoDiscapacidad;
	}
	
	public void setResaltarSeleccionarTipoDiscapacidad(Border borderResaltarSeleccionarTipoDiscapacidad) {
		this.resaltarSeleccionarTipoDiscapacidad= borderResaltarSeleccionarTipoDiscapacidad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDiscapacidad=null;
	public Boolean mostraridTipoDiscapacidad=true;
	public Boolean activaridTipoDiscapacidad=true;

	public Border resaltarid_empresaTipoDiscapacidad=null;
	public Boolean mostrarid_empresaTipoDiscapacidad=true;
	public Boolean activarid_empresaTipoDiscapacidad=true;
	public Boolean cargarid_empresaTipoDiscapacidad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoDiscapacidad=false;//ConEventDepend=true

	public Border resaltarnombreTipoDiscapacidad=null;
	public Boolean mostrarnombreTipoDiscapacidad=true;
	public Boolean activarnombreTipoDiscapacidad=true;

	public Border resaltarporcentaje_inicialTipoDiscapacidad=null;
	public Boolean mostrarporcentaje_inicialTipoDiscapacidad=true;
	public Boolean activarporcentaje_inicialTipoDiscapacidad=true;

	public Border resaltarporcentaje_finalTipoDiscapacidad=null;
	public Boolean mostrarporcentaje_finalTipoDiscapacidad=true;
	public Boolean activarporcentaje_finalTipoDiscapacidad=true;

	
	

	public Border setResaltaridTipoDiscapacidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDiscapacidadBeanSwingJInternalFrame tipodiscapacidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodiscapacidadBeanSwingJInternalFrame.jTtoolBarTipoDiscapacidad.setBorder(borderResaltar);
		
		this.resaltaridTipoDiscapacidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDiscapacidad() {
		return this.resaltaridTipoDiscapacidad;
	}

	public void setResaltaridTipoDiscapacidad(Border borderResaltar) {
		this.resaltaridTipoDiscapacidad= borderResaltar;
	}

	public Boolean getMostraridTipoDiscapacidad() {
		return this.mostraridTipoDiscapacidad;
	}

	public void setMostraridTipoDiscapacidad(Boolean mostraridTipoDiscapacidad) {
		this.mostraridTipoDiscapacidad= mostraridTipoDiscapacidad;
	}

	public Boolean getActivaridTipoDiscapacidad() {
		return this.activaridTipoDiscapacidad;
	}

	public void setActivaridTipoDiscapacidad(Boolean activaridTipoDiscapacidad) {
		this.activaridTipoDiscapacidad= activaridTipoDiscapacidad;
	}

	public Border setResaltarid_empresaTipoDiscapacidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDiscapacidadBeanSwingJInternalFrame tipodiscapacidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodiscapacidadBeanSwingJInternalFrame.jTtoolBarTipoDiscapacidad.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoDiscapacidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoDiscapacidad() {
		return this.resaltarid_empresaTipoDiscapacidad;
	}

	public void setResaltarid_empresaTipoDiscapacidad(Border borderResaltar) {
		this.resaltarid_empresaTipoDiscapacidad= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoDiscapacidad() {
		return this.mostrarid_empresaTipoDiscapacidad;
	}

	public void setMostrarid_empresaTipoDiscapacidad(Boolean mostrarid_empresaTipoDiscapacidad) {
		this.mostrarid_empresaTipoDiscapacidad= mostrarid_empresaTipoDiscapacidad;
	}

	public Boolean getActivarid_empresaTipoDiscapacidad() {
		return this.activarid_empresaTipoDiscapacidad;
	}

	public void setActivarid_empresaTipoDiscapacidad(Boolean activarid_empresaTipoDiscapacidad) {
		this.activarid_empresaTipoDiscapacidad= activarid_empresaTipoDiscapacidad;
	}

	public Boolean getCargarid_empresaTipoDiscapacidad() {
		return this.cargarid_empresaTipoDiscapacidad;
	}

	public void setCargarid_empresaTipoDiscapacidad(Boolean cargarid_empresaTipoDiscapacidad) {
		this.cargarid_empresaTipoDiscapacidad= cargarid_empresaTipoDiscapacidad;
	}

	public Border setResaltarnombreTipoDiscapacidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDiscapacidadBeanSwingJInternalFrame tipodiscapacidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodiscapacidadBeanSwingJInternalFrame.jTtoolBarTipoDiscapacidad.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDiscapacidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDiscapacidad() {
		return this.resaltarnombreTipoDiscapacidad;
	}

	public void setResaltarnombreTipoDiscapacidad(Border borderResaltar) {
		this.resaltarnombreTipoDiscapacidad= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDiscapacidad() {
		return this.mostrarnombreTipoDiscapacidad;
	}

	public void setMostrarnombreTipoDiscapacidad(Boolean mostrarnombreTipoDiscapacidad) {
		this.mostrarnombreTipoDiscapacidad= mostrarnombreTipoDiscapacidad;
	}

	public Boolean getActivarnombreTipoDiscapacidad() {
		return this.activarnombreTipoDiscapacidad;
	}

	public void setActivarnombreTipoDiscapacidad(Boolean activarnombreTipoDiscapacidad) {
		this.activarnombreTipoDiscapacidad= activarnombreTipoDiscapacidad;
	}

	public Border setResaltarporcentaje_inicialTipoDiscapacidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDiscapacidadBeanSwingJInternalFrame tipodiscapacidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodiscapacidadBeanSwingJInternalFrame.jTtoolBarTipoDiscapacidad.setBorder(borderResaltar);
		
		this.resaltarporcentaje_inicialTipoDiscapacidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_inicialTipoDiscapacidad() {
		return this.resaltarporcentaje_inicialTipoDiscapacidad;
	}

	public void setResaltarporcentaje_inicialTipoDiscapacidad(Border borderResaltar) {
		this.resaltarporcentaje_inicialTipoDiscapacidad= borderResaltar;
	}

	public Boolean getMostrarporcentaje_inicialTipoDiscapacidad() {
		return this.mostrarporcentaje_inicialTipoDiscapacidad;
	}

	public void setMostrarporcentaje_inicialTipoDiscapacidad(Boolean mostrarporcentaje_inicialTipoDiscapacidad) {
		this.mostrarporcentaje_inicialTipoDiscapacidad= mostrarporcentaje_inicialTipoDiscapacidad;
	}

	public Boolean getActivarporcentaje_inicialTipoDiscapacidad() {
		return this.activarporcentaje_inicialTipoDiscapacidad;
	}

	public void setActivarporcentaje_inicialTipoDiscapacidad(Boolean activarporcentaje_inicialTipoDiscapacidad) {
		this.activarporcentaje_inicialTipoDiscapacidad= activarporcentaje_inicialTipoDiscapacidad;
	}

	public Border setResaltarporcentaje_finalTipoDiscapacidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDiscapacidadBeanSwingJInternalFrame tipodiscapacidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodiscapacidadBeanSwingJInternalFrame.jTtoolBarTipoDiscapacidad.setBorder(borderResaltar);
		
		this.resaltarporcentaje_finalTipoDiscapacidad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentaje_finalTipoDiscapacidad() {
		return this.resaltarporcentaje_finalTipoDiscapacidad;
	}

	public void setResaltarporcentaje_finalTipoDiscapacidad(Border borderResaltar) {
		this.resaltarporcentaje_finalTipoDiscapacidad= borderResaltar;
	}

	public Boolean getMostrarporcentaje_finalTipoDiscapacidad() {
		return this.mostrarporcentaje_finalTipoDiscapacidad;
	}

	public void setMostrarporcentaje_finalTipoDiscapacidad(Boolean mostrarporcentaje_finalTipoDiscapacidad) {
		this.mostrarporcentaje_finalTipoDiscapacidad= mostrarporcentaje_finalTipoDiscapacidad;
	}

	public Boolean getActivarporcentaje_finalTipoDiscapacidad() {
		return this.activarporcentaje_finalTipoDiscapacidad;
	}

	public void setActivarporcentaje_finalTipoDiscapacidad(Boolean activarporcentaje_finalTipoDiscapacidad) {
		this.activarporcentaje_finalTipoDiscapacidad= activarporcentaje_finalTipoDiscapacidad;
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
		
		
		this.setMostraridTipoDiscapacidad(esInicial);
		this.setMostrarid_empresaTipoDiscapacidad(esInicial);
		this.setMostrarnombreTipoDiscapacidad(esInicial);
		this.setMostrarporcentaje_inicialTipoDiscapacidad(esInicial);
		this.setMostrarporcentaje_finalTipoDiscapacidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.ID)) {
				this.setMostraridTipoDiscapacidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoDiscapacidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDiscapacidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.PORCENTAJEINICIAL)) {
				this.setMostrarporcentaje_inicialTipoDiscapacidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.PORCENTAJEFINAL)) {
				this.setMostrarporcentaje_finalTipoDiscapacidad(esAsigna);
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
		
		
		this.setActivaridTipoDiscapacidad(esInicial);
		this.setActivarid_empresaTipoDiscapacidad(esInicial);
		this.setActivarnombreTipoDiscapacidad(esInicial);
		this.setActivarporcentaje_inicialTipoDiscapacidad(esInicial);
		this.setActivarporcentaje_finalTipoDiscapacidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.ID)) {
				this.setActivaridTipoDiscapacidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoDiscapacidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDiscapacidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.PORCENTAJEINICIAL)) {
				this.setActivarporcentaje_inicialTipoDiscapacidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.PORCENTAJEFINAL)) {
				this.setActivarporcentaje_finalTipoDiscapacidad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDiscapacidadBeanSwingJInternalFrame tipodiscapacidadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDiscapacidad(esInicial);
		this.setResaltarid_empresaTipoDiscapacidad(esInicial);
		this.setResaltarnombreTipoDiscapacidad(esInicial);
		this.setResaltarporcentaje_inicialTipoDiscapacidad(esInicial);
		this.setResaltarporcentaje_finalTipoDiscapacidad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.ID)) {
				this.setResaltaridTipoDiscapacidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoDiscapacidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDiscapacidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.PORCENTAJEINICIAL)) {
				this.setResaltarporcentaje_inicialTipoDiscapacidad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDiscapacidadConstantesFunciones.PORCENTAJEFINAL)) {
				this.setResaltarporcentaje_finalTipoDiscapacidad(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarEmpleadoDiscaTipoDiscapacidad=null;

	public Border getResaltarEmpleadoDiscaTipoDiscapacidad() {
		return this.resaltarEmpleadoDiscaTipoDiscapacidad;
	}

	public void setResaltarEmpleadoDiscaTipoDiscapacidad(Border borderResaltarEmpleadoDisca) {
		if(borderResaltarEmpleadoDisca!=null) {
			this.resaltarEmpleadoDiscaTipoDiscapacidad= borderResaltarEmpleadoDisca;
		}
	}

	public Border setResaltarEmpleadoDiscaTipoDiscapacidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDiscapacidadBeanSwingJInternalFrame tipodiscapacidadBeanSwingJInternalFrame*/) {
		Border borderResaltarEmpleadoDisca=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipodiscapacidadBeanSwingJInternalFrame.jTtoolBarTipoDiscapacidad.setBorder(borderResaltarEmpleadoDisca);
			
		this.resaltarEmpleadoDiscaTipoDiscapacidad= borderResaltarEmpleadoDisca;

		 return borderResaltarEmpleadoDisca;
	}



	public Boolean mostrarEmpleadoDiscaTipoDiscapacidad=true;

	public Boolean getMostrarEmpleadoDiscaTipoDiscapacidad() {
		return this.mostrarEmpleadoDiscaTipoDiscapacidad;
	}

	public void setMostrarEmpleadoDiscaTipoDiscapacidad(Boolean visibilidadResaltarEmpleadoDisca) {
		this.mostrarEmpleadoDiscaTipoDiscapacidad= visibilidadResaltarEmpleadoDisca;
	}



	public Boolean activarEmpleadoDiscaTipoDiscapacidad=true;

	public Boolean gethabilitarResaltarEmpleadoDiscaTipoDiscapacidad() {
		return this.activarEmpleadoDiscaTipoDiscapacidad;
	}

	public void setActivarEmpleadoDiscaTipoDiscapacidad(Boolean habilitarResaltarEmpleadoDisca) {
		this.activarEmpleadoDiscaTipoDiscapacidad= habilitarResaltarEmpleadoDisca;
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

		this.setMostrarEmpleadoDiscaTipoDiscapacidad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoDisca.class)) {
				this.setMostrarEmpleadoDiscaTipoDiscapacidad(esAsigna);
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

		this.setActivarEmpleadoDiscaTipoDiscapacidad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoDisca.class)) {
				this.setActivarEmpleadoDiscaTipoDiscapacidad(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDiscapacidadBeanSwingJInternalFrame tipodiscapacidadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarEmpleadoDiscaTipoDiscapacidad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(EmpleadoDisca.class)) {
				this.setResaltarEmpleadoDiscaTipoDiscapacidad(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoDiscapacidad=true;

	public Boolean getMostrarFK_IdEmpresaTipoDiscapacidad() {
		return this.mostrarFK_IdEmpresaTipoDiscapacidad;
	}

	public void setMostrarFK_IdEmpresaTipoDiscapacidad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoDiscapacidad= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoDiscapacidad=true;

	public Boolean getActivarFK_IdEmpresaTipoDiscapacidad() {
		return this.activarFK_IdEmpresaTipoDiscapacidad;
	}

	public void setActivarFK_IdEmpresaTipoDiscapacidad(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoDiscapacidad= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoDiscapacidad=null;

	public Border getResaltarFK_IdEmpresaTipoDiscapacidad() {
		return this.resaltarFK_IdEmpresaTipoDiscapacidad;
	}

	public void setResaltarFK_IdEmpresaTipoDiscapacidad(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoDiscapacidad= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoDiscapacidad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDiscapacidadBeanSwingJInternalFrame tipodiscapacidadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoDiscapacidad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}