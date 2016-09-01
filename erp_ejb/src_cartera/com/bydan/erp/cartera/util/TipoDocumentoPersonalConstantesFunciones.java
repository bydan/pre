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


import com.bydan.erp.cartera.util.TipoDocumentoPersonalConstantesFunciones;
import com.bydan.erp.cartera.util.TipoDocumentoPersonalParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoDocumentoPersonalParameterGeneral;

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
final public class TipoDocumentoPersonalConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDocumentoPersonal";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDocumentoPersonal"+TipoDocumentoPersonalConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDocumentoPersonalHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDocumentoPersonalHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDocumentoPersonalConstantesFunciones.SCHEMA+"_"+TipoDocumentoPersonalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDocumentoPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDocumentoPersonalConstantesFunciones.SCHEMA+"_"+TipoDocumentoPersonalConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDocumentoPersonalConstantesFunciones.SCHEMA+"_"+TipoDocumentoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDocumentoPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDocumentoPersonalConstantesFunciones.SCHEMA+"_"+TipoDocumentoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDocumentoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDocumentoPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDocumentoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDocumentoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDocumentoPersonalHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDocumentoPersonalConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDocumentoPersonalConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDocumentoPersonalConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDocumentoPersonalConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDocumentoPersonalConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Documento Personals";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Documento Personal";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Documento Personal";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDocumentoPersonal";
	public static final String OBJECTNAME="tipodocumentopersonal";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_documento_personal";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodocumentopersonal from "+TipoDocumentoPersonalConstantesFunciones.SPERSISTENCENAME+" tipodocumentopersonal";
	public static String QUERYSELECTNATIVE="select "+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+".id,"+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+".version_row,"+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+".id_pais,"+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+".codigo,"+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME+".nombre from "+TipoDocumentoPersonalConstantesFunciones.SCHEMA+"."+TipoDocumentoPersonalConstantesFunciones.TABLENAME;//+" as "+TipoDocumentoPersonalConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDPAIS= "id_pais";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDPAIS= "Pais";
		public static final String LABEL_IDPAIS_LOWER= "Pais";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoDocumentoPersonalLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDocumentoPersonalConstantesFunciones.IDPAIS)) {sLabelColumna=TipoDocumentoPersonalConstantesFunciones.LABEL_IDPAIS;}
		if(sNombreColumna.equals(TipoDocumentoPersonalConstantesFunciones.CODIGO)) {sLabelColumna=TipoDocumentoPersonalConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoDocumentoPersonalConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDocumentoPersonalConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoDocumentoPersonalDescripcion(TipoDocumentoPersonal tipodocumentopersonal) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodocumentopersonal !=null/* && tipodocumentopersonal.getId()!=0*/) {
			sDescripcion=tipodocumentopersonal.getcodigo();//tipodocumentopersonaltipodocumentopersonal.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDocumentoPersonalDescripcionDetallado(TipoDocumentoPersonal tipodocumentopersonal) {
		String sDescripcion="";
			
		sDescripcion+=TipoDocumentoPersonalConstantesFunciones.ID+"=";
		sDescripcion+=tipodocumentopersonal.getId().toString()+",";
		sDescripcion+=TipoDocumentoPersonalConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodocumentopersonal.getVersionRow().toString()+",";
		sDescripcion+=TipoDocumentoPersonalConstantesFunciones.IDPAIS+"=";
		sDescripcion+=tipodocumentopersonal.getid_pais().toString()+",";
		sDescripcion+=TipoDocumentoPersonalConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipodocumentopersonal.getcodigo()+",";
		sDescripcion+=TipoDocumentoPersonalConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodocumentopersonal.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDocumentoPersonalDescripcion(TipoDocumentoPersonal tipodocumentopersonal,String sValor) throws Exception {			
		if(tipodocumentopersonal !=null) {
			tipodocumentopersonal.setcodigo(sValor);;//tipodocumentopersonaltipodocumentopersonal.getcodigo().trim();
		}		
	}
	
		

	public static String getPaisDescripcion(Pais pais) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(pais!=null/*&&pais.getId()>0*/) {
			sDescripcion=PaisConstantesFunciones.getPaisDescripcion(pais);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdPais")) {
			sNombreIndice="Tipo=  Por Pais";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdPais(Long id_pais) {
		String sDetalleIndice=" Parametros->";
		if(id_pais!=null) {sDetalleIndice+=" Codigo Unico De Pais="+id_pais.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoDocumentoPersonal(TipoDocumentoPersonal tipodocumentopersonal,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodocumentopersonal.setcodigo(tipodocumentopersonal.getcodigo().trim());
		tipodocumentopersonal.setnombre(tipodocumentopersonal.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDocumentoPersonals(List<TipoDocumentoPersonal> tipodocumentopersonals,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDocumentoPersonal tipodocumentopersonal: tipodocumentopersonals) {
			tipodocumentopersonal.setcodigo(tipodocumentopersonal.getcodigo().trim());
			tipodocumentopersonal.setnombre(tipodocumentopersonal.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDocumentoPersonal(TipoDocumentoPersonal tipodocumentopersonal,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodocumentopersonal.getConCambioAuxiliar()) {
			tipodocumentopersonal.setIsDeleted(tipodocumentopersonal.getIsDeletedAuxiliar());	
			tipodocumentopersonal.setIsNew(tipodocumentopersonal.getIsNewAuxiliar());	
			tipodocumentopersonal.setIsChanged(tipodocumentopersonal.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodocumentopersonal.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodocumentopersonal.setIsDeletedAuxiliar(false);	
			tipodocumentopersonal.setIsNewAuxiliar(false);	
			tipodocumentopersonal.setIsChangedAuxiliar(false);
			
			tipodocumentopersonal.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDocumentoPersonals(List<TipoDocumentoPersonal> tipodocumentopersonals,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDocumentoPersonal tipodocumentopersonal : tipodocumentopersonals) {
			if(conAsignarBase && tipodocumentopersonal.getConCambioAuxiliar()) {
				tipodocumentopersonal.setIsDeleted(tipodocumentopersonal.getIsDeletedAuxiliar());	
				tipodocumentopersonal.setIsNew(tipodocumentopersonal.getIsNewAuxiliar());	
				tipodocumentopersonal.setIsChanged(tipodocumentopersonal.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodocumentopersonal.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodocumentopersonal.setIsDeletedAuxiliar(false);	
				tipodocumentopersonal.setIsNewAuxiliar(false);	
				tipodocumentopersonal.setIsChangedAuxiliar(false);
				
				tipodocumentopersonal.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDocumentoPersonal(TipoDocumentoPersonal tipodocumentopersonal,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDocumentoPersonals(List<TipoDocumentoPersonal> tipodocumentopersonals,Boolean conEnteros) throws Exception  {
		
		for(TipoDocumentoPersonal tipodocumentopersonal: tipodocumentopersonals) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDocumentoPersonal(List<TipoDocumentoPersonal> tipodocumentopersonals,TipoDocumentoPersonal tipodocumentopersonalAux) throws Exception  {
		TipoDocumentoPersonalConstantesFunciones.InicializarValoresTipoDocumentoPersonal(tipodocumentopersonalAux,true);
		
		for(TipoDocumentoPersonal tipodocumentopersonal: tipodocumentopersonals) {
			if(tipodocumentopersonal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDocumentoPersonal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDocumentoPersonalConstantesFunciones.getArrayColumnasGlobalesTipoDocumentoPersonal(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDocumentoPersonal(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDocumentoPersonal(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDocumentoPersonal> tipodocumentopersonals,TipoDocumentoPersonal tipodocumentopersonal,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDocumentoPersonal tipodocumentopersonalAux: tipodocumentopersonals) {
			if(tipodocumentopersonalAux!=null && tipodocumentopersonal!=null) {
				if((tipodocumentopersonalAux.getId()==null && tipodocumentopersonal.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodocumentopersonalAux.getId()!=null && tipodocumentopersonal.getId()!=null){
					if(tipodocumentopersonalAux.getId().equals(tipodocumentopersonal.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDocumentoPersonal(List<TipoDocumentoPersonal> tipodocumentopersonals) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoDocumentoPersonal tipodocumentopersonal: tipodocumentopersonals) {			
			if(tipodocumentopersonal.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDocumentoPersonal() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDocumentoPersonalConstantesFunciones.LABEL_ID, TipoDocumentoPersonalConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoPersonalConstantesFunciones.LABEL_VERSIONROW, TipoDocumentoPersonalConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoPersonalConstantesFunciones.LABEL_IDPAIS, TipoDocumentoPersonalConstantesFunciones.IDPAIS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoPersonalConstantesFunciones.LABEL_CODIGO, TipoDocumentoPersonalConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDocumentoPersonalConstantesFunciones.LABEL_NOMBRE, TipoDocumentoPersonalConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDocumentoPersonal() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoPersonalConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoPersonalConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoPersonalConstantesFunciones.IDPAIS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoPersonalConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDocumentoPersonalConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDocumentoPersonal() throws Exception  {
		return TipoDocumentoPersonalConstantesFunciones.getTiposSeleccionarTipoDocumentoPersonal(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDocumentoPersonal(Boolean conFk) throws Exception  {
		return TipoDocumentoPersonalConstantesFunciones.getTiposSeleccionarTipoDocumentoPersonal(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDocumentoPersonal(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDocumentoPersonalConstantesFunciones.LABEL_IDPAIS);
			reporte.setsDescripcion(TipoDocumentoPersonalConstantesFunciones.LABEL_IDPAIS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDocumentoPersonalConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoDocumentoPersonalConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDocumentoPersonalConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDocumentoPersonalConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDocumentoPersonal(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDocumentoPersonal(TipoDocumentoPersonal tipodocumentopersonalAux) throws Exception {
		
			tipodocumentopersonalAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipodocumentopersonalAux.getPais()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDocumentoPersonal(List<TipoDocumentoPersonal> tipodocumentopersonalsTemp) throws Exception {
		for(TipoDocumentoPersonal tipodocumentopersonalAux:tipodocumentopersonalsTemp) {
			
			tipodocumentopersonalAux.setpais_descripcion(PaisConstantesFunciones.getPaisDescripcion(tipodocumentopersonalAux.getPais()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDocumentoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Pais.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Pais.class)) {
						classes.add(new Classe(Pais.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDocumentoPersonal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Pais.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Pais.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDocumentoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDocumentoPersonalConstantesFunciones.getClassesRelationshipsOfTipoDocumentoPersonal(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDocumentoPersonal(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDocumentoPersonal(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDocumentoPersonalConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDocumentoPersonal(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDocumentoPersonal(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(TipoDocumentoPersonal tipodocumentopersonal,List<TipoDocumentoPersonal> tipodocumentopersonals,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDocumentoPersonal tipodocumentopersonalEncontrado=null;
			
			for(TipoDocumentoPersonal tipodocumentopersonalLocal:tipodocumentopersonals) {
				if(tipodocumentopersonalLocal.getId().equals(tipodocumentopersonal.getId())) {
					tipodocumentopersonalEncontrado=tipodocumentopersonalLocal;
					
					tipodocumentopersonalLocal.setIsChanged(tipodocumentopersonal.getIsChanged());
					tipodocumentopersonalLocal.setIsNew(tipodocumentopersonal.getIsNew());
					tipodocumentopersonalLocal.setIsDeleted(tipodocumentopersonal.getIsDeleted());
					
					tipodocumentopersonalLocal.setGeneralEntityOriginal(tipodocumentopersonal.getGeneralEntityOriginal());
					
					tipodocumentopersonalLocal.setId(tipodocumentopersonal.getId());	
					tipodocumentopersonalLocal.setVersionRow(tipodocumentopersonal.getVersionRow());	
					tipodocumentopersonalLocal.setid_pais(tipodocumentopersonal.getid_pais());	
					tipodocumentopersonalLocal.setcodigo(tipodocumentopersonal.getcodigo());	
					tipodocumentopersonalLocal.setnombre(tipodocumentopersonal.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipodocumentopersonal.getIsDeleted()) {
				if(!existe) {
					tipodocumentopersonals.add(tipodocumentopersonal);
				}
			} else {
				if(tipodocumentopersonalEncontrado!=null && permiteQuitar)  {
					tipodocumentopersonals.remove(tipodocumentopersonalEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDocumentoPersonal tipodocumentopersonal,List<TipoDocumentoPersonal> tipodocumentopersonals) throws Exception {
		try	{			
			for(TipoDocumentoPersonal tipodocumentopersonalLocal:tipodocumentopersonals) {
				if(tipodocumentopersonalLocal.getId().equals(tipodocumentopersonal.getId())) {
					tipodocumentopersonalLocal.setIsSelected(tipodocumentopersonal.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDocumentoPersonal(List<TipoDocumentoPersonal> tipodocumentopersonalsAux) throws Exception {
		//this.tipodocumentopersonalsAux=tipodocumentopersonalsAux;
		
		for(TipoDocumentoPersonal tipodocumentopersonalAux:tipodocumentopersonalsAux) {
			if(tipodocumentopersonalAux.getIsChanged()) {
				tipodocumentopersonalAux.setIsChanged(false);
			}		
			
			if(tipodocumentopersonalAux.getIsNew()) {
				tipodocumentopersonalAux.setIsNew(false);
			}	
			
			if(tipodocumentopersonalAux.getIsDeleted()) {
				tipodocumentopersonalAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDocumentoPersonal(TipoDocumentoPersonal tipodocumentopersonalAux) throws Exception {
		//this.tipodocumentopersonalAux=tipodocumentopersonalAux;
		
			if(tipodocumentopersonalAux.getIsChanged()) {
				tipodocumentopersonalAux.setIsChanged(false);
			}		
			
			if(tipodocumentopersonalAux.getIsNew()) {
				tipodocumentopersonalAux.setIsNew(false);
			}	
			
			if(tipodocumentopersonalAux.getIsDeleted()) {
				tipodocumentopersonalAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDocumentoPersonal tipodocumentopersonalAsignar,TipoDocumentoPersonal tipodocumentopersonal) throws Exception {
		tipodocumentopersonalAsignar.setId(tipodocumentopersonal.getId());	
		tipodocumentopersonalAsignar.setVersionRow(tipodocumentopersonal.getVersionRow());	
		tipodocumentopersonalAsignar.setid_pais(tipodocumentopersonal.getid_pais());
		tipodocumentopersonalAsignar.setpais_descripcion(tipodocumentopersonal.getpais_descripcion());	
		tipodocumentopersonalAsignar.setcodigo(tipodocumentopersonal.getcodigo());	
		tipodocumentopersonalAsignar.setnombre(tipodocumentopersonal.getnombre());	
	}
	
	public static void inicializarTipoDocumentoPersonal(TipoDocumentoPersonal tipodocumentopersonal) throws Exception {
		try {
				tipodocumentopersonal.setId(0L);	
					
				tipodocumentopersonal.setid_pais(-1L);	
				tipodocumentopersonal.setcodigo("");	
				tipodocumentopersonal.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDocumentoPersonal(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDocumentoPersonalConstantesFunciones.LABEL_IDPAIS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDocumentoPersonalConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDocumentoPersonalConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDocumentoPersonal(String sTipo,Row row,Workbook workbook,TipoDocumentoPersonal tipodocumentopersonal,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodocumentopersonal.getpais_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodocumentopersonal.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodocumentopersonal.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDocumentoPersonal=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDocumentoPersonal() {
		return this.sFinalQueryTipoDocumentoPersonal;
	}
	
	public void setsFinalQueryTipoDocumentoPersonal(String sFinalQueryTipoDocumentoPersonal) {
		this.sFinalQueryTipoDocumentoPersonal= sFinalQueryTipoDocumentoPersonal;
	}
	
	public Border resaltarSeleccionarTipoDocumentoPersonal=null;
	
	public Border setResaltarSeleccionarTipoDocumentoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoPersonalBeanSwingJInternalFrame tipodocumentopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodocumentopersonalBeanSwingJInternalFrame.jTtoolBarTipoDocumentoPersonal.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDocumentoPersonal= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDocumentoPersonal() {
		return this.resaltarSeleccionarTipoDocumentoPersonal;
	}
	
	public void setResaltarSeleccionarTipoDocumentoPersonal(Border borderResaltarSeleccionarTipoDocumentoPersonal) {
		this.resaltarSeleccionarTipoDocumentoPersonal= borderResaltarSeleccionarTipoDocumentoPersonal;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDocumentoPersonal=null;
	public Boolean mostraridTipoDocumentoPersonal=true;
	public Boolean activaridTipoDocumentoPersonal=true;

	public Border resaltarid_paisTipoDocumentoPersonal=null;
	public Boolean mostrarid_paisTipoDocumentoPersonal=true;
	public Boolean activarid_paisTipoDocumentoPersonal=true;
	public Boolean cargarid_paisTipoDocumentoPersonal=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_paisTipoDocumentoPersonal=false;//ConEventDepend=true

	public Border resaltarcodigoTipoDocumentoPersonal=null;
	public Boolean mostrarcodigoTipoDocumentoPersonal=true;
	public Boolean activarcodigoTipoDocumentoPersonal=true;

	public Border resaltarnombreTipoDocumentoPersonal=null;
	public Boolean mostrarnombreTipoDocumentoPersonal=true;
	public Boolean activarnombreTipoDocumentoPersonal=true;

	
	

	public Border setResaltaridTipoDocumentoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoPersonalBeanSwingJInternalFrame tipodocumentopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentopersonalBeanSwingJInternalFrame.jTtoolBarTipoDocumentoPersonal.setBorder(borderResaltar);
		
		this.resaltaridTipoDocumentoPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDocumentoPersonal() {
		return this.resaltaridTipoDocumentoPersonal;
	}

	public void setResaltaridTipoDocumentoPersonal(Border borderResaltar) {
		this.resaltaridTipoDocumentoPersonal= borderResaltar;
	}

	public Boolean getMostraridTipoDocumentoPersonal() {
		return this.mostraridTipoDocumentoPersonal;
	}

	public void setMostraridTipoDocumentoPersonal(Boolean mostraridTipoDocumentoPersonal) {
		this.mostraridTipoDocumentoPersonal= mostraridTipoDocumentoPersonal;
	}

	public Boolean getActivaridTipoDocumentoPersonal() {
		return this.activaridTipoDocumentoPersonal;
	}

	public void setActivaridTipoDocumentoPersonal(Boolean activaridTipoDocumentoPersonal) {
		this.activaridTipoDocumentoPersonal= activaridTipoDocumentoPersonal;
	}

	public Border setResaltarid_paisTipoDocumentoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoPersonalBeanSwingJInternalFrame tipodocumentopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentopersonalBeanSwingJInternalFrame.jTtoolBarTipoDocumentoPersonal.setBorder(borderResaltar);
		
		this.resaltarid_paisTipoDocumentoPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_paisTipoDocumentoPersonal() {
		return this.resaltarid_paisTipoDocumentoPersonal;
	}

	public void setResaltarid_paisTipoDocumentoPersonal(Border borderResaltar) {
		this.resaltarid_paisTipoDocumentoPersonal= borderResaltar;
	}

	public Boolean getMostrarid_paisTipoDocumentoPersonal() {
		return this.mostrarid_paisTipoDocumentoPersonal;
	}

	public void setMostrarid_paisTipoDocumentoPersonal(Boolean mostrarid_paisTipoDocumentoPersonal) {
		this.mostrarid_paisTipoDocumentoPersonal= mostrarid_paisTipoDocumentoPersonal;
	}

	public Boolean getActivarid_paisTipoDocumentoPersonal() {
		return this.activarid_paisTipoDocumentoPersonal;
	}

	public void setActivarid_paisTipoDocumentoPersonal(Boolean activarid_paisTipoDocumentoPersonal) {
		this.activarid_paisTipoDocumentoPersonal= activarid_paisTipoDocumentoPersonal;
	}

	public Boolean getCargarid_paisTipoDocumentoPersonal() {
		return this.cargarid_paisTipoDocumentoPersonal;
	}

	public void setCargarid_paisTipoDocumentoPersonal(Boolean cargarid_paisTipoDocumentoPersonal) {
		this.cargarid_paisTipoDocumentoPersonal= cargarid_paisTipoDocumentoPersonal;
	}

	public Border setResaltarcodigoTipoDocumentoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoPersonalBeanSwingJInternalFrame tipodocumentopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentopersonalBeanSwingJInternalFrame.jTtoolBarTipoDocumentoPersonal.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoDocumentoPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoDocumentoPersonal() {
		return this.resaltarcodigoTipoDocumentoPersonal;
	}

	public void setResaltarcodigoTipoDocumentoPersonal(Border borderResaltar) {
		this.resaltarcodigoTipoDocumentoPersonal= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoDocumentoPersonal() {
		return this.mostrarcodigoTipoDocumentoPersonal;
	}

	public void setMostrarcodigoTipoDocumentoPersonal(Boolean mostrarcodigoTipoDocumentoPersonal) {
		this.mostrarcodigoTipoDocumentoPersonal= mostrarcodigoTipoDocumentoPersonal;
	}

	public Boolean getActivarcodigoTipoDocumentoPersonal() {
		return this.activarcodigoTipoDocumentoPersonal;
	}

	public void setActivarcodigoTipoDocumentoPersonal(Boolean activarcodigoTipoDocumentoPersonal) {
		this.activarcodigoTipoDocumentoPersonal= activarcodigoTipoDocumentoPersonal;
	}

	public Border setResaltarnombreTipoDocumentoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoPersonalBeanSwingJInternalFrame tipodocumentopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodocumentopersonalBeanSwingJInternalFrame.jTtoolBarTipoDocumentoPersonal.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDocumentoPersonal= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDocumentoPersonal() {
		return this.resaltarnombreTipoDocumentoPersonal;
	}

	public void setResaltarnombreTipoDocumentoPersonal(Border borderResaltar) {
		this.resaltarnombreTipoDocumentoPersonal= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDocumentoPersonal() {
		return this.mostrarnombreTipoDocumentoPersonal;
	}

	public void setMostrarnombreTipoDocumentoPersonal(Boolean mostrarnombreTipoDocumentoPersonal) {
		this.mostrarnombreTipoDocumentoPersonal= mostrarnombreTipoDocumentoPersonal;
	}

	public Boolean getActivarnombreTipoDocumentoPersonal() {
		return this.activarnombreTipoDocumentoPersonal;
	}

	public void setActivarnombreTipoDocumentoPersonal(Boolean activarnombreTipoDocumentoPersonal) {
		this.activarnombreTipoDocumentoPersonal= activarnombreTipoDocumentoPersonal;
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
		
		
		this.setMostraridTipoDocumentoPersonal(esInicial);
		this.setMostrarid_paisTipoDocumentoPersonal(esInicial);
		this.setMostrarcodigoTipoDocumentoPersonal(esInicial);
		this.setMostrarnombreTipoDocumentoPersonal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDocumentoPersonalConstantesFunciones.ID)) {
				this.setMostraridTipoDocumentoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoPersonalConstantesFunciones.IDPAIS)) {
				this.setMostrarid_paisTipoDocumentoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoPersonalConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoDocumentoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoPersonalConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDocumentoPersonal(esAsigna);
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
		
		
		this.setActivaridTipoDocumentoPersonal(esInicial);
		this.setActivarid_paisTipoDocumentoPersonal(esInicial);
		this.setActivarcodigoTipoDocumentoPersonal(esInicial);
		this.setActivarnombreTipoDocumentoPersonal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDocumentoPersonalConstantesFunciones.ID)) {
				this.setActivaridTipoDocumentoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoPersonalConstantesFunciones.IDPAIS)) {
				this.setActivarid_paisTipoDocumentoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoPersonalConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoDocumentoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoPersonalConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDocumentoPersonal(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDocumentoPersonalBeanSwingJInternalFrame tipodocumentopersonalBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDocumentoPersonal(esInicial);
		this.setResaltarid_paisTipoDocumentoPersonal(esInicial);
		this.setResaltarcodigoTipoDocumentoPersonal(esInicial);
		this.setResaltarnombreTipoDocumentoPersonal(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDocumentoPersonalConstantesFunciones.ID)) {
				this.setResaltaridTipoDocumentoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoPersonalConstantesFunciones.IDPAIS)) {
				this.setResaltarid_paisTipoDocumentoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoPersonalConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoDocumentoPersonal(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDocumentoPersonalConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDocumentoPersonal(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDocumentoPersonalBeanSwingJInternalFrame tipodocumentopersonalBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdPaisTipoDocumentoPersonal=true;

	public Boolean getMostrarFK_IdPaisTipoDocumentoPersonal() {
		return this.mostrarFK_IdPaisTipoDocumentoPersonal;
	}

	public void setMostrarFK_IdPaisTipoDocumentoPersonal(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPaisTipoDocumentoPersonal= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdPaisTipoDocumentoPersonal=true;

	public Boolean getActivarFK_IdPaisTipoDocumentoPersonal() {
		return this.activarFK_IdPaisTipoDocumentoPersonal;
	}

	public void setActivarFK_IdPaisTipoDocumentoPersonal(Boolean habilitarResaltar) {
		this.activarFK_IdPaisTipoDocumentoPersonal= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdPaisTipoDocumentoPersonal=null;

	public Border getResaltarFK_IdPaisTipoDocumentoPersonal() {
		return this.resaltarFK_IdPaisTipoDocumentoPersonal;
	}

	public void setResaltarFK_IdPaisTipoDocumentoPersonal(Border borderResaltar) {
		this.resaltarFK_IdPaisTipoDocumentoPersonal= borderResaltar;
	}

	public void setResaltarFK_IdPaisTipoDocumentoPersonal(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDocumentoPersonalBeanSwingJInternalFrame tipodocumentopersonalBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPaisTipoDocumentoPersonal= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}