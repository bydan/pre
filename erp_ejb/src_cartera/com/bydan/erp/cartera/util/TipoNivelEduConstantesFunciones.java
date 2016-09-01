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


import com.bydan.erp.cartera.util.TipoNivelEduConstantesFunciones;
import com.bydan.erp.cartera.util.TipoNivelEduParameterReturnGeneral;
//import com.bydan.erp.cartera.util.TipoNivelEduParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoNivelEduConstantesFunciones extends TipoNivelEduConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoNivelEdu";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoNivelEdu"+TipoNivelEduConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoNivelEduHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoNivelEduHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoNivelEduConstantesFunciones.SCHEMA+"_"+TipoNivelEduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoNivelEduHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoNivelEduConstantesFunciones.SCHEMA+"_"+TipoNivelEduConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoNivelEduConstantesFunciones.SCHEMA+"_"+TipoNivelEduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoNivelEduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoNivelEduConstantesFunciones.SCHEMA+"_"+TipoNivelEduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNivelEduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoNivelEduHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNivelEduConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNivelEduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoNivelEduHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoNivelEduConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoNivelEduConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoNivelEduConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoNivelEduConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoNivelEduConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Nivel Edus";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Nivel Edu";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Nivel Edu";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoNivelEdu";
	public static final String OBJECTNAME="tiponiveledu";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="tipo_nivel_edu";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tiponiveledu from "+TipoNivelEduConstantesFunciones.SPERSISTENCENAME+" tiponiveledu";
	public static String QUERYSELECTNATIVE="select "+TipoNivelEduConstantesFunciones.SCHEMA+"."+TipoNivelEduConstantesFunciones.TABLENAME+".id,"+TipoNivelEduConstantesFunciones.SCHEMA+"."+TipoNivelEduConstantesFunciones.TABLENAME+".version_row,"+TipoNivelEduConstantesFunciones.SCHEMA+"."+TipoNivelEduConstantesFunciones.TABLENAME+".id_empresa,"+TipoNivelEduConstantesFunciones.SCHEMA+"."+TipoNivelEduConstantesFunciones.TABLENAME+".codigo,"+TipoNivelEduConstantesFunciones.SCHEMA+"."+TipoNivelEduConstantesFunciones.TABLENAME+".nombre,"+TipoNivelEduConstantesFunciones.SCHEMA+"."+TipoNivelEduConstantesFunciones.TABLENAME+".es_defecto from "+TipoNivelEduConstantesFunciones.SCHEMA+"."+TipoNivelEduConstantesFunciones.TABLENAME;//+" as "+TipoNivelEduConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoNivelEduConstantesFuncionesAdditional tiponiveleduConstantesFuncionesAdditional=null;
	
	public TipoNivelEduConstantesFuncionesAdditional getTipoNivelEduConstantesFuncionesAdditional() {
		return this.tiponiveleduConstantesFuncionesAdditional;
	}
	
	public void setTipoNivelEduConstantesFuncionesAdditional(TipoNivelEduConstantesFuncionesAdditional tiponiveleduConstantesFuncionesAdditional) {
		try {
			this.tiponiveleduConstantesFuncionesAdditional=tiponiveleduConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String ESDEFECTO= "es_defecto";
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
    	public static final String LABEL_ESDEFECTO= "Es Defecto";
		public static final String LABEL_ESDEFECTO_LOWER= "Es Defecto";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
		
	
	public static String getTipoNivelEduLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoNivelEduConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoNivelEduConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoNivelEduConstantesFunciones.CODIGO)) {sLabelColumna=TipoNivelEduConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoNivelEduConstantesFunciones.NOMBRE)) {sLabelColumna=TipoNivelEduConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(TipoNivelEduConstantesFunciones.ESDEFECTO)) {sLabelColumna=TipoNivelEduConstantesFunciones.LABEL_ESDEFECTO;}
		
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
	
	
	
			
			
			
			
			
		
	public static String getes_defectoDescripcion(TipoNivelEdu tiponiveledu) throws Exception {
		String sDescripcion=Constantes.SCAMPOVERDADERO;

		if(!tiponiveledu.getes_defecto()) {
			sDescripcion=Constantes.SCAMPOFALSO;
		}

		return sDescripcion;
	}

	public static String getes_defectoHtmlDescripcion(TipoNivelEdu tiponiveledu) throws Exception {
		String sDescripcion=FuncionesJsp.getStringHtmlCheckBox(tiponiveledu.getId(),tiponiveledu.getes_defecto());

		return sDescripcion;
	}	
	
	public static String getTipoNivelEduDescripcion(TipoNivelEdu tiponiveledu) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tiponiveledu !=null/* && tiponiveledu.getId()!=0*/) {
			sDescripcion=tiponiveledu.getcodigo();//tiponiveledutiponiveledu.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoNivelEduDescripcionDetallado(TipoNivelEdu tiponiveledu) {
		String sDescripcion="";
			
		sDescripcion+=TipoNivelEduConstantesFunciones.ID+"=";
		sDescripcion+=tiponiveledu.getId().toString()+",";
		sDescripcion+=TipoNivelEduConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tiponiveledu.getVersionRow().toString()+",";
		sDescripcion+=TipoNivelEduConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tiponiveledu.getid_empresa().toString()+",";
		sDescripcion+=TipoNivelEduConstantesFunciones.CODIGO+"=";
		sDescripcion+=tiponiveledu.getcodigo()+",";
		sDescripcion+=TipoNivelEduConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tiponiveledu.getnombre()+",";
		sDescripcion+=TipoNivelEduConstantesFunciones.ESDEFECTO+"=";
		sDescripcion+=tiponiveledu.getes_defecto().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoNivelEduDescripcion(TipoNivelEdu tiponiveledu,String sValor) throws Exception {			
		if(tiponiveledu !=null) {
			tiponiveledu.setcodigo(sValor);;//tiponiveledutiponiveledu.getcodigo().trim();
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
	
	
	
	
	
	
	public static void quitarEspaciosTipoNivelEdu(TipoNivelEdu tiponiveledu,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tiponiveledu.setcodigo(tiponiveledu.getcodigo().trim());
		tiponiveledu.setnombre(tiponiveledu.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoNivelEdus(List<TipoNivelEdu> tiponiveledus,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoNivelEdu tiponiveledu: tiponiveledus) {
			tiponiveledu.setcodigo(tiponiveledu.getcodigo().trim());
			tiponiveledu.setnombre(tiponiveledu.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoNivelEdu(TipoNivelEdu tiponiveledu,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tiponiveledu.getConCambioAuxiliar()) {
			tiponiveledu.setIsDeleted(tiponiveledu.getIsDeletedAuxiliar());	
			tiponiveledu.setIsNew(tiponiveledu.getIsNewAuxiliar());	
			tiponiveledu.setIsChanged(tiponiveledu.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tiponiveledu.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tiponiveledu.setIsDeletedAuxiliar(false);	
			tiponiveledu.setIsNewAuxiliar(false);	
			tiponiveledu.setIsChangedAuxiliar(false);
			
			tiponiveledu.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoNivelEdus(List<TipoNivelEdu> tiponiveledus,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoNivelEdu tiponiveledu : tiponiveledus) {
			if(conAsignarBase && tiponiveledu.getConCambioAuxiliar()) {
				tiponiveledu.setIsDeleted(tiponiveledu.getIsDeletedAuxiliar());	
				tiponiveledu.setIsNew(tiponiveledu.getIsNewAuxiliar());	
				tiponiveledu.setIsChanged(tiponiveledu.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tiponiveledu.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tiponiveledu.setIsDeletedAuxiliar(false);	
				tiponiveledu.setIsNewAuxiliar(false);	
				tiponiveledu.setIsChangedAuxiliar(false);
				
				tiponiveledu.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoNivelEdu(TipoNivelEdu tiponiveledu,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoNivelEdus(List<TipoNivelEdu> tiponiveledus,Boolean conEnteros) throws Exception  {
		
		for(TipoNivelEdu tiponiveledu: tiponiveledus) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoNivelEdu(List<TipoNivelEdu> tiponiveledus,TipoNivelEdu tiponiveleduAux) throws Exception  {
		TipoNivelEduConstantesFunciones.InicializarValoresTipoNivelEdu(tiponiveleduAux,true);
		
		for(TipoNivelEdu tiponiveledu: tiponiveledus) {
			if(tiponiveledu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoNivelEdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoNivelEduConstantesFunciones.getArrayColumnasGlobalesTipoNivelEdu(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoNivelEdu(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoNivelEduConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoNivelEduConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoNivelEdu(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoNivelEdu> tiponiveledus,TipoNivelEdu tiponiveledu,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoNivelEdu tiponiveleduAux: tiponiveledus) {
			if(tiponiveleduAux!=null && tiponiveledu!=null) {
				if((tiponiveleduAux.getId()==null && tiponiveledu.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tiponiveleduAux.getId()!=null && tiponiveledu.getId()!=null){
					if(tiponiveleduAux.getId().equals(tiponiveledu.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoNivelEdu(List<TipoNivelEdu> tiponiveledus) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoNivelEdu tiponiveledu: tiponiveledus) {			
			if(tiponiveledu.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoNivelEdu() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoNivelEduConstantesFunciones.LABEL_ID, TipoNivelEduConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNivelEduConstantesFunciones.LABEL_VERSIONROW, TipoNivelEduConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNivelEduConstantesFunciones.LABEL_IDEMPRESA, TipoNivelEduConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNivelEduConstantesFunciones.LABEL_CODIGO, TipoNivelEduConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNivelEduConstantesFunciones.LABEL_NOMBRE, TipoNivelEduConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoNivelEduConstantesFunciones.LABEL_ESDEFECTO, TipoNivelEduConstantesFunciones.ESDEFECTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoNivelEdu() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoNivelEduConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNivelEduConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNivelEduConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNivelEduConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNivelEduConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoNivelEduConstantesFunciones.ESDEFECTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoNivelEdu() throws Exception  {
		return TipoNivelEduConstantesFunciones.getTiposSeleccionarTipoNivelEdu(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoNivelEdu(Boolean conFk) throws Exception  {
		return TipoNivelEduConstantesFunciones.getTiposSeleccionarTipoNivelEdu(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoNivelEdu(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoNivelEduConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoNivelEduConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoNivelEduConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoNivelEduConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoNivelEduConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoNivelEduConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conBitColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoNivelEduConstantesFunciones.LABEL_ESDEFECTO);
			reporte.setsDescripcion(TipoNivelEduConstantesFunciones.LABEL_ESDEFECTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoNivelEdu(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoNivelEdu(TipoNivelEdu tiponiveleduAux) throws Exception {
		
			tiponiveleduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiponiveleduAux.getEmpresa()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoNivelEdu(List<TipoNivelEdu> tiponiveledusTemp) throws Exception {
		for(TipoNivelEdu tiponiveleduAux:tiponiveledusTemp) {
			
			tiponiveleduAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tiponiveleduAux.getEmpresa()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoNivelEdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoNivelEdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoNivelEdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoNivelEduConstantesFunciones.getClassesRelationshipsOfTipoNivelEdu(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoNivelEdu(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Cliente.class));
				classes.add(new Classe(SubCliente.class));
				classes.add(new Classe(ParametroCarteraDefecto.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Cliente.class)) {
						classes.add(new Classe(Cliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubCliente.class)) {
						classes.add(new Classe(SubCliente.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(ParametroCarteraDefecto.class)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoNivelEdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoNivelEduConstantesFunciones.getClassesRelationshipsFromStringsOfTipoNivelEdu(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoNivelEdu(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Cliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Cliente.class)); continue;
					}

					if(SubCliente.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubCliente.class)); continue;
					}

					if(ParametroCarteraDefecto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(ParametroCarteraDefecto.class)); continue;
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
	public static void actualizarLista(TipoNivelEdu tiponiveledu,List<TipoNivelEdu> tiponiveledus,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoNivelEdu tiponiveleduEncontrado=null;
			
			for(TipoNivelEdu tiponiveleduLocal:tiponiveledus) {
				if(tiponiveleduLocal.getId().equals(tiponiveledu.getId())) {
					tiponiveleduEncontrado=tiponiveleduLocal;
					
					tiponiveleduLocal.setIsChanged(tiponiveledu.getIsChanged());
					tiponiveleduLocal.setIsNew(tiponiveledu.getIsNew());
					tiponiveleduLocal.setIsDeleted(tiponiveledu.getIsDeleted());
					
					tiponiveleduLocal.setGeneralEntityOriginal(tiponiveledu.getGeneralEntityOriginal());
					
					tiponiveleduLocal.setId(tiponiveledu.getId());	
					tiponiveleduLocal.setVersionRow(tiponiveledu.getVersionRow());	
					tiponiveleduLocal.setid_empresa(tiponiveledu.getid_empresa());	
					tiponiveleduLocal.setcodigo(tiponiveledu.getcodigo());	
					tiponiveleduLocal.setnombre(tiponiveledu.getnombre());	
					tiponiveleduLocal.setes_defecto(tiponiveledu.getes_defecto());	
					
					
					tiponiveleduLocal.setClientes(tiponiveledu.getClientes());
					tiponiveleduLocal.setSubClientes(tiponiveledu.getSubClientes());
					tiponiveleduLocal.setParametroCarteraDefectos(tiponiveledu.getParametroCarteraDefectos());
					
					existe=true;
					break;
				}
			}
			
			if(!tiponiveledu.getIsDeleted()) {
				if(!existe) {
					tiponiveledus.add(tiponiveledu);
				}
			} else {
				if(tiponiveleduEncontrado!=null && permiteQuitar)  {
					tiponiveledus.remove(tiponiveleduEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoNivelEdu tiponiveledu,List<TipoNivelEdu> tiponiveledus) throws Exception {
		try	{			
			for(TipoNivelEdu tiponiveleduLocal:tiponiveledus) {
				if(tiponiveleduLocal.getId().equals(tiponiveledu.getId())) {
					tiponiveleduLocal.setIsSelected(tiponiveledu.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoNivelEdu(List<TipoNivelEdu> tiponiveledusAux) throws Exception {
		//this.tiponiveledusAux=tiponiveledusAux;
		
		for(TipoNivelEdu tiponiveleduAux:tiponiveledusAux) {
			if(tiponiveleduAux.getIsChanged()) {
				tiponiveleduAux.setIsChanged(false);
			}		
			
			if(tiponiveleduAux.getIsNew()) {
				tiponiveleduAux.setIsNew(false);
			}	
			
			if(tiponiveleduAux.getIsDeleted()) {
				tiponiveleduAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoNivelEdu(TipoNivelEdu tiponiveleduAux) throws Exception {
		//this.tiponiveleduAux=tiponiveleduAux;
		
			if(tiponiveleduAux.getIsChanged()) {
				tiponiveleduAux.setIsChanged(false);
			}		
			
			if(tiponiveleduAux.getIsNew()) {
				tiponiveleduAux.setIsNew(false);
			}	
			
			if(tiponiveleduAux.getIsDeleted()) {
				tiponiveleduAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoNivelEdu tiponiveleduAsignar,TipoNivelEdu tiponiveledu) throws Exception {
		tiponiveleduAsignar.setId(tiponiveledu.getId());	
		tiponiveleduAsignar.setVersionRow(tiponiveledu.getVersionRow());	
		tiponiveleduAsignar.setid_empresa(tiponiveledu.getid_empresa());
		tiponiveleduAsignar.setempresa_descripcion(tiponiveledu.getempresa_descripcion());	
		tiponiveleduAsignar.setcodigo(tiponiveledu.getcodigo());	
		tiponiveleduAsignar.setnombre(tiponiveledu.getnombre());	
		tiponiveleduAsignar.setes_defecto(tiponiveledu.getes_defecto());	
	}
	
	public static void inicializarTipoNivelEdu(TipoNivelEdu tiponiveledu) throws Exception {
		try {
				tiponiveledu.setId(0L);	
					
				tiponiveledu.setid_empresa(-1L);	
				tiponiveledu.setcodigo("");	
				tiponiveledu.setnombre("");	
				tiponiveledu.setes_defecto(false);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoNivelEdu(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoNivelEduConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoNivelEduConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoNivelEduConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoNivelEduConstantesFunciones.LABEL_ESDEFECTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoNivelEdu(String sTipo,Row row,Workbook workbook,TipoNivelEdu tiponiveledu,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tiponiveledu.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiponiveledu.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tiponiveledu.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(Funciones2.getDescripcionBoolean(tiponiveledu.getes_defecto()));
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoNivelEdu=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoNivelEdu() {
		return this.sFinalQueryTipoNivelEdu;
	}
	
	public void setsFinalQueryTipoNivelEdu(String sFinalQueryTipoNivelEdu) {
		this.sFinalQueryTipoNivelEdu= sFinalQueryTipoNivelEdu;
	}
	
	public Border resaltarSeleccionarTipoNivelEdu=null;
	
	public Border setResaltarSeleccionarTipoNivelEdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNivelEduBeanSwingJInternalFrame tiponiveleduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tiponiveleduBeanSwingJInternalFrame.jTtoolBarTipoNivelEdu.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoNivelEdu= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoNivelEdu() {
		return this.resaltarSeleccionarTipoNivelEdu;
	}
	
	public void setResaltarSeleccionarTipoNivelEdu(Border borderResaltarSeleccionarTipoNivelEdu) {
		this.resaltarSeleccionarTipoNivelEdu= borderResaltarSeleccionarTipoNivelEdu;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoNivelEdu=null;
	public Boolean mostraridTipoNivelEdu=true;
	public Boolean activaridTipoNivelEdu=true;

	public Border resaltarid_empresaTipoNivelEdu=null;
	public Boolean mostrarid_empresaTipoNivelEdu=true;
	public Boolean activarid_empresaTipoNivelEdu=true;
	public Boolean cargarid_empresaTipoNivelEdu=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoNivelEdu=false;//ConEventDepend=true

	public Border resaltarcodigoTipoNivelEdu=null;
	public Boolean mostrarcodigoTipoNivelEdu=true;
	public Boolean activarcodigoTipoNivelEdu=true;

	public Border resaltarnombreTipoNivelEdu=null;
	public Boolean mostrarnombreTipoNivelEdu=true;
	public Boolean activarnombreTipoNivelEdu=true;

	public Border resaltares_defectoTipoNivelEdu=null;
	public Boolean mostrares_defectoTipoNivelEdu=true;
	public Boolean activares_defectoTipoNivelEdu=true;

	
	

	public Border setResaltaridTipoNivelEdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNivelEduBeanSwingJInternalFrame tiponiveleduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponiveleduBeanSwingJInternalFrame.jTtoolBarTipoNivelEdu.setBorder(borderResaltar);
		
		this.resaltaridTipoNivelEdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoNivelEdu() {
		return this.resaltaridTipoNivelEdu;
	}

	public void setResaltaridTipoNivelEdu(Border borderResaltar) {
		this.resaltaridTipoNivelEdu= borderResaltar;
	}

	public Boolean getMostraridTipoNivelEdu() {
		return this.mostraridTipoNivelEdu;
	}

	public void setMostraridTipoNivelEdu(Boolean mostraridTipoNivelEdu) {
		this.mostraridTipoNivelEdu= mostraridTipoNivelEdu;
	}

	public Boolean getActivaridTipoNivelEdu() {
		return this.activaridTipoNivelEdu;
	}

	public void setActivaridTipoNivelEdu(Boolean activaridTipoNivelEdu) {
		this.activaridTipoNivelEdu= activaridTipoNivelEdu;
	}

	public Border setResaltarid_empresaTipoNivelEdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNivelEduBeanSwingJInternalFrame tiponiveleduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponiveleduBeanSwingJInternalFrame.jTtoolBarTipoNivelEdu.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoNivelEdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoNivelEdu() {
		return this.resaltarid_empresaTipoNivelEdu;
	}

	public void setResaltarid_empresaTipoNivelEdu(Border borderResaltar) {
		this.resaltarid_empresaTipoNivelEdu= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoNivelEdu() {
		return this.mostrarid_empresaTipoNivelEdu;
	}

	public void setMostrarid_empresaTipoNivelEdu(Boolean mostrarid_empresaTipoNivelEdu) {
		this.mostrarid_empresaTipoNivelEdu= mostrarid_empresaTipoNivelEdu;
	}

	public Boolean getActivarid_empresaTipoNivelEdu() {
		return this.activarid_empresaTipoNivelEdu;
	}

	public void setActivarid_empresaTipoNivelEdu(Boolean activarid_empresaTipoNivelEdu) {
		this.activarid_empresaTipoNivelEdu= activarid_empresaTipoNivelEdu;
	}

	public Boolean getCargarid_empresaTipoNivelEdu() {
		return this.cargarid_empresaTipoNivelEdu;
	}

	public void setCargarid_empresaTipoNivelEdu(Boolean cargarid_empresaTipoNivelEdu) {
		this.cargarid_empresaTipoNivelEdu= cargarid_empresaTipoNivelEdu;
	}

	public Border setResaltarcodigoTipoNivelEdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNivelEduBeanSwingJInternalFrame tiponiveleduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponiveleduBeanSwingJInternalFrame.jTtoolBarTipoNivelEdu.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoNivelEdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoNivelEdu() {
		return this.resaltarcodigoTipoNivelEdu;
	}

	public void setResaltarcodigoTipoNivelEdu(Border borderResaltar) {
		this.resaltarcodigoTipoNivelEdu= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoNivelEdu() {
		return this.mostrarcodigoTipoNivelEdu;
	}

	public void setMostrarcodigoTipoNivelEdu(Boolean mostrarcodigoTipoNivelEdu) {
		this.mostrarcodigoTipoNivelEdu= mostrarcodigoTipoNivelEdu;
	}

	public Boolean getActivarcodigoTipoNivelEdu() {
		return this.activarcodigoTipoNivelEdu;
	}

	public void setActivarcodigoTipoNivelEdu(Boolean activarcodigoTipoNivelEdu) {
		this.activarcodigoTipoNivelEdu= activarcodigoTipoNivelEdu;
	}

	public Border setResaltarnombreTipoNivelEdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNivelEduBeanSwingJInternalFrame tiponiveleduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponiveleduBeanSwingJInternalFrame.jTtoolBarTipoNivelEdu.setBorder(borderResaltar);
		
		this.resaltarnombreTipoNivelEdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoNivelEdu() {
		return this.resaltarnombreTipoNivelEdu;
	}

	public void setResaltarnombreTipoNivelEdu(Border borderResaltar) {
		this.resaltarnombreTipoNivelEdu= borderResaltar;
	}

	public Boolean getMostrarnombreTipoNivelEdu() {
		return this.mostrarnombreTipoNivelEdu;
	}

	public void setMostrarnombreTipoNivelEdu(Boolean mostrarnombreTipoNivelEdu) {
		this.mostrarnombreTipoNivelEdu= mostrarnombreTipoNivelEdu;
	}

	public Boolean getActivarnombreTipoNivelEdu() {
		return this.activarnombreTipoNivelEdu;
	}

	public void setActivarnombreTipoNivelEdu(Boolean activarnombreTipoNivelEdu) {
		this.activarnombreTipoNivelEdu= activarnombreTipoNivelEdu;
	}

	public Border setResaltares_defectoTipoNivelEdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNivelEduBeanSwingJInternalFrame tiponiveleduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tiponiveleduBeanSwingJInternalFrame.jTtoolBarTipoNivelEdu.setBorder(borderResaltar);
		
		this.resaltares_defectoTipoNivelEdu= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltares_defectoTipoNivelEdu() {
		return this.resaltares_defectoTipoNivelEdu;
	}

	public void setResaltares_defectoTipoNivelEdu(Border borderResaltar) {
		this.resaltares_defectoTipoNivelEdu= borderResaltar;
	}

	public Boolean getMostrares_defectoTipoNivelEdu() {
		return this.mostrares_defectoTipoNivelEdu;
	}

	public void setMostrares_defectoTipoNivelEdu(Boolean mostrares_defectoTipoNivelEdu) {
		this.mostrares_defectoTipoNivelEdu= mostrares_defectoTipoNivelEdu;
	}

	public Boolean getActivares_defectoTipoNivelEdu() {
		return this.activares_defectoTipoNivelEdu;
	}

	public void setActivares_defectoTipoNivelEdu(Boolean activares_defectoTipoNivelEdu) {
		this.activares_defectoTipoNivelEdu= activares_defectoTipoNivelEdu;
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
		
		
		this.setMostraridTipoNivelEdu(esInicial);
		this.setMostrarid_empresaTipoNivelEdu(esInicial);
		this.setMostrarcodigoTipoNivelEdu(esInicial);
		this.setMostrarnombreTipoNivelEdu(esInicial);
		this.setMostrares_defectoTipoNivelEdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.ID)) {
				this.setMostraridTipoNivelEdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoNivelEdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoNivelEdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoNivelEdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.ESDEFECTO)) {
				this.setMostrares_defectoTipoNivelEdu(esAsigna);
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
		
		
		this.setActivaridTipoNivelEdu(esInicial);
		this.setActivarid_empresaTipoNivelEdu(esInicial);
		this.setActivarcodigoTipoNivelEdu(esInicial);
		this.setActivarnombreTipoNivelEdu(esInicial);
		this.setActivares_defectoTipoNivelEdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.ID)) {
				this.setActivaridTipoNivelEdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoNivelEdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoNivelEdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoNivelEdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.ESDEFECTO)) {
				this.setActivares_defectoTipoNivelEdu(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoNivelEduBeanSwingJInternalFrame tiponiveleduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoNivelEdu(esInicial);
		this.setResaltarid_empresaTipoNivelEdu(esInicial);
		this.setResaltarcodigoTipoNivelEdu(esInicial);
		this.setResaltarnombreTipoNivelEdu(esInicial);
		this.setResaltares_defectoTipoNivelEdu(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.ID)) {
				this.setResaltaridTipoNivelEdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoNivelEdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoNivelEdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoNivelEdu(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoNivelEduConstantesFunciones.ESDEFECTO)) {
				this.setResaltares_defectoTipoNivelEdu(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarClienteTipoNivelEdu=null;

	public Border getResaltarClienteTipoNivelEdu() {
		return this.resaltarClienteTipoNivelEdu;
	}

	public void setResaltarClienteTipoNivelEdu(Border borderResaltarCliente) {
		if(borderResaltarCliente!=null) {
			this.resaltarClienteTipoNivelEdu= borderResaltarCliente;
		}
	}

	public Border setResaltarClienteTipoNivelEdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNivelEduBeanSwingJInternalFrame tiponiveleduBeanSwingJInternalFrame*/) {
		Border borderResaltarCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiponiveleduBeanSwingJInternalFrame.jTtoolBarTipoNivelEdu.setBorder(borderResaltarCliente);
			
		this.resaltarClienteTipoNivelEdu= borderResaltarCliente;

		 return borderResaltarCliente;
	}



	public Boolean mostrarClienteTipoNivelEdu=true;

	public Boolean getMostrarClienteTipoNivelEdu() {
		return this.mostrarClienteTipoNivelEdu;
	}

	public void setMostrarClienteTipoNivelEdu(Boolean visibilidadResaltarCliente) {
		this.mostrarClienteTipoNivelEdu= visibilidadResaltarCliente;
	}



	public Boolean activarClienteTipoNivelEdu=true;

	public Boolean gethabilitarResaltarClienteTipoNivelEdu() {
		return this.activarClienteTipoNivelEdu;
	}

	public void setActivarClienteTipoNivelEdu(Boolean habilitarResaltarCliente) {
		this.activarClienteTipoNivelEdu= habilitarResaltarCliente;
	}


	public Border resaltarSubClienteTipoNivelEdu=null;

	public Border getResaltarSubClienteTipoNivelEdu() {
		return this.resaltarSubClienteTipoNivelEdu;
	}

	public void setResaltarSubClienteTipoNivelEdu(Border borderResaltarSubCliente) {
		if(borderResaltarSubCliente!=null) {
			this.resaltarSubClienteTipoNivelEdu= borderResaltarSubCliente;
		}
	}

	public Border setResaltarSubClienteTipoNivelEdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNivelEduBeanSwingJInternalFrame tiponiveleduBeanSwingJInternalFrame*/) {
		Border borderResaltarSubCliente=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiponiveleduBeanSwingJInternalFrame.jTtoolBarTipoNivelEdu.setBorder(borderResaltarSubCliente);
			
		this.resaltarSubClienteTipoNivelEdu= borderResaltarSubCliente;

		 return borderResaltarSubCliente;
	}



	public Boolean mostrarSubClienteTipoNivelEdu=true;

	public Boolean getMostrarSubClienteTipoNivelEdu() {
		return this.mostrarSubClienteTipoNivelEdu;
	}

	public void setMostrarSubClienteTipoNivelEdu(Boolean visibilidadResaltarSubCliente) {
		this.mostrarSubClienteTipoNivelEdu= visibilidadResaltarSubCliente;
	}



	public Boolean activarSubClienteTipoNivelEdu=true;

	public Boolean gethabilitarResaltarSubClienteTipoNivelEdu() {
		return this.activarSubClienteTipoNivelEdu;
	}

	public void setActivarSubClienteTipoNivelEdu(Boolean habilitarResaltarSubCliente) {
		this.activarSubClienteTipoNivelEdu= habilitarResaltarSubCliente;
	}


	public Border resaltarParametroCarteraDefectoTipoNivelEdu=null;

	public Border getResaltarParametroCarteraDefectoTipoNivelEdu() {
		return this.resaltarParametroCarteraDefectoTipoNivelEdu;
	}

	public void setResaltarParametroCarteraDefectoTipoNivelEdu(Border borderResaltarParametroCarteraDefecto) {
		if(borderResaltarParametroCarteraDefecto!=null) {
			this.resaltarParametroCarteraDefectoTipoNivelEdu= borderResaltarParametroCarteraDefecto;
		}
	}

	public Border setResaltarParametroCarteraDefectoTipoNivelEdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNivelEduBeanSwingJInternalFrame tiponiveleduBeanSwingJInternalFrame*/) {
		Border borderResaltarParametroCarteraDefecto=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//tiponiveleduBeanSwingJInternalFrame.jTtoolBarTipoNivelEdu.setBorder(borderResaltarParametroCarteraDefecto);
			
		this.resaltarParametroCarteraDefectoTipoNivelEdu= borderResaltarParametroCarteraDefecto;

		 return borderResaltarParametroCarteraDefecto;
	}



	public Boolean mostrarParametroCarteraDefectoTipoNivelEdu=true;

	public Boolean getMostrarParametroCarteraDefectoTipoNivelEdu() {
		return this.mostrarParametroCarteraDefectoTipoNivelEdu;
	}

	public void setMostrarParametroCarteraDefectoTipoNivelEdu(Boolean visibilidadResaltarParametroCarteraDefecto) {
		this.mostrarParametroCarteraDefectoTipoNivelEdu= visibilidadResaltarParametroCarteraDefecto;
	}



	public Boolean activarParametroCarteraDefectoTipoNivelEdu=true;

	public Boolean gethabilitarResaltarParametroCarteraDefectoTipoNivelEdu() {
		return this.activarParametroCarteraDefectoTipoNivelEdu;
	}

	public void setActivarParametroCarteraDefectoTipoNivelEdu(Boolean habilitarResaltarParametroCarteraDefecto) {
		this.activarParametroCarteraDefectoTipoNivelEdu= habilitarResaltarParametroCarteraDefecto;
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

		this.setMostrarClienteTipoNivelEdu(esInicial);
		this.setMostrarSubClienteTipoNivelEdu(esInicial);
		this.setMostrarParametroCarteraDefectoTipoNivelEdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setMostrarClienteTipoNivelEdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setMostrarSubClienteTipoNivelEdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setMostrarParametroCarteraDefectoTipoNivelEdu(esAsigna);
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

		this.setActivarClienteTipoNivelEdu(esInicial);
		this.setActivarSubClienteTipoNivelEdu(esInicial);
		this.setActivarParametroCarteraDefectoTipoNivelEdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setActivarClienteTipoNivelEdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setActivarSubClienteTipoNivelEdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setActivarParametroCarteraDefectoTipoNivelEdu(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoNivelEduBeanSwingJInternalFrame tiponiveleduBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarClienteTipoNivelEdu(esInicial);
		this.setResaltarSubClienteTipoNivelEdu(esInicial);
		this.setResaltarParametroCarteraDefectoTipoNivelEdu(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(Cliente.class)) {
				this.setResaltarClienteTipoNivelEdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubCliente.class)) {
				this.setResaltarSubClienteTipoNivelEdu(esAsigna);
				continue;
			}

			if(clase.clas.equals(ParametroCarteraDefecto.class)) {
				this.setResaltarParametroCarteraDefectoTipoNivelEdu(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEmpresaTipoNivelEdu=true;

	public Boolean getMostrarFK_IdEmpresaTipoNivelEdu() {
		return this.mostrarFK_IdEmpresaTipoNivelEdu;
	}

	public void setMostrarFK_IdEmpresaTipoNivelEdu(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoNivelEdu= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoNivelEdu=true;

	public Boolean getActivarFK_IdEmpresaTipoNivelEdu() {
		return this.activarFK_IdEmpresaTipoNivelEdu;
	}

	public void setActivarFK_IdEmpresaTipoNivelEdu(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoNivelEdu= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoNivelEdu=null;

	public Border getResaltarFK_IdEmpresaTipoNivelEdu() {
		return this.resaltarFK_IdEmpresaTipoNivelEdu;
	}

	public void setResaltarFK_IdEmpresaTipoNivelEdu(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoNivelEdu= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoNivelEdu(ParametroGeneralUsuario parametroGeneralUsuario/*TipoNivelEduBeanSwingJInternalFrame tiponiveleduBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoNivelEdu= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}