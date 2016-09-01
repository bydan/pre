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
package com.bydan.erp.contabilidad.util;

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


import com.bydan.erp.contabilidad.util.TipoParametroFormularioIvaConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoParametroFormularioIvaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoParametroFormularioIvaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoParametroFormularioIvaConstantesFunciones extends TipoParametroFormularioIvaConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoParametroFormularioIva";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoParametroFormularioIva"+TipoParametroFormularioIvaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoParametroFormularioIvaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoParametroFormularioIvaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+TipoParametroFormularioIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+TipoParametroFormularioIvaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+TipoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"_"+TipoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoParametroFormularioIvaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoParametroFormularioIvaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoParametroFormularioIvaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoParametroFormularioIvaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoParametroFormularioIvaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoParametroFormularioIvaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Parametro Formulario Iva s";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Parametro Formulario Iva ";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Parametro Formulario Iva";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoParametroFormularioIva";
	public static final String OBJECTNAME="tipoparametroformularioiva";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_parametro_formulario_iva";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoparametroformularioiva from "+TipoParametroFormularioIvaConstantesFunciones.SPERSISTENCENAME+" tipoparametroformularioiva";
	public static String QUERYSELECTNATIVE="select "+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+".id,"+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+".version_row,"+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+".nombre,"+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME+".codigo_sri from "+TipoParametroFormularioIvaConstantesFunciones.SCHEMA+"."+TipoParametroFormularioIvaConstantesFunciones.TABLENAME;//+" as "+TipoParametroFormularioIvaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoParametroFormularioIvaConstantesFuncionesAdditional tipoparametroformularioivaConstantesFuncionesAdditional=null;
	
	public TipoParametroFormularioIvaConstantesFuncionesAdditional getTipoParametroFormularioIvaConstantesFuncionesAdditional() {
		return this.tipoparametroformularioivaConstantesFuncionesAdditional;
	}
	
	public void setTipoParametroFormularioIvaConstantesFuncionesAdditional(TipoParametroFormularioIvaConstantesFuncionesAdditional tipoparametroformularioivaConstantesFuncionesAdditional) {
		try {
			this.tipoparametroformularioivaConstantesFuncionesAdditional=tipoparametroformularioivaConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String NOMBRE= "nombre";
    public static final String CODIGOSRI= "codigo_sri";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_CODIGOSRI= "Codigo Sri";
		public static final String LABEL_CODIGOSRI_LOWER= "Codigo Sri";
	
		
		
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO_SRI=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_SRI=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoParametroFormularioIvaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoParametroFormularioIvaConstantesFunciones.NOMBRE)) {sLabelColumna=TipoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoParametroFormularioIvaConstantesFunciones.CODIGOSRI)) {sLabelColumna=TipoParametroFormularioIvaConstantesFunciones.LABEL_CODIGOSRI;}
		
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
	
	
	
			
			
			
			
	
	public static String getTipoParametroFormularioIvaDescripcion(TipoParametroFormularioIva tipoparametroformularioiva) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoparametroformularioiva !=null/* && tipoparametroformularioiva.getId()!=0*/) {
			sDescripcion=tipoparametroformularioiva.getnombre();//tipoparametroformularioivatipoparametroformularioiva.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoParametroFormularioIvaDescripcionDetallado(TipoParametroFormularioIva tipoparametroformularioiva) {
		String sDescripcion="";
			
		sDescripcion+=TipoParametroFormularioIvaConstantesFunciones.ID+"=";
		sDescripcion+=tipoparametroformularioiva.getId().toString()+",";
		sDescripcion+=TipoParametroFormularioIvaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoparametroformularioiva.getVersionRow().toString()+",";
		sDescripcion+=TipoParametroFormularioIvaConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoparametroformularioiva.getnombre()+",";
		sDescripcion+=TipoParametroFormularioIvaConstantesFunciones.CODIGOSRI+"=";
		sDescripcion+=tipoparametroformularioiva.getcodigo_sri()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoParametroFormularioIvaDescripcion(TipoParametroFormularioIva tipoparametroformularioiva,String sValor) throws Exception {			
		if(tipoparametroformularioiva !=null) {
			tipoparametroformularioiva.setnombre(sValor);;//tipoparametroformularioivatipoparametroformularioiva.getnombre().trim();
		}		
	}
	
		
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoParametroFormularioIva(TipoParametroFormularioIva tipoparametroformularioiva,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoparametroformularioiva.setnombre(tipoparametroformularioiva.getnombre().trim());
		tipoparametroformularioiva.setcodigo_sri(tipoparametroformularioiva.getcodigo_sri().trim());
	}
	
	public static void quitarEspaciosTipoParametroFormularioIvas(List<TipoParametroFormularioIva> tipoparametroformularioivas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoParametroFormularioIva tipoparametroformularioiva: tipoparametroformularioivas) {
			tipoparametroformularioiva.setnombre(tipoparametroformularioiva.getnombre().trim());
			tipoparametroformularioiva.setcodigo_sri(tipoparametroformularioiva.getcodigo_sri().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoParametroFormularioIva(TipoParametroFormularioIva tipoparametroformularioiva,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoparametroformularioiva.getConCambioAuxiliar()) {
			tipoparametroformularioiva.setIsDeleted(tipoparametroformularioiva.getIsDeletedAuxiliar());	
			tipoparametroformularioiva.setIsNew(tipoparametroformularioiva.getIsNewAuxiliar());	
			tipoparametroformularioiva.setIsChanged(tipoparametroformularioiva.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoparametroformularioiva.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoparametroformularioiva.setIsDeletedAuxiliar(false);	
			tipoparametroformularioiva.setIsNewAuxiliar(false);	
			tipoparametroformularioiva.setIsChangedAuxiliar(false);
			
			tipoparametroformularioiva.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoParametroFormularioIvas(List<TipoParametroFormularioIva> tipoparametroformularioivas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoParametroFormularioIva tipoparametroformularioiva : tipoparametroformularioivas) {
			if(conAsignarBase && tipoparametroformularioiva.getConCambioAuxiliar()) {
				tipoparametroformularioiva.setIsDeleted(tipoparametroformularioiva.getIsDeletedAuxiliar());	
				tipoparametroformularioiva.setIsNew(tipoparametroformularioiva.getIsNewAuxiliar());	
				tipoparametroformularioiva.setIsChanged(tipoparametroformularioiva.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoparametroformularioiva.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoparametroformularioiva.setIsDeletedAuxiliar(false);	
				tipoparametroformularioiva.setIsNewAuxiliar(false);	
				tipoparametroformularioiva.setIsChangedAuxiliar(false);
				
				tipoparametroformularioiva.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoParametroFormularioIva(TipoParametroFormularioIva tipoparametroformularioiva,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoParametroFormularioIvas(List<TipoParametroFormularioIva> tipoparametroformularioivas,Boolean conEnteros) throws Exception  {
		
		for(TipoParametroFormularioIva tipoparametroformularioiva: tipoparametroformularioivas) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoParametroFormularioIva(List<TipoParametroFormularioIva> tipoparametroformularioivas,TipoParametroFormularioIva tipoparametroformularioivaAux) throws Exception  {
		TipoParametroFormularioIvaConstantesFunciones.InicializarValoresTipoParametroFormularioIva(tipoparametroformularioivaAux,true);
		
		for(TipoParametroFormularioIva tipoparametroformularioiva: tipoparametroformularioivas) {
			if(tipoparametroformularioiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoParametroFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoParametroFormularioIvaConstantesFunciones.getArrayColumnasGlobalesTipoParametroFormularioIva(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoParametroFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoParametroFormularioIva(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoParametroFormularioIva> tipoparametroformularioivas,TipoParametroFormularioIva tipoparametroformularioiva,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoParametroFormularioIva tipoparametroformularioivaAux: tipoparametroformularioivas) {
			if(tipoparametroformularioivaAux!=null && tipoparametroformularioiva!=null) {
				if((tipoparametroformularioivaAux.getId()==null && tipoparametroformularioiva.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoparametroformularioivaAux.getId()!=null && tipoparametroformularioiva.getId()!=null){
					if(tipoparametroformularioivaAux.getId().equals(tipoparametroformularioiva.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoParametroFormularioIva(List<TipoParametroFormularioIva> tipoparametroformularioivas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoParametroFormularioIva tipoparametroformularioiva: tipoparametroformularioivas) {			
			if(tipoparametroformularioiva.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoParametroFormularioIva() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoParametroFormularioIvaConstantesFunciones.LABEL_ID, TipoParametroFormularioIvaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParametroFormularioIvaConstantesFunciones.LABEL_VERSIONROW, TipoParametroFormularioIvaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE, TipoParametroFormularioIvaConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoParametroFormularioIvaConstantesFunciones.LABEL_CODIGOSRI, TipoParametroFormularioIvaConstantesFunciones.CODIGOSRI,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoParametroFormularioIva() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoParametroFormularioIvaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParametroFormularioIvaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParametroFormularioIvaConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoParametroFormularioIvaConstantesFunciones.CODIGOSRI;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParametroFormularioIva() throws Exception  {
		return TipoParametroFormularioIvaConstantesFunciones.getTiposSeleccionarTipoParametroFormularioIva(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParametroFormularioIva(Boolean conFk) throws Exception  {
		return TipoParametroFormularioIvaConstantesFunciones.getTiposSeleccionarTipoParametroFormularioIva(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoParametroFormularioIva(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoParametroFormularioIvaConstantesFunciones.LABEL_CODIGOSRI);
			reporte.setsDescripcion(TipoParametroFormularioIvaConstantesFunciones.LABEL_CODIGOSRI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoParametroFormularioIva(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoParametroFormularioIva(TipoParametroFormularioIva tipoparametroformularioivaAux) throws Exception {
				
	}
	
	public static void refrescarForeignKeysDescripcionesTipoParametroFormularioIva(List<TipoParametroFormularioIva> tipoparametroformularioivasTemp) throws Exception {
		for(TipoParametroFormularioIva tipoparametroformularioivaAux:tipoparametroformularioivasTemp) {
			
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoParametroFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoParametroFormularioIvaConstantesFunciones.getClassesRelationshipsOfTipoParametroFormularioIva(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoParametroFormularioIva(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(ParametroFormularioIva.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroFormularioIva.class)) {
						classes.add(new Classe(ParametroFormularioIva.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoParametroFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoParametroFormularioIvaConstantesFunciones.getClassesRelationshipsFromStringsOfTipoParametroFormularioIva(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoParametroFormularioIva(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFormularioIva.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(ParametroFormularioIva.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroFormularioIva.class)); continue;
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
	public static void actualizarLista(TipoParametroFormularioIva tipoparametroformularioiva,List<TipoParametroFormularioIva> tipoparametroformularioivas,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoParametroFormularioIva tipoparametroformularioivaEncontrado=null;
			
			for(TipoParametroFormularioIva tipoparametroformularioivaLocal:tipoparametroformularioivas) {
				if(tipoparametroformularioivaLocal.getId().equals(tipoparametroformularioiva.getId())) {
					tipoparametroformularioivaEncontrado=tipoparametroformularioivaLocal;
					
					tipoparametroformularioivaLocal.setIsChanged(tipoparametroformularioiva.getIsChanged());
					tipoparametroformularioivaLocal.setIsNew(tipoparametroformularioiva.getIsNew());
					tipoparametroformularioivaLocal.setIsDeleted(tipoparametroformularioiva.getIsDeleted());
					
					tipoparametroformularioivaLocal.setGeneralEntityOriginal(tipoparametroformularioiva.getGeneralEntityOriginal());
					
					tipoparametroformularioivaLocal.setId(tipoparametroformularioiva.getId());	
					tipoparametroformularioivaLocal.setVersionRow(tipoparametroformularioiva.getVersionRow());	
					tipoparametroformularioivaLocal.setnombre(tipoparametroformularioiva.getnombre());	
					tipoparametroformularioivaLocal.setcodigo_sri(tipoparametroformularioiva.getcodigo_sri());	
					
					
					tipoparametroformularioivaLocal.setParametroFormularioIvas(tipoparametroformularioiva.getParametroFormularioIvas());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoparametroformularioiva.getIsDeleted()) {
				if(!existe) {
					tipoparametroformularioivas.add(tipoparametroformularioiva);
				}
			} else {
				if(tipoparametroformularioivaEncontrado!=null && permiteQuitar)  {
					tipoparametroformularioivas.remove(tipoparametroformularioivaEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoParametroFormularioIva tipoparametroformularioiva,List<TipoParametroFormularioIva> tipoparametroformularioivas) throws Exception {
		try	{			
			for(TipoParametroFormularioIva tipoparametroformularioivaLocal:tipoparametroformularioivas) {
				if(tipoparametroformularioivaLocal.getId().equals(tipoparametroformularioiva.getId())) {
					tipoparametroformularioivaLocal.setIsSelected(tipoparametroformularioiva.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoParametroFormularioIva(List<TipoParametroFormularioIva> tipoparametroformularioivasAux) throws Exception {
		//this.tipoparametroformularioivasAux=tipoparametroformularioivasAux;
		
		for(TipoParametroFormularioIva tipoparametroformularioivaAux:tipoparametroformularioivasAux) {
			if(tipoparametroformularioivaAux.getIsChanged()) {
				tipoparametroformularioivaAux.setIsChanged(false);
			}		
			
			if(tipoparametroformularioivaAux.getIsNew()) {
				tipoparametroformularioivaAux.setIsNew(false);
			}	
			
			if(tipoparametroformularioivaAux.getIsDeleted()) {
				tipoparametroformularioivaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoParametroFormularioIva(TipoParametroFormularioIva tipoparametroformularioivaAux) throws Exception {
		//this.tipoparametroformularioivaAux=tipoparametroformularioivaAux;
		
			if(tipoparametroformularioivaAux.getIsChanged()) {
				tipoparametroformularioivaAux.setIsChanged(false);
			}		
			
			if(tipoparametroformularioivaAux.getIsNew()) {
				tipoparametroformularioivaAux.setIsNew(false);
			}	
			
			if(tipoparametroformularioivaAux.getIsDeleted()) {
				tipoparametroformularioivaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoParametroFormularioIva tipoparametroformularioivaAsignar,TipoParametroFormularioIva tipoparametroformularioiva) throws Exception {
		tipoparametroformularioivaAsignar.setId(tipoparametroformularioiva.getId());	
		tipoparametroformularioivaAsignar.setVersionRow(tipoparametroformularioiva.getVersionRow());	
		tipoparametroformularioivaAsignar.setnombre(tipoparametroformularioiva.getnombre());	
		tipoparametroformularioivaAsignar.setcodigo_sri(tipoparametroformularioiva.getcodigo_sri());	
	}
	
	public static void inicializarTipoParametroFormularioIva(TipoParametroFormularioIva tipoparametroformularioiva) throws Exception {
		try {
				tipoparametroformularioiva.setId(0L);	
					
				tipoparametroformularioiva.setnombre("");	
				tipoparametroformularioiva.setcodigo_sri("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoParametroFormularioIva(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoParametroFormularioIvaConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoParametroFormularioIvaConstantesFunciones.LABEL_CODIGOSRI);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoParametroFormularioIva(String sTipo,Row row,Workbook workbook,TipoParametroFormularioIva tipoparametroformularioiva,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoparametroformularioiva.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoparametroformularioiva.getcodigo_sri());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoParametroFormularioIva=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoParametroFormularioIva() {
		return this.sFinalQueryTipoParametroFormularioIva;
	}
	
	public void setsFinalQueryTipoParametroFormularioIva(String sFinalQueryTipoParametroFormularioIva) {
		this.sFinalQueryTipoParametroFormularioIva= sFinalQueryTipoParametroFormularioIva;
	}
	
	public Border resaltarSeleccionarTipoParametroFormularioIva=null;
	
	public Border setResaltarSeleccionarTipoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParametroFormularioIvaBeanSwingJInternalFrame tipoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarTipoParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoParametroFormularioIva= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoParametroFormularioIva() {
		return this.resaltarSeleccionarTipoParametroFormularioIva;
	}
	
	public void setResaltarSeleccionarTipoParametroFormularioIva(Border borderResaltarSeleccionarTipoParametroFormularioIva) {
		this.resaltarSeleccionarTipoParametroFormularioIva= borderResaltarSeleccionarTipoParametroFormularioIva;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoParametroFormularioIva=null;
	public Boolean mostraridTipoParametroFormularioIva=true;
	public Boolean activaridTipoParametroFormularioIva=true;

	public Border resaltarnombreTipoParametroFormularioIva=null;
	public Boolean mostrarnombreTipoParametroFormularioIva=true;
	public Boolean activarnombreTipoParametroFormularioIva=true;

	public Border resaltarcodigo_sriTipoParametroFormularioIva=null;
	public Boolean mostrarcodigo_sriTipoParametroFormularioIva=true;
	public Boolean activarcodigo_sriTipoParametroFormularioIva=true;

	
	

	public Border setResaltaridTipoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParametroFormularioIvaBeanSwingJInternalFrame tipoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarTipoParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltaridTipoParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoParametroFormularioIva() {
		return this.resaltaridTipoParametroFormularioIva;
	}

	public void setResaltaridTipoParametroFormularioIva(Border borderResaltar) {
		this.resaltaridTipoParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostraridTipoParametroFormularioIva() {
		return this.mostraridTipoParametroFormularioIva;
	}

	public void setMostraridTipoParametroFormularioIva(Boolean mostraridTipoParametroFormularioIva) {
		this.mostraridTipoParametroFormularioIva= mostraridTipoParametroFormularioIva;
	}

	public Boolean getActivaridTipoParametroFormularioIva() {
		return this.activaridTipoParametroFormularioIva;
	}

	public void setActivaridTipoParametroFormularioIva(Boolean activaridTipoParametroFormularioIva) {
		this.activaridTipoParametroFormularioIva= activaridTipoParametroFormularioIva;
	}

	public Border setResaltarnombreTipoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParametroFormularioIvaBeanSwingJInternalFrame tipoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarTipoParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarnombreTipoParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoParametroFormularioIva() {
		return this.resaltarnombreTipoParametroFormularioIva;
	}

	public void setResaltarnombreTipoParametroFormularioIva(Border borderResaltar) {
		this.resaltarnombreTipoParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarnombreTipoParametroFormularioIva() {
		return this.mostrarnombreTipoParametroFormularioIva;
	}

	public void setMostrarnombreTipoParametroFormularioIva(Boolean mostrarnombreTipoParametroFormularioIva) {
		this.mostrarnombreTipoParametroFormularioIva= mostrarnombreTipoParametroFormularioIva;
	}

	public Boolean getActivarnombreTipoParametroFormularioIva() {
		return this.activarnombreTipoParametroFormularioIva;
	}

	public void setActivarnombreTipoParametroFormularioIva(Boolean activarnombreTipoParametroFormularioIva) {
		this.activarnombreTipoParametroFormularioIva= activarnombreTipoParametroFormularioIva;
	}

	public Border setResaltarcodigo_sriTipoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParametroFormularioIvaBeanSwingJInternalFrame tipoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarTipoParametroFormularioIva.setBorder(borderResaltar);
		
		this.resaltarcodigo_sriTipoParametroFormularioIva= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_sriTipoParametroFormularioIva() {
		return this.resaltarcodigo_sriTipoParametroFormularioIva;
	}

	public void setResaltarcodigo_sriTipoParametroFormularioIva(Border borderResaltar) {
		this.resaltarcodigo_sriTipoParametroFormularioIva= borderResaltar;
	}

	public Boolean getMostrarcodigo_sriTipoParametroFormularioIva() {
		return this.mostrarcodigo_sriTipoParametroFormularioIva;
	}

	public void setMostrarcodigo_sriTipoParametroFormularioIva(Boolean mostrarcodigo_sriTipoParametroFormularioIva) {
		this.mostrarcodigo_sriTipoParametroFormularioIva= mostrarcodigo_sriTipoParametroFormularioIva;
	}

	public Boolean getActivarcodigo_sriTipoParametroFormularioIva() {
		return this.activarcodigo_sriTipoParametroFormularioIva;
	}

	public void setActivarcodigo_sriTipoParametroFormularioIva(Boolean activarcodigo_sriTipoParametroFormularioIva) {
		this.activarcodigo_sriTipoParametroFormularioIva= activarcodigo_sriTipoParametroFormularioIva;
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
		
		
		this.setMostraridTipoParametroFormularioIva(esInicial);
		this.setMostrarnombreTipoParametroFormularioIva(esInicial);
		this.setMostrarcodigo_sriTipoParametroFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParametroFormularioIvaConstantesFunciones.ID)) {
				this.setMostraridTipoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroFormularioIvaConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroFormularioIvaConstantesFunciones.CODIGOSRI)) {
				this.setMostrarcodigo_sriTipoParametroFormularioIva(esAsigna);
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
		
		
		this.setActivaridTipoParametroFormularioIva(esInicial);
		this.setActivarnombreTipoParametroFormularioIva(esInicial);
		this.setActivarcodigo_sriTipoParametroFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParametroFormularioIvaConstantesFunciones.ID)) {
				this.setActivaridTipoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroFormularioIvaConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroFormularioIvaConstantesFunciones.CODIGOSRI)) {
				this.setActivarcodigo_sriTipoParametroFormularioIva(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoParametroFormularioIvaBeanSwingJInternalFrame tipoparametroformularioivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoParametroFormularioIva(esInicial);
		this.setResaltarnombreTipoParametroFormularioIva(esInicial);
		this.setResaltarcodigo_sriTipoParametroFormularioIva(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoParametroFormularioIvaConstantesFunciones.ID)) {
				this.setResaltaridTipoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroFormularioIvaConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoParametroFormularioIva(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoParametroFormularioIvaConstantesFunciones.CODIGOSRI)) {
				this.setResaltarcodigo_sriTipoParametroFormularioIva(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarParametroFormularioIvaTipoParametroFormularioIva=null;

	public Border getResaltarParametroFormularioIvaTipoParametroFormularioIva() {
		return this.resaltarParametroFormularioIvaTipoParametroFormularioIva;
	}

	public void setResaltarParametroFormularioIvaTipoParametroFormularioIva(Border borderResaltarParametroFormularioIva) {
		if(borderResaltarParametroFormularioIva!=null) {
			this.resaltarParametroFormularioIvaTipoParametroFormularioIva= borderResaltarParametroFormularioIva;
		}
	}

	public Border setResaltarParametroFormularioIvaTipoParametroFormularioIva(ParametroGeneralUsuario parametroGeneralUsuario/*TipoParametroFormularioIvaBeanSwingJInternalFrame tipoparametroformularioivaBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroFormularioIva=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoparametroformularioivaBeanSwingJInternalFrame.jTtoolBarTipoParametroFormularioIva.setBorder(borderResaltarParametroFormularioIva);
			
		this.resaltarParametroFormularioIvaTipoParametroFormularioIva= borderResaltarParametroFormularioIva;

		 return borderResaltarParametroFormularioIva;
	}



	public Boolean mostrarParametroFormularioIvaTipoParametroFormularioIva=true;

	public Boolean getMostrarParametroFormularioIvaTipoParametroFormularioIva() {
		return this.mostrarParametroFormularioIvaTipoParametroFormularioIva;
	}

	public void setMostrarParametroFormularioIvaTipoParametroFormularioIva(Boolean visibilidadResaltarParametroFormularioIva) {
		this.mostrarParametroFormularioIvaTipoParametroFormularioIva= visibilidadResaltarParametroFormularioIva;
	}



	public Boolean activarParametroFormularioIvaTipoParametroFormularioIva=true;

	public Boolean gethabilitarResaltarParametroFormularioIvaTipoParametroFormularioIva() {
		return this.activarParametroFormularioIvaTipoParametroFormularioIva;
	}

	public void setActivarParametroFormularioIvaTipoParametroFormularioIva(Boolean habilitarResaltarParametroFormularioIva) {
		this.activarParametroFormularioIvaTipoParametroFormularioIva= habilitarResaltarParametroFormularioIva;
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

		this.setMostrarParametroFormularioIvaTipoParametroFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroFormularioIva.class)) {
				this.setMostrarParametroFormularioIvaTipoParametroFormularioIva(esAsigna);
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

		this.setActivarParametroFormularioIvaTipoParametroFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroFormularioIva.class)) {
				this.setActivarParametroFormularioIvaTipoParametroFormularioIva(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoParametroFormularioIvaBeanSwingJInternalFrame tipoparametroformularioivaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarParametroFormularioIvaTipoParametroFormularioIva(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(ParametroFormularioIva.class)) {
				this.setResaltarParametroFormularioIvaTipoParametroFormularioIva(esAsigna);
				continue;
			}
		}		
	}
	
	
	//CONTROL_FUNCION2
}