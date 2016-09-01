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


import com.bydan.erp.cartera.util.TipoBienConstantesFunciones;
import com.bydan.erp.cartera.util.TipoBienParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoBienParameterGeneral;

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
final public class TipoBienConstantesFunciones extends TipoBienConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoBien";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoBien"+TipoBienConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoBienHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoBienHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoBienConstantesFunciones.SCHEMA+"_"+TipoBienConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoBienHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoBienConstantesFunciones.SCHEMA+"_"+TipoBienConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoBienConstantesFunciones.SCHEMA+"_"+TipoBienConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoBienHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoBienConstantesFunciones.SCHEMA+"_"+TipoBienConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBienConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoBienHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBienConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBienConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoBienHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoBienConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoBienConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoBienConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoBienConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoBienConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Bienes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Bien";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Bien";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoBien";
	public static final String OBJECTNAME="tipobien";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_bien";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipobien from "+TipoBienConstantesFunciones.SPERSISTENCENAME+" tipobien";
	public static String QUERYSELECTNATIVE="select "+TipoBienConstantesFunciones.SCHEMA+"."+TipoBienConstantesFunciones.TABLENAME+".id,"+TipoBienConstantesFunciones.SCHEMA+"."+TipoBienConstantesFunciones.TABLENAME+".version_row,"+TipoBienConstantesFunciones.SCHEMA+"."+TipoBienConstantesFunciones.TABLENAME+".id_empresa,"+TipoBienConstantesFunciones.SCHEMA+"."+TipoBienConstantesFunciones.TABLENAME+".codigo,"+TipoBienConstantesFunciones.SCHEMA+"."+TipoBienConstantesFunciones.TABLENAME+".nombre from "+TipoBienConstantesFunciones.SCHEMA+"."+TipoBienConstantesFunciones.TABLENAME;//+" as "+TipoBienConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoBienConstantesFuncionesAdditional tipobienConstantesFuncionesAdditional=null;
	
	public TipoBienConstantesFuncionesAdditional getTipoBienConstantesFuncionesAdditional() {
		return this.tipobienConstantesFuncionesAdditional;
	}
	
	public void setTipoBienConstantesFuncionesAdditional(TipoBienConstantesFuncionesAdditional tipobienConstantesFuncionesAdditional) {
		try {
			this.tipobienConstantesFuncionesAdditional=tipobienConstantesFuncionesAdditional;
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
	
	public static String getTipoBienLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoBienConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoBienConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoBienConstantesFunciones.CODIGO)) {sLabelColumna=TipoBienConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoBienConstantesFunciones.NOMBRE)) {sLabelColumna=TipoBienConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoBienDescripcion(TipoBien tipobien) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipobien !=null/* && tipobien.getId()!=0*/) {
			sDescripcion=tipobien.getcodigo();//tipobientipobien.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoBienDescripcionDetallado(TipoBien tipobien) {
		String sDescripcion="";
			
		sDescripcion+=TipoBienConstantesFunciones.ID+"=";
		sDescripcion+=tipobien.getId().toString()+",";
		sDescripcion+=TipoBienConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipobien.getVersionRow().toString()+",";
		sDescripcion+=TipoBienConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipobien.getid_empresa().toString()+",";
		sDescripcion+=TipoBienConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipobien.getcodigo()+",";
		sDescripcion+=TipoBienConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipobien.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoBienDescripcion(TipoBien tipobien,String sValor) throws Exception {			
		if(tipobien !=null) {
			tipobien.setcodigo(sValor);;//tipobientipobien.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoBien(TipoBien tipobien,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipobien.setcodigo(tipobien.getcodigo().trim());
		tipobien.setnombre(tipobien.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoBiens(List<TipoBien> tipobiens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoBien tipobien: tipobiens) {
			tipobien.setcodigo(tipobien.getcodigo().trim());
			tipobien.setnombre(tipobien.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoBien(TipoBien tipobien,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipobien.getConCambioAuxiliar()) {
			tipobien.setIsDeleted(tipobien.getIsDeletedAuxiliar());	
			tipobien.setIsNew(tipobien.getIsNewAuxiliar());	
			tipobien.setIsChanged(tipobien.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipobien.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipobien.setIsDeletedAuxiliar(false);	
			tipobien.setIsNewAuxiliar(false);	
			tipobien.setIsChangedAuxiliar(false);
			
			tipobien.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoBiens(List<TipoBien> tipobiens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoBien tipobien : tipobiens) {
			if(conAsignarBase && tipobien.getConCambioAuxiliar()) {
				tipobien.setIsDeleted(tipobien.getIsDeletedAuxiliar());	
				tipobien.setIsNew(tipobien.getIsNewAuxiliar());	
				tipobien.setIsChanged(tipobien.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipobien.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipobien.setIsDeletedAuxiliar(false);	
				tipobien.setIsNewAuxiliar(false);	
				tipobien.setIsChangedAuxiliar(false);
				
				tipobien.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoBien(TipoBien tipobien,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoBiens(List<TipoBien> tipobiens,Boolean conEnteros) throws Exception  {
		
		for(TipoBien tipobien: tipobiens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoBien(List<TipoBien> tipobiens,TipoBien tipobienAux) throws Exception  {
		TipoBienConstantesFunciones.InicializarValoresTipoBien(tipobienAux,true);
		
		for(TipoBien tipobien: tipobiens) {
			if(tipobien.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoBien(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoBienConstantesFunciones.getArrayColumnasGlobalesTipoBien(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoBien(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoBienConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoBienConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoBien(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoBien> tipobiens,TipoBien tipobien,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoBien tipobienAux: tipobiens) {
			if(tipobienAux!=null && tipobien!=null) {
				if((tipobienAux.getId()==null && tipobien.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipobienAux.getId()!=null && tipobien.getId()!=null){
					if(tipobienAux.getId().equals(tipobien.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoBien(List<TipoBien> tipobiens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoBien tipobien: tipobiens) {			
			if(tipobien.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoBien() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoBienConstantesFunciones.LABEL_ID, TipoBienConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBienConstantesFunciones.LABEL_VERSIONROW, TipoBienConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBienConstantesFunciones.LABEL_IDEMPRESA, TipoBienConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBienConstantesFunciones.LABEL_CODIGO, TipoBienConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoBienConstantesFunciones.LABEL_NOMBRE, TipoBienConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoBien() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoBienConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBienConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBienConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBienConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoBienConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBien() throws Exception  {
		return TipoBienConstantesFunciones.getTiposSeleccionarTipoBien(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBien(Boolean conFk) throws Exception  {
		return TipoBienConstantesFunciones.getTiposSeleccionarTipoBien(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoBien(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBienConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoBienConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBienConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoBienConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoBienConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoBienConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoBien(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoBien(TipoBien tipobienAux) throws Exception {
		
			tipobienAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipobienAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoBien(List<TipoBien> tipobiensTemp) throws Exception {
		for(TipoBien tipobienAux:tipobiensTemp) {
			
			tipobienAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipobienAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoBien(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoBien(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoBien(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoBienConstantesFunciones.getClassesRelationshipsOfTipoBien(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoBien(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Bien.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Bien.class)) {
						classes.add(new Classe(Bien.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoBien(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoBienConstantesFunciones.getClassesRelationshipsFromStringsOfTipoBien(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoBien(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Bien.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bien.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Bien.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bien.class)); continue;
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
	public static void actualizarLista(TipoBien tipobien,List<TipoBien> tipobiens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoBien tipobienEncontrado=null;
			
			for(TipoBien tipobienLocal:tipobiens) {
				if(tipobienLocal.getId().equals(tipobien.getId())) {
					tipobienEncontrado=tipobienLocal;
					
					tipobienLocal.setIsChanged(tipobien.getIsChanged());
					tipobienLocal.setIsNew(tipobien.getIsNew());
					tipobienLocal.setIsDeleted(tipobien.getIsDeleted());
					
					tipobienLocal.setGeneralEntityOriginal(tipobien.getGeneralEntityOriginal());
					
					tipobienLocal.setId(tipobien.getId());	
					tipobienLocal.setVersionRow(tipobien.getVersionRow());	
					tipobienLocal.setid_empresa(tipobien.getid_empresa());	
					tipobienLocal.setcodigo(tipobien.getcodigo());	
					tipobienLocal.setnombre(tipobien.getnombre());	
					
					
					tipobienLocal.setBiens(tipobien.getBiens());
					
					existe=true;
					break;
				}
			}
			
			if(!tipobien.getIsDeleted()) {
				if(!existe) {
					tipobiens.add(tipobien);
				}
			} else {
				if(tipobienEncontrado!=null && permiteQuitar)  {
					tipobiens.remove(tipobienEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoBien tipobien,List<TipoBien> tipobiens) throws Exception {
		try	{			
			for(TipoBien tipobienLocal:tipobiens) {
				if(tipobienLocal.getId().equals(tipobien.getId())) {
					tipobienLocal.setIsSelected(tipobien.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoBien(List<TipoBien> tipobiensAux) throws Exception {
		//this.tipobiensAux=tipobiensAux;
		
		for(TipoBien tipobienAux:tipobiensAux) {
			if(tipobienAux.getIsChanged()) {
				tipobienAux.setIsChanged(false);
			}		
			
			if(tipobienAux.getIsNew()) {
				tipobienAux.setIsNew(false);
			}	
			
			if(tipobienAux.getIsDeleted()) {
				tipobienAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoBien(TipoBien tipobienAux) throws Exception {
		//this.tipobienAux=tipobienAux;
		
			if(tipobienAux.getIsChanged()) {
				tipobienAux.setIsChanged(false);
			}		
			
			if(tipobienAux.getIsNew()) {
				tipobienAux.setIsNew(false);
			}	
			
			if(tipobienAux.getIsDeleted()) {
				tipobienAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoBien tipobienAsignar,TipoBien tipobien) throws Exception {
		tipobienAsignar.setId(tipobien.getId());	
		tipobienAsignar.setVersionRow(tipobien.getVersionRow());	
		tipobienAsignar.setid_empresa(tipobien.getid_empresa());
		tipobienAsignar.setempresa_descripcion(tipobien.getempresa_descripcion());	
		tipobienAsignar.setcodigo(tipobien.getcodigo());	
		tipobienAsignar.setnombre(tipobien.getnombre());	
	}
	
	public static void inicializarTipoBien(TipoBien tipobien) throws Exception {
		try {
				tipobien.setId(0L);	
					
				tipobien.setid_empresa(-1L);	
				tipobien.setcodigo("");	
				tipobien.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoBien(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBienConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBienConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoBienConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoBien(String sTipo,Row row,Workbook workbook,TipoBien tipobien,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipobien.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipobien.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipobien.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoBien=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoBien() {
		return this.sFinalQueryTipoBien;
	}
	
	public void setsFinalQueryTipoBien(String sFinalQueryTipoBien) {
		this.sFinalQueryTipoBien= sFinalQueryTipoBien;
	}
	
	public Border resaltarSeleccionarTipoBien=null;
	
	public Border setResaltarSeleccionarTipoBien(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBienBeanSwingJInternalFrame tipobienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipobienBeanSwingJInternalFrame.jTtoolBarTipoBien.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoBien= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoBien() {
		return this.resaltarSeleccionarTipoBien;
	}
	
	public void setResaltarSeleccionarTipoBien(Border borderResaltarSeleccionarTipoBien) {
		this.resaltarSeleccionarTipoBien= borderResaltarSeleccionarTipoBien;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoBien=null;
	public Boolean mostraridTipoBien=true;
	public Boolean activaridTipoBien=true;

	public Border resaltarid_empresaTipoBien=null;
	public Boolean mostrarid_empresaTipoBien=true;
	public Boolean activarid_empresaTipoBien=true;
	public Boolean cargarid_empresaTipoBien=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoBien=false;//ConEventDepend=true

	public Border resaltarcodigoTipoBien=null;
	public Boolean mostrarcodigoTipoBien=true;
	public Boolean activarcodigoTipoBien=true;

	public Border resaltarnombreTipoBien=null;
	public Boolean mostrarnombreTipoBien=true;
	public Boolean activarnombreTipoBien=true;

	
	

	public Border setResaltaridTipoBien(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBienBeanSwingJInternalFrame tipobienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobienBeanSwingJInternalFrame.jTtoolBarTipoBien.setBorder(borderResaltar);
		
		this.resaltaridTipoBien= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoBien() {
		return this.resaltaridTipoBien;
	}

	public void setResaltaridTipoBien(Border borderResaltar) {
		this.resaltaridTipoBien= borderResaltar;
	}

	public Boolean getMostraridTipoBien() {
		return this.mostraridTipoBien;
	}

	public void setMostraridTipoBien(Boolean mostraridTipoBien) {
		this.mostraridTipoBien= mostraridTipoBien;
	}

	public Boolean getActivaridTipoBien() {
		return this.activaridTipoBien;
	}

	public void setActivaridTipoBien(Boolean activaridTipoBien) {
		this.activaridTipoBien= activaridTipoBien;
	}

	public Border setResaltarid_empresaTipoBien(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBienBeanSwingJInternalFrame tipobienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobienBeanSwingJInternalFrame.jTtoolBarTipoBien.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoBien= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoBien() {
		return this.resaltarid_empresaTipoBien;
	}

	public void setResaltarid_empresaTipoBien(Border borderResaltar) {
		this.resaltarid_empresaTipoBien= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoBien() {
		return this.mostrarid_empresaTipoBien;
	}

	public void setMostrarid_empresaTipoBien(Boolean mostrarid_empresaTipoBien) {
		this.mostrarid_empresaTipoBien= mostrarid_empresaTipoBien;
	}

	public Boolean getActivarid_empresaTipoBien() {
		return this.activarid_empresaTipoBien;
	}

	public void setActivarid_empresaTipoBien(Boolean activarid_empresaTipoBien) {
		this.activarid_empresaTipoBien= activarid_empresaTipoBien;
	}

	public Boolean getCargarid_empresaTipoBien() {
		return this.cargarid_empresaTipoBien;
	}

	public void setCargarid_empresaTipoBien(Boolean cargarid_empresaTipoBien) {
		this.cargarid_empresaTipoBien= cargarid_empresaTipoBien;
	}

	public Border setResaltarcodigoTipoBien(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBienBeanSwingJInternalFrame tipobienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobienBeanSwingJInternalFrame.jTtoolBarTipoBien.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoBien= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoBien() {
		return this.resaltarcodigoTipoBien;
	}

	public void setResaltarcodigoTipoBien(Border borderResaltar) {
		this.resaltarcodigoTipoBien= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoBien() {
		return this.mostrarcodigoTipoBien;
	}

	public void setMostrarcodigoTipoBien(Boolean mostrarcodigoTipoBien) {
		this.mostrarcodigoTipoBien= mostrarcodigoTipoBien;
	}

	public Boolean getActivarcodigoTipoBien() {
		return this.activarcodigoTipoBien;
	}

	public void setActivarcodigoTipoBien(Boolean activarcodigoTipoBien) {
		this.activarcodigoTipoBien= activarcodigoTipoBien;
	}

	public Border setResaltarnombreTipoBien(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBienBeanSwingJInternalFrame tipobienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipobienBeanSwingJInternalFrame.jTtoolBarTipoBien.setBorder(borderResaltar);
		
		this.resaltarnombreTipoBien= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoBien() {
		return this.resaltarnombreTipoBien;
	}

	public void setResaltarnombreTipoBien(Border borderResaltar) {
		this.resaltarnombreTipoBien= borderResaltar;
	}

	public Boolean getMostrarnombreTipoBien() {
		return this.mostrarnombreTipoBien;
	}

	public void setMostrarnombreTipoBien(Boolean mostrarnombreTipoBien) {
		this.mostrarnombreTipoBien= mostrarnombreTipoBien;
	}

	public Boolean getActivarnombreTipoBien() {
		return this.activarnombreTipoBien;
	}

	public void setActivarnombreTipoBien(Boolean activarnombreTipoBien) {
		this.activarnombreTipoBien= activarnombreTipoBien;
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
		
		
		this.setMostraridTipoBien(esInicial);
		this.setMostrarid_empresaTipoBien(esInicial);
		this.setMostrarcodigoTipoBien(esInicial);
		this.setMostrarnombreTipoBien(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBienConstantesFunciones.ID)) {
				this.setMostraridTipoBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBienConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBienConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBienConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoBien(esAsigna);
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
		
		
		this.setActivaridTipoBien(esInicial);
		this.setActivarid_empresaTipoBien(esInicial);
		this.setActivarcodigoTipoBien(esInicial);
		this.setActivarnombreTipoBien(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBienConstantesFunciones.ID)) {
				this.setActivaridTipoBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBienConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBienConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBienConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoBien(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoBienBeanSwingJInternalFrame tipobienBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoBien(esInicial);
		this.setResaltarid_empresaTipoBien(esInicial);
		this.setResaltarcodigoTipoBien(esInicial);
		this.setResaltarnombreTipoBien(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoBienConstantesFunciones.ID)) {
				this.setResaltaridTipoBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBienConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBienConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoBien(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoBienConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoBien(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarBienTipoBien=null;

	public Border getResaltarBienTipoBien() {
		return this.resaltarBienTipoBien;
	}

	public void setResaltarBienTipoBien(Border borderResaltarBien) {
		if(borderResaltarBien!=null) {
			this.resaltarBienTipoBien= borderResaltarBien;
		}
	}

	public Border setResaltarBienTipoBien(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBienBeanSwingJInternalFrame tipobienBeanSwingJInternalFrame*/) {
		Border borderResaltarBien=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipobienBeanSwingJInternalFrame.jTtoolBarTipoBien.setBorder(borderResaltarBien);
			
		this.resaltarBienTipoBien= borderResaltarBien;

		 return borderResaltarBien;
	}



	public Boolean mostrarBienTipoBien=true;

	public Boolean getMostrarBienTipoBien() {
		return this.mostrarBienTipoBien;
	}

	public void setMostrarBienTipoBien(Boolean visibilidadResaltarBien) {
		this.mostrarBienTipoBien= visibilidadResaltarBien;
	}



	public Boolean activarBienTipoBien=true;

	public Boolean gethabilitarResaltarBienTipoBien() {
		return this.activarBienTipoBien;
	}

	public void setActivarBienTipoBien(Boolean habilitarResaltarBien) {
		this.activarBienTipoBien= habilitarResaltarBien;
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

		this.setMostrarBienTipoBien(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Bien.class)) {
				this.setMostrarBienTipoBien(esAsigna);
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

		this.setActivarBienTipoBien(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Bien.class)) {
				this.setActivarBienTipoBien(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoBienBeanSwingJInternalFrame tipobienBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarBienTipoBien(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Bien.class)) {
				this.setResaltarBienTipoBien(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoBien=true;

	public Boolean getMostrarFK_IdEmpresaTipoBien() {
		return this.mostrarFK_IdEmpresaTipoBien;
	}

	public void setMostrarFK_IdEmpresaTipoBien(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoBien= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoBien=true;

	public Boolean getActivarFK_IdEmpresaTipoBien() {
		return this.activarFK_IdEmpresaTipoBien;
	}

	public void setActivarFK_IdEmpresaTipoBien(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoBien= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoBien=null;

	public Border getResaltarFK_IdEmpresaTipoBien() {
		return this.resaltarFK_IdEmpresaTipoBien;
	}

	public void setResaltarFK_IdEmpresaTipoBien(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoBien= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoBien(ParametroGeneralUsuario parametroGeneralUsuario/*TipoBienBeanSwingJInternalFrame tipobienBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoBien= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}