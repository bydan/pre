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


import com.bydan.erp.cartera.util.TipoMoviFinanConstantesFunciones;
import com.bydan.erp.cartera.util.TipoMoviFinanParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoMoviFinanParameterGeneral;

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
final public class TipoMoviFinanConstantesFunciones extends TipoMoviFinanConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoMoviFinan";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoMoviFinan"+TipoMoviFinanConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoMoviFinanHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoMoviFinanHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoMoviFinanConstantesFunciones.SCHEMA+"_"+TipoMoviFinanConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoMoviFinanHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoMoviFinanConstantesFunciones.SCHEMA+"_"+TipoMoviFinanConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoMoviFinanConstantesFunciones.SCHEMA+"_"+TipoMoviFinanConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoMoviFinanHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoMoviFinanConstantesFunciones.SCHEMA+"_"+TipoMoviFinanConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMoviFinanConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMoviFinanHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMoviFinanConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMoviFinanConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoMoviFinanHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoMoviFinanConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoMoviFinanConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoMoviFinanConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoMoviFinanConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoMoviFinanConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Movi Finanes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Movi Finan";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Movi Finan";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoMoviFinan";
	public static final String OBJECTNAME="tipomovifinan";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_movi_finan";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipomovifinan from "+TipoMoviFinanConstantesFunciones.SPERSISTENCENAME+" tipomovifinan";
	public static String QUERYSELECTNATIVE="select "+TipoMoviFinanConstantesFunciones.SCHEMA+"."+TipoMoviFinanConstantesFunciones.TABLENAME+".id,"+TipoMoviFinanConstantesFunciones.SCHEMA+"."+TipoMoviFinanConstantesFunciones.TABLENAME+".version_row,"+TipoMoviFinanConstantesFunciones.SCHEMA+"."+TipoMoviFinanConstantesFunciones.TABLENAME+".id_empresa,"+TipoMoviFinanConstantesFunciones.SCHEMA+"."+TipoMoviFinanConstantesFunciones.TABLENAME+".codigo,"+TipoMoviFinanConstantesFunciones.SCHEMA+"."+TipoMoviFinanConstantesFunciones.TABLENAME+".nombre from "+TipoMoviFinanConstantesFunciones.SCHEMA+"."+TipoMoviFinanConstantesFunciones.TABLENAME;//+" as "+TipoMoviFinanConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoMoviFinanConstantesFuncionesAdditional tipomovifinanConstantesFuncionesAdditional=null;
	
	public TipoMoviFinanConstantesFuncionesAdditional getTipoMoviFinanConstantesFuncionesAdditional() {
		return this.tipomovifinanConstantesFuncionesAdditional;
	}
	
	public void setTipoMoviFinanConstantesFuncionesAdditional(TipoMoviFinanConstantesFuncionesAdditional tipomovifinanConstantesFuncionesAdditional) {
		try {
			this.tipomovifinanConstantesFuncionesAdditional=tipomovifinanConstantesFuncionesAdditional;
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
	
	public static String getTipoMoviFinanLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoMoviFinanConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoMoviFinanConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoMoviFinanConstantesFunciones.CODIGO)) {sLabelColumna=TipoMoviFinanConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoMoviFinanConstantesFunciones.NOMBRE)) {sLabelColumna=TipoMoviFinanConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoMoviFinanDescripcion(TipoMoviFinan tipomovifinan) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipomovifinan !=null/* && tipomovifinan.getId()!=0*/) {
			sDescripcion=tipomovifinan.getcodigo();//tipomovifinantipomovifinan.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoMoviFinanDescripcionDetallado(TipoMoviFinan tipomovifinan) {
		String sDescripcion="";
			
		sDescripcion+=TipoMoviFinanConstantesFunciones.ID+"=";
		sDescripcion+=tipomovifinan.getId().toString()+",";
		sDescripcion+=TipoMoviFinanConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipomovifinan.getVersionRow().toString()+",";
		sDescripcion+=TipoMoviFinanConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipomovifinan.getid_empresa().toString()+",";
		sDescripcion+=TipoMoviFinanConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipomovifinan.getcodigo()+",";
		sDescripcion+=TipoMoviFinanConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipomovifinan.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoMoviFinanDescripcion(TipoMoviFinan tipomovifinan,String sValor) throws Exception {			
		if(tipomovifinan !=null) {
			tipomovifinan.setcodigo(sValor);;//tipomovifinantipomovifinan.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoMoviFinan(TipoMoviFinan tipomovifinan,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipomovifinan.setcodigo(tipomovifinan.getcodigo().trim());
		tipomovifinan.setnombre(tipomovifinan.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoMoviFinans(List<TipoMoviFinan> tipomovifinans,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoMoviFinan tipomovifinan: tipomovifinans) {
			tipomovifinan.setcodigo(tipomovifinan.getcodigo().trim());
			tipomovifinan.setnombre(tipomovifinan.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMoviFinan(TipoMoviFinan tipomovifinan,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipomovifinan.getConCambioAuxiliar()) {
			tipomovifinan.setIsDeleted(tipomovifinan.getIsDeletedAuxiliar());	
			tipomovifinan.setIsNew(tipomovifinan.getIsNewAuxiliar());	
			tipomovifinan.setIsChanged(tipomovifinan.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipomovifinan.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipomovifinan.setIsDeletedAuxiliar(false);	
			tipomovifinan.setIsNewAuxiliar(false);	
			tipomovifinan.setIsChangedAuxiliar(false);
			
			tipomovifinan.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoMoviFinans(List<TipoMoviFinan> tipomovifinans,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoMoviFinan tipomovifinan : tipomovifinans) {
			if(conAsignarBase && tipomovifinan.getConCambioAuxiliar()) {
				tipomovifinan.setIsDeleted(tipomovifinan.getIsDeletedAuxiliar());	
				tipomovifinan.setIsNew(tipomovifinan.getIsNewAuxiliar());	
				tipomovifinan.setIsChanged(tipomovifinan.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipomovifinan.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipomovifinan.setIsDeletedAuxiliar(false);	
				tipomovifinan.setIsNewAuxiliar(false);	
				tipomovifinan.setIsChangedAuxiliar(false);
				
				tipomovifinan.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoMoviFinan(TipoMoviFinan tipomovifinan,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoMoviFinans(List<TipoMoviFinan> tipomovifinans,Boolean conEnteros) throws Exception  {
		
		for(TipoMoviFinan tipomovifinan: tipomovifinans) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoMoviFinan(List<TipoMoviFinan> tipomovifinans,TipoMoviFinan tipomovifinanAux) throws Exception  {
		TipoMoviFinanConstantesFunciones.InicializarValoresTipoMoviFinan(tipomovifinanAux,true);
		
		for(TipoMoviFinan tipomovifinan: tipomovifinans) {
			if(tipomovifinan.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMoviFinan(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoMoviFinanConstantesFunciones.getArrayColumnasGlobalesTipoMoviFinan(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoMoviFinan(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoMoviFinanConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoMoviFinanConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoMoviFinan(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoMoviFinan> tipomovifinans,TipoMoviFinan tipomovifinan,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoMoviFinan tipomovifinanAux: tipomovifinans) {
			if(tipomovifinanAux!=null && tipomovifinan!=null) {
				if((tipomovifinanAux.getId()==null && tipomovifinan.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipomovifinanAux.getId()!=null && tipomovifinan.getId()!=null){
					if(tipomovifinanAux.getId().equals(tipomovifinan.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoMoviFinan(List<TipoMoviFinan> tipomovifinans) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoMoviFinan tipomovifinan: tipomovifinans) {			
			if(tipomovifinan.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoMoviFinan() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoMoviFinanConstantesFunciones.LABEL_ID, TipoMoviFinanConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMoviFinanConstantesFunciones.LABEL_VERSIONROW, TipoMoviFinanConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMoviFinanConstantesFunciones.LABEL_IDEMPRESA, TipoMoviFinanConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMoviFinanConstantesFunciones.LABEL_CODIGO, TipoMoviFinanConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoMoviFinanConstantesFunciones.LABEL_NOMBRE, TipoMoviFinanConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoMoviFinan() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoMoviFinanConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMoviFinanConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMoviFinanConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMoviFinanConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoMoviFinanConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMoviFinan() throws Exception  {
		return TipoMoviFinanConstantesFunciones.getTiposSeleccionarTipoMoviFinan(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMoviFinan(Boolean conFk) throws Exception  {
		return TipoMoviFinanConstantesFunciones.getTiposSeleccionarTipoMoviFinan(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoMoviFinan(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMoviFinanConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoMoviFinanConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMoviFinanConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoMoviFinanConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoMoviFinanConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoMoviFinanConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoMoviFinan(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMoviFinan(TipoMoviFinan tipomovifinanAux) throws Exception {
		
			tipomovifinanAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipomovifinanAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoMoviFinan(List<TipoMoviFinan> tipomovifinansTemp) throws Exception {
		for(TipoMoviFinan tipomovifinanAux:tipomovifinansTemp) {
			
			tipomovifinanAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipomovifinanAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoMoviFinan(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoMoviFinan(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMoviFinan(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMoviFinanConstantesFunciones.getClassesRelationshipsOfTipoMoviFinan(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoMoviFinan(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(InformacionFinanciera.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(InformacionFinanciera.class)) {
						classes.add(new Classe(InformacionFinanciera.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMoviFinan(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoMoviFinanConstantesFunciones.getClassesRelationshipsFromStringsOfTipoMoviFinan(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoMoviFinan(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(InformacionFinanciera.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(InformacionFinanciera.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(InformacionFinanciera.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(InformacionFinanciera.class)); continue;
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
	public static void actualizarLista(TipoMoviFinan tipomovifinan,List<TipoMoviFinan> tipomovifinans,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoMoviFinan tipomovifinanEncontrado=null;
			
			for(TipoMoviFinan tipomovifinanLocal:tipomovifinans) {
				if(tipomovifinanLocal.getId().equals(tipomovifinan.getId())) {
					tipomovifinanEncontrado=tipomovifinanLocal;
					
					tipomovifinanLocal.setIsChanged(tipomovifinan.getIsChanged());
					tipomovifinanLocal.setIsNew(tipomovifinan.getIsNew());
					tipomovifinanLocal.setIsDeleted(tipomovifinan.getIsDeleted());
					
					tipomovifinanLocal.setGeneralEntityOriginal(tipomovifinan.getGeneralEntityOriginal());
					
					tipomovifinanLocal.setId(tipomovifinan.getId());	
					tipomovifinanLocal.setVersionRow(tipomovifinan.getVersionRow());	
					tipomovifinanLocal.setid_empresa(tipomovifinan.getid_empresa());	
					tipomovifinanLocal.setcodigo(tipomovifinan.getcodigo());	
					tipomovifinanLocal.setnombre(tipomovifinan.getnombre());	
					
					
					tipomovifinanLocal.setInformacionFinancieras(tipomovifinan.getInformacionFinancieras());
					
					existe=true;
					break;
				}
			}
			
			if(!tipomovifinan.getIsDeleted()) {
				if(!existe) {
					tipomovifinans.add(tipomovifinan);
				}
			} else {
				if(tipomovifinanEncontrado!=null && permiteQuitar)  {
					tipomovifinans.remove(tipomovifinanEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoMoviFinan tipomovifinan,List<TipoMoviFinan> tipomovifinans) throws Exception {
		try	{			
			for(TipoMoviFinan tipomovifinanLocal:tipomovifinans) {
				if(tipomovifinanLocal.getId().equals(tipomovifinan.getId())) {
					tipomovifinanLocal.setIsSelected(tipomovifinan.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoMoviFinan(List<TipoMoviFinan> tipomovifinansAux) throws Exception {
		//this.tipomovifinansAux=tipomovifinansAux;
		
		for(TipoMoviFinan tipomovifinanAux:tipomovifinansAux) {
			if(tipomovifinanAux.getIsChanged()) {
				tipomovifinanAux.setIsChanged(false);
			}		
			
			if(tipomovifinanAux.getIsNew()) {
				tipomovifinanAux.setIsNew(false);
			}	
			
			if(tipomovifinanAux.getIsDeleted()) {
				tipomovifinanAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoMoviFinan(TipoMoviFinan tipomovifinanAux) throws Exception {
		//this.tipomovifinanAux=tipomovifinanAux;
		
			if(tipomovifinanAux.getIsChanged()) {
				tipomovifinanAux.setIsChanged(false);
			}		
			
			if(tipomovifinanAux.getIsNew()) {
				tipomovifinanAux.setIsNew(false);
			}	
			
			if(tipomovifinanAux.getIsDeleted()) {
				tipomovifinanAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoMoviFinan tipomovifinanAsignar,TipoMoviFinan tipomovifinan) throws Exception {
		tipomovifinanAsignar.setId(tipomovifinan.getId());	
		tipomovifinanAsignar.setVersionRow(tipomovifinan.getVersionRow());	
		tipomovifinanAsignar.setid_empresa(tipomovifinan.getid_empresa());
		tipomovifinanAsignar.setempresa_descripcion(tipomovifinan.getempresa_descripcion());	
		tipomovifinanAsignar.setcodigo(tipomovifinan.getcodigo());	
		tipomovifinanAsignar.setnombre(tipomovifinan.getnombre());	
	}
	
	public static void inicializarTipoMoviFinan(TipoMoviFinan tipomovifinan) throws Exception {
		try {
				tipomovifinan.setId(0L);	
					
				tipomovifinan.setid_empresa(-1L);	
				tipomovifinan.setcodigo("");	
				tipomovifinan.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoMoviFinan(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMoviFinanConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMoviFinanConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoMoviFinanConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoMoviFinan(String sTipo,Row row,Workbook workbook,TipoMoviFinan tipomovifinan,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomovifinan.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomovifinan.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipomovifinan.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoMoviFinan=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoMoviFinan() {
		return this.sFinalQueryTipoMoviFinan;
	}
	
	public void setsFinalQueryTipoMoviFinan(String sFinalQueryTipoMoviFinan) {
		this.sFinalQueryTipoMoviFinan= sFinalQueryTipoMoviFinan;
	}
	
	public Border resaltarSeleccionarTipoMoviFinan=null;
	
	public Border setResaltarSeleccionarTipoMoviFinan(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMoviFinanBeanSwingJInternalFrame tipomovifinanBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipomovifinanBeanSwingJInternalFrame.jTtoolBarTipoMoviFinan.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoMoviFinan= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoMoviFinan() {
		return this.resaltarSeleccionarTipoMoviFinan;
	}
	
	public void setResaltarSeleccionarTipoMoviFinan(Border borderResaltarSeleccionarTipoMoviFinan) {
		this.resaltarSeleccionarTipoMoviFinan= borderResaltarSeleccionarTipoMoviFinan;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoMoviFinan=null;
	public Boolean mostraridTipoMoviFinan=true;
	public Boolean activaridTipoMoviFinan=true;

	public Border resaltarid_empresaTipoMoviFinan=null;
	public Boolean mostrarid_empresaTipoMoviFinan=true;
	public Boolean activarid_empresaTipoMoviFinan=true;
	public Boolean cargarid_empresaTipoMoviFinan=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoMoviFinan=false;//ConEventDepend=true

	public Border resaltarcodigoTipoMoviFinan=null;
	public Boolean mostrarcodigoTipoMoviFinan=true;
	public Boolean activarcodigoTipoMoviFinan=true;

	public Border resaltarnombreTipoMoviFinan=null;
	public Boolean mostrarnombreTipoMoviFinan=true;
	public Boolean activarnombreTipoMoviFinan=true;

	
	

	public Border setResaltaridTipoMoviFinan(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMoviFinanBeanSwingJInternalFrame tipomovifinanBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovifinanBeanSwingJInternalFrame.jTtoolBarTipoMoviFinan.setBorder(borderResaltar);
		
		this.resaltaridTipoMoviFinan= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoMoviFinan() {
		return this.resaltaridTipoMoviFinan;
	}

	public void setResaltaridTipoMoviFinan(Border borderResaltar) {
		this.resaltaridTipoMoviFinan= borderResaltar;
	}

	public Boolean getMostraridTipoMoviFinan() {
		return this.mostraridTipoMoviFinan;
	}

	public void setMostraridTipoMoviFinan(Boolean mostraridTipoMoviFinan) {
		this.mostraridTipoMoviFinan= mostraridTipoMoviFinan;
	}

	public Boolean getActivaridTipoMoviFinan() {
		return this.activaridTipoMoviFinan;
	}

	public void setActivaridTipoMoviFinan(Boolean activaridTipoMoviFinan) {
		this.activaridTipoMoviFinan= activaridTipoMoviFinan;
	}

	public Border setResaltarid_empresaTipoMoviFinan(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMoviFinanBeanSwingJInternalFrame tipomovifinanBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovifinanBeanSwingJInternalFrame.jTtoolBarTipoMoviFinan.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoMoviFinan= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoMoviFinan() {
		return this.resaltarid_empresaTipoMoviFinan;
	}

	public void setResaltarid_empresaTipoMoviFinan(Border borderResaltar) {
		this.resaltarid_empresaTipoMoviFinan= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoMoviFinan() {
		return this.mostrarid_empresaTipoMoviFinan;
	}

	public void setMostrarid_empresaTipoMoviFinan(Boolean mostrarid_empresaTipoMoviFinan) {
		this.mostrarid_empresaTipoMoviFinan= mostrarid_empresaTipoMoviFinan;
	}

	public Boolean getActivarid_empresaTipoMoviFinan() {
		return this.activarid_empresaTipoMoviFinan;
	}

	public void setActivarid_empresaTipoMoviFinan(Boolean activarid_empresaTipoMoviFinan) {
		this.activarid_empresaTipoMoviFinan= activarid_empresaTipoMoviFinan;
	}

	public Boolean getCargarid_empresaTipoMoviFinan() {
		return this.cargarid_empresaTipoMoviFinan;
	}

	public void setCargarid_empresaTipoMoviFinan(Boolean cargarid_empresaTipoMoviFinan) {
		this.cargarid_empresaTipoMoviFinan= cargarid_empresaTipoMoviFinan;
	}

	public Border setResaltarcodigoTipoMoviFinan(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMoviFinanBeanSwingJInternalFrame tipomovifinanBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovifinanBeanSwingJInternalFrame.jTtoolBarTipoMoviFinan.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoMoviFinan= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoMoviFinan() {
		return this.resaltarcodigoTipoMoviFinan;
	}

	public void setResaltarcodigoTipoMoviFinan(Border borderResaltar) {
		this.resaltarcodigoTipoMoviFinan= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoMoviFinan() {
		return this.mostrarcodigoTipoMoviFinan;
	}

	public void setMostrarcodigoTipoMoviFinan(Boolean mostrarcodigoTipoMoviFinan) {
		this.mostrarcodigoTipoMoviFinan= mostrarcodigoTipoMoviFinan;
	}

	public Boolean getActivarcodigoTipoMoviFinan() {
		return this.activarcodigoTipoMoviFinan;
	}

	public void setActivarcodigoTipoMoviFinan(Boolean activarcodigoTipoMoviFinan) {
		this.activarcodigoTipoMoviFinan= activarcodigoTipoMoviFinan;
	}

	public Border setResaltarnombreTipoMoviFinan(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMoviFinanBeanSwingJInternalFrame tipomovifinanBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipomovifinanBeanSwingJInternalFrame.jTtoolBarTipoMoviFinan.setBorder(borderResaltar);
		
		this.resaltarnombreTipoMoviFinan= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoMoviFinan() {
		return this.resaltarnombreTipoMoviFinan;
	}

	public void setResaltarnombreTipoMoviFinan(Border borderResaltar) {
		this.resaltarnombreTipoMoviFinan= borderResaltar;
	}

	public Boolean getMostrarnombreTipoMoviFinan() {
		return this.mostrarnombreTipoMoviFinan;
	}

	public void setMostrarnombreTipoMoviFinan(Boolean mostrarnombreTipoMoviFinan) {
		this.mostrarnombreTipoMoviFinan= mostrarnombreTipoMoviFinan;
	}

	public Boolean getActivarnombreTipoMoviFinan() {
		return this.activarnombreTipoMoviFinan;
	}

	public void setActivarnombreTipoMoviFinan(Boolean activarnombreTipoMoviFinan) {
		this.activarnombreTipoMoviFinan= activarnombreTipoMoviFinan;
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
		
		
		this.setMostraridTipoMoviFinan(esInicial);
		this.setMostrarid_empresaTipoMoviFinan(esInicial);
		this.setMostrarcodigoTipoMoviFinan(esInicial);
		this.setMostrarnombreTipoMoviFinan(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMoviFinanConstantesFunciones.ID)) {
				this.setMostraridTipoMoviFinan(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMoviFinanConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoMoviFinan(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMoviFinanConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoMoviFinan(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMoviFinanConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoMoviFinan(esAsigna);
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
		
		
		this.setActivaridTipoMoviFinan(esInicial);
		this.setActivarid_empresaTipoMoviFinan(esInicial);
		this.setActivarcodigoTipoMoviFinan(esInicial);
		this.setActivarnombreTipoMoviFinan(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMoviFinanConstantesFunciones.ID)) {
				this.setActivaridTipoMoviFinan(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMoviFinanConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoMoviFinan(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMoviFinanConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoMoviFinan(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMoviFinanConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoMoviFinan(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMoviFinanBeanSwingJInternalFrame tipomovifinanBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoMoviFinan(esInicial);
		this.setResaltarid_empresaTipoMoviFinan(esInicial);
		this.setResaltarcodigoTipoMoviFinan(esInicial);
		this.setResaltarnombreTipoMoviFinan(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoMoviFinanConstantesFunciones.ID)) {
				this.setResaltaridTipoMoviFinan(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMoviFinanConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoMoviFinan(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMoviFinanConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoMoviFinan(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoMoviFinanConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoMoviFinan(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarInformacionFinancieraTipoMoviFinan=null;

	public Border getResaltarInformacionFinancieraTipoMoviFinan() {
		return this.resaltarInformacionFinancieraTipoMoviFinan;
	}

	public void setResaltarInformacionFinancieraTipoMoviFinan(Border borderResaltarInformacionFinanciera) {
		if(borderResaltarInformacionFinanciera!=null) {
			this.resaltarInformacionFinancieraTipoMoviFinan= borderResaltarInformacionFinanciera;
		}
	}

	public Border setResaltarInformacionFinancieraTipoMoviFinan(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMoviFinanBeanSwingJInternalFrame tipomovifinanBeanSwingJInternalFrame*/) {
		Border borderResaltarInformacionFinanciera=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipomovifinanBeanSwingJInternalFrame.jTtoolBarTipoMoviFinan.setBorder(borderResaltarInformacionFinanciera);
			
		this.resaltarInformacionFinancieraTipoMoviFinan= borderResaltarInformacionFinanciera;

		 return borderResaltarInformacionFinanciera;
	}



	public Boolean mostrarInformacionFinancieraTipoMoviFinan=true;

	public Boolean getMostrarInformacionFinancieraTipoMoviFinan() {
		return this.mostrarInformacionFinancieraTipoMoviFinan;
	}

	public void setMostrarInformacionFinancieraTipoMoviFinan(Boolean visibilidadResaltarInformacionFinanciera) {
		this.mostrarInformacionFinancieraTipoMoviFinan= visibilidadResaltarInformacionFinanciera;
	}



	public Boolean activarInformacionFinancieraTipoMoviFinan=true;

	public Boolean gethabilitarResaltarInformacionFinancieraTipoMoviFinan() {
		return this.activarInformacionFinancieraTipoMoviFinan;
	}

	public void setActivarInformacionFinancieraTipoMoviFinan(Boolean habilitarResaltarInformacionFinanciera) {
		this.activarInformacionFinancieraTipoMoviFinan= habilitarResaltarInformacionFinanciera;
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

		this.setMostrarInformacionFinancieraTipoMoviFinan(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionFinanciera.class)) {
				this.setMostrarInformacionFinancieraTipoMoviFinan(esAsigna);
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

		this.setActivarInformacionFinancieraTipoMoviFinan(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionFinanciera.class)) {
				this.setActivarInformacionFinancieraTipoMoviFinan(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoMoviFinanBeanSwingJInternalFrame tipomovifinanBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarInformacionFinancieraTipoMoviFinan(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(InformacionFinanciera.class)) {
				this.setResaltarInformacionFinancieraTipoMoviFinan(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoMoviFinan=true;

	public Boolean getMostrarFK_IdEmpresaTipoMoviFinan() {
		return this.mostrarFK_IdEmpresaTipoMoviFinan;
	}

	public void setMostrarFK_IdEmpresaTipoMoviFinan(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoMoviFinan= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoMoviFinan=true;

	public Boolean getActivarFK_IdEmpresaTipoMoviFinan() {
		return this.activarFK_IdEmpresaTipoMoviFinan;
	}

	public void setActivarFK_IdEmpresaTipoMoviFinan(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoMoviFinan= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoMoviFinan=null;

	public Border getResaltarFK_IdEmpresaTipoMoviFinan() {
		return this.resaltarFK_IdEmpresaTipoMoviFinan;
	}

	public void setResaltarFK_IdEmpresaTipoMoviFinan(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoMoviFinan= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoMoviFinan(ParametroGeneralUsuario parametroGeneralUsuario/*TipoMoviFinanBeanSwingJInternalFrame tipomovifinanBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoMoviFinan= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}