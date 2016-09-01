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
package com.bydan.erp.puntoventa.util;

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


import com.bydan.erp.puntoventa.util.CajaIngresoConstantesFunciones;
import com.bydan.erp.puntoventa.util.CajaIngresoParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CajaIngresoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CajaIngresoConstantesFunciones extends CajaIngresoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="CajaIngreso";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CajaIngreso"+CajaIngresoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CajaIngresoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CajaIngresoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CajaIngresoConstantesFunciones.SCHEMA+"_"+CajaIngresoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CajaIngresoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CajaIngresoConstantesFunciones.SCHEMA+"_"+CajaIngresoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CajaIngresoConstantesFunciones.SCHEMA+"_"+CajaIngresoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CajaIngresoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CajaIngresoConstantesFunciones.SCHEMA+"_"+CajaIngresoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaIngresoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaIngresoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaIngresoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaIngresoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CajaIngresoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CajaIngresoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CajaIngresoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CajaIngresoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CajaIngresoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CajaIngresoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Caja Ingresos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Caja Ingreso";
	public static final String SCLASSWEBTITULO_LOWER="Caja Ingreso";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CajaIngreso";
	public static final String OBJECTNAME="cajaingreso";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="caja_ingreso";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cajaingreso from "+CajaIngresoConstantesFunciones.SPERSISTENCENAME+" cajaingreso";
	public static String QUERYSELECTNATIVE="select "+CajaIngresoConstantesFunciones.SCHEMA+"."+CajaIngresoConstantesFunciones.TABLENAME+".id,"+CajaIngresoConstantesFunciones.SCHEMA+"."+CajaIngresoConstantesFunciones.TABLENAME+".version_row,"+CajaIngresoConstantesFunciones.SCHEMA+"."+CajaIngresoConstantesFunciones.TABLENAME+".id_empresa,"+CajaIngresoConstantesFunciones.SCHEMA+"."+CajaIngresoConstantesFunciones.TABLENAME+".id_sucursal,"+CajaIngresoConstantesFunciones.SCHEMA+"."+CajaIngresoConstantesFunciones.TABLENAME+".id_usuario,"+CajaIngresoConstantesFunciones.SCHEMA+"."+CajaIngresoConstantesFunciones.TABLENAME+".id_caja,"+CajaIngresoConstantesFunciones.SCHEMA+"."+CajaIngresoConstantesFunciones.TABLENAME+".id_turno_pun_ven,"+CajaIngresoConstantesFunciones.SCHEMA+"."+CajaIngresoConstantesFunciones.TABLENAME+".secuencial,"+CajaIngresoConstantesFunciones.SCHEMA+"."+CajaIngresoConstantesFunciones.TABLENAME+".fecha,"+CajaIngresoConstantesFunciones.SCHEMA+"."+CajaIngresoConstantesFunciones.TABLENAME+".hora from "+CajaIngresoConstantesFunciones.SCHEMA+"."+CajaIngresoConstantesFunciones.TABLENAME;//+" as "+CajaIngresoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected CajaIngresoConstantesFuncionesAdditional cajaingresoConstantesFuncionesAdditional=null;
	
	public CajaIngresoConstantesFuncionesAdditional getCajaIngresoConstantesFuncionesAdditional() {
		return this.cajaingresoConstantesFuncionesAdditional;
	}
	
	public void setCajaIngresoConstantesFuncionesAdditional(CajaIngresoConstantesFuncionesAdditional cajaingresoConstantesFuncionesAdditional) {
		try {
			this.cajaingresoConstantesFuncionesAdditional=cajaingresoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDCAJA= "id_caja";
    public static final String IDTURNOPUNVEN= "id_turno_pun_ven";
    public static final String SECUENCIAL= "secuencial";
    public static final String FECHA= "fecha";
    public static final String HORA= "hora";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDCAJA= "Caja";
		public static final String LABEL_IDCAJA_LOWER= "Caja";
    	public static final String LABEL_IDTURNOPUNVEN= "Turno";
		public static final String LABEL_IDTURNOPUNVEN_LOWER= "Turno Pun Ven";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_HORA= "Hora";
		public static final String LABEL_HORA_LOWER= "Hora";
	
		
		
		
		
		
		
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getCajaIngresoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CajaIngresoConstantesFunciones.IDEMPRESA)) {sLabelColumna=CajaIngresoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CajaIngresoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CajaIngresoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CajaIngresoConstantesFunciones.IDUSUARIO)) {sLabelColumna=CajaIngresoConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(CajaIngresoConstantesFunciones.IDCAJA)) {sLabelColumna=CajaIngresoConstantesFunciones.LABEL_IDCAJA;}
		if(sNombreColumna.equals(CajaIngresoConstantesFunciones.IDTURNOPUNVEN)) {sLabelColumna=CajaIngresoConstantesFunciones.LABEL_IDTURNOPUNVEN;}
		if(sNombreColumna.equals(CajaIngresoConstantesFunciones.SECUENCIAL)) {sLabelColumna=CajaIngresoConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(CajaIngresoConstantesFunciones.FECHA)) {sLabelColumna=CajaIngresoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(CajaIngresoConstantesFunciones.HORA)) {sLabelColumna=CajaIngresoConstantesFunciones.LABEL_HORA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getCajaIngresoDescripcion(CajaIngreso cajaingreso) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cajaingreso !=null/* && cajaingreso.getId()!=0*/) {
			sDescripcion=cajaingreso.getsecuencial();//cajaingresocajaingreso.getsecuencial().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCajaIngresoDescripcionDetallado(CajaIngreso cajaingreso) {
		String sDescripcion="";
			
		sDescripcion+=CajaIngresoConstantesFunciones.ID+"=";
		sDescripcion+=cajaingreso.getId().toString()+",";
		sDescripcion+=CajaIngresoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cajaingreso.getVersionRow().toString()+",";
		sDescripcion+=CajaIngresoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cajaingreso.getid_empresa().toString()+",";
		sDescripcion+=CajaIngresoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cajaingreso.getid_sucursal().toString()+",";
		sDescripcion+=CajaIngresoConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=cajaingreso.getid_usuario().toString()+",";
		sDescripcion+=CajaIngresoConstantesFunciones.IDCAJA+"=";
		sDescripcion+=cajaingreso.getid_caja().toString()+",";
		sDescripcion+=CajaIngresoConstantesFunciones.IDTURNOPUNVEN+"=";
		sDescripcion+=cajaingreso.getid_turno_pun_ven().toString()+",";
		sDescripcion+=CajaIngresoConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=cajaingreso.getsecuencial()+",";
		sDescripcion+=CajaIngresoConstantesFunciones.FECHA+"=";
		sDescripcion+=cajaingreso.getfecha().toString()+",";
		sDescripcion+=CajaIngresoConstantesFunciones.HORA+"=";
		sDescripcion+=cajaingreso.gethora().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setCajaIngresoDescripcion(CajaIngreso cajaingreso,String sValor) throws Exception {			
		if(cajaingreso !=null) {
			cajaingreso.setsecuencial(sValor);;//cajaingresocajaingreso.getsecuencial().trim();
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getCajaDescripcion(Caja caja) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(caja!=null/*&&caja.getId()>0*/) {
			sDescripcion=CajaConstantesFunciones.getCajaDescripcion(caja);
		}

		return sDescripcion;
	}

	public static String getTurnoPunVenDescripcion(TurnoPunVen turnopunven) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(turnopunven!=null/*&&turnopunven.getId()>0*/) {
			sDescripcion=TurnoPunVenConstantesFunciones.getTurnoPunVenDescripcion(turnopunven);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCaja")) {
			sNombreIndice="Tipo=  Por Caja";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTurnoPunVen")) {
			sNombreIndice="Tipo=  Por Turno";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCaja(Long id_caja) {
		String sDetalleIndice=" Parametros->";
		if(id_caja!=null) {sDetalleIndice+=" Codigo Unico De Caja="+id_caja.toString();} 

		return sDetalleIndice;
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

	public static String getDetalleIndiceFK_IdTurnoPunVen(Long id_turno_pun_ven) {
		String sDetalleIndice=" Parametros->";
		if(id_turno_pun_ven!=null) {sDetalleIndice+=" Codigo Unico De Turno="+id_turno_pun_ven.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCajaIngreso(CajaIngreso cajaingreso,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cajaingreso.setsecuencial(cajaingreso.getsecuencial().trim());
	}
	
	public static void quitarEspaciosCajaIngresos(List<CajaIngreso> cajaingresos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CajaIngreso cajaingreso: cajaingresos) {
			cajaingreso.setsecuencial(cajaingreso.getsecuencial().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajaIngreso(CajaIngreso cajaingreso,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cajaingreso.getConCambioAuxiliar()) {
			cajaingreso.setIsDeleted(cajaingreso.getIsDeletedAuxiliar());	
			cajaingreso.setIsNew(cajaingreso.getIsNewAuxiliar());	
			cajaingreso.setIsChanged(cajaingreso.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cajaingreso.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cajaingreso.setIsDeletedAuxiliar(false);	
			cajaingreso.setIsNewAuxiliar(false);	
			cajaingreso.setIsChangedAuxiliar(false);
			
			cajaingreso.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCajaIngresos(List<CajaIngreso> cajaingresos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CajaIngreso cajaingreso : cajaingresos) {
			if(conAsignarBase && cajaingreso.getConCambioAuxiliar()) {
				cajaingreso.setIsDeleted(cajaingreso.getIsDeletedAuxiliar());	
				cajaingreso.setIsNew(cajaingreso.getIsNewAuxiliar());	
				cajaingreso.setIsChanged(cajaingreso.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cajaingreso.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cajaingreso.setIsDeletedAuxiliar(false);	
				cajaingreso.setIsNewAuxiliar(false);	
				cajaingreso.setIsChangedAuxiliar(false);
				
				cajaingreso.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCajaIngreso(CajaIngreso cajaingreso,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCajaIngresos(List<CajaIngreso> cajaingresos,Boolean conEnteros) throws Exception  {
		
		for(CajaIngreso cajaingreso: cajaingresos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCajaIngreso(List<CajaIngreso> cajaingresos,CajaIngreso cajaingresoAux) throws Exception  {
		CajaIngresoConstantesFunciones.InicializarValoresCajaIngreso(cajaingresoAux,true);
		
		for(CajaIngreso cajaingreso: cajaingresos) {
			if(cajaingreso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaIngreso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CajaIngresoConstantesFunciones.getArrayColumnasGlobalesCajaIngreso(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCajaIngreso(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaIngresoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaIngresoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaIngresoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaIngresoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CajaIngresoConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CajaIngresoConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCajaIngreso(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CajaIngreso> cajaingresos,CajaIngreso cajaingreso,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CajaIngreso cajaingresoAux: cajaingresos) {
			if(cajaingresoAux!=null && cajaingreso!=null) {
				if((cajaingresoAux.getId()==null && cajaingreso.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cajaingresoAux.getId()!=null && cajaingreso.getId()!=null){
					if(cajaingresoAux.getId().equals(cajaingreso.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCajaIngreso(List<CajaIngreso> cajaingresos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CajaIngreso cajaingreso: cajaingresos) {			
			if(cajaingreso.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCajaIngreso() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CajaIngresoConstantesFunciones.LABEL_ID, CajaIngresoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoConstantesFunciones.LABEL_VERSIONROW, CajaIngresoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoConstantesFunciones.LABEL_IDEMPRESA, CajaIngresoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoConstantesFunciones.LABEL_IDSUCURSAL, CajaIngresoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoConstantesFunciones.LABEL_IDUSUARIO, CajaIngresoConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoConstantesFunciones.LABEL_IDCAJA, CajaIngresoConstantesFunciones.IDCAJA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoConstantesFunciones.LABEL_IDTURNOPUNVEN, CajaIngresoConstantesFunciones.IDTURNOPUNVEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoConstantesFunciones.LABEL_SECUENCIAL, CajaIngresoConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoConstantesFunciones.LABEL_FECHA, CajaIngresoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CajaIngresoConstantesFunciones.LABEL_HORA, CajaIngresoConstantesFunciones.HORA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCajaIngreso() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoConstantesFunciones.IDCAJA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoConstantesFunciones.IDTURNOPUNVEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CajaIngresoConstantesFunciones.HORA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaIngreso() throws Exception  {
		return CajaIngresoConstantesFunciones.getTiposSeleccionarCajaIngreso(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaIngreso(Boolean conFk) throws Exception  {
		return CajaIngresoConstantesFunciones.getTiposSeleccionarCajaIngreso(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCajaIngreso(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaIngresoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CajaIngresoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaIngresoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CajaIngresoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaIngresoConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(CajaIngresoConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaIngresoConstantesFunciones.LABEL_IDCAJA);
			reporte.setsDescripcion(CajaIngresoConstantesFunciones.LABEL_IDCAJA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaIngresoConstantesFunciones.LABEL_IDTURNOPUNVEN);
			reporte.setsDescripcion(CajaIngresoConstantesFunciones.LABEL_IDTURNOPUNVEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaIngresoConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(CajaIngresoConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CajaIngresoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(CajaIngresoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		reporte=new Reporte();
		reporte.setsCodigo(CajaIngresoConstantesFunciones.LABEL_HORA);
		reporte.setsDescripcion(CajaIngresoConstantesFunciones.LABEL_HORA);

		arrTiposSeleccionarTodos.add(reporte);
		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCajaIngreso(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCajaIngreso(CajaIngreso cajaingresoAux) throws Exception {
		
			cajaingresoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajaingresoAux.getEmpresa()));
			cajaingresoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajaingresoAux.getSucursal()));
			cajaingresoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(cajaingresoAux.getUsuario()));
			cajaingresoAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(cajaingresoAux.getCaja()));
			cajaingresoAux.setturnopunven_descripcion(TurnoPunVenConstantesFunciones.getTurnoPunVenDescripcion(cajaingresoAux.getTurnoPunVen()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCajaIngreso(List<CajaIngreso> cajaingresosTemp) throws Exception {
		for(CajaIngreso cajaingresoAux:cajaingresosTemp) {
			
			cajaingresoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cajaingresoAux.getEmpresa()));
			cajaingresoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cajaingresoAux.getSucursal()));
			cajaingresoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(cajaingresoAux.getUsuario()));
			cajaingresoAux.setcaja_descripcion(CajaConstantesFunciones.getCajaDescripcion(cajaingresoAux.getCaja()));
			cajaingresoAux.setturnopunven_descripcion(TurnoPunVenConstantesFunciones.getTurnoPunVenDescripcion(cajaingresoAux.getTurnoPunVen()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCajaIngreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Caja.class));
				classes.add(new Classe(TurnoPunVen.class));
				
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
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Caja.class)) {
						classes.add(new Classe(Caja.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TurnoPunVen.class)) {
						classes.add(new Classe(TurnoPunVen.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCajaIngreso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(TurnoPunVen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TurnoPunVen.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Caja.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Caja.class)); continue;
					}

					if(TurnoPunVen.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TurnoPunVen.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaIngreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaIngresoConstantesFunciones.getClassesRelationshipsOfCajaIngreso(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaIngreso(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(CajaIngresoDetalle.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(CajaIngresoDetalle.class)) {
						classes.add(new Classe(CajaIngresoDetalle.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajaIngreso(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CajaIngresoConstantesFunciones.getClassesRelationshipsFromStringsOfCajaIngreso(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCajaIngreso(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(CajaIngresoDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaIngresoDetalle.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(CajaIngresoDetalle.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CajaIngresoDetalle.class)); continue;
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
	public static void actualizarLista(CajaIngreso cajaingreso,List<CajaIngreso> cajaingresos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			CajaIngreso cajaingresoEncontrado=null;
			
			for(CajaIngreso cajaingresoLocal:cajaingresos) {
				if(cajaingresoLocal.getId().equals(cajaingreso.getId())) {
					cajaingresoEncontrado=cajaingresoLocal;
					
					cajaingresoLocal.setIsChanged(cajaingreso.getIsChanged());
					cajaingresoLocal.setIsNew(cajaingreso.getIsNew());
					cajaingresoLocal.setIsDeleted(cajaingreso.getIsDeleted());
					
					cajaingresoLocal.setGeneralEntityOriginal(cajaingreso.getGeneralEntityOriginal());
					
					cajaingresoLocal.setId(cajaingreso.getId());	
					cajaingresoLocal.setVersionRow(cajaingreso.getVersionRow());	
					cajaingresoLocal.setid_empresa(cajaingreso.getid_empresa());	
					cajaingresoLocal.setid_sucursal(cajaingreso.getid_sucursal());	
					cajaingresoLocal.setid_usuario(cajaingreso.getid_usuario());	
					cajaingresoLocal.setid_caja(cajaingreso.getid_caja());	
					cajaingresoLocal.setid_turno_pun_ven(cajaingreso.getid_turno_pun_ven());	
					cajaingresoLocal.setsecuencial(cajaingreso.getsecuencial());	
					cajaingresoLocal.setfecha(cajaingreso.getfecha());	
					cajaingresoLocal.sethora(cajaingreso.gethora());	
					
					
					cajaingresoLocal.setCajaIngresoDetalles(cajaingreso.getCajaIngresoDetalles());
					
					existe=true;
					break;
				}
			}
			
			if(!cajaingreso.getIsDeleted()) {
				if(!existe) {
					cajaingresos.add(cajaingreso);
				}
			} else {
				if(cajaingresoEncontrado!=null && permiteQuitar)  {
					cajaingresos.remove(cajaingresoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(CajaIngreso cajaingreso,List<CajaIngreso> cajaingresos) throws Exception {
		try	{			
			for(CajaIngreso cajaingresoLocal:cajaingresos) {
				if(cajaingresoLocal.getId().equals(cajaingreso.getId())) {
					cajaingresoLocal.setIsSelected(cajaingreso.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCajaIngreso(List<CajaIngreso> cajaingresosAux) throws Exception {
		//this.cajaingresosAux=cajaingresosAux;
		
		for(CajaIngreso cajaingresoAux:cajaingresosAux) {
			if(cajaingresoAux.getIsChanged()) {
				cajaingresoAux.setIsChanged(false);
			}		
			
			if(cajaingresoAux.getIsNew()) {
				cajaingresoAux.setIsNew(false);
			}	
			
			if(cajaingresoAux.getIsDeleted()) {
				cajaingresoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCajaIngreso(CajaIngreso cajaingresoAux) throws Exception {
		//this.cajaingresoAux=cajaingresoAux;
		
			if(cajaingresoAux.getIsChanged()) {
				cajaingresoAux.setIsChanged(false);
			}		
			
			if(cajaingresoAux.getIsNew()) {
				cajaingresoAux.setIsNew(false);
			}	
			
			if(cajaingresoAux.getIsDeleted()) {
				cajaingresoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CajaIngreso cajaingresoAsignar,CajaIngreso cajaingreso) throws Exception {
		cajaingresoAsignar.setId(cajaingreso.getId());	
		cajaingresoAsignar.setVersionRow(cajaingreso.getVersionRow());	
		cajaingresoAsignar.setid_empresa(cajaingreso.getid_empresa());
		cajaingresoAsignar.setempresa_descripcion(cajaingreso.getempresa_descripcion());	
		cajaingresoAsignar.setid_sucursal(cajaingreso.getid_sucursal());
		cajaingresoAsignar.setsucursal_descripcion(cajaingreso.getsucursal_descripcion());	
		cajaingresoAsignar.setid_usuario(cajaingreso.getid_usuario());
		cajaingresoAsignar.setusuario_descripcion(cajaingreso.getusuario_descripcion());	
		cajaingresoAsignar.setid_caja(cajaingreso.getid_caja());
		cajaingresoAsignar.setcaja_descripcion(cajaingreso.getcaja_descripcion());	
		cajaingresoAsignar.setid_turno_pun_ven(cajaingreso.getid_turno_pun_ven());
		cajaingresoAsignar.setturnopunven_descripcion(cajaingreso.getturnopunven_descripcion());	
		cajaingresoAsignar.setsecuencial(cajaingreso.getsecuencial());	
		cajaingresoAsignar.setfecha(cajaingreso.getfecha());	
		cajaingresoAsignar.sethora(cajaingreso.gethora());	
	}
	
	public static void inicializarCajaIngreso(CajaIngreso cajaingreso) throws Exception {
		try {
				cajaingreso.setId(0L);	
					
				cajaingreso.setid_empresa(-1L);	
				cajaingreso.setid_sucursal(-1L);	
				cajaingreso.setid_usuario(-1L);	
				cajaingreso.setid_caja(-1L);	
				cajaingreso.setid_turno_pun_ven(-1L);	
				cajaingreso.setsecuencial("");	
				cajaingreso.setfecha(new Date());	
				cajaingreso.sethora(new Time((new Date()).getTime()));	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCajaIngreso(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoConstantesFunciones.LABEL_IDCAJA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoConstantesFunciones.LABEL_IDTURNOPUNVEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CajaIngresoConstantesFunciones.LABEL_HORA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCajaIngreso(String sTipo,Row row,Workbook workbook,CajaIngreso cajaingreso,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingreso.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingreso.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingreso.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingreso.getcaja_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingreso.getturnopunven_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingreso.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingreso.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cajaingreso.gethora());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCajaIngreso=Constantes.SFINALQUERY;
	
	public String getsFinalQueryCajaIngreso() {
		return this.sFinalQueryCajaIngreso;
	}
	
	public void setsFinalQueryCajaIngreso(String sFinalQueryCajaIngreso) {
		this.sFinalQueryCajaIngreso= sFinalQueryCajaIngreso;
	}
	
	public Border resaltarSeleccionarCajaIngreso=null;
	
	public Border setResaltarSeleccionarCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cajaingresoBeanSwingJInternalFrame.jTtoolBarCajaIngreso.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCajaIngreso= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCajaIngreso() {
		return this.resaltarSeleccionarCajaIngreso;
	}
	
	public void setResaltarSeleccionarCajaIngreso(Border borderResaltarSeleccionarCajaIngreso) {
		this.resaltarSeleccionarCajaIngreso= borderResaltarSeleccionarCajaIngreso;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCajaIngreso=null;
	public Boolean mostraridCajaIngreso=true;
	public Boolean activaridCajaIngreso=true;

	public Border resaltarid_empresaCajaIngreso=null;
	public Boolean mostrarid_empresaCajaIngreso=true;
	public Boolean activarid_empresaCajaIngreso=true;
	public Boolean cargarid_empresaCajaIngreso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCajaIngreso=false;//ConEventDepend=true

	public Border resaltarid_sucursalCajaIngreso=null;
	public Boolean mostrarid_sucursalCajaIngreso=true;
	public Boolean activarid_sucursalCajaIngreso=true;
	public Boolean cargarid_sucursalCajaIngreso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCajaIngreso=false;//ConEventDepend=true

	public Border resaltarid_usuarioCajaIngreso=null;
	public Boolean mostrarid_usuarioCajaIngreso=true;
	public Boolean activarid_usuarioCajaIngreso=true;
	public Boolean cargarid_usuarioCajaIngreso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioCajaIngreso=false;//ConEventDepend=true

	public Border resaltarid_cajaCajaIngreso=null;
	public Boolean mostrarid_cajaCajaIngreso=true;
	public Boolean activarid_cajaCajaIngreso=true;
	public Boolean cargarid_cajaCajaIngreso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cajaCajaIngreso=false;//ConEventDepend=true

	public Border resaltarid_turno_pun_venCajaIngreso=null;
	public Boolean mostrarid_turno_pun_venCajaIngreso=true;
	public Boolean activarid_turno_pun_venCajaIngreso=true;
	public Boolean cargarid_turno_pun_venCajaIngreso=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_turno_pun_venCajaIngreso=false;//ConEventDepend=true

	public Border resaltarsecuencialCajaIngreso=null;
	public Boolean mostrarsecuencialCajaIngreso=true;
	public Boolean activarsecuencialCajaIngreso=true;

	public Border resaltarfechaCajaIngreso=null;
	public Boolean mostrarfechaCajaIngreso=true;
	public Boolean activarfechaCajaIngreso=true;

	public Border resaltarhoraCajaIngreso=null;
	public Boolean mostrarhoraCajaIngreso=true;
	public Boolean activarhoraCajaIngreso=true;

	
	

	public Border setResaltaridCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresoBeanSwingJInternalFrame.jTtoolBarCajaIngreso.setBorder(borderResaltar);
		
		this.resaltaridCajaIngreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCajaIngreso() {
		return this.resaltaridCajaIngreso;
	}

	public void setResaltaridCajaIngreso(Border borderResaltar) {
		this.resaltaridCajaIngreso= borderResaltar;
	}

	public Boolean getMostraridCajaIngreso() {
		return this.mostraridCajaIngreso;
	}

	public void setMostraridCajaIngreso(Boolean mostraridCajaIngreso) {
		this.mostraridCajaIngreso= mostraridCajaIngreso;
	}

	public Boolean getActivaridCajaIngreso() {
		return this.activaridCajaIngreso;
	}

	public void setActivaridCajaIngreso(Boolean activaridCajaIngreso) {
		this.activaridCajaIngreso= activaridCajaIngreso;
	}

	public Border setResaltarid_empresaCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresoBeanSwingJInternalFrame.jTtoolBarCajaIngreso.setBorder(borderResaltar);
		
		this.resaltarid_empresaCajaIngreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCajaIngreso() {
		return this.resaltarid_empresaCajaIngreso;
	}

	public void setResaltarid_empresaCajaIngreso(Border borderResaltar) {
		this.resaltarid_empresaCajaIngreso= borderResaltar;
	}

	public Boolean getMostrarid_empresaCajaIngreso() {
		return this.mostrarid_empresaCajaIngreso;
	}

	public void setMostrarid_empresaCajaIngreso(Boolean mostrarid_empresaCajaIngreso) {
		this.mostrarid_empresaCajaIngreso= mostrarid_empresaCajaIngreso;
	}

	public Boolean getActivarid_empresaCajaIngreso() {
		return this.activarid_empresaCajaIngreso;
	}

	public void setActivarid_empresaCajaIngreso(Boolean activarid_empresaCajaIngreso) {
		this.activarid_empresaCajaIngreso= activarid_empresaCajaIngreso;
	}

	public Boolean getCargarid_empresaCajaIngreso() {
		return this.cargarid_empresaCajaIngreso;
	}

	public void setCargarid_empresaCajaIngreso(Boolean cargarid_empresaCajaIngreso) {
		this.cargarid_empresaCajaIngreso= cargarid_empresaCajaIngreso;
	}

	public Border setResaltarid_sucursalCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresoBeanSwingJInternalFrame.jTtoolBarCajaIngreso.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCajaIngreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCajaIngreso() {
		return this.resaltarid_sucursalCajaIngreso;
	}

	public void setResaltarid_sucursalCajaIngreso(Border borderResaltar) {
		this.resaltarid_sucursalCajaIngreso= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCajaIngreso() {
		return this.mostrarid_sucursalCajaIngreso;
	}

	public void setMostrarid_sucursalCajaIngreso(Boolean mostrarid_sucursalCajaIngreso) {
		this.mostrarid_sucursalCajaIngreso= mostrarid_sucursalCajaIngreso;
	}

	public Boolean getActivarid_sucursalCajaIngreso() {
		return this.activarid_sucursalCajaIngreso;
	}

	public void setActivarid_sucursalCajaIngreso(Boolean activarid_sucursalCajaIngreso) {
		this.activarid_sucursalCajaIngreso= activarid_sucursalCajaIngreso;
	}

	public Boolean getCargarid_sucursalCajaIngreso() {
		return this.cargarid_sucursalCajaIngreso;
	}

	public void setCargarid_sucursalCajaIngreso(Boolean cargarid_sucursalCajaIngreso) {
		this.cargarid_sucursalCajaIngreso= cargarid_sucursalCajaIngreso;
	}

	public Border setResaltarid_usuarioCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresoBeanSwingJInternalFrame.jTtoolBarCajaIngreso.setBorder(borderResaltar);
		
		this.resaltarid_usuarioCajaIngreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioCajaIngreso() {
		return this.resaltarid_usuarioCajaIngreso;
	}

	public void setResaltarid_usuarioCajaIngreso(Border borderResaltar) {
		this.resaltarid_usuarioCajaIngreso= borderResaltar;
	}

	public Boolean getMostrarid_usuarioCajaIngreso() {
		return this.mostrarid_usuarioCajaIngreso;
	}

	public void setMostrarid_usuarioCajaIngreso(Boolean mostrarid_usuarioCajaIngreso) {
		this.mostrarid_usuarioCajaIngreso= mostrarid_usuarioCajaIngreso;
	}

	public Boolean getActivarid_usuarioCajaIngreso() {
		return this.activarid_usuarioCajaIngreso;
	}

	public void setActivarid_usuarioCajaIngreso(Boolean activarid_usuarioCajaIngreso) {
		this.activarid_usuarioCajaIngreso= activarid_usuarioCajaIngreso;
	}

	public Boolean getCargarid_usuarioCajaIngreso() {
		return this.cargarid_usuarioCajaIngreso;
	}

	public void setCargarid_usuarioCajaIngreso(Boolean cargarid_usuarioCajaIngreso) {
		this.cargarid_usuarioCajaIngreso= cargarid_usuarioCajaIngreso;
	}

	public Border setResaltarid_cajaCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresoBeanSwingJInternalFrame.jTtoolBarCajaIngreso.setBorder(borderResaltar);
		
		this.resaltarid_cajaCajaIngreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cajaCajaIngreso() {
		return this.resaltarid_cajaCajaIngreso;
	}

	public void setResaltarid_cajaCajaIngreso(Border borderResaltar) {
		this.resaltarid_cajaCajaIngreso= borderResaltar;
	}

	public Boolean getMostrarid_cajaCajaIngreso() {
		return this.mostrarid_cajaCajaIngreso;
	}

	public void setMostrarid_cajaCajaIngreso(Boolean mostrarid_cajaCajaIngreso) {
		this.mostrarid_cajaCajaIngreso= mostrarid_cajaCajaIngreso;
	}

	public Boolean getActivarid_cajaCajaIngreso() {
		return this.activarid_cajaCajaIngreso;
	}

	public void setActivarid_cajaCajaIngreso(Boolean activarid_cajaCajaIngreso) {
		this.activarid_cajaCajaIngreso= activarid_cajaCajaIngreso;
	}

	public Boolean getCargarid_cajaCajaIngreso() {
		return this.cargarid_cajaCajaIngreso;
	}

	public void setCargarid_cajaCajaIngreso(Boolean cargarid_cajaCajaIngreso) {
		this.cargarid_cajaCajaIngreso= cargarid_cajaCajaIngreso;
	}

	public Border setResaltarid_turno_pun_venCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresoBeanSwingJInternalFrame.jTtoolBarCajaIngreso.setBorder(borderResaltar);
		
		this.resaltarid_turno_pun_venCajaIngreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_turno_pun_venCajaIngreso() {
		return this.resaltarid_turno_pun_venCajaIngreso;
	}

	public void setResaltarid_turno_pun_venCajaIngreso(Border borderResaltar) {
		this.resaltarid_turno_pun_venCajaIngreso= borderResaltar;
	}

	public Boolean getMostrarid_turno_pun_venCajaIngreso() {
		return this.mostrarid_turno_pun_venCajaIngreso;
	}

	public void setMostrarid_turno_pun_venCajaIngreso(Boolean mostrarid_turno_pun_venCajaIngreso) {
		this.mostrarid_turno_pun_venCajaIngreso= mostrarid_turno_pun_venCajaIngreso;
	}

	public Boolean getActivarid_turno_pun_venCajaIngreso() {
		return this.activarid_turno_pun_venCajaIngreso;
	}

	public void setActivarid_turno_pun_venCajaIngreso(Boolean activarid_turno_pun_venCajaIngreso) {
		this.activarid_turno_pun_venCajaIngreso= activarid_turno_pun_venCajaIngreso;
	}

	public Boolean getCargarid_turno_pun_venCajaIngreso() {
		return this.cargarid_turno_pun_venCajaIngreso;
	}

	public void setCargarid_turno_pun_venCajaIngreso(Boolean cargarid_turno_pun_venCajaIngreso) {
		this.cargarid_turno_pun_venCajaIngreso= cargarid_turno_pun_venCajaIngreso;
	}

	public Border setResaltarsecuencialCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresoBeanSwingJInternalFrame.jTtoolBarCajaIngreso.setBorder(borderResaltar);
		
		this.resaltarsecuencialCajaIngreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialCajaIngreso() {
		return this.resaltarsecuencialCajaIngreso;
	}

	public void setResaltarsecuencialCajaIngreso(Border borderResaltar) {
		this.resaltarsecuencialCajaIngreso= borderResaltar;
	}

	public Boolean getMostrarsecuencialCajaIngreso() {
		return this.mostrarsecuencialCajaIngreso;
	}

	public void setMostrarsecuencialCajaIngreso(Boolean mostrarsecuencialCajaIngreso) {
		this.mostrarsecuencialCajaIngreso= mostrarsecuencialCajaIngreso;
	}

	public Boolean getActivarsecuencialCajaIngreso() {
		return this.activarsecuencialCajaIngreso;
	}

	public void setActivarsecuencialCajaIngreso(Boolean activarsecuencialCajaIngreso) {
		this.activarsecuencialCajaIngreso= activarsecuencialCajaIngreso;
	}

	public Border setResaltarfechaCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresoBeanSwingJInternalFrame.jTtoolBarCajaIngreso.setBorder(borderResaltar);
		
		this.resaltarfechaCajaIngreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaCajaIngreso() {
		return this.resaltarfechaCajaIngreso;
	}

	public void setResaltarfechaCajaIngreso(Border borderResaltar) {
		this.resaltarfechaCajaIngreso= borderResaltar;
	}

	public Boolean getMostrarfechaCajaIngreso() {
		return this.mostrarfechaCajaIngreso;
	}

	public void setMostrarfechaCajaIngreso(Boolean mostrarfechaCajaIngreso) {
		this.mostrarfechaCajaIngreso= mostrarfechaCajaIngreso;
	}

	public Boolean getActivarfechaCajaIngreso() {
		return this.activarfechaCajaIngreso;
	}

	public void setActivarfechaCajaIngreso(Boolean activarfechaCajaIngreso) {
		this.activarfechaCajaIngreso= activarfechaCajaIngreso;
	}

	public Border setResaltarhoraCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cajaingresoBeanSwingJInternalFrame.jTtoolBarCajaIngreso.setBorder(borderResaltar);
		
		this.resaltarhoraCajaIngreso= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarhoraCajaIngreso() {
		return this.resaltarhoraCajaIngreso;
	}

	public void setResaltarhoraCajaIngreso(Border borderResaltar) {
		this.resaltarhoraCajaIngreso= borderResaltar;
	}

	public Boolean getMostrarhoraCajaIngreso() {
		return this.mostrarhoraCajaIngreso;
	}

	public void setMostrarhoraCajaIngreso(Boolean mostrarhoraCajaIngreso) {
		this.mostrarhoraCajaIngreso= mostrarhoraCajaIngreso;
	}

	public Boolean getActivarhoraCajaIngreso() {
		return this.activarhoraCajaIngreso;
	}

	public void setActivarhoraCajaIngreso(Boolean activarhoraCajaIngreso) {
		this.activarhoraCajaIngreso= activarhoraCajaIngreso;
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
		
		
		this.setMostraridCajaIngreso(esInicial);
		this.setMostrarid_empresaCajaIngreso(esInicial);
		this.setMostrarid_sucursalCajaIngreso(esInicial);
		this.setMostrarid_usuarioCajaIngreso(esInicial);
		this.setMostrarid_cajaCajaIngreso(esInicial);
		this.setMostrarid_turno_pun_venCajaIngreso(esInicial);
		this.setMostrarsecuencialCajaIngreso(esInicial);
		this.setMostrarfechaCajaIngreso(esInicial);
		this.setMostrarhoraCajaIngreso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaIngresoConstantesFunciones.ID)) {
				this.setMostraridCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDCAJA)) {
				this.setMostrarid_cajaCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDTURNOPUNVEN)) {
				this.setMostrarid_turno_pun_venCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.FECHA)) {
				this.setMostrarfechaCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.HORA)) {
				this.setMostrarhoraCajaIngreso(esAsigna);
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
		
		
		this.setActivaridCajaIngreso(esInicial);
		this.setActivarid_empresaCajaIngreso(esInicial);
		this.setActivarid_sucursalCajaIngreso(esInicial);
		this.setActivarid_usuarioCajaIngreso(esInicial);
		this.setActivarid_cajaCajaIngreso(esInicial);
		this.setActivarid_turno_pun_venCajaIngreso(esInicial);
		this.setActivarsecuencialCajaIngreso(esInicial);
		this.setActivarfechaCajaIngreso(esInicial);
		this.setActivarhoraCajaIngreso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaIngresoConstantesFunciones.ID)) {
				this.setActivaridCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDCAJA)) {
				this.setActivarid_cajaCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDTURNOPUNVEN)) {
				this.setActivarid_turno_pun_venCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.FECHA)) {
				this.setActivarfechaCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.HORA)) {
				this.setActivarhoraCajaIngreso(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCajaIngreso(esInicial);
		this.setResaltarid_empresaCajaIngreso(esInicial);
		this.setResaltarid_sucursalCajaIngreso(esInicial);
		this.setResaltarid_usuarioCajaIngreso(esInicial);
		this.setResaltarid_cajaCajaIngreso(esInicial);
		this.setResaltarid_turno_pun_venCajaIngreso(esInicial);
		this.setResaltarsecuencialCajaIngreso(esInicial);
		this.setResaltarfechaCajaIngreso(esInicial);
		this.setResaltarhoraCajaIngreso(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CajaIngresoConstantesFunciones.ID)) {
				this.setResaltaridCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDCAJA)) {
				this.setResaltarid_cajaCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.IDTURNOPUNVEN)) {
				this.setResaltarid_turno_pun_venCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.FECHA)) {
				this.setResaltarfechaCajaIngreso(esAsigna);
				continue;
			}

			if(campo.clase.equals(CajaIngresoConstantesFunciones.HORA)) {
				this.setResaltarhoraCajaIngreso(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarCajaIngresoDetalleCajaIngreso=null;

	public Border getResaltarCajaIngresoDetalleCajaIngreso() {
		return this.resaltarCajaIngresoDetalleCajaIngreso;
	}

	public void setResaltarCajaIngresoDetalleCajaIngreso(Border borderResaltarCajaIngresoDetalle) {
		if(borderResaltarCajaIngresoDetalle!=null) {
			this.resaltarCajaIngresoDetalleCajaIngreso= borderResaltarCajaIngresoDetalle;
		}
	}

	public Border setResaltarCajaIngresoDetalleCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltarCajaIngresoDetalle=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//cajaingresoBeanSwingJInternalFrame.jTtoolBarCajaIngreso.setBorder(borderResaltarCajaIngresoDetalle);
			
		this.resaltarCajaIngresoDetalleCajaIngreso= borderResaltarCajaIngresoDetalle;

		 return borderResaltarCajaIngresoDetalle;
	}



	public Boolean mostrarCajaIngresoDetalleCajaIngreso=true;

	public Boolean getMostrarCajaIngresoDetalleCajaIngreso() {
		return this.mostrarCajaIngresoDetalleCajaIngreso;
	}

	public void setMostrarCajaIngresoDetalleCajaIngreso(Boolean visibilidadResaltarCajaIngresoDetalle) {
		this.mostrarCajaIngresoDetalleCajaIngreso= visibilidadResaltarCajaIngresoDetalle;
	}



	public Boolean activarCajaIngresoDetalleCajaIngreso=true;

	public Boolean gethabilitarResaltarCajaIngresoDetalleCajaIngreso() {
		return this.activarCajaIngresoDetalleCajaIngreso;
	}

	public void setActivarCajaIngresoDetalleCajaIngreso(Boolean habilitarResaltarCajaIngresoDetalle) {
		this.activarCajaIngresoDetalleCajaIngreso= habilitarResaltarCajaIngresoDetalle;
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

		this.setMostrarCajaIngresoDetalleCajaIngreso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CajaIngresoDetalle.class)) {
				this.setMostrarCajaIngresoDetalleCajaIngreso(esAsigna);
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

		this.setActivarCajaIngresoDetalleCajaIngreso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CajaIngresoDetalle.class)) {
				this.setActivarCajaIngresoDetalleCajaIngreso(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarCajaIngresoDetalleCajaIngreso(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(CajaIngresoDetalle.class)) {
				this.setResaltarCajaIngresoDetalleCajaIngreso(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCajaCajaIngreso=true;

	public Boolean getMostrarFK_IdCajaCajaIngreso() {
		return this.mostrarFK_IdCajaCajaIngreso;
	}

	public void setMostrarFK_IdCajaCajaIngreso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCajaCajaIngreso= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaCajaIngreso=true;

	public Boolean getMostrarFK_IdEmpresaCajaIngreso() {
		return this.mostrarFK_IdEmpresaCajaIngreso;
	}

	public void setMostrarFK_IdEmpresaCajaIngreso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaCajaIngreso= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalCajaIngreso=true;

	public Boolean getMostrarFK_IdSucursalCajaIngreso() {
		return this.mostrarFK_IdSucursalCajaIngreso;
	}

	public void setMostrarFK_IdSucursalCajaIngreso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalCajaIngreso= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTurnoPunVenCajaIngreso=true;

	public Boolean getMostrarFK_IdTurnoPunVenCajaIngreso() {
		return this.mostrarFK_IdTurnoPunVenCajaIngreso;
	}

	public void setMostrarFK_IdTurnoPunVenCajaIngreso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTurnoPunVenCajaIngreso= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioCajaIngreso=true;

	public Boolean getMostrarFK_IdUsuarioCajaIngreso() {
		return this.mostrarFK_IdUsuarioCajaIngreso;
	}

	public void setMostrarFK_IdUsuarioCajaIngreso(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioCajaIngreso= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCajaCajaIngreso=true;

	public Boolean getActivarFK_IdCajaCajaIngreso() {
		return this.activarFK_IdCajaCajaIngreso;
	}

	public void setActivarFK_IdCajaCajaIngreso(Boolean habilitarResaltar) {
		this.activarFK_IdCajaCajaIngreso= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaCajaIngreso=true;

	public Boolean getActivarFK_IdEmpresaCajaIngreso() {
		return this.activarFK_IdEmpresaCajaIngreso;
	}

	public void setActivarFK_IdEmpresaCajaIngreso(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaCajaIngreso= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalCajaIngreso=true;

	public Boolean getActivarFK_IdSucursalCajaIngreso() {
		return this.activarFK_IdSucursalCajaIngreso;
	}

	public void setActivarFK_IdSucursalCajaIngreso(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalCajaIngreso= habilitarResaltar;
	}

	public Boolean activarFK_IdTurnoPunVenCajaIngreso=true;

	public Boolean getActivarFK_IdTurnoPunVenCajaIngreso() {
		return this.activarFK_IdTurnoPunVenCajaIngreso;
	}

	public void setActivarFK_IdTurnoPunVenCajaIngreso(Boolean habilitarResaltar) {
		this.activarFK_IdTurnoPunVenCajaIngreso= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioCajaIngreso=true;

	public Boolean getActivarFK_IdUsuarioCajaIngreso() {
		return this.activarFK_IdUsuarioCajaIngreso;
	}

	public void setActivarFK_IdUsuarioCajaIngreso(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioCajaIngreso= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCajaCajaIngreso=null;

	public Border getResaltarFK_IdCajaCajaIngreso() {
		return this.resaltarFK_IdCajaCajaIngreso;
	}

	public void setResaltarFK_IdCajaCajaIngreso(Border borderResaltar) {
		this.resaltarFK_IdCajaCajaIngreso= borderResaltar;
	}

	public void setResaltarFK_IdCajaCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCajaCajaIngreso= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaCajaIngreso=null;

	public Border getResaltarFK_IdEmpresaCajaIngreso() {
		return this.resaltarFK_IdEmpresaCajaIngreso;
	}

	public void setResaltarFK_IdEmpresaCajaIngreso(Border borderResaltar) {
		this.resaltarFK_IdEmpresaCajaIngreso= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaCajaIngreso= borderResaltar;
	}

	public Border resaltarFK_IdSucursalCajaIngreso=null;

	public Border getResaltarFK_IdSucursalCajaIngreso() {
		return this.resaltarFK_IdSucursalCajaIngreso;
	}

	public void setResaltarFK_IdSucursalCajaIngreso(Border borderResaltar) {
		this.resaltarFK_IdSucursalCajaIngreso= borderResaltar;
	}

	public void setResaltarFK_IdSucursalCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalCajaIngreso= borderResaltar;
	}

	public Border resaltarFK_IdTurnoPunVenCajaIngreso=null;

	public Border getResaltarFK_IdTurnoPunVenCajaIngreso() {
		return this.resaltarFK_IdTurnoPunVenCajaIngreso;
	}

	public void setResaltarFK_IdTurnoPunVenCajaIngreso(Border borderResaltar) {
		this.resaltarFK_IdTurnoPunVenCajaIngreso= borderResaltar;
	}

	public void setResaltarFK_IdTurnoPunVenCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTurnoPunVenCajaIngreso= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioCajaIngreso=null;

	public Border getResaltarFK_IdUsuarioCajaIngreso() {
		return this.resaltarFK_IdUsuarioCajaIngreso;
	}

	public void setResaltarFK_IdUsuarioCajaIngreso(Border borderResaltar) {
		this.resaltarFK_IdUsuarioCajaIngreso= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioCajaIngreso(ParametroGeneralUsuario parametroGeneralUsuario/*CajaIngresoBeanSwingJInternalFrame cajaingresoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioCajaIngreso= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}