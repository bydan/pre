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


import com.bydan.erp.nomina.util.TipoEnfermedadConstantesFunciones;
import com.bydan.erp.nomina.util.TipoEnfermedadParameterReturnGeneral;
//import com.bydan.erp.nomina.util.TipoEnfermedadParameterGeneral;

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
final public class TipoEnfermedadConstantesFunciones extends TipoEnfermedadConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoEnfermedad";
	public static final String SPATHOPCION="Nomina";	
	public static final String SPATHMODULO="nomina/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoEnfermedad"+TipoEnfermedadConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoEnfermedadHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoEnfermedadHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoEnfermedadConstantesFunciones.SCHEMA+"_"+TipoEnfermedadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoEnfermedadHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoEnfermedadConstantesFunciones.SCHEMA+"_"+TipoEnfermedadConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoEnfermedadConstantesFunciones.SCHEMA+"_"+TipoEnfermedadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoEnfermedadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoEnfermedadConstantesFunciones.SCHEMA+"_"+TipoEnfermedadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEnfermedadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoEnfermedadHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEnfermedadConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEnfermedadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoEnfermedadHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoEnfermedadConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoEnfermedadConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoEnfermedadConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoEnfermedadConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoEnfermedadConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Enfermedades";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Tipo Enfermedad";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Enfermedad";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoEnfermedad";
	public static final String OBJECTNAME="tipoenfermedad";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_NOMINA;	
	public static final String TABLENAME="tipo_enfermedad";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipoenfermedad from "+TipoEnfermedadConstantesFunciones.SPERSISTENCENAME+" tipoenfermedad";
	public static String QUERYSELECTNATIVE="select "+TipoEnfermedadConstantesFunciones.SCHEMA+"."+TipoEnfermedadConstantesFunciones.TABLENAME+".id,"+TipoEnfermedadConstantesFunciones.SCHEMA+"."+TipoEnfermedadConstantesFunciones.TABLENAME+".version_row,"+TipoEnfermedadConstantesFunciones.SCHEMA+"."+TipoEnfermedadConstantesFunciones.TABLENAME+".id_empresa,"+TipoEnfermedadConstantesFunciones.SCHEMA+"."+TipoEnfermedadConstantesFunciones.TABLENAME+".codigo,"+TipoEnfermedadConstantesFunciones.SCHEMA+"."+TipoEnfermedadConstantesFunciones.TABLENAME+".nombre from "+TipoEnfermedadConstantesFunciones.SCHEMA+"."+TipoEnfermedadConstantesFunciones.TABLENAME;//+" as "+TipoEnfermedadConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoEnfermedadConstantesFuncionesAdditional tipoenfermedadConstantesFuncionesAdditional=null;
	
	public TipoEnfermedadConstantesFuncionesAdditional getTipoEnfermedadConstantesFuncionesAdditional() {
		return this.tipoenfermedadConstantesFuncionesAdditional;
	}
	
	public void setTipoEnfermedadConstantesFuncionesAdditional(TipoEnfermedadConstantesFuncionesAdditional tipoenfermedadConstantesFuncionesAdditional) {
		try {
			this.tipoenfermedadConstantesFuncionesAdditional=tipoenfermedadConstantesFuncionesAdditional;
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
	
	public static String getTipoEnfermedadLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoEnfermedadConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoEnfermedadConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoEnfermedadConstantesFunciones.CODIGO)) {sLabelColumna=TipoEnfermedadConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoEnfermedadConstantesFunciones.NOMBRE)) {sLabelColumna=TipoEnfermedadConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getTipoEnfermedadDescripcion(TipoEnfermedad tipoenfermedad) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipoenfermedad !=null/* && tipoenfermedad.getId()!=0*/) {
			sDescripcion=tipoenfermedad.getcodigo();//tipoenfermedadtipoenfermedad.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoEnfermedadDescripcionDetallado(TipoEnfermedad tipoenfermedad) {
		String sDescripcion="";
			
		sDescripcion+=TipoEnfermedadConstantesFunciones.ID+"=";
		sDescripcion+=tipoenfermedad.getId().toString()+",";
		sDescripcion+=TipoEnfermedadConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipoenfermedad.getVersionRow().toString()+",";
		sDescripcion+=TipoEnfermedadConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipoenfermedad.getid_empresa().toString()+",";
		sDescripcion+=TipoEnfermedadConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipoenfermedad.getcodigo()+",";
		sDescripcion+=TipoEnfermedadConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipoenfermedad.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoEnfermedadDescripcion(TipoEnfermedad tipoenfermedad,String sValor) throws Exception {			
		if(tipoenfermedad !=null) {
			tipoenfermedad.setcodigo(sValor);;//tipoenfermedadtipoenfermedad.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoEnfermedad(TipoEnfermedad tipoenfermedad,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipoenfermedad.setcodigo(tipoenfermedad.getcodigo().trim());
		tipoenfermedad.setnombre(tipoenfermedad.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoEnfermedads(List<TipoEnfermedad> tipoenfermedads,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoEnfermedad tipoenfermedad: tipoenfermedads) {
			tipoenfermedad.setcodigo(tipoenfermedad.getcodigo().trim());
			tipoenfermedad.setnombre(tipoenfermedad.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoEnfermedad(TipoEnfermedad tipoenfermedad,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipoenfermedad.getConCambioAuxiliar()) {
			tipoenfermedad.setIsDeleted(tipoenfermedad.getIsDeletedAuxiliar());	
			tipoenfermedad.setIsNew(tipoenfermedad.getIsNewAuxiliar());	
			tipoenfermedad.setIsChanged(tipoenfermedad.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipoenfermedad.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipoenfermedad.setIsDeletedAuxiliar(false);	
			tipoenfermedad.setIsNewAuxiliar(false);	
			tipoenfermedad.setIsChangedAuxiliar(false);
			
			tipoenfermedad.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoEnfermedads(List<TipoEnfermedad> tipoenfermedads,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoEnfermedad tipoenfermedad : tipoenfermedads) {
			if(conAsignarBase && tipoenfermedad.getConCambioAuxiliar()) {
				tipoenfermedad.setIsDeleted(tipoenfermedad.getIsDeletedAuxiliar());	
				tipoenfermedad.setIsNew(tipoenfermedad.getIsNewAuxiliar());	
				tipoenfermedad.setIsChanged(tipoenfermedad.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipoenfermedad.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipoenfermedad.setIsDeletedAuxiliar(false);	
				tipoenfermedad.setIsNewAuxiliar(false);	
				tipoenfermedad.setIsChangedAuxiliar(false);
				
				tipoenfermedad.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoEnfermedad(TipoEnfermedad tipoenfermedad,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoEnfermedads(List<TipoEnfermedad> tipoenfermedads,Boolean conEnteros) throws Exception  {
		
		for(TipoEnfermedad tipoenfermedad: tipoenfermedads) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoEnfermedad(List<TipoEnfermedad> tipoenfermedads,TipoEnfermedad tipoenfermedadAux) throws Exception  {
		TipoEnfermedadConstantesFunciones.InicializarValoresTipoEnfermedad(tipoenfermedadAux,true);
		
		for(TipoEnfermedad tipoenfermedad: tipoenfermedads) {
			if(tipoenfermedad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoEnfermedad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoEnfermedadConstantesFunciones.getArrayColumnasGlobalesTipoEnfermedad(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoEnfermedad(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoEnfermedadConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoEnfermedadConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoEnfermedad(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoEnfermedad> tipoenfermedads,TipoEnfermedad tipoenfermedad,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoEnfermedad tipoenfermedadAux: tipoenfermedads) {
			if(tipoenfermedadAux!=null && tipoenfermedad!=null) {
				if((tipoenfermedadAux.getId()==null && tipoenfermedad.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipoenfermedadAux.getId()!=null && tipoenfermedad.getId()!=null){
					if(tipoenfermedadAux.getId().equals(tipoenfermedad.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoEnfermedad(List<TipoEnfermedad> tipoenfermedads) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoEnfermedad tipoenfermedad: tipoenfermedads) {			
			if(tipoenfermedad.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoEnfermedad() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoEnfermedadConstantesFunciones.LABEL_ID, TipoEnfermedadConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEnfermedadConstantesFunciones.LABEL_VERSIONROW, TipoEnfermedadConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEnfermedadConstantesFunciones.LABEL_IDEMPRESA, TipoEnfermedadConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEnfermedadConstantesFunciones.LABEL_CODIGO, TipoEnfermedadConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoEnfermedadConstantesFunciones.LABEL_NOMBRE, TipoEnfermedadConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoEnfermedad() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoEnfermedadConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEnfermedadConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEnfermedadConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEnfermedadConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoEnfermedadConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEnfermedad() throws Exception  {
		return TipoEnfermedadConstantesFunciones.getTiposSeleccionarTipoEnfermedad(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEnfermedad(Boolean conFk) throws Exception  {
		return TipoEnfermedadConstantesFunciones.getTiposSeleccionarTipoEnfermedad(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoEnfermedad(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEnfermedadConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoEnfermedadConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEnfermedadConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoEnfermedadConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoEnfermedadConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoEnfermedadConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoEnfermedad(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoEnfermedad(TipoEnfermedad tipoenfermedadAux) throws Exception {
		
			tipoenfermedadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoenfermedadAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoEnfermedad(List<TipoEnfermedad> tipoenfermedadsTemp) throws Exception {
		for(TipoEnfermedad tipoenfermedadAux:tipoenfermedadsTemp) {
			
			tipoenfermedadAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipoenfermedadAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoEnfermedad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoEnfermedad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEnfermedad(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoEnfermedadConstantesFunciones.getClassesRelationshipsOfTipoEnfermedad(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoEnfermedad(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Enfermedad.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Enfermedad.class)) {
						classes.add(new Classe(Enfermedad.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoEnfermedad(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoEnfermedadConstantesFunciones.getClassesRelationshipsFromStringsOfTipoEnfermedad(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoEnfermedad(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Enfermedad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Enfermedad.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Enfermedad.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Enfermedad.class)); continue;
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
	public static void actualizarLista(TipoEnfermedad tipoenfermedad,List<TipoEnfermedad> tipoenfermedads,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoEnfermedad tipoenfermedadEncontrado=null;
			
			for(TipoEnfermedad tipoenfermedadLocal:tipoenfermedads) {
				if(tipoenfermedadLocal.getId().equals(tipoenfermedad.getId())) {
					tipoenfermedadEncontrado=tipoenfermedadLocal;
					
					tipoenfermedadLocal.setIsChanged(tipoenfermedad.getIsChanged());
					tipoenfermedadLocal.setIsNew(tipoenfermedad.getIsNew());
					tipoenfermedadLocal.setIsDeleted(tipoenfermedad.getIsDeleted());
					
					tipoenfermedadLocal.setGeneralEntityOriginal(tipoenfermedad.getGeneralEntityOriginal());
					
					tipoenfermedadLocal.setId(tipoenfermedad.getId());	
					tipoenfermedadLocal.setVersionRow(tipoenfermedad.getVersionRow());	
					tipoenfermedadLocal.setid_empresa(tipoenfermedad.getid_empresa());	
					tipoenfermedadLocal.setcodigo(tipoenfermedad.getcodigo());	
					tipoenfermedadLocal.setnombre(tipoenfermedad.getnombre());	
					
					
					tipoenfermedadLocal.setEnfermedads(tipoenfermedad.getEnfermedads());
					
					existe=true;
					break;
				}
			}
			
			if(!tipoenfermedad.getIsDeleted()) {
				if(!existe) {
					tipoenfermedads.add(tipoenfermedad);
				}
			} else {
				if(tipoenfermedadEncontrado!=null && permiteQuitar)  {
					tipoenfermedads.remove(tipoenfermedadEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoEnfermedad tipoenfermedad,List<TipoEnfermedad> tipoenfermedads) throws Exception {
		try	{			
			for(TipoEnfermedad tipoenfermedadLocal:tipoenfermedads) {
				if(tipoenfermedadLocal.getId().equals(tipoenfermedad.getId())) {
					tipoenfermedadLocal.setIsSelected(tipoenfermedad.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoEnfermedad(List<TipoEnfermedad> tipoenfermedadsAux) throws Exception {
		//this.tipoenfermedadsAux=tipoenfermedadsAux;
		
		for(TipoEnfermedad tipoenfermedadAux:tipoenfermedadsAux) {
			if(tipoenfermedadAux.getIsChanged()) {
				tipoenfermedadAux.setIsChanged(false);
			}		
			
			if(tipoenfermedadAux.getIsNew()) {
				tipoenfermedadAux.setIsNew(false);
			}	
			
			if(tipoenfermedadAux.getIsDeleted()) {
				tipoenfermedadAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoEnfermedad(TipoEnfermedad tipoenfermedadAux) throws Exception {
		//this.tipoenfermedadAux=tipoenfermedadAux;
		
			if(tipoenfermedadAux.getIsChanged()) {
				tipoenfermedadAux.setIsChanged(false);
			}		
			
			if(tipoenfermedadAux.getIsNew()) {
				tipoenfermedadAux.setIsNew(false);
			}	
			
			if(tipoenfermedadAux.getIsDeleted()) {
				tipoenfermedadAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoEnfermedad tipoenfermedadAsignar,TipoEnfermedad tipoenfermedad) throws Exception {
		tipoenfermedadAsignar.setId(tipoenfermedad.getId());	
		tipoenfermedadAsignar.setVersionRow(tipoenfermedad.getVersionRow());	
		tipoenfermedadAsignar.setid_empresa(tipoenfermedad.getid_empresa());
		tipoenfermedadAsignar.setempresa_descripcion(tipoenfermedad.getempresa_descripcion());	
		tipoenfermedadAsignar.setcodigo(tipoenfermedad.getcodigo());	
		tipoenfermedadAsignar.setnombre(tipoenfermedad.getnombre());	
	}
	
	public static void inicializarTipoEnfermedad(TipoEnfermedad tipoenfermedad) throws Exception {
		try {
				tipoenfermedad.setId(0L);	
					
				tipoenfermedad.setid_empresa(-1L);	
				tipoenfermedad.setcodigo("");	
				tipoenfermedad.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoEnfermedad(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEnfermedadConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEnfermedadConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoEnfermedadConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoEnfermedad(String sTipo,Row row,Workbook workbook,TipoEnfermedad tipoenfermedad,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoenfermedad.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoenfermedad.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipoenfermedad.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoEnfermedad=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoEnfermedad() {
		return this.sFinalQueryTipoEnfermedad;
	}
	
	public void setsFinalQueryTipoEnfermedad(String sFinalQueryTipoEnfermedad) {
		this.sFinalQueryTipoEnfermedad= sFinalQueryTipoEnfermedad;
	}
	
	public Border resaltarSeleccionarTipoEnfermedad=null;
	
	public Border setResaltarSeleccionarTipoEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEnfermedadBeanSwingJInternalFrame tipoenfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipoenfermedadBeanSwingJInternalFrame.jTtoolBarTipoEnfermedad.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoEnfermedad= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoEnfermedad() {
		return this.resaltarSeleccionarTipoEnfermedad;
	}
	
	public void setResaltarSeleccionarTipoEnfermedad(Border borderResaltarSeleccionarTipoEnfermedad) {
		this.resaltarSeleccionarTipoEnfermedad= borderResaltarSeleccionarTipoEnfermedad;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoEnfermedad=null;
	public Boolean mostraridTipoEnfermedad=true;
	public Boolean activaridTipoEnfermedad=true;

	public Border resaltarid_empresaTipoEnfermedad=null;
	public Boolean mostrarid_empresaTipoEnfermedad=true;
	public Boolean activarid_empresaTipoEnfermedad=true;
	public Boolean cargarid_empresaTipoEnfermedad=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoEnfermedad=false;//ConEventDepend=true

	public Border resaltarcodigoTipoEnfermedad=null;
	public Boolean mostrarcodigoTipoEnfermedad=true;
	public Boolean activarcodigoTipoEnfermedad=true;

	public Border resaltarnombreTipoEnfermedad=null;
	public Boolean mostrarnombreTipoEnfermedad=true;
	public Boolean activarnombreTipoEnfermedad=true;

	
	

	public Border setResaltaridTipoEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEnfermedadBeanSwingJInternalFrame tipoenfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoenfermedadBeanSwingJInternalFrame.jTtoolBarTipoEnfermedad.setBorder(borderResaltar);
		
		this.resaltaridTipoEnfermedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoEnfermedad() {
		return this.resaltaridTipoEnfermedad;
	}

	public void setResaltaridTipoEnfermedad(Border borderResaltar) {
		this.resaltaridTipoEnfermedad= borderResaltar;
	}

	public Boolean getMostraridTipoEnfermedad() {
		return this.mostraridTipoEnfermedad;
	}

	public void setMostraridTipoEnfermedad(Boolean mostraridTipoEnfermedad) {
		this.mostraridTipoEnfermedad= mostraridTipoEnfermedad;
	}

	public Boolean getActivaridTipoEnfermedad() {
		return this.activaridTipoEnfermedad;
	}

	public void setActivaridTipoEnfermedad(Boolean activaridTipoEnfermedad) {
		this.activaridTipoEnfermedad= activaridTipoEnfermedad;
	}

	public Border setResaltarid_empresaTipoEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEnfermedadBeanSwingJInternalFrame tipoenfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoenfermedadBeanSwingJInternalFrame.jTtoolBarTipoEnfermedad.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoEnfermedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoEnfermedad() {
		return this.resaltarid_empresaTipoEnfermedad;
	}

	public void setResaltarid_empresaTipoEnfermedad(Border borderResaltar) {
		this.resaltarid_empresaTipoEnfermedad= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoEnfermedad() {
		return this.mostrarid_empresaTipoEnfermedad;
	}

	public void setMostrarid_empresaTipoEnfermedad(Boolean mostrarid_empresaTipoEnfermedad) {
		this.mostrarid_empresaTipoEnfermedad= mostrarid_empresaTipoEnfermedad;
	}

	public Boolean getActivarid_empresaTipoEnfermedad() {
		return this.activarid_empresaTipoEnfermedad;
	}

	public void setActivarid_empresaTipoEnfermedad(Boolean activarid_empresaTipoEnfermedad) {
		this.activarid_empresaTipoEnfermedad= activarid_empresaTipoEnfermedad;
	}

	public Boolean getCargarid_empresaTipoEnfermedad() {
		return this.cargarid_empresaTipoEnfermedad;
	}

	public void setCargarid_empresaTipoEnfermedad(Boolean cargarid_empresaTipoEnfermedad) {
		this.cargarid_empresaTipoEnfermedad= cargarid_empresaTipoEnfermedad;
	}

	public Border setResaltarcodigoTipoEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEnfermedadBeanSwingJInternalFrame tipoenfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoenfermedadBeanSwingJInternalFrame.jTtoolBarTipoEnfermedad.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoEnfermedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoEnfermedad() {
		return this.resaltarcodigoTipoEnfermedad;
	}

	public void setResaltarcodigoTipoEnfermedad(Border borderResaltar) {
		this.resaltarcodigoTipoEnfermedad= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoEnfermedad() {
		return this.mostrarcodigoTipoEnfermedad;
	}

	public void setMostrarcodigoTipoEnfermedad(Boolean mostrarcodigoTipoEnfermedad) {
		this.mostrarcodigoTipoEnfermedad= mostrarcodigoTipoEnfermedad;
	}

	public Boolean getActivarcodigoTipoEnfermedad() {
		return this.activarcodigoTipoEnfermedad;
	}

	public void setActivarcodigoTipoEnfermedad(Boolean activarcodigoTipoEnfermedad) {
		this.activarcodigoTipoEnfermedad= activarcodigoTipoEnfermedad;
	}

	public Border setResaltarnombreTipoEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEnfermedadBeanSwingJInternalFrame tipoenfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipoenfermedadBeanSwingJInternalFrame.jTtoolBarTipoEnfermedad.setBorder(borderResaltar);
		
		this.resaltarnombreTipoEnfermedad= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoEnfermedad() {
		return this.resaltarnombreTipoEnfermedad;
	}

	public void setResaltarnombreTipoEnfermedad(Border borderResaltar) {
		this.resaltarnombreTipoEnfermedad= borderResaltar;
	}

	public Boolean getMostrarnombreTipoEnfermedad() {
		return this.mostrarnombreTipoEnfermedad;
	}

	public void setMostrarnombreTipoEnfermedad(Boolean mostrarnombreTipoEnfermedad) {
		this.mostrarnombreTipoEnfermedad= mostrarnombreTipoEnfermedad;
	}

	public Boolean getActivarnombreTipoEnfermedad() {
		return this.activarnombreTipoEnfermedad;
	}

	public void setActivarnombreTipoEnfermedad(Boolean activarnombreTipoEnfermedad) {
		this.activarnombreTipoEnfermedad= activarnombreTipoEnfermedad;
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
		
		
		this.setMostraridTipoEnfermedad(esInicial);
		this.setMostrarid_empresaTipoEnfermedad(esInicial);
		this.setMostrarcodigoTipoEnfermedad(esInicial);
		this.setMostrarnombreTipoEnfermedad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEnfermedadConstantesFunciones.ID)) {
				this.setMostraridTipoEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEnfermedadConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEnfermedadConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEnfermedadConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoEnfermedad(esAsigna);
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
		
		
		this.setActivaridTipoEnfermedad(esInicial);
		this.setActivarid_empresaTipoEnfermedad(esInicial);
		this.setActivarcodigoTipoEnfermedad(esInicial);
		this.setActivarnombreTipoEnfermedad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEnfermedadConstantesFunciones.ID)) {
				this.setActivaridTipoEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEnfermedadConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEnfermedadConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEnfermedadConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoEnfermedad(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoEnfermedadBeanSwingJInternalFrame tipoenfermedadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoEnfermedad(esInicial);
		this.setResaltarid_empresaTipoEnfermedad(esInicial);
		this.setResaltarcodigoTipoEnfermedad(esInicial);
		this.setResaltarnombreTipoEnfermedad(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoEnfermedadConstantesFunciones.ID)) {
				this.setResaltaridTipoEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEnfermedadConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEnfermedadConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoEnfermedad(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoEnfermedadConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoEnfermedad(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarEnfermedadTipoEnfermedad=null;

	public Border getResaltarEnfermedadTipoEnfermedad() {
		return this.resaltarEnfermedadTipoEnfermedad;
	}

	public void setResaltarEnfermedadTipoEnfermedad(Border borderResaltarEnfermedad) {
		if(borderResaltarEnfermedad!=null) {
			this.resaltarEnfermedadTipoEnfermedad= borderResaltarEnfermedad;
		}
	}

	public Border setResaltarEnfermedadTipoEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEnfermedadBeanSwingJInternalFrame tipoenfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltarEnfermedad=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tipoenfermedadBeanSwingJInternalFrame.jTtoolBarTipoEnfermedad.setBorder(borderResaltarEnfermedad);
			
		this.resaltarEnfermedadTipoEnfermedad= borderResaltarEnfermedad;

		 return borderResaltarEnfermedad;
	}



	public Boolean mostrarEnfermedadTipoEnfermedad=true;

	public Boolean getMostrarEnfermedadTipoEnfermedad() {
		return this.mostrarEnfermedadTipoEnfermedad;
	}

	public void setMostrarEnfermedadTipoEnfermedad(Boolean visibilidadResaltarEnfermedad) {
		this.mostrarEnfermedadTipoEnfermedad= visibilidadResaltarEnfermedad;
	}



	public Boolean activarEnfermedadTipoEnfermedad=true;

	public Boolean gethabilitarResaltarEnfermedadTipoEnfermedad() {
		return this.activarEnfermedadTipoEnfermedad;
	}

	public void setActivarEnfermedadTipoEnfermedad(Boolean habilitarResaltarEnfermedad) {
		this.activarEnfermedadTipoEnfermedad= habilitarResaltarEnfermedad;
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

		this.setMostrarEnfermedadTipoEnfermedad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Enfermedad.class)) {
				this.setMostrarEnfermedadTipoEnfermedad(esAsigna);
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

		this.setActivarEnfermedadTipoEnfermedad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Enfermedad.class)) {
				this.setActivarEnfermedadTipoEnfermedad(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoEnfermedadBeanSwingJInternalFrame tipoenfermedadBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarEnfermedadTipoEnfermedad(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Enfermedad.class)) {
				this.setResaltarEnfermedadTipoEnfermedad(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoEnfermedad=true;

	public Boolean getMostrarFK_IdEmpresaTipoEnfermedad() {
		return this.mostrarFK_IdEmpresaTipoEnfermedad;
	}

	public void setMostrarFK_IdEmpresaTipoEnfermedad(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoEnfermedad= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoEnfermedad=true;

	public Boolean getActivarFK_IdEmpresaTipoEnfermedad() {
		return this.activarFK_IdEmpresaTipoEnfermedad;
	}

	public void setActivarFK_IdEmpresaTipoEnfermedad(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoEnfermedad= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoEnfermedad=null;

	public Border getResaltarFK_IdEmpresaTipoEnfermedad() {
		return this.resaltarFK_IdEmpresaTipoEnfermedad;
	}

	public void setResaltarFK_IdEmpresaTipoEnfermedad(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoEnfermedad= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoEnfermedad(ParametroGeneralUsuario parametroGeneralUsuario/*TipoEnfermedadBeanSwingJInternalFrame tipoenfermedadBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoEnfermedad= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}