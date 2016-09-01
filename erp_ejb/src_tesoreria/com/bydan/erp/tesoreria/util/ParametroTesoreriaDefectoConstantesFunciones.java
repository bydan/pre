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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.ParametroTesoreriaDefectoConstantesFunciones;
import com.bydan.erp.tesoreria.util.ParametroTesoreriaDefectoParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.ParametroTesoreriaDefectoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ParametroTesoreriaDefectoConstantesFunciones extends ParametroTesoreriaDefectoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="ParametroTesoreriaDefecto";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ParametroTesoreriaDefecto"+ParametroTesoreriaDefectoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ParametroTesoreriaDefectoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ParametroTesoreriaDefectoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ParametroTesoreriaDefectoConstantesFunciones.SCHEMA+"_"+ParametroTesoreriaDefectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ParametroTesoreriaDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ParametroTesoreriaDefectoConstantesFunciones.SCHEMA+"_"+ParametroTesoreriaDefectoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ParametroTesoreriaDefectoConstantesFunciones.SCHEMA+"_"+ParametroTesoreriaDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ParametroTesoreriaDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ParametroTesoreriaDefectoConstantesFunciones.SCHEMA+"_"+ParametroTesoreriaDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroTesoreriaDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroTesoreriaDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroTesoreriaDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroTesoreriaDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ParametroTesoreriaDefectoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ParametroTesoreriaDefectoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ParametroTesoreriaDefectoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ParametroTesoreriaDefectoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ParametroTesoreriaDefectoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ParametroTesoreriaDefectoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Parametro Tesoreria Defectos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Parametro Tesoreria Defecto";
	public static final String SCLASSWEBTITULO_LOWER="Parametro Tesoreria Defecto";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ParametroTesoreriaDefecto";
	public static final String OBJECTNAME="parametrotesoreriadefecto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="parametro_tesoreria_defecto";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select parametrotesoreriadefecto from "+ParametroTesoreriaDefectoConstantesFunciones.SPERSISTENCENAME+" parametrotesoreriadefecto";
	public static String QUERYSELECTNATIVE="select "+ParametroTesoreriaDefectoConstantesFunciones.SCHEMA+"."+ParametroTesoreriaDefectoConstantesFunciones.TABLENAME+".id,"+ParametroTesoreriaDefectoConstantesFunciones.SCHEMA+"."+ParametroTesoreriaDefectoConstantesFunciones.TABLENAME+".version_row,"+ParametroTesoreriaDefectoConstantesFunciones.SCHEMA+"."+ParametroTesoreriaDefectoConstantesFunciones.TABLENAME+".id_empresa,"+ParametroTesoreriaDefectoConstantesFunciones.SCHEMA+"."+ParametroTesoreriaDefectoConstantesFunciones.TABLENAME+".id_sucursal,"+ParametroTesoreriaDefectoConstantesFunciones.SCHEMA+"."+ParametroTesoreriaDefectoConstantesFunciones.TABLENAME+".id_tipo_cuenta_banco_global from "+ParametroTesoreriaDefectoConstantesFunciones.SCHEMA+"."+ParametroTesoreriaDefectoConstantesFunciones.TABLENAME;//+" as "+ParametroTesoreriaDefectoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected ParametroTesoreriaDefectoConstantesFuncionesAdditional parametrotesoreriadefectoConstantesFuncionesAdditional=null;
	
	public ParametroTesoreriaDefectoConstantesFuncionesAdditional getParametroTesoreriaDefectoConstantesFuncionesAdditional() {
		return this.parametrotesoreriadefectoConstantesFuncionesAdditional;
	}
	
	public void setParametroTesoreriaDefectoConstantesFuncionesAdditional(ParametroTesoreriaDefectoConstantesFuncionesAdditional parametrotesoreriadefectoConstantesFuncionesAdditional) {
		try {
			this.parametrotesoreriadefectoConstantesFuncionesAdditional=parametrotesoreriadefectoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDTIPOCUENTABANCOGLOBAL= "id_tipo_cuenta_banco_global";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDTIPOCUENTABANCOGLOBAL= "Tipo Cuenta";
		public static final String LABEL_IDTIPOCUENTABANCOGLOBAL_LOWER= "Tipo Cuenta Banco Global";
	
		
		
		
		
		
	
	public static String getParametroTesoreriaDefectoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ParametroTesoreriaDefectoConstantesFunciones.IDEMPRESA)) {sLabelColumna=ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ParametroTesoreriaDefectoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(ParametroTesoreriaDefectoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {sLabelColumna=ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL;}
		
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
	
	
	
			
			
			
			
			
	
	public static String getParametroTesoreriaDefectoDescripcion(ParametroTesoreriaDefecto parametrotesoreriadefecto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(parametrotesoreriadefecto !=null/* && parametrotesoreriadefecto.getId()!=0*/) {
			if(parametrotesoreriadefecto.getId()!=null) {
				sDescripcion=parametrotesoreriadefecto.getId().toString();
			}//parametrotesoreriadefectoparametrotesoreriadefecto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getParametroTesoreriaDefectoDescripcionDetallado(ParametroTesoreriaDefecto parametrotesoreriadefecto) {
		String sDescripcion="";
			
		sDescripcion+=ParametroTesoreriaDefectoConstantesFunciones.ID+"=";
		sDescripcion+=parametrotesoreriadefecto.getId().toString()+",";
		sDescripcion+=ParametroTesoreriaDefectoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=parametrotesoreriadefecto.getVersionRow().toString()+",";
		sDescripcion+=ParametroTesoreriaDefectoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=parametrotesoreriadefecto.getid_empresa().toString()+",";
		sDescripcion+=ParametroTesoreriaDefectoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=parametrotesoreriadefecto.getid_sucursal().toString()+",";
		sDescripcion+=ParametroTesoreriaDefectoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL+"=";
		sDescripcion+=parametrotesoreriadefecto.getid_tipo_cuenta_banco_global().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setParametroTesoreriaDefectoDescripcion(ParametroTesoreriaDefecto parametrotesoreriadefecto,String sValor) throws Exception {			
		if(parametrotesoreriadefecto !=null) {
			//parametrotesoreriadefectoparametrotesoreriadefecto.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getTipoCuentaBancoGlobalDescripcion(TipoCuentaBancoGlobal tipocuentabancoglobal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipocuentabancoglobal!=null/*&&tipocuentabancoglobal.getId()>0*/) {
			sDescripcion=TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(tipocuentabancoglobal);
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
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoCuentaBancoGlobal")) {
			sNombreIndice="Tipo=  Por Tipo Cuenta";
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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoCuentaBancoGlobal(Long id_tipo_cuenta_banco_global) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_cuenta_banco_global!=null) {sDetalleIndice+=" Codigo Unico De Tipo Cuenta="+id_tipo_cuenta_banco_global.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosParametroTesoreriaDefecto(ParametroTesoreriaDefecto parametrotesoreriadefecto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosParametroTesoreriaDefectos(List<ParametroTesoreriaDefecto> parametrotesoreriadefectos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ParametroTesoreriaDefecto parametrotesoreriadefecto: parametrotesoreriadefectos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroTesoreriaDefecto(ParametroTesoreriaDefecto parametrotesoreriadefecto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && parametrotesoreriadefecto.getConCambioAuxiliar()) {
			parametrotesoreriadefecto.setIsDeleted(parametrotesoreriadefecto.getIsDeletedAuxiliar());	
			parametrotesoreriadefecto.setIsNew(parametrotesoreriadefecto.getIsNewAuxiliar());	
			parametrotesoreriadefecto.setIsChanged(parametrotesoreriadefecto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			parametrotesoreriadefecto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			parametrotesoreriadefecto.setIsDeletedAuxiliar(false);	
			parametrotesoreriadefecto.setIsNewAuxiliar(false);	
			parametrotesoreriadefecto.setIsChangedAuxiliar(false);
			
			parametrotesoreriadefecto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresParametroTesoreriaDefectos(List<ParametroTesoreriaDefecto> parametrotesoreriadefectos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ParametroTesoreriaDefecto parametrotesoreriadefecto : parametrotesoreriadefectos) {
			if(conAsignarBase && parametrotesoreriadefecto.getConCambioAuxiliar()) {
				parametrotesoreriadefecto.setIsDeleted(parametrotesoreriadefecto.getIsDeletedAuxiliar());	
				parametrotesoreriadefecto.setIsNew(parametrotesoreriadefecto.getIsNewAuxiliar());	
				parametrotesoreriadefecto.setIsChanged(parametrotesoreriadefecto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				parametrotesoreriadefecto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				parametrotesoreriadefecto.setIsDeletedAuxiliar(false);	
				parametrotesoreriadefecto.setIsNewAuxiliar(false);	
				parametrotesoreriadefecto.setIsChangedAuxiliar(false);
				
				parametrotesoreriadefecto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresParametroTesoreriaDefecto(ParametroTesoreriaDefecto parametrotesoreriadefecto,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresParametroTesoreriaDefectos(List<ParametroTesoreriaDefecto> parametrotesoreriadefectos,Boolean conEnteros) throws Exception  {
		
		for(ParametroTesoreriaDefecto parametrotesoreriadefecto: parametrotesoreriadefectos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaParametroTesoreriaDefecto(List<ParametroTesoreriaDefecto> parametrotesoreriadefectos,ParametroTesoreriaDefecto parametrotesoreriadefectoAux) throws Exception  {
		ParametroTesoreriaDefectoConstantesFunciones.InicializarValoresParametroTesoreriaDefecto(parametrotesoreriadefectoAux,true);
		
		for(ParametroTesoreriaDefecto parametrotesoreriadefecto: parametrotesoreriadefectos) {
			if(parametrotesoreriadefecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroTesoreriaDefecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ParametroTesoreriaDefectoConstantesFunciones.getArrayColumnasGlobalesParametroTesoreriaDefecto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesParametroTesoreriaDefecto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroTesoreriaDefectoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroTesoreriaDefectoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ParametroTesoreriaDefectoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ParametroTesoreriaDefectoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoParametroTesoreriaDefecto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ParametroTesoreriaDefecto> parametrotesoreriadefectos,ParametroTesoreriaDefecto parametrotesoreriadefecto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ParametroTesoreriaDefecto parametrotesoreriadefectoAux: parametrotesoreriadefectos) {
			if(parametrotesoreriadefectoAux!=null && parametrotesoreriadefecto!=null) {
				if((parametrotesoreriadefectoAux.getId()==null && parametrotesoreriadefecto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(parametrotesoreriadefectoAux.getId()!=null && parametrotesoreriadefecto.getId()!=null){
					if(parametrotesoreriadefectoAux.getId().equals(parametrotesoreriadefecto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaParametroTesoreriaDefecto(List<ParametroTesoreriaDefecto> parametrotesoreriadefectos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(ParametroTesoreriaDefecto parametrotesoreriadefecto: parametrotesoreriadefectos) {			
			if(parametrotesoreriadefecto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaParametroTesoreriaDefecto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ParametroTesoreriaDefectoConstantesFunciones.LABEL_ID, ParametroTesoreriaDefectoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaDefectoConstantesFunciones.LABEL_VERSIONROW, ParametroTesoreriaDefectoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDEMPRESA, ParametroTesoreriaDefectoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDSUCURSAL, ParametroTesoreriaDefectoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL, ParametroTesoreriaDefectoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasParametroTesoreriaDefecto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaDefectoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaDefectoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaDefectoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaDefectoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ParametroTesoreriaDefectoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroTesoreriaDefecto() throws Exception  {
		return ParametroTesoreriaDefectoConstantesFunciones.getTiposSeleccionarParametroTesoreriaDefecto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroTesoreriaDefecto(Boolean conFk) throws Exception  {
		return ParametroTesoreriaDefectoConstantesFunciones.getTiposSeleccionarParametroTesoreriaDefecto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarParametroTesoreriaDefecto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);
			reporte.setsDescripcion(ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesParametroTesoreriaDefecto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(ParametroTesoreriaDefecto parametrotesoreriadefectoAux) throws Exception {
		
			parametrotesoreriadefectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrotesoreriadefectoAux.getEmpresa()));
			parametrotesoreriadefectoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrotesoreriadefectoAux.getSucursal()));
			parametrotesoreriadefectoAux.settipocuentabancoglobal_descripcion(TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(parametrotesoreriadefectoAux.getTipoCuentaBancoGlobal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesParametroTesoreriaDefecto(List<ParametroTesoreriaDefecto> parametrotesoreriadefectosTemp) throws Exception {
		for(ParametroTesoreriaDefecto parametrotesoreriadefectoAux:parametrotesoreriadefectosTemp) {
			
			parametrotesoreriadefectoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(parametrotesoreriadefectoAux.getEmpresa()));
			parametrotesoreriadefectoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(parametrotesoreriadefectoAux.getSucursal()));
			parametrotesoreriadefectoAux.settipocuentabancoglobal_descripcion(TipoCuentaBancoGlobalConstantesFunciones.getTipoCuentaBancoGlobalDescripcion(parametrotesoreriadefectoAux.getTipoCuentaBancoGlobal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfParametroTesoreriaDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(TipoCuentaBancoGlobal.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoCuentaBancoGlobal.class)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfParametroTesoreriaDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(TipoCuentaBancoGlobal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoCuentaBancoGlobal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroTesoreriaDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroTesoreriaDefectoConstantesFunciones.getClassesRelationshipsOfParametroTesoreriaDefecto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfParametroTesoreriaDefecto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroTesoreriaDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ParametroTesoreriaDefectoConstantesFunciones.getClassesRelationshipsFromStringsOfParametroTesoreriaDefecto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfParametroTesoreriaDefecto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ParametroTesoreriaDefecto parametrotesoreriadefecto,List<ParametroTesoreriaDefecto> parametrotesoreriadefectos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			ParametroTesoreriaDefecto parametrotesoreriadefectoEncontrado=null;
			
			for(ParametroTesoreriaDefecto parametrotesoreriadefectoLocal:parametrotesoreriadefectos) {
				if(parametrotesoreriadefectoLocal.getId().equals(parametrotesoreriadefecto.getId())) {
					parametrotesoreriadefectoEncontrado=parametrotesoreriadefectoLocal;
					
					parametrotesoreriadefectoLocal.setIsChanged(parametrotesoreriadefecto.getIsChanged());
					parametrotesoreriadefectoLocal.setIsNew(parametrotesoreriadefecto.getIsNew());
					parametrotesoreriadefectoLocal.setIsDeleted(parametrotesoreriadefecto.getIsDeleted());
					
					parametrotesoreriadefectoLocal.setGeneralEntityOriginal(parametrotesoreriadefecto.getGeneralEntityOriginal());
					
					parametrotesoreriadefectoLocal.setId(parametrotesoreriadefecto.getId());	
					parametrotesoreriadefectoLocal.setVersionRow(parametrotesoreriadefecto.getVersionRow());	
					parametrotesoreriadefectoLocal.setid_empresa(parametrotesoreriadefecto.getid_empresa());	
					parametrotesoreriadefectoLocal.setid_sucursal(parametrotesoreriadefecto.getid_sucursal());	
					parametrotesoreriadefectoLocal.setid_tipo_cuenta_banco_global(parametrotesoreriadefecto.getid_tipo_cuenta_banco_global());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!parametrotesoreriadefecto.getIsDeleted()) {
				if(!existe) {
					parametrotesoreriadefectos.add(parametrotesoreriadefecto);
				}
			} else {
				if(parametrotesoreriadefectoEncontrado!=null && permiteQuitar)  {
					parametrotesoreriadefectos.remove(parametrotesoreriadefectoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(ParametroTesoreriaDefecto parametrotesoreriadefecto,List<ParametroTesoreriaDefecto> parametrotesoreriadefectos) throws Exception {
		try	{			
			for(ParametroTesoreriaDefecto parametrotesoreriadefectoLocal:parametrotesoreriadefectos) {
				if(parametrotesoreriadefectoLocal.getId().equals(parametrotesoreriadefecto.getId())) {
					parametrotesoreriadefectoLocal.setIsSelected(parametrotesoreriadefecto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesParametroTesoreriaDefecto(List<ParametroTesoreriaDefecto> parametrotesoreriadefectosAux) throws Exception {
		//this.parametrotesoreriadefectosAux=parametrotesoreriadefectosAux;
		
		for(ParametroTesoreriaDefecto parametrotesoreriadefectoAux:parametrotesoreriadefectosAux) {
			if(parametrotesoreriadefectoAux.getIsChanged()) {
				parametrotesoreriadefectoAux.setIsChanged(false);
			}		
			
			if(parametrotesoreriadefectoAux.getIsNew()) {
				parametrotesoreriadefectoAux.setIsNew(false);
			}	
			
			if(parametrotesoreriadefectoAux.getIsDeleted()) {
				parametrotesoreriadefectoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesParametroTesoreriaDefecto(ParametroTesoreriaDefecto parametrotesoreriadefectoAux) throws Exception {
		//this.parametrotesoreriadefectoAux=parametrotesoreriadefectoAux;
		
			if(parametrotesoreriadefectoAux.getIsChanged()) {
				parametrotesoreriadefectoAux.setIsChanged(false);
			}		
			
			if(parametrotesoreriadefectoAux.getIsNew()) {
				parametrotesoreriadefectoAux.setIsNew(false);
			}	
			
			if(parametrotesoreriadefectoAux.getIsDeleted()) {
				parametrotesoreriadefectoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ParametroTesoreriaDefecto parametrotesoreriadefectoAsignar,ParametroTesoreriaDefecto parametrotesoreriadefecto) throws Exception {
		parametrotesoreriadefectoAsignar.setId(parametrotesoreriadefecto.getId());	
		parametrotesoreriadefectoAsignar.setVersionRow(parametrotesoreriadefecto.getVersionRow());	
		parametrotesoreriadefectoAsignar.setid_empresa(parametrotesoreriadefecto.getid_empresa());
		parametrotesoreriadefectoAsignar.setempresa_descripcion(parametrotesoreriadefecto.getempresa_descripcion());	
		parametrotesoreriadefectoAsignar.setid_sucursal(parametrotesoreriadefecto.getid_sucursal());
		parametrotesoreriadefectoAsignar.setsucursal_descripcion(parametrotesoreriadefecto.getsucursal_descripcion());	
		parametrotesoreriadefectoAsignar.setid_tipo_cuenta_banco_global(parametrotesoreriadefecto.getid_tipo_cuenta_banco_global());
		parametrotesoreriadefectoAsignar.settipocuentabancoglobal_descripcion(parametrotesoreriadefecto.gettipocuentabancoglobal_descripcion());	
	}
	
	public static void inicializarParametroTesoreriaDefecto(ParametroTesoreriaDefecto parametrotesoreriadefecto) throws Exception {
		try {
				parametrotesoreriadefecto.setId(0L);	
					
				parametrotesoreriadefecto.setid_empresa(-1L);	
				parametrotesoreriadefecto.setid_sucursal(-1L);	
				parametrotesoreriadefecto.setid_tipo_cuenta_banco_global(-1L);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderParametroTesoreriaDefecto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ParametroTesoreriaDefectoConstantesFunciones.LABEL_IDTIPOCUENTABANCOGLOBAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataParametroTesoreriaDefecto(String sTipo,Row row,Workbook workbook,ParametroTesoreriaDefecto parametrotesoreriadefecto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrotesoreriadefecto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrotesoreriadefecto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(parametrotesoreriadefecto.gettipocuentabancoglobal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryParametroTesoreriaDefecto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryParametroTesoreriaDefecto() {
		return this.sFinalQueryParametroTesoreriaDefecto;
	}
	
	public void setsFinalQueryParametroTesoreriaDefecto(String sFinalQueryParametroTesoreriaDefecto) {
		this.sFinalQueryParametroTesoreriaDefecto= sFinalQueryParametroTesoreriaDefecto;
	}
	
	public Border resaltarSeleccionarParametroTesoreriaDefecto=null;
	
	public Border setResaltarSeleccionarParametroTesoreriaDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaDefectoBeanSwingJInternalFrame parametrotesoreriadefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//parametrotesoreriadefectoBeanSwingJInternalFrame.jTtoolBarParametroTesoreriaDefecto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarParametroTesoreriaDefecto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarParametroTesoreriaDefecto() {
		return this.resaltarSeleccionarParametroTesoreriaDefecto;
	}
	
	public void setResaltarSeleccionarParametroTesoreriaDefecto(Border borderResaltarSeleccionarParametroTesoreriaDefecto) {
		this.resaltarSeleccionarParametroTesoreriaDefecto= borderResaltarSeleccionarParametroTesoreriaDefecto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridParametroTesoreriaDefecto=null;
	public Boolean mostraridParametroTesoreriaDefecto=true;
	public Boolean activaridParametroTesoreriaDefecto=true;

	public Border resaltarid_empresaParametroTesoreriaDefecto=null;
	public Boolean mostrarid_empresaParametroTesoreriaDefecto=true;
	public Boolean activarid_empresaParametroTesoreriaDefecto=true;
	public Boolean cargarid_empresaParametroTesoreriaDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaParametroTesoreriaDefecto=false;//ConEventDepend=true

	public Border resaltarid_sucursalParametroTesoreriaDefecto=null;
	public Boolean mostrarid_sucursalParametroTesoreriaDefecto=true;
	public Boolean activarid_sucursalParametroTesoreriaDefecto=true;
	public Boolean cargarid_sucursalParametroTesoreriaDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalParametroTesoreriaDefecto=false;//ConEventDepend=true

	public Border resaltarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto=null;
	public Boolean mostrarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto=true;
	public Boolean activarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto=true;
	public Boolean cargarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_cuenta_banco_globalParametroTesoreriaDefecto=false;//ConEventDepend=true

	
	

	public Border setResaltaridParametroTesoreriaDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaDefectoBeanSwingJInternalFrame parametrotesoreriadefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriadefectoBeanSwingJInternalFrame.jTtoolBarParametroTesoreriaDefecto.setBorder(borderResaltar);
		
		this.resaltaridParametroTesoreriaDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridParametroTesoreriaDefecto() {
		return this.resaltaridParametroTesoreriaDefecto;
	}

	public void setResaltaridParametroTesoreriaDefecto(Border borderResaltar) {
		this.resaltaridParametroTesoreriaDefecto= borderResaltar;
	}

	public Boolean getMostraridParametroTesoreriaDefecto() {
		return this.mostraridParametroTesoreriaDefecto;
	}

	public void setMostraridParametroTesoreriaDefecto(Boolean mostraridParametroTesoreriaDefecto) {
		this.mostraridParametroTesoreriaDefecto= mostraridParametroTesoreriaDefecto;
	}

	public Boolean getActivaridParametroTesoreriaDefecto() {
		return this.activaridParametroTesoreriaDefecto;
	}

	public void setActivaridParametroTesoreriaDefecto(Boolean activaridParametroTesoreriaDefecto) {
		this.activaridParametroTesoreriaDefecto= activaridParametroTesoreriaDefecto;
	}

	public Border setResaltarid_empresaParametroTesoreriaDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaDefectoBeanSwingJInternalFrame parametrotesoreriadefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriadefectoBeanSwingJInternalFrame.jTtoolBarParametroTesoreriaDefecto.setBorder(borderResaltar);
		
		this.resaltarid_empresaParametroTesoreriaDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaParametroTesoreriaDefecto() {
		return this.resaltarid_empresaParametroTesoreriaDefecto;
	}

	public void setResaltarid_empresaParametroTesoreriaDefecto(Border borderResaltar) {
		this.resaltarid_empresaParametroTesoreriaDefecto= borderResaltar;
	}

	public Boolean getMostrarid_empresaParametroTesoreriaDefecto() {
		return this.mostrarid_empresaParametroTesoreriaDefecto;
	}

	public void setMostrarid_empresaParametroTesoreriaDefecto(Boolean mostrarid_empresaParametroTesoreriaDefecto) {
		this.mostrarid_empresaParametroTesoreriaDefecto= mostrarid_empresaParametroTesoreriaDefecto;
	}

	public Boolean getActivarid_empresaParametroTesoreriaDefecto() {
		return this.activarid_empresaParametroTesoreriaDefecto;
	}

	public void setActivarid_empresaParametroTesoreriaDefecto(Boolean activarid_empresaParametroTesoreriaDefecto) {
		this.activarid_empresaParametroTesoreriaDefecto= activarid_empresaParametroTesoreriaDefecto;
	}

	public Boolean getCargarid_empresaParametroTesoreriaDefecto() {
		return this.cargarid_empresaParametroTesoreriaDefecto;
	}

	public void setCargarid_empresaParametroTesoreriaDefecto(Boolean cargarid_empresaParametroTesoreriaDefecto) {
		this.cargarid_empresaParametroTesoreriaDefecto= cargarid_empresaParametroTesoreriaDefecto;
	}

	public Border setResaltarid_sucursalParametroTesoreriaDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaDefectoBeanSwingJInternalFrame parametrotesoreriadefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriadefectoBeanSwingJInternalFrame.jTtoolBarParametroTesoreriaDefecto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalParametroTesoreriaDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalParametroTesoreriaDefecto() {
		return this.resaltarid_sucursalParametroTesoreriaDefecto;
	}

	public void setResaltarid_sucursalParametroTesoreriaDefecto(Border borderResaltar) {
		this.resaltarid_sucursalParametroTesoreriaDefecto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalParametroTesoreriaDefecto() {
		return this.mostrarid_sucursalParametroTesoreriaDefecto;
	}

	public void setMostrarid_sucursalParametroTesoreriaDefecto(Boolean mostrarid_sucursalParametroTesoreriaDefecto) {
		this.mostrarid_sucursalParametroTesoreriaDefecto= mostrarid_sucursalParametroTesoreriaDefecto;
	}

	public Boolean getActivarid_sucursalParametroTesoreriaDefecto() {
		return this.activarid_sucursalParametroTesoreriaDefecto;
	}

	public void setActivarid_sucursalParametroTesoreriaDefecto(Boolean activarid_sucursalParametroTesoreriaDefecto) {
		this.activarid_sucursalParametroTesoreriaDefecto= activarid_sucursalParametroTesoreriaDefecto;
	}

	public Boolean getCargarid_sucursalParametroTesoreriaDefecto() {
		return this.cargarid_sucursalParametroTesoreriaDefecto;
	}

	public void setCargarid_sucursalParametroTesoreriaDefecto(Boolean cargarid_sucursalParametroTesoreriaDefecto) {
		this.cargarid_sucursalParametroTesoreriaDefecto= cargarid_sucursalParametroTesoreriaDefecto;
	}

	public Border setResaltarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaDefectoBeanSwingJInternalFrame parametrotesoreriadefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//parametrotesoreriadefectoBeanSwingJInternalFrame.jTtoolBarParametroTesoreriaDefecto.setBorder(borderResaltar);
		
		this.resaltarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto() {
		return this.resaltarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto;
	}

	public void setResaltarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto(Border borderResaltar) {
		this.resaltarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto= borderResaltar;
	}

	public Boolean getMostrarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto() {
		return this.mostrarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto;
	}

	public void setMostrarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto(Boolean mostrarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto) {
		this.mostrarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto= mostrarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto;
	}

	public Boolean getActivarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto() {
		return this.activarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto;
	}

	public void setActivarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto(Boolean activarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto) {
		this.activarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto= activarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto;
	}

	public Boolean getCargarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto() {
		return this.cargarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto;
	}

	public void setCargarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto(Boolean cargarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto) {
		this.cargarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto= cargarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto;
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
		
		
		this.setMostraridParametroTesoreriaDefecto(esInicial);
		this.setMostrarid_empresaParametroTesoreriaDefecto(esInicial);
		this.setMostrarid_sucursalParametroTesoreriaDefecto(esInicial);
		this.setMostrarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroTesoreriaDefectoConstantesFunciones.ID)) {
				this.setMostraridParametroTesoreriaDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaDefectoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaParametroTesoreriaDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalParametroTesoreriaDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaDefectoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setMostrarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto(esAsigna);
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
		
		
		this.setActivaridParametroTesoreriaDefecto(esInicial);
		this.setActivarid_empresaParametroTesoreriaDefecto(esInicial);
		this.setActivarid_sucursalParametroTesoreriaDefecto(esInicial);
		this.setActivarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroTesoreriaDefectoConstantesFunciones.ID)) {
				this.setActivaridParametroTesoreriaDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaDefectoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaParametroTesoreriaDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalParametroTesoreriaDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaDefectoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setActivarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroTesoreriaDefectoBeanSwingJInternalFrame parametrotesoreriadefectoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridParametroTesoreriaDefecto(esInicial);
		this.setResaltarid_empresaParametroTesoreriaDefecto(esInicial);
		this.setResaltarid_sucursalParametroTesoreriaDefecto(esInicial);
		this.setResaltarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ParametroTesoreriaDefectoConstantesFunciones.ID)) {
				this.setResaltaridParametroTesoreriaDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaDefectoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaParametroTesoreriaDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaDefectoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalParametroTesoreriaDefecto(esAsigna);
				continue;
			}

			if(campo.clase.equals(ParametroTesoreriaDefectoConstantesFunciones.IDTIPOCUENTABANCOGLOBAL)) {
				this.setResaltarid_tipo_cuenta_banco_globalParametroTesoreriaDefecto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ParametroTesoreriaDefectoBeanSwingJInternalFrame parametrotesoreriadefectoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdEmpresaParametroTesoreriaDefecto=true;

	public Boolean getMostrarFK_IdEmpresaParametroTesoreriaDefecto() {
		return this.mostrarFK_IdEmpresaParametroTesoreriaDefecto;
	}

	public void setMostrarFK_IdEmpresaParametroTesoreriaDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaParametroTesoreriaDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalParametroTesoreriaDefecto=true;

	public Boolean getMostrarFK_IdSucursalParametroTesoreriaDefecto() {
		return this.mostrarFK_IdSucursalParametroTesoreriaDefecto;
	}

	public void setMostrarFK_IdSucursalParametroTesoreriaDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalParametroTesoreriaDefecto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto=true;

	public Boolean getMostrarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto() {
		return this.mostrarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto;
	}

	public void setMostrarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEmpresaParametroTesoreriaDefecto=true;

	public Boolean getActivarFK_IdEmpresaParametroTesoreriaDefecto() {
		return this.activarFK_IdEmpresaParametroTesoreriaDefecto;
	}

	public void setActivarFK_IdEmpresaParametroTesoreriaDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaParametroTesoreriaDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalParametroTesoreriaDefecto=true;

	public Boolean getActivarFK_IdSucursalParametroTesoreriaDefecto() {
		return this.activarFK_IdSucursalParametroTesoreriaDefecto;
	}

	public void setActivarFK_IdSucursalParametroTesoreriaDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalParametroTesoreriaDefecto= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto=true;

	public Boolean getActivarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto() {
		return this.activarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto;
	}

	public void setActivarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto(Boolean habilitarResaltar) {
		this.activarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEmpresaParametroTesoreriaDefecto=null;

	public Border getResaltarFK_IdEmpresaParametroTesoreriaDefecto() {
		return this.resaltarFK_IdEmpresaParametroTesoreriaDefecto;
	}

	public void setResaltarFK_IdEmpresaParametroTesoreriaDefecto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaParametroTesoreriaDefecto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaParametroTesoreriaDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaDefectoBeanSwingJInternalFrame parametrotesoreriadefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaParametroTesoreriaDefecto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalParametroTesoreriaDefecto=null;

	public Border getResaltarFK_IdSucursalParametroTesoreriaDefecto() {
		return this.resaltarFK_IdSucursalParametroTesoreriaDefecto;
	}

	public void setResaltarFK_IdSucursalParametroTesoreriaDefecto(Border borderResaltar) {
		this.resaltarFK_IdSucursalParametroTesoreriaDefecto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalParametroTesoreriaDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaDefectoBeanSwingJInternalFrame parametrotesoreriadefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalParametroTesoreriaDefecto= borderResaltar;
	}

	public Border resaltarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto=null;

	public Border getResaltarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto() {
		return this.resaltarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto;
	}

	public void setResaltarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto(Border borderResaltar) {
		this.resaltarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto= borderResaltar;
	}

	public void setResaltarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto(ParametroGeneralUsuario parametroGeneralUsuario/*ParametroTesoreriaDefectoBeanSwingJInternalFrame parametrotesoreriadefectoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoCuentaBancoGlobalParametroTesoreriaDefecto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}