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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.TipoInvenConstantesFunciones;
import com.bydan.erp.inventario.util.TipoInvenParameterReturnGeneral;
//import com.bydan.erp.inventario.util.TipoInvenParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoInvenConstantesFunciones extends TipoInvenConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoInven";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoInven"+TipoInvenConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoInvenHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoInvenHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoInvenConstantesFunciones.SCHEMA+"_"+TipoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoInvenConstantesFunciones.SCHEMA+"_"+TipoInvenConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoInvenConstantesFunciones.SCHEMA+"_"+TipoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoInvenConstantesFunciones.SCHEMA+"_"+TipoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoInvenHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoInvenConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoInvenConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoInvenConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoInvenConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoInvenConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Invenes";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Inven";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Inven";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoInven";
	public static final String OBJECTNAME="tipoinven";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="tipo_inven";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoinven from "+TipoInvenConstantesFunciones.SPERSISTENCENAME+" tipoinven";
	public static String QUERYSELECTNATIVE="select "+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+".id,"+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+".version_row,"+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+".id_empresa,"+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+".codigo,"+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME+".nombre from "+TipoInvenConstantesFunciones.SCHEMA+"."+TipoInvenConstantesFunciones.TABLENAME;//+" as "+TipoInvenConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoInvenConstantesFuncionesAdditional tipoinvenConstantesFuncionesAdditional=null;
	
	public TipoInvenConstantesFuncionesAdditional getTipoInvenConstantesFuncionesAdditional() {
		return this.tipoinvenConstantesFuncionesAdditional;
	}
	
	public void setTipoInvenConstantesFuncionesAdditional(TipoInvenConstantesFuncionesAdditional tipoinvenConstantesFuncionesAdditional) {
		try {
			this.tipoinvenConstantesFuncionesAdditional=tipoinvenConstantesFuncionesAdditional;
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
	
	public static String getTipoInvenLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoInvenConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoInvenConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoInvenConstantesFunciones.CODIGO)) {sLabelColumna=TipoInvenConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoInvenConstantesFunciones.NOMBRE)) {sLabelColumna=TipoInvenConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoInvenDescripcion(TipoInven tipoinven) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoinven !=null/* && tipoinven.getId()!=0*/) {
			sDescripcion=tipoinven.getcodigo();//tipoinventipoinven.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoInvenDescripcionDetallado(TipoInven tipoinven) {
		String sDescripcion="";
			
		sDescripcion+=TipoInvenConstantesFunciones.ID+"=";
		sDescripcion+=tipoinven.getId().toString()+",";
		sDescripcion+=TipoInvenConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoinven.getVersionRow().toString()+",";
		sDescripcion+=TipoInvenConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoinven.getid_empresa().toString()+",";
		sDescripcion+=TipoInvenConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoinven.getcodigo()+",";
		sDescripcion+=TipoInvenConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoinven.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoInvenDescripcion(TipoInven tipoinven,String sValor) throws Exception {			
		if(tipoinven !=null) {
			tipoinven.setcodigo(sValor);;//tipoinventipoinven.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoInven(TipoInven tipoinven,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoinven.setcodigo(tipoinven.getcodigo().trim());
		tipoinven.setnombre(tipoinven.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoInvens(List<TipoInven> tipoinvens,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoInven tipoinven: tipoinvens) {
			tipoinven.setcodigo(tipoinven.getcodigo().trim());
			tipoinven.setnombre(tipoinven.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoInven(TipoInven tipoinven,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoinven.getConCambioAuxiliar()) {
			tipoinven.setIsDeleted(tipoinven.getIsDeletedAuxiliar());	
			tipoinven.setIsNew(tipoinven.getIsNewAuxiliar());	
			tipoinven.setIsChanged(tipoinven.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoinven.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoinven.setIsDeletedAuxiliar(false);	
			tipoinven.setIsNewAuxiliar(false);	
			tipoinven.setIsChangedAuxiliar(false);
			
			tipoinven.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoInvens(List<TipoInven> tipoinvens,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoInven tipoinven : tipoinvens) {
			if(conAsignarBase && tipoinven.getConCambioAuxiliar()) {
				tipoinven.setIsDeleted(tipoinven.getIsDeletedAuxiliar());	
				tipoinven.setIsNew(tipoinven.getIsNewAuxiliar());	
				tipoinven.setIsChanged(tipoinven.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoinven.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoinven.setIsDeletedAuxiliar(false);	
				tipoinven.setIsNewAuxiliar(false);	
				tipoinven.setIsChangedAuxiliar(false);
				
				tipoinven.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoInven(TipoInven tipoinven,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoInvens(List<TipoInven> tipoinvens,Boolean conEnteros) throws Exception  {
		
		for(TipoInven tipoinven: tipoinvens) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoInven(List<TipoInven> tipoinvens,TipoInven tipoinvenAux) throws Exception  {
		TipoInvenConstantesFunciones.InicializarValoresTipoInven(tipoinvenAux,true);
		
		for(TipoInven tipoinven: tipoinvens) {
			if(tipoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoInvenConstantesFunciones.getArrayColumnasGlobalesTipoInven(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoInven(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoInvenConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoInvenConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoInven(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoInven> tipoinvens,TipoInven tipoinven,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoInven tipoinvenAux: tipoinvens) {
			if(tipoinvenAux!=null && tipoinven!=null) {
				if((tipoinvenAux.getId()==null && tipoinven.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoinvenAux.getId()!=null && tipoinven.getId()!=null){
					if(tipoinvenAux.getId().equals(tipoinven.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoInven(List<TipoInven> tipoinvens) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoInven tipoinven: tipoinvens) {			
			if(tipoinven.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoInven() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoInvenConstantesFunciones.LABEL_ID, TipoInvenConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInvenConstantesFunciones.LABEL_VERSIONROW, TipoInvenConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInvenConstantesFunciones.LABEL_IDEMPRESA, TipoInvenConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInvenConstantesFunciones.LABEL_CODIGO, TipoInvenConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoInvenConstantesFunciones.LABEL_NOMBRE, TipoInvenConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoInven() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoInvenConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInvenConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInvenConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInvenConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoInvenConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInven() throws Exception  {
		return TipoInvenConstantesFunciones.getTiposSeleccionarTipoInven(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInven(Boolean conFk) throws Exception  {
		return TipoInvenConstantesFunciones.getTiposSeleccionarTipoInven(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoInven(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoInvenConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoInvenConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoInvenConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoInvenConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoInvenConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoInvenConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoInven(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoInven(TipoInven tipoinvenAux) throws Exception {
		
			tipoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoinvenAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoInven(List<TipoInven> tipoinvensTemp) throws Exception {
		for(TipoInven tipoinvenAux:tipoinvensTemp) {
			
			tipoinvenAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoinvenAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoInvenConstantesFunciones.getClassesRelationshipsOfTipoInven(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoInven(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoInvenConstantesFunciones.getClassesRelationshipsFromStringsOfTipoInven(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoInven(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoInven tipoinven,List<TipoInven> tipoinvens,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoInven tipoinvenEncontrado=null;
			
			for(TipoInven tipoinvenLocal:tipoinvens) {
				if(tipoinvenLocal.getId().equals(tipoinven.getId())) {
					tipoinvenEncontrado=tipoinvenLocal;
					
					tipoinvenLocal.setIsChanged(tipoinven.getIsChanged());
					tipoinvenLocal.setIsNew(tipoinven.getIsNew());
					tipoinvenLocal.setIsDeleted(tipoinven.getIsDeleted());
					
					tipoinvenLocal.setGeneralEntityOriginal(tipoinven.getGeneralEntityOriginal());
					
					tipoinvenLocal.setId(tipoinven.getId());	
					tipoinvenLocal.setVersionRow(tipoinven.getVersionRow());	
					tipoinvenLocal.setid_empresa(tipoinven.getid_empresa());	
					tipoinvenLocal.setcodigo(tipoinven.getcodigo());	
					tipoinvenLocal.setnombre(tipoinven.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipoinven.getIsDeleted()) {
				if(!existe) {
					tipoinvens.add(tipoinven);
				}
			} else {
				if(tipoinvenEncontrado!=null && permiteQuitar)  {
					tipoinvens.remove(tipoinvenEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoInven tipoinven,List<TipoInven> tipoinvens) throws Exception {
		try	{			
			for(TipoInven tipoinvenLocal:tipoinvens) {
				if(tipoinvenLocal.getId().equals(tipoinven.getId())) {
					tipoinvenLocal.setIsSelected(tipoinven.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoInven(List<TipoInven> tipoinvensAux) throws Exception {
		//this.tipoinvensAux=tipoinvensAux;
		
		for(TipoInven tipoinvenAux:tipoinvensAux) {
			if(tipoinvenAux.getIsChanged()) {
				tipoinvenAux.setIsChanged(false);
			}		
			
			if(tipoinvenAux.getIsNew()) {
				tipoinvenAux.setIsNew(false);
			}	
			
			if(tipoinvenAux.getIsDeleted()) {
				tipoinvenAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoInven(TipoInven tipoinvenAux) throws Exception {
		//this.tipoinvenAux=tipoinvenAux;
		
			if(tipoinvenAux.getIsChanged()) {
				tipoinvenAux.setIsChanged(false);
			}		
			
			if(tipoinvenAux.getIsNew()) {
				tipoinvenAux.setIsNew(false);
			}	
			
			if(tipoinvenAux.getIsDeleted()) {
				tipoinvenAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoInven tipoinvenAsignar,TipoInven tipoinven) throws Exception {
		tipoinvenAsignar.setId(tipoinven.getId());	
		tipoinvenAsignar.setVersionRow(tipoinven.getVersionRow());	
		tipoinvenAsignar.setid_empresa(tipoinven.getid_empresa());
		tipoinvenAsignar.setempresa_descripcion(tipoinven.getempresa_descripcion());	
		tipoinvenAsignar.setcodigo(tipoinven.getcodigo());	
		tipoinvenAsignar.setnombre(tipoinven.getnombre());	
	}
	
	public static void inicializarTipoInven(TipoInven tipoinven) throws Exception {
		try {
				tipoinven.setId(0L);	
					
				tipoinven.setid_empresa(-1L);	
				tipoinven.setcodigo("");	
				tipoinven.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoInven(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoInvenConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoInvenConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoInvenConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoInven(String sTipo,Row row,Workbook workbook,TipoInven tipoinven,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoinven.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoinven.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoinven.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoInven=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoInven() {
		return this.sFinalQueryTipoInven;
	}
	
	public void setsFinalQueryTipoInven(String sFinalQueryTipoInven) {
		this.sFinalQueryTipoInven= sFinalQueryTipoInven;
	}
	
	public Border resaltarSeleccionarTipoInven=null;
	
	public Border setResaltarSeleccionarTipoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInvenBeanSwingJInternalFrame tipoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoinvenBeanSwingJInternalFrame.jTtoolBarTipoInven.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoInven= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoInven() {
		return this.resaltarSeleccionarTipoInven;
	}
	
	public void setResaltarSeleccionarTipoInven(Border borderResaltarSeleccionarTipoInven) {
		this.resaltarSeleccionarTipoInven= borderResaltarSeleccionarTipoInven;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoInven=null;
	public Boolean mostraridTipoInven=true;
	public Boolean activaridTipoInven=true;

	public Border resaltarid_empresaTipoInven=null;
	public Boolean mostrarid_empresaTipoInven=true;
	public Boolean activarid_empresaTipoInven=true;
	public Boolean cargarid_empresaTipoInven=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoInven=false;//ConEventDepend=true

	public Border resaltarcodigoTipoInven=null;
	public Boolean mostrarcodigoTipoInven=true;
	public Boolean activarcodigoTipoInven=true;

	public Border resaltarnombreTipoInven=null;
	public Boolean mostrarnombreTipoInven=true;
	public Boolean activarnombreTipoInven=true;

	
	

	public Border setResaltaridTipoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInvenBeanSwingJInternalFrame tipoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinvenBeanSwingJInternalFrame.jTtoolBarTipoInven.setBorder(borderResaltar);
		
		this.resaltaridTipoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoInven() {
		return this.resaltaridTipoInven;
	}

	public void setResaltaridTipoInven(Border borderResaltar) {
		this.resaltaridTipoInven= borderResaltar;
	}

	public Boolean getMostraridTipoInven() {
		return this.mostraridTipoInven;
	}

	public void setMostraridTipoInven(Boolean mostraridTipoInven) {
		this.mostraridTipoInven= mostraridTipoInven;
	}

	public Boolean getActivaridTipoInven() {
		return this.activaridTipoInven;
	}

	public void setActivaridTipoInven(Boolean activaridTipoInven) {
		this.activaridTipoInven= activaridTipoInven;
	}

	public Border setResaltarid_empresaTipoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInvenBeanSwingJInternalFrame tipoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinvenBeanSwingJInternalFrame.jTtoolBarTipoInven.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoInven() {
		return this.resaltarid_empresaTipoInven;
	}

	public void setResaltarid_empresaTipoInven(Border borderResaltar) {
		this.resaltarid_empresaTipoInven= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoInven() {
		return this.mostrarid_empresaTipoInven;
	}

	public void setMostrarid_empresaTipoInven(Boolean mostrarid_empresaTipoInven) {
		this.mostrarid_empresaTipoInven= mostrarid_empresaTipoInven;
	}

	public Boolean getActivarid_empresaTipoInven() {
		return this.activarid_empresaTipoInven;
	}

	public void setActivarid_empresaTipoInven(Boolean activarid_empresaTipoInven) {
		this.activarid_empresaTipoInven= activarid_empresaTipoInven;
	}

	public Boolean getCargarid_empresaTipoInven() {
		return this.cargarid_empresaTipoInven;
	}

	public void setCargarid_empresaTipoInven(Boolean cargarid_empresaTipoInven) {
		this.cargarid_empresaTipoInven= cargarid_empresaTipoInven;
	}

	public Border setResaltarcodigoTipoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInvenBeanSwingJInternalFrame tipoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinvenBeanSwingJInternalFrame.jTtoolBarTipoInven.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoInven() {
		return this.resaltarcodigoTipoInven;
	}

	public void setResaltarcodigoTipoInven(Border borderResaltar) {
		this.resaltarcodigoTipoInven= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoInven() {
		return this.mostrarcodigoTipoInven;
	}

	public void setMostrarcodigoTipoInven(Boolean mostrarcodigoTipoInven) {
		this.mostrarcodigoTipoInven= mostrarcodigoTipoInven;
	}

	public Boolean getActivarcodigoTipoInven() {
		return this.activarcodigoTipoInven;
	}

	public void setActivarcodigoTipoInven(Boolean activarcodigoTipoInven) {
		this.activarcodigoTipoInven= activarcodigoTipoInven;
	}

	public Border setResaltarnombreTipoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInvenBeanSwingJInternalFrame tipoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoinvenBeanSwingJInternalFrame.jTtoolBarTipoInven.setBorder(borderResaltar);
		
		this.resaltarnombreTipoInven= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoInven() {
		return this.resaltarnombreTipoInven;
	}

	public void setResaltarnombreTipoInven(Border borderResaltar) {
		this.resaltarnombreTipoInven= borderResaltar;
	}

	public Boolean getMostrarnombreTipoInven() {
		return this.mostrarnombreTipoInven;
	}

	public void setMostrarnombreTipoInven(Boolean mostrarnombreTipoInven) {
		this.mostrarnombreTipoInven= mostrarnombreTipoInven;
	}

	public Boolean getActivarnombreTipoInven() {
		return this.activarnombreTipoInven;
	}

	public void setActivarnombreTipoInven(Boolean activarnombreTipoInven) {
		this.activarnombreTipoInven= activarnombreTipoInven;
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
		
		
		this.setMostraridTipoInven(esInicial);
		this.setMostrarid_empresaTipoInven(esInicial);
		this.setMostrarcodigoTipoInven(esInicial);
		this.setMostrarnombreTipoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInvenConstantesFunciones.ID)) {
				this.setMostraridTipoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInvenConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInvenConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInvenConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoInven(esAsigna);
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
		
		
		this.setActivaridTipoInven(esInicial);
		this.setActivarid_empresaTipoInven(esInicial);
		this.setActivarcodigoTipoInven(esInicial);
		this.setActivarnombreTipoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInvenConstantesFunciones.ID)) {
				this.setActivaridTipoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInvenConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInvenConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInvenConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoInven(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoInvenBeanSwingJInternalFrame tipoinvenBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoInven(esInicial);
		this.setResaltarid_empresaTipoInven(esInicial);
		this.setResaltarcodigoTipoInven(esInicial);
		this.setResaltarnombreTipoInven(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoInvenConstantesFunciones.ID)) {
				this.setResaltaridTipoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInvenConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInvenConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoInven(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoInvenConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoInven(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoInvenBeanSwingJInternalFrame tipoinvenBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoInven=true;

	public Boolean getMostrarFK_IdEmpresaTipoInven() {
		return this.mostrarFK_IdEmpresaTipoInven;
	}

	public void setMostrarFK_IdEmpresaTipoInven(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoInven= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoInven=true;

	public Boolean getActivarFK_IdEmpresaTipoInven() {
		return this.activarFK_IdEmpresaTipoInven;
	}

	public void setActivarFK_IdEmpresaTipoInven(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoInven= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoInven=null;

	public Border getResaltarFK_IdEmpresaTipoInven() {
		return this.resaltarFK_IdEmpresaTipoInven;
	}

	public void setResaltarFK_IdEmpresaTipoInven(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoInven= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoInven(ParametroGeneralUsuario parametroGeneralUsuario/*TipoInvenBeanSwingJInternalFrame tipoinvenBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoInven= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}