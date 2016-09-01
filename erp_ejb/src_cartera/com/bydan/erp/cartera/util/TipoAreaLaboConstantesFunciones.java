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


import com.bydan.erp.cartera.util.TipoAreaLaboConstantesFunciones;
import com.bydan.erp.cartera.util.TipoAreaLaboParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoAreaLaboParameterGeneral;

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
final public class TipoAreaLaboConstantesFunciones extends TipoAreaLaboConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoAreaLabo";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoAreaLabo"+TipoAreaLaboConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoAreaLaboHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoAreaLaboHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoAreaLaboConstantesFunciones.SCHEMA+"_"+TipoAreaLaboConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoAreaLaboHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoAreaLaboConstantesFunciones.SCHEMA+"_"+TipoAreaLaboConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoAreaLaboConstantesFunciones.SCHEMA+"_"+TipoAreaLaboConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoAreaLaboHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoAreaLaboConstantesFunciones.SCHEMA+"_"+TipoAreaLaboConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAreaLaboConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoAreaLaboHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAreaLaboConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAreaLaboConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoAreaLaboHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoAreaLaboConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoAreaLaboConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoAreaLaboConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoAreaLaboConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoAreaLaboConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Area Labos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Area Labo";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Area Labo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoAreaLabo";
	public static final String OBJECTNAME="tipoarealabo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_area_labo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoarealabo from "+TipoAreaLaboConstantesFunciones.SPERSISTENCENAME+" tipoarealabo";
	public static String QUERYSELECTNATIVE="select "+TipoAreaLaboConstantesFunciones.SCHEMA+"."+TipoAreaLaboConstantesFunciones.TABLENAME+".id,"+TipoAreaLaboConstantesFunciones.SCHEMA+"."+TipoAreaLaboConstantesFunciones.TABLENAME+".version_row,"+TipoAreaLaboConstantesFunciones.SCHEMA+"."+TipoAreaLaboConstantesFunciones.TABLENAME+".id_empresa,"+TipoAreaLaboConstantesFunciones.SCHEMA+"."+TipoAreaLaboConstantesFunciones.TABLENAME+".codigo,"+TipoAreaLaboConstantesFunciones.SCHEMA+"."+TipoAreaLaboConstantesFunciones.TABLENAME+".nombre from "+TipoAreaLaboConstantesFunciones.SCHEMA+"."+TipoAreaLaboConstantesFunciones.TABLENAME;//+" as "+TipoAreaLaboConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoAreaLaboConstantesFuncionesAdditional tipoarealaboConstantesFuncionesAdditional=null;
	
	public TipoAreaLaboConstantesFuncionesAdditional getTipoAreaLaboConstantesFuncionesAdditional() {
		return this.tipoarealaboConstantesFuncionesAdditional;
	}
	
	public void setTipoAreaLaboConstantesFuncionesAdditional(TipoAreaLaboConstantesFuncionesAdditional tipoarealaboConstantesFuncionesAdditional) {
		try {
			this.tipoarealaboConstantesFuncionesAdditional=tipoarealaboConstantesFuncionesAdditional;
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
	
	public static String getTipoAreaLaboLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoAreaLaboConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoAreaLaboConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoAreaLaboConstantesFunciones.CODIGO)) {sLabelColumna=TipoAreaLaboConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoAreaLaboConstantesFunciones.NOMBRE)) {sLabelColumna=TipoAreaLaboConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoAreaLaboDescripcion(TipoAreaLabo tipoarealabo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoarealabo !=null/* && tipoarealabo.getId()!=0*/) {
			sDescripcion=tipoarealabo.getcodigo();//tipoarealabotipoarealabo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoAreaLaboDescripcionDetallado(TipoAreaLabo tipoarealabo) {
		String sDescripcion="";
			
		sDescripcion+=TipoAreaLaboConstantesFunciones.ID+"=";
		sDescripcion+=tipoarealabo.getId().toString()+",";
		sDescripcion+=TipoAreaLaboConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoarealabo.getVersionRow().toString()+",";
		sDescripcion+=TipoAreaLaboConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoarealabo.getid_empresa().toString()+",";
		sDescripcion+=TipoAreaLaboConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoarealabo.getcodigo()+",";
		sDescripcion+=TipoAreaLaboConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoarealabo.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoAreaLaboDescripcion(TipoAreaLabo tipoarealabo,String sValor) throws Exception {			
		if(tipoarealabo !=null) {
			tipoarealabo.setcodigo(sValor);;//tipoarealabotipoarealabo.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoAreaLabo(TipoAreaLabo tipoarealabo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoarealabo.setcodigo(tipoarealabo.getcodigo().trim());
		tipoarealabo.setnombre(tipoarealabo.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoAreaLabos(List<TipoAreaLabo> tipoarealabos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoAreaLabo tipoarealabo: tipoarealabos) {
			tipoarealabo.setcodigo(tipoarealabo.getcodigo().trim());
			tipoarealabo.setnombre(tipoarealabo.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoAreaLabo(TipoAreaLabo tipoarealabo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoarealabo.getConCambioAuxiliar()) {
			tipoarealabo.setIsDeleted(tipoarealabo.getIsDeletedAuxiliar());	
			tipoarealabo.setIsNew(tipoarealabo.getIsNewAuxiliar());	
			tipoarealabo.setIsChanged(tipoarealabo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoarealabo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoarealabo.setIsDeletedAuxiliar(false);	
			tipoarealabo.setIsNewAuxiliar(false);	
			tipoarealabo.setIsChangedAuxiliar(false);
			
			tipoarealabo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoAreaLabos(List<TipoAreaLabo> tipoarealabos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoAreaLabo tipoarealabo : tipoarealabos) {
			if(conAsignarBase && tipoarealabo.getConCambioAuxiliar()) {
				tipoarealabo.setIsDeleted(tipoarealabo.getIsDeletedAuxiliar());	
				tipoarealabo.setIsNew(tipoarealabo.getIsNewAuxiliar());	
				tipoarealabo.setIsChanged(tipoarealabo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoarealabo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoarealabo.setIsDeletedAuxiliar(false);	
				tipoarealabo.setIsNewAuxiliar(false);	
				tipoarealabo.setIsChangedAuxiliar(false);
				
				tipoarealabo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoAreaLabo(TipoAreaLabo tipoarealabo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoAreaLabos(List<TipoAreaLabo> tipoarealabos,Boolean conEnteros) throws Exception  {
		
		for(TipoAreaLabo tipoarealabo: tipoarealabos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoAreaLabo(List<TipoAreaLabo> tipoarealabos,TipoAreaLabo tipoarealaboAux) throws Exception  {
		TipoAreaLaboConstantesFunciones.InicializarValoresTipoAreaLabo(tipoarealaboAux,true);
		
		for(TipoAreaLabo tipoarealabo: tipoarealabos) {
			if(tipoarealabo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoAreaLabo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoAreaLaboConstantesFunciones.getArrayColumnasGlobalesTipoAreaLabo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoAreaLabo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoAreaLaboConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoAreaLaboConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoAreaLabo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoAreaLabo> tipoarealabos,TipoAreaLabo tipoarealabo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoAreaLabo tipoarealaboAux: tipoarealabos) {
			if(tipoarealaboAux!=null && tipoarealabo!=null) {
				if((tipoarealaboAux.getId()==null && tipoarealabo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoarealaboAux.getId()!=null && tipoarealabo.getId()!=null){
					if(tipoarealaboAux.getId().equals(tipoarealabo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoAreaLabo(List<TipoAreaLabo> tipoarealabos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoAreaLabo tipoarealabo: tipoarealabos) {			
			if(tipoarealabo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoAreaLabo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoAreaLaboConstantesFunciones.LABEL_ID, TipoAreaLaboConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAreaLaboConstantesFunciones.LABEL_VERSIONROW, TipoAreaLaboConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAreaLaboConstantesFunciones.LABEL_IDEMPRESA, TipoAreaLaboConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAreaLaboConstantesFunciones.LABEL_CODIGO, TipoAreaLaboConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoAreaLaboConstantesFunciones.LABEL_NOMBRE, TipoAreaLaboConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoAreaLabo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoAreaLaboConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAreaLaboConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAreaLaboConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAreaLaboConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoAreaLaboConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAreaLabo() throws Exception  {
		return TipoAreaLaboConstantesFunciones.getTiposSeleccionarTipoAreaLabo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAreaLabo(Boolean conFk) throws Exception  {
		return TipoAreaLaboConstantesFunciones.getTiposSeleccionarTipoAreaLabo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoAreaLabo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAreaLaboConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoAreaLaboConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAreaLaboConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoAreaLaboConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoAreaLaboConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoAreaLaboConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoAreaLabo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoAreaLabo(TipoAreaLabo tipoarealaboAux) throws Exception {
		
			tipoarealaboAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoarealaboAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoAreaLabo(List<TipoAreaLabo> tipoarealabosTemp) throws Exception {
		for(TipoAreaLabo tipoarealaboAux:tipoarealabosTemp) {
			
			tipoarealaboAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoarealaboAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoAreaLabo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoAreaLabo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAreaLabo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoAreaLaboConstantesFunciones.getClassesRelationshipsOfTipoAreaLabo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoAreaLabo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoAreaLabo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoAreaLaboConstantesFunciones.getClassesRelationshipsFromStringsOfTipoAreaLabo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoAreaLabo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoAreaLabo tipoarealabo,List<TipoAreaLabo> tipoarealabos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoAreaLabo tipoarealaboEncontrado=null;
			
			for(TipoAreaLabo tipoarealaboLocal:tipoarealabos) {
				if(tipoarealaboLocal.getId().equals(tipoarealabo.getId())) {
					tipoarealaboEncontrado=tipoarealaboLocal;
					
					tipoarealaboLocal.setIsChanged(tipoarealabo.getIsChanged());
					tipoarealaboLocal.setIsNew(tipoarealabo.getIsNew());
					tipoarealaboLocal.setIsDeleted(tipoarealabo.getIsDeleted());
					
					tipoarealaboLocal.setGeneralEntityOriginal(tipoarealabo.getGeneralEntityOriginal());
					
					tipoarealaboLocal.setId(tipoarealabo.getId());	
					tipoarealaboLocal.setVersionRow(tipoarealabo.getVersionRow());	
					tipoarealaboLocal.setid_empresa(tipoarealabo.getid_empresa());	
					tipoarealaboLocal.setcodigo(tipoarealabo.getcodigo());	
					tipoarealaboLocal.setnombre(tipoarealabo.getnombre());	
					
					
					tipoarealaboLocal.setInformacionLaborals(tipoarealabo.getInformacionLaborals());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoarealabo.getIsDeleted()) {
				if(!existe) {
					tipoarealabos.add(tipoarealabo);
				}
			} else {
				if(tipoarealaboEncontrado!=null && permiteQuitar)  {
					tipoarealabos.remove(tipoarealaboEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoAreaLabo tipoarealabo,List<TipoAreaLabo> tipoarealabos) throws Exception {
		try	{			
			for(TipoAreaLabo tipoarealaboLocal:tipoarealabos) {
				if(tipoarealaboLocal.getId().equals(tipoarealabo.getId())) {
					tipoarealaboLocal.setIsSelected(tipoarealabo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoAreaLabo(List<TipoAreaLabo> tipoarealabosAux) throws Exception {
		//this.tipoarealabosAux=tipoarealabosAux;
		
		for(TipoAreaLabo tipoarealaboAux:tipoarealabosAux) {
			if(tipoarealaboAux.getIsChanged()) {
				tipoarealaboAux.setIsChanged(false);
			}		
			
			if(tipoarealaboAux.getIsNew()) {
				tipoarealaboAux.setIsNew(false);
			}	
			
			if(tipoarealaboAux.getIsDeleted()) {
				tipoarealaboAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoAreaLabo(TipoAreaLabo tipoarealaboAux) throws Exception {
		//this.tipoarealaboAux=tipoarealaboAux;
		
			if(tipoarealaboAux.getIsChanged()) {
				tipoarealaboAux.setIsChanged(false);
			}		
			
			if(tipoarealaboAux.getIsNew()) {
				tipoarealaboAux.setIsNew(false);
			}	
			
			if(tipoarealaboAux.getIsDeleted()) {
				tipoarealaboAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoAreaLabo tipoarealaboAsignar,TipoAreaLabo tipoarealabo) throws Exception {
		tipoarealaboAsignar.setId(tipoarealabo.getId());	
		tipoarealaboAsignar.setVersionRow(tipoarealabo.getVersionRow());	
		tipoarealaboAsignar.setid_empresa(tipoarealabo.getid_empresa());
		tipoarealaboAsignar.setempresa_descripcion(tipoarealabo.getempresa_descripcion());	
		tipoarealaboAsignar.setcodigo(tipoarealabo.getcodigo());	
		tipoarealaboAsignar.setnombre(tipoarealabo.getnombre());	
	}
	
	public static void inicializarTipoAreaLabo(TipoAreaLabo tipoarealabo) throws Exception {
		try {
				tipoarealabo.setId(0L);	
					
				tipoarealabo.setid_empresa(-1L);	
				tipoarealabo.setcodigo("");	
				tipoarealabo.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoAreaLabo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAreaLaboConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAreaLaboConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoAreaLaboConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoAreaLabo(String sTipo,Row row,Workbook workbook,TipoAreaLabo tipoarealabo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoarealabo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoarealabo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoarealabo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoAreaLabo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoAreaLabo() {
		return this.sFinalQueryTipoAreaLabo;
	}
	
	public void setsFinalQueryTipoAreaLabo(String sFinalQueryTipoAreaLabo) {
		this.sFinalQueryTipoAreaLabo= sFinalQueryTipoAreaLabo;
	}
	
	public Border resaltarSeleccionarTipoAreaLabo=null;
	
	public Border setResaltarSeleccionarTipoAreaLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaLaboBeanSwingJInternalFrame tipoarealaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoarealaboBeanSwingJInternalFrame.jTtoolBarTipoAreaLabo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoAreaLabo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoAreaLabo() {
		return this.resaltarSeleccionarTipoAreaLabo;
	}
	
	public void setResaltarSeleccionarTipoAreaLabo(Border borderResaltarSeleccionarTipoAreaLabo) {
		this.resaltarSeleccionarTipoAreaLabo= borderResaltarSeleccionarTipoAreaLabo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoAreaLabo=null;
	public Boolean mostraridTipoAreaLabo=true;
	public Boolean activaridTipoAreaLabo=true;

	public Border resaltarid_empresaTipoAreaLabo=null;
	public Boolean mostrarid_empresaTipoAreaLabo=true;
	public Boolean activarid_empresaTipoAreaLabo=true;
	public Boolean cargarid_empresaTipoAreaLabo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoAreaLabo=false;//ConEventDepend=true

	public Border resaltarcodigoTipoAreaLabo=null;
	public Boolean mostrarcodigoTipoAreaLabo=true;
	public Boolean activarcodigoTipoAreaLabo=true;

	public Border resaltarnombreTipoAreaLabo=null;
	public Boolean mostrarnombreTipoAreaLabo=true;
	public Boolean activarnombreTipoAreaLabo=true;

	
	

	public Border setResaltaridTipoAreaLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaLaboBeanSwingJInternalFrame tipoarealaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoarealaboBeanSwingJInternalFrame.jTtoolBarTipoAreaLabo.setBorder(borderResaltar);
		
		this.resaltaridTipoAreaLabo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoAreaLabo() {
		return this.resaltaridTipoAreaLabo;
	}

	public void setResaltaridTipoAreaLabo(Border borderResaltar) {
		this.resaltaridTipoAreaLabo= borderResaltar;
	}

	public Boolean getMostraridTipoAreaLabo() {
		return this.mostraridTipoAreaLabo;
	}

	public void setMostraridTipoAreaLabo(Boolean mostraridTipoAreaLabo) {
		this.mostraridTipoAreaLabo= mostraridTipoAreaLabo;
	}

	public Boolean getActivaridTipoAreaLabo() {
		return this.activaridTipoAreaLabo;
	}

	public void setActivaridTipoAreaLabo(Boolean activaridTipoAreaLabo) {
		this.activaridTipoAreaLabo= activaridTipoAreaLabo;
	}

	public Border setResaltarid_empresaTipoAreaLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaLaboBeanSwingJInternalFrame tipoarealaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoarealaboBeanSwingJInternalFrame.jTtoolBarTipoAreaLabo.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoAreaLabo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoAreaLabo() {
		return this.resaltarid_empresaTipoAreaLabo;
	}

	public void setResaltarid_empresaTipoAreaLabo(Border borderResaltar) {
		this.resaltarid_empresaTipoAreaLabo= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoAreaLabo() {
		return this.mostrarid_empresaTipoAreaLabo;
	}

	public void setMostrarid_empresaTipoAreaLabo(Boolean mostrarid_empresaTipoAreaLabo) {
		this.mostrarid_empresaTipoAreaLabo= mostrarid_empresaTipoAreaLabo;
	}

	public Boolean getActivarid_empresaTipoAreaLabo() {
		return this.activarid_empresaTipoAreaLabo;
	}

	public void setActivarid_empresaTipoAreaLabo(Boolean activarid_empresaTipoAreaLabo) {
		this.activarid_empresaTipoAreaLabo= activarid_empresaTipoAreaLabo;
	}

	public Boolean getCargarid_empresaTipoAreaLabo() {
		return this.cargarid_empresaTipoAreaLabo;
	}

	public void setCargarid_empresaTipoAreaLabo(Boolean cargarid_empresaTipoAreaLabo) {
		this.cargarid_empresaTipoAreaLabo= cargarid_empresaTipoAreaLabo;
	}

	public Border setResaltarcodigoTipoAreaLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaLaboBeanSwingJInternalFrame tipoarealaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoarealaboBeanSwingJInternalFrame.jTtoolBarTipoAreaLabo.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoAreaLabo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoAreaLabo() {
		return this.resaltarcodigoTipoAreaLabo;
	}

	public void setResaltarcodigoTipoAreaLabo(Border borderResaltar) {
		this.resaltarcodigoTipoAreaLabo= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoAreaLabo() {
		return this.mostrarcodigoTipoAreaLabo;
	}

	public void setMostrarcodigoTipoAreaLabo(Boolean mostrarcodigoTipoAreaLabo) {
		this.mostrarcodigoTipoAreaLabo= mostrarcodigoTipoAreaLabo;
	}

	public Boolean getActivarcodigoTipoAreaLabo() {
		return this.activarcodigoTipoAreaLabo;
	}

	public void setActivarcodigoTipoAreaLabo(Boolean activarcodigoTipoAreaLabo) {
		this.activarcodigoTipoAreaLabo= activarcodigoTipoAreaLabo;
	}

	public Border setResaltarnombreTipoAreaLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaLaboBeanSwingJInternalFrame tipoarealaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoarealaboBeanSwingJInternalFrame.jTtoolBarTipoAreaLabo.setBorder(borderResaltar);
		
		this.resaltarnombreTipoAreaLabo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoAreaLabo() {
		return this.resaltarnombreTipoAreaLabo;
	}

	public void setResaltarnombreTipoAreaLabo(Border borderResaltar) {
		this.resaltarnombreTipoAreaLabo= borderResaltar;
	}

	public Boolean getMostrarnombreTipoAreaLabo() {
		return this.mostrarnombreTipoAreaLabo;
	}

	public void setMostrarnombreTipoAreaLabo(Boolean mostrarnombreTipoAreaLabo) {
		this.mostrarnombreTipoAreaLabo= mostrarnombreTipoAreaLabo;
	}

	public Boolean getActivarnombreTipoAreaLabo() {
		return this.activarnombreTipoAreaLabo;
	}

	public void setActivarnombreTipoAreaLabo(Boolean activarnombreTipoAreaLabo) {
		this.activarnombreTipoAreaLabo= activarnombreTipoAreaLabo;
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
		
		
		this.setMostraridTipoAreaLabo(esInicial);
		this.setMostrarid_empresaTipoAreaLabo(esInicial);
		this.setMostrarcodigoTipoAreaLabo(esInicial);
		this.setMostrarnombreTipoAreaLabo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAreaLaboConstantesFunciones.ID)) {
				this.setMostraridTipoAreaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaLaboConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoAreaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaLaboConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoAreaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaLaboConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoAreaLabo(esAsigna);
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
		
		
		this.setActivaridTipoAreaLabo(esInicial);
		this.setActivarid_empresaTipoAreaLabo(esInicial);
		this.setActivarcodigoTipoAreaLabo(esInicial);
		this.setActivarnombreTipoAreaLabo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAreaLaboConstantesFunciones.ID)) {
				this.setActivaridTipoAreaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaLaboConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoAreaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaLaboConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoAreaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaLaboConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoAreaLabo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoAreaLaboBeanSwingJInternalFrame tipoarealaboBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoAreaLabo(esInicial);
		this.setResaltarid_empresaTipoAreaLabo(esInicial);
		this.setResaltarcodigoTipoAreaLabo(esInicial);
		this.setResaltarnombreTipoAreaLabo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoAreaLaboConstantesFunciones.ID)) {
				this.setResaltaridTipoAreaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaLaboConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoAreaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaLaboConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoAreaLabo(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoAreaLaboConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoAreaLabo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarInformacionLaboralTipoAreaLabo=null;

	public Border getResaltarInformacionLaboralTipoAreaLabo() {
		return this.resaltarInformacionLaboralTipoAreaLabo;
	}

	public void setResaltarInformacionLaboralTipoAreaLabo(Border borderResaltarInformacionLaboral) {
		if(borderResaltarInformacionLaboral!=null) {
			this.resaltarInformacionLaboralTipoAreaLabo= borderResaltarInformacionLaboral;
		}
	}

	public Border setResaltarInformacionLaboralTipoAreaLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaLaboBeanSwingJInternalFrame tipoarealaboBeanSwingJInternalFrame*/) {
		Border borderResaltarInformacionLaboral=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoarealaboBeanSwingJInternalFrame.jTtoolBarTipoAreaLabo.setBorder(borderResaltarInformacionLaboral);
			
		this.resaltarInformacionLaboralTipoAreaLabo= borderResaltarInformacionLaboral;

		 return borderResaltarInformacionLaboral;
	}



	public Boolean mostrarInformacionLaboralTipoAreaLabo=true;

	public Boolean getMostrarInformacionLaboralTipoAreaLabo() {
		return this.mostrarInformacionLaboralTipoAreaLabo;
	}

	public void setMostrarInformacionLaboralTipoAreaLabo(Boolean visibilidadResaltarInformacionLaboral) {
		this.mostrarInformacionLaboralTipoAreaLabo= visibilidadResaltarInformacionLaboral;
	}



	public Boolean activarInformacionLaboralTipoAreaLabo=true;

	public Boolean gethabilitarResaltarInformacionLaboralTipoAreaLabo() {
		return this.activarInformacionLaboralTipoAreaLabo;
	}

	public void setActivarInformacionLaboralTipoAreaLabo(Boolean habilitarResaltarInformacionLaboral) {
		this.activarInformacionLaboralTipoAreaLabo= habilitarResaltarInformacionLaboral;
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

		this.setMostrarInformacionLaboralTipoAreaLabo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionLaboral.class)) {
				this.setMostrarInformacionLaboralTipoAreaLabo(esAsigna);
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

		this.setActivarInformacionLaboralTipoAreaLabo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionLaboral.class)) {
				this.setActivarInformacionLaboralTipoAreaLabo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoAreaLaboBeanSwingJInternalFrame tipoarealaboBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarInformacionLaboralTipoAreaLabo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionLaboral.class)) {
				this.setResaltarInformacionLaboralTipoAreaLabo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoAreaLabo=true;

	public Boolean getMostrarFK_IdEmpresaTipoAreaLabo() {
		return this.mostrarFK_IdEmpresaTipoAreaLabo;
	}

	public void setMostrarFK_IdEmpresaTipoAreaLabo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoAreaLabo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoAreaLabo=true;

	public Boolean getActivarFK_IdEmpresaTipoAreaLabo() {
		return this.activarFK_IdEmpresaTipoAreaLabo;
	}

	public void setActivarFK_IdEmpresaTipoAreaLabo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoAreaLabo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoAreaLabo=null;

	public Border getResaltarFK_IdEmpresaTipoAreaLabo() {
		return this.resaltarFK_IdEmpresaTipoAreaLabo;
	}

	public void setResaltarFK_IdEmpresaTipoAreaLabo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoAreaLabo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoAreaLabo(ParametroGeneralUsuario parametroGeneralUsuario/*TipoAreaLaboBeanSwingJInternalFrame tipoarealaboBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoAreaLabo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}