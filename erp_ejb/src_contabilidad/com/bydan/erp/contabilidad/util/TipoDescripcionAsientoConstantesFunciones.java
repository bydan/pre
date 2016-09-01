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


import com.bydan.erp.contabilidad.util.TipoDescripcionAsientoConstantesFunciones;
import com.bydan.erp.contabilidad.util.TipoDescripcionAsientoParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.TipoDescripcionAsientoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.contabilidad.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.contabilidad.business.dataaccess.*;
//import com.bydan.erp.contabilidad.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class TipoDescripcionAsientoConstantesFunciones extends TipoDescripcionAsientoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="TipoDescripcionAsiento";
	public static final String SPATHOPCION="Contabilidad";	
	public static final String SPATHMODULO="contabilidad/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="TipoDescripcionAsiento"+TipoDescripcionAsientoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="TipoDescripcionAsientoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="TipoDescripcionAsientoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=TipoDescripcionAsientoConstantesFunciones.SCHEMA+"_"+TipoDescripcionAsientoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/TipoDescripcionAsientoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=TipoDescripcionAsientoConstantesFunciones.SCHEMA+"_"+TipoDescripcionAsientoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=TipoDescripcionAsientoConstantesFunciones.SCHEMA+"_"+TipoDescripcionAsientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/TipoDescripcionAsientoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=TipoDescripcionAsientoConstantesFunciones.SCHEMA+"_"+TipoDescripcionAsientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDescripcionAsientoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDescripcionAsientoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDescripcionAsientoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDescripcionAsientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/TipoDescripcionAsientoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+TipoDescripcionAsientoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=TipoDescripcionAsientoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+TipoDescripcionAsientoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=TipoDescripcionAsientoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+TipoDescripcionAsientoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Tipo Descripcion Asiento Contables";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Tipo Descripcion Asiento Contable";
	public static final String SCLASSWEBTITULO_LOWER="Tipo Descripcion Asiento";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="TipoDescripcionAsiento";
	public static final String OBJECTNAME="tipodescripcionasiento";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CONTABILIDAD;	
	public static final String TABLENAME="tipo_descripcion_asiento";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select tipodescripcionasiento from "+TipoDescripcionAsientoConstantesFunciones.SPERSISTENCENAME+" tipodescripcionasiento";
	public static String QUERYSELECTNATIVE="select "+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".id,"+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".version_row,"+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".id_empresa,"+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".id_modulo,"+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".codigo,"+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME+".nombre from "+TipoDescripcionAsientoConstantesFunciones.SCHEMA+"."+TipoDescripcionAsientoConstantesFunciones.TABLENAME;//+" as "+TipoDescripcionAsientoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected TipoDescripcionAsientoConstantesFuncionesAdditional tipodescripcionasientoConstantesFuncionesAdditional=null;
	
	public TipoDescripcionAsientoConstantesFuncionesAdditional getTipoDescripcionAsientoConstantesFuncionesAdditional() {
		return this.tipodescripcionasientoConstantesFuncionesAdditional;
	}
	
	public void setTipoDescripcionAsientoConstantesFuncionesAdditional(TipoDescripcionAsientoConstantesFuncionesAdditional tipodescripcionasientoConstantesFuncionesAdditional) {
		try {
			this.tipodescripcionasientoConstantesFuncionesAdditional=tipodescripcionasientoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDMODULO= "id_modulo";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDMODULO= "Modulo";
		public static final String LABEL_IDMODULO_LOWER= "Modulo";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
	
		
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getTipoDescripcionAsientoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(TipoDescripcionAsientoConstantesFunciones.IDEMPRESA)) {sLabelColumna=TipoDescripcionAsientoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(TipoDescripcionAsientoConstantesFunciones.IDMODULO)) {sLabelColumna=TipoDescripcionAsientoConstantesFunciones.LABEL_IDMODULO;}
		if(sNombreColumna.equals(TipoDescripcionAsientoConstantesFunciones.CODIGO)) {sLabelColumna=TipoDescripcionAsientoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(TipoDescripcionAsientoConstantesFunciones.NOMBRE)) {sLabelColumna=TipoDescripcionAsientoConstantesFunciones.LABEL_NOMBRE;}
		
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
	
	
	
			
			
			
			
			
			
	
	public static String getTipoDescripcionAsientoDescripcion(TipoDescripcionAsiento tipodescripcionasiento) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(tipodescripcionasiento !=null/* && tipodescripcionasiento.getId()!=0*/) {
			sDescripcion=tipodescripcionasiento.getcodigo()+"-"+tipodescripcionasiento.getnombre();//tipodescripcionasientotipodescripcionasiento.getcodigo().trim()+"-"+tipodescripcionasiento.getnombre().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getTipoDescripcionAsientoDescripcionDetallado(TipoDescripcionAsiento tipodescripcionasiento) {
		String sDescripcion="";
			
		sDescripcion+=TipoDescripcionAsientoConstantesFunciones.ID+"=";
		sDescripcion+=tipodescripcionasiento.getId().toString()+",";
		sDescripcion+=TipoDescripcionAsientoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=tipodescripcionasiento.getVersionRow().toString()+",";
		sDescripcion+=TipoDescripcionAsientoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=tipodescripcionasiento.getid_empresa().toString()+",";
		sDescripcion+=TipoDescripcionAsientoConstantesFunciones.IDMODULO+"=";
		sDescripcion+=tipodescripcionasiento.getid_modulo().toString()+",";
		sDescripcion+=TipoDescripcionAsientoConstantesFunciones.CODIGO+"=";
		sDescripcion+=tipodescripcionasiento.getcodigo()+",";
		sDescripcion+=TipoDescripcionAsientoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=tipodescripcionasiento.getnombre()+",";
			
		return sDescripcion;
	}
	
	public static void setTipoDescripcionAsientoDescripcion(TipoDescripcionAsiento tipodescripcionasiento,String sValor) throws Exception {			
		if(tipodescripcionasiento !=null) {
			tipodescripcionasiento.setcodigo(sValor);
tipodescripcionasiento.setnombre(sValor);;//tipodescripcionasientotipodescripcionasiento.getcodigo().trim()+"-"+tipodescripcionasiento.getnombre().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getModuloDescripcion(Modulo modulo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(modulo!=null/*&&modulo.getId()>0*/) {
			sDescripcion=ModuloConstantesFunciones.getModuloDescripcion(modulo);
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
		} else if(sNombreIndice.equals("FK_IdModulo")) {
			sNombreIndice="Tipo=  Por Modulo";
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

	public static String getDetalleIndiceFK_IdModulo(Long id_modulo) {
		String sDetalleIndice=" Parametros->";
		if(id_modulo!=null) {sDetalleIndice+=" Codigo Unico De Modulo="+id_modulo.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosTipoDescripcionAsiento(TipoDescripcionAsiento tipodescripcionasiento,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		tipodescripcionasiento.setcodigo(tipodescripcionasiento.getcodigo().trim());
		tipodescripcionasiento.setnombre(tipodescripcionasiento.getnombre().trim());
	}
	
	public static void quitarEspaciosTipoDescripcionAsientos(List<TipoDescripcionAsiento> tipodescripcionasientos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(TipoDescripcionAsiento tipodescripcionasiento: tipodescripcionasientos) {
			tipodescripcionasiento.setcodigo(tipodescripcionasiento.getcodigo().trim());
			tipodescripcionasiento.setnombre(tipodescripcionasiento.getnombre().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDescripcionAsiento(TipoDescripcionAsiento tipodescripcionasiento,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && tipodescripcionasiento.getConCambioAuxiliar()) {
			tipodescripcionasiento.setIsDeleted(tipodescripcionasiento.getIsDeletedAuxiliar());	
			tipodescripcionasiento.setIsNew(tipodescripcionasiento.getIsNewAuxiliar());	
			tipodescripcionasiento.setIsChanged(tipodescripcionasiento.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			tipodescripcionasiento.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			tipodescripcionasiento.setIsDeletedAuxiliar(false);	
			tipodescripcionasiento.setIsNewAuxiliar(false);	
			tipodescripcionasiento.setIsChangedAuxiliar(false);
			
			tipodescripcionasiento.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresTipoDescripcionAsientos(List<TipoDescripcionAsiento> tipodescripcionasientos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(TipoDescripcionAsiento tipodescripcionasiento : tipodescripcionasientos) {
			if(conAsignarBase && tipodescripcionasiento.getConCambioAuxiliar()) {
				tipodescripcionasiento.setIsDeleted(tipodescripcionasiento.getIsDeletedAuxiliar());	
				tipodescripcionasiento.setIsNew(tipodescripcionasiento.getIsNewAuxiliar());	
				tipodescripcionasiento.setIsChanged(tipodescripcionasiento.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				tipodescripcionasiento.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				tipodescripcionasiento.setIsDeletedAuxiliar(false);	
				tipodescripcionasiento.setIsNewAuxiliar(false);	
				tipodescripcionasiento.setIsChangedAuxiliar(false);
				
				tipodescripcionasiento.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresTipoDescripcionAsiento(TipoDescripcionAsiento tipodescripcionasiento,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresTipoDescripcionAsientos(List<TipoDescripcionAsiento> tipodescripcionasientos,Boolean conEnteros) throws Exception  {
		
		for(TipoDescripcionAsiento tipodescripcionasiento: tipodescripcionasientos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaTipoDescripcionAsiento(List<TipoDescripcionAsiento> tipodescripcionasientos,TipoDescripcionAsiento tipodescripcionasientoAux) throws Exception  {
		TipoDescripcionAsientoConstantesFunciones.InicializarValoresTipoDescripcionAsiento(tipodescripcionasientoAux,true);
		
		for(TipoDescripcionAsiento tipodescripcionasiento: tipodescripcionasientos) {
			if(tipodescripcionasiento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDescripcionAsiento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=TipoDescripcionAsientoConstantesFunciones.getArrayColumnasGlobalesTipoDescripcionAsiento(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesTipoDescripcionAsiento(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoDescripcionAsientoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoDescripcionAsientoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(TipoDescripcionAsientoConstantesFunciones.IDMODULO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(TipoDescripcionAsientoConstantesFunciones.IDMODULO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoTipoDescripcionAsiento(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		arrColumnasGlobales.add(TipoDescripcionAsientoConstantesFunciones.IDMODULO);
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<TipoDescripcionAsiento> tipodescripcionasientos,TipoDescripcionAsiento tipodescripcionasiento,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(TipoDescripcionAsiento tipodescripcionasientoAux: tipodescripcionasientos) {
			if(tipodescripcionasientoAux!=null && tipodescripcionasiento!=null) {
				if((tipodescripcionasientoAux.getId()==null && tipodescripcionasiento.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(tipodescripcionasientoAux.getId()!=null && tipodescripcionasiento.getId()!=null){
					if(tipodescripcionasientoAux.getId().equals(tipodescripcionasiento.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaTipoDescripcionAsiento(List<TipoDescripcionAsiento> tipodescripcionasientos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(TipoDescripcionAsiento tipodescripcionasiento: tipodescripcionasientos) {			
			if(tipodescripcionasiento.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaTipoDescripcionAsiento() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,TipoDescripcionAsientoConstantesFunciones.LABEL_ID, TipoDescripcionAsientoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDescripcionAsientoConstantesFunciones.LABEL_VERSIONROW, TipoDescripcionAsientoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDescripcionAsientoConstantesFunciones.LABEL_IDEMPRESA, TipoDescripcionAsientoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDescripcionAsientoConstantesFunciones.LABEL_IDMODULO, TipoDescripcionAsientoConstantesFunciones.IDMODULO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDescripcionAsientoConstantesFunciones.LABEL_CODIGO, TipoDescripcionAsientoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,TipoDescripcionAsientoConstantesFunciones.LABEL_NOMBRE, TipoDescripcionAsientoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasTipoDescripcionAsiento() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=TipoDescripcionAsientoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDescripcionAsientoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDescripcionAsientoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDescripcionAsientoConstantesFunciones.IDMODULO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDescripcionAsientoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=TipoDescripcionAsientoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDescripcionAsiento() throws Exception  {
		return TipoDescripcionAsientoConstantesFunciones.getTiposSeleccionarTipoDescripcionAsiento(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDescripcionAsiento(Boolean conFk) throws Exception  {
		return TipoDescripcionAsientoConstantesFunciones.getTiposSeleccionarTipoDescripcionAsiento(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarTipoDescripcionAsiento(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDescripcionAsientoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(TipoDescripcionAsientoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDescripcionAsientoConstantesFunciones.LABEL_IDMODULO);
			reporte.setsDescripcion(TipoDescripcionAsientoConstantesFunciones.LABEL_IDMODULO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDescripcionAsientoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(TipoDescripcionAsientoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(TipoDescripcionAsientoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(TipoDescripcionAsientoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesTipoDescripcionAsiento(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDescripcionAsiento(TipoDescripcionAsiento tipodescripcionasientoAux) throws Exception {
		
			tipodescripcionasientoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodescripcionasientoAux.getEmpresa()));
			tipodescripcionasientoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(tipodescripcionasientoAux.getModulo()));		
	}
	
	public static void refrescarForeignKeysDescripcionesTipoDescripcionAsiento(List<TipoDescripcionAsiento> tipodescripcionasientosTemp) throws Exception {
		for(TipoDescripcionAsiento tipodescripcionasientoAux:tipodescripcionasientosTemp) {
			
			tipodescripcionasientoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(tipodescripcionasientoAux.getEmpresa()));
			tipodescripcionasientoAux.setmodulo_descripcion(ModuloConstantesFunciones.getModuloDescripcion(tipodescripcionasientoAux.getModulo()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfTipoDescripcionAsiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Modulo.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Modulo.class)) {
						classes.add(new Classe(Modulo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfTipoDescripcionAsiento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Modulo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Modulo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDescripcionAsiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDescripcionAsientoConstantesFunciones.getClassesRelationshipsOfTipoDescripcionAsiento(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfTipoDescripcionAsiento(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDescripcionAsiento(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return TipoDescripcionAsientoConstantesFunciones.getClassesRelationshipsFromStringsOfTipoDescripcionAsiento(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfTipoDescripcionAsiento(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(TipoDescripcionAsiento tipodescripcionasiento,List<TipoDescripcionAsiento> tipodescripcionasientos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			TipoDescripcionAsiento tipodescripcionasientoEncontrado=null;
			
			for(TipoDescripcionAsiento tipodescripcionasientoLocal:tipodescripcionasientos) {
				if(tipodescripcionasientoLocal.getId().equals(tipodescripcionasiento.getId())) {
					tipodescripcionasientoEncontrado=tipodescripcionasientoLocal;
					
					tipodescripcionasientoLocal.setIsChanged(tipodescripcionasiento.getIsChanged());
					tipodescripcionasientoLocal.setIsNew(tipodescripcionasiento.getIsNew());
					tipodescripcionasientoLocal.setIsDeleted(tipodescripcionasiento.getIsDeleted());
					
					tipodescripcionasientoLocal.setGeneralEntityOriginal(tipodescripcionasiento.getGeneralEntityOriginal());
					
					tipodescripcionasientoLocal.setId(tipodescripcionasiento.getId());	
					tipodescripcionasientoLocal.setVersionRow(tipodescripcionasiento.getVersionRow());	
					tipodescripcionasientoLocal.setid_empresa(tipodescripcionasiento.getid_empresa());	
					tipodescripcionasientoLocal.setid_modulo(tipodescripcionasiento.getid_modulo());	
					tipodescripcionasientoLocal.setcodigo(tipodescripcionasiento.getcodigo());	
					tipodescripcionasientoLocal.setnombre(tipodescripcionasiento.getnombre());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!tipodescripcionasiento.getIsDeleted()) {
				if(!existe) {
					tipodescripcionasientos.add(tipodescripcionasiento);
				}
			} else {
				if(tipodescripcionasientoEncontrado!=null && permiteQuitar)  {
					tipodescripcionasientos.remove(tipodescripcionasientoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(TipoDescripcionAsiento tipodescripcionasiento,List<TipoDescripcionAsiento> tipodescripcionasientos) throws Exception {
		try	{			
			for(TipoDescripcionAsiento tipodescripcionasientoLocal:tipodescripcionasientos) {
				if(tipodescripcionasientoLocal.getId().equals(tipodescripcionasiento.getId())) {
					tipodescripcionasientoLocal.setIsSelected(tipodescripcionasiento.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesTipoDescripcionAsiento(List<TipoDescripcionAsiento> tipodescripcionasientosAux) throws Exception {
		//this.tipodescripcionasientosAux=tipodescripcionasientosAux;
		
		for(TipoDescripcionAsiento tipodescripcionasientoAux:tipodescripcionasientosAux) {
			if(tipodescripcionasientoAux.getIsChanged()) {
				tipodescripcionasientoAux.setIsChanged(false);
			}		
			
			if(tipodescripcionasientoAux.getIsNew()) {
				tipodescripcionasientoAux.setIsNew(false);
			}	
			
			if(tipodescripcionasientoAux.getIsDeleted()) {
				tipodescripcionasientoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesTipoDescripcionAsiento(TipoDescripcionAsiento tipodescripcionasientoAux) throws Exception {
		//this.tipodescripcionasientoAux=tipodescripcionasientoAux;
		
			if(tipodescripcionasientoAux.getIsChanged()) {
				tipodescripcionasientoAux.setIsChanged(false);
			}		
			
			if(tipodescripcionasientoAux.getIsNew()) {
				tipodescripcionasientoAux.setIsNew(false);
			}	
			
			if(tipodescripcionasientoAux.getIsDeleted()) {
				tipodescripcionasientoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(TipoDescripcionAsiento tipodescripcionasientoAsignar,TipoDescripcionAsiento tipodescripcionasiento) throws Exception {
		tipodescripcionasientoAsignar.setId(tipodescripcionasiento.getId());	
		tipodescripcionasientoAsignar.setVersionRow(tipodescripcionasiento.getVersionRow());	
		tipodescripcionasientoAsignar.setid_empresa(tipodescripcionasiento.getid_empresa());
		tipodescripcionasientoAsignar.setempresa_descripcion(tipodescripcionasiento.getempresa_descripcion());	
		tipodescripcionasientoAsignar.setid_modulo(tipodescripcionasiento.getid_modulo());
		tipodescripcionasientoAsignar.setmodulo_descripcion(tipodescripcionasiento.getmodulo_descripcion());	
		tipodescripcionasientoAsignar.setcodigo(tipodescripcionasiento.getcodigo());	
		tipodescripcionasientoAsignar.setnombre(tipodescripcionasiento.getnombre());	
	}
	
	public static void inicializarTipoDescripcionAsiento(TipoDescripcionAsiento tipodescripcionasiento) throws Exception {
		try {
				tipodescripcionasiento.setId(0L);	
					
				tipodescripcionasiento.setid_empresa(-1L);	
				tipodescripcionasiento.setid_modulo(-1L);	
				tipodescripcionasiento.setcodigo("");	
				tipodescripcionasiento.setnombre("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderTipoDescripcionAsiento(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDescripcionAsientoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDescripcionAsientoConstantesFunciones.LABEL_IDMODULO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDescripcionAsientoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(TipoDescripcionAsientoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataTipoDescripcionAsiento(String sTipo,Row row,Workbook workbook,TipoDescripcionAsiento tipodescripcionasiento,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodescripcionasiento.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodescripcionasiento.getmodulo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodescripcionasiento.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(tipodescripcionasiento.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryTipoDescripcionAsiento=Constantes.SFINALQUERY;
	
	public String getsFinalQueryTipoDescripcionAsiento() {
		return this.sFinalQueryTipoDescripcionAsiento;
	}
	
	public void setsFinalQueryTipoDescripcionAsiento(String sFinalQueryTipoDescripcionAsiento) {
		this.sFinalQueryTipoDescripcionAsiento= sFinalQueryTipoDescripcionAsiento;
	}
	
	public Border resaltarSeleccionarTipoDescripcionAsiento=null;
	
	public Border setResaltarSeleccionarTipoDescripcionAsiento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDescripcionAsientoBeanSwingJInternalFrame tipodescripcionasientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//tipodescripcionasientoBeanSwingJInternalFrame.jTtoolBarTipoDescripcionAsiento.setBorder(borderResaltar);
		
		this.resaltarSeleccionarTipoDescripcionAsiento= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarTipoDescripcionAsiento() {
		return this.resaltarSeleccionarTipoDescripcionAsiento;
	}
	
	public void setResaltarSeleccionarTipoDescripcionAsiento(Border borderResaltarSeleccionarTipoDescripcionAsiento) {
		this.resaltarSeleccionarTipoDescripcionAsiento= borderResaltarSeleccionarTipoDescripcionAsiento;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridTipoDescripcionAsiento=null;
	public Boolean mostraridTipoDescripcionAsiento=true;
	public Boolean activaridTipoDescripcionAsiento=true;

	public Border resaltarid_empresaTipoDescripcionAsiento=null;
	public Boolean mostrarid_empresaTipoDescripcionAsiento=true;
	public Boolean activarid_empresaTipoDescripcionAsiento=true;
	public Boolean cargarid_empresaTipoDescripcionAsiento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaTipoDescripcionAsiento=false;//ConEventDepend=true

	public Border resaltarid_moduloTipoDescripcionAsiento=null;
	public Boolean mostrarid_moduloTipoDescripcionAsiento=true;
	public Boolean activarid_moduloTipoDescripcionAsiento=true;
	public Boolean cargarid_moduloTipoDescripcionAsiento=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_moduloTipoDescripcionAsiento=false;//ConEventDepend=true

	public Border resaltarcodigoTipoDescripcionAsiento=null;
	public Boolean mostrarcodigoTipoDescripcionAsiento=true;
	public Boolean activarcodigoTipoDescripcionAsiento=true;

	public Border resaltarnombreTipoDescripcionAsiento=null;
	public Boolean mostrarnombreTipoDescripcionAsiento=true;
	public Boolean activarnombreTipoDescripcionAsiento=true;

	
	

	public Border setResaltaridTipoDescripcionAsiento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDescripcionAsientoBeanSwingJInternalFrame tipodescripcionasientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodescripcionasientoBeanSwingJInternalFrame.jTtoolBarTipoDescripcionAsiento.setBorder(borderResaltar);
		
		this.resaltaridTipoDescripcionAsiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridTipoDescripcionAsiento() {
		return this.resaltaridTipoDescripcionAsiento;
	}

	public void setResaltaridTipoDescripcionAsiento(Border borderResaltar) {
		this.resaltaridTipoDescripcionAsiento= borderResaltar;
	}

	public Boolean getMostraridTipoDescripcionAsiento() {
		return this.mostraridTipoDescripcionAsiento;
	}

	public void setMostraridTipoDescripcionAsiento(Boolean mostraridTipoDescripcionAsiento) {
		this.mostraridTipoDescripcionAsiento= mostraridTipoDescripcionAsiento;
	}

	public Boolean getActivaridTipoDescripcionAsiento() {
		return this.activaridTipoDescripcionAsiento;
	}

	public void setActivaridTipoDescripcionAsiento(Boolean activaridTipoDescripcionAsiento) {
		this.activaridTipoDescripcionAsiento= activaridTipoDescripcionAsiento;
	}

	public Border setResaltarid_empresaTipoDescripcionAsiento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDescripcionAsientoBeanSwingJInternalFrame tipodescripcionasientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodescripcionasientoBeanSwingJInternalFrame.jTtoolBarTipoDescripcionAsiento.setBorder(borderResaltar);
		
		this.resaltarid_empresaTipoDescripcionAsiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaTipoDescripcionAsiento() {
		return this.resaltarid_empresaTipoDescripcionAsiento;
	}

	public void setResaltarid_empresaTipoDescripcionAsiento(Border borderResaltar) {
		this.resaltarid_empresaTipoDescripcionAsiento= borderResaltar;
	}

	public Boolean getMostrarid_empresaTipoDescripcionAsiento() {
		return this.mostrarid_empresaTipoDescripcionAsiento;
	}

	public void setMostrarid_empresaTipoDescripcionAsiento(Boolean mostrarid_empresaTipoDescripcionAsiento) {
		this.mostrarid_empresaTipoDescripcionAsiento= mostrarid_empresaTipoDescripcionAsiento;
	}

	public Boolean getActivarid_empresaTipoDescripcionAsiento() {
		return this.activarid_empresaTipoDescripcionAsiento;
	}

	public void setActivarid_empresaTipoDescripcionAsiento(Boolean activarid_empresaTipoDescripcionAsiento) {
		this.activarid_empresaTipoDescripcionAsiento= activarid_empresaTipoDescripcionAsiento;
	}

	public Boolean getCargarid_empresaTipoDescripcionAsiento() {
		return this.cargarid_empresaTipoDescripcionAsiento;
	}

	public void setCargarid_empresaTipoDescripcionAsiento(Boolean cargarid_empresaTipoDescripcionAsiento) {
		this.cargarid_empresaTipoDescripcionAsiento= cargarid_empresaTipoDescripcionAsiento;
	}

	public Border setResaltarid_moduloTipoDescripcionAsiento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDescripcionAsientoBeanSwingJInternalFrame tipodescripcionasientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodescripcionasientoBeanSwingJInternalFrame.jTtoolBarTipoDescripcionAsiento.setBorder(borderResaltar);
		
		this.resaltarid_moduloTipoDescripcionAsiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_moduloTipoDescripcionAsiento() {
		return this.resaltarid_moduloTipoDescripcionAsiento;
	}

	public void setResaltarid_moduloTipoDescripcionAsiento(Border borderResaltar) {
		this.resaltarid_moduloTipoDescripcionAsiento= borderResaltar;
	}

	public Boolean getMostrarid_moduloTipoDescripcionAsiento() {
		return this.mostrarid_moduloTipoDescripcionAsiento;
	}

	public void setMostrarid_moduloTipoDescripcionAsiento(Boolean mostrarid_moduloTipoDescripcionAsiento) {
		this.mostrarid_moduloTipoDescripcionAsiento= mostrarid_moduloTipoDescripcionAsiento;
	}

	public Boolean getActivarid_moduloTipoDescripcionAsiento() {
		return this.activarid_moduloTipoDescripcionAsiento;
	}

	public void setActivarid_moduloTipoDescripcionAsiento(Boolean activarid_moduloTipoDescripcionAsiento) {
		this.activarid_moduloTipoDescripcionAsiento= activarid_moduloTipoDescripcionAsiento;
	}

	public Boolean getCargarid_moduloTipoDescripcionAsiento() {
		return this.cargarid_moduloTipoDescripcionAsiento;
	}

	public void setCargarid_moduloTipoDescripcionAsiento(Boolean cargarid_moduloTipoDescripcionAsiento) {
		this.cargarid_moduloTipoDescripcionAsiento= cargarid_moduloTipoDescripcionAsiento;
	}

	public Border setResaltarcodigoTipoDescripcionAsiento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDescripcionAsientoBeanSwingJInternalFrame tipodescripcionasientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodescripcionasientoBeanSwingJInternalFrame.jTtoolBarTipoDescripcionAsiento.setBorder(borderResaltar);
		
		this.resaltarcodigoTipoDescripcionAsiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoTipoDescripcionAsiento() {
		return this.resaltarcodigoTipoDescripcionAsiento;
	}

	public void setResaltarcodigoTipoDescripcionAsiento(Border borderResaltar) {
		this.resaltarcodigoTipoDescripcionAsiento= borderResaltar;
	}

	public Boolean getMostrarcodigoTipoDescripcionAsiento() {
		return this.mostrarcodigoTipoDescripcionAsiento;
	}

	public void setMostrarcodigoTipoDescripcionAsiento(Boolean mostrarcodigoTipoDescripcionAsiento) {
		this.mostrarcodigoTipoDescripcionAsiento= mostrarcodigoTipoDescripcionAsiento;
	}

	public Boolean getActivarcodigoTipoDescripcionAsiento() {
		return this.activarcodigoTipoDescripcionAsiento;
	}

	public void setActivarcodigoTipoDescripcionAsiento(Boolean activarcodigoTipoDescripcionAsiento) {
		this.activarcodigoTipoDescripcionAsiento= activarcodigoTipoDescripcionAsiento;
	}

	public Border setResaltarnombreTipoDescripcionAsiento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDescripcionAsientoBeanSwingJInternalFrame tipodescripcionasientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//tipodescripcionasientoBeanSwingJInternalFrame.jTtoolBarTipoDescripcionAsiento.setBorder(borderResaltar);
		
		this.resaltarnombreTipoDescripcionAsiento= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreTipoDescripcionAsiento() {
		return this.resaltarnombreTipoDescripcionAsiento;
	}

	public void setResaltarnombreTipoDescripcionAsiento(Border borderResaltar) {
		this.resaltarnombreTipoDescripcionAsiento= borderResaltar;
	}

	public Boolean getMostrarnombreTipoDescripcionAsiento() {
		return this.mostrarnombreTipoDescripcionAsiento;
	}

	public void setMostrarnombreTipoDescripcionAsiento(Boolean mostrarnombreTipoDescripcionAsiento) {
		this.mostrarnombreTipoDescripcionAsiento= mostrarnombreTipoDescripcionAsiento;
	}

	public Boolean getActivarnombreTipoDescripcionAsiento() {
		return this.activarnombreTipoDescripcionAsiento;
	}

	public void setActivarnombreTipoDescripcionAsiento(Boolean activarnombreTipoDescripcionAsiento) {
		this.activarnombreTipoDescripcionAsiento= activarnombreTipoDescripcionAsiento;
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
		
		
		this.setMostraridTipoDescripcionAsiento(esInicial);
		this.setMostrarid_empresaTipoDescripcionAsiento(esInicial);
		this.setMostrarid_moduloTipoDescripcionAsiento(esInicial);
		this.setMostrarcodigoTipoDescripcionAsiento(esInicial);
		this.setMostrarnombreTipoDescripcionAsiento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.ID)) {
				this.setMostraridTipoDescripcionAsiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaTipoDescripcionAsiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.IDMODULO)) {
				this.setMostrarid_moduloTipoDescripcionAsiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoTipoDescripcionAsiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreTipoDescripcionAsiento(esAsigna);
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
		
		
		this.setActivaridTipoDescripcionAsiento(esInicial);
		this.setActivarid_empresaTipoDescripcionAsiento(esInicial);
		this.setActivarid_moduloTipoDescripcionAsiento(esInicial);
		this.setActivarcodigoTipoDescripcionAsiento(esInicial);
		this.setActivarnombreTipoDescripcionAsiento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.ID)) {
				this.setActivaridTipoDescripcionAsiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaTipoDescripcionAsiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.IDMODULO)) {
				this.setActivarid_moduloTipoDescripcionAsiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoTipoDescripcionAsiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreTipoDescripcionAsiento(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDescripcionAsientoBeanSwingJInternalFrame tipodescripcionasientoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridTipoDescripcionAsiento(esInicial);
		this.setResaltarid_empresaTipoDescripcionAsiento(esInicial);
		this.setResaltarid_moduloTipoDescripcionAsiento(esInicial);
		this.setResaltarcodigoTipoDescripcionAsiento(esInicial);
		this.setResaltarnombreTipoDescripcionAsiento(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.ID)) {
				this.setResaltaridTipoDescripcionAsiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaTipoDescripcionAsiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.IDMODULO)) {
				this.setResaltarid_moduloTipoDescripcionAsiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoTipoDescripcionAsiento(esAsigna);
				continue;
			}

			if(campo.clase.equals(TipoDescripcionAsientoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreTipoDescripcionAsiento(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,TipoDescripcionAsientoBeanSwingJInternalFrame tipodescripcionasientoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaTipoDescripcionAsiento=true;

	public Boolean getMostrarFK_IdEmpresaTipoDescripcionAsiento() {
		return this.mostrarFK_IdEmpresaTipoDescripcionAsiento;
	}

	public void setMostrarFK_IdEmpresaTipoDescripcionAsiento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaTipoDescripcionAsiento= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdModuloTipoDescripcionAsiento=true;

	public Boolean getMostrarFK_IdModuloTipoDescripcionAsiento() {
		return this.mostrarFK_IdModuloTipoDescripcionAsiento;
	}

	public void setMostrarFK_IdModuloTipoDescripcionAsiento(Boolean visibilidadResaltar) {
		this.mostrarFK_IdModuloTipoDescripcionAsiento= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaTipoDescripcionAsiento=true;

	public Boolean getActivarFK_IdEmpresaTipoDescripcionAsiento() {
		return this.activarFK_IdEmpresaTipoDescripcionAsiento;
	}

	public void setActivarFK_IdEmpresaTipoDescripcionAsiento(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaTipoDescripcionAsiento= habilitarResaltar;
	}

	public Boolean activarFK_IdModuloTipoDescripcionAsiento=true;

	public Boolean getActivarFK_IdModuloTipoDescripcionAsiento() {
		return this.activarFK_IdModuloTipoDescripcionAsiento;
	}

	public void setActivarFK_IdModuloTipoDescripcionAsiento(Boolean habilitarResaltar) {
		this.activarFK_IdModuloTipoDescripcionAsiento= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaTipoDescripcionAsiento=null;

	public Border getResaltarFK_IdEmpresaTipoDescripcionAsiento() {
		return this.resaltarFK_IdEmpresaTipoDescripcionAsiento;
	}

	public void setResaltarFK_IdEmpresaTipoDescripcionAsiento(Border borderResaltar) {
		this.resaltarFK_IdEmpresaTipoDescripcionAsiento= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaTipoDescripcionAsiento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDescripcionAsientoBeanSwingJInternalFrame tipodescripcionasientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaTipoDescripcionAsiento= borderResaltar;
	}

	public Border resaltarFK_IdModuloTipoDescripcionAsiento=null;

	public Border getResaltarFK_IdModuloTipoDescripcionAsiento() {
		return this.resaltarFK_IdModuloTipoDescripcionAsiento;
	}

	public void setResaltarFK_IdModuloTipoDescripcionAsiento(Border borderResaltar) {
		this.resaltarFK_IdModuloTipoDescripcionAsiento= borderResaltar;
	}

	public void setResaltarFK_IdModuloTipoDescripcionAsiento(ParametroGeneralUsuario parametroGeneralUsuario/*TipoDescripcionAsientoBeanSwingJInternalFrame tipodescripcionasientoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdModuloTipoDescripcionAsiento= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}