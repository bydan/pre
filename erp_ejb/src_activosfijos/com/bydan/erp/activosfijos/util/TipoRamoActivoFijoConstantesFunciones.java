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


import com.bydan.erp.activosfijos.util.TipoRamoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.TipoRamoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.TipoRamoActivoFijoParameterGeneral;

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
final public class TipoRamoActivoFijoConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoRamoActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoRamoActivoFijo"+TipoRamoActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoRamoActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoRamoActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoRamoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoRamoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoRamoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoRamoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoRamoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoRamoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoRamoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoRamoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoRamoActivoFijoConstantesFunciones.SCHEMA+"_"+TipoRamoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRamoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRamoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRamoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRamoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRamoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRamoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoRamoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoRamoActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoRamoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoRamoActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Ramo Activo Fijos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Ramo Activo Fijo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Ramo Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoRamoActivoFijo";
	public static final String OBJECTNAME="tiporamoactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="tipo_ramo_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiporamoactivofijo from "+TipoRamoActivoFijoConstantesFunciones.SPERSISTENCENAME+" tiporamoactivofijo";
	public static String QUERYSELECTNATIVE="select "+TipoRamoActivoFijoConstantesFunciones.SCHEMA+"."+TipoRamoActivoFijoConstantesFunciones.TABLENAME+".id,"+TipoRamoActivoFijoConstantesFunciones.SCHEMA+"."+TipoRamoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+TipoRamoActivoFijoConstantesFunciones.SCHEMA+"."+TipoRamoActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+TipoRamoActivoFijoConstantesFunciones.SCHEMA+"."+TipoRamoActivoFijoConstantesFunciones.TABLENAME+".nombre from "+TipoRamoActivoFijoConstantesFunciones.SCHEMA+"."+TipoRamoActivoFijoConstantesFunciones.TABLENAME;//+" as "+TipoRamoActivoFijoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoRamoActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoRamoActivoFijoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoRamoActivoFijoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoRamoActivoFijoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoRamoActivoFijoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoRamoActivoFijoDescripcion(TipoRamoActivoFijo tiporamoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiporamoactivofijo !=null/* && tiporamoactivofijo.getId()!=0*/) {
			sDescripcion=tiporamoactivofijo.getnombre();//tiporamoactivofijotiporamoactivofijo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoRamoActivoFijoDescripcionDetallado(TipoRamoActivoFijo tiporamoactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=TipoRamoActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=tiporamoactivofijo.getId().toString()+",";
		sDescripcion+=TipoRamoActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiporamoactivofijo.getVersionRow().toString()+",";
		sDescripcion+=TipoRamoActivoFijoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tiporamoactivofijo.getid_empresa().toString()+",";
		sDescripcion+=TipoRamoActivoFijoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiporamoactivofijo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoRamoActivoFijoDescripcion(TipoRamoActivoFijo tiporamoactivofijo,String sValor) throws Exception {			
		if(tiporamoactivofijo !=null) {
			tiporamoactivofijo.setnombre(sValor);//tiporamoactivofijotiporamoactivofijo.getId().toString();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoRamoActivoFijo(TipoRamoActivoFijo tiporamoactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiporamoactivofijo.setnombre(tiporamoactivofijo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoRamoActivoFijos(List<TipoRamoActivoFijo> tiporamoactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoRamoActivoFijo tiporamoactivofijo: tiporamoactivofijos) {
			tiporamoactivofijo.setnombre(tiporamoactivofijo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRamoActivoFijo(TipoRamoActivoFijo tiporamoactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiporamoactivofijo.getConCambioAuxiliar()) {
			tiporamoactivofijo.setIsDeleted(tiporamoactivofijo.getIsDeletedAuxiliar());	
			tiporamoactivofijo.setIsNew(tiporamoactivofijo.getIsNewAuxiliar());	
			tiporamoactivofijo.setIsChanged(tiporamoactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiporamoactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiporamoactivofijo.setIsDeletedAuxiliar(false);	
			tiporamoactivofijo.setIsNewAuxiliar(false);	
			tiporamoactivofijo.setIsChangedAuxiliar(false);
			
			tiporamoactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRamoActivoFijos(List<TipoRamoActivoFijo> tiporamoactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoRamoActivoFijo tiporamoactivofijo : tiporamoactivofijos) {
			if(conAsignarBase && tiporamoactivofijo.getConCambioAuxiliar()) {
				tiporamoactivofijo.setIsDeleted(tiporamoactivofijo.getIsDeletedAuxiliar());	
				tiporamoactivofijo.setIsNew(tiporamoactivofijo.getIsNewAuxiliar());	
				tiporamoactivofijo.setIsChanged(tiporamoactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiporamoactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiporamoactivofijo.setIsDeletedAuxiliar(false);	
				tiporamoactivofijo.setIsNewAuxiliar(false);	
				tiporamoactivofijo.setIsChangedAuxiliar(false);
				
				tiporamoactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoRamoActivoFijo(TipoRamoActivoFijo tiporamoactivofijo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoRamoActivoFijos(List<TipoRamoActivoFijo> tiporamoactivofijos,Boolean conEnteros) throws Exception  {
		
		for(TipoRamoActivoFijo tiporamoactivofijo: tiporamoactivofijos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoRamoActivoFijo(List<TipoRamoActivoFijo> tiporamoactivofijos,TipoRamoActivoFijo tiporamoactivofijoAux) throws Exception  {
		TipoRamoActivoFijoConstantesFunciones.InicializarValoresTipoRamoActivoFijo(tiporamoactivofijoAux,true);
		
		for(TipoRamoActivoFijo tiporamoactivofijo: tiporamoactivofijos) {
			if(tiporamoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRamoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoRamoActivoFijoConstantesFunciones.getArrayColumnasGlobalesTipoRamoActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRamoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoRamoActivoFijoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoRamoActivoFijoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoRamoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoRamoActivoFijo> tiporamoactivofijos,TipoRamoActivoFijo tiporamoactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoRamoActivoFijo tiporamoactivofijoAux: tiporamoactivofijos) {
			if(tiporamoactivofijoAux!=null && tiporamoactivofijo!=null) {
				if((tiporamoactivofijoAux.getId()==null && tiporamoactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiporamoactivofijoAux.getId()!=null && tiporamoactivofijo.getId()!=null){
					if(tiporamoactivofijoAux.getId().equals(tiporamoactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoRamoActivoFijo(List<TipoRamoActivoFijo> tiporamoactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoRamoActivoFijo tiporamoactivofijo: tiporamoactivofijos) {			
			if(tiporamoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoRamoActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoRamoActivoFijoConstantesFunciones.LABEL_ID, TipoRamoActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRamoActivoFijoConstantesFunciones.LABEL_VERSIONROW, TipoRamoActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRamoActivoFijoConstantesFunciones.LABEL_IDEMPRESA, TipoRamoActivoFijoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRamoActivoFijoConstantesFunciones.LABEL_NOMBRE, TipoRamoActivoFijoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoRamoActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoRamoActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRamoActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRamoActivoFijoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRamoActivoFijoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRamoActivoFijo() throws Exception  {
		return TipoRamoActivoFijoConstantesFunciones.getTiposSeleccionarTipoRamoActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRamoActivoFijo(Boolean conFk) throws Exception  {
		return TipoRamoActivoFijoConstantesFunciones.getTiposSeleccionarTipoRamoActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRamoActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRamoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoRamoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRamoActivoFijoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoRamoActivoFijoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoRamoActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRamoActivoFijo(TipoRamoActivoFijo tiporamoactivofijoAux) throws Exception {
		
			tiporamoactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiporamoactivofijoAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRamoActivoFijo(List<TipoRamoActivoFijo> tiporamoactivofijosTemp) throws Exception {
		for(TipoRamoActivoFijo tiporamoactivofijoAux:tiporamoactivofijosTemp) {
			
			tiporamoactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiporamoactivofijoAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRamoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoRamoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRamoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRamoActivoFijoConstantesFunciones.getClassesRelationshipsOfTipoRamoActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRamoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleActivoFijo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRamoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRamoActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoRamoActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRamoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
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
	public static void actualizarLista(TipoRamoActivoFijo tiporamoactivofijo,List<TipoRamoActivoFijo> tiporamoactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoRamoActivoFijo tiporamoactivofijoEncontrado=null;
			
			for(TipoRamoActivoFijo tiporamoactivofijoLocal:tiporamoactivofijos) {
				if(tiporamoactivofijoLocal.getId().equals(tiporamoactivofijo.getId())) {
					tiporamoactivofijoEncontrado=tiporamoactivofijoLocal;
					
					tiporamoactivofijoLocal.setIsChanged(tiporamoactivofijo.getIsChanged());
					tiporamoactivofijoLocal.setIsNew(tiporamoactivofijo.getIsNew());
					tiporamoactivofijoLocal.setIsDeleted(tiporamoactivofijo.getIsDeleted());
					
					tiporamoactivofijoLocal.setGeneralEntityOriginal(tiporamoactivofijo.getGeneralEntityOriginal());
					
					tiporamoactivofijoLocal.setId(tiporamoactivofijo.getId());	
					tiporamoactivofijoLocal.setVersionRow(tiporamoactivofijo.getVersionRow());	
					tiporamoactivofijoLocal.setid_empresa(tiporamoactivofijo.getid_empresa());	
					tiporamoactivofijoLocal.setnombre(tiporamoactivofijo.getnombre());	
					
					
					tiporamoactivofijoLocal.setDetalleActivoFijos(tiporamoactivofijo.getDetalleActivoFijos());
					
					existe=true;
					break;
				}
			}
			
			if(!tiporamoactivofijo.getIsDeleted()) {
				if(!existe) {
					tiporamoactivofijos.add(tiporamoactivofijo);
				}
			} else {
				if(tiporamoactivofijoEncontrado!=null && permiteQuitar)  {
					tiporamoactivofijos.remove(tiporamoactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoRamoActivoFijo tiporamoactivofijo,List<TipoRamoActivoFijo> tiporamoactivofijos) throws Exception {
		try	{			
			for(TipoRamoActivoFijo tiporamoactivofijoLocal:tiporamoactivofijos) {
				if(tiporamoactivofijoLocal.getId().equals(tiporamoactivofijo.getId())) {
					tiporamoactivofijoLocal.setIsSelected(tiporamoactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoRamoActivoFijo(List<TipoRamoActivoFijo> tiporamoactivofijosAux) throws Exception {
		//this.tiporamoactivofijosAux=tiporamoactivofijosAux;
		
		for(TipoRamoActivoFijo tiporamoactivofijoAux:tiporamoactivofijosAux) {
			if(tiporamoactivofijoAux.getIsChanged()) {
				tiporamoactivofijoAux.setIsChanged(false);
			}		
			
			if(tiporamoactivofijoAux.getIsNew()) {
				tiporamoactivofijoAux.setIsNew(false);
			}	
			
			if(tiporamoactivofijoAux.getIsDeleted()) {
				tiporamoactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoRamoActivoFijo(TipoRamoActivoFijo tiporamoactivofijoAux) throws Exception {
		//this.tiporamoactivofijoAux=tiporamoactivofijoAux;
		
			if(tiporamoactivofijoAux.getIsChanged()) {
				tiporamoactivofijoAux.setIsChanged(false);
			}		
			
			if(tiporamoactivofijoAux.getIsNew()) {
				tiporamoactivofijoAux.setIsNew(false);
			}	
			
			if(tiporamoactivofijoAux.getIsDeleted()) {
				tiporamoactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoRamoActivoFijo tiporamoactivofijoAsignar,TipoRamoActivoFijo tiporamoactivofijo) throws Exception {
		tiporamoactivofijoAsignar.setId(tiporamoactivofijo.getId());	
		tiporamoactivofijoAsignar.setVersionRow(tiporamoactivofijo.getVersionRow());	
		tiporamoactivofijoAsignar.setid_empresa(tiporamoactivofijo.getid_empresa());
		tiporamoactivofijoAsignar.setempresa_descripcion(tiporamoactivofijo.getempresa_descripcion());	
		tiporamoactivofijoAsignar.setnombre(tiporamoactivofijo.getnombre());	
	}
	
	public static void inicializarTipoRamoActivoFijo(TipoRamoActivoFijo tiporamoactivofijo) throws Exception {
		try {
				tiporamoactivofijo.setId(0L);	
					
				tiporamoactivofijo.setid_empresa(-1L);	
				tiporamoactivofijo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoRamoActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRamoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRamoActivoFijoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoRamoActivoFijo(String sTipo,Row row,Workbook workbook,TipoRamoActivoFijo tiporamoactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporamoactivofijo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporamoactivofijo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoRamoActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoRamoActivoFijo() {
		return this.sFinalQueryTipoRamoActivoFijo;
	}
	
	public void setsFinalQueryTipoRamoActivoFijo(String sFinalQueryTipoRamoActivoFijo) {
		this.sFinalQueryTipoRamoActivoFijo= sFinalQueryTipoRamoActivoFijo;
	}
	
	public Border resaltarSeleccionarTipoRamoActivoFijo=null;
	
	public Border setResaltarSeleccionarTipoRamoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRamoActivoFijoBeanSwingJInternalFrame tiporamoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiporamoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoRamoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoRamoActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoRamoActivoFijo() {
		return this.resaltarSeleccionarTipoRamoActivoFijo;
	}
	
	public void setResaltarSeleccionarTipoRamoActivoFijo(Border borderResaltarSeleccionarTipoRamoActivoFijo) {
		this.resaltarSeleccionarTipoRamoActivoFijo= borderResaltarSeleccionarTipoRamoActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoRamoActivoFijo=null;
	public Boolean mostraridTipoRamoActivoFijo=true;
	public Boolean activaridTipoRamoActivoFijo=true;

	public Border resaltarid_empresaTipoRamoActivoFijo=null;
	public Boolean mostrarid_empresaTipoRamoActivoFijo=true;
	public Boolean activarid_empresaTipoRamoActivoFijo=true;
	public Boolean cargarid_empresaTipoRamoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoRamoActivoFijo=false;//ConEventDepend=true

	public Border resaltarnombreTipoRamoActivoFijo=null;
	public Boolean mostrarnombreTipoRamoActivoFijo=true;
	public Boolean activarnombreTipoRamoActivoFijo=true;

	
	

	public Border setResaltaridTipoRamoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRamoActivoFijoBeanSwingJInternalFrame tiporamoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporamoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoRamoActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridTipoRamoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoRamoActivoFijo() {
		return this.resaltaridTipoRamoActivoFijo;
	}

	public void setResaltaridTipoRamoActivoFijo(Border borderResaltar) {
		this.resaltaridTipoRamoActivoFijo= borderResaltar;
	}

	public Boolean getMostraridTipoRamoActivoFijo() {
		return this.mostraridTipoRamoActivoFijo;
	}

	public void setMostraridTipoRamoActivoFijo(Boolean mostraridTipoRamoActivoFijo) {
		this.mostraridTipoRamoActivoFijo= mostraridTipoRamoActivoFijo;
	}

	public Boolean getActivaridTipoRamoActivoFijo() {
		return this.activaridTipoRamoActivoFijo;
	}

	public void setActivaridTipoRamoActivoFijo(Boolean activaridTipoRamoActivoFijo) {
		this.activaridTipoRamoActivoFijo= activaridTipoRamoActivoFijo;
	}

	public Border setResaltarid_empresaTipoRamoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRamoActivoFijoBeanSwingJInternalFrame tiporamoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporamoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoRamoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoRamoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoRamoActivoFijo() {
		return this.resaltarid_empresaTipoRamoActivoFijo;
	}

	public void setResaltarid_empresaTipoRamoActivoFijo(Border borderResaltar) {
		this.resaltarid_empresaTipoRamoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoRamoActivoFijo() {
		return this.mostrarid_empresaTipoRamoActivoFijo;
	}

	public void setMostrarid_empresaTipoRamoActivoFijo(Boolean mostrarid_empresaTipoRamoActivoFijo) {
		this.mostrarid_empresaTipoRamoActivoFijo= mostrarid_empresaTipoRamoActivoFijo;
	}

	public Boolean getActivarid_empresaTipoRamoActivoFijo() {
		return this.activarid_empresaTipoRamoActivoFijo;
	}

	public void setActivarid_empresaTipoRamoActivoFijo(Boolean activarid_empresaTipoRamoActivoFijo) {
		this.activarid_empresaTipoRamoActivoFijo= activarid_empresaTipoRamoActivoFijo;
	}

	public Boolean getCargarid_empresaTipoRamoActivoFijo() {
		return this.cargarid_empresaTipoRamoActivoFijo;
	}

	public void setCargarid_empresaTipoRamoActivoFijo(Boolean cargarid_empresaTipoRamoActivoFijo) {
		this.cargarid_empresaTipoRamoActivoFijo= cargarid_empresaTipoRamoActivoFijo;
	}

	public Border setResaltarnombreTipoRamoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRamoActivoFijoBeanSwingJInternalFrame tiporamoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporamoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoRamoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoRamoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoRamoActivoFijo() {
		return this.resaltarnombreTipoRamoActivoFijo;
	}

	public void setResaltarnombreTipoRamoActivoFijo(Border borderResaltar) {
		this.resaltarnombreTipoRamoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoRamoActivoFijo() {
		return this.mostrarnombreTipoRamoActivoFijo;
	}

	public void setMostrarnombreTipoRamoActivoFijo(Boolean mostrarnombreTipoRamoActivoFijo) {
		this.mostrarnombreTipoRamoActivoFijo= mostrarnombreTipoRamoActivoFijo;
	}

	public Boolean getActivarnombreTipoRamoActivoFijo() {
		return this.activarnombreTipoRamoActivoFijo;
	}

	public void setActivarnombreTipoRamoActivoFijo(Boolean activarnombreTipoRamoActivoFijo) {
		this.activarnombreTipoRamoActivoFijo= activarnombreTipoRamoActivoFijo;
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
		
		
		this.setMostraridTipoRamoActivoFijo(esInicial);
		this.setMostrarid_empresaTipoRamoActivoFijo(esInicial);
		this.setMostrarnombreTipoRamoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRamoActivoFijoConstantesFunciones.ID)) {
				this.setMostraridTipoRamoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRamoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoRamoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRamoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoRamoActivoFijo(esAsigna);
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
		
		
		this.setActivaridTipoRamoActivoFijo(esInicial);
		this.setActivarid_empresaTipoRamoActivoFijo(esInicial);
		this.setActivarnombreTipoRamoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRamoActivoFijoConstantesFunciones.ID)) {
				this.setActivaridTipoRamoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRamoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoRamoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRamoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoRamoActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRamoActivoFijoBeanSwingJInternalFrame tiporamoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoRamoActivoFijo(esInicial);
		this.setResaltarid_empresaTipoRamoActivoFijo(esInicial);
		this.setResaltarnombreTipoRamoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRamoActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridTipoRamoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRamoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoRamoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRamoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoRamoActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleActivoFijoTipoRamoActivoFijo=null;

	public Border getResaltarDetalleActivoFijoTipoRamoActivoFijo() {
		return this.resaltarDetalleActivoFijoTipoRamoActivoFijo;
	}

	public void setResaltarDetalleActivoFijoTipoRamoActivoFijo(Border borderResaltarDetalleActivoFijo) {
		if(borderResaltarDetalleActivoFijo!=null) {
			this.resaltarDetalleActivoFijoTipoRamoActivoFijo= borderResaltarDetalleActivoFijo;
		}
	}

	public Border setResaltarDetalleActivoFijoTipoRamoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRamoActivoFijoBeanSwingJInternalFrame tiporamoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiporamoactivofijoBeanSwingJInternalFrame.jTtoolBarTipoRamoActivoFijo.setBorder(borderResaltarDetalleActivoFijo);
			
		this.resaltarDetalleActivoFijoTipoRamoActivoFijo= borderResaltarDetalleActivoFijo;

		 return borderResaltarDetalleActivoFijo;
	}



	public Boolean mostrarDetalleActivoFijoTipoRamoActivoFijo=true;

	public Boolean getMostrarDetalleActivoFijoTipoRamoActivoFijo() {
		return this.mostrarDetalleActivoFijoTipoRamoActivoFijo;
	}

	public void setMostrarDetalleActivoFijoTipoRamoActivoFijo(Boolean visibilidadResaltarDetalleActivoFijo) {
		this.mostrarDetalleActivoFijoTipoRamoActivoFijo= visibilidadResaltarDetalleActivoFijo;
	}



	public Boolean activarDetalleActivoFijoTipoRamoActivoFijo=true;

	public Boolean gethabilitarResaltarDetalleActivoFijoTipoRamoActivoFijo() {
		return this.activarDetalleActivoFijoTipoRamoActivoFijo;
	}

	public void setActivarDetalleActivoFijoTipoRamoActivoFijo(Boolean habilitarResaltarDetalleActivoFijo) {
		this.activarDetalleActivoFijoTipoRamoActivoFijo= habilitarResaltarDetalleActivoFijo;
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

		this.setMostrarDetalleActivoFijoTipoRamoActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setMostrarDetalleActivoFijoTipoRamoActivoFijo(esAsigna);
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

		this.setActivarDetalleActivoFijoTipoRamoActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setActivarDetalleActivoFijoTipoRamoActivoFijo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRamoActivoFijoBeanSwingJInternalFrame tiporamoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleActivoFijoTipoRamoActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setResaltarDetalleActivoFijoTipoRamoActivoFijo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoRamoActivoFijo=true;

	public Boolean getMostrarFK_IdEmpresaTipoRamoActivoFijo() {
		return this.mostrarFK_IdEmpresaTipoRamoActivoFijo;
	}

	public void setMostrarFK_IdEmpresaTipoRamoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoRamoActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoRamoActivoFijo=true;

	public Boolean getActivarFK_IdEmpresaTipoRamoActivoFijo() {
		return this.activarFK_IdEmpresaTipoRamoActivoFijo;
	}

	public void setActivarFK_IdEmpresaTipoRamoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoRamoActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoRamoActivoFijo=null;

	public Border getResaltarFK_IdEmpresaTipoRamoActivoFijo() {
		return this.resaltarFK_IdEmpresaTipoRamoActivoFijo;
	}

	public void setResaltarFK_IdEmpresaTipoRamoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoRamoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoRamoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRamoActivoFijoBeanSwingJInternalFrame tiporamoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoRamoActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}