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
package com.bydan.erp.cartera.util;

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


import com.bydan.erp.cartera.util.TipoRelaLaboConstantesFunciones;
import com.bydan.erp.cartera.util.TipoRelaLaboParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoRelaLaboParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



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
final public class TipoRelaLaboConstantesFunciones extends TipoRelaLaboConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoRelaLabo";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoRelaLabo"+TipoRelaLaboConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoRelaLaboHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoRelaLaboHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoRelaLaboConstantesFunciones.SCHEMA+"_"+TipoRelaLaboConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoRelaLaboHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoRelaLaboConstantesFunciones.SCHEMA+"_"+TipoRelaLaboConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoRelaLaboConstantesFunciones.SCHEMA+"_"+TipoRelaLaboConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoRelaLaboHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoRelaLaboConstantesFunciones.SCHEMA+"_"+TipoRelaLaboConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRelaLaboConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRelaLaboHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRelaLaboConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRelaLaboConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoRelaLaboHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoRelaLaboConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoRelaLaboConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoRelaLaboConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoRelaLaboConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoRelaLaboConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Rela Labos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Rela Labo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Rela Labo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoRelaLabo";
	public static final String OBJECTNAME="tiporelalabo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_rela_labo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiporelalabo from "+TipoRelaLaboConstantesFunciones.SPERSISTENCENAME+" tiporelalabo";
	public static String QUERYSELECTNATIVE="select "+TipoRelaLaboConstantesFunciones.SCHEMA+"."+TipoRelaLaboConstantesFunciones.TABLENAME+".id,"+TipoRelaLaboConstantesFunciones.SCHEMA+"."+TipoRelaLaboConstantesFunciones.TABLENAME+".version_row,"+TipoRelaLaboConstantesFunciones.SCHEMA+"."+TipoRelaLaboConstantesFunciones.TABLENAME+".id_empresa,"+TipoRelaLaboConstantesFunciones.SCHEMA+"."+TipoRelaLaboConstantesFunciones.TABLENAME+".codigo,"+TipoRelaLaboConstantesFunciones.SCHEMA+"."+TipoRelaLaboConstantesFunciones.TABLENAME+".nombre from "+TipoRelaLaboConstantesFunciones.SCHEMA+"."+TipoRelaLaboConstantesFunciones.TABLENAME;//+" as "+TipoRelaLaboConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoRelaLaboConstantesFuncionesAdditional tiporelalaboConstantesFuncionesAdditional=null;
	
	public TipoRelaLaboConstantesFuncionesAdditional getTipoRelaLaboConstantesFuncionesAdditional() {
		return this.tiporelalaboConstantesFuncionesAdditional;
	}
	
	public void setTipoRelaLaboConstantesFuncionesAdditional(TipoRelaLaboConstantesFuncionesAdditional tiporelalaboConstantesFuncionesAdditional) {
		try {
			this.tiporelalaboConstantesFuncionesAdditional=tiporelalaboConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
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
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoRelaLaboLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoRelaLaboConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoRelaLaboConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoRelaLaboConstantesFunciones.CODIGO)) {sLabelColumna=TipoRelaLaboConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoRelaLaboConstantesFunciones.NOMBRE)) {sLabelColumna=TipoRelaLaboConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoRelaLaboDescripcion(TipoRelaLabo tiporelalabo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiporelalabo !=null/* && tiporelalabo.getId()!=0*/) {
			sDescripcion=tiporelalabo.getcodigo();//tiporelalabotiporelalabo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoRelaLaboDescripcionDetallado(TipoRelaLabo tiporelalabo) {
		String sDescripcion="";
			
		sDescripcion+=TipoRelaLaboConstantesFunciones.ID+"=";
		sDescripcion+=tiporelalabo.getId().toString()+",";
		sDescripcion+=TipoRelaLaboConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiporelalabo.getVersionRow().toString()+",";
		sDescripcion+=TipoRelaLaboConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tiporelalabo.getid_empresa().toString()+",";
		sDescripcion+=TipoRelaLaboConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiporelalabo.getcodigo()+",";
		sDescripcion+=TipoRelaLaboConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiporelalabo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoRelaLaboDescripcion(TipoRelaLabo tiporelalabo,String sValor) throws Exception {			
		if(tiporelalabo !=null) {
			tiporelalabo.setcodigo(sValor);;//tiporelalabotiporelalabo.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoRelaLabo(TipoRelaLabo tiporelalabo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiporelalabo.setcodigo(tiporelalabo.getcodigo().trim());
		tiporelalabo.setnombre(tiporelalabo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoRelaLabos(List<TipoRelaLabo> tiporelalabos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoRelaLabo tiporelalabo: tiporelalabos) {
			tiporelalabo.setcodigo(tiporelalabo.getcodigo().trim());
			tiporelalabo.setnombre(tiporelalabo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRelaLabo(TipoRelaLabo tiporelalabo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiporelalabo.getConCambioAuxiliar()) {
			tiporelalabo.setIsDeleted(tiporelalabo.getIsDeletedAuxiliar());	
			tiporelalabo.setIsNew(tiporelalabo.getIsNewAuxiliar());	
			tiporelalabo.setIsChanged(tiporelalabo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiporelalabo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiporelalabo.setIsDeletedAuxiliar(false);	
			tiporelalabo.setIsNewAuxiliar(false);	
			tiporelalabo.setIsChangedAuxiliar(false);
			
			tiporelalabo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoRelaLabos(List<TipoRelaLabo> tiporelalabos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoRelaLabo tiporelalabo : tiporelalabos) {
			if(conAsignarBase && tiporelalabo.getConCambioAuxiliar()) {
				tiporelalabo.setIsDeleted(tiporelalabo.getIsDeletedAuxiliar());	
				tiporelalabo.setIsNew(tiporelalabo.getIsNewAuxiliar());	
				tiporelalabo.setIsChanged(tiporelalabo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiporelalabo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiporelalabo.setIsDeletedAuxiliar(false);	
				tiporelalabo.setIsNewAuxiliar(false);	
				tiporelalabo.setIsChangedAuxiliar(false);
				
				tiporelalabo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoRelaLabo(TipoRelaLabo tiporelalabo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoRelaLabos(List<TipoRelaLabo> tiporelalabos,Boolean conEnteros) throws Exception  {
		
		for(TipoRelaLabo tiporelalabo: tiporelalabos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoRelaLabo(List<TipoRelaLabo> tiporelalabos,TipoRelaLabo tiporelalaboAux) throws Exception  {
		TipoRelaLaboConstantesFunciones.InicializarValoresTipoRelaLabo(tiporelalaboAux,true);
		
		for(TipoRelaLabo tiporelalabo: tiporelalabos) {
			if(tiporelalabo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRelaLabo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoRelaLaboConstantesFunciones.getArrayColumnasGlobalesTipoRelaLabo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoRelaLabo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoRelaLaboConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoRelaLaboConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoRelaLabo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoRelaLabo> tiporelalabos,TipoRelaLabo tiporelalabo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoRelaLabo tiporelalaboAux: tiporelalabos) {
			if(tiporelalaboAux!=null && tiporelalabo!=null) {
				if((tiporelalaboAux.getId()==null && tiporelalabo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiporelalaboAux.getId()!=null && tiporelalabo.getId()!=null){
					if(tiporelalaboAux.getId().equals(tiporelalabo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoRelaLabo(List<TipoRelaLabo> tiporelalabos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoRelaLabo tiporelalabo: tiporelalabos) {			
			if(tiporelalabo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoRelaLabo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoRelaLaboConstantesFunciones.LABEL_ID, TipoRelaLaboConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRelaLaboConstantesFunciones.LABEL_VERSIONROW, TipoRelaLaboConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRelaLaboConstantesFunciones.LABEL_IDEMPRESA, TipoRelaLaboConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRelaLaboConstantesFunciones.LABEL_CODIGO, TipoRelaLaboConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoRelaLaboConstantesFunciones.LABEL_NOMBRE, TipoRelaLaboConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoRelaLabo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoRelaLaboConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRelaLaboConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRelaLaboConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRelaLaboConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoRelaLaboConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRelaLabo() throws Exception  {
		return TipoRelaLaboConstantesFunciones.getTiposSeleccionarTipoRelaLabo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRelaLabo(Boolean conFk) throws Exception  {
		return TipoRelaLaboConstantesFunciones.getTiposSeleccionarTipoRelaLabo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoRelaLabo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRelaLaboConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoRelaLaboConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRelaLaboConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoRelaLaboConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoRelaLaboConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoRelaLaboConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoRelaLabo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRelaLabo(TipoRelaLabo tiporelalaboAux) throws Exception {
		
			tiporelalaboAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiporelalaboAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoRelaLabo(List<TipoRelaLabo> tiporelalabosTemp) throws Exception {
		for(TipoRelaLabo tiporelalaboAux:tiporelalabosTemp) {
			
			tiporelalaboAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiporelalaboAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoRelaLabo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoRelaLabo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRelaLabo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRelaLaboConstantesFunciones.getClassesRelationshipsOfTipoRelaLabo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoRelaLabo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(InformacionLaboral.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(InformacionLaboral.class)) {
						classes.add(new Classe(InformacionLaboral.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRelaLabo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoRelaLaboConstantesFunciones.getClassesRelationshipsFromStringsOfTipoRelaLabo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoRelaLabo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(InformacionLaboral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(InformacionLaboral.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(InformacionLaboral.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(InformacionLaboral.class)); continue;
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
	public static void actualizarLista(TipoRelaLabo tiporelalabo,List<TipoRelaLabo> tiporelalabos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoRelaLabo tiporelalaboEncontrado=null;
			
			for(TipoRelaLabo tiporelalaboLocal:tiporelalabos) {
				if(tiporelalaboLocal.getId().equals(tiporelalabo.getId())) {
					tiporelalaboEncontrado=tiporelalaboLocal;
					
					tiporelalaboLocal.setIsChanged(tiporelalabo.getIsChanged());
					tiporelalaboLocal.setIsNew(tiporelalabo.getIsNew());
					tiporelalaboLocal.setIsDeleted(tiporelalabo.getIsDeleted());
					
					tiporelalaboLocal.setGeneralEntityOriginal(tiporelalabo.getGeneralEntityOriginal());
					
					tiporelalaboLocal.setId(tiporelalabo.getId());	
					tiporelalaboLocal.setVersionRow(tiporelalabo.getVersionRow());	
					tiporelalaboLocal.setid_empresa(tiporelalabo.getid_empresa());	
					tiporelalaboLocal.setcodigo(tiporelalabo.getcodigo());	
					tiporelalaboLocal.setnombre(tiporelalabo.getnombre());	
					
					
					tiporelalaboLocal.setInformacionLaborals(tiporelalabo.getInformacionLaborals());
					
					existe=true;
					break;
				}
			}
			
			if(!tiporelalabo.getIsDeleted()) {
				if(!existe) {
					tiporelalabos.add(tiporelalabo);
				}
			} else {
				if(tiporelalaboEncontrado!=null && permiteQuitar)  {
					tiporelalabos.remove(tiporelalaboEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoRelaLabo tiporelalabo,List<TipoRelaLabo> tiporelalabos) throws Exception {
		try	{			
			for(TipoRelaLabo tiporelalaboLocal:tiporelalabos) {
				if(tiporelalaboLocal.getId().equals(tiporelalabo.getId())) {
					tiporelalaboLocal.setIsSelected(tiporelalabo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoRelaLabo(List<TipoRelaLabo> tiporelalabosAux) throws Exception {
		//this.tiporelalabosAux=tiporelalabosAux;
		
		for(TipoRelaLabo tiporelalaboAux:tiporelalabosAux) {
			if(tiporelalaboAux.getIsChanged()) {
				tiporelalaboAux.setIsChanged(false);
			}		
			
			if(tiporelalaboAux.getIsNew()) {
				tiporelalaboAux.setIsNew(false);
			}	
			
			if(tiporelalaboAux.getIsDeleted()) {
				tiporelalaboAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoRelaLabo(TipoRelaLabo tiporelalaboAux) throws Exception {
		//this.tiporelalaboAux=tiporelalaboAux;
		
			if(tiporelalaboAux.getIsChanged()) {
				tiporelalaboAux.setIsChanged(false);
			}		
			
			if(tiporelalaboAux.getIsNew()) {
				tiporelalaboAux.setIsNew(false);
			}	
			
			if(tiporelalaboAux.getIsDeleted()) {
				tiporelalaboAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoRelaLabo tiporelalaboAsignar,TipoRelaLabo tiporelalabo) throws Exception {
		tiporelalaboAsignar.setId(tiporelalabo.getId());	
		tiporelalaboAsignar.setVersionRow(tiporelalabo.getVersionRow());	
		tiporelalaboAsignar.setid_empresa(tiporelalabo.getid_empresa());
		tiporelalaboAsignar.setempresa_descripcion(tiporelalabo.getempresa_descripcion());	
		tiporelalaboAsignar.setcodigo(tiporelalabo.getcodigo());	
		tiporelalaboAsignar.setnombre(tiporelalabo.getnombre());	
	}
	
	public static void inicializarTipoRelaLabo(TipoRelaLabo tiporelalabo) throws Exception {
		try {
				tiporelalabo.setId(0L);	
					
				tiporelalabo.setid_empresa(-1L);	
				tiporelalabo.setcodigo("");	
				tiporelalabo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoRelaLabo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRelaLaboConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRelaLaboConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoRelaLaboConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoRelaLabo(String sTipo,Row row,Workbook workbook,TipoRelaLabo tiporelalabo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporelalabo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporelalabo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiporelalabo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoRelaLabo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoRelaLabo() {
		return this.sFinalQueryTipoRelaLabo;
	}
	
	public void setsFinalQueryTipoRelaLabo(String sFinalQueryTipoRelaLabo) {
		this.sFinalQueryTipoRelaLabo= sFinalQueryTipoRelaLabo;
	}
	
	public Border resaltarSeleccionarTipoRelaLabo=null;
	
	public Border setResaltarSeleccionarTipoRelaLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRelaLaboBeanSwingJInternalFrame tiporelalaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiporelalaboBeanSwingJInternalFrame.jTtoolBarTipoRelaLabo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoRelaLabo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoRelaLabo() {
		return this.resaltarSeleccionarTipoRelaLabo;
	}
	
	public void setResaltarSeleccionarTipoRelaLabo(Border borderResaltarSeleccionarTipoRelaLabo) {
		this.resaltarSeleccionarTipoRelaLabo= borderResaltarSeleccionarTipoRelaLabo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoRelaLabo=null;
	public Boolean mostraridTipoRelaLabo=true;
	public Boolean activaridTipoRelaLabo=true;

	public Border resaltarid_empresaTipoRelaLabo=null;
	public Boolean mostrarid_empresaTipoRelaLabo=true;
	public Boolean activarid_empresaTipoRelaLabo=true;
	public Boolean cargarid_empresaTipoRelaLabo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoRelaLabo=false;//ConEventDepend=true

	public Border resaltarcodigoTipoRelaLabo=null;
	public Boolean mostrarcodigoTipoRelaLabo=true;
	public Boolean activarcodigoTipoRelaLabo=true;

	public Border resaltarnombreTipoRelaLabo=null;
	public Boolean mostrarnombreTipoRelaLabo=true;
	public Boolean activarnombreTipoRelaLabo=true;

	
	

	public Border setResaltaridTipoRelaLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRelaLaboBeanSwingJInternalFrame tiporelalaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporelalaboBeanSwingJInternalFrame.jTtoolBarTipoRelaLabo.setBorder(borderResaltar);
		
		this.resaltaridTipoRelaLabo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoRelaLabo() {
		return this.resaltaridTipoRelaLabo;
	}

	public void setResaltaridTipoRelaLabo(Border borderResaltar) {
		this.resaltaridTipoRelaLabo= borderResaltar;
	}

	public Boolean getMostraridTipoRelaLabo() {
		return this.mostraridTipoRelaLabo;
	}

	public void setMostraridTipoRelaLabo(Boolean mostraridTipoRelaLabo) {
		this.mostraridTipoRelaLabo= mostraridTipoRelaLabo;
	}

	public Boolean getActivaridTipoRelaLabo() {
		return this.activaridTipoRelaLabo;
	}

	public void setActivaridTipoRelaLabo(Boolean activaridTipoRelaLabo) {
		this.activaridTipoRelaLabo= activaridTipoRelaLabo;
	}

	public Border setResaltarid_empresaTipoRelaLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRelaLaboBeanSwingJInternalFrame tiporelalaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporelalaboBeanSwingJInternalFrame.jTtoolBarTipoRelaLabo.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoRelaLabo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoRelaLabo() {
		return this.resaltarid_empresaTipoRelaLabo;
	}

	public void setResaltarid_empresaTipoRelaLabo(Border borderResaltar) {
		this.resaltarid_empresaTipoRelaLabo= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoRelaLabo() {
		return this.mostrarid_empresaTipoRelaLabo;
	}

	public void setMostrarid_empresaTipoRelaLabo(Boolean mostrarid_empresaTipoRelaLabo) {
		this.mostrarid_empresaTipoRelaLabo= mostrarid_empresaTipoRelaLabo;
	}

	public Boolean getActivarid_empresaTipoRelaLabo() {
		return this.activarid_empresaTipoRelaLabo;
	}

	public void setActivarid_empresaTipoRelaLabo(Boolean activarid_empresaTipoRelaLabo) {
		this.activarid_empresaTipoRelaLabo= activarid_empresaTipoRelaLabo;
	}

	public Boolean getCargarid_empresaTipoRelaLabo() {
		return this.cargarid_empresaTipoRelaLabo;
	}

	public void setCargarid_empresaTipoRelaLabo(Boolean cargarid_empresaTipoRelaLabo) {
		this.cargarid_empresaTipoRelaLabo= cargarid_empresaTipoRelaLabo;
	}

	public Border setResaltarcodigoTipoRelaLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRelaLaboBeanSwingJInternalFrame tiporelalaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporelalaboBeanSwingJInternalFrame.jTtoolBarTipoRelaLabo.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoRelaLabo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoRelaLabo() {
		return this.resaltarcodigoTipoRelaLabo;
	}

	public void setResaltarcodigoTipoRelaLabo(Border borderResaltar) {
		this.resaltarcodigoTipoRelaLabo= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoRelaLabo() {
		return this.mostrarcodigoTipoRelaLabo;
	}

	public void setMostrarcodigoTipoRelaLabo(Boolean mostrarcodigoTipoRelaLabo) {
		this.mostrarcodigoTipoRelaLabo= mostrarcodigoTipoRelaLabo;
	}

	public Boolean getActivarcodigoTipoRelaLabo() {
		return this.activarcodigoTipoRelaLabo;
	}

	public void setActivarcodigoTipoRelaLabo(Boolean activarcodigoTipoRelaLabo) {
		this.activarcodigoTipoRelaLabo= activarcodigoTipoRelaLabo;
	}

	public Border setResaltarnombreTipoRelaLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRelaLaboBeanSwingJInternalFrame tiporelalaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiporelalaboBeanSwingJInternalFrame.jTtoolBarTipoRelaLabo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoRelaLabo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoRelaLabo() {
		return this.resaltarnombreTipoRelaLabo;
	}

	public void setResaltarnombreTipoRelaLabo(Border borderResaltar) {
		this.resaltarnombreTipoRelaLabo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoRelaLabo() {
		return this.mostrarnombreTipoRelaLabo;
	}

	public void setMostrarnombreTipoRelaLabo(Boolean mostrarnombreTipoRelaLabo) {
		this.mostrarnombreTipoRelaLabo= mostrarnombreTipoRelaLabo;
	}

	public Boolean getActivarnombreTipoRelaLabo() {
		return this.activarnombreTipoRelaLabo;
	}

	public void setActivarnombreTipoRelaLabo(Boolean activarnombreTipoRelaLabo) {
		this.activarnombreTipoRelaLabo= activarnombreTipoRelaLabo;
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
		
		
		this.setMostraridTipoRelaLabo(esInicial);
		this.setMostrarid_empresaTipoRelaLabo(esInicial);
		this.setMostrarcodigoTipoRelaLabo(esInicial);
		this.setMostrarnombreTipoRelaLabo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRelaLaboConstantesFunciones.ID)) {
				this.setMostraridTipoRelaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRelaLaboConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoRelaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRelaLaboConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoRelaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRelaLaboConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoRelaLabo(esAsigna);
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
		
		
		this.setActivaridTipoRelaLabo(esInicial);
		this.setActivarid_empresaTipoRelaLabo(esInicial);
		this.setActivarcodigoTipoRelaLabo(esInicial);
		this.setActivarnombreTipoRelaLabo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRelaLaboConstantesFunciones.ID)) {
				this.setActivaridTipoRelaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRelaLaboConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoRelaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRelaLaboConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoRelaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRelaLaboConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoRelaLabo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRelaLaboBeanSwingJInternalFrame tiporelalaboBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoRelaLabo(esInicial);
		this.setResaltarid_empresaTipoRelaLabo(esInicial);
		this.setResaltarcodigoTipoRelaLabo(esInicial);
		this.setResaltarnombreTipoRelaLabo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoRelaLaboConstantesFunciones.ID)) {
				this.setResaltaridTipoRelaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRelaLaboConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoRelaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRelaLaboConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoRelaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoRelaLaboConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoRelaLabo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarInformacionLaboralTipoRelaLabo=null;

	public Border getResaltarInformacionLaboralTipoRelaLabo() {
		return this.resaltarInformacionLaboralTipoRelaLabo;
	}

	public void setResaltarInformacionLaboralTipoRelaLabo(Border borderResaltarInformacionLaboral) {
		if(borderResaltarInformacionLaboral!=null) {
			this.resaltarInformacionLaboralTipoRelaLabo= borderResaltarInformacionLaboral;
		}
	}

	public Border setResaltarInformacionLaboralTipoRelaLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRelaLaboBeanSwingJInternalFrame tiporelalaboBeanSwingJInternalFrame*/) {
		Border borderResaltarInformacionLaboral=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiporelalaboBeanSwingJInternalFrame.jTtoolBarTipoRelaLabo.setBorder(borderResaltarInformacionLaboral);
			
		this.resaltarInformacionLaboralTipoRelaLabo= borderResaltarInformacionLaboral;

		 return borderResaltarInformacionLaboral;
	}



	public Boolean mostrarInformacionLaboralTipoRelaLabo=true;

	public Boolean getMostrarInformacionLaboralTipoRelaLabo() {
		return this.mostrarInformacionLaboralTipoRelaLabo;
	}

	public void setMostrarInformacionLaboralTipoRelaLabo(Boolean visibilidadResaltarInformacionLaboral) {
		this.mostrarInformacionLaboralTipoRelaLabo= visibilidadResaltarInformacionLaboral;
	}



	public Boolean activarInformacionLaboralTipoRelaLabo=true;

	public Boolean gethabilitarResaltarInformacionLaboralTipoRelaLabo() {
		return this.activarInformacionLaboralTipoRelaLabo;
	}

	public void setActivarInformacionLaboralTipoRelaLabo(Boolean habilitarResaltarInformacionLaboral) {
		this.activarInformacionLaboralTipoRelaLabo= habilitarResaltarInformacionLaboral;
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

		this.setMostrarInformacionLaboralTipoRelaLabo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionLaboral.class)) {
				this.setMostrarInformacionLaboralTipoRelaLabo(esAsigna);
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

		this.setActivarInformacionLaboralTipoRelaLabo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionLaboral.class)) {
				this.setActivarInformacionLaboralTipoRelaLabo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoRelaLaboBeanSwingJInternalFrame tiporelalaboBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarInformacionLaboralTipoRelaLabo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionLaboral.class)) {
				this.setResaltarInformacionLaboralTipoRelaLabo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoRelaLabo=true;

	public Boolean getMostrarFK_IdEmpresaTipoRelaLabo() {
		return this.mostrarFK_IdEmpresaTipoRelaLabo;
	}

	public void setMostrarFK_IdEmpresaTipoRelaLabo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoRelaLabo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoRelaLabo=true;

	public Boolean getActivarFK_IdEmpresaTipoRelaLabo() {
		return this.activarFK_IdEmpresaTipoRelaLabo;
	}

	public void setActivarFK_IdEmpresaTipoRelaLabo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoRelaLabo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoRelaLabo=null;

	public Border getResaltarFK_IdEmpresaTipoRelaLabo() {
		return this.resaltarFK_IdEmpresaTipoRelaLabo;
	}

	public void setResaltarFK_IdEmpresaTipoRelaLabo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoRelaLabo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoRelaLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoRelaLaboBeanSwingJInternalFrame tiporelalaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoRelaLabo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}