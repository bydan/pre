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


import com.bydan.erp.cartera.util.TipoDireccionConstantesFunciones;
import com.bydan.erp.cartera.util.TipoDireccionParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoDireccionParameterGeneral;

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
final public class TipoDireccionConstantesFunciones extends TipoDireccionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDireccion";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDireccion"+TipoDireccionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDireccionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDireccionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDireccionConstantesFunciones.SCHEMA+"_"+TipoDireccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDireccionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDireccionConstantesFunciones.SCHEMA+"_"+TipoDireccionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDireccionConstantesFunciones.SCHEMA+"_"+TipoDireccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDireccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDireccionConstantesFunciones.SCHEMA+"_"+TipoDireccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDireccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDireccionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDireccionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDireccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDireccionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDireccionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDireccionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDireccionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDireccionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDireccionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Direcciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Direccion";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Direccion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDireccion";
	public static final String OBJECTNAME="tipodireccion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_direccion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodireccion from "+TipoDireccionConstantesFunciones.SPERSISTENCENAME+" tipodireccion";
	public static String QUERYSELECTNATIVE="select "+TipoDireccionConstantesFunciones.SCHEMA+"."+TipoDireccionConstantesFunciones.TABLENAME+".id,"+TipoDireccionConstantesFunciones.SCHEMA+"."+TipoDireccionConstantesFunciones.TABLENAME+".version_row,"+TipoDireccionConstantesFunciones.SCHEMA+"."+TipoDireccionConstantesFunciones.TABLENAME+".id_empresa,"+TipoDireccionConstantesFunciones.SCHEMA+"."+TipoDireccionConstantesFunciones.TABLENAME+".codigo,"+TipoDireccionConstantesFunciones.SCHEMA+"."+TipoDireccionConstantesFunciones.TABLENAME+".nombre from "+TipoDireccionConstantesFunciones.SCHEMA+"."+TipoDireccionConstantesFunciones.TABLENAME;//+" as "+TipoDireccionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoDireccionConstantesFuncionesAdditional tipodireccionConstantesFuncionesAdditional=null;
	
	public TipoDireccionConstantesFuncionesAdditional getTipoDireccionConstantesFuncionesAdditional() {
		return this.tipodireccionConstantesFuncionesAdditional;
	}
	
	public void setTipoDireccionConstantesFuncionesAdditional(TipoDireccionConstantesFuncionesAdditional tipodireccionConstantesFuncionesAdditional) {
		try {
			this.tipodireccionConstantesFuncionesAdditional=tipodireccionConstantesFuncionesAdditional;
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
	
	public static String getTipoDireccionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDireccionConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoDireccionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoDireccionConstantesFunciones.CODIGO)) {sLabelColumna=TipoDireccionConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoDireccionConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDireccionConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoDireccionDescripcion(TipoDireccion tipodireccion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodireccion !=null/* && tipodireccion.getId()!=0*/) {
			sDescripcion=tipodireccion.getcodigo();//tipodirecciontipodireccion.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDireccionDescripcionDetallado(TipoDireccion tipodireccion) {
		String sDescripcion="";
			
		sDescripcion+=TipoDireccionConstantesFunciones.ID+"=";
		sDescripcion+=tipodireccion.getId().toString()+",";
		sDescripcion+=TipoDireccionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodireccion.getVersionRow().toString()+",";
		sDescripcion+=TipoDireccionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipodireccion.getid_empresa().toString()+",";
		sDescripcion+=TipoDireccionConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipodireccion.getcodigo()+",";
		sDescripcion+=TipoDireccionConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodireccion.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDireccionDescripcion(TipoDireccion tipodireccion,String sValor) throws Exception {			
		if(tipodireccion !=null) {
			tipodireccion.setcodigo(sValor);;//tipodirecciontipodireccion.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoDireccion(TipoDireccion tipodireccion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodireccion.setcodigo(tipodireccion.getcodigo().trim());
		tipodireccion.setnombre(tipodireccion.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDireccions(List<TipoDireccion> tipodireccions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDireccion tipodireccion: tipodireccions) {
			tipodireccion.setcodigo(tipodireccion.getcodigo().trim());
			tipodireccion.setnombre(tipodireccion.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDireccion(TipoDireccion tipodireccion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodireccion.getConCambioAuxiliar()) {
			tipodireccion.setIsDeleted(tipodireccion.getIsDeletedAuxiliar());	
			tipodireccion.setIsNew(tipodireccion.getIsNewAuxiliar());	
			tipodireccion.setIsChanged(tipodireccion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodireccion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodireccion.setIsDeletedAuxiliar(false);	
			tipodireccion.setIsNewAuxiliar(false);	
			tipodireccion.setIsChangedAuxiliar(false);
			
			tipodireccion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDireccions(List<TipoDireccion> tipodireccions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDireccion tipodireccion : tipodireccions) {
			if(conAsignarBase && tipodireccion.getConCambioAuxiliar()) {
				tipodireccion.setIsDeleted(tipodireccion.getIsDeletedAuxiliar());	
				tipodireccion.setIsNew(tipodireccion.getIsNewAuxiliar());	
				tipodireccion.setIsChanged(tipodireccion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodireccion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodireccion.setIsDeletedAuxiliar(false);	
				tipodireccion.setIsNewAuxiliar(false);	
				tipodireccion.setIsChangedAuxiliar(false);
				
				tipodireccion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDireccion(TipoDireccion tipodireccion,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDireccions(List<TipoDireccion> tipodireccions,Boolean conEnteros) throws Exception  {
		
		for(TipoDireccion tipodireccion: tipodireccions) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDireccion(List<TipoDireccion> tipodireccions,TipoDireccion tipodireccionAux) throws Exception  {
		TipoDireccionConstantesFunciones.InicializarValoresTipoDireccion(tipodireccionAux,true);
		
		for(TipoDireccion tipodireccion: tipodireccions) {
			if(tipodireccion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDireccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDireccionConstantesFunciones.getArrayColumnasGlobalesTipoDireccion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDireccion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoDireccionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoDireccionConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDireccion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDireccion> tipodireccions,TipoDireccion tipodireccion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDireccion tipodireccionAux: tipodireccions) {
			if(tipodireccionAux!=null && tipodireccion!=null) {
				if((tipodireccionAux.getId()==null && tipodireccion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodireccionAux.getId()!=null && tipodireccion.getId()!=null){
					if(tipodireccionAux.getId().equals(tipodireccion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDireccion(List<TipoDireccion> tipodireccions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoDireccion tipodireccion: tipodireccions) {			
			if(tipodireccion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDireccion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDireccionConstantesFunciones.LABEL_ID, TipoDireccionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDireccionConstantesFunciones.LABEL_VERSIONROW, TipoDireccionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDireccionConstantesFunciones.LABEL_IDEMPRESA, TipoDireccionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDireccionConstantesFunciones.LABEL_CODIGO, TipoDireccionConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDireccionConstantesFunciones.LABEL_NOMBRE, TipoDireccionConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDireccion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDireccionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDireccionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDireccionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDireccionConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDireccionConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDireccion() throws Exception  {
		return TipoDireccionConstantesFunciones.getTiposSeleccionarTipoDireccion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDireccion(Boolean conFk) throws Exception  {
		return TipoDireccionConstantesFunciones.getTiposSeleccionarTipoDireccion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDireccion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDireccionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoDireccionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDireccionConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoDireccionConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDireccionConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDireccionConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDireccion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDireccion(TipoDireccion tipodireccionAux) throws Exception {
		
			tipodireccionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodireccionAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDireccion(List<TipoDireccion> tipodireccionsTemp) throws Exception {
		for(TipoDireccion tipodireccionAux:tipodireccionsTemp) {
			
			tipodireccionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodireccionAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDireccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDireccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDireccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDireccionConstantesFunciones.getClassesRelationshipsOfTipoDireccion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDireccion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Direccion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Direccion.class)) {
						classes.add(new Classe(Direccion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDireccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDireccionConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDireccion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDireccion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Direccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Direccion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Direccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Direccion.class)); continue;
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
	public static void actualizarLista(TipoDireccion tipodireccion,List<TipoDireccion> tipodireccions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDireccion tipodireccionEncontrado=null;
			
			for(TipoDireccion tipodireccionLocal:tipodireccions) {
				if(tipodireccionLocal.getId().equals(tipodireccion.getId())) {
					tipodireccionEncontrado=tipodireccionLocal;
					
					tipodireccionLocal.setIsChanged(tipodireccion.getIsChanged());
					tipodireccionLocal.setIsNew(tipodireccion.getIsNew());
					tipodireccionLocal.setIsDeleted(tipodireccion.getIsDeleted());
					
					tipodireccionLocal.setGeneralEntityOriginal(tipodireccion.getGeneralEntityOriginal());
					
					tipodireccionLocal.setId(tipodireccion.getId());	
					tipodireccionLocal.setVersionRow(tipodireccion.getVersionRow());	
					tipodireccionLocal.setid_empresa(tipodireccion.getid_empresa());	
					tipodireccionLocal.setcodigo(tipodireccion.getcodigo());	
					tipodireccionLocal.setnombre(tipodireccion.getnombre());	
					
					
					tipodireccionLocal.setDireccions(tipodireccion.getDireccions());
					
					existe=true;
					break;
				}
			}
			
			if(!tipodireccion.getIsDeleted()) {
				if(!existe) {
					tipodireccions.add(tipodireccion);
				}
			} else {
				if(tipodireccionEncontrado!=null && permiteQuitar)  {
					tipodireccions.remove(tipodireccionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDireccion tipodireccion,List<TipoDireccion> tipodireccions) throws Exception {
		try	{			
			for(TipoDireccion tipodireccionLocal:tipodireccions) {
				if(tipodireccionLocal.getId().equals(tipodireccion.getId())) {
					tipodireccionLocal.setIsSelected(tipodireccion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDireccion(List<TipoDireccion> tipodireccionsAux) throws Exception {
		//this.tipodireccionsAux=tipodireccionsAux;
		
		for(TipoDireccion tipodireccionAux:tipodireccionsAux) {
			if(tipodireccionAux.getIsChanged()) {
				tipodireccionAux.setIsChanged(false);
			}		
			
			if(tipodireccionAux.getIsNew()) {
				tipodireccionAux.setIsNew(false);
			}	
			
			if(tipodireccionAux.getIsDeleted()) {
				tipodireccionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDireccion(TipoDireccion tipodireccionAux) throws Exception {
		//this.tipodireccionAux=tipodireccionAux;
		
			if(tipodireccionAux.getIsChanged()) {
				tipodireccionAux.setIsChanged(false);
			}		
			
			if(tipodireccionAux.getIsNew()) {
				tipodireccionAux.setIsNew(false);
			}	
			
			if(tipodireccionAux.getIsDeleted()) {
				tipodireccionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDireccion tipodireccionAsignar,TipoDireccion tipodireccion) throws Exception {
		tipodireccionAsignar.setId(tipodireccion.getId());	
		tipodireccionAsignar.setVersionRow(tipodireccion.getVersionRow());	
		tipodireccionAsignar.setid_empresa(tipodireccion.getid_empresa());
		tipodireccionAsignar.setempresa_descripcion(tipodireccion.getempresa_descripcion());	
		tipodireccionAsignar.setcodigo(tipodireccion.getcodigo());	
		tipodireccionAsignar.setnombre(tipodireccion.getnombre());	
	}
	
	public static void inicializarTipoDireccion(TipoDireccion tipodireccion) throws Exception {
		try {
				tipodireccion.setId(0L);	
					
				tipodireccion.setid_empresa(-1L);	
				tipodireccion.setcodigo("");	
				tipodireccion.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDireccion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDireccionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDireccionConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDireccionConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDireccion(String sTipo,Row row,Workbook workbook,TipoDireccion tipodireccion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodireccion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodireccion.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodireccion.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDireccion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDireccion() {
		return this.sFinalQueryTipoDireccion;
	}
	
	public void setsFinalQueryTipoDireccion(String sFinalQueryTipoDireccion) {
		this.sFinalQueryTipoDireccion= sFinalQueryTipoDireccion;
	}
	
	public Border resaltarSeleccionarTipoDireccion=null;
	
	public Border setResaltarSeleccionarTipoDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDireccionBeanSwingJInternalFrame tipodireccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodireccionBeanSwingJInternalFrame.jTtoolBarTipoDireccion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDireccion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDireccion() {
		return this.resaltarSeleccionarTipoDireccion;
	}
	
	public void setResaltarSeleccionarTipoDireccion(Border borderResaltarSeleccionarTipoDireccion) {
		this.resaltarSeleccionarTipoDireccion= borderResaltarSeleccionarTipoDireccion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDireccion=null;
	public Boolean mostraridTipoDireccion=true;
	public Boolean activaridTipoDireccion=true;

	public Border resaltarid_empresaTipoDireccion=null;
	public Boolean mostrarid_empresaTipoDireccion=true;
	public Boolean activarid_empresaTipoDireccion=true;
	public Boolean cargarid_empresaTipoDireccion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoDireccion=false;//ConEventDepend=true

	public Border resaltarcodigoTipoDireccion=null;
	public Boolean mostrarcodigoTipoDireccion=true;
	public Boolean activarcodigoTipoDireccion=true;

	public Border resaltarnombreTipoDireccion=null;
	public Boolean mostrarnombreTipoDireccion=true;
	public Boolean activarnombreTipoDireccion=true;

	
	

	public Border setResaltaridTipoDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDireccionBeanSwingJInternalFrame tipodireccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodireccionBeanSwingJInternalFrame.jTtoolBarTipoDireccion.setBorder(borderResaltar);
		
		this.resaltaridTipoDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDireccion() {
		return this.resaltaridTipoDireccion;
	}

	public void setResaltaridTipoDireccion(Border borderResaltar) {
		this.resaltaridTipoDireccion= borderResaltar;
	}

	public Boolean getMostraridTipoDireccion() {
		return this.mostraridTipoDireccion;
	}

	public void setMostraridTipoDireccion(Boolean mostraridTipoDireccion) {
		this.mostraridTipoDireccion= mostraridTipoDireccion;
	}

	public Boolean getActivaridTipoDireccion() {
		return this.activaridTipoDireccion;
	}

	public void setActivaridTipoDireccion(Boolean activaridTipoDireccion) {
		this.activaridTipoDireccion= activaridTipoDireccion;
	}

	public Border setResaltarid_empresaTipoDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDireccionBeanSwingJInternalFrame tipodireccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodireccionBeanSwingJInternalFrame.jTtoolBarTipoDireccion.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoDireccion() {
		return this.resaltarid_empresaTipoDireccion;
	}

	public void setResaltarid_empresaTipoDireccion(Border borderResaltar) {
		this.resaltarid_empresaTipoDireccion= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoDireccion() {
		return this.mostrarid_empresaTipoDireccion;
	}

	public void setMostrarid_empresaTipoDireccion(Boolean mostrarid_empresaTipoDireccion) {
		this.mostrarid_empresaTipoDireccion= mostrarid_empresaTipoDireccion;
	}

	public Boolean getActivarid_empresaTipoDireccion() {
		return this.activarid_empresaTipoDireccion;
	}

	public void setActivarid_empresaTipoDireccion(Boolean activarid_empresaTipoDireccion) {
		this.activarid_empresaTipoDireccion= activarid_empresaTipoDireccion;
	}

	public Boolean getCargarid_empresaTipoDireccion() {
		return this.cargarid_empresaTipoDireccion;
	}

	public void setCargarid_empresaTipoDireccion(Boolean cargarid_empresaTipoDireccion) {
		this.cargarid_empresaTipoDireccion= cargarid_empresaTipoDireccion;
	}

	public Border setResaltarcodigoTipoDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDireccionBeanSwingJInternalFrame tipodireccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodireccionBeanSwingJInternalFrame.jTtoolBarTipoDireccion.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoDireccion() {
		return this.resaltarcodigoTipoDireccion;
	}

	public void setResaltarcodigoTipoDireccion(Border borderResaltar) {
		this.resaltarcodigoTipoDireccion= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoDireccion() {
		return this.mostrarcodigoTipoDireccion;
	}

	public void setMostrarcodigoTipoDireccion(Boolean mostrarcodigoTipoDireccion) {
		this.mostrarcodigoTipoDireccion= mostrarcodigoTipoDireccion;
	}

	public Boolean getActivarcodigoTipoDireccion() {
		return this.activarcodigoTipoDireccion;
	}

	public void setActivarcodigoTipoDireccion(Boolean activarcodigoTipoDireccion) {
		this.activarcodigoTipoDireccion= activarcodigoTipoDireccion;
	}

	public Border setResaltarnombreTipoDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDireccionBeanSwingJInternalFrame tipodireccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodireccionBeanSwingJInternalFrame.jTtoolBarTipoDireccion.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDireccion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDireccion() {
		return this.resaltarnombreTipoDireccion;
	}

	public void setResaltarnombreTipoDireccion(Border borderResaltar) {
		this.resaltarnombreTipoDireccion= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDireccion() {
		return this.mostrarnombreTipoDireccion;
	}

	public void setMostrarnombreTipoDireccion(Boolean mostrarnombreTipoDireccion) {
		this.mostrarnombreTipoDireccion= mostrarnombreTipoDireccion;
	}

	public Boolean getActivarnombreTipoDireccion() {
		return this.activarnombreTipoDireccion;
	}

	public void setActivarnombreTipoDireccion(Boolean activarnombreTipoDireccion) {
		this.activarnombreTipoDireccion= activarnombreTipoDireccion;
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
		
		
		this.setMostraridTipoDireccion(esInicial);
		this.setMostrarid_empresaTipoDireccion(esInicial);
		this.setMostrarcodigoTipoDireccion(esInicial);
		this.setMostrarnombreTipoDireccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDireccionConstantesFunciones.ID)) {
				this.setMostraridTipoDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDireccionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDireccionConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDireccionConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDireccion(esAsigna);
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
		
		
		this.setActivaridTipoDireccion(esInicial);
		this.setActivarid_empresaTipoDireccion(esInicial);
		this.setActivarcodigoTipoDireccion(esInicial);
		this.setActivarnombreTipoDireccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDireccionConstantesFunciones.ID)) {
				this.setActivaridTipoDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDireccionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDireccionConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDireccionConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDireccion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDireccionBeanSwingJInternalFrame tipodireccionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDireccion(esInicial);
		this.setResaltarid_empresaTipoDireccion(esInicial);
		this.setResaltarcodigoTipoDireccion(esInicial);
		this.setResaltarnombreTipoDireccion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDireccionConstantesFunciones.ID)) {
				this.setResaltaridTipoDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDireccionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDireccionConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoDireccion(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDireccionConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDireccion(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDireccionTipoDireccion=null;

	public Border getResaltarDireccionTipoDireccion() {
		return this.resaltarDireccionTipoDireccion;
	}

	public void setResaltarDireccionTipoDireccion(Border borderResaltarDireccion) {
		if(borderResaltarDireccion!=null) {
			this.resaltarDireccionTipoDireccion= borderResaltarDireccion;
		}
	}

	public Border setResaltarDireccionTipoDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDireccionBeanSwingJInternalFrame tipodireccionBeanSwingJInternalFrame*/) {
		Border borderResaltarDireccion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipodireccionBeanSwingJInternalFrame.jTtoolBarTipoDireccion.setBorder(borderResaltarDireccion);
			
		this.resaltarDireccionTipoDireccion= borderResaltarDireccion;

		 return borderResaltarDireccion;
	}



	public Boolean mostrarDireccionTipoDireccion=true;

	public Boolean getMostrarDireccionTipoDireccion() {
		return this.mostrarDireccionTipoDireccion;
	}

	public void setMostrarDireccionTipoDireccion(Boolean visibilidadResaltarDireccion) {
		this.mostrarDireccionTipoDireccion= visibilidadResaltarDireccion;
	}



	public Boolean activarDireccionTipoDireccion=true;

	public Boolean gethabilitarResaltarDireccionTipoDireccion() {
		return this.activarDireccionTipoDireccion;
	}

	public void setActivarDireccionTipoDireccion(Boolean habilitarResaltarDireccion) {
		this.activarDireccionTipoDireccion= habilitarResaltarDireccion;
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

		this.setMostrarDireccionTipoDireccion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Direccion.class)) {
				this.setMostrarDireccionTipoDireccion(esAsigna);
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

		this.setActivarDireccionTipoDireccion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Direccion.class)) {
				this.setActivarDireccionTipoDireccion(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDireccionBeanSwingJInternalFrame tipodireccionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDireccionTipoDireccion(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Direccion.class)) {
				this.setResaltarDireccionTipoDireccion(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoDireccion=true;

	public Boolean getMostrarFK_IdEmpresaTipoDireccion() {
		return this.mostrarFK_IdEmpresaTipoDireccion;
	}

	public void setMostrarFK_IdEmpresaTipoDireccion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoDireccion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoDireccion=true;

	public Boolean getActivarFK_IdEmpresaTipoDireccion() {
		return this.activarFK_IdEmpresaTipoDireccion;
	}

	public void setActivarFK_IdEmpresaTipoDireccion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoDireccion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoDireccion=null;

	public Border getResaltarFK_IdEmpresaTipoDireccion() {
		return this.resaltarFK_IdEmpresaTipoDireccion;
	}

	public void setResaltarFK_IdEmpresaTipoDireccion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoDireccion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoDireccion(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDireccionBeanSwingJInternalFrame tipodireccionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoDireccion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}