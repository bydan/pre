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


import com.bydan.erp.nomina.util.TipoSangreConstantesFunciones;
import com.bydan.erp.nomina.util.TipoSangreParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoSangreParameterGeneral;

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
final public class TipoSangreConstantesFunciones extends TipoSangreConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoSangre";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoSangre"+TipoSangreConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoSangreHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoSangreHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoSangreConstantesFunciones.SCHEMA+"_"+TipoSangreConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoSangreHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoSangreConstantesFunciones.SCHEMA+"_"+TipoSangreConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoSangreConstantesFunciones.SCHEMA+"_"+TipoSangreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoSangreHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoSangreConstantesFunciones.SCHEMA+"_"+TipoSangreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSangreConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoSangreHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSangreConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSangreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoSangreHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoSangreConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoSangreConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoSangreConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoSangreConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoSangreConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Sangres";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Sangre";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Sangre";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoSangre";
	public static final String OBJECTNAME="tiposangre";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_sangre";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiposangre from "+TipoSangreConstantesFunciones.SPERSISTENCENAME+" tiposangre";
	public static String QUERYSELECTNATIVE="select "+TipoSangreConstantesFunciones.SCHEMA+"."+TipoSangreConstantesFunciones.TABLENAME+".id,"+TipoSangreConstantesFunciones.SCHEMA+"."+TipoSangreConstantesFunciones.TABLENAME+".version_row,"+TipoSangreConstantesFunciones.SCHEMA+"."+TipoSangreConstantesFunciones.TABLENAME+".id_empresa,"+TipoSangreConstantesFunciones.SCHEMA+"."+TipoSangreConstantesFunciones.TABLENAME+".codigo,"+TipoSangreConstantesFunciones.SCHEMA+"."+TipoSangreConstantesFunciones.TABLENAME+".nombre from "+TipoSangreConstantesFunciones.SCHEMA+"."+TipoSangreConstantesFunciones.TABLENAME;//+" as "+TipoSangreConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoSangreConstantesFuncionesAdditional tiposangreConstantesFuncionesAdditional=null;
	
	public TipoSangreConstantesFuncionesAdditional getTipoSangreConstantesFuncionesAdditional() {
		return this.tiposangreConstantesFuncionesAdditional;
	}
	
	public void setTipoSangreConstantesFuncionesAdditional(TipoSangreConstantesFuncionesAdditional tiposangreConstantesFuncionesAdditional) {
		try {
			this.tiposangreConstantesFuncionesAdditional=tiposangreConstantesFuncionesAdditional;
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
	
	public static String getTipoSangreLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoSangreConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoSangreConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoSangreConstantesFunciones.CODIGO)) {sLabelColumna=TipoSangreConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoSangreConstantesFunciones.NOMBRE)) {sLabelColumna=TipoSangreConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoSangreDescripcion(TipoSangre tiposangre) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiposangre !=null/* && tiposangre.getId()!=0*/) {
			sDescripcion=tiposangre.getcodigo();//tiposangretiposangre.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoSangreDescripcionDetallado(TipoSangre tiposangre) {
		String sDescripcion="";
			
		sDescripcion+=TipoSangreConstantesFunciones.ID+"=";
		sDescripcion+=tiposangre.getId().toString()+",";
		sDescripcion+=TipoSangreConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiposangre.getVersionRow().toString()+",";
		sDescripcion+=TipoSangreConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tiposangre.getid_empresa().toString()+",";
		sDescripcion+=TipoSangreConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiposangre.getcodigo()+",";
		sDescripcion+=TipoSangreConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiposangre.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoSangreDescripcion(TipoSangre tiposangre,String sValor) throws Exception {			
		if(tiposangre !=null) {
			tiposangre.setcodigo(sValor);;//tiposangretiposangre.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoSangre(TipoSangre tiposangre,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiposangre.setcodigo(tiposangre.getcodigo().trim());
		tiposangre.setnombre(tiposangre.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoSangres(List<TipoSangre> tiposangres,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoSangre tiposangre: tiposangres) {
			tiposangre.setcodigo(tiposangre.getcodigo().trim());
			tiposangre.setnombre(tiposangre.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoSangre(TipoSangre tiposangre,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiposangre.getConCambioAuxiliar()) {
			tiposangre.setIsDeleted(tiposangre.getIsDeletedAuxiliar());	
			tiposangre.setIsNew(tiposangre.getIsNewAuxiliar());	
			tiposangre.setIsChanged(tiposangre.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiposangre.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiposangre.setIsDeletedAuxiliar(false);	
			tiposangre.setIsNewAuxiliar(false);	
			tiposangre.setIsChangedAuxiliar(false);
			
			tiposangre.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoSangres(List<TipoSangre> tiposangres,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoSangre tiposangre : tiposangres) {
			if(conAsignarBase && tiposangre.getConCambioAuxiliar()) {
				tiposangre.setIsDeleted(tiposangre.getIsDeletedAuxiliar());	
				tiposangre.setIsNew(tiposangre.getIsNewAuxiliar());	
				tiposangre.setIsChanged(tiposangre.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiposangre.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiposangre.setIsDeletedAuxiliar(false);	
				tiposangre.setIsNewAuxiliar(false);	
				tiposangre.setIsChangedAuxiliar(false);
				
				tiposangre.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoSangre(TipoSangre tiposangre,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoSangres(List<TipoSangre> tiposangres,Boolean conEnteros) throws Exception  {
		
		for(TipoSangre tiposangre: tiposangres) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoSangre(List<TipoSangre> tiposangres,TipoSangre tiposangreAux) throws Exception  {
		TipoSangreConstantesFunciones.InicializarValoresTipoSangre(tiposangreAux,true);
		
		for(TipoSangre tiposangre: tiposangres) {
			if(tiposangre.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoSangre(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoSangreConstantesFunciones.getArrayColumnasGlobalesTipoSangre(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoSangre(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoSangreConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoSangreConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoSangre(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoSangre> tiposangres,TipoSangre tiposangre,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoSangre tiposangreAux: tiposangres) {
			if(tiposangreAux!=null && tiposangre!=null) {
				if((tiposangreAux.getId()==null && tiposangre.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiposangreAux.getId()!=null && tiposangre.getId()!=null){
					if(tiposangreAux.getId().equals(tiposangre.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoSangre(List<TipoSangre> tiposangres) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoSangre tiposangre: tiposangres) {			
			if(tiposangre.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoSangre() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoSangreConstantesFunciones.LABEL_ID, TipoSangreConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSangreConstantesFunciones.LABEL_VERSIONROW, TipoSangreConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSangreConstantesFunciones.LABEL_IDEMPRESA, TipoSangreConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSangreConstantesFunciones.LABEL_CODIGO, TipoSangreConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoSangreConstantesFunciones.LABEL_NOMBRE, TipoSangreConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoSangre() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoSangreConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSangreConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSangreConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSangreConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoSangreConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSangre() throws Exception  {
		return TipoSangreConstantesFunciones.getTiposSeleccionarTipoSangre(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSangre(Boolean conFk) throws Exception  {
		return TipoSangreConstantesFunciones.getTiposSeleccionarTipoSangre(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoSangre(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoSangreConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoSangreConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoSangreConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoSangreConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoSangreConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoSangreConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoSangre(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoSangre(TipoSangre tiposangreAux) throws Exception {
		
			tiposangreAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiposangreAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoSangre(List<TipoSangre> tiposangresTemp) throws Exception {
		for(TipoSangre tiposangreAux:tiposangresTemp) {
			
			tiposangreAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiposangreAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoSangre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoSangre(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoSangre(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoSangreConstantesFunciones.getClassesRelationshipsOfTipoSangre(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoSangre(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DatoGeneralEmpleado.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DatoGeneralEmpleado.class)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoSangre(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoSangreConstantesFunciones.getClassesRelationshipsFromStringsOfTipoSangre(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoSangre(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DatoGeneralEmpleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DatoGeneralEmpleado.class)); continue;
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
	public static void actualizarLista(TipoSangre tiposangre,List<TipoSangre> tiposangres,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoSangre tiposangreEncontrado=null;
			
			for(TipoSangre tiposangreLocal:tiposangres) {
				if(tiposangreLocal.getId().equals(tiposangre.getId())) {
					tiposangreEncontrado=tiposangreLocal;
					
					tiposangreLocal.setIsChanged(tiposangre.getIsChanged());
					tiposangreLocal.setIsNew(tiposangre.getIsNew());
					tiposangreLocal.setIsDeleted(tiposangre.getIsDeleted());
					
					tiposangreLocal.setGeneralEntityOriginal(tiposangre.getGeneralEntityOriginal());
					
					tiposangreLocal.setId(tiposangre.getId());	
					tiposangreLocal.setVersionRow(tiposangre.getVersionRow());	
					tiposangreLocal.setid_empresa(tiposangre.getid_empresa());	
					tiposangreLocal.setcodigo(tiposangre.getcodigo());	
					tiposangreLocal.setnombre(tiposangre.getnombre());	
					
					
					tiposangreLocal.setDatoGeneralEmpleados(tiposangre.getDatoGeneralEmpleados());
					
					existe=true;
					break;
				}
			}
			
			if(!tiposangre.getIsDeleted()) {
				if(!existe) {
					tiposangres.add(tiposangre);
				}
			} else {
				if(tiposangreEncontrado!=null && permiteQuitar)  {
					tiposangres.remove(tiposangreEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoSangre tiposangre,List<TipoSangre> tiposangres) throws Exception {
		try	{			
			for(TipoSangre tiposangreLocal:tiposangres) {
				if(tiposangreLocal.getId().equals(tiposangre.getId())) {
					tiposangreLocal.setIsSelected(tiposangre.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoSangre(List<TipoSangre> tiposangresAux) throws Exception {
		//this.tiposangresAux=tiposangresAux;
		
		for(TipoSangre tiposangreAux:tiposangresAux) {
			if(tiposangreAux.getIsChanged()) {
				tiposangreAux.setIsChanged(false);
			}		
			
			if(tiposangreAux.getIsNew()) {
				tiposangreAux.setIsNew(false);
			}	
			
			if(tiposangreAux.getIsDeleted()) {
				tiposangreAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoSangre(TipoSangre tiposangreAux) throws Exception {
		//this.tiposangreAux=tiposangreAux;
		
			if(tiposangreAux.getIsChanged()) {
				tiposangreAux.setIsChanged(false);
			}		
			
			if(tiposangreAux.getIsNew()) {
				tiposangreAux.setIsNew(false);
			}	
			
			if(tiposangreAux.getIsDeleted()) {
				tiposangreAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoSangre tiposangreAsignar,TipoSangre tiposangre) throws Exception {
		tiposangreAsignar.setId(tiposangre.getId());	
		tiposangreAsignar.setVersionRow(tiposangre.getVersionRow());	
		tiposangreAsignar.setid_empresa(tiposangre.getid_empresa());
		tiposangreAsignar.setempresa_descripcion(tiposangre.getempresa_descripcion());	
		tiposangreAsignar.setcodigo(tiposangre.getcodigo());	
		tiposangreAsignar.setnombre(tiposangre.getnombre());	
	}
	
	public static void inicializarTipoSangre(TipoSangre tiposangre) throws Exception {
		try {
				tiposangre.setId(0L);	
					
				tiposangre.setid_empresa(-1L);	
				tiposangre.setcodigo("");	
				tiposangre.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoSangre(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoSangreConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoSangreConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoSangreConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoSangre(String sTipo,Row row,Workbook workbook,TipoSangre tiposangre,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposangre.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposangre.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiposangre.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoSangre=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoSangre() {
		return this.sFinalQueryTipoSangre;
	}
	
	public void setsFinalQueryTipoSangre(String sFinalQueryTipoSangre) {
		this.sFinalQueryTipoSangre= sFinalQueryTipoSangre;
	}
	
	public Border resaltarSeleccionarTipoSangre=null;
	
	public Border setResaltarSeleccionarTipoSangre(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSangreBeanSwingJInternalFrame tiposangreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiposangreBeanSwingJInternalFrame.jTtoolBarTipoSangre.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoSangre= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoSangre() {
		return this.resaltarSeleccionarTipoSangre;
	}
	
	public void setResaltarSeleccionarTipoSangre(Border borderResaltarSeleccionarTipoSangre) {
		this.resaltarSeleccionarTipoSangre= borderResaltarSeleccionarTipoSangre;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoSangre=null;
	public Boolean mostraridTipoSangre=true;
	public Boolean activaridTipoSangre=true;

	public Border resaltarid_empresaTipoSangre=null;
	public Boolean mostrarid_empresaTipoSangre=true;
	public Boolean activarid_empresaTipoSangre=true;
	public Boolean cargarid_empresaTipoSangre=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoSangre=false;//ConEventDepend=true

	public Border resaltarcodigoTipoSangre=null;
	public Boolean mostrarcodigoTipoSangre=true;
	public Boolean activarcodigoTipoSangre=true;

	public Border resaltarnombreTipoSangre=null;
	public Boolean mostrarnombreTipoSangre=true;
	public Boolean activarnombreTipoSangre=true;

	
	

	public Border setResaltaridTipoSangre(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSangreBeanSwingJInternalFrame tiposangreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposangreBeanSwingJInternalFrame.jTtoolBarTipoSangre.setBorder(borderResaltar);
		
		this.resaltaridTipoSangre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoSangre() {
		return this.resaltaridTipoSangre;
	}

	public void setResaltaridTipoSangre(Border borderResaltar) {
		this.resaltaridTipoSangre= borderResaltar;
	}

	public Boolean getMostraridTipoSangre() {
		return this.mostraridTipoSangre;
	}

	public void setMostraridTipoSangre(Boolean mostraridTipoSangre) {
		this.mostraridTipoSangre= mostraridTipoSangre;
	}

	public Boolean getActivaridTipoSangre() {
		return this.activaridTipoSangre;
	}

	public void setActivaridTipoSangre(Boolean activaridTipoSangre) {
		this.activaridTipoSangre= activaridTipoSangre;
	}

	public Border setResaltarid_empresaTipoSangre(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSangreBeanSwingJInternalFrame tiposangreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposangreBeanSwingJInternalFrame.jTtoolBarTipoSangre.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoSangre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoSangre() {
		return this.resaltarid_empresaTipoSangre;
	}

	public void setResaltarid_empresaTipoSangre(Border borderResaltar) {
		this.resaltarid_empresaTipoSangre= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoSangre() {
		return this.mostrarid_empresaTipoSangre;
	}

	public void setMostrarid_empresaTipoSangre(Boolean mostrarid_empresaTipoSangre) {
		this.mostrarid_empresaTipoSangre= mostrarid_empresaTipoSangre;
	}

	public Boolean getActivarid_empresaTipoSangre() {
		return this.activarid_empresaTipoSangre;
	}

	public void setActivarid_empresaTipoSangre(Boolean activarid_empresaTipoSangre) {
		this.activarid_empresaTipoSangre= activarid_empresaTipoSangre;
	}

	public Boolean getCargarid_empresaTipoSangre() {
		return this.cargarid_empresaTipoSangre;
	}

	public void setCargarid_empresaTipoSangre(Boolean cargarid_empresaTipoSangre) {
		this.cargarid_empresaTipoSangre= cargarid_empresaTipoSangre;
	}

	public Border setResaltarcodigoTipoSangre(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSangreBeanSwingJInternalFrame tiposangreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposangreBeanSwingJInternalFrame.jTtoolBarTipoSangre.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoSangre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoSangre() {
		return this.resaltarcodigoTipoSangre;
	}

	public void setResaltarcodigoTipoSangre(Border borderResaltar) {
		this.resaltarcodigoTipoSangre= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoSangre() {
		return this.mostrarcodigoTipoSangre;
	}

	public void setMostrarcodigoTipoSangre(Boolean mostrarcodigoTipoSangre) {
		this.mostrarcodigoTipoSangre= mostrarcodigoTipoSangre;
	}

	public Boolean getActivarcodigoTipoSangre() {
		return this.activarcodigoTipoSangre;
	}

	public void setActivarcodigoTipoSangre(Boolean activarcodigoTipoSangre) {
		this.activarcodigoTipoSangre= activarcodigoTipoSangre;
	}

	public Border setResaltarnombreTipoSangre(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSangreBeanSwingJInternalFrame tiposangreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiposangreBeanSwingJInternalFrame.jTtoolBarTipoSangre.setBorder(borderResaltar);
		
		this.resaltarnombreTipoSangre= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoSangre() {
		return this.resaltarnombreTipoSangre;
	}

	public void setResaltarnombreTipoSangre(Border borderResaltar) {
		this.resaltarnombreTipoSangre= borderResaltar;
	}

	public Boolean getMostrarnombreTipoSangre() {
		return this.mostrarnombreTipoSangre;
	}

	public void setMostrarnombreTipoSangre(Boolean mostrarnombreTipoSangre) {
		this.mostrarnombreTipoSangre= mostrarnombreTipoSangre;
	}

	public Boolean getActivarnombreTipoSangre() {
		return this.activarnombreTipoSangre;
	}

	public void setActivarnombreTipoSangre(Boolean activarnombreTipoSangre) {
		this.activarnombreTipoSangre= activarnombreTipoSangre;
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
		
		
		this.setMostraridTipoSangre(esInicial);
		this.setMostrarid_empresaTipoSangre(esInicial);
		this.setMostrarcodigoTipoSangre(esInicial);
		this.setMostrarnombreTipoSangre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSangreConstantesFunciones.ID)) {
				this.setMostraridTipoSangre(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSangreConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoSangre(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSangreConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoSangre(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSangreConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoSangre(esAsigna);
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
		
		
		this.setActivaridTipoSangre(esInicial);
		this.setActivarid_empresaTipoSangre(esInicial);
		this.setActivarcodigoTipoSangre(esInicial);
		this.setActivarnombreTipoSangre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSangreConstantesFunciones.ID)) {
				this.setActivaridTipoSangre(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSangreConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoSangre(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSangreConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoSangre(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSangreConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoSangre(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoSangreBeanSwingJInternalFrame tiposangreBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoSangre(esInicial);
		this.setResaltarid_empresaTipoSangre(esInicial);
		this.setResaltarcodigoTipoSangre(esInicial);
		this.setResaltarnombreTipoSangre(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoSangreConstantesFunciones.ID)) {
				this.setResaltaridTipoSangre(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSangreConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoSangre(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSangreConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoSangre(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoSangreConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoSangre(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDatoGeneralEmpleadoTipoSangre=null;

	public Border getResaltarDatoGeneralEmpleadoTipoSangre() {
		return this.resaltarDatoGeneralEmpleadoTipoSangre;
	}

	public void setResaltarDatoGeneralEmpleadoTipoSangre(Border borderResaltarDatoGeneralEmpleado) {
		if(borderResaltarDatoGeneralEmpleado!=null) {
			this.resaltarDatoGeneralEmpleadoTipoSangre= borderResaltarDatoGeneralEmpleado;
		}
	}

	public Border setResaltarDatoGeneralEmpleadoTipoSangre(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSangreBeanSwingJInternalFrame tiposangreBeanSwingJInternalFrame*/) {
		Border borderResaltarDatoGeneralEmpleado=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiposangreBeanSwingJInternalFrame.jTtoolBarTipoSangre.setBorder(borderResaltarDatoGeneralEmpleado);
			
		this.resaltarDatoGeneralEmpleadoTipoSangre= borderResaltarDatoGeneralEmpleado;

		 return borderResaltarDatoGeneralEmpleado;
	}



	public Boolean mostrarDatoGeneralEmpleadoTipoSangre=true;

	public Boolean getMostrarDatoGeneralEmpleadoTipoSangre() {
		return this.mostrarDatoGeneralEmpleadoTipoSangre;
	}

	public void setMostrarDatoGeneralEmpleadoTipoSangre(Boolean visibilidadResaltarDatoGeneralEmpleado) {
		this.mostrarDatoGeneralEmpleadoTipoSangre= visibilidadResaltarDatoGeneralEmpleado;
	}



	public Boolean activarDatoGeneralEmpleadoTipoSangre=true;

	public Boolean gethabilitarResaltarDatoGeneralEmpleadoTipoSangre() {
		return this.activarDatoGeneralEmpleadoTipoSangre;
	}

	public void setActivarDatoGeneralEmpleadoTipoSangre(Boolean habilitarResaltarDatoGeneralEmpleado) {
		this.activarDatoGeneralEmpleadoTipoSangre= habilitarResaltarDatoGeneralEmpleado;
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

		this.setMostrarDatoGeneralEmpleadoTipoSangre(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setMostrarDatoGeneralEmpleadoTipoSangre(esAsigna);
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

		this.setActivarDatoGeneralEmpleadoTipoSangre(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setActivarDatoGeneralEmpleadoTipoSangre(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoSangreBeanSwingJInternalFrame tiposangreBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDatoGeneralEmpleadoTipoSangre(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DatoGeneralEmpleado.class)) {
				this.setResaltarDatoGeneralEmpleadoTipoSangre(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoSangre=true;

	public Boolean getMostrarFK_IdEmpresaTipoSangre() {
		return this.mostrarFK_IdEmpresaTipoSangre;
	}

	public void setMostrarFK_IdEmpresaTipoSangre(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoSangre= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoSangre=true;

	public Boolean getActivarFK_IdEmpresaTipoSangre() {
		return this.activarFK_IdEmpresaTipoSangre;
	}

	public void setActivarFK_IdEmpresaTipoSangre(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoSangre= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoSangre=null;

	public Border getResaltarFK_IdEmpresaTipoSangre() {
		return this.resaltarFK_IdEmpresaTipoSangre;
	}

	public void setResaltarFK_IdEmpresaTipoSangre(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoSangre= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoSangre(ParametroGeneralUsuario parametroGeneralUsuario/*TipoSangreBeanSwingJInternalFrame tiposangreBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoSangre= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}